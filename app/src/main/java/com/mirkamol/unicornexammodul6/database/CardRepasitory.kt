package com.mirkamol.unicornexammodul6.database

import android.app.Application
import com.mirkamol.unicornexammodul6.helper.Logger
import com.mirkamol.unicornexammodul6.manager.RoomManager
import com.mirkamol.unicornexammodul6.model.CardDataItem

class CardRepasitory(application: Application) {
    val TAG:String = CardRepasitory::class.java.simpleName

    private val db = RoomManager.getDatabase(application)
    private val cardDao:CardDao = db!!.cardDao()

    fun getUsers():List<CardDataItem>{
        Logger.d(TAG, "Done")

        return cardDao.getUsers()
    }

    fun saveUser(cardDataItem: CardDataItem){
        Logger.d(TAG, "Saved")
        cardDao.saveUser(cardDataItem)
    }

    fun deleteUsers(){
        Logger.d(TAG, "Database cleared")

        cardDao.deleteAllUsers()
    }
}