package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class CompositeKey2 implements Serializable {

    private String slotId;
    private String courseId;
    private String studentId;
    public CompositeKey2() {
    }

    public CompositeKey2(String courseId ,String slotId, String studentId ) {

        this.slotId = slotId;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CompositeKey))
            return false;
        CompositeKey2 arg = (CompositeKey2)obj;
        return arg.courseId.equals(this.courseId) && arg.slotId.equals(this.slotId)&& arg.studentId.equals(this.studentId);
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ?  courseId.hashCode() : 0);

        hash += (slotId != null ? slotId.hashCode() : 0);

        hash += (studentId != null ? studentId.hashCode() : 0);

        return hash;
    }
    @Override
    public String toString() {
        return "newpackage.CompositeKey[ cid=" + courseId +  ",slotid"+ slotId +" studentId=  "+studentId+"]";
    }
}


