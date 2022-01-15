package com.lival.repetition.memoryservice.service;

import com.lival.repetition.memoryservice.enums.MemoryStatus;
import com.lival.repetition.memoryservice.model.Memory;

import java.util.List;

public interface MemoryService {
    Memory getMemoryById(Long id);

    List<Memory> getMemoryByUserIdAndStatus(Long userId, MemoryStatus status);

    void deleteMemoryById(Long id);

    long createMemory(Memory memory);

    void updateMemory(Memory memory);
}