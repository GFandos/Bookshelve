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


            for (int i = 0; i < jsonItems.length(); ++i) {

                String title = "No title found";
                String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1000px-No_image_available.svg.png";
                ArrayList<String> authors = new ArrayList<>();
                String publisher = "No publisher found";
                String date = "No date found";
                String description = "No description found";

                JSONObject object = jsonItems.getJSONObject(i);

                if(object.get("kind").toString().contains("books")) {

                    JSONObject volumeInfo = object.getJSONObject("volumeInfo");

                    title = volumeInfo.get("title").toString();
                    JSONArray authorsArray;
                    if(volumeInfo.has("authors")) {
                        authorsArray = volumeInfo.getJSONArray("authors");
                        for(int j = 0; j < authorsArray.length(); ++j) {
                            authors.add(authorsArray.get(j).toString());
                            Log.d("AUTHORS:", authorsArray.getString(j));
                        }
                    } else {
                        authors.add("No author found");
                    }

                    if(volumeInfo.has("imageLinks")) {
                        JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                        if(imageLinks.has("smallThumbnail")) {
                            imageUrl = imageLinks.get("smallThumbnail").toString();
                        } else if(imageLinks.has("thumbnail")) {
                            imageUrl = imageLinks.get("thumbnail").toString();
                        }
                    }

                    if(volumeInfo.has("publisher")) {
                        publisher = volumeInfo.get("publisher").toString();
                    }
                    if(volumeInfo.has("publishedDate")) {
                        date = volumeInfo.get("publishedDate").toString();
                    }
                    if(volumeInfo.has("description")) {
                        description = volumeInfo.get("description").toString();
                    }

                    Book b = new Book(authors, title, imageUrl, publisher, date, description);
                    books.add(b);
                }
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
