package com.artur.assignment.controllers.patternControllers;

import com.artur.assignment.service.patternServices.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/observer")
public class ObserverController {
    private SubscriptionService sService;

    @GetMapping("/selectSubscriptions")
    public String  selectSubscriptions(){

        return"observer/subscriptionPage";
    }

    @GetMapping("/checkUpdates")
    public String  checkForUpdates(){

        return"observer/updatesPage";
    }

    @GetMapping("/updateTopic")
    public String  updateNews(){

        return"observer/newMessagePage";
    }

}
