package com.mobilabtestassignment.rebekka.backend.controller

import com.mobilabtestassignment.rebekka.backend.model.ListModel
import com.mobilabtestassignment.rebekka.backend.repository.ListRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * ListController deals with all the HTTP requests coming to "/list" and maps them to the right database query method
 * fun getLists is a method that returns all of the existing lists in the database
 * fun getList is a method that gets the ID of the list, does a query to the database and returns it´s ListModel
 * fun addList is a method that gets a model of a list (ListModel) and based on that inserts that list into the database
 * and returns the ListModel of that created list
 * fun deleteList is a method that gets the ID of the list we want to delete given in the DELETE request and removes it from the database
 */
@RestController
@RequestMapping("/list")
class ListController(private val listRepository: ListRepository) {

    @GetMapping()
    fun getLists(): ResponseEntity<List<ListModel>> {
        return ResponseEntity(listRepository.getLists(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getList(@PathVariable("id") listId: Int): ResponseEntity<ListModel> {
        val list = listRepository.getList(listId) ?: return ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY)
        return ResponseEntity(list, HttpStatus.OK)
    }

    @PutMapping()
    fun addList(@RequestBody listModel: ListModel): ResponseEntity<ListModel> {
        val name = listModel.name
        val id = listRepository.addList(name)
        return ResponseEntity(listRepository.getList(id)!!, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteList(@PathVariable("id") listId: Int) {
        listRepository.deleteList(listId)
    }

}
