package com.RestfulAPIs.RestfulAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentDTO {
    private String name;
    private String email;
}
