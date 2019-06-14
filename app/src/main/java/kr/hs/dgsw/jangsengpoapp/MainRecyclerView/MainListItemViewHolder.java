package kr.hs.dgsw.jangsengpoapp.MainRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kr.hs.dgsw.jangsengpoapp.R;

public class MainListItemViewHolder extends RecyclerView.ViewHolder {

    TextView textViewTitle;

    public MainListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.Title);
    }
}
