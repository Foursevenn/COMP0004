package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListFolder;
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

@WebServlet("/listFolder.html")
public class ViewListFolderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        ListFolder listFolder = model.getTopics();
        request.setAttribute("listFolder", listFolder);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/listFolder.jsp");
        dispatch.forward(request, response);
    }
}