package com.mobilabtestassignment.rebekka.backend.repository

import com.mobilabtestassignment.rebekka.backend.model.ItemModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: CrudRepository<ItemModel, Long> {

    @Query("SELECT * FROM items WHERE items.list_id = :listId")
    fun getItems(listId: Int): List<ItemModel>

    @Query("INSERT INTO items(id, list_id, value, checkedState) VALUES (:itemModel.id, :itemModel.list_id, :itemModel.value, :itemModel.checkedState)")
    fun addItem(itemModel: ItemModel): ItemModel

    @Query("DELETE FROM items WHERE items.id = :itemId")
    fun deleteItem(itemId: Int)

    @Query("UPDATE items SET items.checked_state = itemStatus WHERE items.id = itemId")
    fun changeItemStatus(itemId: Int, itemStatus: Boolean)
}
