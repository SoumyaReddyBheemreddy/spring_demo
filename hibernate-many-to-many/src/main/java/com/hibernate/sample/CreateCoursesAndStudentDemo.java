package com.hibernate.sample;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesAndStudentDemo {
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
            // create a course
            Course course = new Course("Pacman- How To score one Million Points");
            // save the course
            System.out.println("Saving the course");
            session.save(course);
            System.out.println("Saved the course: "+course);
            //create the student
            Student student1 = new Student("John","Doe","john@gmail.com");
            Student student2 = new Student("Mary","Public","mary@gmail.com");
            //add students to the course
            course.addStudent(student1);
            course.addStudent(student2);
            //save the students
            session.save(student1);
            session.save(student2);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
