package jee.ensas.myagencyservice.controllers;

import jee.ensas.myagencyservice.dtos.AgencyDto;
import jee.ensas.myagencyservice.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Agency")
public class AgencyController {

    @Autowired
    AgencyService agencyService;

    @GetMapping("/getById")
    public AgencyDto getAgencyById(@RequestParam String agencyId){
        return agencyService.getAgencyById(agencyId);
    }

    @GetMapping("/getAll")
    public List<AgencyDto> getAllAgencies(){
        return agencyService.getAllAgencies();
    }

    @PostMapping("/add")
    public AgencyDto addAgency(@RequestBody AgencyDto agencyDto){
        return agencyService.addAgency(agencyDto);
    }
}
