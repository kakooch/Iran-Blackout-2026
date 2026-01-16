package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.sl, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20874sl extends RecyclerView.o {
    private final int a;

    public C20874sl(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        AbstractC13042fc3.i(rect, "outRect");
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(recyclerView, "parent");
        AbstractC13042fc3.i(zVar, "state");
        int i = this.a;
        rect.top = i / 2;
        rect.left = i / 2;
        rect.right = i / 2;
        rect.bottom = i / 2;
    }
}
