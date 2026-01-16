package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.nx3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18024nx3 extends LG6 {
    private final C19206px3 a;
    private final InterfaceC14603iB2 b;
    private final int c;
    private final InterfaceC9102Ym4 d;
    private final InterfaceC9664aL6 e;

    /* renamed from: ir.nasim.nx3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MG6 invoke() {
            InterfaceC23384wp6 interfaceC23384wp6N = C18024nx3.this.n();
            C18024nx3 c18024nx3 = C18024nx3.this;
            Object obj = null;
            for (Object obj2 : interfaceC23384wp6N) {
                MG6 mg6 = (MG6) obj2;
                if (mg6.b() <= ((Number) c18024nx3.b.invoke(c18024nx3, mg6)).intValue()) {
                    obj = obj2;
                }
            }
            return (MG6) obj;
        }
    }

    /* renamed from: ir.nasim.nx3$b */
    /* synthetic */ class b extends EB2 implements UA2 {
        public static final b a = new b();

        b() {
            super(1, C18615ox3.class, "<init>", "<init>(Landroidx/compose/foundation/lazy/LazyListItemInfo;)V", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final C18615ox3 invoke(InterfaceC7948Tw3 interfaceC7948Tw3) {
            AbstractC13042fc3.i(interfaceC7948Tw3, "p0");
            return new C18615ox3(interfaceC7948Tw3);
        }
    }

    public /* synthetic */ C18024nx3(C19206px3 c19206px3, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2, ED1 ed1) {
        this(c19206px3, interfaceC14603iB2, (i2 & 4) != 0 ? 0 : i);
    }

    private final int j() {
        InterfaceC9425Zw3 interfaceC9425Zw3X = this.a.x();
        if (interfaceC9425Zw3X.i().size() < 2) {
            return 0;
        }
        InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) interfaceC9425Zw3X.i().get(0);
        return ((InterfaceC7948Tw3) interfaceC9425Zw3X.i().get(1)).getOffset() - (interfaceC7948Tw3.f() + interfaceC7948Tw3.getOffset());
    }

    private final float k() {
        Object next;
        InterfaceC9425Zw3 interfaceC9425Zw3X = this.a.x();
        if (interfaceC9425Zw3X.i().isEmpty()) {
            return -1.0f;
        }
        Iterator it = interfaceC9425Zw3X.i().iterator();
        Object next2 = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int offset = ((InterfaceC7948Tw3) next).getOffset();
                do {
                    Object next3 = it.next();
                    int offset2 = ((InterfaceC7948Tw3) next3).getOffset();
                    if (offset > offset2) {
                        next = next3;
                        offset = offset2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) next;
        if (interfaceC7948Tw3 == null) {
            return -1.0f;
        }
        Iterator it2 = interfaceC9425Zw3X.i().iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                InterfaceC7948Tw3 interfaceC7948Tw32 = (InterfaceC7948Tw3) next2;
                int offset3 = interfaceC7948Tw32.getOffset() + interfaceC7948Tw32.f();
                do {
                    Object next4 = it2.next();
                    InterfaceC7948Tw3 interfaceC7948Tw33 = (InterfaceC7948Tw3) next4;
                    int offset4 = interfaceC7948Tw33.getOffset() + interfaceC7948Tw33.f();
                    if (offset3 < offset4) {
                        next2 = next4;
                        offset3 = offset4;
                    }
                } while (it2.hasNext());
            }
        }
        InterfaceC7948Tw3 interfaceC7948Tw34 = (InterfaceC7948Tw3) next2;
        if (interfaceC7948Tw34 == null) {
            return -1.0f;
        }
        if (Math.max(interfaceC7948Tw3.getOffset() + interfaceC7948Tw3.f(), interfaceC7948Tw34.getOffset() + interfaceC7948Tw34.f()) - Math.min(interfaceC7948Tw3.getOffset(), interfaceC7948Tw34.getOffset()) == 0) {
            return -1.0f;
        }
        return (r3 + j()) / interfaceC9425Zw3X.i().size();
    }

    private final int m() {
        return this.a.x().g();
    }

    @Override // ir.nasim.LG6
    public boolean a() {
        InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) AbstractC15401jX0.F0(this.a.x().i());
        if (interfaceC7948Tw3 == null) {
            return false;
        }
        return interfaceC7948Tw3.getIndex() < m() - 1 || interfaceC7948Tw3.getOffset() + interfaceC7948Tw3.f() > f();
    }

    @Override // ir.nasim.LG6
    public boolean b() {
        InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) AbstractC15401jX0.s0(this.a.x().i());
        if (interfaceC7948Tw3 == null) {
            return false;
        }
        return interfaceC7948Tw3.getIndex() > 0 || interfaceC7948Tw3.getOffset() < g();
    }

    @Override // ir.nasim.LG6
    public int c(float f, InterfaceC10163bB1 interfaceC10163bB1, float f2) {
        AbstractC13042fc3.i(interfaceC10163bB1, "decayAnimationSpec");
        MG6 mg6E = e();
        if (mg6E == null) {
            return -1;
        }
        float fK = k();
        if (fK <= 0.0f) {
            return mg6E.a();
        }
        int iD = d(mg6E.a());
        int iD2 = d(mg6E.a() + 1);
        if (Math.abs(f) < 0.5f) {
            return AbstractC23053wG5.m(Math.abs(iD) < Math.abs(iD2) ? mg6E.a() : mg6E.a() + 1, 0, m() - 1);
        }
        float fL = AbstractC23053wG5.l(AbstractC11543dB1.a(interfaceC10163bB1, 0.0f, f), -f2, f2);
        double d = fK;
        int iM = AbstractC23053wG5.m(mg6E.a() + AbstractC20723sV3.c(((f < 0.0f ? AbstractC23053wG5.h(fL + iD2, 0.0f) : AbstractC23053wG5.d(fL + iD, 0.0f)) / d) - (iD / d)), 0, m() - 1);
        NG6 ng6 = NG6.a;
        return iM;
    }

    @Override // ir.nasim.LG6
    public int d(int i) {
        Object next;
        int iD;
        int iIntValue;
        Iterator it = n().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((MG6) next).a() == i) {
                break;
            }
        }
        MG6 mg6 = (MG6) next;
        if (mg6 != null) {
            iD = mg6.b();
            iIntValue = ((Number) this.b.invoke(this, mg6)).intValue();
        } else {
            MG6 mg6E = e();
            if (mg6E == null) {
                return 0;
            }
            iD = AbstractC20723sV3.d((i - mg6E.a()) * k()) + mg6E.b();
            iIntValue = ((Number) this.b.invoke(this, mg6E)).intValue();
        }
        return iD - iIntValue;
    }

    @Override // ir.nasim.LG6
    public MG6 e() {
        return (MG6) this.e.getValue();
    }

    @Override // ir.nasim.LG6
    public int f() {
        return this.a.x().d() - l();
    }

    @Override // ir.nasim.LG6
    public int g() {
        return this.c;
    }

    @Override // ir.nasim.LG6
    public int h() {
        return this.a.x().g();
    }

    public final int l() {
        return ((Number) this.d.getValue()).intValue();
    }

    public InterfaceC23384wp6 n() {
        return AbstractC11342cq6.C(AbstractC15401jX0.g0(this.a.x().i()), b.a);
    }

    public final void o(int i) {
        this.d.setValue(Integer.valueOf(i));
    }

    public C18024nx3(C19206px3 c19206px3, InterfaceC14603iB2 interfaceC14603iB2, int i) {
        AbstractC13042fc3.i(c19206px3, "lazyListState");
        AbstractC13042fc3.i(interfaceC14603iB2, "snapOffsetForItem");
        this.a = c19206px3;
        this.b = interfaceC14603iB2;
        this.d = AbstractC13472gH6.d(Integer.valueOf(i), null, 2, null);
        this.e = AbstractC10222bH6.d(new a());
    }
}
