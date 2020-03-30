package com.mobilabtestassignment.rebekka.backend.repository

import com.mobilabtestassignment.rebekka.backend.model.ItemModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: CrudRepository<ItemModel, Long> {

    @Query("SELECT * FROM lists")
    fun getItems(listId: Int): List<ItemModel>

    /*
    @Query("")
    fun addItem(itemModel: ItemModel): ItemModel

     */
}
