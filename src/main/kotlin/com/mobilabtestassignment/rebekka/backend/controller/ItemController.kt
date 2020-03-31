package com.mobilabtestassignment.rebekka.backend.controller

import com.mobilabtestassignment.rebekka.backend.model.ItemModel
import com.mobilabtestassignment.rebekka.backend.repository.ItemRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ItemController(private val itemRepository: ItemRepository) {

    @GetMapping("/{id}")
    fun getItems(@PathVariable("id") listId: Int): ResponseEntity<List<ItemModel>> {
        return ResponseEntity(itemRepository.getItems(listId), HttpStatus.OK)
    }

    @PutMapping()
    fun addItem(@RequestBody itemModel: ItemModel): ItemModel? {
        val listId = itemModel.listId
        val value = itemModel.value
        val checkedState = itemModel.checkedState
        itemRepository.addItem(listId, value, checkedState)
        return itemModel
        //TODO return item with id? (not used at the moment)
    }

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable("id") itemId: Int) {
        itemRepository.deleteItem(itemId)

    }

    @PostMapping("/{id}")
    fun changeItemStatus(@PathVariable("id") itemId: Int, @RequestParam("itemStatus") itemStatus: Boolean) {
        itemRepository.changeItemStatus(itemId, itemStatus)

    }
}
