package controller;

import dao.MarketItemsDAO;
import dao.ProcessItemsDAO;
import dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MarketItems;
import model.ProcessItem;
import model.User;

@WebServlet(name = "ProcessItemController", urlPatterns = {"/ProcessItemController"})
public class ProcessItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Users are not allowed to access this servlet through the doGet method
        request.getRequestDispatcher("BuyPageController").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            User userForTransaction;
            String rawProcessItemId = request.getParameter("processItemId");
            ProcessItem processItem;
            String decision = request.getParameter("decision");
            String redirect = "InsertProcessNotificationController";
            int processItemId;
            double newMoneyAmount = 0;
            if (user == null) {
                redirect = "BuyPageController";
            } else if (user.getRoleid() != 2) {
                redirect = "BuyPageController";
            } else if (rawProcessItemId == null || decision == null) {
                redirect = "BuyPageController";
            } else {
                //Get payment request information by payment request id
                processItemId = Integer.parseInt(rawProcessItemId);
                processItem = ProcessItemsDAO.getProcessItems(processItemId);
                processItem.setObject(MarketItemsDAO.getMarketItem(processItem.getTransactionId()));
                ProcessItemsDAO.deleteProcessItems(processItemId);
                MarketItemsDAO.deletelMarketItem(processItem.getTransactionId());

                // If payment request is accepted add funds to user account
                if (decision.equals("accept")) {
                    userForTransaction = UserDAO.GetUserInformation(processItem.getSenderId());
                    newMoneyAmount = userForTransaction.getMoney() + ((MarketItems) processItem.getObject()).getPrice();
                    UserDAO.updateUserMoney(processItem.getSenderId(), newMoneyAmount);
                } else {
                    userForTransaction = UserDAO.GetUserInformation(processItem.getReceiverId());
                    newMoneyAmount = userForTransaction.getMoney() + ((MarketItems) processItem.getObject()).getPrice();
                    UserDAO.updateUserMoney(processItem.getReceiverId(), newMoneyAmount);
                }
                request.setAttribute("processItem", processItem);
            }
            request.getRequestDispatcher(redirect).forward(request, response);
        } catch (Exception e) {
            System.out.println("Error in ProcessItemController");
            System.out.println(e);
        }
    }
}
