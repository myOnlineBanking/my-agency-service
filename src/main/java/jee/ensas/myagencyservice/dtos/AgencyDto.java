package jee.ensas.myagencyservice.dtos;

import lombok.Data;


@Data
public class AgencyDto {

    private String id;
    private String name;
    private String location;
    private String city;
    private String idAgent;
    private String latitude;
    private String longitude;

}
