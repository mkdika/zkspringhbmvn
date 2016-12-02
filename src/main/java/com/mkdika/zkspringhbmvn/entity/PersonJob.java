
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
 * @author maikel
 */
@Entity
@Table(name = "person_job", catalog = "coderclub", schema = "")
public class PersonJob implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "personid")
    private Integer personid;
    
    @Basic(optional = false)
    @Column(name = "jobname")
    private String jobname;
    
    @Basic(optional = false)
    @Column(name = "company")
    private String company;
        
    @Column(name = "salary")
    private Double salary;
    
    @Column(name = "worksince")
    @Temporal(TemporalType.DATE)
    private Date worksince;
    

    public PersonJob() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getWorksince() {
        return worksince;
    }

    public void setWorksince(Date worksince) {
        this.worksince = worksince;
    }

    
    
    
}
