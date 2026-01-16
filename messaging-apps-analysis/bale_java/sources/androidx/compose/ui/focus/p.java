package androidx.compose.ui.focus;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC5283Ir2;

/* loaded from: classes2.dex */
final class p extends e.c implements InterfaceC5283Ir2 {
    private m o;

    public p(m mVar) {
        this.o = mVar;
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        super.e2();
        this.o.e().d(this);
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        this.o.e().t(this);
        super.f2();
    }

    public final m v2() {
        return this.o;
    }

    public final void w2(m mVar) {
        this.o = mVar;
    }
}
