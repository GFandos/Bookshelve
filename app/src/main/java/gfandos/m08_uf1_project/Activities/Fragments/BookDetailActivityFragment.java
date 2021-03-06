package gfandos.m08_uf1_project.Activities.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.databinding.DataBindingUtil;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import gfandos.m08_uf1_project.Activities.Description_Activity;
import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;
import gfandos.m08_uf1_project.Utils.ContentProviderUtil;
import gfandos.m08_uf1_project.Utils.DataManagerUtil;
import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * A placeholder fragment containing a simple view.
 */
public class BookDetailActivityFragment extends Fragment {

    private ImageView bookImage;
    private TextView titleDetail;
    private TextView authorDetail;
    private TextView publisherDetail;
    private TextView dateDetail;
    private TextView descriptionDetail;
    private View view;

    private Intent i;
    private Book book;


    public BookDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_book_detail, container, false);

        i = getActivity().getIntent();

        if (i != null) {
            book = (Book) i.getSerializableExtra("book");

            if(book != null) {
                Log.d("BOOK:", book.toString());
                updateDetail(book);
            }
        }

        return view;
    }

    private void updateDetail(Book b) {

        bookImage = (ImageView) view.findViewById(R.id.detailImage);
        titleDetail = (TextView) view.findViewById(R.id.titleDetail);
        authorDetail = (TextView) view.findViewById(R.id.authorDetail);
        publisherDetail = (TextView) view.findViewById(R.id.publisherDetail);

        Glide.with(getContext()).load(b.getImageURL()).into(bookImage);
        titleDetail.setText(b.getTitle());

        String authors = "";
        authors = b.getAuthor();
        authorDetail.setText(authors);

        publisherDetail.setText(b.getPublisher());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button fav = (Button) getView().findViewById(R.id.fav);
        Button descriptionButton = (Button) getView().findViewById(R.id.descriptionButton);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataManagerUtil.storeBook(book, getContext());
            }
        });

        descriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), Description_Activity.class);
                intent.putExtra("book", book);

                startActivity(intent);
            }
        });

    }


}
