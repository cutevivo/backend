package com.cutevivo.backend.Service;

import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.utils.ResultMessage;

import java.util.List;

public interface NoteService {

    ResultMessage addNote(Note note);
    ResultMessage getNoteById(long noteId);
    ResultMessage getNoteByKeyword(String keyword);
    ResultMessage deleteNote(Note note);
    //该方法获取某个课程的某个章节下的所有笔记
    ResultMessage getNotesByCourseAndChapter(long courseId, int chapterOrder);
    //该方法返回当前用户在某个课程的某个章节下点赞过的笔记
    List<Long> getUserCurrentCollectedNotes(long userId, long courseId, int chapterOrder);


}
