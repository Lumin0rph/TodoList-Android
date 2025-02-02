package fr.univangers.dcojucari.todolist

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class AdapterTaches(val context: Context): RecyclerView.Adapter<AdapterTaches.TacheViewHolder>() {

    private var textSize: Float = 18f

    private var prioritiesColored: Boolean = true

    private fun getPrioriteCouleur(priorite: Int): Int{
        val couleur: Int

        when (priorite){
            1 -> {
                couleur = ContextCompat.getColor(context,R.color.priorite_basse)
            }
            2 -> {
                couleur = ContextCompat.getColor(context,R.color.priorite_moyenne)
            }
            3 -> {
                couleur = ContextCompat.getColor(context,R.color.priorite_haute)
            }
            else -> {
                couleur = ContextCompat.getColor(context,R.color.black)
            }
        }

        return couleur;
    }

    class TacheViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_tache = itemView.findViewById<TextView>(R.id.tv_tache)
        val v_priorite_couleur = itemView.findViewById<View>(R.id.v_priorite_couleur)
    }

    private var liste_taches: ArrayList<Tache> = ArrayList<Tache>()

    public fun setListeTaches(taches : ArrayList<Tache>){
        liste_taches = taches
    }

    public fun getListeTaches(): ArrayList<Tache> {
        return liste_taches
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TacheViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ligne, parent, false)
        return TacheViewHolder(view)
    }

    override fun getItemCount() = liste_taches.size

    override fun onBindViewHolder(holder: TacheViewHolder, position: Int) {
        val item = liste_taches[position]
        holder.tv_tache.text = item.nom_tache

        if (this.prioritiesColored) {
            holder.v_priorite_couleur.setBackgroundColor(getPrioriteCouleur(item.priorite))
        }
        else {
            holder.v_priorite_couleur.setBackgroundColor(0xFFFFFF)
        }


        holder.itemView.tag = position

        holder.tv_tache.setTextSize(textSize)
    }

    fun ajouteTache(nom_tache: String,priorite: Int){
        liste_taches.add(
            Tache(
                nom_tache,
                priorite
            )
        )
        notifyItemInserted(liste_taches.size-1)
    }

    fun getTache (position: Int): Tache {
        return liste_taches[position]
    }

    fun supprime(position: Int) {
        liste_taches.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,liste_taches.size - position)
    }

    fun setTextSize(textSize: Float){
        this.textSize=textSize
        notifyDataSetChanged()
    }

    fun setPrioritiesColored(areColored: Boolean){
        this.prioritiesColored = areColored
        notifyDataSetChanged()
    }

}