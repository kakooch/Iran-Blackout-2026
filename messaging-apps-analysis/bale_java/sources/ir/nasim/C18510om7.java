package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.om7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18510om7 {
    public static final c g = new c(null);
    private static final InterfaceC8230Vb6 h = WB3.a(a.e, b.e);
    private final InterfaceC14354hm4 a;
    private final InterfaceC14354hm4 b;
    private final InterfaceC17916nm4 c;
    private CK5 d;
    private long e;
    private final InterfaceC9102Ym4 f;

    /* renamed from: ir.nasim.om7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C18510om7 c18510om7) {
            return AbstractC10360bX0.p(Float.valueOf(c18510om7.d()), Boolean.valueOf(c18510om7.f() == EnumC24286yM4.a));
        }
    }

    /* renamed from: ir.nasim.om7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C18510om7 invoke(List list) {
            Object obj = list.get(1);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Boolean");
            EnumC24286yM4 enumC24286yM4 = ((Boolean) obj).booleanValue() ? EnumC24286yM4.a : EnumC24286yM4.b;
            Object obj2 = list.get(0);
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new C18510om7(enumC24286yM4, ((Float) obj2).floatValue());
        }
    }

    /* renamed from: ir.nasim.om7$c */
    public static final class c {
        private c() {
        }

        public final InterfaceC8230Vb6 a() {
            return C18510om7.h;
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public C18510om7(EnumC24286yM4 enumC24286yM4, float f) {
        this.a = AbstractC4326Eq5.a(f);
        this.b = AbstractC4326Eq5.a(0.0f);
        this.c = UG6.a(0);
        this.d = CK5.e.a();
        this.e = C4301En7.b.a();
        this.f = AbstractC10222bH6.h(enumC24286yM4, AbstractC10222bH6.s());
    }

    private final void g(float f) {
        this.b.s(f);
    }

    private final void j(int i) {
        this.c.h(i);
    }

    public final void b(float f, float f2, int i) {
        float fD = d();
        float f3 = i;
        float f4 = fD + f3;
        h(d() + ((f2 <= f4 && (f >= fD || f2 - f <= f3)) ? (f >= fD || f2 - f > f3) ? 0.0f : f - fD : f2 - f4));
    }

    public final float c() {
        return this.b.a();
    }

    public final float d() {
        return this.a.a();
    }

    public final int e(long j) {
        return C4301En7.n(j) != C4301En7.n(this.e) ? C4301En7.n(j) : C4301En7.i(j) != C4301En7.i(this.e) ? C4301En7.i(j) : C4301En7.l(j);
    }

    public final EnumC24286yM4 f() {
        return (EnumC24286yM4) this.f.getValue();
    }

    public final void h(float f) {
        this.a.s(f);
    }

    public final void i(long j) {
        this.e = j;
    }

    public final void k(EnumC24286yM4 enumC24286yM4, CK5 ck5, int i, int i2) {
        float f = i2 - i;
        g(f);
        if (ck5.i() != this.d.i() || ck5.l() != this.d.l()) {
            boolean z = enumC24286yM4 == EnumC24286yM4.a;
            b(z ? ck5.l() : ck5.i(), z ? ck5.e() : ck5.j(), i);
            this.d = ck5;
        }
        h(AbstractC23053wG5.l(d(), 0.0f, f));
        j(i);
    }

    public /* synthetic */ C18510om7(EnumC24286yM4 enumC24286yM4, float f, int i, ED1 ed1) {
        this(enumC24286yM4, (i & 2) != 0 ? 0.0f : f);
    }
}
