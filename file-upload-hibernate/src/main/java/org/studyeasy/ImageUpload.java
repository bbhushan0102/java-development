package org.studyeasy;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.studyeasy.entity.Files;
import org.studyeasy.hibernate.FileDAO;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "imageUpload", value = "/ImageUpload")
public class ImageUpload extends HttpServlet {
    public String path = "/Users/bharat/java-development/file-upload-hibernate/images/";
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =  req.getParameter("action");

        switch(action) {

            case "filesUpload":
                fileUpload(req, resp);
                break;
            case "listingImages":
                listingImages(req, resp);
                break;
            default:
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }


    }

    private void listingImages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<File> files = new FileDAO().listFiles();
        req.setAttribute("files", files);
        req.setAttribute("path", path);
        req.getRequestDispatcher("listFiles.jsp").forward(req, resp);
    }

    public void fileUpload (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> images = null;
        try {
            images = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        for(FileItem image: images) {

            try {
                File file = new File (path + image);
                if (!file.exists()) {
                    new FileDAO().addFileDetails(new Files(image.getName()));
                    image.write(file);
                }
                listingImages(req, resp);


            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(image.getName());
        }
    }
}