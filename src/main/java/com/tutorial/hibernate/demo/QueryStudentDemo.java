package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").list();

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName = 'Vargockova'").list();

            System.out.println("Students with last name: Vargockova: ");
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName = 'Vargockova' OR s.firstName='Tomas'").list();
            System.out.println("Students with last name: Vargockova or firstName Tomas ");
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").list();
            System.out.println("Students with email ending gmail.com ");
            displayStudents(theStudents);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

























    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student student: theStudents){
            System.out.println(student);
        }
    }
}
