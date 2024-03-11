package com.pranjal.intuit.companyms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pranjal.intuit.jobms.Job;
import com.pranjal.intuit.reviewms.Review;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String description;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Job> jobs;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Review> reviews;

}