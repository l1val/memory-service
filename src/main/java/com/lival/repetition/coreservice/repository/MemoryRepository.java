package com.lival.repetition.coreservice.repository;

import com.lival.repetition.coreservice.entity.Memory;
import com.lival.repetition.coreservice.enums.MemoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {

    List<Memory> findAllByUserIdAndStatus(Long userId, MemoryStatus status);
}