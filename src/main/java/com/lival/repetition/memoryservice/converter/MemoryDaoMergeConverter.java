package com.lival.repetition.memoryservice.converter;

import com.lival.repetition.memoryservice.entity.MemoryDao;
import com.lival.repetition.memoryservice.mapper.MemoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MemoryDaoMergeConverter implements Converter<Pair<MemoryDao, MemoryDao>, MemoryDao> {
    private final MemoryMapper memoryMapper;

    @Override
    public MemoryDao convert(Pair<MemoryDao, MemoryDao> patchMemoryDaoPair) {
        return memoryMapper.merge(patchMemoryDaoPair.getFirst(), patchMemoryDaoPair.getSecond());
    }
}