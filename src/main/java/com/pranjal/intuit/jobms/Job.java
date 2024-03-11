package com.pranjal.intuit.jobms;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pranjal.intuit.companyms.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job")

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private String minSalary;
    @NotNull
    private String maxSalary;
    @NotNull
    private String location;

    @ManyToOne
    private Company company;


}
