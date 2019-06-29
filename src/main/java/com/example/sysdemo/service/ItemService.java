package com.example.sysdemo.service;

import com.example.sysdemo.pojo.Item;

import java.util.List;

public interface ItemService {
    int saveItem(Item item);

    List<Item> findAll();

    Item findItemById(Integer id);

    int updateItem(Item item);
}
