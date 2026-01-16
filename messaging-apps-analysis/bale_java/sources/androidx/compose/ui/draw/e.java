package androidx.compose.ui.draw;

import ir.nasim.AbstractC23642xG4;
import ir.nasim.C21226tK2;
import ir.nasim.C3587Bm4;
import ir.nasim.InterfaceC20014rK2;
import ir.nasim.M73;

/* loaded from: classes2.dex */
final class e implements InterfaceC20014rK2 {
    private C3587Bm4 a;
    private InterfaceC20014rK2 b;

    @Override // ir.nasim.InterfaceC20014rK2
    public C21226tK2 a() {
        InterfaceC20014rK2 interfaceC20014rK2 = this.b;
        if (!(interfaceC20014rK2 != null)) {
            M73.b("GraphicsContext not provided");
        }
        C21226tK2 c21226tK2A = interfaceC20014rK2.a();
        C3587Bm4 c3587Bm4 = this.a;
        if (c3587Bm4 == null) {
            this.a = AbstractC23642xG4.g(c21226tK2A);
        } else {
            c3587Bm4.n(c21226tK2A);
        }
        return c21226tK2A;
    }

    @Override // ir.nasim.InterfaceC20014rK2
    public void b(C21226tK2 c21226tK2) {
        InterfaceC20014rK2 interfaceC20014rK2 = this.b;
        if (interfaceC20014rK2 != null) {
            interfaceC20014rK2.b(c21226tK2);
        }
    }

    public final InterfaceC20014rK2 c() {
        return this.b;
    }

    public final void d() {
        C3587Bm4 c3587Bm4 = this.a;
        if (c3587Bm4 != null) {
            Object[] objArr = c3587Bm4.a;
            int i = c3587Bm4.b;
            for (int i2 = 0; i2 < i; i2++) {
                b((C21226tK2) objArr[i2]);
            }
            c3587Bm4.t();
        }
    }

    public final void e(InterfaceC20014rK2 interfaceC20014rK2) {
        d();
        this.b = interfaceC20014rK2;
    }
}
