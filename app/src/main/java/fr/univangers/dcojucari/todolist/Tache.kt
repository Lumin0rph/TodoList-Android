package fr.univangers.dcojucari.todolist

import android.os.Parcel
import android.os.Parcelable

class Tache(var nom_tache: String,var priorite: Int): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?:"",
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom_tache)
        parcel.writeInt(priorite)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Tache> {
        override fun createFromParcel(parcel: Parcel): Tache {
            return Tache(parcel)
        }

        override fun newArray(size: Int): Array<Tache?> {
            return arrayOfNulls(size)
        }
    }
}