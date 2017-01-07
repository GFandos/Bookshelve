package gfandos.m08_uf1_project.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;

/**
 * Created by 47989768s on 20/12/16.
 */

public class BooksAdapterUtils extends ArrayAdapter<Book> {

    public BooksAdapterUtils(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Book book = getItem(position);
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.book_row, parent, false);
        }

        TextView author = (TextView) convertView.findViewById(R.id.bookAuthor);
        TextView title = (TextView) convertView.findViewById(R.id.bookTitle);

        author.setText(book.getAuthor().get(0));
        title.setText(book.getTitle());

        return convertView;

    }
}
