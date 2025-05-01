package com.example.mtb.entity;

import com.example.mtb.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.security.PrivateKey;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Setter
@Getter
@Table(name = "user_detail")
@EntityListeners(AuditingEntityListener.class)
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", updatable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "is_delete")
    private boolean isDelete;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "update_at", updatable = true)
    private Instant updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

}
