package gfandos.m08_uf1_project.Activities.Fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;
import gfandos.m08_uf1_project.Utils.BooksAdapterUtils;
import gfandos.m08_uf1_project.Utils.BooksCursorAdapter;
import gfandos.m08_uf1_project.Utils.StoredBooksAdapterUtils;

/**
 * A placeholder fragment containing a simple view.
 */
public class Bookshelve_ActivityFragment extends Fragment {

    private BooksCursorAdapter adapter;
    private ArrayList<Book> books;

    public Bookshelve_ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bookshelve_, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView storedListView = (ListView) getView().findViewById(R.id.storedListView);

        adapter = new BooksCursorAdapter(getContext(), Book.class);
        //storedListView.setAdapter(adapter);
    }
}
