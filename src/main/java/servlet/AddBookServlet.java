package servlet;

import manager.AuthorManager;
import manager.BooksManager;
import model.Author;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PipedReader;
import java.util.List;

@WebServlet(urlPatterns = "/book/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddBookServlet extends HttpServlet {

    private AuthorManager authorManager = new AuthorManager();

    private BooksManager booksManager = new BooksManager();

    private static final String IMAGE_PATH = "C:\\Users\\Armen\\IdeaProjects\\MyLibrary\\images";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> authors = authorManager.getAll();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("/WEB-INF/addBooks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int authorId = Integer.parseInt(request.getParameter("author_id"));
        Part image = request.getPart("image");
        String imageName = null;
        if (image != null) {
            long nanoTime = System.nanoTime();
            imageName = nanoTime + "_" + image.getSubmittedFileName();
            String fullName = IMAGE_PATH + File.separator + imageName;
            image.write(fullName);
        }

        Book book = Book.builder()
                .title(title)
                .description(description)
                .price(price)
                .author(authorManager.getAuthorById(authorId))
                .image(imageName)
                .build();
        booksManager.addBook(book);
        response.sendRedirect("/books");
    }
}
