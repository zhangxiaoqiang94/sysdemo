package com.example.sysdemo.controller;

import com.example.sysdemo.pojo.Item;
import com.example.sysdemo.service.ItemService;
import com.example.sysdemo.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/save")
    public SysResult saveItem(Item item){
            System.out.println("Item param::"+item);
        try {
            int count=itemService.saveItem(item);
            System.out.println("商品入库行数"+count);
            if(count!=0)
             return new SysResult(200,"商品入库成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SysResult(201,"商品入库失败");
    }
    @RequestMapping("/findAll")
    public SysResult findAll(){
        List<Item> items=itemService.findAll();
      //  System.out.println("item的size    :"+items.size());
        return new SysResult(200,"查询成功",items);
    }

    @RequestMapping("/findItemById")
    //根据条件查询  用于数据的回显
    public SysResult findItemById(Integer id){

        try {
            Item item=itemService.findItemById(id);

                return  new SysResult(200,"更新成功",item);

        } catch (Exception e) {
            System.out.println("返回值出现异常！！！");
            e.printStackTrace();
        }
        return new SysResult(201,"controller更新失败");
    }
    //商品修改
    @RequestMapping("/update")
    public SysResult updateItem(Item item){

        try {
            int count=itemService.updateItem(item);
            if(count!=0)
            return  new SysResult(200,"商品修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SysResult(201,"商品修改失败");
    }





}
