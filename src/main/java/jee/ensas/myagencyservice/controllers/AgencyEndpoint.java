package jee.ensas.myagencyservice.controllers;

import io.spring.guides.gs_producing_web_service.GetAllAgenciesRequest;
import jee.ensas.myagencyservice.daos.*;
import jee.ensas.myagencyservice.repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@CrossOrigin(origins = "*")
public class AgencyEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private AgencyRepository agencyRepository;

    @Autowired
    public AgencyEndpoint(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAgencyByIdRequest")
    @ResponsePayload
    @CrossOrigin(origins = "*")
    public GetAgencyByIdResponse getAgencyById(@RequestPayload GetAgencyByIdRequest request) {
        GetAgencyByIdResponse response = new GetAgencyByIdResponse();
        response.setAgency(agencyRepository.findByName(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAgenciesRequest")
    @ResponsePayload
    @CrossOrigin(origins = "*")
    public GetAllAgenciesResponse getAllAgencies(@RequestPayload GetAllAgenciesRequest request) {
        GetAllAgenciesResponse response = new GetAllAgenciesResponse();
        response.setAgency(agencyRepository.findAll());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAgencyRequest")
    @ResponsePayload
    @CrossOrigin(origins = "*")
    public AddAgencyResponse addAgency(@RequestPayload AddAgencyRequest request) {
        AddAgencyResponse response = new AddAgencyResponse();
        Agency agency = new Agency();

        agency.setCity(request.getCity());
        agency.setLocation(request.getLocation());
        agency.setName(request.getName());

        agencyRepository.save(agency);
        response.setAgency(agency);
        return response;
    }

}