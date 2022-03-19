package uk.ac.ucl.servlets;

import uk.ac.ucl.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/video.html")
public class ViewVideoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        VideoFolder videoFolder = model.getVideoFolder();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Video video = videoFolder.getById(id);
            request.setAttribute("found", true);
            request.setAttribute("title", video.getTitle());
            request.setAttribute("author", video.getAuthor());
            request.setAttribute("platform", video.getPlatform());
            request.setAttribute("year", video.getYear());
            request.setAttribute("link", video.getLink());
        } catch (Exception e) {
            request.setAttribute("found", false);
        }

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/video.jsp");
        dispatch.forward(request, response);
    }
}
