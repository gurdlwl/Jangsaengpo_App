package kr.hs.dgsw.jangsengpoapp.SubRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.hs.dgsw.jangsengpoapp.R;

public class SubListAdapter extends RecyclerView.Adapter<SubListItemViewHolder> {
    private ArrayList<String> listData;
    private SubListClickListener listener;

    public SubListAdapter(ArrayList<String> data, SubListClickListener listener){
        this.listData = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SubListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list2, viewGroup, false);

        return new SubListItemViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubListItemViewHolder viewHolder, int i) {
        viewHolder.textViewTitle.setText(listData.get(i));

        final int index = i;
        viewHolder.itemView.setOnClickListener(v -> listener.onItemClick2(v, index));
    }

    @Override
    public int getItemCount() {
        if(listData == null)
            return 0;
        else
            return listData.size();
    }
}
