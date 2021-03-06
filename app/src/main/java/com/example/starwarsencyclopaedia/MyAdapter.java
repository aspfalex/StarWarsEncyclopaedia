package com.example.starwarsencyclopaedia;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.starwarsencyclopaedia.model.Pokemon;




    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {
        private List<Pokemon> listValues;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class CelluleJava extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView txtHeader;
            public TextView txtFooter;
            public ImageView image;
            public View layout;

            //Constructeur
            public CelluleJava(View v) {
                super(v);
                layout = v;
                txtHeader = (TextView) v.findViewById(R.id.firstLine);
                txtFooter = (TextView) v.findViewById(R.id.secondLine);
                image = v.findViewById(R.id.icon);
            }
        }

        public void add(int position, Pokemon item) {
            listValues.add(position, item);
            notifyItemInserted(position);
        }

        public void remove(int position) {
            listValues.remove(position);
            notifyItemRemoved(position);
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(List<Pokemon> listValues) {
            this.listValues = listValues;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public CelluleJava onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
            // create a new view
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.row_layout, parent, false);
            // set the view's size, margins, paddings and layout parameters
            CelluleJava vh = new CelluleJava(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(CelluleJava holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            Pokemon currentPokemon = listValues.get(position);
            final String name = currentPokemon.getName();
            holder.txtHeader.setText(name);
            holder.txtHeader.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(position);
                }
            });

            holder.txtFooter.setText("Footer: " + name);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return listValues.size();
        }


    }
