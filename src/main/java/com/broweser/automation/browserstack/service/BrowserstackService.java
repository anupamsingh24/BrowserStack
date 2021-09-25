package com.broweser.automation.browserstack.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class BrowserstackService {
    Logger logger = Logger.getLogger(BrowserstackService.class.getName());
    public static final String FIREFOX_LOCATION = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    public static final String CHROME_HANDLER = "rundll32 url.dll,FileProtocolHandler ";
    public final Runtime rt = Runtime.getRuntime();
    public Process proc = null;

    public boolean startBrowser(String browser, String url){
        String browserOpen = browser.toLowerCase();
        String urlOpen = url.toLowerCase();

        try {

            if(browser.equals("chrome")){
                proc = rt.exec(CHROME_HANDLER + url);
            } else if(browser.equals("firefox")){
                proc = rt.exec(FIREFOX_LOCATION + url);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        if(proc.isAlive()) {
            return true;
        } else {
            return false;
        }
    }

    public void stopBrowswer(String browser) throws IOException {
//        long pid = getPid(proc);
//        logger.info("process pid:" + pid);
//        rt.exec("taskkill /F /IM " + "chrome");
        proc.destroy();
    }

    public void cleanupBrowser(String browser){

    }

    public void getActiveTab(String browser){

    }

    public static int getPid(Process process) {
        try {
            Class<?> cProcessImpl = process.getClass();
            Field fPid = cProcessImpl.getDeclaredField("pid");
            if (!fPid.isAccessible()) {
                fPid.setAccessible(true);
            }
            return fPid.getInt(process);
        } catch (Exception e) {
            return -1;
        }
    }

}
