package com.translator.Translator.service;

import com.translator.Translator.repository.TranslateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TranslateServiceTest {

    @Mock
    private TranslateRepository repository;

    @InjectMocks
    private TranslateService service;

    @Test
    public void saveTest() {
        when(repository.saveCopiedWord("hello")).thenReturn("hello");

        String hello = service.saveWord("hello");
        Assertions.assertEquals(hello, "hello");

    }
}
