package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Instructor;
import com.tutorial.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 2;
            InstructorDetail tempInstructorDetail = (InstructorDetail) session.get(InstructorDetail.class, theId);
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

























    }
}
