package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {

    @Autowired
    RecoveryRoomService service;

    @GetMapping("/create")    
    public String showCreationForm(ModelMap model){
        RecoveryRoom r=new RecoveryRoom();
        model.put("recoveryRoom", r);
        return "recoveryroom/createOrUpdateRecoveryRoomForm";
    }


    @PostMapping("/create")    
    public String showCreationForm(@Valid RecoveryRoom room, BindingResult br,ModelMap model){
        if(br.hasErrors())
            return "recoveryroom/createOrUpdateRecoveryRoomForm";
        else{
            try {
                service.save(room);
            } catch (DuplicatedRoomNameException e) {
                e.printStackTrace();
                return "recoveryroom/createOrUpdateRecoveryRoomForm";                
            }            
        }            
        return "welcome";
        
    }
}
