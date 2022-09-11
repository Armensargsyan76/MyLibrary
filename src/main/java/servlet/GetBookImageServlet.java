package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/getImageBook")
public class GetBookImageServlet extends HttpServlet {

    private static final String IMAGE_PATH = "C:\\Users\\Armen\\IdeaProjects\\MyLibrary\\images";


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String profilePicName = req.getParameter("image");
        if (profilePicName == null || profilePicName.length()==0){
            resp.sendRedirect("/books");
        }
        String filePath = IMAGE_PATH + File.separator + profilePicName;
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            try (FileInputStream inStream = new FileInputStream(imageFile)) {
                resp.setContentType("image/jpeg");
                resp.setContentLength((int) imageFile.length());
                OutputStream outputStream = resp.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead=inStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/books");
    }

}
