package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Book;
import uk.ac.ucl.model.BookFolder;
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

@WebServlet("/book.html")
public class ViewBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel();
        BookFolder bookFolder = model.getBookFolder();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Book book = bookFolder.getById(id);
            request.setAttribute("found", true);
            request.setAttribute("title", book.getTitle());
            request.setAttribute("author", book.getAuthor());
            request.setAttribute("year", book.getYear());
            request.setAttribute("cover", book.getCover());
            request.setAttribute("link", book.getLink());
        } catch (Exception e) {
            request.setAttribute("found", false);
        }

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/book.jsp");
        dispatch.forward(request, response);
    }
}
