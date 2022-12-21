package com.example.dhlee.domain;

import lombok.*;
import javax.persistence.*;

//user 테이블과 연결하는 클래스
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String emailAddress;

}
