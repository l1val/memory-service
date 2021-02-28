package com.lival.repetition.coreservice.entity;

import com.lival.repetition.coreservice.enums.MemoryStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "memory")
public class Memory {

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
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}