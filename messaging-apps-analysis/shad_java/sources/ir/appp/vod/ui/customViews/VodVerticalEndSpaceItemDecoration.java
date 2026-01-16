package ir.appp.vod.ui.customViews;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VodVerticalEndSpaceItemDecoration.kt */
/* loaded from: classes3.dex */
public class VodVerticalEndSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int mHorizontalSpaceWidth;

    public VodVerticalEndSpaceItemDecoration(int i) {
        this.mHorizontalSpaceWidth = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int itemCount = state.getItemCount();
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (itemCount <= 0 || childAdapterPosition != itemCount - 1) {
            return;
        }
        outRect.bottom = this.mHorizontalSpaceWidth;
    }
}
