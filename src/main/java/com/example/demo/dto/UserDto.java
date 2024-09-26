package com.example.demo.dto;

import com.example.demo.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

    private String name;

    private String email;

    private RoleName role;

    private String password;

}
