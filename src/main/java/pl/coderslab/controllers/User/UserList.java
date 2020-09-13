package pl.coderslab.controllers.User;

import pl.coderslab.controllers.Group.GroupDao;
import pl.coderslab.controllers.Group.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userList")
public class UserList extends HttpServlet {
    private static final UserDao USER_DAO = new UserDao();
    private static final GroupDao GROUP_DAO = new GroupDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User[] user = USER_DAO.findAll();
        Group[] group = new Group[user.length];
        for (int i = 0; i < user.length; i++) {
            group[i] = GROUP_DAO.readById(user[i].getGroupId());
        }
        request.setAttribute("userList", user);
        request.setAttribute("group", group);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/userList.jsp")
                .forward(request, response);
    }
}
