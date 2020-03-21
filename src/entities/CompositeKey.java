/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable{

    private String slotId;
    private String courseId;

    public CompositeKey() {
    }

    public CompositeKey(String courseId ,String slotId ) {

        this.slotId = slotId;
        this.courseId = courseId;
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
        CompositeKey arg = (CompositeKey)obj;
        return arg.courseId.equals(this.courseId) && arg.slotId.equals(this.slotId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ?  courseId.hashCode() : 0);

        hash += (slotId != null ? slotId.hashCode() : 0);

        return hash;
    }

    @Override
    public String toString() {
        return "newpackage.CompositeKey[ cid=" + courseId +  ",slotid"+ slotId +"]";
    }
}
