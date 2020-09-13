package pl.coderslab.controllers.User;

import pl.coderslab.controllers.Exercise.ExerciseDao;
import pl.coderslab.controllers.Solution.SolutionsDao;
import pl.coderslab.controllers.Exercise.Exercise;
import pl.coderslab.controllers.Solution.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userDetails")
public class UserDetails extends HttpServlet {
    private static final UserDao USER_DAO = new UserDao();
    private static final SolutionsDao SOLUTION_DAO = new SolutionsDao();
    private static final ExerciseDao EXERCISE_DAO = new ExerciseDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Solution[] solutions = SOLUTION_DAO.findAll(id);
        Exercise[] exercise = new Exercise[solutions.length];
        for (int i = 0; i < solutions.length; i++) {
            exercise[i] = EXERCISE_DAO.readById(solutions[i].getExerciseId());
        }
        request.setAttribute("userDetails", USER_DAO.readById(id));
        request.setAttribute("userSolutions", SOLUTION_DAO.findAll(id));
        request.setAttribute("userExercises", exercise);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/userDetails.jsp")
                .forward(request, response);
    }
}
