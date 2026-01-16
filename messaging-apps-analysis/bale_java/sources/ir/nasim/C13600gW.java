package ir.nasim;

import androidx.compose.ui.e;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import java.util.HashSet;

/* renamed from: ir.nasim.gW, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13600gW extends e.c implements InterfaceC21655tu3, InterfaceC15687k02, InterfaceC7163Qn6, InterfaceC8508Wg5, InterfaceC22696vg4, InterfaceC24472yg4, InterfaceC24970zW4, InterfaceC9398Zt3, InterfaceC15868kJ2, InterfaceC20937sr2, InterfaceC4815Gr2, InterfaceC5283Ir2, InterfaceC24304yO4, InterfaceC8548Wl0 {
    private e.b o;
    private boolean p;
    private C12982fW q;
    private HashSet r;
    private InterfaceC11379cu3 s;

    /* renamed from: ir.nasim.gW$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            C13600gW.this.B2();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gW$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        public final void a() {
            e.b bVarV2 = C13600gW.this.v2();
            AbstractC13042fc3.g(bVarV2, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
            ((InterfaceC20236rg4) bVarV2).g(C13600gW.this);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C13600gW(e.b bVar) {
        p2(AbstractC10166bB4.f(bVar));
        this.o = bVar;
        this.p = true;
        this.r = new HashSet();
    }

    private final void A2() {
        if (!b2()) {
            M73.b("unInitializeModifier called on unattached node");
        }
        e.b bVar = this.o;
        if ((AbstractC9572aB4.a(32) & W1()) != 0) {
            if (bVar instanceof InterfaceC23882xg4) {
                KG1.p(this).getModifierLocalManager().d(this, ((InterfaceC23882xg4) bVar).getKey());
            }
            if (bVar instanceof InterfaceC20236rg4) {
                ((InterfaceC20236rg4) bVar).g(AbstractC14191hW.a);
            }
        }
        if ((AbstractC9572aB4.a(8) & W1()) != 0) {
            KG1.p(this).F();
        }
    }

    private final void C2(InterfaceC23882xg4 interfaceC23882xg4) {
        C12982fW c12982fW = this.q;
        if (c12982fW != null && c12982fW.a(interfaceC23882xg4.getKey())) {
            c12982fW.c(interfaceC23882xg4);
            KG1.p(this).getModifierLocalManager().f(this, interfaceC23882xg4.getKey());
        } else {
            this.q = new C12982fW(interfaceC23882xg4);
            if (AbstractC14191hW.d(this)) {
                KG1.p(this).getModifierLocalManager().a(this, interfaceC23882xg4.getKey());
            }
        }
    }

    private final void x2(boolean z) {
        if (!b2()) {
            M73.b("initializeModifier called on unattached node");
        }
        e.b bVar = this.o;
        if ((AbstractC9572aB4.a(32) & W1()) != 0) {
            if (bVar instanceof InterfaceC20236rg4) {
                t2(new a());
            }
            if (bVar instanceof InterfaceC23882xg4) {
                C2((InterfaceC23882xg4) bVar);
            }
        }
        if ((AbstractC9572aB4.a(4) & W1()) != 0 && !z) {
            AbstractC23431wu3.a(this);
        }
        if ((AbstractC9572aB4.a(2) & W1()) != 0) {
            if (AbstractC14191hW.d(this)) {
                XA4 xa4T1 = T1();
                AbstractC13042fc3.f(xa4T1);
                ((C22245uu3) xa4T1).M3(this);
                xa4T1.c3();
            }
            if (!z) {
                AbstractC23431wu3.a(this);
                KG1.o(this).O0();
            }
        }
        if (bVar instanceof SM5) {
            ((SM5) bVar).h(KG1.o(this));
        }
        AbstractC9572aB4.a(128);
        W1();
        if ((AbstractC9572aB4.a(256) & W1()) != 0 && (bVar instanceof InterfaceC17052mJ4) && AbstractC14191hW.d(this)) {
            KG1.o(this).O0();
        }
        if ((AbstractC9572aB4.a(16) & W1()) != 0 && (bVar instanceof InterfaceC8274Vg5)) {
            ((InterfaceC8274Vg5) bVar).j().f(T1());
        }
        if ((AbstractC9572aB4.a(8) & W1()) != 0) {
            KG1.p(this).F();
        }
    }

    public final void B2() {
        if (b2()) {
            this.r.clear();
            KG1.p(this).getSnapshotObserver().i(this, AbstractC14191hW.c, new b());
        }
    }

    @Override // ir.nasim.InterfaceC24970zW4
    public Object C(WH1 wh1, Object obj) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((InterfaceC24376yW4) bVar).C(wh1, obj);
    }

    @Override // ir.nasim.JG1, ir.nasim.InterfaceC8508Wg5
    public void E() {
        if (this.o instanceof InterfaceC8274Vg5) {
            i1();
        }
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((InterfaceC20377ru3) bVar).F(interfaceC10436bc3, interfaceC9236Zb3, i);
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public boolean F1() {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((InterfaceC8274Vg5) bVar).j().c();
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((InterfaceC20377ru3) bVar).J(interfaceC10436bc3, interfaceC9236Zb3, i);
    }

    @Override // ir.nasim.InterfaceC20937sr2
    public void O(InterfaceC5517Jr2 interfaceC5517Jr2) {
        e.b bVar = this.o;
        M73.b("onFocusEvent called on wrong node");
        AbstractC18350oW3.a(bVar);
        throw null;
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        SemanticsConfiguration semanticsConfigurationE = ((InterfaceC6685On6) bVar).e();
        AbstractC13042fc3.g(interfaceC11943do6, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        ((SemanticsConfiguration) interfaceC11943do6).h(semanticsConfigurationE);
    }

    @Override // ir.nasim.InterfaceC24304yO4
    public boolean Z0() {
        return b2();
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((InterfaceC20377ru3) bVar).b(interfaceC12377eW3, zv3, j);
    }

    @Override // ir.nasim.InterfaceC4815Gr2
    public void b1(androidx.compose.ui.focus.k kVar) {
        e.b bVar = this.o;
        M73.b("applyFocusProperties called on wrong node");
        AbstractC18350oW3.a(bVar);
        new C4332Er2(kVar);
        throw null;
    }

    @Override // ir.nasim.InterfaceC8548Wl0
    public long d() {
        return AbstractC4663Ga3.d(KG1.j(this, AbstractC9572aB4.a(128)).a());
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        x2(true);
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        A2();
    }

    @Override // ir.nasim.InterfaceC8548Wl0
    public WH1 getDensity() {
        return KG1.o(this).T();
    }

    @Override // ir.nasim.InterfaceC8548Wl0
    public EnumC12613eu3 getLayoutDirection() {
        return KG1.o(this).getLayoutDirection();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void i1() {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((InterfaceC8274Vg5) bVar).j().d();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public boolean k0() {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((InterfaceC8274Vg5) bVar).j().a();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void k1(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((InterfaceC8274Vg5) bVar).j().e(c3534Bg5, enumC4002Dg5, j);
    }

    @Override // ir.nasim.InterfaceC9398Zt3
    public void l0(InterfaceC11379cu3 interfaceC11379cu3) {
        this.s = interfaceC11379cu3;
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void l1() {
        this.p = true;
        AbstractC16278l02.a(this);
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        ((InterfaceC15096j02) bVar).o(interfaceC23919xk1);
    }

    @Override // ir.nasim.InterfaceC22696vg4
    public AbstractC22106ug4 o0() {
        C12982fW c12982fW = this.q;
        return c12982fW != null ? c12982fW : AbstractC23292wg4.a();
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((InterfaceC20377ru3) bVar).p(interfaceC10436bc3, interfaceC9236Zb3, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v9 */
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
    @Override // ir.nasim.InterfaceC22696vg4, ir.nasim.InterfaceC24472yg4
    public Object t(AbstractC19629qg4 abstractC19629qg4) {
        VA4 va4T0;
        this.r.add(abstractC19629qg4);
        int iA = AbstractC9572aB4.a(32);
        if (!h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = h().Y1();
        C3419Au3 c3419Au3O = KG1.o(this);
        while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        RG1 rg1H = cVarY1;
                        ?? c12544en4 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC22696vg4) {
                                InterfaceC22696vg4 interfaceC22696vg4 = (InterfaceC22696vg4) rg1H;
                                if (interfaceC22696vg4.o0().a(abstractC19629qg4)) {
                                    return interfaceC22696vg4.o0().b(abstractC19629qg4);
                                }
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
                    }
                    cVarY1 = cVarY1.Y1();
                }
            }
            c3419Au3O = c3419Au3O.A0();
            cVarY1 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
        }
        return abstractC19629qg4.a().invoke();
    }

    public String toString() {
        return this.o.toString();
    }

    @Override // ir.nasim.InterfaceC15868kJ2
    public void u(InterfaceC11379cu3 interfaceC11379cu3) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((InterfaceC17052mJ4) bVar).u(interfaceC11379cu3);
    }

    public final e.b v2() {
        return this.o;
    }

    public final HashSet w2() {
        return this.r;
    }

    public final void y2() {
        this.p = true;
        AbstractC16278l02.a(this);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        e.b bVar = this.o;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((InterfaceC20377ru3) bVar).z(interfaceC10436bc3, interfaceC9236Zb3, i);
    }

    public final void z2(e.b bVar) {
        if (b2()) {
            A2();
        }
        this.o = bVar;
        p2(AbstractC10166bB4.f(bVar));
        if (b2()) {
            x2(false);
        }
    }

    @Override // ir.nasim.InterfaceC9398Zt3
    public void S(long j) {
    }
}
