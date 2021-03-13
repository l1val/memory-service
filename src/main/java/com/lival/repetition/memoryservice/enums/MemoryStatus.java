package com.lival.repetition.memoryservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemoryStatus {
    DRAFT, WAIT, ON_STUDY, ON_REPEAT, DONE
}
