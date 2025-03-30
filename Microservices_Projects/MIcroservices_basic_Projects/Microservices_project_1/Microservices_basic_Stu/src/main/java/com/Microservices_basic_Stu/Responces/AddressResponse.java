package com.Microservices_basic_Stu.Responces;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressResponse {

    @JsonProperty("addid")
    private long AddressId;
    @JsonProperty("state_name")
    private String state;

    private String city;
}
