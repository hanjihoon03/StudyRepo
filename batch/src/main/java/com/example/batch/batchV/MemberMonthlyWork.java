package com.example.batch.batchV;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Entity
@Getter
@Setter
public class MemberMonthlyWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Column(name = "year_month", length = 8, nullable = false)
    private String yearMonth;

    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name= "hour", nullable = false)
    private Integer hour;

    @Column(name= "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

}
