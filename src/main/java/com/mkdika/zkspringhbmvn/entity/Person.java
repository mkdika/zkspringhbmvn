package com.mkdika.zkspringhbmvn.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maikel
 */
@Entity
@Table(name = "person", catalog = "coderclub", schema = "")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /*
    ID tidak perlu diinput manual karena telah mengambil fitur AUTO_INCREMENT
    yang telah setup di table MySQL nya.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "personname")
    private String personname;
    
    /*
    0 = FEMALE
    1 = MALE
    */
    @Basic(optional = false)
    @Column(name = "gender")
    private Integer gender;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }   
}
