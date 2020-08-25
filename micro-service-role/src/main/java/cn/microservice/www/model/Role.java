package cn.microservice.www.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色类
 * @author MachineGeek
 */
@Data
public class Role {
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private String remark;
    private Integer enable;
    private Integer delete;
    @Version
    private Integer version;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}