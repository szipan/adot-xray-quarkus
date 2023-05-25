package cn.nwcdcloud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.nwcdcloud.entity.Student;
import cn.nwcdcloud.service.RedisService;
import cn.nwcdcloud.service.StudentService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/test")
public class StudentController {

    @Inject
    private StudentService studentService;

    @Inject
    private RedisService redisService;

    ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("/student/{id}")
    @Blocking
    public Uni<Response> info(@PathParam("id") Long id) throws JsonProcessingException {
        String stuSer = redisService.get(Long.toString(id));
        Student result;
        if (null == stuSer) {
            result = studentService.getById(id);
            if (result != null) {
                System.out.println("1");
                System.out.println(mapper.writeValueAsString(result));
                redisService.set(id.toString(), mapper.writeValueAsString(result));
            }
        } else {
            System.out.println("2");
            result = mapper.readValue(stuSer.toString(), Student.class);
        }

        if (result != null) {
            return Uni.createFrom().item(Response.ok(result).build());
        } else {
            return Uni.createFrom().item(Response.ok().status(Response.Status.NOT_FOUND).build());
        }
    }
}