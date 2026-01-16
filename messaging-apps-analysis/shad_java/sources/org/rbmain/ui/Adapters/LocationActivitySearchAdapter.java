package org.rbmain.ui.Adapters;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import org.rbmain.tgnet.TLRPC$TL_messageMediaVenue;
import org.rbmain.ui.Cells.LocationCell;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class LocationActivitySearchAdapter extends BaseLocationAdapter {
    private Context mContext;

    @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        return true;
    }

    public LocationActivitySearchAdapter(Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.places.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RecyclerListView.Holder(new LocationCell(this.mContext, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((LocationCell) viewHolder.itemView).setLocation(this.places.get(i), this.iconUrls.get(i), i, i != this.places.size() - 1);
    }

    public TLRPC$TL_messageMediaVenue getItem(int i) {
        if (i < 0 || i >= this.places.size()) {
            return null;
        }
        return this.places.get(i);
    }
}
