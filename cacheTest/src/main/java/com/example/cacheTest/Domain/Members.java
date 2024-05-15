package com.example.cacheTest.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Members {
    private List<Member> members = new ArrayList<>();

    public Members(List<Member> members) {
        this.members = members;
    }
}
