package com.pack.getdatausingvolley

import androidx.lifecycle.LiveData

class UserInfoRepo(var userInfoDao: UserInfoDao) {

    fun addUser(userInfoItem: UserInfoItem){
        userInfoDao.createUser(userInfoItem)
    }

    suspend fun updateUserInfo(userInfoItem: UserInfoItem){
        userInfoDao.updateUser(userInfoItem)
    }

    suspend fun deleteUserInfo(userInfoItem: UserInfoItem){
        userInfoDao.deleteUser(userInfoItem)
    }

    suspend fun getAllUserInfo():LiveData<List<UserInfoItem>>{
       return userInfoDao.getAllUser()
    }
}