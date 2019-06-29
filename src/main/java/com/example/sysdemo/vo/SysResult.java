package com.example.sysdemo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
public class SysResult implements Serializable {
    private Integer status;
    private String mgs;
    private Object data;

    public SysResult(){}
    public SysResult(Integer status,String mgs){
        this.status=status;
        this.mgs=mgs;
    }
    public SysResult(Integer status,String mgs,Object data){
        this.status=status;
        this.mgs=mgs;
        this.data=data;
    }


}
