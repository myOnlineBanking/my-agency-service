package jee.ensas.myagencyservice.services;

import jee.ensas.myagencyservice.dtos.AgencyDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface AgencyService {

    AgencyDto getAgencyById(@RequestParam String agencyId);

    List<AgencyDto> getAllAgencies();

    AgencyDto addAgency(@RequestBody AgencyDto agencyDto);
}
