package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.VideoFolder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/videoFolder.html")
public class ViewVideoFolderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        VideoFolder videoFolder = model.getVideoFolder();
        request.setAttribute("videoFolder", videoFolder);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/videoFolder.jsp");
        dispatch.forward(request, response);
    }
}
