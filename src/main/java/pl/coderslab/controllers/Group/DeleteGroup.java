package pl.coderslab.controllers.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteGroup")
public class DeleteGroup extends HttpServlet {
    private static final GroupDao GROUP_DAO = new GroupDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Group group = GROUP_DAO.readById(Integer.parseInt(request.getParameter("id")));
        GROUP_DAO.delete(group);
        response.sendRedirect("/groupList");
    }
}
