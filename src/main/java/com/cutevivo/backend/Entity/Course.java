package com.cutevivo.backend.Entity;

import javax.persistence.*;

/**
 * courseName：课程名
 * description：课程描述
 * score：课程总评分，当用户提交新的评分或笔记收到新的赞时更新
 */
@Entity
@Table(name="t_course")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long courseId;
    private String courseName;
    private String description;
    private double score;

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
}
