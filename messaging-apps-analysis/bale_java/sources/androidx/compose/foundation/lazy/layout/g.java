package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC7397Rn6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9939ao6;
import ir.nasim.C19938rB7;
import ir.nasim.C5629Kd6;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC20397rw3;
import ir.nasim.InterfaceC6030Lw3;
import ir.nasim.InterfaceC7163Qn6;
import ir.nasim.OW0;
import ir.nasim.P73;
import ir.nasim.SA2;
import ir.nasim.UA2;

/* loaded from: classes.dex */
final class g extends e.c implements InterfaceC7163Qn6 {
    private SA2 o;
    private InterfaceC6030Lw3 p;
    private EnumC24286yM4 q;
    private boolean r;
    private boolean s;
    private C5629Kd6 t;
    private final UA2 u = new b();
    private UA2 v;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(g.this.p.e() - g.this.p.a());
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(Object obj) {
            InterfaceC20397rw3 interfaceC20397rw3 = (InterfaceC20397rw3) g.this.o.invoke();
            int iA = interfaceC20397rw3.a();
            int i = 0;
            while (true) {
                if (i >= iA) {
                    i = -1;
                    break;
                }
                if (AbstractC13042fc3.d(interfaceC20397rw3.d(i), obj)) {
                    break;
                }
                i++;
            }
            return Integer.valueOf(i);
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(g.this.p.f());
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(g.this.p.b());
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ g c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = gVar;
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC6030Lw3 interfaceC6030Lw3 = this.c.p;
                    int i2 = this.d;
                    this.b = 1;
                    if (interfaceC6030Lw3.c(i2, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e() {
            super(1);
        }

        public final Boolean a(int i) {
            InterfaceC20397rw3 interfaceC20397rw3 = (InterfaceC20397rw3) g.this.o.invoke();
            if (!(i >= 0 && i < interfaceC20397rw3.a())) {
                P73.a("Can't scroll to index " + i + ", it is out of bounds [0, " + interfaceC20397rw3.a() + ')');
            }
            AbstractC10533bm0.d(g.this.U1(), null, null, new a(g.this, i, null), 3, null);
            return Boolean.TRUE;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public g(SA2 sa2, InterfaceC6030Lw3 interfaceC6030Lw3, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2) {
        this.o = sa2;
        this.p = interfaceC6030Lw3;
        this.q = enumC24286yM4;
        this.r = z;
        this.s = z2;
        A2();
    }

    private final void A2() {
        this.t = new C5629Kd6(new c(), new d(), this.s);
        this.v = this.r ? new e() : null;
    }

    private final OW0 x2() {
        return this.p.d();
    }

    private final boolean y2() {
        return this.q == EnumC24286yM4.a;
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC9939ao6.E0(interfaceC11943do6, true);
        AbstractC9939ao6.u(interfaceC11943do6, this.u);
        if (y2()) {
            C5629Kd6 c5629Kd6 = this.t;
            if (c5629Kd6 == null) {
                AbstractC13042fc3.y("scrollAxisRange");
                c5629Kd6 = null;
            }
            AbstractC9939ao6.G0(interfaceC11943do6, c5629Kd6);
        } else {
            C5629Kd6 c5629Kd62 = this.t;
            if (c5629Kd62 == null) {
                AbstractC13042fc3.y("scrollAxisRange");
                c5629Kd62 = null;
            }
            AbstractC9939ao6.i0(interfaceC11943do6, c5629Kd62);
        }
        UA2 ua2 = this.v;
        if (ua2 != null) {
            AbstractC9939ao6.Y(interfaceC11943do6, null, ua2, 1, null);
        }
        AbstractC9939ao6.q(interfaceC11943do6, null, new a(), 1, null);
        AbstractC9939ao6.a0(interfaceC11943do6, x2());
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return false;
    }

    public final void z2(SA2 sa2, InterfaceC6030Lw3 interfaceC6030Lw3, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2) {
        this.o = sa2;
        this.p = interfaceC6030Lw3;
        if (this.q != enumC24286yM4) {
            this.q = enumC24286yM4;
            AbstractC7397Rn6.b(this);
        }
        if (this.r == z && this.s == z2) {
            return;
        }
        this.r = z;
        this.s = z2;
        A2();
        AbstractC7397Rn6.b(this);
    }
}
