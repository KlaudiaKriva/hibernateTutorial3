package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Instructor;
import com.tutorial.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 4;
            InstructorDetail tempInstructorDetail = (InstructorDetail) session.get(InstructorDetail.class, theId);
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            System.out.println("Deleting tempInstructorDetail " + tempInstructorDetail);

            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(tempInstructorDetail);

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }

























    }
}
