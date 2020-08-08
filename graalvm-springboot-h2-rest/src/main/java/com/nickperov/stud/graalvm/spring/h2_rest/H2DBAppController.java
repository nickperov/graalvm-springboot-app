package com.nickperov.stud.graalvm.spring.h2_rest;

import com.nickperov.stud.graalvm.spring.h2_rest.db.NoteEntity;
import com.nickperov.stud.graalvm.spring.h2_rest.db.NoteRepository;
import com.nickperov.stud.graalvm.spring.h2_rest.model.NoteDTO;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class H2DBAppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(H2DBAppController.class);

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/status")
    public String getStatus() {
        return String.format("H2 DB app is running: %s", new Date());
    }

    @GetMapping("/note")
    public NoteDTO getNote(@RequestParam final long id) {
        Optional<NoteEntity> queryResult = noteRepository.findById(id);
        if (queryResult.isPresent()) {
            LOGGER.info("Note with id: {} found", id);
            return new NoteDTO(queryResult.get());
        } else {
            LOGGER.info("Note with id: {} not found", id);
            return new NoteDTO();
        }
    }

    @PostMapping("/note")
    public String addNote(@RequestBody final NoteDTO note) {
        final NoteEntity noteEntity = noteRepository.save(new NoteEntity(note));
        LOGGER.info("New note created: {}", noteEntity);
        return "" + noteEntity.getId();
    }

    @GetMapping("/notes")
    public List<NoteDTO> listNotes() {
        return noteRepository.findAll().stream().map(NoteDTO::new).collect(Collectors.toList());
    }
}
