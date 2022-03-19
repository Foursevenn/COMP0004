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

@WebServlet("/list.html")
public class ViewListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        int id = Integer.parseInt(request.getParameter("id"));
        //for general notebook webpage
        if (id < 11) {
            try {
                ListFolder listFolder = model.getTopics();
                MyList myList = listFolder.getById(id);
                request.setAttribute("found", true);
                request.setAttribute("myList", myList);
            } catch (Exception e) {
                request.setAttribute("found", false);
            }
        //for list webpage
        } else {
            try {
                ListFolder listFolder = model.getListFolder();
                MyList myList = listFolder.getById(id);
                request.setAttribute("found", true);
                request.setAttribute("myList", myList);
            } catch (Exception e) {
                request.setAttribute("found", false);
            }
        }

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/list.jsp");
        dispatch.forward(request, response);
    }
}
