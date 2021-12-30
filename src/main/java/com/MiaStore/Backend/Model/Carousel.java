package com.MiaStore.Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
/*@NoArgsConstructor*/
@AllArgsConstructor
@Document(collection= "carousel")
public class Carousel implements Serializable {
    @Id
    private Integer id;
    private String title;
    private String paragraph;
    private String img;
}
