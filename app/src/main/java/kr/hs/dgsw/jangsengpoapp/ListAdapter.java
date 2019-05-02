package kr.hs.dgsw.jangsengpoapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private List<String> listData = Arrays.asList("스토리텔링", "영상", "스탬프", "장생포 한 눈에 보기");
    private ListClickListener listener;

    public ListAdapter(ListClickListener listener){
            this.listener = listener;
    }

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
