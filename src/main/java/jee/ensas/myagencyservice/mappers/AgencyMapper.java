package jee.ensas.myagencyservice.mappers;

import jee.ensas.myagencyservice.daos.Agency;
import jee.ensas.myagencyservice.dtos.AgencyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgencyMapper {

    public AgencyDto map(Agency agency) {

        AgencyDto agencyDto = new AgencyDto();

        agencyDto.setCity(agency.getCity());
        agencyDto.setLocation(agency.getLocation());
        agencyDto.setName(agency.getName());
        agencyDto.setId(agency.getId());
        agencyDto.setIdAgent(agency.getIdAgent());
        agencyDto.setLatitude(agency.getLatitude());
        agencyDto.setLongitude(agency.getLongitude());


        return agencyDto;
    }

    public Agency map(AgencyDto agencyDto) {

        Agency agency = new Agency();

        agency.setCity(agencyDto.getCity());
        agency.setLocation(agencyDto.getLocation());
        agency.setName(agencyDto.getName());
        agency.setId(agencyDto.getId());
        agency.setIdAgent(agencyDto.getIdAgent());
        agency.setLatitude(agencyDto.getLatitude());
        agency.setLongitude(agencyDto.getLongitude());

        return agency;
    }

    public List<AgencyDto> map(List<Agency> agencys) {

        return  agencys
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public List<Agency> toMap(List<AgencyDto> agencyDtos) {

        return  agencyDtos
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }



}
