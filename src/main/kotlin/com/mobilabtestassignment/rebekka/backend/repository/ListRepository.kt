package com.mobilabtestassignment.rebekka.backend.repository

import com.mobilabtestassignment.rebekka.backend.model.ListModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ListRepository : CrudRepository<ListModel, Long> {

    @Query("SELECT * FROM lists")
    fun getLists(): List<ListModel>

    @Query("SELECT * FROM lists WHERE lists.id = :listId")
    fun getList(listId: Int): ListModel

    @Query("INSERT INTO lists(id, name) VALUES (:listModel.id, :listModel.name)")
    fun addList(listModel: ListModel): ListModel

    @Query("DELETE FROM lists WHERE lists.id = :listId")
    fun deleteList(listId: Int)

}
