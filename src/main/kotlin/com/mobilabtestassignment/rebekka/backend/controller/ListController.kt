package com.mobilabtestassignment.rebekka.backend.controller

import com.mobilabtestassignment.rebekka.backend.model.ListModel
import com.mobilabtestassignment.rebekka.backend.repository.ListRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun addList(@RequestBody listModel: ListModel): ListModel {
        val name = listModel.name
        val id = listRepository.addList(name)
        return listRepository.getList(id)!!
    }

    @DeleteMapping("/{id}")
    fun deleteList(@PathVariable("id") listId: Int) {
        listRepository.deleteList(listId)
    }

}
