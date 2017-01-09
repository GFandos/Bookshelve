package gfandos.m08_uf1_project.Activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Description_ActivityFragment extends Fragment {

    private Intent i;
    private Book book;

    public Description_ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_description_, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView bookDescription = (TextView) getView().findViewById(R.id.bookDescription);

        i = getActivity().getIntent();

        if (i != null) {
            book = (Book) i.getSerializableExtra("book");

            if(book != null) {
                Log.d("BOOK:", book.toString());
                bookDescription.setText(book.getDescription());
            }
        }

    }
}
