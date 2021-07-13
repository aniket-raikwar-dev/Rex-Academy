package com.example.rexacademy;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class comicAdapter extends FirebaseRecyclerAdapter<comicModel, comicAdapter.mycomicviewholder> {


/**
 * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
 * {@link FirebaseRecyclerOptions} for configuration options.
 *
 * @param options*/


    public comicAdapter(@NonNull FirebaseRecyclerOptions<comicModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final mycomicviewholder holder, int position, @NonNull final comicModel model) {

        holder.header.setText(model.getFilename());

        holder.writer.setText(model.getWriter());

        holder.description.setText(model.getDescription());

        Glide.with(holder.img1.getContext()).load(model.getImage()).into(holder.img1);

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.img1.getContext(), viewComicpdf.class);
                intent.putExtra("filename", model.getFilename());
                intent.putExtra("fileurl", model.getFileurl());
                intent.putExtra("decription", model.getDescription());
                intent.putExtra("writer", model.getWriter());
                intent.putExtra("image", model.getImage());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.img1.getContext().startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public mycomicviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlecomicdesign, parent, false);
        return new mycomicviewholder(view);
    }



    public class mycomicviewholder extends RecyclerView.ViewHolder{

        TextView header;
        TextView writer;
        ImageView img1;
        TextView description;


        public mycomicviewholder(@NonNull View itemView) {
            super(itemView);

            header = (TextView) itemView.findViewById(R.id.comicHeader_design);
            writer = (TextView) itemView.findViewById(R.id.comicWriter);
            img1 = (ImageView) itemView.findViewById(R.id.comic_poster_design);
            description = (TextView) itemView.findViewById(R.id.comicDescription);
        }
    }
}
