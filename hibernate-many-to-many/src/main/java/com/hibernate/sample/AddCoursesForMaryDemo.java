package com.hibernate.sample;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMaryDemo {
    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //use the session object to save Java object


            //start a transaction
            session.beginTransaction();
            //get the student mary from database
            int id = 2;
            Student student = session.get(Student.class,id);
            System.out.println("Loaded student: "+student);
            System.out.println("Courses: "+student.getCourses());
            //create more courses
            Course course1 = new Course("Rubik's Cube - How to speed Cube");
            Course course2 = new Course("Atari 2600  - Game Development");
            //save courses
            session.save(course1);
            session.save(course2);
            //add student to courses
            student.addCourse(course1);
            student.addCourse(course2);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
