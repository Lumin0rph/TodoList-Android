package fr.univangers.dcojucari.todolist

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import java.util.ArrayList
import kotlin.collections.ArrayList

class ActiviteListeTaches : AppCompatActivity() {

    private lateinit var dbHelper: TachesDBHelper

    private var adapter = AdapterTaches(this@ActiviteListeTaches)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activite_liste_taches)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*val taches : LinearLayout = findViewById(R.id.corps)

        for (str in FakeData.get_tasks()){
            val tv : TextView = TextView(this@ActiviteListeTaches)
            tv.text = str
            taches.addView(tv)
        }*/

        val rv: RecyclerView = findViewById(R.id.rv_taches)
        rv.layoutManager = LinearLayoutManager(this@ActiviteListeTaches)
        //val adapter = AdapterTaches(this@ActiviteListeTaches)
        rv.adapter = adapter


        dbHelper = TachesDBHelper(this)

        val item_touch_helper_callback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.itemView.tag as Int
                Log.d("POSITION",position.toString())
                dbHelper.deleteTaskByName(adapter.getListeTaches()[position].nom_tache)
                adapter.supprime(position)
            }
        }

        val item_touch_helper = ItemTouchHelper(item_touch_helper_callback)
        item_touch_helper.attachToRecyclerView(rv)



        val tasks : ArrayList<Tache> = dbHelper.getAllTasks()
        val intent = intent
        val nom : String? = intent.getStringExtra("EXTRA_NOM")
        val priorite : Int = intent.getIntExtra("EXTRA_PRIORITY",0)
        adapter.setListeTaches(tasks)

        if (nom != null){
            adapter.ajouteTache(nom,priorite)
            dbHelper.insertTask(nom,priorite)
        }

        if (savedInstanceState == null){
            adapter.setListeTaches(dbHelper.getAllTasks())
        }
        else {
            var l_taches : ArrayList<Tache> = savedInstanceState.getParcelableArrayList<Tache>("TACHES")!!
            adapter.setListeTaches(l_taches)
        }

        /*val db = dbHelper.writableDatabase
        db.execSQL("DELETE FROM ${TachesDBHelper.TABLE_NAME}")

        for (e in FakeData.get_tasks()){
            dbHelper.insertTask(e.substring(4),3)
        }
        db.close()*/



    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val pref_text_size = sharedPreferences.getString(getString(R.string.pref_text_size_key),"18f")
        Log.d("PREFERENCE TEXT SIZE",pref_text_size.toString())
        adapter.setTextSize(pref_text_size!!.toFloat())

        val areColored : Boolean = sharedPreferences.getBoolean(getString(R.string.key_show_priority),false)
        adapter.setPrioritiesColored(areColored)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("TACHES",adapter.getListeTaches())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.i_ajout_de_tache -> {
                val intent = Intent(this@ActiviteListeTaches,ActiviteAjoutTache::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun launch_preferences(view: View) {
        val startSettingIntent: Intent = Intent(this,SettingsActivity::class.java)
        startActivity(startSettingIntent)
    }

}