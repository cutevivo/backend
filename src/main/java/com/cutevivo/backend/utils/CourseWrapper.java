package com.cutevivo.backend.utils;

import com.cutevivo.backend.Entity.Course;

public class CourseWrapper {

    private long courseId;
    private String courseName;
    private String description;
    private double score;
    private String teacher;
    private String posterUrl;
    private int chapterNum;

    public CourseWrapper(){

    }

    public CourseWrapper(Course course){
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
        this.score = course.getScore();
        this.teacher = course.getTeacher();
        this.posterUrl = course.getPosterUrl();
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }
}
