package com.example.sysdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sysdemo.mapper.ItemMapper;
import com.example.sysdemo.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public int saveItem(Item item) {
        //由于数据库环境问题  写死
        item.setCid(641L);
        item.setCreated(new Date());
        item.setUpdated(item.getCreated());
       // System.out.println("serviceItem"+item);
        String img=item.getImage();
    if(img==null||img=="")
        throw new IllegalArgumentException("没有上传图片");
        /**
         * 简单实现功能  其他参数判断 暂时省略
         */
        int count=itemMapper.insert(item);
        return count;
    }

    @Override
    //查找所有商品
    public List<Item> findAll() {
        QueryWrapper queryWrapper=  new QueryWrapper<>();
        queryWrapper.orderByAsc("num");
        List<Item> items= itemMapper.selectList(queryWrapper);
        return  items;
    }

    @Override
    public Item findItemById(Integer id) {

        if(StringUtils.isEmpty(id))
            throw new IllegalArgumentException("修改id不能为空");



           Item  item = itemMapper.selectById(id);
            if (item == null)
                throw new RuntimeException("更新失败");

            return item;
    }

    @Override
    public int updateItem(Item item) {
        if(item==null)
            throw new IllegalArgumentException("修改队形不能为空");
        //简单检验 对象属性
        if(StringUtils.isEmpty(item.getId()))
            throw new IllegalArgumentException("修改对象id不能为空");
        if(StringUtils.isEmpty(item.getTitle()))
            throw new IllegalArgumentException("修改对象名不能为空");
        if(StringUtils.isEmpty(item.getPrice()))
            throw new IllegalArgumentException("修改对象价格不能为空");
        if(StringUtils.isEmpty(item.getNum()))
            throw new IllegalArgumentException("修改对象数量不能为空");//参数验证…………
        int count=itemMapper.updateById(item);

        return count;
    }
}
