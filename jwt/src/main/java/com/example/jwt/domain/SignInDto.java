package com.example.jwt.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignInDto {
    private String username;
    private String password;
}