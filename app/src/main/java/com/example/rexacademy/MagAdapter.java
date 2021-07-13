package com.example.rexacademy;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MagAdapter extends FirebaseRecyclerAdapter<magModel, MagAdapter.mymagviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MagAdapter(@NonNull FirebaseRecyclerOptions<magModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final mymagviewholder holder, int position, @NonNull final magModel model) {
        holder.header.setText(model.getFilename());

        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.header.getContext(), viewMagPdf.class);
                intent.putExtra("filename", model.getFilename());
                intent.putExtra("fileurl", model.getFileurl());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.header.getContext().startActivity(intent);
            }
        });


    }

    @NonNull
    @Override
    public mymagviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlecomicdesign, parent, false);
        return new mymagviewholder(view);
    }



    public class mymagviewholder extends RecyclerView.ViewHolder{
        TextView header;

        public mymagviewholder(@NonNull View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.magHeader_design);
        }
    }
}
