package servlet;

import manager.AuthorManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/authors/delete")
public class DeleteAuthorServlet extends HttpServlet {

    AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        authorManager.deleteAuthorById(authorId);
        response.sendRedirect("/authors");
    }

}
