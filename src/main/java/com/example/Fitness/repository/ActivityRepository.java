package com.example.Fitness.repository;

import com.example.Fitness.modal.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity , String> {

}
