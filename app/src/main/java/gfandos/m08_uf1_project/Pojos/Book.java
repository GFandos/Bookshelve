package gfandos.m08_uf1_project.Pojos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 47989768s on 20/12/16.
 */

public class Book implements Serializable{

    private String authors;
    private String title;
    private String imageURL;
    private String publisher;
    private String publishedDate;
    private String description;

    public Book(String a, String t, String url, String pub, String date, String descr) {
        authors = a;
        title = t;
        imageURL = url;
        publisher = pub;
        publishedDate = date;
        description = descr;
    }

    public String toString(){
        String retValue = "Títle: " + title + ". Author: " + authors + ". Image: " + imageURL + ". Publisher: " + publisher + ". PublishedDate: " + publishedDate + ". Description: " + description;

        return retValue;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getAuthor() {
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
