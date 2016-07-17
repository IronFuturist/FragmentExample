package com.megliosolutions.fragmentexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
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

    private MainActivity activity;
    private Context mContext;
    public Bundle bundle = new Bundle();

    private List<Movie> moviesList;


    public MoviesAdapter(Context context, List<Movie> moviesList) {
        this.mContext = context;
        this.moviesList = moviesList;
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
            //Show movie info in new fragment
            String mTitle = title.getText().toString();
            String mGenre = genre.getText().toString();
            String mYear = year.getText().toString();
            String movieStr = mTitle +
                    "\n " +  mGenre +
                    "\n " +  mYear;
            Toast.makeText(mContext,movieStr, Toast.LENGTH_SHORT).show();
            MovieInfo movie = new MovieInfo();
            bundle.putString("title",mTitle);
            bundle.putString("genre",mGenre);
            bundle.putString("year",mYear);
            movie.setArguments(bundle);

            FragmentManager fragmentManager = activity.getFragmentManager();
            //Replace intent with Bundle and put it in the transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frameLayout, movie);
            fragmentTransaction.commit();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    @Override
    public long getItemId(int position) {
        return moviesList.size();
    }
}