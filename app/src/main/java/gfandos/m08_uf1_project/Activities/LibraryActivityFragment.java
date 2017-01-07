package gfandos.m08_uf1_project.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;
import gfandos.m08_uf1_project.Utils.getBooksFromApiUtils;
import gfandos.m08_uf1_project.databinding.FragmentMainBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class LibraryActivityFragment extends Fragment {

    private String searchQuery;
    private ArrayList<String> items;
    private ArrayList<Book> books;
    private FragmentMainBinding binding;

    private ArrayAdapter<String> adapter;

    public LibraryActivityFragment() {
        searchQuery = "";
        books = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_library, container, false);

        String startingData[] = {"NO DATA"};
        items = new ArrayList<>(Arrays.asList(startingData));

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.book_row,
                R.id.bookTitle,
                items
        );

        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button getBooksButton = (Button) getView().findViewById(R.id.getBooksButton);

        getBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search(view);
            }
        });

    }

    private void Search(View v) {

        RefreshAsyncTask refreshAsyncTask = new RefreshAsyncTask();

        refreshAsyncTask.execute();

    }

    private class RefreshAsyncTask extends AsyncTask<Void, Void, ArrayList<Book>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            EditText searchText = (EditText) getView().findViewById(R.id.searchText);

            searchQuery = searchText.getText().toString();
        }

        @Override
        protected ArrayList<Book> doInBackground(Void... voids) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

            books = getBooksFromApiUtils.getBooks(searchQuery);

            return books;
        }

        @Override
        protected void onPostExecute(ArrayList<Book> books) {

            adapter.clear();
            for (Book b : books) {
                adapter.add(b.getTitle());
            }

            ListView listView = (ListView) getView().findViewById(R.id.listView);
            listView.setAdapter(adapter);

        }
    }
}
