package com.usa.retociclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "cleaningproducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleaningProduct {

    @Id
    private Integer id;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private Double price;
    private Boolean availability = true;
    private Integer quantity;
    private String photography;
}