package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity

@NamedQueries({
        @NamedQuery(name = "CCR.findAll", query = "SELECT cr FROM CCR cr") })

public class CCR implements Serializable {
    @EmbeddedId
    CompositeKey2 c;
    @JoinColumn(name = "studentId", referencedColumnName = "studentNumber", insertable = false, updatable = false)
    @OneToOne(optional = false)
    Student student;

    @JoinColumn(name = "courseId", referencedColumnName = "courseCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    Course course;

    @JoinColumn(name = "slotId", referencedColumnName = "slotCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    Slot slot;



    public CCR() {
    }

    public CCR(Student student, Course course, Slot slot) {
        this.c = new CompositeKey2(course.getCourseCode(), slot.getSlotCode(), student.getStudentNumber());
        this.student = student;
        this.course = course;
        this.slot = slot;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public CompositeKey2 getC() {
        return c;
    }

    public void setC(CompositeKey2 c) {
        this.c = c;
    }
    public int hashCode() {
        int hash = 0;
        hash += (c != null ? c.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CCR){
            CCR arg = (CCR)obj;
            return this.c.equals(arg.c);
        }
        else if(obj instanceof CompositeKey2){
            CompositeKey2 arg = (CompositeKey2)obj;
            return this.c.equals(arg);
        }
        return false;
    }
}
