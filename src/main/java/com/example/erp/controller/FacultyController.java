package com.example.erp.controller;

import com.example.erp.bean.Faculty;
import com.example.erp.service.FacultyService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("faculty")
public class FacultyController {
    FacultyService facultyService = new FacultyService();

    @POST
    @Path("/verify")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verifyFaculty(Faculty faculty) throws URISyntaxException {
        Integer facultyId = facultyService.verifyFaculty(faculty);
        if(facultyId != null){

            return Response.ok(facultyId).build();
        }else{
            return Response.status(203).build();
        }
    }

}
