package com.hibernate.sample;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FecthJoinDemo {
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

            // option 2 : Hibernate query with HQL

            //get the instructor from db
            int id = 1;
            Query<Instructor> query = session.createQuery("select i from" +
                    " Instructor i " +
                    "Join FETCH i.courses" +
                    " where i.id=:theInstructorId",Instructor.class);
            query.setParameter("theInstructorId",id);
            Instructor instructor= query.getSingleResult();
            System.out.println("luv2code : Instructor: "+instructor);

            //commit transaction
            session.getTransaction().commit();
            //close session
            session.close();
            //since session are lazy loaded ... this should fail
            //how to overcome exception
            System.out.println("luv2code: The session is now closed!\n");

            //get course for the  instructor
            System.out.println("luv2code: Courses: "+instructor.getCourses());
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
