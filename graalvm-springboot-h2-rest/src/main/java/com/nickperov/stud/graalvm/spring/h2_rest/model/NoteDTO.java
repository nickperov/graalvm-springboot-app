package com.nickperov.stud.graalvm.spring.h2_rest.model;

public class NoteDTO implements Note {

    private String title;
    private String text;

    public NoteDTO() {
    }

    public NoteDTO(final Note note) {
        this.title = note.getTitle();
        this.text = note.getText();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }
}
