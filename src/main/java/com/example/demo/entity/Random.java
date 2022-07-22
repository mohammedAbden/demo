package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "random")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Random {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

}
