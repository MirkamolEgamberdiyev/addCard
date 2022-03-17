package com.mirkamol.unicornexammodul6.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mirkamol.unicornexammodul6.model.CardDataItem

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(cardDataItem: CardDataItem)

    @Query("SELECT *FROM card")
    fun getUsers():List<CardDataItem>

    @Query("DELETE FROM card")
    fun deleteAllUsers()
}