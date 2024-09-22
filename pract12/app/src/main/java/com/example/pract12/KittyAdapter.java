package com.example.pract12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KittyAdapter extends RecyclerView.Adapter<KittyAdapter.ViewHolder> {
    interface OnStateClickListener{
        void onStateClick(Kitty kitty, int position);
    }

    private final OnStateClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<Kitty> kitties;

    public KittyAdapter(OnStateClickListener onClickListener, Context context, List<Kitty> kitties) {
        this.onClickListener = onClickListener;
        this.kitties = kitties;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public KittyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KittyAdapter.ViewHolder holder, int position) {
        Kitty kitty = kitties.get(position);
        holder.picView.setImageResource(kitty.getPicResource());
        holder.nameView.setText(kitty.getName());
        holder.colorView.setText(kitty.getColor());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onStateClick(kitty, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kitties.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView picView;
        final TextView nameView, colorView;

        ViewHolder(View view) {
            super(view);
            picView = view.findViewById(R.id.pic);
            nameView = view.findViewById(R.id.name);
            colorView = view.findViewById(R.id.color);
        }
    }
}
