//package Design;
//
//import entities.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.Date;
//
//public class Test {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction etx = em.getTransaction();
//        etx.begin();
//        Course c = new Course("CSE312");
//        Course c1 = new Course("PHYS102");
//        Course c2 = new Course("SOFT301");
//        Course c3 = new Course("HSS102");
//        Date d = new Date(2016,10,20);
//        Student s = new Student("216cs2007", d, true );
//        Student s1 = new Student("212ag1234", d, false );
//        Student s2 = new Student("217cs2032", d, true );
//        Student s3 = new Student("217cs2008", d, true );
//
//        Slot slot = new Slot("asdfas", "sdafsdaf", 3, 1);
//        Slot slot1 = new Slot("ssfd", "cvbnvb", 4, 2);
//        Slot slot2 = new Slot("fghgh", "ytutyu", 2, 3);
//        Slot slot3 = new Slot("khjjk", "rtyrt", 3, 4);
//
////        SlotAndCourse sc = new SlotAndCourse("BA", 2, 2011, slot, c );
////        SlotAndCourse sc1 = new SlotAndCourse("AA", 1, 2012, slot1, c1 );
////        SlotAndCourse sc2 = new SlotAndCourse("DD", 2, 2013, slot2, c2 );
////        SlotAndCourse sc3 = new SlotAndCourse("F", 2, 2014, slot3, c3 );
//        SlotAndCourse slots = new SlotAndCourse(2015, 1, "ba", slot, c);
//        CCR ccr =  new CCR(s,c,slot);
//        CCR ccr1 =  new CCR(s1,c1,slot1);
//        CCR ccr2 =  new CCR(s2,c2,slot2);
//        CCR ccr3 =  new CCR(s3,c3,slot3);
//
//
//
//        em.persist(c);
//        em.persist(c1);
//        em.persist(c2);
//        em.persist(c3);
////        em.persist(s);
////        em.persist(s1);
////        em.persist(s2);
////        em.persist(s3);
//        em.persist(slot);
//        em.persist(slot1);
//        em.persist(slot2);
//        em.persist(slot3);
//        em.persist(slots);
////        em.persist(sc1);
////        em.persist(sc2);
////        em.persist(sc3);
//        em.persist(ccr);
//        em.persist(ccr1);
//        em.persist(ccr2);
//        em.persist(ccr3);
//
//        etx.commit();
//    }
//}
