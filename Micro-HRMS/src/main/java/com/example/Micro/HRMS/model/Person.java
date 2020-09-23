package com.example.Micro.HRMS.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    private final UUID id;

    @NotBlank
    private final String name;
    private final String email;
    private final String phone;
    private final String team;
    private final String role;
    private final String doj;


    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("email") String email,
                  @JsonProperty("phone") String phone,
                  @JsonProperty("team") String team,
                  @JsonProperty("role") String role,
                  @JsonProperty("doj") String doj
                  ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.team = team;
        this.doj = doj;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getTeam() {
        return team;
    }

    public String getRole() {
        return role;
    }

    public String getDoj() {
        return doj;
    }
}

