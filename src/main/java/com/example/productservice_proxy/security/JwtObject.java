package com.example.productservice_proxy.security;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JwtObject {

    String email;
    Long userId;
    Date createdAt;
    Date expiryAt;
    List<Role> roles = new ArrayList<>();
}
