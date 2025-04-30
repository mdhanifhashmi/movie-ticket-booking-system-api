package com.example.mtb.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "theater_id", updatable = false, nullable = false)
    private String theaterId;

    @ManyToOne
    @JoinColumn(name = "theater_owner_id")
    private TheaterOwner theaterOwner;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screens;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "landmark", nullable = false)
    private String landmark;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Long updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = false)
    private String createBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "theater", fetch = FetchType.EAGER)
    private List<Show> shows;
}
