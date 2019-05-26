package com.cutevivo.backend.Repository;

import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.utils.ResultMessage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {

    @Autowired
    BaseRepository baseRepository;

    public ResultMessage saveCourse(Course course){
        return baseRepository.save(course);
    }

    public ResultMessage deleteCourse(Course course){
        return baseRepository.delete(course);
    }

    public ResultMessage updateCourse(Course course){
        return baseRepository.update(course);
    }

    public ResultMessage findCourseById(long id){
        return baseRepository.findById(Course.class, id);
    }

    public ResultMessage findAllCourses(){
        return baseRepository.getAll(Course.class);
    }

    public ResultMessage findCourseByKeyword(String keyword){
        Session session = baseRepository.getSession();
        List<Course> result = null;
        try {
            String queryString =
                    "from Course as model where model.courseName like '%" + keyword + "%'";
            Query queryObject = session.createQuery(queryString);
            result = queryObject.list();
            return new ResultMessage(true, result, "Course实体（按课程名）获取成功！");
        }catch(Exception e){
            e.printStackTrace();
            return new ResultMessage(false, "Course实体（按课程名）获取失败！");
        }finally {
            session.close();
        }
    }

    public ResultMessage findCourseByName(String courseName){
        return baseRepository.findByProperty(Course.class, "courseName", courseName);
    }


}
