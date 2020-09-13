package pl.coderslab.controllers.User;

import pl.coderslab.controllers.Group.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editUser")
public class EditUser extends HttpServlet {
    private static final GroupDao GROUP_DAO = new GroupDao();
    private static final UserDao USER_DAO = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {

            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    user = USER_DAO.readById(Integer.parseInt(cookie.getValue()));

                }
            }
        }
        String name = request.getParameter("name");
        if (!"".equals(name)) {
            user.setName(name);
        }
        String email = request.getParameter("email");
        if (!"".equals(email)) {
            user.setEmail(email);
        }
        String password = request.getParameter("password");
        if (!"".equals(password)) {
            user.setPassword(password);
        }
       String group= request.getParameter("group");
        if (!"".equals(group)) {
            int groupId = Integer.parseInt(group);
            user.setGroupId(groupId);
        }
        USER_DAO.update(user);
        response.sendRedirect("/userList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("group", GROUP_DAO.findAll());
        Cookie cookie = new Cookie("userId", request.getParameter("id"));
        response.addCookie(cookie);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/editUser.jsp")
                .forward(request, response);
    }
}
