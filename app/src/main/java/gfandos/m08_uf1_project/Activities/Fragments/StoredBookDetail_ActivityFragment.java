package gfandos.m08_uf1_project.Activities.Fragments;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;
import gfandos.m08_uf1_project.Utils.DataManagerUtil;

/**
 * A placeholder fragment containing a simple view.
 */
public class StoredBookDetail_ActivityFragment extends Fragment {

    RatingBar rate;
    Book book;

    public StoredBookDetail_ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stored_book_detail_, container, false);
        rate = (RatingBar) view.findViewById(R.id.ratingBar);
        final Button deleteButton = (Button) view.findViewById(R.id.delete);

        Intent i = getActivity().getIntent();

        if (i != null) {
            book = (Book) i.getSerializableExtra("book");

            if(book != null) {
                Log.d("BOOK:", book.toString());
                updateDetail(view, book);
            }
        }

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate.setRating(rate.getRating());
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DataManagerUtil.deletBook(getContext(), book);
            }
        });




        return view;
    }

    private void updateDetail(View v, Book b) {

        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        Glide.with(getContext()).load(b.getImageURL()).into(imageView);

    }
}
