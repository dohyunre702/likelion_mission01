package com.example.dhlee.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(length = 300)
    private String body;

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime last_modified_at;

}
