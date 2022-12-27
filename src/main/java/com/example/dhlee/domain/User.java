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
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //인덱스값
    private int user_id;

    @Column(nullable = false, unique = true) //유저네임 (토큰생성)
    private String user_name;

    @Column(nullable = false) //비밀번호
    private String password;

    @Column
    private LocalDateTime registered_at;

    @Column
    private LocalDateTime updated_at;

    @Column
    private LocalDateTime removed_at;

    @Column
    private int role; //1 : normal, 2 : admin



}
