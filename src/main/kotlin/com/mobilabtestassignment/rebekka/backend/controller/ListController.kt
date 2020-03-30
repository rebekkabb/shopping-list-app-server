package com.mobilabtestassignment.rebekka.backend.controller

import com.mobilabtestassignment.rebekka.backend.model.ListModel
import com.mobilabtestassignment.rebekka.backend.repository.ListRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/list")
class ListController(private val listRepository: ListRepository) {

    @GetMapping()
    fun getLists(): List<ListModel> {
        return listRepository.getLists()
    }

    @GetMapping("/{id}")
    fun getList(@PathVariable("id") listId: Int): ListModel {
        return listRepository.getList(listId)
    }

    @PutMapping()
    fun addList(listModel: ListModel): ListModel {
        return listRepository.addList(listModel)
    }

    @DeleteMapping("/{id}")
    fun deleteList(@PathVariable("id") listId: Int) {
        listRepository.deleteList(listId)
    }

}
