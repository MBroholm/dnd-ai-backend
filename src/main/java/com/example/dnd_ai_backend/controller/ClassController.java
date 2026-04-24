package com.example.dnd_ai_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dnd_ai_backend.dto.common.ApiReferenceDto;
import com.example.dnd_ai_backend.service.ClassService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/classes")
public class ClassController {

    ClassService classService;
    
    public ClassController(ClassService classService) {
        this.classService = classService;
    }


    @GetMapping()
    public List<ApiReferenceDto> getClasses() {
        return classService.getAllClasses();
    }
    
}
