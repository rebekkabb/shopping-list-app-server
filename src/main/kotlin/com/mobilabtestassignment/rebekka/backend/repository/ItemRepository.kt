package com.mobilabtestassignment.rebekka.backend.repository

import com.mobilabtestassignment.rebekka.backend.model.ItemModel
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: CrudRepository<ItemModel, Long> {

    @Query("SELECT * FROM items WHERE items.list_id = :listId ORDER BY id")
    fun getItems(listId: Int): List<ItemModel>

    @Modifying
    @Query("INSERT INTO items(list_id, value, checked_state) VALUES (:listId, :value, :checkedState)")
    fun addItem(listId: Int, value: String, checkedState: Boolean): Int

    @Modifying
    @Query("DELETE FROM items WHERE items.id = :itemId")
    fun deleteItem(itemId: Int)

    @Modifying
    @Query("UPDATE items SET checked_state = :itemStatus WHERE id = :itemId")
    fun changeItemStatus(itemId: Int, itemStatus: Boolean)
}
