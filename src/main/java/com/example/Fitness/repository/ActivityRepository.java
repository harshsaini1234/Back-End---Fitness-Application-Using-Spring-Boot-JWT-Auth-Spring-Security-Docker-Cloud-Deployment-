package com.example.Fitness.repository;

import com.example.Fitness.modal.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository <Activity,String>{

}
