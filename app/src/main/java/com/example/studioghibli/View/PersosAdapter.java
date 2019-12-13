package com.example.studioghibli.View;


import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.content.Intent;


import android.widget.TextView;

import com.example.studioghibli.Model.Persos;
import com.example.studioghibli.R;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public class PersosAdapter extends RecyclerView.Adapter<PersosAdapter.ViewHolder> {
    private List<Persos> valuesP;

    private Context context;
    public static final String Id_Persos = "idPeople";


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Name;
        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            Name = v.findViewById(R.id.firstLineP);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PersosAdapter(List<Persos> myDatasetP) {
        valuesP = myDatasetP;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public PersosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout_p, parent, false);
        // set the view's size, margins, paddingrow_layouts and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Persos currentPersos = valuesP.get(position);

        holder.Name.setText(currentPersos.getName());
        holder.Name.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent randomIntent = new Intent(context, DetailActivity.class);
                randomIntent.putExtra(Id_Persos, currentPersos.getId());
                context.startActivity(randomIntent);
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return valuesP.size();
    }

}