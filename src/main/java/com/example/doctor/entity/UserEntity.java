package com.example.doctor.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static com.example.doctor.validationConstants.RegexConstants.VALIDATION_CONSTANT_TYPE_OF_PHONE_NUMBER;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name")
//    @NotBlank
    private String userName;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Email
    @Column(name = "email")
    @NotBlank
    private String email;

    @Column(name = "password")
    @Size(min = 8, message = "at least 8 characters")
    @NotBlank
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(name = "phone_number")
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_PHONE_NUMBER, message = " Should contain real phone number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "verification")
    private Boolean verification;

    @Column(name = "verification_hash")
    private String verificationHash;

    @Column(name = "description")
    private String description;

}
