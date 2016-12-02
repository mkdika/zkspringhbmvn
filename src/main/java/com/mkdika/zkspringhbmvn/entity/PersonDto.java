
package com.mkdika.zkspringhbmvn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author maikel
 */
@Entity
public class PersonDto implements java.io.Serializable {
    
    @Id
    private Integer id;
    private String name;
    private String mail;
    
    public PersonDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }                    
}
