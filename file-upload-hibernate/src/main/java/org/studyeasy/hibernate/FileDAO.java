package org.studyeasy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.entity.Files;
import java.io.File;
import java.util.List;

public class FileDAO {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Files.class).buildSessionFactory();
            public void addFileDetails(Files file) {
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                session.save(file);
                session.getTransaction().commit();
                System.out.println(file.getFilename()+"Got added");

            }

            public List<File> listFiles() {

                Session session = factory.getCurrentSession();
                session.beginTransaction();

                List<File> files = session.createCriteria(Files.class).list();

//               session.getTransaction().commit();
               return files;

    }

}
