package classes.main;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory  sessionFactory= new Configuration().configure().addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        try {

            //create the objects
//            Instructor instructor= new Instructor("Nagendra","kumar", "nagendra@ghodagang.com");
//            InstructorDetail instructorDetail= new InstructorDetail("www.youtube.com/nagendra","riding ghoda");

            Instructor instructor= new Instructor("madhu","patel", "madhu@ghodagang.com");
            InstructorDetail instructorDetail= new InstructorDetail("www.youtube.com/madhu"," guitar");
            //associate the objects
            instructor.setInstructorDetail(instructorDetail);

            //save the instructor
            session.beginTransaction();


            //this will also save the associated objects in this case it will also save the instructor detail
            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("done");


        }finally {
            sessionFactory.close();
        }
    }
}
