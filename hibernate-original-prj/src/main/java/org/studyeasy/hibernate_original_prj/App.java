package org.studyeasy.hibernate_original_prj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate_original_prj.entity.Users;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Users.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
// Hibernate HQL operations
        try {

//            session.beginTransaction();

//            List<Users> users = session.createQuery("from users ").getResultList();

//            List<Users> users = session.createQuery("from users where user_id=2  OR  username='bharat'").getResultList();
//            for (Users temp: users
//                 ) {
//                System.out.println(temp);
//            }

//            update entry
//           session.createQuery(" update  users set username='Monu'  where username='Hibernate HQL'").executeUpdate();

//            Delete entry
            Users user =new Users();
            session.beginTransaction();
            user = session.get(Users.class, 23);
            session.delete(user);
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }

    }
}
