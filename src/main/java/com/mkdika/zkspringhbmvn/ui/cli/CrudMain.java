package com.mkdika.zkspringhbmvn.ui.cli;

import com.mkdika.zkspringhbmvn.entity.Person;
import com.mkdika.zkspringhbmvn.helper.AppUtil;
import java.util.Date;

/**
 *
 * @author Maikel
 */
public class CrudMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CLEAR EXISTING DB DATA MANUALLY
        if (AppUtil.getService().truncateDb()) {
            System.out.println("Truncate existing DB Data done!");
        }
        System.out.println("");

        // CREATE / INSERT
        Person p1 = new Person();
        p1.setPersonname("Maikel Chandika");
        p1.setBirthday(new Date());
        p1.setEmail("mkdika@gmail.com");
        p1.setGender(1);
        if (AppUtil.getService().save(p1)) {
            System.out.println("Save p1 successful!");
        }
        System.out.println("");

        // UPDATE
        p1.setEmail("xxxx@gmail.com");
        if (AppUtil.getService().save(p1)) {
            System.out.println("update p1 successful!");
        }
        System.out.println("");

        // READ 
        Person p2 = AppUtil.getService().getPersons().get(0);
        System.out.println("Table Index 0/ Top 1");
        System.out.println("Person Name: " + p2.getPersonname());
        System.out.println("Birthday   : " + p2.getBirthday());
        System.out.println("Email      : " + p2.getEmail());
        System.out.println("Gender     : " + p2.getGender());
        
        // DELETE
//        if (AppUtil.getService().delete(p2)) {
//            System.out.println("Delete done!");
//        }
//        System.out.println("");
        
        // QUERY ALL
        System.out.println("Currernt DB Size: " + AppUtil.getService().getPersons().size());

    }

}
