package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating 3 new students object...");
            Student tempStudent1 = new Student("Klaud", "Kriva", "klaud@gmail.com");
            Student tempStudent2 = new Student("Tomas", "Pavlik", "tomas@gmail.com");
            Student tempStudent3 = new Student("Adam", "Ivan", "adam@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
