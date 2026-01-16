package androidx.compose.ui.layout;

import androidx.compose.ui.e;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C4414Fa3;
import ir.nasim.InterfaceC9398Zt3;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
final class f extends e.c implements InterfaceC9398Zt3 {
    private UA2 o;
    private final boolean p = true;
    private long q;

    public f(UA2 ua2) {
        this.o = ua2;
        long j = RecyclerView.UNDEFINED_DURATION;
        this.q = C4414Fa3.c((j & 4294967295L) | (j << 32));
    }

    @Override // ir.nasim.InterfaceC9398Zt3
    public void S(long j) {
        if (C4414Fa3.e(this.q, j)) {
            return;
        }
        this.o.invoke(C4414Fa3.b(j));
        this.q = j;
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return this.p;
    }

    public final void v2(UA2 ua2) {
        this.o = ua2;
        long j = RecyclerView.UNDEFINED_DURATION;
        this.q = C4414Fa3.c((j & 4294967295L) | (j << 32));
    }
}
