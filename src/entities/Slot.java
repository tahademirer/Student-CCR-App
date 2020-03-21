package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@Entity

@NamedQueries({
        @NamedQuery(name = "Slot.findAll", query = "SELECT sl FROM Slot sl") })
public class Slot implements Serializable {
    @Id

    String slotCode;


    String slotName;


    int credit;


    int semester;


    public Slot() {
    }

    public Slot(String slotCode, String slotName, int credit, int semester) {
        this.slotCode = slotCode;
        this.slotName = slotName;
        this.credit = credit;
        this.semester = semester;
    }

    public String getSlotCode() {
        return slotCode;
    }

    public void setSlotCode(String slotCode) {
        this.slotCode = slotCode;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Slot)) {
            return false;
        }
        Slot other = (Slot) object;
        if ((this.slotCode == null && other.slotCode != null) || (this.slotCode != null && !this.slotCode.equals(other.slotCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return slotCode+" ";
    }

}

