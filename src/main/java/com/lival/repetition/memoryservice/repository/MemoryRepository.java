package com.lival.repetition.memoryservice.repository;

import com.lival.repetition.memoryservice.entity.MemoryDao;
import com.lival.repetition.memoryservice.enums.MemoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoryRepository extends JpaRepository<MemoryDao, Long> {

    List<MemoryDao> findAllByUserIdAndStatus(Long userId, MemoryStatus status);
}