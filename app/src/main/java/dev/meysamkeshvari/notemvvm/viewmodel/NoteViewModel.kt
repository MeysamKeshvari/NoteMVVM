package dev.meysamkeshvari.notemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.meysamkeshvari.notemvvm.repository.NoteRepository
import dev.meysamkeshvari.notemvvm.model.Note

class NoteViewModel : ViewModel() {
    var lst = MutableLiveData<ArrayList<Note>>()
    var newList = arrayListOf<Note>()
    private var noteRepository: NoteRepository = NoteRepository()

    fun getRepository(): MutableLiveData<List<Note>> {
        return noteRepository.getNotes()
    }

    fun add(note: Note) {
        newList.add(note)
        lst.value = newList
    }

    fun remove(note: Note) {
        newList.remove(note)
        lst.value = newList
    }

    fun edit(note: Note) {

    }
}