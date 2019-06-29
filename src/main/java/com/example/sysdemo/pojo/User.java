package com.example.sysdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = -6826424046686921108L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private  String phone;
    private String email;
    private Date created;
    private Date updated;




}
