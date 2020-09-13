package pl.coderslab.controllers.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editGroup")
public class EditGroup extends HttpServlet {
    private static final GroupDao GROUP_DAO = new GroupDao();
    Group group = new Group();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        group.setName(request.getParameter("name"));
        GROUP_DAO.update(group);
        response.sendRedirect("/groupList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        group = GROUP_DAO.readById(Integer.parseInt(request.getParameter("id")));
        getServletContext()
                .getRequestDispatcher("/WEB-INF/editGroup.jsp")
                .forward(request, response);
    }
}
