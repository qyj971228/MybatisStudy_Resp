package com.qyj.mapper;

import com.qyj.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from user_role,role where user_role.roleId = role.id and user_role.userId = #{id}")
    public List<Role> findById();

}
