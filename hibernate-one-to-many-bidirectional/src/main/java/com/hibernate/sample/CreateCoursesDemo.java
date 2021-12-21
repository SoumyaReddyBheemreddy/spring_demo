package com.hibernate.sample;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {
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
            // create some courses
            Course course1 = new Course("Air Guitar - The Ultimate Guide");
            Course course2 = new Course("The Pinball Masterclass");
            Course course3 = new Course("Java introduction class");
            //add courses to instructor
                instructor.add(course1);
                instructor.add(course2);
                instructor.add(course3);
            //save the courses
               session.save(course1);
               session.save(course2);
               session.save(course3);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
