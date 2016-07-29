package com.example.usuario.joelfernandezpractica3;

/**
 * Created by Usuario on 28/07/2016.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdaptadorItems  extends RecyclerView.Adapter<MyItemHolder> {

    private List<ItemsObject> itemList;
    private Context context;

    public AdaptadorItems(Context context, List<ItemsObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MyItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        MyItemHolder rcv = new MyItemHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MyItemHolder holder, int position) {
        holder.countryName.setText(itemList.get(position).getTitulo());
        holder.countryPhoto.setImageResource(itemList.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
