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


public class showBookAdapter extends FirebaseRecyclerAdapter<bookModel, showBookAdapter.mybookviewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public showBookAdapter(@NonNull FirebaseRecyclerOptions<bookModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final mybookviewholder holder, int position, @NonNull final bookModel model) {

        holder.header.setText(model.getFilename());
        holder.writer.setText(model.getWriter());
        holder.description.setText(model.getDescription());
        Glide.with(holder.book_image.getContext()).load(model.getImage()).into(holder.book_image);

                holder.book_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(holder.book_image.getContext(), viewPdf.class);

                        intent.putExtra("filename", model.getFilename());
                        intent.putExtra("fileurl", model.getFileurl());
                        intent.putExtra("writer", model.getWriter());
                        intent.putExtra("description", model.getDescription());
                        intent.putExtra("image", model.getImage());

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        holder.book_image.getContext().startActivity(intent);

                    }
                });




    }

    @NonNull
    @Override
    public mybookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlebookrow, parent, false);
        return new mybookviewholder(view);
    }

    public class mybookviewholder extends RecyclerView.ViewHolder
    {

        ImageView book_image;
        TextView header;
        TextView writer;
        TextView description;

        public mybookviewholder(@NonNull View itemView) {
            super(itemView);

            book_image = (ImageView) itemView.findViewById(R.id.book_image);
            header = (TextView) itemView.findViewById(R.id.header);
            writer = (TextView) itemView.findViewById(R.id.writer);
            description = (TextView) itemView.findViewById(R.id.description);

        }
    }
}
