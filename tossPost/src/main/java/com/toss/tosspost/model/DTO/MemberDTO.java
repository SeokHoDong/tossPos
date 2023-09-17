package com.toss.tosspost.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    @JsonProperty("MEM_ID")
    private String MEM_ID;

    @JsonProperty("MEM_PW")
    private String MEM_PW;

    @JsonProperty("id_SEQ")
    private String id_SEQ;
}
