package app.servlets;

import app.db.UserBankListDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SpecifiedUserAndAllAccountsServlet extends HttpServlet {

    private final static String TASK1_6 = "/task1_6.jsp";

    private String user = "";
    private List<String> accounts;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("getAccounts") != null) {
            try {
                accounts = UserBankListDB.getAllAccount();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("accounts", accounts);
        }
        req.getRequestDispatcher(TASK1_6).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            user = UserBankListDB.getUser(Integer.parseInt(req.getParameter("id")));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            req.setAttribute("emptyStr", true);
        }
        req.setAttribute("user", user);
        req.setAttribute("id", req.getParameter("id"));

        doGet(req, resp);
    }
}
