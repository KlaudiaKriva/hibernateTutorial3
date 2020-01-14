package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student with id: "+ studentId);

            Student myStudent = (Student) session.get(Student.class, studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("Anezka");

            session.getTransaction().commit();

            //new code
            session = factory.getCurrentSession();
            session.beginTransaction();



            System.out.println("update email for all users");
            session.createQuery("update Student set email='klaud@gmail.com'").executeUpdate();

            session.getTransaction().commit();





            System.out.println("Done!");

        }
        finally {
            factory.close();
        }

























    }
}
