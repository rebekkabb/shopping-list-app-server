package com.mobilabtestassignment.rebekka.backend.controller

import com.mobilabtestassignment.rebekka.backend.model.ItemModel
import com.mobilabtestassignment.rebekka.backend.repository.ItemRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ItemController(private val itemRepository: ItemRepository) {

    @GetMapping("/{id}")
    fun getItems(@PathVariable("id") listId: Int): List<ItemModel> {
        return itemRepository.getItems(listId);
    }

    @PutMapping("/addItem")
    fun addItem(itemModel: ItemModel): ItemModel? {
        return null
    }

    @DeleteMapping("/deleteItem/{id}")
    fun deleteItem(itemId: Int) {

    }

    @PostMapping("/changeItemStatus/{id}")
    fun changeItemStatus(itemId: Int, itemStatus: Boolean) {

    }
}
