package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@Entity

@NamedQueries({
        @NamedQuery(name = "SlotAndCourse.findAll", query = "SELECT sla FROM SlotAndCourse sla") })
public class SlotAndCourse implements Serializable {
    @EmbeddedId
    CompositeKey ck;

    int yearTaken;


    int termTaken;


    String grade;

    @JoinColumn(name = "slotId", referencedColumnName = "slotCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    Slot slot;

    @JoinColumn(name = "courseId",referencedColumnName = "courseCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    Course course;


    public SlotAndCourse() {
    }

    public SlotAndCourse(int yearTaken, int termTaken, String grade, Slot slot, Course course) {
        this.ck = new CompositeKey(course.getCourseCode(), slot.getSlotCode());
        this.yearTaken = yearTaken;
        this.termTaken = termTaken;
        this.grade = grade;
        this.slot = slot;
        this.course = course;
    }

    public int getYearTaken() {
        return yearTaken;
    }

    public void setYearTaken(int yearTaken) {
        this.yearTaken = yearTaken;
    }

    public int getTermTaken() {
        return termTaken;
    }

    public void setTermTaken(int termTaken) {
        this.termTaken = termTaken;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public void setC(CompositeKey c) {
        this.ck = c;
    }
    public int hashCode() {
        int hash = 0;
        hash += (ck != null ? ck.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SlotAndCourse){
            SlotAndCourse arg = (SlotAndCourse)obj;
            return this.ck.equals(arg.ck);
        }
        else if(obj instanceof CompositeKey){
            CompositeKey arg = (CompositeKey)obj;
            return this.ck.equals(arg);
        }
        return false;
    }

    @Override
    public String toString() {
        return  this.ck.getCourseId()+ " "+ this.ck.getSlotId();
    }

}
