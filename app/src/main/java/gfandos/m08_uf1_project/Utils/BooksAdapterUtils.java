package gfandos.m08_uf1_project.Utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import gfandos.m08_uf1_project.Pojos.Book;

/**
 * Created by 47989768s on 20/12/16.
 */

public class BooksAdapterUtils extends ArrayAdapter<Book> {

    public BooksAdapterUtils(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
    }



}
