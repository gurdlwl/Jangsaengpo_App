package kr.hs.dgsw.jangsengpoapp.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.hs.dgsw.jangsengpoapp.R;

public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {
    private ArrayList<String> listData;
    private ListClickListener listener;

    public ListAdapter(ArrayList<String> data, ListClickListener listener){
        this.listData = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        return new ListItemViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder viewHolder, int i) {
        viewHolder.textViewTitle.setText(listData.get(i));

        final int index = i;
        viewHolder.itemView.setOnClickListener(v -> listener.onItemClick(v, index));
    }

    @Override
    public int getItemCount() {
        if(listData == null)
            return 0;
        else
            return listData.size();
    }
}
