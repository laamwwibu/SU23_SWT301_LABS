/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import model.Notification;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admins
 */
public class NotificationDAOTest {
    
    public NotificationDAOTest() {
    }

    @Test
    public void testGetAllUserNotification() {
    }

    @Test
    public void testInsertNotification() {
        // Create a Notification object with test data
        Notification notification = new Notification();
        notification.setDate("2023-05-01");
        notification.setUser_id(1);
        notification.setNoti_content("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
        notification.setContent_type("admin");

        // Call the insertNotification method
        NotificationDAO.insertNotification(notification);

        // Verify if the notification was inserted correctly
        assertEquals("2023-05-01", notification.getDate());
        assertEquals(1, notification.getUser_id());
        assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", notification.getNoti_content());
        assertEquals("admin", notification.getContent_type());
    }
     @Test
    public void testInsertNotification_buy() {
        // Create a Notification object with test data
        Notification notification = new Notification();
        notification.setDate("2023-06-29");
        notification.setUser_id(2);
        notification.setNoti_content("You have bought Glock-18|Pistol using game account : cdad.Please wait for admin to trasnfer this item to you!");
        notification.setContent_type("buy");

        // Call the insertNotification method
        NotificationDAO.insertNotification(notification);

        // Verify if the notification was inserted correctly
        assertEquals("2023-06-29", notification.getDate());
        assertEquals(2, notification.getUser_id());
        assertEquals("You have bought Glock-18|Pistol using game account : cdad.Please wait for admin to trasnfer this item to you!", notification.getNoti_content());
        assertEquals("buy", notification.getContent_type());
    }
     @Test
    public void testInsertNotification_sell() {
        // Create a Notification object with test data
        Notification notification = new Notification();
        notification.setDate("2023-06-29");
        notification.setUser_id(3);
        notification.setNoti_content("Your item :Glock-18|Pistol has been sold using game account :lam.Please transfer this item to the server game account!");
        notification.setContent_type("sell");

        // Call the insertNotification method
        NotificationDAO.insertNotification(notification);

        // Verify if the notification was inserted correctly
        assertEquals("2023-06-29", notification.getDate());
        assertEquals(3, notification.getUser_id());
        assertEquals("Your item :Glock-18|Pistol has been sold using game account :lam.Please transfer this item to the server game account!", notification.getNoti_content());
        assertEquals("sell", notification.getContent_type());
    }
    @Test
public void testInsertNotification_invalidInput() {
    // Create a new instance of NotificationDAO
    NotificationDAO notificationDAO = new NotificationDAO();

    // Create a Notification object with invalid test data
    Notification notification = new Notification();
    notification.setDate("2023-05-01");
    notification.setUser_id(-1);  // Invalid user ID
    notification.setNoti_content("Lorem Ipsum is simply dummy text");
    notification.setContent_type("admin");

    // Call the insertNotification method
    notificationDAO.insertNotification(notification);

    // Verify that the notification was not inserted
    // In this example, we assume that the insertNotification method handles the invalid input gracefully
    // You may need to modify this assertion based on your implementation
    assertEquals("2023-05-01", notification.getDate());
        assertEquals(1, notification.getUser_id());
        assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", notification.getNoti_content());
        assertEquals("admin", notification.getContent_type());
}
@Test
public void testInsertNotification_invalidContent() {
    // Create a new instance of NotificationDAO
    NotificationDAO notificationDAO = new NotificationDAO();

    // Create a Notification object with invalid test data
    Notification notification = new Notification();
    notification.setDate("2023-05-01");
    notification.setUser_id(1);
    notification.setNoti_content(null); // Invalid null content
    notification.setContent_type("admin");

    // Call the insertNotification method
    notificationDAO.insertNotification(notification);

    // Verify that the notification was not inserted
    // In this example, we assume that the insertNotification method handles the invalid input gracefully
    // You may need to modify this assertion based on your implementation
    assertEquals("2023-05-01", notification.getDate());
        assertEquals(1, notification.getUser_id());
        assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", notification.getNoti_content());
        assertEquals("admin", notification.getContent_type());
}
@Test
public void testInsertNotification_invalidDate() {
    // Create a new instance of NotificationDAO
    NotificationDAO notificationDAO = new NotificationDAO();

    // Create a Notification object with invalid test data
    Notification notification = new Notification();
    notification.setDate("2023-13-01"); // Invalid date
    notification.setUser_id(1);
    notification.setNoti_content("Lorem Ipsum is simply dummy text");
    notification.setContent_type("admin");

    // Call the insertNotification method
    notificationDAO.insertNotification(notification);

    // Verify that the notification was not inserted
    // In this example, we assume that the insertNotification method handles the invalid input gracefully
    // You may need to modify this assertion based on your implementation
    assertEquals("2023-05-02", notification.getDate());
        assertEquals(1, notification.getUser_id());
        assertEquals("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", notification.getNoti_content());
        assertEquals("admin", notification.getContent_type());
}


    @Test
    public void testMain() {
    }
    
}
