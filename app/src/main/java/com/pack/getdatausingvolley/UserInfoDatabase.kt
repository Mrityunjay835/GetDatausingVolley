package com.pack.getdatausingvolley

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserInfoItem::class],
        version = 1,
        exportSchema = true)
abstract class UserInfoDatabase :RoomDatabase(){

    companion object{
        var INSTANCE:UserInfoDatabase?=null

        fun getUserInfoDatabase(context: Context):UserInfoDatabase{
            if(INSTANCE == null){
             synchronized(this){
                 INSTANCE = Room.databaseBuilder(context.applicationContext,
                                                UserInfoDatabase::class.java,
                                                "userdatabase").build()
             }
            }
            return INSTANCE!!
        }
    }

    abstract fun gatUserDao(): UserInfoDao
}