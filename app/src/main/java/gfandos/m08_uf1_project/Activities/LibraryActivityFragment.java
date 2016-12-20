package gfandos.m08_uf1_project.Activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gfandos.m08_uf1_project.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class LibraryActivityFragment extends Fragment {

    public LibraryActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_library, container, false);
    }
}
