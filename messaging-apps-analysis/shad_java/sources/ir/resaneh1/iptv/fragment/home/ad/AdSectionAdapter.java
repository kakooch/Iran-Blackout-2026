package ir.resaneh1.iptv.fragment.home.ad;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.RecyclerListView;

/* compiled from: AdSectionAdapter.kt */
/* loaded from: classes3.dex */
public final class AdSectionAdapter extends RecyclerListView.SelectionAdapter {
    private int heightImage;
    private final ArrayList<HomePageModels.AdItemObject> items;
    private final Context mContext;
    private HomePageModels.MarginInfoObject marginInfoObject;
    private float ratio;
    private int widthImage;

    @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        return true;
    }

    public AdSectionAdapter(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.items = new ArrayList<>();
        this.widthImage = calculateWidth();
        this.ratio = 2.5f;
        this.heightImage = calculateHeight();
    }

    private final int calculateWidth() {
        HomePageModels.MarginInfoObject marginInfoObject = this.marginInfoObject;
        if (marginInfoObject != null) {
            return AndroidUtilities.getScreenWidth() - AndroidUtilities.dp((marginInfoObject.left + marginInfoObject.right) * 100);
        }
        return AndroidUtilities.getScreenWidth() - AndroidUtilities.dp(12.0f);
    }

    private final int calculateHeight() {
        return (int) (this.widthImage / this.ratio);
    }

    public final void setData(List<? extends HomePageModels.AdItemObject> collections, Float f, HomePageModels.MarginInfoObject marginInfoObject) {
        Unit unit;
        Intrinsics.checkNotNullParameter(collections, "collections");
        if (Intrinsics.areEqual(this.items, collections)) {
            return;
        }
        this.marginInfoObject = marginInfoObject;
        if (f == null) {
            unit = null;
        } else {
            float fFloatValue = f.floatValue();
            if (fFloatValue > 0.0f) {
                this.ratio = fFloatValue;
            } else {
                this.ratio = 2.5f;
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.ratio = 2.5f;
        }
        this.items.clear();
        this.items.addAll(collections);
        this.widthImage = calculateWidth();
        this.heightImage = calculateHeight();
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.items.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdItemCell adItemCell = new AdItemCell(this.mContext);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(this.widthImage, this.heightImage);
        layoutParams.setMargins(getHorizontalMargin(), 0, getHorizontalMargin(), 0);
        adItemCell.setLayoutParams(layoutParams);
        return new RecyclerListView.Holder(adItemCell);
    }

    private final int getHorizontalMargin() {
        HomePageModels.MarginInfoObject marginInfoObject = this.marginInfoObject;
        if (marginInfoObject != null) {
            return AndroidUtilities.dp((marginInfoObject.left + marginInfoObject.right) * 100) / 2;
        }
        return AndroidUtilities.dp(6.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (i >= 0 && i < this.items.size()) {
            AdItemCell adItemCell = (AdItemCell) holder.itemView;
            if (adItemCell.getHeight() != 0 && adItemCell.getHeight() != calculateHeight()) {
                RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(this.widthImage, this.heightImage);
                layoutParams.setMargins(getHorizontalMargin(), 0, getHorizontalMargin(), 0);
                adItemCell.setLayoutParams(layoutParams);
            }
            adItemCell.setData(this.items.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
