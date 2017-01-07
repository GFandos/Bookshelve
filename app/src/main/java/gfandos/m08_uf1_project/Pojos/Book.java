package gfandos.m08_uf1_project.Pojos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 47989768s on 20/12/16.
 */

public class Book implements Serializable{

    ArrayList<String> authors;
    String title;
    String imageURL;
    String publisher;
    String publishedDate;
    String description;

    public Book(ArrayList<String> a, String t, String url, String pub, String date, String descr) {
        authors = a;
        title = t;
        imageURL = url;
        publisher = pub;
        publishedDate = date;
        description = descr;
    }

    public String toString(){
        String retValue = "Títle: " + title + ". Author: " + authors.get(0) + ". Image: " + imageURL;

        return retValue;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ArrayList<String> getAuthor() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }
}
