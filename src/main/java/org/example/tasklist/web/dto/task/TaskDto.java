package org.example.tasklist.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.tasklist.domain.task.Status;
import org.example.tasklist.web.dto.validation.OnCreate;
import org.example.tasklist.web.dto.validation.OnUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private long id;

    @NotNull(message = "Title must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @Length(max = 255, message = "Description length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;

}
