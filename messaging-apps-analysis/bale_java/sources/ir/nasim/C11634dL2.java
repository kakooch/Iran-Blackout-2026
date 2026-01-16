package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.dL2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11634dL2 extends RecyclerView.o {
    private final int a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public /* synthetic */ C11634dL2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ED1 ed1) {
        this(i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) == 0 ? i7 : 0);
    }

    private final int l(int i) {
        return n(i) ? this.f : this.g;
    }

    private final int m(int i) {
        return q(i) ? this.e : this.g;
    }

    private final boolean n(int i) {
        int i2 = i + 1;
        int i3 = this.a;
        return i2 <= i3 ? i2 == i3 : i + (1 % i3) == 0;
    }

    private final boolean o(int i) {
        return i + 1 <= this.a;
    }

    private final boolean p(int i, int i2) {
        int i3 = this.a;
        if (i + i3 < i2) {
            return false;
        }
        if (i2 % i3 == 0) {
            if (i + 1 < i2 - i3) {
                return false;
            }
        } else if (i + i3 <= i2 || i + (1 % i3) == 0) {
            return false;
        }
        return true;
    }

    private final boolean q(int i) {
        int i2 = i + 1;
        int i3 = this.a;
        if (i2 <= i3) {
            return i == 0;
        }
        return i3 + 1 == i3 + (i + (1 % i3));
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
        if (o(childAdapterPosition)) {
            rect.set(l(childAdapterPosition), this.b, m(childAdapterPosition), this.d);
        } else if (p(childAdapterPosition, iB)) {
            rect.set(l(childAdapterPosition), this.d, m(childAdapterPosition), this.c);
        } else {
            rect.set(l(childAdapterPosition), this.d, m(childAdapterPosition), this.d);
        }
    }

    public C11634dL2(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.e = i5;
        this.f = i6;
        this.d = i4 / 2;
        this.g = i7 / 2;
    }
}
