package servlet;

import manager.AuthorManager;
import model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/authors")
public class AuthorsServlet extends HttpServlet {

    private AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> authors = authorManager.getAll();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("/WEB-INF/authors.jsp").forward(request, response);
    }


}
