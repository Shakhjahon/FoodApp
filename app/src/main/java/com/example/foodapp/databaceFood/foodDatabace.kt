package com.example.foodapp.databaceFood

import android.content.Context
import com.example.foodapp.model.foodModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val SHARED_PREFENCES_KEY = "SHARED_PREFENCES_KEY"
private const val NOTES_SHARED_PREF = "NOTES_PREF"

class foodDatabace(
    context: Context,
) {
    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFENCES_KEY, Context.MODE_PRIVATE

    )

    fun getAllNotes(): List<foodModel> {
        val gson = Gson()
        val json = sharedPreferences.getString(NOTES_SHARED_PREF, null)
        val type: Type = object : TypeToken<ArrayList<foodModel?>?>() {}.type
        val noteList = gson.fromJson<ArrayList<foodModel>>(json, type)
        return noteList ?: emptyList()
    }

    fun saveNote(notesModel: foodModel) {
        val notes = getAllNotes().toMutableList()
        notes.add(0, notesModel)
        val notesGson = Gson().toJson(notes)
        sharedPreferences.edit().putString(NOTES_SHARED_PREF, notesGson).apply()
    }

    fun deleteNoteAtIndex(index: Int) {
        val getAllNotes = getAllNotes().toMutableList()
        if (index in 0 until getAllNotes.size) {
            getAllNotes.removeAt(index)
            val noteGsonString = Gson().toJson(getAllNotes)
            sharedPreferences.edit().putString(NOTES_SHARED_PREF, noteGsonString).apply()
        }
    }

    fun delelteAllNotes() {
        sharedPreferences.edit().clear().apply()
    }
}

