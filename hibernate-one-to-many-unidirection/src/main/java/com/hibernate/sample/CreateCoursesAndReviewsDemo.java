package com.hibernate.sample;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //use the session object to save Java object


            //start a transaction
            session.beginTransaction();
            // create a course
            Course course = new Course("Pacman- How To score one Million Points");
            //add some reviews
            Review review1 = new Review("Great course ... loved it!");
            Review review2 = new Review("Cool course, job well done");
            Review review3 = new Review("I like this course");
            course.add(review1);
            course.add(review2);
            course.add(review3);
            // save the course ... and leverage the cascade all
            System.out.println("Saving the course");
            session.save(course);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
