package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public abstract class BG6 {
    public static final int a(androidx.recyclerview.widget.y yVar, RecyclerView recyclerView) {
        View viewF;
        AbstractC13042fc3.i(yVar, "<this>");
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null || (viewF = yVar.f(layoutManager)) == null) {
            return -1;
        }
        return layoutManager.i0(viewF);
    }
}
