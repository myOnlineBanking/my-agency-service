package jee.ensas.myagencyservice.repositories;


import jee.ensas.myagencyservice.daos.Agency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface AgencyRepository extends MongoRepository<Agency, String> {
    Agency findByName(String name);
    Optional<Agency> findById(String id);
    List<Agency> findAll();
}