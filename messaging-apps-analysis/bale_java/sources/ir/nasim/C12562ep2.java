package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.ep2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12562ep2 extends RecyclerView.o {
    private final int a;

    public C12562ep2(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        AbstractC13042fc3.i(rect, "outRect");
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(recyclerView, "parent");
        AbstractC13042fc3.i(zVar, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        boolean z = childAdapterPosition == zVar.b() - 1;
        boolean z2 = childAdapterPosition == 0;
        if (z) {
            rect.right = this.a;
        }
        if (z2) {
            rect.left = this.a;
        }
    }
}
