package com.aliriza.DomesticTaskManager.repository;

import com.aliriza.DomesticTaskManager.model.Status;
import com.aliriza.DomesticTaskManager.model.Task;
import com.aliriza.DomesticTaskManager.model.Type;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

     @Query("SELECT s FROM Task s WHERE s.title = ?1")
    Optional<Task> findTaskByTitle(String title);

     public Long countById(Long id);

}