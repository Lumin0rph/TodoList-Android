package fr.univangers.dcojucari.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat

class OldAdapterTaches (private val context: Context): BaseAdapter() {

    private var liste_taches: ArrayList<Tache> = ArrayList<Tache>()


    override fun getCount(): Int {
        return liste_taches.size
    }

    override fun getItem(position: Int): Tache {
        return liste_taches[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var nView: View? = convertView
        if (nView == null){
            nView = LayoutInflater.from(context).inflate(R.layout.ligne,parent,false)
        }

        val wTache = nView!!.findViewById<TextView>(R.id.tv_tache)
        val wPriorite= nView.findViewById<View>(R.id.v_priorite_couleur)

        wTache.text=getItem(position).nom_tache

        when (getItem(position).priorite) {
            1 -> {
                wPriorite.setBackgroundColor(ContextCompat.getColor(context,R.color.priorite_basse))
            }
            2 -> {
                wPriorite.setBackgroundColor(ContextCompat.getColor(context,R.color.priorite_moyenne))
            }
            3 -> {
                wPriorite.setBackgroundColor(ContextCompat.getColor(context,R.color.priorite_haute))
            }
            else -> {
                wPriorite.setBackgroundColor(ContextCompat.getColor(context,R.color.black))
            }
        }

        return nView
    }

    fun ajouteTache(nom_tache: String,priorite: Int){
        liste_taches.add(Tache(nom_tache,priorite))
        notifyDataSetChanged()
    }
}