package com.example.georges.tourapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.util.HashMap;

/**
 * Cette classe fait l'interface avec la base de données.
 * @author
 *
 */

public class Database extends SQLiteOpenHelper {

    private static final String TABLE_ACT = "table_activite";
    private static final String COL_IDACT = "id";
    private static final String COL_USRMAIL = "USRMAIL";
    private static final String COL_PAYS = "PAYS";
    private static final String COL_VILLES = "VILLES";
    private static final String COL_ADD = "ADRESSE";
    private static final String COL_OPENDATE = "OPENDATE";
    private static final String COL_HOPEN = "HOPEN";
    private static final String COL_HCLOSE = "HCLOSE";
    private static final String COL_DESCR = "DESCRIPTION";
    private static final String COL_TITLE = "TITLE";

    private static final String TABLE_USER = "table_user";
    private static final String COL_ID = "ID";
    private static final String COL_NOM = "NOM";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_PASSWORD = "PASSWORD";


    private static final String CREATE_ACTBD = "CREATE TABLE " + TABLE_ACT + " ("
            + COL_IDACT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_USRMAIL + " TEXT NOT NULL, "
            + COL_PAYS + " TEXT NOT NULL, " + COL_VILLES + " TEXT NOT NULL, "
            + COL_ADD + " TEXT NOT NULL, " + COL_TITLE + " TEXT NOT NULL, "
            + COL_DESCR + " TEXT NOT NULL, " + COL_OPENDATE + " TEXT, "
            + COL_HOPEN + " TEXT," + COL_HCLOSE + " TEXT);";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_USER + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM + " TEXT NOT NULL, "
            + COL_EMAIL + " TEXT NOT NULL," + COL_PASSWORD + " TEXT NOT NULL);";

    public Database(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_ACTBD);
        db.execSQL(CREATE_BDD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_USER + ";");
        db.execSQL("DROP TABLE " + TABLE_ACT + ";");
        onCreate(db);
    }

}