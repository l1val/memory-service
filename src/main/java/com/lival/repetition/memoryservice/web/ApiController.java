package com.lival.repetition.memoryservice.web;

import com.lival.repetition.memoryservice.enums.MemoryStatus;
import com.lival.repetition.memoryservice.model.Memory;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.lival.repetition.memoryservice.service.MemoryService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApiController {

    private final MemoryService memoryService;

    @GetMapping("/start")
    public String start() {
        return "It is start of repetition application";
    }

    @GetMapping("/memory/{id}")
    public Memory memoryById(@PathVariable("id") Long id) {
        return memoryService.getMemoryById(id);
    }

    @GetMapping("/memory")
    public List<Memory> memoryByIdAndStatus(@RequestParam("userId") Long userId, @RequestParam("status") MemoryStatus memoryStatus) {
        return memoryService.getMemoryByUserIdAndStatus(userId, memoryStatus);
    }

    @PostMapping("/memory")
    public Long createMemory(@RequestBody Memory memory) {
        return memoryService.createMemory(memory);
    }

    @PatchMapping("/memory")
    public void updateMemory(@RequestBody Memory memory) {
        memoryService.updateMemory(memory);
    }

    @DeleteMapping("/memory/{id}")
    public void deleteMemory(@PathVariable("id") Long id) {
        memoryService.deleteMemoryById(id);
    }
}
