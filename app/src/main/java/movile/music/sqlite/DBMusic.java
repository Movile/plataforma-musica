package movile.music.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

/**
 * Created by amktechnologies on 22/12/15.
 */
public class DBMusic extends SQLiteOpenHelper {

    public static String ID = "_id";

    public static String TABLA_ARTIST = "artits";
    public static String ARTIST_NAME = "name";
    public static String ARTIST_URL_IMAGE = "url_image";

    public static String TABLA_ALBUM = "album";
    public static String ALBUM_TITLE = "title";
    public static String ALBUM_DESCRIPTION = "description";
    public static String ALBUM_DURATION = "duration";
    public static String ALBUM_YEAR = "year";
    public static String ALBUM_NUMBER_SONG = "number_of_song";
    public static String ALBUM_URLIMAGE = "url_image";
    public static String ARTIST_ID_ARTIST = "id_artits";

    public static String TABLA_SONG = "song";
    public static String SONG_TITLE = "title";
    public static String SONG_DURATION = "duration";
    public static String SONG_NUMBER = "number";
    public static String SONG_RATING = "rating";
    public static String SONG_URL_SONG = "url_song";
    public static String SONG_ID_ALBUM = "id_album";

    private static final String DATABASENAME = "DBMusic";
    private static final int DATABASE_VERSION = 1;


    public DBMusic(Context context) {
        super ( context , Environment. getExternalStorageDirectory()
                +  File. separator +  "/DataBase/"  +  File . separator
                + DATABASENAME ,  null , DATABASE_VERSION );
        //super ( context ,DATABASENAME ,  null , DATABASE_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLA_ARTIST +
                "("+ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ARTIST_NAME + " TEXT, " +
                ARTIST_URL_IMAGE + " TEXT)");

        db.execSQL("CREATE TABLE " + TABLA_ALBUM +
                "("+ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + ALBUM_TITLE + " TEXT, " +
                ALBUM_DESCRIPTION + " TEXT, " + ALBUM_DURATION + " TEXT, " +
                ALBUM_YEAR + " TEXT, " + ALBUM_NUMBER_SONG + " TEXT, " +
                ALBUM_URLIMAGE + " TEXT, " + ARTIST_ID_ARTIST + " INTEGER)");

        db.execSQL("CREATE TABLE " + TABLA_SONG +
                "("+ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SONG_TITLE + " TEXT, " +
                SONG_DURATION + " TEXT, " + SONG_NUMBER + " TEXT, " +
                SONG_RATING + " TEXT, " + SONG_URL_SONG + " TEXT, " +
                SONG_ID_ALBUM + " INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
