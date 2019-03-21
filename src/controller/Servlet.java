package controller;

import connection.AuthUtils;
import constants.Path;
import entity.Recipe;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.RecipeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@WebServlet("/hello")
public class Servlet extends HttpServlet {
    private RecipeService recipeService = new RecipeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Path.CREATE_RECIPE_PAGE_JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        HttpSession session = request.getSession();
        String recipeName = null;
        int preparationTime = 0;
        int cookingTime = 0;
        String description = null;
        String imagePath = null;
        String message = null;
        if (!isMultipart) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024);

        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024 * 1024 * 10);

        try {
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    if (item.getFieldName().equals("recipeName")) {
                        recipeName = item.getString();
                    } else if (item.getFieldName().equals("prepTime")) {
                        preparationTime = Integer.parseInt(item.getString());
                    } else if (item.getFieldName().equals("cookTime")) {
                        cookingTime = Integer.parseInt(item.getString());
                    } else if (item.getFieldName().equals("instruction")) {
                        description = item.getString();
                    }
                } else {

                    System.out.println(item.getSize());
                    if (item.getSize() > 26214400) {
                        message = "photo too big";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher(Path.CREATE_RECIPE_PAGE_JSP).forward(request, response);
                        return;
                    }
                    if (item.getSize() == 0) {
                        imagePath = "/images/No_image_available.png";
                    } else {
                        imagePath = processUploadedFile(item);
                    }


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        if (recipeName.length() > 2 && !description.equals("")) {
            System.out.println(recipeName + "  " + preparationTime + "   " + cookingTime + "   " + "description" + imagePath);
            Recipe recipe = new Recipe(recipeName, cookingTime, preparationTime, description, imagePath);


            recipeService.add(recipe, AuthUtils.getLoginedUser(session).getId());

        } else {
            message = "Something went wrong ";
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher(Path.CREATE_RECIPE_PAGE_JSP).forward(request, response);
    }

    private String processUploadedFile(FileItem item) throws Exception {
        File uploadetFile;
        String wayToPhoto;
        do {
            wayToPhoto = "/images/" + new Random().nextInt() + item.getName();
            String path = getServletContext().getRealPath(wayToPhoto);
            uploadetFile = new File(path);
        } while (uploadetFile.exists());
        item.write(uploadetFile);
        return wayToPhoto;
    }
}
