package fr.univangers.dcojucari.todolist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActiviteAjoutTache : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activite_ajout_tache)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun on_ajouter(view: View) {
        val id_bouton_priorite_clique = findViewById<RadioGroup>(R.id.rg_priorites).checkedRadioButtonId
        val tache_saisie = findViewById<EditText>(R.id.et_saisie_tache).text.toString()
        if (tache_saisie.isNotEmpty() && id_bouton_priorite_clique !=-1 ) {
            val texte_bouton_priorite_clique = findViewById<RadioButton>(id_bouton_priorite_clique).text.toString()
            Toast.makeText(
                this@ActiviteAjoutTache,
                String.format(
                    "Tâche : %s De priorité %s",
                    tache_saisie,
                    texte_bouton_priorite_clique
                ),
                Toast.LENGTH_LONG
            ).show()

            val priorite: Int
            when (texte_bouton_priorite_clique){
                "HAUTE" -> priorite = 3
                "MOYENNE" -> priorite = 2
                "BASSE" -> priorite = 1
                else -> priorite = 0
            }
            val intent = Intent(this, ActiviteListeTaches::class.java) // Create the Intent to start the second activity

            intent.putExtra("EXTRA_NOM", tache_saisie)       // Add data to the Intent
            intent.putExtra("EXTRA_PRIORITY", priorite) // Add another data value
            startActivity(intent)
        }
        else {
            Toast.makeText(
                this@ActiviteAjoutTache,
                String.format(
                    "Entrez une tâche et selectionner une priorité"
                ),
                Toast.LENGTH_LONG
            ).show()

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}