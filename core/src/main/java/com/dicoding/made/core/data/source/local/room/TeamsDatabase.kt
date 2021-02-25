package com.dicoding.made.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.made.core.data.source.local.entity.TeamsEntity


@Database(entities = [TeamsEntity::class], version = 1, exportSchema = false)
abstract class TeamsDatabase : RoomDatabase() {
    abstract fun teamsDao() : TeamsDao
}