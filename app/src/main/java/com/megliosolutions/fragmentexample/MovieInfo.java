package com.megliosolutions.fragmentexample;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Meglio on 7/14/16.
 */
public class MovieInfo extends Fragment {

    private static final String TAG = MovieInfo.class.getSimpleName();
    public TextView title,genre,year;
    public String mTitle, mGenre, mYear;
    public Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_info,container,false);
        Log.i("MovieInfo", "Fragment has been made");

        initializeViews(view);

        getBundleArgs();

        return view;
    }

    private void initializeViews(View view) {
        title = (TextView) view.findViewById(R.id.movie_info_title);
        genre = (TextView) view.findViewById(R.id.movie_info_genre);
        year = (TextView) view.findViewById(R.id.movie_info_year);
    }

    private void getBundleArgs() {
        Bundle bundle = getArguments();
        String mTitle = bundle.getString("title", "AWESOME MOVIE");
        String mGenre = bundle.getString("genre", "ACTION PACKED");
        String mYear = bundle.getString("year", "2016");
        title.setText(mTitle);
        genre.setText(mGenre);
        year.setText(mYear);

        Log.d(TAG, "Title: " + mTitle);
        Log.d(TAG, "Genre: " + mGenre);
        Log.d(TAG, "Year:  " + mYear);

    }
}
