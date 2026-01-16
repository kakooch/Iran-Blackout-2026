package ir.eitaa.ui.explore.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.explore.cells.HashtagCell;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class HashtagAdapter extends RecyclerListView.SelectionAdapter {
    Context context;
    ArrayList<String> hashtags;
    OnItemClicked onItemClicked;

    public interface OnItemClicked {
        void onItemClicked(int position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        return true;
    }

    public HashtagAdapter(ArrayList<String> hashtags, Context context, OnItemClicked onItemClicked) {
        this.hashtags = hashtags;
        this.context = context;
        this.onItemClicked = onItemClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HashtagCell hashtagCell = new HashtagCell(this.context);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
        if (viewType != 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = AndroidUtilities.dp(8.0f);
        }
        hashtagCell.setLayoutParams(layoutParams);
        return new RecyclerListView.Holder(hashtagCell);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) throws Resources.NotFoundException {
        HashtagCell hashtagCell = (HashtagCell) holder.itemView;
        if (position == this.hashtags.size()) {
            hashtagCell.setText(LocaleController.getString("More", R.string.More), Boolean.TRUE);
        } else {
            hashtagCell.setText(this.hashtags.get(position), Boolean.FALSE);
        }
        hashtagCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.adapter.HashtagAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                HashtagAdapter.this.onItemClicked.onItemClicked(holder.getAdapterPosition());
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.hashtags.size() + 1;
    }
}
