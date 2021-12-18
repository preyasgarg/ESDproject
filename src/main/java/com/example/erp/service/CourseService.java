package com.example.erp.service;

import com.example.erp.bean.*;
import com.example.erp.dao.CourseDao;
import com.example.erp.dao.FacultyDao;
import com.example.erp.dao.implementation.CourseDaoImpl;
import com.example.erp.dao.implementation.FacultyDaoImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Time;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    FacultyDao facultyDao = new FacultyDaoImpl();
    public List<Course> getCoursesByFaculty(int facultyId){
        return courseDao.getCoursesByFaculty(facultyId);
    }

    public List<StudentCourse> getStudentsByCourse(int courseId){
        return courseDao.getStudentByCourse(courseId);
    }

    public JSONArray getCourseSchedule(int facultyId, int year, int term){

        List<Course> courses = facultyDao.getCoursesByFaculty(facultyId);
        String[][] schedule = new String[4][5];
        //Arrays.fill(schedule,"");
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("MON",0);
        hashMap.put("TUE",1);
        hashMap.put("WED",2);
        hashMap.put("THU",3);
        hashMap.put("FRI",4);
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                schedule[i][j]="";
            }
        }
        for(Course course:courses){
            if(course.getTerm() == term && course.getYear() == year){
                List<CourseSchedule> courseSchedules = course.getCourseSchedules();
                for(CourseSchedule courseSchedule : courseSchedules){
                    Time time = courseSchedule.getTime();
                    String timeStr = time.toString();
                    switch(timeStr) {
                        case "09:00:00":
                            schedule[0][hashMap.get(courseSchedule.getDay())] = course.getName()+"("+courseSchedule.getBuilding()+","+courseSchedule.getRoom()+")";
                            break;
                        case "11:00:00":
                            schedule[1][hashMap.get(courseSchedule.getDay())] = course.getName()+"("+courseSchedule.getBuilding()+","+courseSchedule.getRoom()+")";
                            break;
                        case "14:00:00":
                            schedule[2][hashMap.get(courseSchedule.getDay())] = course.getName()+"("+courseSchedule.getBuilding()+","+courseSchedule.getRoom()+")";
                            break;
                        case "16:00:00":
                            schedule[3][hashMap.get(courseSchedule.getDay())] = course.getName()+"("+courseSchedule.getBuilding()+","+courseSchedule.getRoom()+")";
                            break;
                    }
                }
            }

        }

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        for(int i=0;i<4;i++){
            jsonObject = new JSONObject();
            jsonObject.put("MON",schedule[i][0]);
            jsonObject.put("TUE",schedule[i][1]);
            jsonObject.put("WED",schedule[i][2]);
            jsonObject.put("THU",schedule[i][3]);
            jsonObject.put("FRI",schedule[i][4]);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
