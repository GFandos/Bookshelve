package gfandos.m08_uf1_project.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;
import gfandos.m08_uf1_project.Utils.getBooksFromApiUtils;




/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private String searchQuery;
    private ArrayList<Book> books;

    private ArrayAdapter<String> adapter;

    public MainActivityFragment() {
        searchQuery = "";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button apiButton = (Button) getView().findViewById(R.id.apiButton);
        apiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), LibraryActivity.class);

                startActivity(i);
            }
        });

        Button getBooksButton = (Button) getView().findViewById(R.id.getBooksButton);
        EditText searchText = (EditText) getView().findViewById(R.id.searchText);

        //searchQuery = searchText.getText().toString();

        getBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search(getView());
            }
        });

    }

    private void Search(View v) {

        RefreshAsyncTask refreshAsyncTask = new RefreshAsyncTask();

        refreshAsyncTask.execute();

        FillList(v);

    }

    private void FillList(View v) {

        ListView lv = (ListView) v.findViewById(R.id.listView);

        ArrayList<String> titles = new ArrayList<>();

        for(int i = 0; i < books.size(); ++i) {
            titles.add(books.get(i).getTitle());
        }

        adapter = new ArrayAdapter<>(
            getContext(),
            R.layout.book_row,
            R.id.bookTitle,
            titles
        );
    }

    private class RefreshAsyncTask extends AsyncTask<Void, Void, ArrayList<Book>> {

        @Override
        protected ArrayList<Book> doInBackground(Void... voids) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            String rarity = preferences.getString("rarity", "");
            String color = preferences.getString("color", "");

            books = getBooksFromApiUtils.getBooks(searchQuery);

            for(int i = 0; i < books.size(); ++i) {
                Log.d("DEBUG", books.get(i).toString());
            }

            return books;
        }

        @Override
        protected void onPostExecute(ArrayList<Book> books) {
            adapter.clear();
            for (Book b : books) {
                adapter.add(b.getTitle());
            }
        }
    }
}
