package com.aliriza.DomesticTaskManager.model;

import com.aliriza.DomesticTaskManager.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            TaskRepository repository){
        return args -> {
            Task Java = new Task(
                            1L,
                            "Java",
                            "You should learn Java.",
                            LocalDateTime.of(2022, 11, 14, 15, 0),
                            Type.TASK,
                            Status.NEW
                    );

                    Task Python = new Task(
                            2L,
                            "Python",
                            "If you learn Python, it will be very good.",
                            LocalDateTime.of(2022, 11, 7, 15, 0),
                            Type.BUG,
                            Status.IN_PROGRESS
                    );

                    Task Codes = new Task(
                            3L,
                            "Codes",
                            "If you write your code so short and clear, you are very developer.",
                            LocalDateTime.of(2022, 10, 24, 15, 0),
                            Type.FEATURE,
                            Status.DONE
                    );

                    repository.saveAll(
                            List.of(Java, Python, Codes)
                    );
        };
    }
}
