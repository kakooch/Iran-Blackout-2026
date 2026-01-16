package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.Uu3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8164Uu3 extends e.c implements InterfaceC24970zW4 {
    private float o;
    private boolean p;

    public C8164Uu3(float f, boolean z) {
        this.o = f;
        this.p = z;
    }

    @Override // ir.nasim.InterfaceC24970zW4
    /* renamed from: v2, reason: merged with bridge method [inline-methods] */
    public I66 C(WH1 wh1, Object obj) {
        I66 i66 = obj instanceof I66 ? (I66) obj : null;
        if (i66 == null) {
            i66 = new I66(0.0f, false, null, null, 15, null);
        }
        i66.g(this.o);
        i66.f(this.p);
        return i66;
    }

    public final void w2(boolean z) {
        this.p = z;
    }

    public final void x2(float f) {
        this.o = f;
    }
}
