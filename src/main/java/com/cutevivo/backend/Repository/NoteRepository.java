package com.cutevivo.backend.Repository;

import com.cutevivo.backend.Entity.CollectionEntry;
import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.utils.ResultMessage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class NoteRepository {

    @Autowired
    BaseRepository baseRepository;

    @Autowired
    CollectionEntryRepository collectionEntryRepository;

    public ResultMessage saveNote(Note note){
        return baseRepository.save(note);
    }

    public ResultMessage deleteNote(Note note){
        return baseRepository.delete(note);
    }

    public ResultMessage findNoteById(long id){
        return baseRepository.findById(Note.class, id);
    }

    public ResultMessage findNoteByKeyword(String keyword){
        Session session = baseRepository.getSession();
        List<Note> result = null;
        try{
            String queryString =
                    "from Note as model where model.header like '%" + keyword + "%'";
            Query queryObject = session.createQuery(queryString);
            result = queryObject.list();
            return new ResultMessage(true, result, "Note实体（按笔记名）获取成功！");
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ResultMessage(false, "Note实体（按笔记名）获取失败！");
        }finally{
            session.close();
        }
    }

    public ResultMessage findNotesByUserId(long userId){
        return baseRepository.findByProperty(Note.class, "userId", userId);
    }

    public ResultMessage findNoteByCourseAndChapter(long courseId, int chapterOrder){
        Session session = baseRepository.getSession();
        List<Note> result = null;
        try{
            String queryString =
                    "from Note as model where model.courseId=?1 and model.chapterOrder=?2";
            Query queryObject = session.createQuery(queryString);
            queryObject.setParameter(1, courseId);
            queryObject.setParameter(2, chapterOrder);
            result = queryObject.list();
            return new ResultMessage(true, result, "Note实体（按课程号与章节）获取成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultMessage(false, "Note实体（按课程号与章节）获取失败！");
        }finally{
            session.close();
        }
    }

    public List<Long> findUserCurrentCollectedNotes(long userId, long courseId, int chapterOrder){
        ResultMessage resultMessage1 = collectionEntryRepository.findCollectionEntriesByUserId(userId);
        List<CollectionEntry> collectionEntryList = (List<CollectionEntry>) resultMessage1.getData();
        List<Long> result = new ArrayList<>();
        if(collectionEntryList.size()>0){
            for(CollectionEntry collectionEntry : collectionEntryList){
                ResultMessage temp = findNoteById(collectionEntry.getNoteId());
                if(temp.getData() != null) {
                    Note note = (Note) temp.getData();
                    if (note.getCourseId() == courseId && note.getChapterOrder() == chapterOrder) {
                        result.add(note.getNoteId());
                    }
                }
            }
        }
        return result;
    }

    public List<Long> findUserCollectedNotes(long userId){
        ResultMessage resultMessage1 = collectionEntryRepository.findCollectionEntriesByUserId(userId);
        List<CollectionEntry> collectionEntryList = (List<CollectionEntry>) resultMessage1.getData();
        List<Long> result = new ArrayList<>();
        if(collectionEntryList.size()>0) {
            for (CollectionEntry collectionEntry : collectionEntryList) {
                result.add(collectionEntry.getNoteId());
            }
        }
        return result;
    }

    public ResultMessage findNotesByCourseId(long courseId){
        return baseRepository.findByProperty(Note.class, "courseId", courseId);
    }

    public ResultMessage updateNote(Note note){
        return baseRepository.update(note);
    }

    public ResultMessage getMaxNoteId(){
        Session session = baseRepository.getSession();
        List<Note> result = null;
        try {
            String queryString =
                    "from Note as model order by model.noteId desc";
            Query queryObject = session.createQuery(queryString);
            queryObject.setMaxResults(1);
            result = queryObject.list();
            Note note = result.get(0);
            return new ResultMessage(true, note, "获取最后一条笔记成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultMessage(false, "获取最后一条笔记失败！");
        }finally {
            session.close();
        }
    }


}
