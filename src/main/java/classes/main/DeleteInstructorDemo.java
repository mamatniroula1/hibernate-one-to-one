package classes.main;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory= new Configuration(). configure().addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        Session session= sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            int instructorId=2;

            Instructor instructor= session.get(Instructor.class, instructorId);

            //it deletes the whole instructor and indtructor detail

            session.delete(instructor);


            session.getTransaction().commit();




        }finally {
            sessionFactory.close();
        }

    }
}
