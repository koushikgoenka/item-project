package com.example.item.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.item.dto.ItemDto;
import com.example.item.entities.Item;
import com.example.item.repository.ItemRepository;
import com.example.item.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public ItemDto addItem(@RequestBody ItemDto itemDto) {
		Item item = mapToEntity(itemDto);
		Item savedItem = itemRepository.save(item);
		return mapToDTO(savedItem);
	}

	@Override
	public ItemDto getItemById(long itemId) {

		Optional<Item> itemOptional = itemRepository.findById(itemId);
		if (itemOptional.isPresent()) {
			Item savedItem = itemOptional.get();
			ItemDto itemDto = mapToDTO(savedItem);
			return itemDto;
		} else {
			throw new RuntimeException("Invalid itemId passed");
		}
	}

	@Override
	public List<ItemDto> getAllItems() {
		List<Item> items = itemRepository.findAll();

		List<ItemDto> itemDtoList = items.stream().map(item -> mapToDTO(item)).collect(Collectors.toList());

		return itemDtoList;
	}

	@Override
	public void updateItem(Long itemId, ItemDto itemDto) {

		Item item = mapToEntity(itemDto);
		itemRepository.save(item);
	}

	// convert Entity to DTO
	private ItemDto mapToDTO(Item item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemId(item.getItemId());
		itemDto.setName(item.getName());
		itemDto.setDescription(item.getDescription());
		itemDto.setQuantity(item.getQuantity());
		itemDto.setPrice(item.getPrice());
		return itemDto;
	}

	// convert DTO to entity
	private Item mapToEntity(ItemDto itemDto) {
		Item item = new Item();
		item.setItemId(itemDto.getItemId());
		item.setName(itemDto.getName());
		item.setDescription(itemDto.getDescription());
		item.setQuantity(itemDto.getQuantity());
		item.setPrice(itemDto.getPrice());
		return item;
	}
}
