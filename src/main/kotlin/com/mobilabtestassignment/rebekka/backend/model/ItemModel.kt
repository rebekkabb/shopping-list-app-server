package com.mobilabtestassignment.rebekka.backend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class ItemModel (@Id
                      @GeneratedValue(strategy = GenerationType.AUTO)
                      val id: Int = 0,
                      val listId: Int,
                      val value: String,
                      val checkedState: Boolean){



}
