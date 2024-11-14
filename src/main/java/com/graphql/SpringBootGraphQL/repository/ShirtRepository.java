package com.graphql.SpringBootGraphQL.repository;

import com.graphql.SpringBootGraphQL.domain.Shirt;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShirtRepository extends MongoRepository<Shirt, String> {
    List<Shirt> findByDescription(String description);
}
