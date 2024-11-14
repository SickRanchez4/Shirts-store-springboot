package com.graphql.SpringBootGraphQL.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class Shirt {
    @Id
    private String id;

    private String description;

    private List<String> size;

    private boolean available;

    private List<String> color;

    private int price;

    private String img_url;
}
