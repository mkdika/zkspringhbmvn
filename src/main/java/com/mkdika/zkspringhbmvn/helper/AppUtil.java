package com.mkdika.zkspringhbmvn.helper;

import com.mkdika.zkspringhbmvn.service.ServiceDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zkoss.zkplus.spring.SpringUtil;

/**
 *
 * @author Maikel
 */
public class AppUtil {
 
    // HANYA DIGUNAKAN UNTUK PEMANGILAN DI UI.CLI
    private static ApplicationContext context;    
    private static ServiceDao service;
    
    
    // HANYA DIGUNAKAN UNTUK PEMANGILAN DI UI.WEB
    private static ServiceDao webService;
    
    /*
    HANYA DIGUNAKAN UNTUK PEMANGILAN DI UI.WEB
    Singleton pattern pada load serviceDao dari yang telah diregistrasi di
    Spring applicationContext.xml. Karena pengunaan di context Web, maka untuk 
    mempermudah pemangilan dapat digunakan API SpringUtil bawaan dari 
    Zk Framework.
    */
    public static ServiceDao getWebService() {
        if (webService == null) {
            webService = (ServiceDao) SpringUtil.getBean("serviceDao");
        }
        return webService;
    }      
    
        
    /*
    HANYA DIGUNAKAN UNTUK PEMANGILAN DI UI.CLI
    Singleton pattern pada load spring context & config.
    Supaya efisien instance spring bisa dipakai berulang" dimana saja.
    Namun load aplication context ini cukup dilakukan 1x pada saat aplikasi
    startup.
    */
    private static ApplicationContext getSpringContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        }
        return context;
    }
    
    /*
    HANYA DIGUNAKAN UNTUK PEMANGILAN DI UI.CLI
    Singleton pattern pada load serviceDao dari yang telah diregistrasi di
    Spring applicationContext.xml. Supaya efisien, instance hanya akan digenerate
    sekali dan bisa dipanggil langsung (static method) berulang" kali pada 
    semua program aplikasi.    
    */
    public static ServiceDao getService() {
        if (service == null) {
            service = (ServiceDao) getSpringContext().getBean("serviceDao");
        }
        return service;
    }    
}
