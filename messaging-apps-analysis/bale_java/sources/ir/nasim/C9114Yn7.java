package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC9998au2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Yn7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9114Yn7 extends e.c implements InterfaceC21655tu3, InterfaceC15687k02, InterfaceC7163Qn6 {
    private String o;
    private C9348Zn7 p;
    private AbstractC9998au2.b q;
    private int r;
    private boolean s;
    private int t;
    private int u;
    private VX0 v;
    private Map w;
    private C14196hW4 x;
    private UA2 y;
    private a z;

    /* renamed from: ir.nasim.Yn7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            C14196hW4 c14196hW4E2 = C9114Yn7.this.E2();
            C9348Zn7 c9348Zn7 = C9114Yn7.this.p;
            VX0 vx0 = C9114Yn7.this.v;
            C13774gn7 c13774gn7O = c14196hW4E2.o(c9348Zn7.K((16609104 & 1) != 0 ? C24381yX0.b.i() : vx0 != null ? vx0.a() : C24381yX0.b.i(), (16609104 & 2) != 0 ? C13193fo7.b.a() : 0L, (16609104 & 4) != 0 ? null : null, (16609104 & 8) != 0 ? null : null, (16609104 & 16) != 0 ? null : null, (16609104 & 32) != 0 ? null : null, (16609104 & 64) != 0 ? null : null, (16609104 & 128) != 0 ? C13193fo7.b.a() : 0L, (16609104 & 256) != 0 ? null : null, (16609104 & 512) != 0 ? null : null, (16609104 & 1024) != 0 ? null : null, (16609104 & 2048) != 0 ? C24381yX0.b.i() : 0L, (16609104 & 4096) != 0 ? null : null, (16609104 & 8192) != 0 ? null : null, (16609104 & 16384) != 0 ? null : null, (16609104 & 32768) != 0 ? C6399Nk7.b.g() : 0, (16609104 & 65536) != 0 ? C4049Dl7.b.f() : 0, (16609104 & 131072) != 0 ? C13193fo7.b.a() : 0L, (16609104 & 262144) != 0 ? null : null, (16609104 & 524288) != 0 ? null : null, (16609104 & 1048576) != 0 ? C4171Dz3.b.b() : 0, (16609104 & 2097152) != 0 ? C23811xZ2.b.c() : 0, (16609104 & 4194304) != 0 ? null : null, (16609104 & 8388608) != 0 ? null : null));
            if (c13774gn7O != null) {
                list.add(c13774gn7O);
            } else {
                c13774gn7O = null;
            }
            return Boolean.valueOf(c13774gn7O != null);
        }
    }

    /* renamed from: ir.nasim.Yn7$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C13245fu c13245fu) {
            C9114Yn7.this.I2(c13245fu.k());
            C9114Yn7.this.H2();
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Yn7$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        public final Boolean a(boolean z) {
            if (C9114Yn7.this.z == null) {
                return Boolean.FALSE;
            }
            a aVar = C9114Yn7.this.z;
            if (aVar != null) {
                aVar.e(z);
            }
            C9114Yn7.this.H2();
            return Boolean.TRUE;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Boolean) obj).booleanValue());
        }
    }

    /* renamed from: ir.nasim.Yn7$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            C9114Yn7.this.C2();
            C9114Yn7.this.H2();
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Yn7$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.h(aVar, this.e, 0, 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ C9114Yn7(String str, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3, VX0 vx0, ED1 ed1) {
        this(str, c9348Zn7, bVar, i, z, i2, i3, vx0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C2() {
        this.z = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C14196hW4 E2() {
        if (this.x == null) {
            this.x = new C14196hW4(this.o, this.p, this.q, this.r, this.s, this.t, this.u, null);
        }
        C14196hW4 c14196hW4 = this.x;
        AbstractC13042fc3.f(c14196hW4);
        return c14196hW4;
    }

    private final C14196hW4 F2(InterfaceC10436bc3 interfaceC10436bc3) {
        C14196hW4 c14196hW4G2 = G2();
        c14196hW4G2.m(interfaceC10436bc3);
        return c14196hW4G2;
    }

    private final C14196hW4 G2() {
        C14196hW4 c14196hW4A;
        a aVar = this.z;
        if (aVar != null) {
            if (!aVar.c()) {
                aVar = null;
            }
            if (aVar != null && (c14196hW4A = aVar.a()) != null) {
                return c14196hW4A;
            }
        }
        return E2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H2() {
        AbstractC7397Rn6.b(this);
        AbstractC23431wu3.b(this);
        AbstractC16278l02.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I2(String str) {
        C19938rB7 c19938rB7;
        a aVar = this.z;
        if (aVar == null) {
            a aVar2 = new a(this.o, str, false, null, 12, null);
            C14196hW4 c14196hW4 = new C14196hW4(str, this.p, this.q, this.r, this.s, this.t, this.u, null);
            c14196hW4.m(E2().a());
            aVar2.d(c14196hW4);
            this.z = aVar2;
            return true;
        }
        if (AbstractC13042fc3.d(str, aVar.b())) {
            return false;
        }
        aVar.f(str);
        C14196hW4 c14196hW4A = aVar.a();
        if (c14196hW4A != null) {
            c14196hW4A.p(str, this.p, this.q, this.r, this.s, this.t, this.u);
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        return c19938rB7 != null;
    }

    public final void D2(boolean z, boolean z2, boolean z3) {
        if (z2 || z3) {
            E2().p(this.o, this.p, this.q, this.r, this.s, this.t, this.u);
        }
        if (b2()) {
            if (z2 || (z && this.y != null)) {
                AbstractC7397Rn6.b(this);
            }
            if (z2 || z3) {
                AbstractC23431wu3.b(this);
                AbstractC16278l02.a(this);
            }
            if (z) {
                AbstractC16278l02.a(this);
            }
        }
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return F2(interfaceC10436bc3).f(i, interfaceC10436bc3.getLayoutDirection());
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return F2(interfaceC10436bc3).f(i, interfaceC10436bc3.getLayoutDirection());
    }

    public final boolean J2(VX0 vx0, C9348Zn7 c9348Zn7) {
        boolean z = !AbstractC13042fc3.d(vx0, this.v);
        this.v = vx0;
        return z || !c9348Zn7.F(this.p);
    }

    public final boolean K2(C9348Zn7 c9348Zn7, int i, int i2, boolean z, AbstractC9998au2.b bVar, int i3) {
        boolean z2 = !this.p.G(c9348Zn7);
        this.p = c9348Zn7;
        if (this.u != i) {
            this.u = i;
            z2 = true;
        }
        if (this.t != i2) {
            this.t = i2;
            z2 = true;
        }
        if (this.s != z) {
            this.s = z;
            z2 = true;
        }
        if (!AbstractC13042fc3.d(this.q, bVar)) {
            this.q = bVar;
            z2 = true;
        }
        if (AbstractC23365wn7.g(this.r, i3)) {
            return z2;
        }
        this.r = i3;
        return true;
    }

    public final boolean L2(String str) {
        if (AbstractC13042fc3.d(this.o, str)) {
            return false;
        }
        this.o = str;
        C2();
        return true;
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        UA2 bVar = this.y;
        if (bVar == null) {
            bVar = new b();
            this.y = bVar;
        }
        AbstractC9939ao6.w0(interfaceC11943do6, new C13245fu(this.o, null, 2, null));
        a aVar = this.z;
        if (aVar != null) {
            AbstractC9939ao6.t0(interfaceC11943do6, aVar.c());
            AbstractC9939ao6.A0(interfaceC11943do6, new C13245fu(aVar.b(), null, 2, null));
        }
        AbstractC9939ao6.C0(interfaceC11943do6, null, new c(), 1, null);
        AbstractC9939ao6.I0(interfaceC11943do6, null, new d(), 1, null);
        AbstractC9939ao6.d(interfaceC11943do6, null, new e(), 1, null);
        AbstractC9939ao6.s(interfaceC11943do6, null, bVar, 1, null);
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        C14196hW4 c14196hW4F2 = F2(interfaceC12377eW3);
        boolean zH = c14196hW4F2.h(j, interfaceC12377eW3.getLayoutDirection());
        c14196hW4F2.d();
        InterfaceC10355bW4 interfaceC10355bW4E = c14196hW4F2.e();
        AbstractC13042fc3.f(interfaceC10355bW4E);
        long jC = c14196hW4F2.c();
        if (zH) {
            AbstractC23431wu3.a(this);
            Map map = this.w;
            if (map == null) {
                map = new HashMap(2);
                this.w = map;
            }
            map.put(AbstractC13756gm.a(), Integer.valueOf(Math.round(interfaceC10355bW4E.k())));
            map.put(AbstractC13756gm.b(), Integer.valueOf(Math.round(interfaceC10355bW4E.z())));
        }
        int i = (int) (jC >> 32);
        int i2 = (int) (jC & 4294967295L);
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(C17833ne1.b.b(i, i, i2, i2));
        Map map2 = this.w;
        AbstractC13042fc3.f(map2);
        return interfaceC12377eW3.P1(i, i2, map2, new f(abstractC21430te5L0));
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        if (b2()) {
            C14196hW4 c14196hW4G2 = G2();
            InterfaceC10355bW4 interfaceC10355bW4E = c14196hW4G2.e();
            if (interfaceC10355bW4E == null) {
                P73.b("no paragraph (layoutCache=" + this.x + ", textSubstitution=" + this.z + ')');
                throw new KotlinNothingValueException();
            }
            UE0 ue0E = interfaceC23919xk1.z1().e();
            boolean zB = c14196hW4G2.b();
            if (zB) {
                float fC = (int) (c14196hW4G2.c() >> 32);
                float fC2 = (int) (c14196hW4G2.c() & 4294967295L);
                ue0E.n();
                UE0.g(ue0E, 0.0f, 0.0f, fC, fC2, 0, 16, null);
            }
            try {
                C24525yl7 c24525yl7A = this.p.A();
                if (c24525yl7A == null) {
                    c24525yl7A = C24525yl7.b.c();
                }
                C24525yl7 c24525yl7 = c24525yl7A;
                C5566Jw6 c5566Jw6X = this.p.x();
                if (c5566Jw6X == null) {
                    c5566Jw6X = C5566Jw6.d.a();
                }
                C5566Jw6 c5566Jw6 = c5566Jw6X;
                AbstractC18051o02 abstractC18051o02I = this.p.i();
                if (abstractC18051o02I == null) {
                    abstractC18051o02I = C8568Wn2.a;
                }
                AbstractC18051o02 abstractC18051o02 = abstractC18051o02I;
                AbstractC12520el0 abstractC12520el0G = this.p.g();
                if (abstractC12520el0G != null) {
                    InterfaceC10355bW4.i(interfaceC10355bW4E, ue0E, abstractC12520el0G, this.p.d(), c5566Jw6, c24525yl7, abstractC18051o02, 0, 64, null);
                } else {
                    VX0 vx0 = this.v;
                    long jA = vx0 != null ? vx0.a() : C24381yX0.b.i();
                    if (jA == 16) {
                        jA = this.p.h() != 16 ? this.p.h() : C24381yX0.b.a();
                    }
                    InterfaceC10355bW4.r(interfaceC10355bW4E, ue0E, jA, c5566Jw6, c24525yl7, abstractC18051o02, 0, 32, null);
                }
                if (zB) {
                    ue0E.i();
                }
            } catch (Throwable th) {
                if (zB) {
                    ue0E.i();
                }
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return F2(interfaceC10436bc3).k(interfaceC10436bc3.getLayoutDirection());
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return F2(interfaceC10436bc3).j(interfaceC10436bc3.getLayoutDirection());
    }

    private C9114Yn7(String str, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, int i, boolean z, int i2, int i3, VX0 vx0) {
        this.o = str;
        this.p = c9348Zn7;
        this.q = bVar;
        this.r = i;
        this.s = z;
        this.t = i2;
        this.u = i3;
        this.v = vx0;
    }

    /* renamed from: ir.nasim.Yn7$a */
    public static final class a {
        private final String a;
        private String b;
        private boolean c;
        private C14196hW4 d;

        public a(String str, String str2, boolean z, C14196hW4 c14196hW4) {
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = c14196hW4;
        }

        public final C14196hW4 a() {
            return this.d;
        }

        public final String b() {
            return this.b;
        }

        public final boolean c() {
            return this.c;
        }

        public final void d(C14196hW4 c14196hW4) {
            this.d = c14196hW4;
        }

        public final void e(boolean z) {
            this.c = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d);
        }

        public final void f(String str) {
            this.b = str;
        }

        public int hashCode() {
            int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31;
            C14196hW4 c14196hW4 = this.d;
            return iHashCode + (c14196hW4 == null ? 0 : c14196hW4.hashCode());
        }

        public String toString() {
            return "TextSubstitution(layoutCache=" + this.d + ", isShowingSubstitution=" + this.c + ')';
        }

        public /* synthetic */ a(String str, String str2, boolean z, C14196hW4 c14196hW4, int i, ED1 ed1) {
            this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : c14196hW4);
        }
    }
}
