package com.translator.Translator.service;

import com.translator.Translator.entity.Translate;
import com.translator.Translator.repository.TranslateRepository;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    private TranslateRepository repository;

    public TranslateService(TranslateRepository repository) {
        this.repository = repository;
    }

    public void saveWord(String word){
        repository.saveCopiedWord(word);
    }

    public Translate findById(Long id) {
        return repository.findById(id).get();
    }

//    public void delete() {
//        repository.de
//    }
}
