package com.example.erp.dao;

import com.example.erp.bean.Course;
import com.example.erp.bean.Faculty;

import java.util.List;

public interface FacultyDao {
    Integer verifyFaculty(Faculty faculty);
    List<Course> getCoursesByFaculty(int facultyId);
}
