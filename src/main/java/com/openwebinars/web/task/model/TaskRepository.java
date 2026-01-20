package com.openwebinars.web.task.model;

import com.openwebinars.web.category.model.Category;
import com.openwebinars.web.user.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAuthor(User user, Sort sort);
    List<Task> findByCategory(Category category);
    List<Task> findTaskByTitleContainingIgnoreCase(String q);
}
