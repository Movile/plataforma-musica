package movile.music.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import movile.music.sqlite.DBMusic;

import movile.music.beans.Artist;


/**
 * Created by amktechnologies on 23/12/15.
 */
public class ArtistDataSource {

    private SQLiteDatabase databaseArtist;
    private DBMusic dbHelperArtist;

    public ArtistDataSource(Context context) {

        dbHelperArtist = new DBMusic(context);
    }

    /**
     * Abre conexion Base de datos en modo escritura
     */
    public void abrirEscritura() throws SQLException {
        databaseArtist = dbHelperArtist.getWritableDatabase();
    }

    /**
     * Abre conexion Base de datos en modo lectura
     */
    public void abrirLectura() throws SQLException {
        databaseArtist = dbHelperArtist.getReadableDatabase();
    }

    /**
     * Cierra conexion Base de datos
     */
    public void cerrar() {
        databaseArtist.close();
    }

    /**
     * Elimina tabla Artist
     */
    public void eliminar() {
        databaseArtist.delete(DBMusic.TABLA_ARTIST, null, null);
    }

    public boolean insertArtist(String name,String urlImage){
        boolean save=false;

        try{
            ContentValues registro = new ContentValues();
            registro.put(DBMusic.ARTIST_NAME, name);
            registro.put(DBMusic.ARTIST_URL_IMAGE, urlImage);
            databaseArtist.insert(DBMusic.TABLA_ARTIST, null, registro);
            save =true;

            Log.i("MusicApp", "Se inserto " + name + urlImage);
        }catch (Exception e){
            Log.e("MusicApp", e.getMessage());
        }
        return save;
    }

    public Cursor getArtist() {
        Cursor c = databaseArtist.rawQuery("select * from " + DBMusic.TABLA_ARTIST, null);
        return c;
    }


    public int getCantidadUsuarios() {
        int cantidad = 0;

        Cursor c = databaseArtist.rawQuery("select count(*) from " + DBMusic.TABLA_ARTIST, null);
        c.moveToFirst();
        cantidad = c.getInt(0);
        // Make sure to close the cursor
        c.close();
        return cantidad;
    }


    /**
     * Obtiene objeto de tipo Artits
     *
     * @return<Artist>
     */
    private Artist cursorToArtist(Cursor cursor) {
        Artist artist = new Artist();
        artist.setId(cursor.getInt(0));
        artist.setName(cursor.getString(1));
        artist.setUrlImage(cursor.getString(2));
        return artist;
    }
}
