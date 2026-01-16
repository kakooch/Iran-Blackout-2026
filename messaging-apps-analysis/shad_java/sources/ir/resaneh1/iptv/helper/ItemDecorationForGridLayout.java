package ir.resaneh1.iptv.helper;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class ItemDecorationForGridLayout extends RecyclerView.ItemDecoration {
    private int columns;
    private int mSizeGridSpacingPx;

    public ItemDecorationForGridLayout(int i, int i2) {
        this.mSizeGridSpacingPx = i;
        this.columns = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
        int i = this.columns;
        if (viewAdapterPosition < i) {
            rect.top = this.mSizeGridSpacingPx / 2;
        } else {
            rect.top = 0;
        }
        if (viewAdapterPosition % i == 0) {
            rect.left = 0;
            rect.right = this.mSizeGridSpacingPx / 2;
        } else if (viewAdapterPosition % i == i - 1) {
            rect.left = this.mSizeGridSpacingPx / 2;
            rect.right = 0;
        } else {
            rect.right = 0;
            rect.left = 0;
        }
        rect.bottom = 0;
    }
}
