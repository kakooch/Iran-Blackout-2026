package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.Sn1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7626Sn1 extends e.c implements InterfaceC7163Qn6 {
    private boolean o;
    private boolean p;
    private UA2 q;

    public C7626Sn1(boolean z, boolean z2, UA2 ua2) {
        this.o = z;
        this.p = z2;
        this.q = ua2;
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public boolean L1() {
        return this.o;
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        this.q.invoke(interfaceC11943do6);
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public boolean g0() {
        return this.p;
    }

    public final void v2(boolean z) {
        this.o = z;
    }

    public final void w2(UA2 ua2) {
        this.q = ua2;
    }
}
