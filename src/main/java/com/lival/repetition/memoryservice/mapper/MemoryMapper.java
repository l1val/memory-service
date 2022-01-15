package com.lival.repetition.memoryservice.mapper;

import com.lival.repetition.memoryservice.entity.MemoryDao;
import com.lival.repetition.memoryservice.model.Memory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public abstract class MemoryMapper {

    @Mapping(ignore = true, target = "id")
    public abstract MemoryDao merge(MemoryDao patch, @MappingTarget MemoryDao memoryDao);

    public abstract MemoryDao mapMemoryToMemoryDao(Memory memory);
    public abstract Memory mapMemoryDaoToMemory(MemoryDao memoryDao);
}