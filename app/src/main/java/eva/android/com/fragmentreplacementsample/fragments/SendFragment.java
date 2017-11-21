package eva.android.com.fragmentreplacementsample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eva.android.com.fragmentreplacementsample.R;

/**
 * Created by Vladimir on 21.11.2017.
 */

public class SendFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.send_fragment, container, false);
        return view;
    }
}
