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
@TableName("tb_item")
public class Item implements Serializable {
    private static final long serialVersionUID = 3923444355658140679L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String barcode;
    private  String image;
    private Long cid;
    private Integer status;
    private Date created;
    private Date updated;

}
