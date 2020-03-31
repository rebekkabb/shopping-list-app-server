package com.mobilabtestassignment.rebekka.backend.repository

import com.mobilabtestassignment.rebekka.backend.model.ListModel
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * ListRepository holds all the database queries for each method defined in ListController
 */
@Repository
interface ListRepository : CrudRepository<ListModel, Long> {

    @Query("SELECT * FROM lists")
    fun getLists(): List<ListModel>

    @Query("SELECT * FROM lists WHERE lists.id = :listId")
    fun getList(listId: Int): ListModel?

    @Modifying
    @Query("INSERT INTO lists(name) VALUES (:name)")
    fun addList(name: String): Int

    @Modifying
    @Query("DELETE FROM lists WHERE lists.id = :listId")
    fun deleteList(listId: Int)

}
