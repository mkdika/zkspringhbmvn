package com.mkdika.zkspringhbmvn.ui.web;

import com.mkdika.zkspringhbmvn.entity.Person;
import com.mkdika.zkspringhbmvn.helper.AppUtil;
import com.mkdika.zkspringhbmvn.ui.web.template.CrudFormTemplate;
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
public class Menu02Vm extends CrudFormTemplate {

    private final String appInfo = "ZK Spring Hibernate CRUD Single Table [Maven] (Toolbar Template)";
    private final String[] genderData = {"FEMALE", "MALE"};

    private Person selected;
    private List<Person> lists;
    private List<String> genderList;

    public Menu02Vm() {
    }

    @Init()
    public void init() {
        super.init();
        setVisibleRefresh(false);
        setVisibleInfo(true);

        setGenderList(new ArrayList<>(Arrays.asList(genderData)));
        getLists();
    }

    @Command
    @Override
    @NotifyChange({"selected", "lists"})
    public void addClick() {
        setSelected(new Person());
        super.addClick();          
    }

    @Override
    @Command
    public void selectedRecord() {
        super.selectedRecord();
    }
        
    @Command
    @Override
    public void editClick() {
        super.editClick();
    }

    @Command
    @Override
    @NotifyChange({"selected", "lists"})
    public void deleteClick() {
        if (getSelected() != null) {
            try {
                if (AppUtil.getWebService().delete(getSelected())) {
                    setSelected(null);
                    super.deleteClick();
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
    @Override
    @NotifyChange({"selected", "lists"})
    public void saveClick() {
        try {
            if (AppUtil.getWebService().save(getSelected())) {
                setSelected(null);
                getLists();
                super.saveClick();
                Clients.showNotification("Save successful.");
            }
        } catch (Exception e) {
            Clients.showNotification("Save failed.\n" + e.getLocalizedMessage());
        }
    }

    @Command
    @Override
    @NotifyChange({"selected", "lists"})
    public void cancelClick() {
        setSelected(null);
        super.cancelClick();
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
