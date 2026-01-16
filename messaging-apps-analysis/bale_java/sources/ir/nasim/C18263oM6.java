package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.oM6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18263oM6 extends X24 {
    static final /* synthetic */ InterfaceC5239Im3[] d = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C18263oM6.class), "functions", "getFunctions()Ljava/util/List;"))};
    private final InterfaceC21331tU0 b;
    private final InterfaceC23016wC4 c;

    /* renamed from: ir.nasim.oM6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return AbstractC10360bX0.p(AbstractC23657xI1.d(C18263oM6.this.b), AbstractC23657xI1.e(C18263oM6.this.b));
        }
    }

    public C18263oM6(ON6 on6, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC21331tU0, "containingClass");
        this.b = interfaceC21331tU0;
        interfaceC21331tU0.f();
        AU0 au0 = AU0.CLASS;
        this.c = on6.c(new a());
    }

    private final List l() {
        return (List) MN6.a(this.c, this, d[0]);
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public /* bridge */ /* synthetic */ MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        return (MU0) i(c6432No4, ij3);
    }

    public Void i(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return null;
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public List f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        return l();
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public CE6 d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        List listL = l();
        CE6 ce6 = new CE6();
        for (Object obj : listL) {
            if (AbstractC13042fc3.d(((JC6) obj).getName(), c6432No4)) {
                ce6.add(obj);
            }
        }
        return ce6;
    }
}
