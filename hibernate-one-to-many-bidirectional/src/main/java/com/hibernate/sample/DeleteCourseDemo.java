package com.hibernate.sample;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemo {
    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {

            //start a transaction
            session.beginTransaction();
            //get course
            int id = 12;
            Course course = session.get(Course.class,id);
            //delete course
            System.out.println("Deleting course: "+course);
            session.delete(course);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            //handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
