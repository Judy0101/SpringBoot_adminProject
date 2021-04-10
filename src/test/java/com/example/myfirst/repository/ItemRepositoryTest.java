package com.example.myfirst.repository;

import com.example.myfirst.MyfirstApplicationTests;
import com.example.myfirst.model.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositoryTest extends MyfirstApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북");

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);
    }

    @Test
    public void read(){

        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assert.assertTrue(item.isPresent());
    }
}
