package com.pack.getdatausingvolley

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createUser(userInfoItem: UserInfoItem)

    @Update
    fun updateUser(userInfoItem: UserInfoItem)

    @Delete
    fun deleteUser(userInfoItem: UserInfoItem)

    @Query("SELECT * FROM userinfo_table ORDER BY name" )
    fun getAllUser(): LiveData<List<UserInfoItem>>

}