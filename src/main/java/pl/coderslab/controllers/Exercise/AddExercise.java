package pl.coderslab.controllers.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addExercise")
public class AddExercise extends HttpServlet {
    private static final ExerciseDao EXERCISE_DAO = new ExerciseDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Exercise exercise = new Exercise(title, description);
        EXERCISE_DAO.create(exercise);
        response.sendRedirect("/exerciseList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/addExercise.jsp")
                .forward(request, response);
    }
}
