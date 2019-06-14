package kr.hs.dgsw.jangsengpoapp.MainRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.hs.dgsw.jangsengpoapp.R;

public class MainListAdapter extends RecyclerView.Adapter<MainListItemViewHolder> {
    private ArrayList<String> listData;
    private MainListClickListener listener;

    public MainListAdapter(ArrayList<String> data, MainListClickListener listener){
        this.listData = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        return new MainListItemViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainListItemViewHolder viewHolder, int i) {
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
