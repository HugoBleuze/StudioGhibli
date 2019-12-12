package com.example.studioghibli.View;



import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.content.Intent;
import com.example.studioghibli.Model.Films;

import android.widget.TextView;
import com.example.studioghibli.R;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {
    private List<Films> values;
    private Context context;
    public static final String Id_Films = "idFilm";
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Title;
        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            Title = v.findViewById(R.id.firstLine);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FilmsAdapter(List<Films> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FilmsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddingrow_layouts and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Films currentMovie = values.get(position);   //Movie
        holder.Title.setText(currentMovie.getTitle());  //Movie.getTitle
        holder.Title.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent randomIntent = new Intent(context, DetailActivity.class);
                randomIntent.putExtra(Id_Films, currentMovie.getId());
                context.startActivity(randomIntent);
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}