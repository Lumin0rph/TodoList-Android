package fr.univangers.dcojucari.todolist

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.preference.CheckBoxPreference
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)


        val shared_pref = preferenceScreen.sharedPreferences

        val pref_screen = preferenceScreen

        val text_size_preference = findPreference<EditTextPreference>("key_pref_text_size")


        text_size_preference?.setOnPreferenceChangeListener { _, newValue ->
                val input = newValue.toString()

                if (isPositiveNumber(input)) {
                    true
                } else {
                    Toast.makeText(context, "La taille du texte doit être strictement positive", Toast.LENGTH_SHORT).show()
                    false // Don't allow the change
                }
            }


        for (i in 0 until pref_screen.preferenceCount) {
            val p = pref_screen.getPreference(i)
            if (p is EditTextPreference){

                val value = shared_pref!!.getString(p.key,"")
                p.summary = value
            }
        }
    }

    private fun isPositiveNumber(input: String): Boolean {
        return try {
            val number = input.toInt()  // Try converting to an integer
            number > 0  // Check if the number is positive
        } catch (e: NumberFormatException) {
            false  // If input is not a valid number, return false
        }
    }



}