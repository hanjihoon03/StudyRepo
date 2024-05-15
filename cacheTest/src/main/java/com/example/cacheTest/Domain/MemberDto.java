package com.example.cacheTest.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private String name;
    private Integer age;

    public MemberDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
