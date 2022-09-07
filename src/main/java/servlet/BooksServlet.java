package servlet;

import manager.BooksManager;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books")
public class BooksServlet extends HttpServlet {

    private BooksManager booksManager = new BooksManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> allBooks = booksManager.getAllBooks();
        request.setAttribute("books", allBooks);
        request.getRequestDispatcher("/WEB-INF/books.jsp").forward(request, response);
    }

}
