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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userPanel")
public class UserPanel extends HttpServlet {
    private static final UserDao USER_DAO = new UserDao();
    private static final SolutionsDao SOLUTION_DAO=new SolutionsDao();
    private static final ExerciseDao EXERCISE_DAO=new ExerciseDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (USER_DAO.authorization(email,password)){
            HttpSession session = request.getSession();
            session.setAttribute("user", USER_DAO.read(email,password));

        }
        response.sendRedirect("/userPanel");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user")!=null){
            Solution[] doneSolutions = SOLUTION_DAO.findAllDone((User) session.getAttribute("user"));
            Exercise[] doneExercise = new Exercise[doneSolutions.length];
            for (int i = 0; i < doneSolutions.length; i++) {
                doneExercise[i] = EXERCISE_DAO.readById(doneSolutions[i].getExerciseId());
            }
            request.setAttribute("doneSolutions", doneSolutions);
            request.setAttribute("doneExercises", doneExercise);
            Solution[] notDoneSolutions = SOLUTION_DAO.findAllNotDone((User) session.getAttribute("user"));
            Exercise[] notDoneExercise = new Exercise[notDoneSolutions.length];
            for (int i = 0; i < notDoneSolutions.length; i++) {
                notDoneExercise[i] = EXERCISE_DAO.readById(notDoneSolutions[i].getExerciseId());
            }
            request.setAttribute("notDoneSolutions", notDoneSolutions);
            request.setAttribute("notDoneExercises", notDoneExercise);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/userPanel.jsp")
                    .forward(request, response);
        } else {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }

    }
}
