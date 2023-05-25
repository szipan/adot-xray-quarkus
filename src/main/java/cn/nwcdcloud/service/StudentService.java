package cn.nwcdcloud.service;

import cn.nwcdcloud.entity.Student;
import cn.nwcdcloud.mapper.StudentMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class StudentService {

    @Inject
    private StudentMapper studentMapper;

    public Student getById(long id) {
        return this.studentMapper.getById(id);
    }
}
