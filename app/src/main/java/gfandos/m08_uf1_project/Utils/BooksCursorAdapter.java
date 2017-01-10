package gfandos.m08_uf1_project.Utils;

/**
 * Created by Gerard on 10/01/2017.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.ImageVideoBitmapDecoder;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;

public class BooksCursorAdapter extends CupboardCursorAdapter<Book>{

    public BooksCursorAdapter(Context context, Class<Book> entityClass) {
        super(context, entityClass);
    }

    @Override
    public View newView(Context context, Book model, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.stored_book_row, parent, false);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Book model) {

        ImageView image = (ImageView) view.findViewById(R.id.storedBookImage);
        TextView rateTv = (TextView) view.findViewById(R.id.ratingTv);
        TextView coments = (TextView) view.findViewById(R.id.countComents);

        Glide.with(context).load(model.getImageURL()).into(image);
        rateTv.setText("Rating: none");
        coments.setText("Coments: 0");

    }

}
