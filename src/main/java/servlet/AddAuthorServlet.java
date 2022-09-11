package servlet;

import manager.AuthorManager;
import model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddAuthorServlet extends HttpServlet {

    private AuthorManager authorManager = new AuthorManager();

    private static final String IMAGE_PATH = "C:\\Users\\Armen\\IdeaProjects\\MyLibrary\\images";

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
        Part image = request.getPart("image");
        String imageName = null;
        if (image != null) {
            long nanoTime = System.nanoTime();
            imageName = nanoTime + "_" + image.getSubmittedFileName();
            String fullName = IMAGE_PATH + File.separator + imageName;
            image.write(fullName);
        }
        Author author = Author.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .age(age)
                .image(imageName)
                .build();
        authorManager.addAuthor(author);
        response.sendRedirect("/authors");
    }
}
