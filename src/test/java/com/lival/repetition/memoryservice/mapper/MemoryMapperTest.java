package com.lival.repetition.memoryservice.mapper;

import com.lival.repetition.memoryservice.entity.MemoryDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = {MemoryMapperImpl.class})
class MemoryMapperTest {

    public static final String NEW_MEMORY_DAO_TEXT = "newText";
    public static final long OLD_MEMORY_DAO_ID = 456L;
    public static final String OLD_MEMORY_DAO_TEXT = "oldText";
    public static final long OLD_MEMORY_DAO_USER_ID = 1L;

    @Autowired
    private MemoryMapper memoryMapper;

    @Test
    @DisplayName("Merge patch with MemoryDao test")
    public void merge() {
        MemoryDao oldMemoryDao = new MemoryDao();
        oldMemoryDao.setId(OLD_MEMORY_DAO_ID);
        oldMemoryDao.setText(OLD_MEMORY_DAO_TEXT);
        oldMemoryDao.setUserId(OLD_MEMORY_DAO_USER_ID);

        MemoryDao patch = new MemoryDao();
        patch.setId(111L);
        patch.setText(NEW_MEMORY_DAO_TEXT);

        MemoryDao result = memoryMapper.merge(patch,oldMemoryDao);
        assertEquals(OLD_MEMORY_DAO_ID, (long) result.getId());
        assertEquals(NEW_MEMORY_DAO_TEXT, result.getText());
        assertEquals(OLD_MEMORY_DAO_USER_ID, (long) result.getUserId());
        assertNull(result.getLinks());
    }

}