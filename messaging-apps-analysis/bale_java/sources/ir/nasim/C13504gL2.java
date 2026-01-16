package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.gL2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13504gL2 extends RecyclerView.o {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private int e;

    public C13504gL2(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        AbstractC13042fc3.i(rect, "outRect");
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(recyclerView, "parent");
        AbstractC13042fc3.i(zVar, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0 || childAdapterPosition == 1 || childAdapterPosition == 2) {
            rect.top = AbstractC8943Xx1.b(this.a) * this.e;
        } else {
            rect.top = AbstractC8943Xx1.b(this.a);
        }
        if (childAdapterPosition == zVar.b() - 1 || childAdapterPosition == zVar.b() - 2 || childAdapterPosition == zVar.b() - 3) {
            rect.bottom = AbstractC8943Xx1.b(this.b) * this.e;
        } else {
            rect.bottom = AbstractC8943Xx1.b(this.b);
        }
        rect.left = AbstractC8943Xx1.b(this.d);
        rect.right = AbstractC8943Xx1.b(this.c);
    }

    public C13504gL2(float f, int i) {
        this(f, f, f, f);
        this.e = i;
    }
}
