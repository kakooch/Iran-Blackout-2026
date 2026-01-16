package ir.nasim;

import androidx.compose.ui.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.tg4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21449tg4 {
    private final InterfaceC23714xO4 a;
    private final C12544en4 b = new C12544en4(new C13600gW[16], 0);
    private final C12544en4 c = new C12544en4(new AbstractC19629qg4[16], 0);
    private final C12544en4 d = new C12544en4(new C3419Au3[16], 0);
    private final C12544en4 e = new C12544en4(new AbstractC19629qg4[16], 0);
    private boolean f;

    /* renamed from: ir.nasim.tg4$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            C21449tg4.this.e();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C21449tg4(InterfaceC23714xO4 interfaceC23714xO4) {
        this.a = interfaceC23714xO4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v9 */
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
    private final void c(e.c cVar, AbstractC19629qg4 abstractC19629qg4, Set set) {
        int iA = AbstractC9572aB4.a(32);
        if (!cVar.h().b2()) {
            M73.b("visitSubtreeIf called on an unattached node");
        }
        C12544en4 c12544en4 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = cVar.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en4, cVar.h(), false);
        } else {
            c12544en4.d(cVarS1);
        }
        while (c12544en4.o() != 0) {
            e.c cVar2 = (e.c) c12544en4.w(c12544en4.o() - 1);
            if ((cVar2.R1() & iA) != 0) {
                for (e.c cVarS12 = cVar2; cVarS12 != null; cVarS12 = cVarS12.S1()) {
                    if ((cVarS12.W1() & iA) != 0) {
                        RG1 rg1H = cVarS12;
                        ?? c12544en42 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC22696vg4) {
                                InterfaceC22696vg4 interfaceC22696vg4 = (InterfaceC22696vg4) rg1H;
                                if (interfaceC22696vg4 instanceof C13600gW) {
                                    C13600gW c13600gW = (C13600gW) interfaceC22696vg4;
                                    if ((c13600gW.v2() instanceof InterfaceC20236rg4) && c13600gW.w2().contains(abstractC19629qg4)) {
                                        set.add(interfaceC22696vg4);
                                    }
                                }
                                if (!(!interfaceC22696vg4.o0().a(abstractC19629qg4))) {
                                    break;
                                }
                            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                e.c cVarW2 = rg1H.w2();
                                int i = 0;
                                rg1H = rg1H;
                                c12544en42 = c12544en42;
                                while (cVarW2 != null) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        c12544en42 = c12544en42;
                                        if (i == 1) {
                                            rg1H = cVarW2;
                                        } else {
                                            if (c12544en42 == 0) {
                                                c12544en42 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (rg1H != 0) {
                                                c12544en42.d(rg1H);
                                                rg1H = 0;
                                            }
                                            c12544en42.d(cVarW2);
                                        }
                                    }
                                    cVarW2 = cVarW2.S1();
                                    rg1H = rg1H;
                                    c12544en42 = c12544en42;
                                }
                                if (i == 1) {
                                }
                            }
                            rg1H = KG1.h(c12544en42);
                        }
                    }
                }
            }
            KG1.c(c12544en4, cVar2, false);
        }
    }

    public final void a(C13600gW c13600gW, AbstractC19629qg4 abstractC19629qg4) {
        this.b.d(c13600gW);
        this.c.d(abstractC19629qg4);
        b();
    }

    public final void b() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.a.h(new a());
    }

    public final void d(C13600gW c13600gW, AbstractC19629qg4 abstractC19629qg4) {
        this.d.d(KG1.o(c13600gW));
        this.e.d(abstractC19629qg4);
        b();
    }

    public final void e() {
        this.f = false;
        HashSet hashSet = new HashSet();
        C12544en4 c12544en4 = this.d;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            AbstractC19629qg4 abstractC19629qg4 = (AbstractC19629qg4) this.e.a[i];
            if (c3419Au3.t0().k().b2()) {
                c(c3419Au3.t0().k(), abstractC19629qg4, hashSet);
            }
        }
        this.d.k();
        this.e.k();
        C12544en4 c12544en42 = this.b;
        Object[] objArr2 = c12544en42.a;
        int iO2 = c12544en42.o();
        for (int i2 = 0; i2 < iO2; i2++) {
            C13600gW c13600gW = (C13600gW) objArr2[i2];
            AbstractC19629qg4 abstractC19629qg42 = (AbstractC19629qg4) this.c.a[i2];
            if (c13600gW.b2()) {
                c(c13600gW, abstractC19629qg42, hashSet);
            }
        }
        this.b.k();
        this.c.k();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C13600gW) it.next()).B2();
        }
    }

    public final void f(C13600gW c13600gW, AbstractC19629qg4 abstractC19629qg4) {
        this.b.d(c13600gW);
        this.c.d(abstractC19629qg4);
        b();
    }
}
