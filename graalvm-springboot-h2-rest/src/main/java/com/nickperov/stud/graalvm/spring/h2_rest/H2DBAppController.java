package com.nickperov.stud.graalvm.spring.h2_rest;

import com.nickperov.stud.graalvm.spring.h2_rest.db.NoteEntity;
import com.nickperov.stud.graalvm.spring.h2_rest.db.NoteRepository;
import com.nickperov.stud.graalvm.spring.h2_rest.model.NoteDTO;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class H2DBAppController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/status")
    public String getStatus() {
        return String.format("H2 DB app is running: %s", new Date());
    }

    @GetMapping("/note")
    public NoteDTO getNote(@RequestParam final long id) {
        return new NoteDTO(noteRepository.getOne(id));
    }

    /*@PostMapping("/note")
    public String addNote(@RequestBody final String note) {
        return "Reply to note " + note;
    }*/
    
    @PostMapping("/note")
    public void addNote(@RequestBody final NoteDTO note) {
        noteRepository.save(new NoteEntity(note));
    }

    @GetMapping("/notes")
    public List<NoteDTO> listNotes() {
        return noteRepository.findAll().stream().map(NoteDTO::new).collect(Collectors.toList());
    }

}
