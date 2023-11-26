package com.translator.Translator.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Translate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String copiedWord;
    private String translatedWord;

    @Override
    public String toString() {
        return "Translate{" +
                "copiedWord='" + copiedWord + '\'' +
                ", translatedWord='" + translatedWord + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Translate translate = (Translate) o;
        return Objects.equals(copiedWord, translate.copiedWord) && Objects.equals(translatedWord, translate.translatedWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(copiedWord, translatedWord);
    }

    public String getCopiedWord() {
        return copiedWord;
    }

    public void setCopiedWord(String copiedWord) {
        this.copiedWord = copiedWord;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }
}
