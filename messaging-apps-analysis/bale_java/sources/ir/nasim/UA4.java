package ir.nasim;

import androidx.compose.ui.e;
import java.util.List;

/* loaded from: classes2.dex */
public final class UA4 extends C12189eB4 {
    private final e.c c;
    private InterfaceC11379cu3 f;
    private C3534Bg5 g;
    private boolean h;
    private final C6361Ng5 d = new C6361Ng5();
    private final C21892uJ3 e = new C21892uJ3(2);
    private boolean i = true;
    private boolean j = true;

    public UA4(e.c cVar) {
        this.c = cVar;
    }

    private final void j() {
        this.e.c();
        this.f = null;
    }

    private final boolean m(C3534Bg5 c3534Bg5, C3534Bg5 c3534Bg52) {
        if (c3534Bg5 == null || c3534Bg5.c().size() != c3534Bg52.c().size()) {
            return true;
        }
        int size = c3534Bg52.c().size();
        for (int i = 0; i < size; i++) {
            if (!ZG4.j(((C6616Og5) c3534Bg5.c().get(i)).h(), ((C6616Og5) c3534Bg52.c().get(i)).h())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0264  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    @Override // ir.nasim.C12189eB4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(ir.nasim.C21892uJ3 r45, ir.nasim.InterfaceC11379cu3 r46, ir.nasim.C7286Rb3 r47, boolean r48) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UA4.a(ir.nasim.uJ3, ir.nasim.cu3, ir.nasim.Rb3, boolean):boolean");
    }

    @Override // ir.nasim.C12189eB4
    public void b(C7286Rb3 c7286Rb3) {
        super.b(c7286Rb3);
        C3534Bg5 c3534Bg5 = this.g;
        if (c3534Bg5 == null) {
            return;
        }
        this.h = this.i;
        List listC = c3534Bg5.c();
        int size = listC.size();
        for (int i = 0; i < size; i++) {
            C6616Og5 c6616Og5 = (C6616Og5) listC.get(i);
            boolean z = !c6616Og5.i();
            boolean z2 = !c7286Rb3.a(c6616Og5.f());
            boolean z3 = !this.i;
            if ((z && z2) || (z && z3)) {
                this.d.g(c6616Og5.f());
            }
        }
        this.i = false;
        this.j = AbstractC4236Eg5.i(c3534Bg5.g(), AbstractC4236Eg5.a.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // ir.nasim.C12189eB4
    public void d() {
        C12544en4 c12544en4G = g();
        Object[] objArr = c12544en4G.a;
        int iO = c12544en4G.o();
        for (int i = 0; i < iO; i++) {
            ((UA4) objArr[i]).d();
        }
        RG1 rg1H = this.c;
        int iA = AbstractC9572aB4.a(16);
        ?? c12544en4 = 0;
        while (rg1H != 0) {
            if (rg1H instanceof InterfaceC8508Wg5) {
                ((InterfaceC8508Wg5) rg1H).i1();
            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                e.c cVarW2 = rg1H.w2();
                int i2 = 0;
                rg1H = rg1H;
                c12544en4 = c12544en4;
                while (cVarW2 != null) {
                    if ((cVarW2.W1() & iA) != 0) {
                        i2++;
                        c12544en4 = c12544en4;
                        if (i2 == 1) {
                            rg1H = cVarW2;
                        } else {
                            if (c12544en4 == 0) {
                                c12544en4 = new C12544en4(new e.c[16], 0);
                            }
                            if (rg1H != 0) {
                                c12544en4.d(rg1H);
                                rg1H = 0;
                            }
                            c12544en4.d(cVarW2);
                        }
                    }
                    cVarW2 = cVarW2.S1();
                    rg1H = rg1H;
                    c12544en4 = c12544en4;
                }
                if (i2 == 1) {
                }
            }
            rg1H = KG1.h(c12544en4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // ir.nasim.C12189eB4
    public boolean e(C7286Rb3 c7286Rb3) {
        boolean z = false;
        z = false;
        if (!this.e.i() && this.c.b2()) {
            C3534Bg5 c3534Bg5 = this.g;
            AbstractC13042fc3.f(c3534Bg5);
            InterfaceC11379cu3 interfaceC11379cu3 = this.f;
            AbstractC13042fc3.f(interfaceC11379cu3);
            long jA = interfaceC11379cu3.a();
            RG1 rg1H = this.c;
            int iA = AbstractC9572aB4.a(16);
            ?? c12544en4 = 0;
            while (rg1H != 0) {
                if (rg1H instanceof InterfaceC8508Wg5) {
                    ((InterfaceC8508Wg5) rg1H).k1(c3534Bg5, EnumC4002Dg5.c, jA);
                } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                    e.c cVarW2 = rg1H.w2();
                    int i = 0;
                    rg1H = rg1H;
                    c12544en4 = c12544en4;
                    while (cVarW2 != null) {
                        if ((cVarW2.W1() & iA) != 0) {
                            i++;
                            c12544en4 = c12544en4;
                            if (i == 1) {
                                rg1H = cVarW2;
                            } else {
                                if (c12544en4 == 0) {
                                    c12544en4 = new C12544en4(new e.c[16], 0);
                                }
                                if (rg1H != 0) {
                                    c12544en4.d(rg1H);
                                    rg1H = 0;
                                }
                                c12544en4.d(cVarW2);
                            }
                        }
                        cVarW2 = cVarW2.S1();
                        rg1H = rg1H;
                        c12544en4 = c12544en4;
                    }
                    if (i == 1) {
                    }
                }
                rg1H = KG1.h(c12544en4);
            }
            if (this.c.b2()) {
                C12544en4 c12544en4G = g();
                Object[] objArr = c12544en4G.a;
                int iO = c12544en4G.o();
                for (int i2 = 0; i2 < iO; i2++) {
                    ((UA4) objArr[i2]).e(c7286Rb3);
                }
            }
            z = true;
        }
        b(c7286Rb3);
        j();
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r14v4, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v10, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // ir.nasim.C12189eB4
    public boolean f(C21892uJ3 c21892uJ3, InterfaceC11379cu3 interfaceC11379cu3, C7286Rb3 c7286Rb3, boolean z) {
        if (this.e.i() || !this.c.b2()) {
            return false;
        }
        C3534Bg5 c3534Bg5 = this.g;
        AbstractC13042fc3.f(c3534Bg5);
        InterfaceC11379cu3 interfaceC11379cu32 = this.f;
        AbstractC13042fc3.f(interfaceC11379cu32);
        long jA = interfaceC11379cu32.a();
        RG1 rg1H = this.c;
        int iA = AbstractC9572aB4.a(16);
        ?? c12544en4 = 0;
        while (rg1H != 0) {
            if (rg1H instanceof InterfaceC8508Wg5) {
                ((InterfaceC8508Wg5) rg1H).k1(c3534Bg5, EnumC4002Dg5.a, jA);
            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                e.c cVarW2 = rg1H.w2();
                int i = 0;
                rg1H = rg1H;
                c12544en4 = c12544en4;
                while (cVarW2 != null) {
                    if ((cVarW2.W1() & iA) != 0) {
                        i++;
                        c12544en4 = c12544en4;
                        if (i == 1) {
                            rg1H = cVarW2;
                        } else {
                            if (c12544en4 == 0) {
                                c12544en4 = new C12544en4(new e.c[16], 0);
                            }
                            if (rg1H != 0) {
                                c12544en4.d(rg1H);
                                rg1H = 0;
                            }
                            c12544en4.d(cVarW2);
                        }
                    }
                    cVarW2 = cVarW2.S1();
                    rg1H = rg1H;
                    c12544en4 = c12544en4;
                }
                if (i == 1) {
                }
            }
            rg1H = KG1.h(c12544en4);
        }
        if (this.c.b2()) {
            C12544en4 c12544en4G = g();
            Object[] objArr = c12544en4G.a;
            int iO = c12544en4G.o();
            for (int i2 = 0; i2 < iO; i2++) {
                UA4 ua4 = (UA4) objArr[i2];
                C21892uJ3 c21892uJ32 = this.e;
                InterfaceC11379cu3 interfaceC11379cu33 = this.f;
                AbstractC13042fc3.f(interfaceC11379cu33);
                ua4.f(c21892uJ32, interfaceC11379cu33, c7286Rb3, z);
            }
        }
        if (this.c.b2()) {
            RG1 rg1H2 = this.c;
            int iA2 = AbstractC9572aB4.a(16);
            ?? c12544en42 = 0;
            while (rg1H2 != 0) {
                if (rg1H2 instanceof InterfaceC8508Wg5) {
                    ((InterfaceC8508Wg5) rg1H2).k1(c3534Bg5, EnumC4002Dg5.b, jA);
                } else if ((rg1H2.W1() & iA2) != 0 && (rg1H2 instanceof RG1)) {
                    e.c cVarW22 = rg1H2.w2();
                    int i3 = 0;
                    c12544en42 = c12544en42;
                    rg1H2 = rg1H2;
                    while (cVarW22 != null) {
                        if ((cVarW22.W1() & iA2) != 0) {
                            i3++;
                            c12544en42 = c12544en42;
                            if (i3 == 1) {
                                rg1H2 = cVarW22;
                            } else {
                                if (c12544en42 == 0) {
                                    c12544en42 = new C12544en4(new e.c[16], 0);
                                }
                                if (rg1H2 != 0) {
                                    c12544en42.d(rg1H2);
                                    rg1H2 = 0;
                                }
                                c12544en42.d(cVarW22);
                            }
                        }
                        cVarW22 = cVarW22.S1();
                        c12544en42 = c12544en42;
                        rg1H2 = rg1H2;
                    }
                    if (i3 == 1) {
                    }
                }
                rg1H2 = KG1.h(c12544en42);
            }
        }
        return true;
    }

    @Override // ir.nasim.C12189eB4
    public void h(long j, C3587Bm4 c3587Bm4) {
        if (this.d.c(j) && !c3587Bm4.a(this)) {
            this.d.g(j);
            this.e.m(j);
        }
        C12544en4 c12544en4G = g();
        Object[] objArr = c12544en4G.a;
        int iO = c12544en4G.o();
        for (int i = 0; i < iO; i++) {
            ((UA4) objArr[i]).h(j, c3587Bm4);
        }
    }

    public final e.c k() {
        return this.c;
    }

    public final C6361Ng5 l() {
        return this.d;
    }

    public final void n() {
        this.i = true;
    }

    public String toString() {
        return "Node(modifierNode=" + this.c + ", children=" + g() + ", pointerIds=" + this.d + ')';
    }
}
