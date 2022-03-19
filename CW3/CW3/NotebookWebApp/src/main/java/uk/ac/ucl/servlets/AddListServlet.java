package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addList.html")
public class AddListServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String newType = request.getParameter("newType");
        String newValue = request.getParameter("newString");
        Model model = ModelFactory.getModel();
        model.addList(newType, newValue);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/index.html");
        dispatch.forward(request, response);
    }
}
