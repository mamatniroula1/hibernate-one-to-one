package classes.main;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory= new Configuration(). configure().addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        Session session= sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId=1;

            InstructorDetail instructorDetail= session.get(InstructorDetail.class, theId);


            System.out.println("the associated instructor:"+ instructorDetail.getInstructor());
            session.getTransaction().commit();




        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
