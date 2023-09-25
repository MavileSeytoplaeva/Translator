package com.translator.Translator.repository;

import com.translator.Translator.entity.Translate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TranslateRepository extends JpaRepository<Translate, Long> {


    @Modifying
    @Query(value = "INSERT INTO Translate (copied_word) VALUES (?)", nativeQuery = true)
    void saveCopiedWord( String word);

}
