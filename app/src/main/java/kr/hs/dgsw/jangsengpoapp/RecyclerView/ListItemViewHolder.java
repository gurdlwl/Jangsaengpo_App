package kr.hs.dgsw.jangsengpoapp.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kr.hs.dgsw.jangsengpoapp.R;

public class ListItemViewHolder extends RecyclerView.ViewHolder {

    TextView textViewTitle;

    public ListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.Title);
    }
}
