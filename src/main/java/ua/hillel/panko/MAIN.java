package ua.hillel.panko;

import ua.hillel.panko.dao.UserDao;
import ua.hillel.panko.entity.Post;
import ua.hillel.panko.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MAIN
{
  public static void main(String[] args)
  {
    UserDao userDao = new UserDao();

    int userId = 3;

    User user = new User();
    user.setLogin("my-login-" + userId);
    user.setPassword("my-password-" + userId);
    user.setRegistrationDate(new Date());

    List<Post> posts = new ArrayList<>();

    for (int i = 1; i <= 3; i++)
    {
      Post post = new Post();
      post.setAuthor(user);
      post.setDateCreated(new Date());
      post.setText(String.format("Post %d message of user %d", i, userId));
      posts.add(post);
    }

    user.setPosts(posts);

    System.out.println("Saving user  : " + user);
    userDao.save(user);
    System.out.println("User is saved: " + user);

    List<User> users = userDao.loadAll();
    for (User u : users)
    {
      System.out.println("User from DB: " + u);
    }
  }
}
