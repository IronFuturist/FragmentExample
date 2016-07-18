package com.megliosolutions.fragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Meglio on 7/13/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private static final String TAG = MoviesAdapter.class.getSimpleName();
    private Context mContext;
    private List<Movie> moviesList;
    public MainActivity activity;
    public FragmentManager fragmentManager;
    public Movie mInfo;
    public String mTitleStr, mGenreStr, mYearStr;

    public MoviesAdapter(Context context, List<Movie> moviesList) {
        this.mContext = context;
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener{
        public TextView title, year, genre;
        public RelativeLayout mRelativeLayout;

        public MyViewHolder(View view) {
            super(view);
            mRelativeLayout = (RelativeLayout) view.findViewById(R.id.movie_item_relativeLayout);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);

            mRelativeLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            MovieInfo movie = new MovieInfo();
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            fragmentManager = activity.getFragmentManager();
            Bundle bundle = new Bundle();
            bundle.putString("title",title.getText().toString());
            bundle.putString("genre",genre.getText().toString());
            bundle.putString("year",year.getText().toString());
            movie.setArguments(bundle);
            //Replace intent with Bundle and put it in the transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frameLayout, movie);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}