package com.aliriza.DomesticTaskManager;

import com.aliriza.DomesticTaskManager.model.Status;
import com.aliriza.DomesticTaskManager.model.Task;
import com.aliriza.DomesticTaskManager.model.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class DomesticTaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomesticTaskManagerApplication.class, args);
	}


}
