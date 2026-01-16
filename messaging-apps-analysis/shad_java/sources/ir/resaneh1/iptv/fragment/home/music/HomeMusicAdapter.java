package ir.resaneh1.iptv.fragment.home.music;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeMusicAdapter.kt */
/* loaded from: classes3.dex */
public final class HomeMusicAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final ArrayList<HomePageModels.MusicItem> data;
    private int emptyRow;
    private int musicEndRow;
    private int musicStartRow;
    private int rowCount;

    public HomeMusicAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.data = new ArrayList<>();
        this.musicStartRow = -1;
        this.musicEndRow = -1;
        this.emptyRow = -1;
    }

    /* compiled from: HomeMusicAdapter.kt */
    public enum TYPE {
        MUSIC_CELL(0),
        EMPTY_CELL(1);

        private final int value;

        TYPE(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public final void setData(List<? extends HomePageModels.MusicItem> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data.clear();
        this.data.addAll(newData);
        updateRows();
    }

    public final void clearData() {
        this.data.clear();
        notifyDataSetChanged();
    }

    private final void updateRows() {
        resetRows();
        if (this.data.isEmpty()) {
            int i = this.rowCount;
            this.rowCount = i + 1;
            this.emptyRow = i;
        } else {
            int i2 = this.rowCount;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.musicStartRow = i2;
            int size = i3 + this.data.size();
            this.rowCount = size;
            this.musicEndRow = size - 1;
        }
        notifyDataSetChanged();
    }

    private final void resetRows() {
        this.rowCount = 0;
        this.musicStartRow = -1;
        this.musicEndRow = -1;
        this.emptyRow = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i == TYPE.MUSIC_CELL.getValue()) {
            view = new HomeMusicItemCell(this.context);
        } else if (i == TYPE.EMPTY_CELL.getValue()) {
            view = new HomeMusicEmptyCell(this.context);
        } else {
            view = new View(this.context);
        }
        setLayoutParams(view);
        return new ViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.rowCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (getItemViewType(i) == TYPE.MUSIC_CELL.getValue()) {
            HomeMusicItemCell homeMusicItemCell = (HomeMusicItemCell) holder.itemView;
            HomePageModels.MusicItem musicItem = this.data.get(i);
            Intrinsics.checkNotNullExpressionValue(musicItem, "data[position]");
            homeMusicItemCell.setData(musicItem);
        }
    }

    private final void setLayoutParams(View view) {
        view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(view.getLayoutParams());
        marginLayoutParams.setMargins(0, 10, 0, 10);
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == this.emptyRow) {
            return TYPE.EMPTY_CELL.getValue();
        }
        int i2 = this.musicStartRow;
        boolean z = false;
        if (i < this.musicEndRow && i2 <= i) {
            z = true;
        }
        if (z) {
            return TYPE.MUSIC_CELL.getValue();
        }
        return -1;
    }

    /* compiled from: HomeMusicAdapter.kt */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }
}
