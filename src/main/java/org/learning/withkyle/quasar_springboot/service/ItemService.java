package org.learning.withkyle.quasar_springboot.service;

import java.util.List;

import org.learning.withkyle.quasar_springboot.model.Item;
import org.learning.withkyle.quasar_springboot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    public ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> showAll(){
        return itemRepository.findAll();

    }
    
    public Item addItem(Item item){
        return itemRepository.save(item);
        
    }


}
