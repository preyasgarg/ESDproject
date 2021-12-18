package com.example.erp.service;

import com.example.erp.bean.Faculty;
import com.example.erp.dao.FacultyDao;
import com.example.erp.dao.implementation.FacultyDaoImpl;

public class FacultyService {
    FacultyDao facultyDao = new FacultyDaoImpl();
    public Integer verifyFaculty(Faculty faculty){
        return  facultyDao.verifyFaculty(faculty);
    }
}
