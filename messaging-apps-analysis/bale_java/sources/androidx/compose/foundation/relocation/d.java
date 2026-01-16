package androidx.compose.foundation.relocation;

import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC7598Sk0;

/* loaded from: classes.dex */
public final class d extends e.c {
    private InterfaceC7598Sk0 o;
    private final boolean p;

    public d(InterfaceC7598Sk0 interfaceC7598Sk0) {
        this.o = interfaceC7598Sk0;
    }

    private final void v2() {
        InterfaceC7598Sk0 interfaceC7598Sk0 = this.o;
        if (interfaceC7598Sk0 instanceof a) {
            AbstractC13042fc3.g(interfaceC7598Sk0, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((a) interfaceC7598Sk0).b().t(this);
        }
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return this.p;
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        w2(this.o);
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        v2();
    }

    public final void w2(InterfaceC7598Sk0 interfaceC7598Sk0) {
        v2();
        if (interfaceC7598Sk0 instanceof a) {
            ((a) interfaceC7598Sk0).b().d(this);
        }
        this.o = interfaceC7598Sk0;
    }
}
