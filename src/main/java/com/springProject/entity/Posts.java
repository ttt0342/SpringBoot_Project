package com.springProject.entity;

import java.sql.Timestamp;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posts {

    @Id @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column
    private String category;

    @Column
    private String location;

    @Column
    private Integer star;

    @Column
    private String hashtags;

    @Column
    private Timestamp created_at;

    @Column
    private Timestamp updated_at;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
    private List<Comments> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @Column(name = "isNotice")
    private boolean isNotice;

    @Column(nullable = false)
    private Long post_id;

}
