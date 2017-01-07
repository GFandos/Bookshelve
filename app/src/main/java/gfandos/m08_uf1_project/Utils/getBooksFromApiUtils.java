package gfandos.m08_uf1_project.Utils;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import gfandos.m08_uf1_project.Pojos.Book;

/**
 * Created by 47989768s on 20/12/16.
 */

public class getBooksFromApiUtils {

    private static String url="https://www.googleapis.com/books/v1/volumes?";

    private static String getUrl(String search) {

        Uri builtUri = Uri.parse(url)
                .buildUpon()
                .appendQueryParameter("q", search)
                .build();
        Log.d("DEBUG", builtUri.toString() + ". Search = " + search);
        return builtUri.toString();

    }

    public static ArrayList<Book> getBooks(String search) {

        ArrayList<Book> books = new ArrayList<>();

        try {

            String newUrl = getUrl(search);
            JSONObject jsonO = new JSONObject(HttpUtils.get(newUrl));
            JSONArray jsonItems = jsonO.getJSONArray("items");
            String title = "No title found";
            String imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1000px-No_image_available.svg.png";
            ArrayList<String> authors = new ArrayList<>();

            for (int i = 0; i < jsonItems.length(); ++i) {

                JSONObject object = jsonItems.getJSONObject(i);

                if(object.get("kind").toString().contains("books")) {

                    JSONObject volumeInfo = object.getJSONObject("volumeInfo");

                    title = volumeInfo.get("title").toString();
                    String authorsString;
                    if(volumeInfo.has("authors")) {
                        authorsString = volumeInfo.getString("authors");
                    }
                    else authorsString = "No author found";

//                    for(int j = 0; j < authorsArray.length(); ++j) {
//                        authors.add(authorsArray.get(j).toString());
//                    }
                    if(volumeInfo.has("imageLinks")) {
                        JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                        if(imageLinks.has("smallThumbnail")) {
                            imageURL = imageLinks.get("smallThumbnail").toString();
                        } else if(imageLinks.has("thumbnail")) {
                            imageURL = imageLinks.get("thumbnail").toString();
                        }
                    }

                    authors.add(authorsString);
                }

                Book b = new Book(authors, title, imageURL);
                books.add(b);

            }

            for(int i = 0; i < books.size(); ++i) {
                Log.d("Llistat llibres: ", books.get(i).toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return books;

    }

}
