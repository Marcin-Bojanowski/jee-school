package pl.coderslab.controllers.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editExercise")
public class EditExercise extends HttpServlet {
    private static final ExerciseDao EXERCISE_DAO = new ExerciseDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exercise exercise = new Exercise();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {

            for (Cookie cookie : cookies) {
                if ("exerciseId".equals(cookie.getName())) {
                    exercise = EXERCISE_DAO.readById(Integer.parseInt(cookie.getValue()));

                }
            }
        }
        String title = request.getParameter("title");
        if (!"".equals(title)) {
            exercise.setTitle(title);
        }
        String description = request.getParameter("description");
        if (!"".equals(description)) {
            exercise.setDescription(description);
        }
        EXERCISE_DAO.update(exercise);
        response.sendRedirect("/exerciseList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("exerciseId", request.getParameter("id"));
        response.addCookie(cookie);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/editExercise.jsp")
                .forward(request, response);
    }
}
