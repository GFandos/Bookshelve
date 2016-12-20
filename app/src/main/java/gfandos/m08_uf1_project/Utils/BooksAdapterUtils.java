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

    public View getView(int position, View convertView, ViewGroup parent) {

        Book b =  getItem(position);
        Log.w("Book: ", b.toString());

        CardsRowsBinding binding = null;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.cards_rows, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }

        binding.cardName.setText(card.getName());
        binding.cardType.setText(card.getType());
        Glide.with(getContext()).load(card.getImageUrl()).into(binding.cardImage);

        return binding.getRoot();

    }

}
