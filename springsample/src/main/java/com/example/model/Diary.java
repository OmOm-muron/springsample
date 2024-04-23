package com.example.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Diary {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime upddate;
}
