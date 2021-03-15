package app.servlets;

import app.db.UserBankListDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class WholeSumAndTheRichestServlet extends HttpServlet {

    private final static String TASK1_8 = "/task1_8.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(TASK1_8).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if(req.getParameter("button1") != null) req.setAttribute("text1", UserBankListDB.getTheRichest());
            if(req.getParameter("button2") != null) req.setAttribute("text2", UserBankListDB.getWholeSum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }
}
