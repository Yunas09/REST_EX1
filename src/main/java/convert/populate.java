package convert;

import entity.person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class populate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rest_pu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        person p = new person( "lars", "larsen", 5);
        em.persist(p);
       
        person p2 = new person( "henrik", "larsen", 1);
        em.persist(p2);
        
        person p3 = new person( "Yunas", "Mohamed", 2);
        em.persist(p3);
        
        
        em.getTransaction().commit();
        em.close();
        
     
        
        
        
        
    }
}
