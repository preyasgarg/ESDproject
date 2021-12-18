package com.example.erp.dao.implementation;

import com.example.erp.bean.Course;
import com.example.erp.bean.Faculty;
import com.example.erp.bean.Student;
import com.example.erp.bean.StudentCourse;
import com.example.erp.dao.CourseDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public List<Course> getCoursesByFaculty(int facultyId) {
        Session session = SessionUtil.getSession();
        try {
            System.out.println("facultyEmail : "+facultyId);
            Query query = session.createQuery("from Faculty where id=:id");
            query.setParameter("id", facultyId);

            if(query.getResultList().size()==1){
                Faculty faculty1 = (Faculty)query.getResultList().get(0);
                List<Course> courses = faculty1.getCourses();
                for(Course course: courses){
                    System.out.println(course.getName());
                }
                return courses;
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
    @SuppressWarnings("unchecked")
    public List<StudentCourse> getStudentByCourse(int courseId) {
        Session session = SessionUtil.getSession();

        try {

                System.out.println(courseId);
                Query query = session.createQuery("from Course where id=:id");
                query.setParameter("id", courseId);

                if(query.getResultList().size()==1){
                    Course course = (Course)query.getResultList().get(0);
                 /*List<Student> students = course.getStudents();*/
                /*for(Object object:query.getResultList()){
                    students.add((Student)object);
                }*/
                List<StudentCourse> studentCourses = course.getStudentCourses();
                /*for(Student student: students){
                    System.out.println("CourseService : "+student.getFirstName());
                }*/
                    for(StudentCourse studentCourse: studentCourses){
                        System.out.println("CourseService : "+studentCourse.getStudent().getFirstName());
                    }
                return studentCourses;
            }

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }finally {
            session.close();
        }
        return null;
    }
}
