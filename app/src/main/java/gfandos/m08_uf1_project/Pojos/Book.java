package gfandos.m08_uf1_project.Pojos;

import java.util.ArrayList;

/**
 * Created by 47989768s on 20/12/16.
 */

public class Book {

    ArrayList<String> authors;
    String title;
    String imageURL;

    public Book(ArrayList<String> a, String t, String url) {
        authors = a;
        title = t;
        imageURL = url;
    }

    public String toString(){
        String retValue = "Títle: " + title + ". Author: " + authors.get(0) + ". Image: " + imageURL;

        return retValue;
    }

    public ArrayList<String> getAuthor() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

}
