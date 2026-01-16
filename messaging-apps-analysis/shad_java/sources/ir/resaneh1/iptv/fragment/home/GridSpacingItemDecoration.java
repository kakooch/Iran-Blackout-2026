package ir.resaneh1.iptv.fragment.home;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;

/* compiled from: GridSpacingItemDecoration.kt */
/* loaded from: classes3.dex */
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int spacing = AndroidUtilities.dp(50.0f);

    public final void setSpacing(int i) {
        this.spacing = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (parent.getChildAdapterPosition(view) == 1) {
            outRect.right = -this.spacing;
        }
    }
}
