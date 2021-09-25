package com.broweser.automation.browserstack.controller;

import com.broweser.automation.browserstack.service.BrowserstackService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping(path="/app/v1")
public class BrowserstackController {
    Logger logger = Logger.getLogger(BrowserstackController.class.getName());

    BrowserstackService browserstackService = new BrowserstackService();

    @GetMapping(value = "/start")
    public void startBrowser(@RequestParam(value = "browser") String browser, @RequestParam(value = "url") String url){
        logger.info("calling startBrowser...");
        logger.info("brower  : " + browser);
        logger.info("url : " + url);
        boolean status =  browserstackService.startBrowser(browser, url);
        if(status){
            logger.info("started the browser successfully");
        } else{
            logger.info("error occurred during opening browser");
        }
    }

    @GetMapping("/stop")
    public void stopBrowswer(@RequestParam(value = "browser") String browser) throws IOException {
        logger.info("calling stopBrowser...");

        browserstackService.stopBrowswer(browser);
    }

    @GetMapping("/cleanup")
    public void cleanupBrowser(@RequestParam(value = "browser") String browser){
        logger.info("calling cleanupBrowser...");
        browserstackService.cleanupBrowser(browser);
    }

    @GetMapping("/geturl")
    public void getActiveTab(@RequestParam(value = "browser") String browser){
        logger.info("calling getActiveTabBrowser...");
        browserstackService.getActiveTab(browser);
    }


}
