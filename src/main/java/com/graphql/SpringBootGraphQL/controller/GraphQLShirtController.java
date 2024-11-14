package com.graphql.SpringBootGraphQL.controller;

import com.graphql.SpringBootGraphQL.domain.Shirt;
import com.graphql.SpringBootGraphQL.service.ShirtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class GraphQLShirtController {

    @Autowired
    ShirtService shirtService;

    //@Autowired
    //DesignService designService;

    @QueryMapping
    public Shirt shirtById(@Argument String id) {
        log.info("Quering shirt in GraphQL bi id {}", id);
        Shirt shirt = shirtService.getShirtById(id);
        return shirt;
    }

    @QueryMapping
    public Shirt shirtByDescription(@Argument String description) {
        log.info("Quering shirt in GraphQL Server by description {}", description);
        Shirt shirt = shirtService.getShirtByDescription(description).get(0);
        return shirt;
    }

    @MutationMapping
    public Shirt addShirt(@Argument String description, @Argument List<String> size, @Argument Boolean available,
                          @Argument List<String> color, @Argument int price, @Argument String img_url){
        Shirt shirt = new Shirt();
        shirt.setId(UUID.randomUUID().toString());
        shirt.setDescription(description);
        shirt.setSize(size);
        shirt.setAvailable(available);
        shirt.setColor(color);
        shirt.setPrice(price);
        shirt.setImg_url(img_url);

        shirtService.addShirt(shirt);

        return shirt;
    }
}
