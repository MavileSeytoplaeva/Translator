package com.translator.Translator.controller;

import com.translator.Translator.entity.Translate;
import com.translator.Translator.service.TranslateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

    private final TranslateService service;

    public TranslateController(TranslateService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> saveCopiedWord(String word) {
        service.saveWord(word);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Translate> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
