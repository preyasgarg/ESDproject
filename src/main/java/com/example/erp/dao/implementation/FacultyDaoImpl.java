package com.example.erp.dao.implementation;

import com.example.erp.bean.Course;
import com.example.erp.bean.Faculty;
import com.example.erp.dao.FacultyDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FacultyDaoImpl implements FacultyDao {


    @Override
    public Integer verifyFaculty(Faculty faculty) {
        Session session = SessionUtil.getSession();
        try {
            System.out.println("from frontend email : "+faculty.getEmail());
            System.out.println("from frontend password : "+faculty.getPassword());
            Query query = session.createQuery("from Faculty where email=:email and password=:password");
            query.setParameter("email", faculty.getEmail());
            query.setParameter("password", faculty.getPassword());

            if(query.getResultList().size()==1){
                Faculty faculty1 = (Faculty)query.getResultList().get(0);
                return faculty1.getId();
            }

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Course> getCoursesByFaculty(int facultyId){
        Session session = SessionUtil.getSession();
        System.out.println("FacultyDaoImpl  facultyId : "+facultyId);
        try{
            Query query = session.createQuery("from Faculty where id=:id");
            query.setParameter("id",facultyId);
            if(query.getResultList().size()==1){
                Faculty faculty1 = (Faculty)query.getResultList().get(0);
                System.out.println("FacultyDAOImpl course name : "+faculty1.getCourses().get(0).getName());
                return faculty1.getCourses();
            }
        }catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
        return null;
    }
}
