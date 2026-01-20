package com.openwebinars.web.task.model;

import com.openwebinars.web.category.model.Category;
import com.openwebinars.web.tag.model.Tag;
import com.openwebinars.web.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob// @Lob -> Para almacenar objetos grandes.
    private String description;

    private boolean completed;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    // Relación entre Task y Category.
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_task_category"))
    private Category category;

    // Relación entre Task y Tag
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "task_tag",
               joinColumns = @JoinColumn(name = "task_id"),
               foreignKey = @ForeignKey(name = "fk_task_tag_task"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"),
               inverseForeignKey = @ForeignKey(name = "fk_task_tag_tag"))
    @Builder.Default
    @Setter(AccessLevel.NONE)
    private Set<Tag> tags = new HashSet<>();

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_task_user"))
    private User author;

    // Métodos Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;
        return completed == task.completed && Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(createdAt, task.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, completed, createdAt);
    }
}
