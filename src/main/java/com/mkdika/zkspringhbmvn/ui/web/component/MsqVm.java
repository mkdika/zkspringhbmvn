package com.mkdika.zkspringhbmvn.ui.web.component;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author maikel
 */
public class MsqVm {
    
    @Wire("#msqDialog")
    Window msqDialog;

    private String content;

    private String bindMethodYes;
    private String bindMethodNo;

    public MsqVm() {

    }
    
    // for use to wire frontend component
    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
    }

    @Init
    public void init(@ExecutionArgParam("sContent") String content,
                     @ExecutionArgParam("sBindMethodYes") String bindMethodYes,
                     @ExecutionArgParam("sBindMethodNo") String bindMethodNo) {
        this.content = content;
        this.bindMethodYes = bindMethodYes;
        this.bindMethodNo = bindMethodNo;    
        setContent(content);
    }
    
    @Command
    public void btnYesAction() {
        if (bindMethodYes != null && !bindMethodYes.isEmpty()) {
             BindUtils.postGlobalCommand(null, null, bindMethodYes, null);
        }
        msqDialog.onClose();
    }
    
    @Command
    public void btnNoAction() {
        if (bindMethodNo != null && !bindMethodNo.isEmpty()) {
             BindUtils.postGlobalCommand(null, null, bindMethodNo, null);
        }
        msqDialog.onClose();
    }

    // ==================== SETTER & GETTER ===================================   
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
