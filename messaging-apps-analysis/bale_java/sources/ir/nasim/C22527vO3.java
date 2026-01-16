package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.vO3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22527vO3 extends RecyclerView.o {
    private final int a;
    private final int b;
    private int c;
    private int d;
    private int e;

    public /* synthetic */ C22527vO3(int i, int i2, int i3, int i4, int i5, int i6, ED1 ed1) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        AbstractC13042fc3.i(rect, "outRect");
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(recyclerView, "parent");
        AbstractC13042fc3.i(zVar, "state");
        super.g(rect, view, recyclerView, zVar);
        int iB = zVar.b();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        if (childAdapterPosition == 0) {
            if (JF5.g()) {
                rect.set(this.c, this.d, this.a, this.e);
                return;
            } else {
                rect.set(this.a, this.d, this.c, this.e);
                return;
            }
        }
        if (iB <= 0 || childAdapterPosition != iB - 1) {
            int i = this.c;
            rect.set(i, this.d, i, this.e);
        } else if (JF5.g()) {
            rect.set(this.b, this.d, this.c, this.e);
        } else {
            rect.set(this.c, this.d, this.b, this.e);
        }
    }

    public C22527vO3(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.d = i4;
        this.e = i5;
        this.c = i3 / 2;
    }
}
