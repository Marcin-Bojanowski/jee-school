package pl.coderslab.controllers.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class Users extends HttpServlet {
    private static final UserDao USER_DAO = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        request.setAttribute("users",USER_DAO.findByGroup(id));
        getServletContext()
                .getRequestDispatcher("/WEB-INF/users.jsp")
                .forward(request, response);
    }
}
