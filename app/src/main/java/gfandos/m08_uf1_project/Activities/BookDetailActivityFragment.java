package gfandos.m08_uf1_project.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.databinding.DataBindingUtil;
import com.bumptech.glide.Glide;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;

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


    public BookDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_book_detail, container, false);

        Intent i = getActivity().getIntent();

        if (i != null) {
            Book book = (Book) i.getSerializableExtra("book");

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
        descriptionDetail = (TextView) view.findViewById(R.id.descriptionDetail);

        Glide.with(getContext()).load(b.getImageURL()).into(bookImage);
        titleDetail.setText(b.getTitle());

        String authors = "";
        for(int i = 0; i < b.getAuthor().size(); ++i) {
            if(i == b.getAuthor().size() - 1) {
                authors += b.getAuthor().get(i);
            } else {
                authors += b.getAuthor().get(i) + ", ";
            }

        }
        authorDetail.setText(authors);

        publisherDetail.setText(b.getPublisher());
        descriptionDetail.setText(b.getDescription());



    }
}
