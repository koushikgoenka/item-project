package com.example.item.service;

import java.util.List;

import com.example.item.dto.ItemDto;

public interface ItemService {

    ItemDto addItem(ItemDto itemDto);

    ItemDto getItemById(long itemId);

    List<ItemDto> getAllItems();

    void updateItem(Long itemId, ItemDto itemDto);
}
