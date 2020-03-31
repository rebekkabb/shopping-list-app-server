package com.mobilabtestassignment.rebekka.backend.controller

import com.mobilabtestassignment.rebekka.backend.model.ItemModel
import com.mobilabtestassignment.rebekka.backend.repository.ItemRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * ItemController deals with all the HTTP requests coming to "/item" and maps them to the right database query method
 * fun getItems is a method that gets the ID of a list given in the GET request and returns the items found in that list
 * fun addItem is a method that gets a model of an item (ItemModel) and based on that inserts it into the database
 * fun deleteItem is a method that gets the ID of an item given in the DELETE request and removes it from the database
 * fun changeItemStatus is a method that gets the ID of an item given in the POST request and status of the checkbox,
 * then changes the value of checked_state field for that itemn based on that checkbox status
 */
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
