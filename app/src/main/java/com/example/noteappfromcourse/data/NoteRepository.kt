package com.example.noteappfromcourse.data


import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertItem(item: NoteItem)
    suspend fun deleteItem(item: NoteItem)
    fun getAllItemsById(): Flow<List<NoteItem>>
    suspend fun getNoteItemById(id: Int): NoteItem
}