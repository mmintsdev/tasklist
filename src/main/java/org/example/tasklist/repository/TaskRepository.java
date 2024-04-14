package org.example.tasklist.repository;

import java.util.List;
import java.util.Optional;

import org.example.tasklist.domain.task.Task;

public interface TaskRepository {

    Optional<Task> findById(Long id);

    List<Task> findAllByUserId(Long userId);

    void assignToUserById(Long taskId, Long userId);

    void update(Task task);

    void create(Task task);

    void delete(Long id);

}
