package pl.coderslab.controllers.Solution;

import pl.coderslab.controllers.User.UserDao;
import pl.coderslab.controllers.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solutionToUser")
public class SolutionToUser extends HttpServlet {
    private static final UserDao USER_DAO = new UserDao();
    private static final SolutionsDao SOLUTIONS_DAO = new SolutionsDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] userId = request.getParameterValues("id");
        Cookie[] cookies = request.getCookies();
        Solution solution;
        if (cookies != null) {

            for (Cookie cookie : cookies) {
                if ("exerciseId".equals(cookie.getName())) {
                    for (String id : userId) {
                        solution = new Solution(Integer.parseInt(cookie.getValue()), Integer.parseInt(id));
                        SOLUTIONS_DAO.create(solution);
                    }

                }
            }
        }

        response.sendRedirect("/exerciseList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("exerciseId", request.getParameter("id"));
        response.addCookie(cookie);
        User[] user = USER_DAO.findAll();
        request.setAttribute("userList", user);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/solutionToUser.jsp")
                .forward(request, response);
    }
}
