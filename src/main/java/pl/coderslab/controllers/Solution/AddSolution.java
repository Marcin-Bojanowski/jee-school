package pl.coderslab.controllers.Solution;

import pl.coderslab.controllers.Exercise.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet("/addSolution")
public class AddSolution extends HttpServlet {
    private final static ExerciseDao EXERCISE_DAO=new ExerciseDao();
    private final static SolutionsDao SOLUTIONS_DAO=new SolutionsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user")!=null){
            int solutionId= (int) session.getAttribute("solutionId");
            Solution solution= SOLUTIONS_DAO.readById(solutionId);
            solution.setUpdated(Timestamp.valueOf(LocalDateTime.now()));
            solution.setDescription(request.getParameter("description"));
            SOLUTIONS_DAO.update(solution);
            response.sendRedirect("/userPanel");
        } else {
            response.sendRedirect("/");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user")!=null){
            int solutionId=Integer.parseInt(request.getParameter("id"));
            session.setAttribute("solutionId",solutionId);
            request.setAttribute("exercise",EXERCISE_DAO.readById(SOLUTIONS_DAO.readById(solutionId).getExerciseId()));
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/addSolution.jsp")
                    .forward(request, response);
        } else {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/index.jsp")
                    .forward(request, response);
        }
    }
}
