package com.lival.repetition.memoryservice.service;

import com.lival.repetition.memoryservice.entity.MemoryDao;
import com.lival.repetition.memoryservice.enums.MemoryStatus;
import com.lival.repetition.memoryservice.exception.MemoryNotFoundException;
import com.lival.repetition.memoryservice.model.Memory;
import com.lival.repetition.memoryservice.repository.MemoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class MemoryServiceImpl implements MemoryService {

    private final MemoryRepository memoryRepository;
    private final ConversionService conversionService;

    @Override
    public Memory getMemoryById(Long id) {
        Objects.requireNonNull(id, "Для получения memory нужен id");
        MemoryDao memoryDao = memoryRepository.findById(id).orElseThrow(() -> new MemoryNotFoundException(id));

        return conversionService.convert(memoryDao, Memory.class);
    }

    @Override
    public List<Memory> getMemoryByUserIdAndStatus(Long userId, MemoryStatus status) {
        Objects.requireNonNull(userId, "Для получения memory нужен userId");
        Objects.requireNonNull(status, "Для получения memory нужен status");
        List<MemoryDao> memoryDaoList = memoryRepository.findAllByUserIdAndStatus(userId, status);

        return conversionService.convert(memoryDaoList, List.class);
    }

    @Override
    public void deleteMemoryById(Long id) {
        Objects.requireNonNull(id, "Для удаления memory нужен id");
        memoryRepository.deleteById(id);
    }

    @Override
    public long createMemory(Memory memory) {
        Objects.requireNonNull(memory, "memory не должно быть null при создании");
        MemoryDao memoryDao = memoryRepository.save(Objects.requireNonNull(conversionService.convert(memory, MemoryDao.class)));
        return memoryDao.getId();
    }

    @Override
    public void updateMemory(Memory memory) {
        Objects.requireNonNull(memory, "memory не должно быть null при обновлении");
        Objects.requireNonNull(memory.getId(), "Для обновления memory нужен id");
        MemoryDao patch = conversionService.convert(memory, MemoryDao.class);
        MemoryDao memoryDao = memoryRepository.findById(Objects.requireNonNull(patch).getId()).orElseThrow(() -> new MemoryNotFoundException(patch.getId()));

        memoryRepository.save(Objects.requireNonNull(conversionService.convert(Pair.of(patch, memoryDao), MemoryDao.class)));
    }
}