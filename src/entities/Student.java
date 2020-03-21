package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity

@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s") })

public class Student implements Serializable {

    @Id

    String studentNumber;

    int leavingDate;

    Boolean minorDegree;

    public Student() {
    }

    public Student(String studentNumber, int leavingDate, Boolean minorDegree) {
        this.studentNumber = studentNumber;
        this.leavingDate = leavingDate;
        this.minorDegree = minorDegree;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(int leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Boolean getMinorDegree() {
        return minorDegree;
    }

    public void setMinorDegree(Boolean minorDegree) {
        this.minorDegree = minorDegree;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentNumber != null ? studentNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentNumber == null && other.studentNumber != null) || (this.studentNumber != null && !this.studentNumber.equals(other.studentNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return studentNumber + " ";
    }

}


