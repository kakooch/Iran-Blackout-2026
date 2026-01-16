package ir.nasim;

import androidx.compose.ui.e;
import java.util.List;

/* loaded from: classes2.dex */
public final class VA4 {
    private final C3419Au3 a;
    private final C15177j83 b;
    private XA4 c;
    private final e.c d;
    private e.c e;
    private C12544en4 f;
    private C12544en4 g;
    private a h;

    private final class a implements InterfaceC21980uT1 {
        private e.c a;
        private int b;
        private C12544en4 c;
        private C12544en4 d;
        private boolean e;

        public a(e.c cVar, int i, C12544en4 c12544en4, C12544en4 c12544en42, boolean z) {
            this.a = cVar;
            this.b = i;
            this.c = c12544en4;
            this.d = c12544en42;
            this.e = z;
        }

        @Override // ir.nasim.InterfaceC21980uT1
        public void a(int i, int i2) {
            e.c cVarS1 = this.a.S1();
            AbstractC13042fc3.f(cVarS1);
            VA4.d(VA4.this);
            if ((AbstractC9572aB4.a(2) & cVarS1.W1()) != 0) {
                XA4 xa4T1 = cVarS1.T1();
                AbstractC13042fc3.f(xa4T1);
                XA4 xa4L2 = xa4T1.L2();
                XA4 xa4K2 = xa4T1.K2();
                AbstractC13042fc3.f(xa4K2);
                if (xa4L2 != null) {
                    xa4L2.t3(xa4K2);
                }
                xa4K2.u3(xa4L2);
                VA4.this.w(this.a, xa4K2);
            }
            this.a = VA4.this.h(cVarS1);
        }

        @Override // ir.nasim.InterfaceC21980uT1
        public boolean b(int i, int i2) {
            C12544en4 c12544en4 = this.c;
            int i3 = this.b;
            return WA4.d((e.b) c12544en4.a[i + i3], (e.b) this.d.a[i3 + i2]) != 0;
        }

        @Override // ir.nasim.InterfaceC21980uT1
        public void c(int i) {
            int i2 = this.b + i;
            this.a = VA4.this.g((e.b) this.d.a[i2], this.a);
            VA4.d(VA4.this);
            if (!this.e) {
                this.a.o2(true);
                return;
            }
            e.c cVarS1 = this.a.S1();
            AbstractC13042fc3.f(cVarS1);
            XA4 xa4T1 = cVarS1.T1();
            AbstractC13042fc3.f(xa4T1);
            InterfaceC21655tu3 interfaceC21655tu3D = KG1.d(this.a);
            if (interfaceC21655tu3D != null) {
                C22245uu3 c22245uu3 = new C22245uu3(VA4.this.m(), interfaceC21655tu3D);
                this.a.u2(c22245uu3);
                VA4.this.w(this.a, c22245uu3);
                c22245uu3.u3(xa4T1.L2());
                c22245uu3.t3(xa4T1);
                xa4T1.u3(c22245uu3);
            } else {
                this.a.u2(xa4T1);
            }
            this.a.c2();
            this.a.i2();
            AbstractC10166bB4.a(this.a);
        }

        @Override // ir.nasim.InterfaceC21980uT1
        public void d(int i, int i2) {
            e.c cVarS1 = this.a.S1();
            AbstractC13042fc3.f(cVarS1);
            this.a = cVarS1;
            C12544en4 c12544en4 = this.c;
            int i3 = this.b;
            e.b bVar = (e.b) c12544en4.a[i + i3];
            e.b bVar2 = (e.b) this.d.a[i3 + i2];
            if (AbstractC13042fc3.d(bVar, bVar2)) {
                VA4.d(VA4.this);
            } else {
                VA4.this.G(bVar, bVar2, this.a);
                VA4.d(VA4.this);
            }
        }

        public final void e(C12544en4 c12544en4) {
            this.d = c12544en4;
        }

        public final void f(C12544en4 c12544en4) {
            this.c = c12544en4;
        }

        public final void g(e.c cVar) {
            this.a = cVar;
        }

        public final void h(int i) {
            this.b = i;
        }

        public final void i(boolean z) {
            this.e = z;
        }
    }

    public interface b {
    }

    public VA4(C3419Au3 c3419Au3) {
        this.a = c3419Au3;
        C15177j83 c15177j83 = new C15177j83(c3419Au3);
        this.b = c15177j83;
        this.c = c15177j83;
        C16707lj7 c16707lj7I3 = c15177j83.J2();
        this.d = c16707lj7I3;
        this.e = c16707lj7I3;
    }

    private final void B(int i, C12544en4 c12544en4, C12544en4 c12544en42, e.c cVar, boolean z) {
        AbstractC5258Io4.e(c12544en4.o() - i, c12544en42.o() - i, j(cVar, i, c12544en4, c12544en42, z));
        C();
    }

