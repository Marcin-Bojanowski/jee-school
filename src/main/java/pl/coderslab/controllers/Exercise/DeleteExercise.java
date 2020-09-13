package pl.coderslab.controllers.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteExercise")
public class DeleteExercise extends HttpServlet {
    private static final ExerciseDao EXERCISE_DAO=new ExerciseDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EXERCISE_DAO.delete(EXERCISE_DAO.readById(Integer.parseInt(request.getParameter("id"))));
        response.sendRedirect("/userList");
    }
}
