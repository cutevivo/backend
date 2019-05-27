package com.cutevivo.backend.ServiceImpl;

import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.Repository.NoteRepository;
import com.cutevivo.backend.Service.NoteService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public ResultMessage addNote(Note note){
        return noteRepository.saveNote(note);
    }

    public ResultMessage getNoteById(long noteId){
        return noteRepository.findNoteById(noteId);
    }

    public ResultMessage getNoteByKeyword(String keyword){
        return noteRepository.findNoteByKeyword(keyword);
    }

    //not tested
    public ResultMessage deleteNote(Note note){
        return noteRepository.deleteNote(note);
    }

    public ResultMessage getNotesByCourseAndChapter(long courseId, int chapterOrder){
        return noteRepository.findNoteByCourseAndChapter(courseId, chapterOrder);
    }

    public List<Long> getUserCurrentCollectedNotes(long userId, long courseId, int chapterOrder) {
        return noteRepository.findUserCurrentCollectedNotes(userId, courseId, chapterOrder);
    }

    public long getMaxNoteId(){
        ResultMessage resultMessage = noteRepository.getMaxNoteId();
        Note note = (Note) resultMessage.getData();
        return note.getNoteId();
    }


}
