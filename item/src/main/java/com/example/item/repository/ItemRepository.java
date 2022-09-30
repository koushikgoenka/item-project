package com.example.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.item.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
