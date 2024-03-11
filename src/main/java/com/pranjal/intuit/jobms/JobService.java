package com.pranjal.intuit.jobms;

import com.pranjal.intuit.jobms.Job;
import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

}
