package com.artur.assignment.controllers.patternControllers;

import com.artur.assignment.model.UserAccount;
import com.artur.assignment.service.patternServices.StateService;
import com.artur.assignment.state.AccountState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/state")
public class StateController {
    private StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/file")
    public String fileView(@ModelAttribute("account") UserAccount account){
        return "state/file";
    }

    @GetMapping("/newFile")
    public String createNewFile(@ModelAttribute("account")UserAccount account){
        stateService.setState(account.getStatus());
        stateService.createFile();
        return "state/newFile";
    }

    @GetMapping("/readFile")
    public String readFile(@ModelAttribute("account")UserAccount account){
        stateService.setState(account.getStatus());
        stateService.readFile();
        return "state/readFile";
    }

    @GetMapping("/modifyFile")
    public String modifyFile(@ModelAttribute("account")UserAccount account){
        stateService.setState(account.getStatus());
        stateService.modifyFile();
        return "state/modifyFile";
    }
}
