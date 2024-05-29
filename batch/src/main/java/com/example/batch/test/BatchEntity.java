package com.example.batch.test;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BATCH_TEST")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class BatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Builder
    public BatchEntity(String name) {
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
