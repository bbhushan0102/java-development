package org.studyeasy;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "imageUpload", value = "/ImageUpload")
public class ImageUpload extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> images = null;
        try {
            images = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        for(FileItem image: images) {

            try {
                image.write(new File("/Users/bharat/java-development/file-upload-hibernate/images/" +image));

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(image.getName());
        }

    }
}