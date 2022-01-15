package com.lival.repetition.memoryservice.entity;

import com.lival.repetition.memoryservice.enums.MemoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "memory")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoryDao {

    @Id
    @SequenceGenerator(name = "memory_seq", sequenceName = "memory_seq",  allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "memory_seq")
    @Column(name = "id")
    private Long id;

    private Long userId;
    private String text;
    private String links;

    @Enumerated(EnumType.STRING)
    private MemoryStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void setCreatedAt() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}