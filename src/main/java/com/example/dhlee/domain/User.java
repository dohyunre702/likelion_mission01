package com.example.dhlee.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

//user 테이블과 연결하는 클래스
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //인덱스값
    private Long id;

    @Column(nullable = false, unique = true) //token 생성 위한 유저id
    private String uid;

    @Column(nullable = false) //비밀번호
    private String password;

    @Column(nullable = false, unique = true) //유저닉네임
    private String userName;

    @Column(nullable = false) //이메일주소
    private String emailAddress;

    /*
    @Column
    private LocalDateTime registeredAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;
     */

}
