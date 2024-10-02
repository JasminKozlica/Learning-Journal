package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomGrantedAuthority implements GrantedAuthority {

    private RoleName roleName;

    @Override
    public String getAuthority() {
        return roleName.name();
    }
}
