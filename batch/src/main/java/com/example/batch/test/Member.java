package com.example.batch.test;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "mileage", nullable = false)
    private int mileage;

    public Member(String name, String grade, int mileage) {
        this.name = name;
        this.grade = grade;
        this.mileage = mileage;
    }
}
