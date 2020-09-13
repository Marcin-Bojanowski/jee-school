package pl.coderslab.controllers.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addGroup")
public class AddGroup extends HttpServlet {
    private static final GroupDao GROUP_DAO = new GroupDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Group group=new Group(request.getParameter("name"));
        GROUP_DAO.create(group);
        response.sendRedirect("/groupList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/addGroup.jsp")
                .forward(request, response);
    }
}
