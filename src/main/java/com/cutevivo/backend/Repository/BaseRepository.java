package com.cutevivo.backend.Repository;

import com.cutevivo.backend.utils.ResultMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class BaseRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public Session getSession(){
        return entityManagerFactory.unwrap(SessionFactory.class).openSession();
    }

    public ResultMessage save(Object entity){
        Session session = getSession();
        try{
            Transaction tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
            session.clear();
            return new ResultMessage(true, entity.getClass().getSimpleName()+"实体存储成功！");
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ResultMessage(false, entity.getClass().getSimpleName()+"实体存储失败！");
        }finally {
            session.close();
        }
    }

    public ResultMessage update(Object entity) {
        Session session = getSession();
        try {
            Transaction tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
            session.clear();
            return new ResultMessage(true, entity.getClass().getSimpleName()+"实体更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ResultMessage(false, entity.getClass().getSimpleName()+"实体更新失败！");
        } finally {
            session.close();
        }

    }

    public ResultMessage delete(Object entity) {
        Session session = getSession();
        try {
            Transaction tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
            session.clear();
            return new ResultMessage(true, entity.getClass().getSimpleName()+"实体删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ResultMessage(false, entity.getClass().getSimpleName()+"实体删除失败！");
        } finally {
            session.close();
        }
    }

    public ResultMessage findById(Class<?> className, long id){
        Session session = getSession();
        try{
            Object instance = session.get(className, id);
            return new ResultMessage(true, instance, className.getSimpleName()+"实体（按ID）获取成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultMessage(false, className.getSimpleName()+"实体（按ID）获取失败！");
        }finally {
            session.close();
        }
    }

    public ResultMessage findByProperty(Class<?> className, String propertyName, Object value){
        Session session = getSession();
        try{
            String queryString = "from " + className.getSimpleName() + " as model where model." + propertyName + "=?1";
            Query queryObject = session.createQuery(queryString);
            queryObject.setParameter(1, value);
            List<?> result = queryObject.list();
            return new ResultMessage(true, result, className.getSimpleName()+"实体（按属性）获取成功！");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultMessage(false, className.getSimpleName()+"实体（按属性）获取失败！");
        }finally {
            session.close();
        }
    }

    public ResultMessage getAll(Class<?> className){
        List<?> result = null;
        Session session = getSession();
        try{
            Transaction tx = session.beginTransaction();
            String queryString = "from " + className.getSimpleName();
            Query queryObject = session.createQuery(queryString);
            result = queryObject.list();
            tx.commit();
            session.clear();
            return new ResultMessage(true, result, className.getSimpleName()+"下获取所有实体成功！");
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ResultMessage(false, className.getSimpleName()+"下获取所有实体失败！");
        }finally {
            session.close();
        }
    }


}
