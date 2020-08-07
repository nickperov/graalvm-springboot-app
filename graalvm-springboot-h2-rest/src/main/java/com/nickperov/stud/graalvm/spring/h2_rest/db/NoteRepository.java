package com.nickperov.stud.graalvm.spring.h2_rest.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

}