    private final void C() {
        int iW1 = 0;
        for (e.c cVarY1 = this.d.Y1(); cVarY1 != null && cVarY1 != WA4.a; cVarY1 = cVarY1.Y1()) {
            iW1 |= cVarY1.W1();
            cVarY1.k2(iW1);
        }
    }

    private final e.c E(e.c cVar) {
        if (!(cVar == WA4.a)) {
            M73.b("trimChain called on already trimmed chain");
        }
        e.c cVarS1 = WA4.a.S1();
        if (cVarS1 == null) {
            cVarS1 = this.d;
        }
        cVarS1.r2(null);
        WA4.a.m2(null);
        WA4.a.k2(-1);
        WA4.a.u2(null);
        if (!(cVarS1 != WA4.a)) {
            M73.b("trimChain did not update the head");
        }
        return cVarS1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(e.b bVar, e.b bVar2, e.c cVar) {
        if ((bVar instanceof AbstractC25066zg4) && (bVar2 instanceof AbstractC25066zg4)) {
            WA4.f((AbstractC25066zg4) bVar2, cVar);
            if (cVar.b2()) {
                AbstractC10166bB4.e(cVar);
                return;
            } else {
                cVar.s2(true);
                return;
            }
        }
        if (!(cVar instanceof C13600gW)) {
            M73.b("Unknown Modifier.Node type");
            return;
        }
        ((C13600gW) cVar).z2(bVar2);
        if (cVar.b2()) {
            AbstractC10166bB4.e(cVar);
        } else {
            cVar.s2(true);
        }
    }

    public static final /* synthetic */ b d(VA4 va4) {
        va4.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.c g(e.b bVar, e.c cVar) {
        e.c c13600gW;
        if (bVar instanceof AbstractC25066zg4) {
            c13600gW = ((AbstractC25066zg4) bVar).f();
            c13600gW.p2(AbstractC10166bB4.h(c13600gW));
        } else {
            c13600gW = new C13600gW(bVar);
        }
        if (!(!c13600gW.b2())) {
            M73.b("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        c13600gW.o2(true);
        return r(c13600gW, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.c h(e.c cVar) {
        if (cVar.b2()) {
            AbstractC10166bB4.d(cVar);
            cVar.j2();
            cVar.d2();
        }
        return x(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i() {
        return this.e.R1();
    }

    private final a j(e.c cVar, int i, C12544en4 c12544en4, C12544en4 c12544en42, boolean z) {
        a aVar = this.h;
        if (aVar == null) {
            a aVar2 = new a(cVar, i, c12544en4, c12544en42, z);
            this.h = aVar2;
            return aVar2;
        }
        aVar.g(cVar);
        aVar.h(i);
        aVar.f(c12544en4);
        aVar.e(c12544en42);
        aVar.i(z);
        return aVar;
    }

    private final e.c r(e.c cVar, e.c cVar2) {
        e.c cVarS1 = cVar2.S1();
        if (cVarS1 != null) {
            cVarS1.r2(cVar);
            cVar.m2(cVarS1);
        }
        cVar2.m2(cVar);
        cVar.r2(cVar2);
        return cVar;
    }

    private final e.c v() {
        if (!(this.e != WA4.a)) {
            M73.b("padChain called on already padded chain");
        }
        e.c cVar = this.e;
        cVar.r2(WA4.a);
        WA4.a.m2(cVar);
        return WA4.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(e.c cVar, XA4 xa4) {
        for (e.c cVarY1 = cVar.Y1(); cVarY1 != null; cVarY1 = cVarY1.Y1()) {
            if (cVarY1 == WA4.a) {
                C3419Au3 c3419Au3A0 = this.a.A0();
                xa4.u3(c3419Au3A0 != null ? c3419Au3A0.Y() : null);
                this.c = xa4;
                return;
            } else {
                if ((AbstractC9572aB4.a(2) & cVarY1.W1()) != 0) {
                    return;
                }
                cVarY1.u2(xa4);
            }
        }
    }

    private final e.c x(e.c cVar) {
        e.c cVarS1 = cVar.S1();
        e.c cVarY1 = cVar.Y1();
        if (cVarS1 != null) {
            cVarS1.r2(cVarY1);
            cVar.m2(null);
        }
        if (cVarY1 != null) {
            cVarY1.m2(cVarS1);
            cVar.r2(null);
        }
        AbstractC13042fc3.f(cVarY1);
        return cVarY1;
    }

    public final void A() {
        for (e.c cVarP = p(); cVarP != null; cVarP = cVarP.Y1()) {
            if (cVarP.b2()) {
                cVarP.j2();
            }
        }
        XA4 xa4L2 = this.b;
        XA4 xa4 = this.c;
        while (xa4L2 != xa4) {
            xa4L2.b3();
            xa4L2 = xa4L2.L2();
            AbstractC13042fc3.f(xa4L2);
        }
        xa4.b3();
    }

    public final void D() {
        XA4 c22245uu3;
        XA4 xa4 = this.b;
        for (e.c cVarY1 = this.d.Y1(); cVarY1 != null; cVarY1 = cVarY1.Y1()) {
            InterfaceC21655tu3 interfaceC21655tu3D = KG1.d(cVarY1);
            if (interfaceC21655tu3D != null) {
                if (cVarY1.T1() != null) {
                    XA4 xa4T1 = cVarY1.T1();
                    AbstractC13042fc3.g(xa4T1, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    c22245uu3 = (C22245uu3) xa4T1;
                    InterfaceC21655tu3 interfaceC21655tu3J3 = c22245uu3.J3();
                    c22245uu3.M3(interfaceC21655tu3D);
                    if (interfaceC21655tu3J3 != cVarY1) {
                        c22245uu3.c3();
                    }
                } else {
                    c22245uu3 = new C22245uu3(this.a, interfaceC21655tu3D);
                    cVarY1.u2(c22245uu3);
                }
                xa4.u3(c22245uu3);
                c22245uu3.t3(xa4);
                xa4 = c22245uu3;
            } else {
                cVarY1.u2(xa4);
            }
        }
        C3419Au3 c3419Au3A0 = this.a.A0();
        xa4.u3(c3419Au3A0 != null ? c3419Au3A0.Y() : null);
        this.c = xa4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        if (r2 >= r1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        if (r7 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r5 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        B(r2, r7, r13, r5, !r12.a.N());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
    
        ir.nasim.M73.c("structuralUpdate requires a non-null tail");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
    
        ir.nasim.M73.c("expected prior modifier list to be non-empty");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(androidx.compose.ui.e r13) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VA4.F(androidx.compose.ui.e):void");
    }

    public final e.c k() {
        return this.e;
    }

    public final C15177j83 l() {
        return this.b;
    }

    public final C3419Au3 m() {
        return this.a;
    }

    public final List n() {
        C12544en4 c12544en4 = this.f;
        if (c12544en4 == null) {
            return AbstractC10360bX0.m();
        }
        int i = 0;
        C12544en4 c12544en42 = new C12544en4(new C19038pg4[c12544en4.o()], 0);
        e.c cVarK = k();
        while (cVarK != null && cVarK != p()) {
            XA4 xa4T1 = cVarK.T1();
            if (xa4T1 == null) {
                throw new IllegalArgumentException("getModifierInfo called on node with no coordinator".toString());
            }
            InterfaceC23124wO4 interfaceC23124wO4D2 = xa4T1.D2();
            InterfaceC23124wO4 interfaceC23124wO4D22 = this.b.D2();
            e.c cVarS1 = cVarK.S1();
            if (cVarS1 != this.d || cVarK.T1() == cVarS1.T1()) {
                interfaceC23124wO4D22 = null;
            }
            if (interfaceC23124wO4D2 == null) {
                interfaceC23124wO4D2 = interfaceC23124wO4D22;
            }
            c12544en42.d(new C19038pg4((androidx.compose.ui.e) c12544en4.a[i], xa4T1, interfaceC23124wO4D2));
            cVarK = cVarK.S1();
            i++;
        }
        return c12544en42.j();
    }

    public final XA4 o() {
        return this.c;
    }

    public final e.c p() {
        return this.d;
    }

    public final boolean q(int i) {
        return (i & i()) != 0;
    }

    public final boolean s() {
        return WA4.a.S1() != null;
    }

    public final void t() {
        for (e.c cVarK = k(); cVarK != null; cVarK = cVarK.S1()) {
            cVarK.c2();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.e == this.d) {
            sb.append("]");
        } else {
            e.c cVarK = k();
            while (true) {
                if (cVarK == null || cVarK == p()) {
                    break;
                }
                sb.append(String.valueOf(cVarK));
                if (cVarK.S1() == this.d) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                cVarK = cVarK.S1();
            }
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public final void u() {
        for (e.c cVarP = p(); cVarP != null; cVarP = cVarP.Y1()) {
            if (cVarP.b2()) {
                cVarP.d2();
            }
        }
    }

    public final void y() {
        for (e.c cVarP = p(); cVarP != null; cVarP = cVarP.Y1()) {
            if (cVarP.b2()) {
                cVarP.h2();
            }
        }
        A();
        u();
    }

    public final void z() {
        XA4 xa4K2 = this.c;
        C15177j83 c15177j83 = this.b;
        while (xa4K2 != c15177j83) {
            xa4K2.Z2();
            xa4K2 = xa4K2.K2();
            AbstractC13042fc3.f(xa4K2);
        }
        c15177j83.Z2();
        for (e.c cVarK = k(); cVarK != null; cVarK = cVarK.S1()) {
            cVarK.i2();
            if (cVarK.V1()) {
                AbstractC10166bB4.a(cVarK);
            }
            if (cVarK.a2()) {
                AbstractC10166bB4.e(cVarK);
            }
            cVarK.o2(false);
            cVarK.s2(false);
        }
    }
}
