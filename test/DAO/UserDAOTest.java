package DAO;

import Context.DBContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.User;
import dao.UserDAO;
import java.sql.PreparedStatement;
import java.sql.Statement;
import static org.junit.Assert.*;

/**
 *
 * @author VICTUS
 */
public class UserDAOTest {

    DBContext db;
    Connection con;
    Logger logger;

    @Before
    public void setUpDatabase() {
        db = new DBContext();
        con = db.getConnection();
    }

    @Before
    public void instanitiateLogger() {
        logger = Logger.getLogger(getClass().getName());
    }

    @After
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Close connection failed");
        }
    }

    public void insertUser(User user) {
        try {
            String sql = "INSERT INTO game_items_trading_test.useraccount (id,username, password, dob,"
                    + "email, gender, avatar, role_id, money_amount)"
                    + "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, user.getId());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.setString(4, user.getDob());
            st.setString(5, user.getEmail());
            st.setString(6, user.getGender());
            st.setString(7, user.getAvatar());
            st.setInt(8, user.getRoleid());
            st.setDouble(9, user.getMoney());
            st.executeUpdate();
            st.close();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    public void rollBackInsert(int id) {
        try {
            String sql = "delete FROM game_items_trading_test.useraccount where id = " + id;
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

    @Test
    public void GetUserInformation_Valid() {
        User expected = new User(99, "user", "pass", "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        insertUser(expected);
        User actual = UserDAO.GetUserInformation(expected.getId());
        rollBackInsert(expected.getId());
        assertEquals(expected, actual);
    }

    @Test
    public void GetUserInformation_NonExistId() {
        User actual = UserDAO.GetUserInformation(10);
        assertEquals(null, actual);
    }

    @Test
    public void GetUserInformation_NegativeId() {
        User actual = UserDAO.GetUserInformation(-1);
        assertEquals(null, actual);
    }

    @Test
    public void FindUsername_Valid() {
        User user = new User(99, "user", "pass", "2001-12-03", "user@domain.com", "Male", "user.jpg", 1, 10);
        insertUser(user);
        String name = user.getUsername();
        boolean actual = UserDAO.FindUserName(name);
        rollBackInsert(user.getId());
        assertTrue(actual);
    }

    @Test
    public void FindUsername_NonExistUsername() {
        String nonexist = "nonexistusername";
        boolean actual = UserDAO.FindUserName(nonexist);
        assertFalse(actual);
    }
    
    //Test Find user name with null input
    @Test
    public void FindUsername_NullInput() {
        boolean expected = false;
        boolean actual = UserDAO.FindUserName(null);
        assertEquals(expected, actual);
    }

    //Test login with valid username and password
    @Test
    public void LogIn_Valid() {
        User user = new User(99, "user", "pass", "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        insertUser(user);
        User actual = UserDAO.LogIn("user", "pass");
        rollBackInsert(user.getId());
        assertTrue(user.equals(actual));
    }
    
    @Test
    public void LogIn_Invalid() {
        User actual = UserDAO.LogIn("wrongusername", "wrongpassword");
        assertEquals(null, actual);
    }

    @Test
    public void LogIn_NullUsername() {
        User user = new User(99, "null", "pass", "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        insertUser(user);
        User actual = UserDAO.LogIn(null, "pass");
        rollBackInsert(user.getId());
        assertEquals(null, actual);
    }

    @Test
    public void LogIn_NullPassword() {
        User user = new User(99, "user", "null", "2001-12-03", "", "", "", 1, 10);
        insertUser(user);
        User actual = UserDAO.LogIn("user", null);
        rollBackInsert(user.getId());
        assertEquals(null, actual);
    }

    @Test
    public void InsertUser_Valid() {
        User user = new User(99, "user", "pass", "2001-12-03", "user@domain.com", "Male", "user.jpg", 1, 10);
        boolean expected = true;
        boolean actual = UserDAO.insertUser(user);
        rollBackInsert(user.getId());
        assertEquals(expected, actual);
    }

    @Test
    public void InsertUser_NullUser() {
        boolean expected = false;
        boolean actual = UserDAO.insertUser(null);
        assertEquals(expected, actual);
    }

    @Test
    public void InsertUser_EmptyUsername() {
        User user = new User(99, "", "pass", "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        boolean expected = false;
        boolean actual = UserDAO.insertUser(user);
        assertEquals(expected, actual);
    }

    @Test
    public void InsertUser_EmptyPassword() {
        User user = new User(99, "user", "", "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        boolean expected = false;
        boolean actual = UserDAO.insertUser(user);
        assertEquals(expected, actual);
    }

    @Test
    public void InsertUser_NullUsername() {
        User user = new User(99, null, "pass", "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        boolean expected = false;
        boolean actual = UserDAO.insertUser(user);
        assertEquals(expected, actual);
    }

    @Test
    public void InsertUser_NullPassword() {
        User user = new User(99, "user", null, "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        boolean expected = false;
        boolean actual = UserDAO.insertUser(user);
        assertEquals(expected, actual);
    }

    @Test
    public void editUserProfile_Valid() {
        User insert = new User(99, "user", "pass", "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        User expected = new User(99, "user", "pass", "2001-12-03", "newuser@domain.com", "Male", "userprofile.jpg", 1, 10);
        boolean expectreturn = true;
        insertUser(insert);
        boolean actualreturn = UserDAO.editUserProfile(expected);
        rollBackInsert(insert.getId());
        assertEquals(expectreturn, actualreturn);
    }

    @Test
    public void editUserProfile_NullUser() {
        boolean expected = false;
        boolean actual = UserDAO.editUserProfile(null);
        assertEquals(expected, actual);
    }

    @Test
    public void editUserProfile_NonExistUser() {
        User nonexist = new User(10, "name", "pass", "2003-12-03", "a", "b", "c", 1, 10);
        boolean expected = false;
        boolean actual = UserDAO.editUserProfile(nonexist);
        assertEquals(expected, actual);
    }

    @Test
    public void ChangePassword_Valid() {
        boolean expected = true;
        boolean actual = UserDAO.ChangePassword(1, "pass");
        assertEquals(expected, actual);
    }

    @Test
    public void ChangePassword_NonExistUser() {
        boolean expected = false;
        boolean actual = UserDAO.ChangePassword(10, "pass");
        assertEquals(expected, actual);
    }

    @Test
    public void ChangePassword_NullPassword() {
        boolean expected = false;
        boolean actual = UserDAO.ChangePassword(1, null);
        assertEquals(expected, actual);
    }

    @Test
    public void ChangePassword_EmptyPass() {
        boolean expected = false;
        boolean actual = UserDAO.ChangePassword(1, "");
        assertEquals(expected, actual);
    }

    @Test
    public void updateUserMoney_Valid() {
        boolean expected = true;
        boolean actual = UserDAO.updateUserMoney(1, 3000);
        assertEquals(expected, actual);
    }

    @Test
    public void updateUserMoney_NegativeAmount() {
        boolean expected = false;
        boolean actual = UserDAO.updateUserMoney(1, -1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void updateUserMoney_NonexistUser() {
        boolean expected = false;
        boolean actual = UserDAO.updateUserMoney(10, 3000);
        assertEquals(expected, actual);
    }

    @Test
    public void getUserByUsername_Valid() {
        User expected = new User(99, "user", "pass", "2001-12-03", "", "", "", 1, 10);
        insertUser(expected);
        User actual = UserDAO.getUserByUsername(expected.getUsername());
        rollBackInsert(expected.getId());
        assertTrue(expected.equals(actual));
    }

    @Test
    public void getUserByUserName_NonexistUsername() {
        User expected = null;
        User actual = UserDAO.getUserByUsername("nonexistusername");
        assertEquals(expected, actual);
    }

    @Test
    public void getUserByUsername_NullInput() {
        User expected = null;
        User actual = UserDAO.getUserByUsername(null);
        assertEquals(expected, actual);
    }
}
