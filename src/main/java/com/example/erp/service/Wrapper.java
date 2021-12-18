package com.example.erp.service;

import com.example.erp.bean.Student;
import com.example.erp.bean.StudentCourse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Wrapper {
    JSONArray jsonArray;
    public JSONArray getStudentJsonArray(List<StudentCourse> studentCourses){
        jsonArray = new JSONArray();
        JSONObject jsonObject;
        for(StudentCourse studentCourse:studentCourses){
            jsonObject = new JSONObject();
            Student student = studentCourse.getStudent();
            jsonObject.put("name",student.getFirstName()+" "+student.getLastName());
            jsonObject.put("rollnumber",student.getRollnumber());
            jsonObject.put("email",student.getEmail());
            jsonObject.put("cgpa",student.getCgpa());
            jsonObject.put("totalCredits",student.getTotalCredits());
            jsonObject.put("graduationYear",student.getGraduationYear());
            jsonObject.put("grade",studentCourse.getGrade());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
