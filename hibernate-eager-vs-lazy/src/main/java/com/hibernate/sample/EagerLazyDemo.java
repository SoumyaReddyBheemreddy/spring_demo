package com.hibernate.sample;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {
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
            //use the session object to save Java object
            //start a transaction
            session.beginTransaction();

            //get the instructor from db
            int id = 1;
            Instructor instructor = session.get(Instructor.class,id);
            System.out.println("luv2code : Instructor: "+instructor);
            //get course for the  instructor
            //System.out.println("luv2code: Courses: "+instructor.getCourses());
            //commit transaction
            session.getTransaction().commit();
            //close session
            session.close();
            //since session are lazy loaded ... this should fail
            //how to overcome exception
            System.out.println("luv2code: The session is now closed!\n");

            //option 1 : call getter method while session is open like line no: 32
            // this works because Courses are loaded on main when line 32 runned

            //get course for the  instructor
            System.out.println("luv2code: Courses: "+instructor.getCourses());
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
