package org.siit.course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class CarBrands {

    private String name;
    private Date establishDate;
    private String owner;
    private String contact;
    private Person ceo;

//    commented below getters and setters because of
//    lombok Getters, Setters and AllArgsConstructor import
    /*public String getName() {
        return this.name;
    }

    public Date getDate() {
        return this.establishDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Person getCeo() {
        return ceo;
    }

    public void setCeo(Person ceo) {
        this.ceo = ceo;
    }*/


}
