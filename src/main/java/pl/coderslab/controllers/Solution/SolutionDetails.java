package pl.coderslab.controllers.Solution;

import pl.coderslab.controllers.Exercise.ExerciseDao;
import pl.coderslab.controllers.User.UserDao;
import pl.coderslab.controllers.Exercise.Exercise;
import pl.coderslab.controllers.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details")
public class SolutionDetails extends HttpServlet {
    private static final SolutionsDao SOLUTION_DAO = new SolutionsDao();
    private static final UserDao USER_DAO = new UserDao();
    private static final ExerciseDao EXERCISE_DAO = new ExerciseDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        Solution solution=SOLUTION_DAO.readById(id);
        User user=USER_DAO.readById(solution.getUserId());
        Exercise exercise=EXERCISE_DAO.readById(solution.getExerciseId());
        request.setAttribute("solutions", solution);
        request.setAttribute("users",user);
        request.setAttribute("exercise",exercise);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/solutionDetails.jsp")
                .forward(request, response);
    }
}
