package com.example.dao;

/*import org.jboss.logging.Param;*/

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") Integer id);

    @Insert("insert into user(type,name) values(#{type},#{name})")
    int addUser(User user);

}