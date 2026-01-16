package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.eB4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12189eB4 {
    private final C12544en4 a = new C12544en4(new UA4[16], 0);
    private final C3587Bm4 b = new C3587Bm4(10);

    public boolean a(C21892uJ3 c21892uJ3, InterfaceC11379cu3 interfaceC11379cu3, C7286Rb3 c7286Rb3, boolean z) {
        C12544en4 c12544en4 = this.a;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        boolean z2 = false;
        for (int i = 0; i < iO; i++) {
            z2 = ((UA4) objArr[i]).a(c21892uJ3, interfaceC11379cu3, c7286Rb3, z) || z2;
        }
        return z2;
    }

    public void b(C7286Rb3 c7286Rb3) {
        int iO = this.a.o();
        while (true) {
            iO--;
            if (-1 >= iO) {
                return;
            }
            if (((UA4) this.a.a[iO]).l().f()) {
                this.a.w(iO);
            }
        }
    }

    public final void c() {
        this.a.k();
    }

    public void d() {
        C12544en4 c12544en4 = this.a;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            ((UA4) objArr[i]).d();
        }
    }

    public boolean e(C7286Rb3 c7286Rb3) {
        C12544en4 c12544en4 = this.a;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        boolean z = false;
        for (int i = 0; i < iO; i++) {
            z = ((UA4) objArr[i]).e(c7286Rb3) || z;
        }
        b(c7286Rb3);
        return z;
    }

    public boolean f(C21892uJ3 c21892uJ3, InterfaceC11379cu3 interfaceC11379cu3, C7286Rb3 c7286Rb3, boolean z) {
        C12544en4 c12544en4 = this.a;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        boolean z2 = false;
        for (int i = 0; i < iO; i++) {
            z2 = ((UA4) objArr[i]).f(c21892uJ3, interfaceC11379cu3, c7286Rb3, z) || z2;
        }
        return z2;
    }

    public final C12544en4 g() {
        return this.a;
    }

    public void h(long j, C3587Bm4 c3587Bm4) {
        C12544en4 c12544en4 = this.a;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            ((UA4) objArr[i]).h(j, c3587Bm4);
        }
    }

    public void i(e.c cVar) {
        this.b.t();
        this.b.n(this);
        while (this.b.h()) {
            C12189eB4 c12189eB4 = (C12189eB4) this.b.A(r0.e() - 1);
            int i = 0;
            while (i < c12189eB4.a.o()) {
                UA4 ua4 = (UA4) c12189eB4.a.a[i];
                if (AbstractC13042fc3.d(ua4.k(), cVar)) {
                    c12189eB4.a.t(ua4);
                    ua4.d();
                } else {
                    this.b.n(ua4);
                    i++;
                }
            }
        }
    }
}
