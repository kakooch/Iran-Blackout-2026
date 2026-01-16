package ir.resaneh1.iptv.helper;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class ItemDecorationForHorizontal extends RecyclerView.ItemDecoration {
    private int spacePx;

    public ItemDecorationForHorizontal(int i) {
        this.spacePx = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
        rect.top = AndroidUtilities.dp(0.0f);
        rect.bottom = AndroidUtilities.dp(0.0f);
        if (viewAdapterPosition == 0) {
            rect.right = this.spacePx;
        } else {
            rect.right = this.spacePx / 2;
        }
        rect.left = this.spacePx / 2;
    }
}
