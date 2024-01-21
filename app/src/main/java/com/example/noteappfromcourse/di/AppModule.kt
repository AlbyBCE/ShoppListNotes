package com.example.noteappfromcourse.di

import android.app.Application
import androidx.room.Room
import com.example.noteappfromcourse.data.AddItemRepoImpl
import com.example.noteappfromcourse.data.AddItemRepository
import com.example.noteappfromcourse.data.MainDB
import com.example.noteappfromcourse.data.NoteRepoImpl
import com.example.noteappfromcourse.data.NoteRepository
import com.example.noteappfromcourse.data.ShoppingListRepoImpl
import com.example.noteappfromcourse.data.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDB(app: Application): MainDB {
        return Room.databaseBuilder(
            app,
            MainDB::class.java,
            name = "shop_list_db"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideShopRepo(mainDB: MainDB): ShoppingListRepository {
        return ShoppingListRepoImpl(mainDB.shoppingListDao)
    }

    @Provides
    @Singleton
    fun provideAddItemRepo(mainDB: MainDB): AddItemRepository {
        return AddItemRepoImpl(mainDB.addItemDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepo(mainDB: MainDB): NoteRepository {
        return NoteRepoImpl(mainDB.noteDao)
    }
}