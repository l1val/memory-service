package com.lival.repetition.memoryservice.model;

import com.lival.repetition.memoryservice.enums.MemoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Memory {
    private Long id;
    private Long userId;
    private String text;
    private String links;
    private MemoryStatus status;
}