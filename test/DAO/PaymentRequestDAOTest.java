/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import static dao.PaymentRequestDAO.insertPaymentRequest;
import java.util.ArrayList;
import model.PaymentRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tayho
 */
public class PaymentRequestDAOTest {
    
    public PaymentRequestDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertPaymentRequest method, of class PaymentRequestDAO.
     */
    @Test
    public void testInsertPaymentRequest() {
        // Create a PaymentRequest object for testing
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setUser_id(1);
        paymentRequest.setMoney(100.0);
        paymentRequest.setDate("2023-06-30");
        paymentRequest.setImg("payment.png");
        
        // Call the insertPaymentRequest method and get the result
        String result = insertPaymentRequest(paymentRequest);
        
        // Verify the result
        Assert.assertNotNull(result);
        Assert.assertNotEquals("0", result);
    }

    /**
     * Test of getAllPaymentRequest method, of class PaymentRequestDAO.
     */
    @Test
    public void testGetAllPaymentRequest() {
        // Call the method to get the list of payment requests
       ArrayList<PaymentRequest> paymentRequestList = null;

        // Perform assertions to check if the list is not null and has some elements
        assertNotNull(paymentRequestList);
        assertTrue(paymentRequestList.size() > 0);

        // Add more specific assertions as needed for the test
        // For example, you can check the attributes of the PaymentRequest objects in the list
        for (PaymentRequest request : paymentRequestList) {
            assertNotNull(request.getId());
            assertNotNull(request.getUser_id());
            assertNotNull(request.getMoney());
            assertNotNull(request.getDate());
            assertNotNull(request.getImg());
        }
    }

    /**
     * Test of getPaymentRequest method, of class PaymentRequestDAO.
     */
    @Test
    public void testGetPaymentRequest() {
        // Assuming you have a known existing id in your database, change '1' to a valid id for a payment request
        int paymentRequestId = 1;

        // Call the method to get the payment request for the given id
        PaymentRequest paymentRequest = null;

        // Perform assertions to check if the paymentRequest is not null
        assertNotNull(paymentRequest);

        // Add more specific assertions as needed for the test
        // For example, you can check the attributes of the PaymentRequest object
        assertEquals(paymentRequestId, paymentRequest.getId());
        assertNotNull(paymentRequest.getUser_id());
        assertNotNull(paymentRequest.getMoney());
        assertNotNull(paymentRequest.getDate());
        assertNotNull(paymentRequest.getImg());
    }

    /**
     * Test of deletePaymentRequest method, of class PaymentRequestDAO.
     */
    @Test
    public void testDeleteNonExistingPaymentRequest() {
        // Assuming you have an invalid id that doesn't exist in the database
        int nonExistingPaymentRequestId = -1;

        // Call the method to delete the non-existing payment request for the given id
        paymentRequestService.deletePaymentRequest(nonExistingPaymentRequestId);

        // It should not raise any exceptions or errors, and the method should execute without any issues.
        // You can also add assertions to check for logs, etc., depending on your implementation.
    }

    // Helper method to check if a payment request exists in the database
    private boolean isPaymentRequestExists(int paymentRequestId) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            String sql = "SELECT * FROM PaymentRequest WHERE id = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, paymentRequestId);
            ResultSet rs = preparedStatement.executeQuery();
            boolean exists = rs.next();
            con.close();
            return exists;
        } catch (SQLException e) {
            System.out.println("Error checking payment request existence: " + e.getMessage());
            return false;
        }
    }
    
}
