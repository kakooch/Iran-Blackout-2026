package ir.resaneh1.iptv.fragment.rubino;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RvUtil.kt */
/* loaded from: classes3.dex */
public final class RvUtilKt {
    public static final int getSnapPosition(SnapHelper snapHelper, RecyclerView recyclerView) {
        View viewFindSnapView;
        Intrinsics.checkNotNullParameter(snapHelper, "<this>");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null || (viewFindSnapView = snapHelper.findSnapView(layoutManager)) == null) {
            return -1;
        }
        return layoutManager.getPosition(viewFindSnapView);
    }
}
