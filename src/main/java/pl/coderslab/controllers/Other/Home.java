package pl.coderslab.controllers.Other;

import pl.coderslab.controllers.Exercise.ExerciseDao;
import pl.coderslab.controllers.Solution.SolutionsDao;
import pl.coderslab.controllers.User.UserDao;
import pl.coderslab.controllers.Exercise.Exercise;
import pl.coderslab.controllers.Solution.Solution;
import pl.coderslab.controllers.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class Home extends HttpServlet {
    private static final SolutionsDao SOLUTION_DAO = new SolutionsDao();
    private static final UserDao USER_DAO = new UserDao();
    private static final ExerciseDao EXERCISE_DAO = new ExerciseDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numberSolutions= Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
        Solution [] recentSolutions=SOLUTION_DAO.findRecent(numberSolutions);
        User [] users=new User[recentSolutions.length];
        Exercise[] exercise=new Exercise[recentSolutions.length];
        for (int i=0; i<recentSolutions.length; i++){
            users[i]=USER_DAO.readById(recentSolutions[i].getUserId());
            exercise[i]=EXERCISE_DAO.readById(recentSolutions[i].getExerciseId());
        }
        request.setAttribute("recentSolutions", recentSolutions);
        request.setAttribute("users",users);
        request.setAttribute("exercise",exercise);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(request, response);
    }
}
