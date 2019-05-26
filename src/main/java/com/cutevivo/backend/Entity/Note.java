package com.cutevivo.backend.Entity;

import javax.persistence.*;

/**
 * header: 标题
 * content：笔记内容
 * score：对课程评分
 * thumbs：笔记被点赞数
 * comment：短评
 */
@Entity
@Table(name="t_note")
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long noteId;
    private String header;
    private String content;
    private double score;
    private long thumbs;
    private String comment;
    private long userId;
    private long courseId;
    private int chapterOrder;



    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public long getThumbs() {
        return thumbs;
    }

    public void setThumbs(long thumbs) {
        this.thumbs = thumbs;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public int getChapterOrder() {
        return chapterOrder;
    }

    public void setChapterOrder(int chapterOrder) {
        this.chapterOrder = chapterOrder;
    }
}
