package com.mkdika.zkspringhbmvn.ui.web.template;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.DefaultCommand;
import org.zkoss.zk.ui.util.Clients;

/**
 *
 * @author maikel
 */
public abstract class CrudFormTemplate {
    
    private boolean visibleAdd = false;
    private boolean visibleEdit = false;
    private boolean visibleDelete = false;
    private boolean visibleSave = false;
    private boolean visibleCancel = false;   
    private boolean visibleRefresh = true;    
    private boolean visibleInfo = true;

    public void init() {        
        normalButtonState();
    }

    // toolbar command    
    public void addClick() {
        addButtonState();
    }

    public void editClick() {
        editButtonState();
    }

    public void deleteClick() {
        normalButtonState();
    }

    public void saveClick() {
        normalButtonState();
    }

    public void cancelClick() {
        normalButtonState();
    }

    public void refreshClick() {

    }

    public void infoClick() {

    }
    
    public void selectedRecord() {
        selectButtonState();
    }

    @DefaultCommand
    public void defaultCommand() {
        Clients.showNotification("Features is not implemented.");
    }

    public void normalButtonState() {
        setVisibleAdd(true);
        setVisibleEdit(false);
        setVisibleDelete(false);
        setVisibleSave(false);
        setVisibleCancel(false);
    }

    public void addButtonState() {
        setVisibleAdd(false);
        setVisibleEdit(false);
        setVisibleDelete(false);
        setVisibleSave(true);
        setVisibleCancel(true);
    }

    public void selectButtonState() {
        setVisibleAdd(false);
        setVisibleEdit(true);
        setVisibleDelete(false);
        setVisibleSave(false);
        setVisibleCancel(true);
    }

    public void editButtonState() {
        setVisibleAdd(false);
        setVisibleEdit(false);
        setVisibleDelete(true);
        setVisibleSave(true);
        setVisibleCancel(true);
    }

    // ------------ SETTER & GETTER ---------------------------
    public boolean isVisibleRefresh() {
        return visibleRefresh;
    }

    public void setVisibleRefresh(boolean visibleRefresh) {
        this.visibleRefresh = visibleRefresh;        
        BindUtils.postNotifyChange(null,null,this,"visibleRefresh");
    }

    public boolean isVisibleInfo() {
        return visibleInfo;
    }

    public void setVisibleInfo(boolean visibleInfo) {
        this.visibleInfo = visibleInfo;        
        BindUtils.postNotifyChange(null,null,this,"visibleInfo");
    }

    public boolean isVisibleAdd() {
        return visibleAdd;
    }

    public void setVisibleAdd(boolean visibleAdd) {
        this.visibleAdd = visibleAdd;        
        BindUtils.postNotifyChange(null,null,this,"visibleAdd");
    }

    public boolean isVisibleEdit() {
        return visibleEdit;
    }

    public void setVisibleEdit(boolean visibleEdit) {
        this.visibleEdit = visibleEdit;        
        BindUtils.postNotifyChange(null,null,this,"visibleEdit");
    }

    public boolean isVisibleDelete() {
        return visibleDelete;
    }

    public void setVisibleDelete(boolean visibleDelete) {
        this.visibleDelete = visibleDelete;        
        BindUtils.postNotifyChange(null,null,this,"visibleDelete");
    }

    public boolean isVisibleSave() {
        return visibleSave;
    }

    public void setVisibleSave(boolean visibleSave) {
        this.visibleSave = visibleSave;        
        BindUtils.postNotifyChange(null,null,this,"visibleSave");
    }
   
    public boolean isVisibleCancel() {
        return visibleCancel;
    }

    public void setVisibleCancel(boolean visibleCancel) {
        this.visibleCancel = visibleCancel;        
        BindUtils.postNotifyChange(null,null,this,"visibleCancel");
    }
}
