package pl.coderslab.controllers.User;

import pl.coderslab.controllers.Group.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/addUser")
public class AddUser extends HttpServlet {
    private static final GroupDao GROUP_DAO=new GroupDao();
    private static final UserDao USER_DAO=new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int group =Integer.parseInt(request.getParameter("group"));
        User user=new User(name,email,password,group);
        USER_DAO.create(user);
        response.sendRedirect("/userList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("group",GROUP_DAO.findAll());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/addUser.jsp")
                .forward(request, response);
    }
}
