package com.example.booking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "First name cannot be empty")
    @Pattern.List({
        @Pattern(regexp = "[A-Z].*", message = "First name must start out of a letter in uppercase"),
        @Pattern(regexp = "[A-Za-z]+", message = "First name may contain only letters"),
        @Pattern(regexp = "^(?!.*(.)\\1{4}).*$", message = "Same character cannot repeat 5 times or more")
    })
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Pattern.List({
        @Pattern(regexp = "[A-Z].*", message = "Last name must start out of a letter in uppercase"),
        @Pattern(regexp = "[A-Za-z]+", message = "Last name may contain only letters"),
        @Pattern(regexp = "^(?!.*(.)\\1{4}).*$", message = "Same character cannot repeat 5 times or more")
    })
    private String lastName;

    @NotEmpty(message = "Gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    private LocalDate dateOfBirth;

    @Column(unique = true)
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotEmpty(message = "Address cannot be empty")
    @Size(min = 5, message = "The entered address seems to be too short")
    private String address;

    @NotEmpty(message = "ID number cannot be empty")
    @Size(min = 5, message = "The entered ID number seems to be too short")
    private String idNumber;

    public User(
            long id,
            String firstName,
            String lastName,
            String gender,
            LocalDate dateOfBirth,
            String email,
            String address,
            String idNumber,
            String profileImage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.idNumber = idNumber;
    }

    public User() {}

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getIdNumber() {
        return idNumber;
    }
    //    @Override
    //    public boolean isAccountNonExpired() {
    //        return true;
    //    }
    //
    //    @Override
    //    public boolean isAccountNonLocked() {
    //        return true;
    //    }
    //
    //    @Override
    //    public boolean isCredentialsNonExpired() {
    //        return true;
    //    }
    //
    //    @Override
    //    public boolean isEnabled() {
    //        return true;
    //    }
}
