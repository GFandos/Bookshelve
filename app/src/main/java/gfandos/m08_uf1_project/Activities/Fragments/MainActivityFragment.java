package gfandos.m08_uf1_project.Activities.Fragments;

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

import gfandos.m08_uf1_project.Activities.Bookshelve_Activity;
import gfandos.m08_uf1_project.Activities.LibraryActivity;
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
        Button bookshelveButton = (Button) getView().findViewById(R.id.bookshelveButton);

        apiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), LibraryActivity.class);

                startActivity(i);
            }
        });

        bookshelveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), Bookshelve_Activity.class);

                startActivity(i);
            }
        });
    }
}
