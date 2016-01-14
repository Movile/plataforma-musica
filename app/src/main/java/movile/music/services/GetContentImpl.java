package movile.music.services;

import android.os.AsyncTask;
import android.util.Log;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDACallback;
import com.contentful.java.cda.CDAClient;
import com.contentful.java.cda.CDAEntry;

import java.util.ArrayList;

import movile.music.beans.Album;
import movile.music.beans.Artist;
import movile.music.beans.Song;

/**
 * Created by amktechnologies on 23/12/15.
 */
public class GetContentImpl extends AsyncTask<String,Integer,String> {

    GetContent mListener;

    protected String doInBackground(String... params) {

      //  String url = params[0];
        try
        {
            CDAClient client = CDAClient.builder()
                    .setSpace("is0p2dn703un")
                    .setToken("3702bdcf504b39eb206ca9796d2ccb84bddf1a36c0368fc962cd0ccbbb4b14a1")
                    .build();

            client.fetch(CDAEntry.class).all(new CDACallback<CDAArray>() {
                        @Override
                        protected void onSuccess(CDAArray result) {
                        if (result != null && result.items() != null) {
                            Artist artist =new Artist();
                        for (int i = 0; i < result.items().size(); i++) {

                            CDAEntry entry = (CDAEntry) result.items().get(i);

                            if(entry.contentType().name().equalsIgnoreCase("Artist")){

                                artist.setName(entry.getField("name").toString());
                                artist.setUrlImage(entry.getField("urlImage").toString());
                                Log.d("MusicApp", artist.toString());
                                ArrayList arrayAlbum = (ArrayList) entry.getField("album");
                                Album album = new Album();

                                for (int x = 0; x < arrayAlbum.size(); x++) {
                                    CDAEntry entryAlbum = (CDAEntry) arrayAlbum.get(x);
                                    album.setTitle(entryAlbum.getField("title").toString());
                                    album.setDescription(entryAlbum.getField("description").toString());
                                    album.setDuration(entryAlbum.getField("duration").toString());
                                    album.setNumberOfSong(entryAlbum.getField("numberOfSongs").toString());
                                    album.setYear(entryAlbum.getField("year").toString());
                                    album.setUrlImageAlbum(entryAlbum.getField("urlImageAlbum").toString());

                                    Log.d("MusicApp", album.toString());
                                    ArrayList arraySong =  (ArrayList) entryAlbum.getField("song");
                                    Song song = new Song();

                                    for(int y=0; y<arraySong.size();y++){
                                        CDAEntry entrySong = (CDAEntry) arraySong.get(y);
                                        song.setTitle(entrySong.getField("title").toString());
                                        song.setDuration(entrySong.getField("duration").toString());
                                        song.setNumber(entrySong.getField("number").toString());
                                        song.setRating(entrySong.getField("rating").toString());
                                        song.setUrlSong(entrySong.getField("urlSong").toString());
                                        Log.d("MusicApp", song.toString());
                                    }
                                }
                            }
        }
    }
                        }
                    });
        }
        catch(Exception ex)
        {
            Log.e("MusicApp", "Error!", ex);
        }
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        Log.e("xx", result);
        mListener.callbackGetContent(result);
    }

    public void setListener(GetContent listener){
        mListener = listener;
    }
}
