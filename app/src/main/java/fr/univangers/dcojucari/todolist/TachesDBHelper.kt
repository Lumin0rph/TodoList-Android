package fr.univangers.dcojucari.todolist

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.TextView

class TachesDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "MA_BASE"
        val TABLE_NAME = "taches"
        val ID_COL = "id"
        val NOM_COL = "nom"
        val PRIORITE_COL = "priority"
    }

    override fun onCreate(db: SQLiteDatabase) =
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                ID_COL + " INTEGER PRIMARY KEY," +
                NOM_COL + " TEXT," +
                PRIORITE_COL + " INTEGER)")


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion:
    Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int,newVersion: Int) = onUpgrade(db, oldVersion, newVersion)

    fun insertTask(nom: String, priorite: Int){
        val  db = writableDatabase
        val cv = ContentValues()
        cv.put(NOM_COL,nom)
        cv.put(PRIORITE_COL,priorite)
        db.insert(TachesDBHelper.TABLE_NAME,null,cv)
        db.close()
    }

    fun getAllTasks(): ArrayList<Tache>{
        val taches = ArrayList<Tache>()
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(ID_COL, NOM_COL, PRIORITE_COL),
            null,null,null,null,null
        )

        while (cursor.moveToNext()){
            val nom = cursor.getString(cursor.getColumnIndexOrThrow(NOM_COL))
            val priorite = cursor.getInt(cursor.getColumnIndexOrThrow(PRIORITE_COL))
            taches.add(Tache(nom,priorite))
        }
        return taches
    }

    fun deleteTaskByName(taskName: String) {
        val db = writableDatabase
        val whereClause = "${NOM_COL} = ?"
        val whereArgs = arrayOf(taskName)


        db.delete(TABLE_NAME, whereClause, whereArgs)

        db.close()
    }



}