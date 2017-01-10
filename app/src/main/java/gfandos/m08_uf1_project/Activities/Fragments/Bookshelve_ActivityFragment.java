package gfandos.m08_uf1_project.Activities.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import gfandos.m08_uf1_project.Activities.BookDetailActivity;
import gfandos.m08_uf1_project.Activities.StoredBookDetail_Activity;
import gfandos.m08_uf1_project.Pojos.Book;
import gfandos.m08_uf1_project.R;
import gfandos.m08_uf1_project.Utils.BooksCursorAdapter;
import gfandos.m08_uf1_project.Utils.DataManagerUtil;


/**
 * A placeholder fragment containing a simple view.
 */
public class Bookshelve_ActivityFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private BooksCursorAdapter adapter;

    public Bookshelve_ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bookshelve_, container, false);
        getLoaderManager().initLoader(0, null, this);
        adapter = new BooksCursorAdapter(getContext(), Book.class);

        ListView storedListView = (ListView) view.findViewById(R.id.storedListView);
        storedListView.setAdapter(adapter);

        storedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Book book = (Book) parent.getItemAtPosition(position);

                Intent intent = new Intent(getContext(), StoredBookDetail_Activity.class);
                intent.putExtra("book", book);

                startActivity(intent);

            }
        });

        return view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return DataManagerUtil.getCursorLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
