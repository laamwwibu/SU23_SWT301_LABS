package dao;

import org.junit.Test;
import static org.junit.Assert.*;
import model.Role;
import java.util.ArrayList;

public class RoleDAOTest {

   @Test
    public void testGetRoleListForAdminRole() {
        // Create a new instance of RoleDAO
        RoleDAO roleDAO = new RoleDAO();

        // Define the expected admin role
        Role expectedAdminRole = new Role();
        expectedAdminRole.setRole(2);
        expectedAdminRole.setRole_name("admin");

        // Call the getRoleList() method to get the actual results
        ArrayList<Role> actualList = roleDAO.getRoleList();

        // Assert that the actual list contains the expected admin role
        boolean isAdminRolePresent = false;
        for (Role role : actualList) {
            if (role.getRole() == expectedAdminRole.getRole()
                    && role.getRole_name().equals(expectedAdminRole.getRole_name())) {
                isAdminRolePresent = true;
                break;
            }
        }
        assertTrue(isAdminRolePresent);
    }

     @Test
    public void testGetRoleListForUserRole() {
        // Create a new instance of RoleDAO
        RoleDAO roleDAO = new RoleDAO();

        // Define the expected user role
        Role expectedUserRole = new Role();
        expectedUserRole.setRole(1);
        expectedUserRole.setRole_name("user");

        // Call the getRoleList() method to get the actual results
        ArrayList<Role> actualList = roleDAO.getRoleList();

        // Assert that the actual list contains the expected user role
        boolean isUserRolePresent = false;
        for (Role role : actualList) {
            if (role.getRole() == expectedUserRole.getRole()
                    && role.getRole_name().equals(expectedUserRole.getRole_name())) {
                isUserRolePresent = true;
                break;
            }
        }
        assertTrue(isUserRolePresent);
    }
}




