package com.example.dhlee.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//user 테이블과 연결하는 클래스
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User implements UserDetails {

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

    @Column
    private LocalDateTime registeredAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

    @ElementCollection(fetch = FetchType.EAGER) //컬렉션객체임을 jpa에게 announce
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //계정이 가진 권한 목록 리턴
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty //key값 매핑해 jpa로 전달
    @Override
    public String getUsername() { //계정 이름(아이디) 리턴
        return this.uid;
    }

    @JsonProperty
    @Override
    public boolean isAccountNonExpired() { //계정 만료여부 리턴
        return false;
    }

    @JsonProperty
    @Override
    public boolean isAccountNonLocked() { //계정 잠겨있는지 리턴
        return false;
    }

    @JsonProperty
    @Override
    public boolean isCredentialsNonExpired() { //비밀번호 만료여부 리턴
        return false;
    }

    @JsonProperty
    @Override
    public boolean isEnabled() { //계정 잠겨있는지 리턴
        return false;
    }
}
