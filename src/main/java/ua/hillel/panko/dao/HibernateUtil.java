package ua.hillel.panko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ua.hillel.panko.entity.Post;
import ua.hillel.panko.entity.User;

public class HibernateUtil
{
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory()
  {
    if(sessionFactory == null)
    {
      try
      {
        Configuration configuration = new Configuration().configure();

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Post.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties());

        sessionFactory = configuration.buildSessionFactory(builder.build());
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return sessionFactory;
  }
}
