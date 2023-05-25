package cn.nwcdcloud.mapper;

import org.apache.ibatis.annotations.*;
import cn.nwcdcloud.entity.Student;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM students WHERE id = #{id}")
    Student getById(Long id);
}
