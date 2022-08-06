package dev.meysamkeshvari.notemvvm.repository

import androidx.lifecycle.MutableLiveData
import dev.meysamkeshvari.notemvvm.model.Note

class NoteRepository {
    private var mutableLiveData: MutableLiveData<List<Note>> = MutableLiveData<List<Note>>()

    fun getNotes(): MutableLiveData<List<Note>> {
        val note: List<Note> = listOf(
            Note("Title","Description"),
        )
        mutableLiveData.value = note
        return mutableLiveData
    }
}