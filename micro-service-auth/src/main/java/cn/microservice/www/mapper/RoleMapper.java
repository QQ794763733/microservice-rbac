package cn.microservice.www.mapper;

import cn.microservice.www.model.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色映射类
 * @author MachineGeek
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectRolesByAccountId(@Param(value = "accountId")Long accountId);
}
