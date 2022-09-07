package servlet;

import manager.AuthorManager;
import model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/add")
public class AddAuthorServlet extends HttpServlet {

    private AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addAuthor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        Author author = Author.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .age(age)
                .build();
        authorManager.addAuthor(author);
        response.sendRedirect("/authors");
    }
}
