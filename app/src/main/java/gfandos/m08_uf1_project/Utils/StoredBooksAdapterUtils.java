package gfandos.m08_uf1_project.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;

/**
 * Created by Gerard on 09/01/2017.
 */

public class StoredBooksAdapterUtils extends ArrayAdapter<Book> {

    public StoredBooksAdapterUtils(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Book book = getItem(position);
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.stored_book_row, parent, false);
        }

        ImageView storedBookImage = (ImageView) convertView.findViewById(R.id.storedBookImage);
        Glide.with(getContext()).load(book.getImageURL()).into(storedBookImage);

        return convertView;

    }

}
