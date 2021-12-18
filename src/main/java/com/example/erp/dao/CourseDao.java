package com.example.erp.dao;

import com.example.erp.bean.Course;
import com.example.erp.bean.Student;
import com.example.erp.bean.StudentCourse;

import java.util.List;

public interface CourseDao {
    List<Course> getCoursesByFaculty(int facultyId);
    List<StudentCourse> getStudentByCourse(int courseId);
}
