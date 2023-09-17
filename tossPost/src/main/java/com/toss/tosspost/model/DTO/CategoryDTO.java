package com.toss.tosspost.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoryDTO {

    @JsonProperty("CATG_SEQ")
    private int CATG_SEQ;

    @JsonProperty("ID_SEQ")
    private int ID_SEQ;

    @JsonProperty("CATG_NM")
    private String CATG_NM;

}
