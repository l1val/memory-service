package com.lival.repetition.memoryservice.converter;

import com.lival.repetition.memoryservice.entity.MemoryDao;
import com.lival.repetition.memoryservice.mapper.MemoryMapper;
import com.lival.repetition.memoryservice.model.Memory;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MemoryDaoToMemoryConverter implements Converter<MemoryDao, Memory> {

    private final MemoryMapper memoryMapper;

    @Override
    public Memory convert(MemoryDao memoryDao) {
        return memoryMapper.mapMemoryDaoToMemory(memoryDao);
    }
}