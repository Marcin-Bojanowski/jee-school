package pl.coderslab.controllers.Other;

import pl.coderslab.controllers.Exercise.ExerciseDao;
import pl.coderslab.controllers.User.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/panelAdmin")
public class PanelAdmin extends HttpServlet {
    private static final UserDao USER_DAO = new UserDao();
    private static final ExerciseDao EXERCISE_DAO = new ExerciseDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("exerciseList", EXERCISE_DAO.findAll());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/panelAdmin.jsp")
                .forward(request, response);
    }
}
