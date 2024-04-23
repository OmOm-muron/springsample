package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mapper.DiaryMapper;
import com.example.model.Diary;

@Controller
public class DiaryController {
    @Autowired
    private DiaryMapper diaryMapper;

    @GetMapping("/")
    public String index(Model model) {
        List<Diary> diaries = diaryMapper.getAllDiary();
        model.addAttribute("diaries", diaries);
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("diary", new Diary());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Diary diary) {
        diary.setUpddate(LocalDateTime.now());
        diaryMapper.insertDiary(diary);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Diary diary = diaryMapper.getDiary(id);
        model.addAttribute("diary", diary);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Diary diary) {
        diary.setUpddate(LocalDateTime.now());
        diaryMapper.updateDiary(diary);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        diaryMapper.deleteDiary(id);
        return "redirect:/";
    }
}
