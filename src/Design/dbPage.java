package Design;

import entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class dbPage {
    @FXML
    TextField tfYear,tfSlot,tfAvgcourse,tfAvgslot;
    @FXML
    Button btYear,btSlot,btAvgcourse,btAvgslot,btGpa;
    @FXML
    Label lbAvgcourse,lbAvgslot;
    @FXML
    TableView twStudent,twCourse,twSlot,twCCR,twSlotAndCourse;
    @FXML
    TableView twResultTable;

    private ObservableList<CCR> ccrObservableList;
    private ObservableList<Course> courseObservableList;
    private ObservableList<Slot> slotObservableList;
    private ObservableList<SlotAndCourse> slotAndCourseObservableList;
    private ObservableList<Student> studentObservableList;
    private ObservableList<Student> query1ObservableList;
    private ObservableList<SlotAndCourse> query2ObservableList;

    private EntityManager em;
    private EntityTransaction etx;

    public void initialize(){
        prepareTables();
        studentObservableList= FXCollections.emptyObservableList();
        courseObservableList = FXCollections.emptyObservableList();
        ccrObservableList = FXCollections.emptyObservableList();
        slotAndCourseObservableList = FXCollections.emptyObservableList();
        slotObservableList = FXCollections.emptyObservableList();

//        try{
//            readFiles();
//        }catch (Exception e){
//            System.out.println("HATA");
//        }

        connectDB();
        filldb();
        fillTables();


    }
//    public void readFiles() throws FileNotFoundException {
//
//    File[] fileArray = new File("C:\\Users\\tahad\\Desktop\\project5\\src\\Design\\Data").listFiles();
//
//        File a = new File("C:\\Users\\tahad\\Desktop\\project5\\src\\Design\\Data\\1.txt.txt.mxt");
//
//        for (int i=1;i<2;i++) {
//            Scanner s = new Scanner(a);
//            while (s.hasNextLine()) {
//                String line =s.nextLine();
//                System.out.println(line);
//            }
//
//        }
//    }

    public void filldb(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        Course c = new Course("CSE312");
        Course c1 = new Course("PHYS101");
        Course c2 = new Course("SOFT301");
        Course c3 = new Course("HSS102");
        Course c4 = new Course("MATH101");
        Course c5 = new Course("MATH102");
        Course c6 = new Course("CSE111");
        Date d = new Date(2016,10,20);
        Student s = new Student("216cs2007", d.getYear(), true );
        Student s1 = new Student("212ag1234", d.getYear(), false );
        Student s2 = new Student("217cs2032", d.getYear(), true );
        Student s3 = new Student("217cs2008", d.getYear(), true );

        Slot slot = new Slot("cse312", "Algorithm", 3, 1);
        Slot slot1 = new Slot("hss", "hsslesson", 4, 2);
        Slot slot2 = new Slot("phys101", "physics", 2, 3);
        Slot slot3 = new Slot("soft301", "software engineering", 3, 4);
        Slot slot5 = new Slot("math101", "calculus 1", 3, 4);
        Slot slot6 = new Slot("math102", "calculus 2", 3, 4);
        Slot slot7 = new Slot("cse111", "java", 3, 4);

        SlotAndCourse sc = new SlotAndCourse(2016, 2, "BA", slot, c );
        SlotAndCourse sc1 = new SlotAndCourse(2014, 2, "AA", slot1, c3 );
        SlotAndCourse sc2 = new SlotAndCourse(2015, 2, "DD", slot2, c1 );
        SlotAndCourse sc3 = new SlotAndCourse(2011, 2, "DC", slot3, c2 );
        SlotAndCourse slots = new SlotAndCourse(2015, 1, "F", slot5, c4);
        SlotAndCourse sc5 = new SlotAndCourse(2014, 2, "CC", slot7, c6);
        SlotAndCourse sc6 = new SlotAndCourse(2014, 2, "CC", slot6, c5);

        CCR ccr =  new CCR(s,c,slot);
        CCR ccr1 =  new CCR(s1,c1,slot1);
        CCR ccr2 =  new CCR(s2,c2,slot2);
        CCR ccr3 =  new CCR(s3,c3,slot3);



        em.persist(c);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(c5);
        em.persist(c6);
        em.persist(s);
        em.persist(s1);
        em.persist(s2);
        em.persist(s3);
        em.persist(slot);
        em.persist(slot1);
        em.persist(slot2);
        em.persist(slot3);
        em.persist(slot5);
        em.persist(slot6);
        em.persist(slot7);
        em.persist(sc5);
        em.persist(slots);
        em.persist(sc);
        em.persist(sc1);
        em.persist(sc2);
        em.persist(sc3);
        em.persist(sc6);
        em.persist(ccr);
        em.persist(ccr1);
        em.persist(ccr2);
        em.persist(ccr3);

        etx.commit();

    }
//    public void query1(String year){
//        year = tfYear.getText();
//        int result = Integer.parseInt(year);
//        em.createQuery("select e.studentNumber from Student e where e.leavingDate = :result");
//
//
//
//    }
    public void averageCourse(){
        String coursename = tfAvgcourse.getText();
        List<String> list = em.createQuery(
                "SELECT e.grade FROM SlotAndCourse e where e.course.courseCode = :coursename ")
                .setParameter("coursename",tfAvgcourse.getText()).getResultList();
        double sum = 0;
        String[] grades = new String[list.size()];
        grades =  list.toArray(grades);

        for (int i = 0; i< grades.length; i++){

            if (grades[i].equals("AA")){
            sum = sum+100.0;
        }
        else if(grades[i].equals("BA")){
            sum =sum+ 89.0;
        }
        else if(grades[i].equals("BB")){
            sum =sum+ 79.0;
        }
        else if(grades[i].equals("CB")){
            sum = sum+ 69;
        }
        else if(grades[i].equals("CC")){
            sum = sum+ 59;
        }
        else if(grades[i].equals("DC")){
            sum =sum+ 49.0;
        }
        else if(grades[i].equals("DD")){
            sum =sum+ 39.0;
        }


        }

        double average = sum/grades.length;
        if (average >=90){
            lbAvgcourse.setText("AA");
        }
        else if (average <90 && average >=80){
            lbAvgcourse.setText("BA");
        }
        else if (average <90 && average >=80){
            lbAvgcourse.setText("BA");
        }
        else if (average <80 && average >=70){
            lbAvgcourse.setText("BB");
        }
        else if (average <70 && average >=60){
            lbAvgcourse.setText("CB");
        }
        else if (average <60 && average >=50){
            lbAvgcourse.setText("CC");
        }
        else if (average <50 && average >=40){
            lbAvgcourse.setText("DC");
        }
        else if (average <40 && average >30){
            lbAvgcourse.setText("DD");
        }


            }
    public void averageSlot() {
        String slotname = tfAvgslot.getText();
        List<String> list = em.createQuery(
                "SELECT e.grade FROM SlotAndCourse e where e.slot.slotCode = :slotcode ")
                .setParameter("slotcode", tfAvgslot.getText()).getResultList();
        double sum = 0;
        String[] grades = new String[list.size()];
        grades =  list.toArray(grades);

        for (int i = 0; i< grades.length; i++){
            System.out.println(grades[i]);
            if (grades[i].equals("AA")){
                sum = sum+100.0;
            }
            else if(grades[i].equals("BA")){
                sum =sum+ 89.0;
            }
            else if(grades[i].equals("BB")){
                sum =sum+ 79.0;
            }
            else if(grades[i].equals("CB")){
                sum = sum+ 69.0;
            }
            else if(grades[i].equals("CC")){
                sum = sum+ 59.0;
            }
            else if(grades[i].equals("DC")){
                sum =sum+ 49.0;
            }
            else if(grades[i].equals("DD")){
                sum =sum+ 39.0;
            }


        }

        double average = sum/grades.length;
        if (average >=90){
            lbAvgslot.setText("AA");
        }
        else if (average <90 && average >=80){
            lbAvgslot.setText("BA");
        }
        else if (average <80 && average >=70){
            lbAvgslot.setText("BB");
        }
        else if (average <70 && average >=60){
            lbAvgslot.setText("CB");
        }
        else if (average <60 && average >=50){
            lbAvgslot.setText("CC");
        }
        else if (average <50 && average >=40){
            lbAvgslot.setText("DC");
        }
        else if (average <40 && average >30){
            lbAvgslot.setText("DD");
        }

    }
    public void query1(){

        twResultTable.getColumns().clear();
        TableColumn<Student,String> qCol1 = new TableColumn<>("studentNumber");
        qCol1.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        TableColumn<Student,String> qCol2 = new TableColumn<>("leavingDate");
        qCol2.setCellValueFactory(new PropertyValueFactory<>("leavingDate"));
        TableColumn<Student,String> qCol3 = new TableColumn<>("minorDegree");
        qCol3.setCellValueFactory(new PropertyValueFactory<>("minorDegree"));

        twResultTable.getColumns().add(qCol1);
        twResultTable.getColumns().add(qCol2);
        twResultTable.getColumns().add(qCol3);
        twResultTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        twResultTable.setEditable(true);
        twResultTable.setItems(query1ObservableList);
        String year1 = tfYear.getText();
        int year =Integer.parseInt(year1);


        TypedQuery<Student> query = em.createQuery(
                "SELECT c FROM Student c WHERE c.leavingDate = :year", Student.class);

        query1ObservableList = FXCollections.observableList((List<entities.Student>)query.setParameter("year", year).getResultList());
        twResultTable.setItems(query1ObservableList);


    }
    public void query2(){
        twResultTable.getColumns().clear();
        TableColumn<Course,String> sacCol5 = new TableColumn<>("courseCode");
        sacCol5.setCellValueFactory(new PropertyValueFactory<>("courseCode"));


        twResultTable.getColumns().add(sacCol5);
        twResultTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        twResultTable.setEditable(true);


        String slotcode = tfSlot.getText();

        TypedQuery<SlotAndCourse> query = em.createQuery(
                "SELECT a.course FROM SlotAndCourse a WHERE a.slot.slotCode = :slotcode", SlotAndCourse.class);

        query2ObservableList = FXCollections.observableList((List<entities.SlotAndCourse>)query.setParameter("slotcode", slotcode).getResultList());
        twResultTable.setItems(query2ObservableList);




    }
//
//    public void averageCourse2(){
//        twResultTable.getColumns().clear();
//        TableColumn<SlotAndCourse,String> qCol1 = new TableColumn<>("grade");
//        qCol1.setCellValueFactory(new PropertyValueFactory<>("grade"));
//
//
//        twResultTable.getColumns().add(qCol1);
//
//        twResultTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        twResultTable.setEditable(true);
//        twResultTable.setItems(averageCourseObservableList);
//
//        String coursename = tfAvgcourse.getText();
//        TypedQuery<SlotAndCourse> query = em.createQuery(
//                "SELECT e.grade FROM SlotAndCourse e where e.course.courseCode = :coursename ", SlotAndCourse.class);
//
//        averageCourseObservableList = FXCollections.observableList((List<entities.SlotAndCourse>)em.createQuery(
//                "SELECT e.grade FROM SlotAndCourse e where e.course.courseCode = :coursename ")
//                .setParameter("coursename",tfAvgcourse.getText()).getResultList());
//        twSlotAndCourse.setItems(averageCourseObservableList);
//
//        slotAndCourseObservableList = FXCollections.observableList((List<entities.SlotAndCourse>)em.createNamedQuery("SlotAndCourse.findAll").getResultList());
//        twSlotAndCourse.setItems(slotAndCourseObservableList);
//
//    }


    private void connectDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        em = emf.createEntityManager();
        etx= em.getTransaction();
        etx.begin();
    }


    private void fillTables() {
        courseObservableList = FXCollections.observableList((List<entities.Course>)em.createNamedQuery("Course.findAll").getResultList());
        twCourse.setItems(courseObservableList);
        studentObservableList = FXCollections.observableList((List<entities.Student>)em.createNamedQuery("Student.findAll").getResultList());
        twStudent.setItems(studentObservableList);
        ccrObservableList = FXCollections.observableList((List<entities.CCR>)em.createNamedQuery("CCR.findAll").getResultList());
        twCCR.setItems(ccrObservableList);
        slotObservableList = FXCollections.observableList((List<entities.Slot>)em.createNamedQuery("Slot.findAll").getResultList());
        twSlot.setItems(slotObservableList);
        slotAndCourseObservableList = FXCollections.observableList((List<entities.SlotAndCourse>)em.createNamedQuery("SlotAndCourse.findAll").getResultList());
        twSlotAndCourse.setItems(slotAndCourseObservableList);



    }
    private void prepareTables(){
        TableColumn<Student,String> sCol1 = new TableColumn<>("studentNumber");
        sCol1.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        TableColumn<Student,String> sCol2 = new TableColumn<>("leavingDate");
        sCol2.setCellValueFactory(new PropertyValueFactory<>("leavingDate"));
        TableColumn<Student,String> sCol3 = new TableColumn<>("minorDegree");
        sCol3.setCellValueFactory(new PropertyValueFactory<>("minorDegree"));
        twStudent.getColumns().clear();
        twStudent.getColumns().add(sCol1);
        twStudent.getColumns().add(sCol2);
        twStudent.getColumns().add(sCol3);
        twStudent.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        twStudent.setEditable(true);
        twStudent.setItems(studentObservableList);

        TableColumn<Course,String> cCol1 = new TableColumn<>("courseCode");
        cCol1.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        twCourse.getColumns().clear();
        twCourse.getColumns().add(cCol1);
        twCourse.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        twCourse.setItems(courseObservableList);
        twCourse.setEditable(true);

        TableColumn<Slot,String> slCol1 = new TableColumn<>("slotCode");
        slCol1.setCellValueFactory(new PropertyValueFactory<>("slotCode"));
        TableColumn<Slot,String> slCol2 = new TableColumn<>("slotName");
        slCol2.setCellValueFactory(new PropertyValueFactory<>("slotName"));
        TableColumn<Slot,String> slCol3 = new TableColumn<>("credit");
        slCol3.setCellValueFactory(new PropertyValueFactory<>("credit"));
        TableColumn<Slot,String> slCol4 = new TableColumn<>("semester");
        slCol4.setCellValueFactory(new PropertyValueFactory<>("semester"));
        twSlot.getColumns().clear();
        twSlot.getColumns().add(slCol1);
        twSlot.getColumns().add(slCol3);
        twSlot.getColumns().add(slCol4);
        twSlot.getColumns().add(slCol2);
        twSlot.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        twSlot.setEditable(true);
        twSlot.setItems(slotObservableList);

        TableColumn<CCR,String> ccCol1 = new TableColumn<>("student");
        ccCol1.setCellValueFactory(new PropertyValueFactory<>("student"));
        TableColumn<CCR,String> ccCol2 = new TableColumn<>("course");
        ccCol2.setCellValueFactory(new PropertyValueFactory<>("course"));
        TableColumn<CCR,String> ccCol3 = new TableColumn<>("slot");
        ccCol3.setCellValueFactory(new PropertyValueFactory<>("slot"));
        twCCR.getColumns().clear();
        twCCR.getColumns().add(ccCol3);
        twCCR.getColumns().add(ccCol2);
        twCCR.getColumns().add(ccCol1);

        twCCR.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        twCCR.setEditable(true);
        twCCR.setItems(ccrObservableList);



        TableColumn<SlotAndCourse,String> sacCol1 = new TableColumn<>("yearTaken");
        sacCol1.setCellValueFactory(new PropertyValueFactory<>("yearTaken"));
        TableColumn<SlotAndCourse,String> sacCol2 = new TableColumn<>("termTaken");
        sacCol2.setCellValueFactory(new PropertyValueFactory<>("termTaken"));
        TableColumn<SlotAndCourse,String> sacCol3 = new TableColumn<>("grade");
        sacCol3.setCellValueFactory(new PropertyValueFactory<>("grade"));
        TableColumn<SlotAndCourse,String> sacCol4 = new TableColumn<>("slot");
        sacCol4.setCellValueFactory(new PropertyValueFactory<>("slot"));
        TableColumn<SlotAndCourse,String> sacCol5 = new TableColumn<>("course");
        sacCol5.setCellValueFactory(new PropertyValueFactory<>("course"));
        twSlotAndCourse.getColumns().clear();
        twSlotAndCourse.getColumns().add(sacCol3);
        twSlotAndCourse.getColumns().add(sacCol2);
        twSlotAndCourse.getColumns().add(sacCol1);
        twSlotAndCourse.getColumns().add(sacCol4);
        twSlotAndCourse.getColumns().add(sacCol5);

        twSlotAndCourse.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        twSlotAndCourse.setEditable(true);
        twSlotAndCourse.setItems(slotAndCourseObservableList);

    }


}
