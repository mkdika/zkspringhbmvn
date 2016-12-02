package com.mkdika.zkspringhbmvn.ui.web;

import com.mkdika.zkspringhbmvn.entity.Person;
import com.mkdika.zkspringhbmvn.helper.AppUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

/**
 *
 * @author maikel
 */
public class IndexVm {

    private final String appInfo = "ZK Spring Hibernate CRUD Single Table [Maven]";
    private final String[] genderData = {"FEMALE", "MALE"};

    private Person selected;
    private List<Person> lists;
    private List<String> genderList;

    public IndexVm() {

    }

    @Init
    public void init() {
        setGenderList(new ArrayList<>(Arrays.asList(genderData)));
        getLists();
    }

    @Command
    @NotifyChange({"selected", "lists"})
    public void addClick() {
        setSelected(new Person());
    }

    @Command
    @NotifyChange({"selected", "lists"})
    public void delClick() {
        if (getSelected() != null) {
            try {
                if (AppUtil.getWebService().delete(getSelected())) {
                    setSelected(null);
                    Clients.showNotification("Delete successful.");
                } else {
                    Clients.showNotification("Delete failed.");
                }
            } catch (Exception e) {
                Clients.showNotification("Delete failed.\n" + e.getLocalizedMessage());
            }
        } else {
            Clients.showNotification("Record not found.");
        }
    }

    @Command
    @NotifyChange({"selected", "lists"})
    public void saveClick() {
        try {
            if (AppUtil.getWebService().save(getSelected())) {
                setSelected(null);
                getLists();
                Clients.showNotification("Save successful.");
            }
        } catch (Exception e) {
            Clients.showNotification("Save failed.\n" + e.getLocalizedMessage());
        }
    }

    @Command
    @NotifyChange({"selected", "lists"})
    public void cancelClick() {
        setSelected(null);
    }

    @Command
    public void infoClick() {
        Clients.showNotification(appInfo + "<br/>" + "First version writen by:<br/>Maikel Chandika (mkdika@gmail.com)");
    }

    @Command
    @NotifyChange("lists")
    public void refreshClick() {
        setLists(AppUtil.getWebService().getPersons());
    }

    // ============== Setter & Getter ====================
    public Person getSelected() {
        return selected;
    }

    public void setSelected(Person selected) {
        this.selected = selected;
    }

    public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public List<Person> getLists() {
        lists = AppUtil.getWebService().getPersons();
        return lists;
    }

    public void setLists(List<Person> lists) {
        this.lists = lists;
    }
}
