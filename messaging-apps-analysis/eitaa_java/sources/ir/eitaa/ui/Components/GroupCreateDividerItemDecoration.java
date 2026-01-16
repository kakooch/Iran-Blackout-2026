package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.GroupCreateSectionCell;

/* loaded from: classes3.dex */
public class GroupCreateDividerItemDecoration extends RecyclerView.ItemDecoration {
    private boolean searching;
    private boolean single;
    private int skipRows;

    public void setSearching(boolean value) {
        this.searching = value;
    }

    public void setSingle(boolean value) {
        this.single = value;
    }

    public void setSkipRows(int value) {
        this.skipRows = value;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int width = recyclerView.getWidth();
        int childCount = recyclerView.getChildCount() - (!this.single ? 1 : 0);
        int i = 0;
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            View childAt2 = i < childCount + (-1) ? recyclerView.getChildAt(i + 1) : null;
            if (recyclerView.getChildAdapterPosition(childAt) >= this.skipRows && !(childAt instanceof GroupCreateSectionCell) && !(childAt2 instanceof GroupCreateSectionCell)) {
                float bottom = childAt.getBottom();
                canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(72.0f), bottom, width - (LocaleController.isRTL ? AndroidUtilities.dp(72.0f) : 0), bottom, Theme.dividerPaint);
            }
            i++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(android.graphics.Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = 1;
    }
}
