package com.cutevivo.backend.Controller;

import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.Service.NoteService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("note")
    public ResultMessage fetchNote(long noteId){
        ResultMessage resultMessage = noteService.getNoteById(noteId);
        Note note = (Note)resultMessage.getObject();
        return new ResultMessage(true, note, "获取笔记信息成功！");
    }

}
