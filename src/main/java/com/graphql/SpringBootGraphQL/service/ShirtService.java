package com.graphql.SpringBootGraphQL.service;

import com.graphql.SpringBootGraphQL.domain.Shirt;
import com.graphql.SpringBootGraphQL.repository.ShirtRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ShirtService {

    @Autowired
    ShirtRepository shirtRepository;

    public Shirt getShirtById(String id) {
        log.info("Getting shirt {} from the repository.", id);

        Optional<Shirt> optionalShirt = shirtRepository.findById(id);

        if(optionalShirt == null || optionalShirt.get() == null) {
            log.info("No shirt found by id {}.", id);
            return null;
        }

        Shirt shirt = optionalShirt.get();
        log.info("found shirt by description {}", shirt.getDescription());
        return shirt;
    }

    public List<Shirt> getShirtByDescription(String description) {
        log.info("Getting shirt {} from the repository.", description);

        List<Shirt> shirtList = shirtRepository.findByDescription(description);

        if (CollectionUtils.isEmpty(shirtList)) {
            log.info("No shirt found by description {}", description);
            return new ArrayList<Shirt>();
        }
        log.info("found {} shirts by description {}", shirtList.size(), description);
        return shirtList;
    }

    public Shirt addShirt(Shirt shirt) {
        log.info("Adding shirt {} to database", shirt.getDescription());
        Shirt shirt2 = shirtRepository.insert(shirt);
        log.info("Added shirt {} successfully", shirt2.getDescription());
        return shirt2;
    }
}
