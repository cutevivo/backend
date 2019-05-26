package com.cutevivo.backend.Repository;


import com.cutevivo.backend.Entity.Chapter;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ChapterRepository {

    @Autowired
    private BaseRepository baseRepository;

    public ResultMessage findChaptersByCourseId(long courseId){
        return baseRepository.findByProperty(Chapter.class, "courseId", courseId);
    }

}
