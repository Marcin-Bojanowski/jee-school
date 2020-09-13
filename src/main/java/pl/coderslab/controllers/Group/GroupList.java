package pl.coderslab.controllers.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupList")
public class GroupList extends HttpServlet {
    private static final GroupDao GROUP_DAO = new GroupDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("groupList", GROUP_DAO.findAll());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/groupList.jsp")
                .forward(request, response);
    }
}
