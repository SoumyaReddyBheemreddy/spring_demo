package com.hibernate.sample;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {
    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {

            //start a transaction
            session.beginTransaction();
            // get the instructor detail object
                int id = 1;
                InstructorDetail instructorDetail = session.get(InstructorDetail.class,id);
            // print the instructor details
            System.out.println(instructorDetail);
            // print the associated instructor
            System.out.println("the associated instructor:"+
                    instructorDetail.getInstructor());
            // now let's delte the instrucyor detail
            System.out.println("Deleting instructor details: "+instructorDetail);
            session.delete(instructorDetail);
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
