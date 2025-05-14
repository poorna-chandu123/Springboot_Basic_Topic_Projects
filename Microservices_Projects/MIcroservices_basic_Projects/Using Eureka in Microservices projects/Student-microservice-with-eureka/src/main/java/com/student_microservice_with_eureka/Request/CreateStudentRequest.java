package com.student_microservice_with_eureka.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateStudentRequest {

    private String firstName;

    private String lastName;

    private String email;

    private long addressId;
}
