package servlet;

import manager.BooksManager;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/books/delete")
public class DeleteBookServlet extends HttpServlet {

    BooksManager booksManager = new BooksManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("booksId"));
        booksManager.deleteBookById(bookId);
        response.sendRedirect("/books");
    }

}
