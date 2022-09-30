package com.example.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.item.dto.ItemDto;
import com.example.item.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    private ItemDto addItem(@RequestBody ItemDto itemDto){
        return itemService.addItem(itemDto);
    }

    @GetMapping("/{id}")
    private ItemDto getItemById(@PathVariable long id){
        return itemService.getItemById(id);
    }

    @GetMapping
    private List<ItemDto> getAllItems(){
        return itemService.getAllItems();
    }

}

