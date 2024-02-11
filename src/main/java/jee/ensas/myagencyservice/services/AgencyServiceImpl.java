package jee.ensas.myagencyservice.services;

import jee.ensas.myagencyservice.dtos.AgencyDto;
import jee.ensas.myagencyservice.mappers.AgencyMapper;
import jee.ensas.myagencyservice.repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService{

    @Autowired
    AgencyRepository agencyRepository;

    @Autowired
    AgencyMapper agencyMapper;

    @Override
    public AgencyDto getAgencyById(String agencyId) {
        return agencyMapper.map(agencyRepository.findById(agencyId).orElse(null));
    }

    @Override
    public List<AgencyDto> getAllAgencies() {
        return agencyMapper.map(agencyRepository.findAll());
    }

    @Override
    public AgencyDto addAgency(AgencyDto agencyDto) {
        return agencyMapper.map(agencyRepository.save(agencyMapper.map(agencyDto)));
    }
}
