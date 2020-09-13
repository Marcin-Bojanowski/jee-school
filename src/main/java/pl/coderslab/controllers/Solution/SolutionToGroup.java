package pl.coderslab.controllers.Solution;

import pl.coderslab.controllers.Group.GroupDao;
import pl.coderslab.controllers.User.UserDao;
import pl.coderslab.controllers.Group.Group;
import pl.coderslab.controllers.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solutionToGroup")
public class SolutionToGroup extends HttpServlet {
    private static final GroupDao GROUP_DAO=new GroupDao();
    private static final SolutionsDao SOLUTIONS_DAO=new SolutionsDao();
    private static final UserDao USER_DAO=new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] groupId = request.getParameterValues("id");

        Cookie[] cookies = request.getCookies();
        Solution solution;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("exerciseId".equals(cookie.getName())) {
                    for (String id : groupId) {
                        User [] users=USER_DAO.findByGroup(Integer.parseInt(id));
                        for (User user:users){
                            solution = new Solution(Integer.parseInt(cookie.getValue()), user.getId());
                            SOLUTIONS_DAO.create(solution);
                        }

                    }

                }
            }
        }

        response.sendRedirect("/exerciseList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("exerciseId", request.getParameter("id"));
        response.addCookie(cookie);
        Group[] groups = GROUP_DAO.findAll();
        request.setAttribute("groupList", groups);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/solutionToGroup.jsp")
                .forward(request, response);
    }
}
