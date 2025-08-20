package com.RestfulAPIs.RestfulAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // constructor with parameters
@Data // getters and setters
public class StudentDTO {
    private long id;
    private String name;
    private String email;
}
