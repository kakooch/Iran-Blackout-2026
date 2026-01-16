package androidx.compose.animation;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC24021xu3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C14638iE6;
import ir.nasim.C15866kJ0;
import ir.nasim.C19938rB7;
import ir.nasim.C21669tv7;
import ir.nasim.C22045ua3;
import ir.nasim.C4414Fa3;
import ir.nasim.EnumC12613eu3;
import ir.nasim.EnumC17550n92;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC21900uK2;
import ir.nasim.InterfaceC4788Go2;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.ZV3;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
final class g extends AbstractC24021xu3 {
    private C21669tv7 o;
    private C21669tv7.a p;
    private C21669tv7.a q;
    private C21669tv7.a r;
    private androidx.compose.animation.h s;
    private androidx.compose.animation.j t;
    private SA2 u;
    private InterfaceC21900uK2 v;
    private boolean w;
    private InterfaceC12529em z;
    private long x = androidx.compose.animation.e.c();
    private long y = AbstractC19606qe1.b(0, 0, 0, 0, 15, null);
    private final UA2 A = new i();
    private final UA2 B = new j();

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC17550n92.values().length];
            try {
                iArr[EnumC17550n92.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC17550n92.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC17550n92.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC21430te5 abstractC21430te5) {
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

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ UA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC21430te5 abstractC21430te5, long j, long j2, UA2 ua2) {
            super(1);
            this.e = abstractC21430te5;
            this.f = j;
            this.g = j2;
            this.h = ua2;
        }

        public final void a(AbstractC21430te5.a aVar) {
            aVar.u(this.e, C22045ua3.k(this.g) + C22045ua3.k(this.f), C22045ua3.l(this.g) + C22045ua3.l(this.f), 0.0f, this.h);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AbstractC21430te5 abstractC21430te5) {
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

    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j) {
            super(1);
            this.f = j;
        }

        public final long a(EnumC17550n92 enumC17550n92) {
            return g.this.H2(enumC17550n92, this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C4414Fa3.b(a((EnumC17550n92) obj));
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC4788Go2 invoke(C21669tv7.b bVar) {
            return androidx.compose.animation.f.c;
        }
    }

    /* renamed from: androidx.compose.animation.g$g, reason: collision with other inner class name */
    static final class C0028g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0028g(long j) {
            super(1);
            this.f = j;
        }

        public final long a(EnumC17550n92 enumC17550n92) {
            return g.this.J2(enumC17550n92, this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C22045ua3.c(a((EnumC17550n92) obj));
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j) {
            super(1);
            this.f = j;
        }

        public final long a(EnumC17550n92 enumC17550n92) {
            return g.this.I2(enumC17550n92, this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C22045ua3.c(a((EnumC17550n92) obj));
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        i() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC4788Go2 invoke(C21669tv7.b bVar) {
            EnumC17550n92 enumC17550n92 = EnumC17550n92.a;
            EnumC17550n92 enumC17550n922 = EnumC17550n92.b;
            InterfaceC4788Go2 interfaceC4788Go2B = null;
            if (bVar.c(enumC17550n92, enumC17550n922)) {
                C15866kJ0 c15866kJ0A = g.this.w2().b().a();
                if (c15866kJ0A != null) {
                    interfaceC4788Go2B = c15866kJ0A.b();
                }
            } else if (bVar.c(enumC17550n922, EnumC17550n92.c)) {
                C15866kJ0 c15866kJ0A2 = g.this.x2().b().a();
                if (c15866kJ0A2 != null) {
                    interfaceC4788Go2B = c15866kJ0A2.b();
                }
            } else {
                interfaceC4788Go2B = androidx.compose.animation.f.d;
            }
            return interfaceC4788Go2B == null ? androidx.compose.animation.f.d : interfaceC4788Go2B;
        }
    }

    static final class j extends AbstractC8614Ws3 implements UA2 {
        j() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC4788Go2 invoke(C21669tv7.b bVar) {
            InterfaceC4788Go2 interfaceC4788Go2A;
            InterfaceC4788Go2 interfaceC4788Go2A2;
            EnumC17550n92 enumC17550n92 = EnumC17550n92.a;
            EnumC17550n92 enumC17550n922 = EnumC17550n92.b;
            if (bVar.c(enumC17550n92, enumC17550n922)) {
                C14638iE6 c14638iE6F = g.this.w2().b().f();
                return (c14638iE6F == null || (interfaceC4788Go2A2 = c14638iE6F.a()) == null) ? androidx.compose.animation.f.c : interfaceC4788Go2A2;
            }
            if (!bVar.c(enumC17550n922, EnumC17550n92.c)) {
                return androidx.compose.animation.f.c;
            }
            C14638iE6 c14638iE6F2 = g.this.x2().b().f();
            return (c14638iE6F2 == null || (interfaceC4788Go2A = c14638iE6F2.a()) == null) ? androidx.compose.animation.f.c : interfaceC4788Go2A;
        }
    }

    public g(C21669tv7 c21669tv7, C21669tv7.a aVar, C21669tv7.a aVar2, C21669tv7.a aVar3, androidx.compose.animation.h hVar, androidx.compose.animation.j jVar, SA2 sa2, InterfaceC21900uK2 interfaceC21900uK2) {
        this.o = c21669tv7;
        this.p = aVar;
        this.q = aVar2;
        this.r = aVar3;
        this.s = hVar;
        this.t = jVar;
        this.u = sa2;
        this.v = interfaceC21900uK2;
    }

    private final void C2(long j2) {
        this.w = true;
        this.y = j2;
    }

    public final void A2(androidx.compose.animation.j jVar) {
        this.t = jVar;
    }

    public final void B2(InterfaceC21900uK2 interfaceC21900uK2) {
        this.v = interfaceC21900uK2;
    }

    public final void D2(C21669tv7.a aVar) {
        this.q = aVar;
    }

    public final void E2(C21669tv7.a aVar) {
        this.p = aVar;
    }

    public final void F2(C21669tv7.a aVar) {
        this.r = aVar;
    }

    public final void G2(C21669tv7 c21669tv7) {
        this.o = c21669tv7;
    }

    public final long H2(EnumC17550n92 enumC17550n92, long j2) {
        UA2 ua2D;
        UA2 ua2D2;
        int i2 = a.a[enumC17550n92.ordinal()];
        if (i2 == 1) {
            return j2;
        }
        if (i2 == 2) {
            C15866kJ0 c15866kJ0A = this.s.b().a();
            return (c15866kJ0A == null || (ua2D = c15866kJ0A.d()) == null) ? j2 : ((C4414Fa3) ua2D.invoke(C4414Fa3.b(j2))).j();
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        C15866kJ0 c15866kJ0A2 = this.t.b().a();
        return (c15866kJ0A2 == null || (ua2D2 = c15866kJ0A2.d()) == null) ? j2 : ((C4414Fa3) ua2D2.invoke(C4414Fa3.b(j2))).j();
    }

    public final long I2(EnumC17550n92 enumC17550n92, long j2) {
        UA2 ua2B;
        UA2 ua2B2;
        C14638iE6 c14638iE6F = this.s.b().f();
        long jB = (c14638iE6F == null || (ua2B2 = c14638iE6F.b()) == null) ? C22045ua3.b.b() : ((C22045ua3) ua2B2.invoke(C4414Fa3.b(j2))).r();
        C14638iE6 c14638iE6F2 = this.t.b().f();
        long jB2 = (c14638iE6F2 == null || (ua2B = c14638iE6F2.b()) == null) ? C22045ua3.b.b() : ((C22045ua3) ua2B.invoke(C4414Fa3.b(j2))).r();
        int i2 = a.a[enumC17550n92.ordinal()];
        if (i2 == 1) {
            return C22045ua3.b.b();
        }
        if (i2 == 2) {
            return jB;
        }
        if (i2 == 3) {
            return jB2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final long J2(EnumC17550n92 enumC17550n92, long j2) {
        if (this.z == null) {
            return C22045ua3.b.b();
        }
        if (v2() == null) {
            return C22045ua3.b.b();
        }
        if (AbstractC13042fc3.d(this.z, v2())) {
            return C22045ua3.b.b();
        }
        int i2 = a.a[enumC17550n92.ordinal()];
        if (i2 == 1) {
            return C22045ua3.b.b();
        }
        if (i2 == 2) {
            return C22045ua3.b.b();
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        C15866kJ0 c15866kJ0A = this.t.b().a();
        if (c15866kJ0A == null) {
            return C22045ua3.b.b();
        }
        long j3 = ((C4414Fa3) c15866kJ0A.d().invoke(C4414Fa3.b(j2))).j();
        InterfaceC12529em interfaceC12529emV2 = v2();
        AbstractC13042fc3.f(interfaceC12529emV2);
        EnumC12613eu3 enumC12613eu3 = EnumC12613eu3.a;
        long jA = interfaceC12529emV2.a(j2, j3, enumC12613eu3);
        InterfaceC12529em interfaceC12529em = this.z;
        AbstractC13042fc3.f(interfaceC12529em);
        return C22045ua3.n(jA, interfaceC12529em.a(j2, j3, enumC12613eu3));
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j2) {
        InterfaceC9664aL6 interfaceC9664aL6A;
        InterfaceC9664aL6 interfaceC9664aL6A2;
        if (this.o.h() == this.o.o()) {
            this.z = null;
        } else if (this.z == null) {
            InterfaceC12529em interfaceC12529emV2 = v2();
            if (interfaceC12529emV2 == null) {
                interfaceC12529emV2 = InterfaceC12529em.a.o();
            }
            this.z = interfaceC12529emV2;
        }
        if (interfaceC12377eW3.s0()) {
            AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j2);
            long jC = C4414Fa3.c((abstractC21430te5L0.P0() << 32) | (abstractC21430te5L0.A0() & 4294967295L));
            this.x = jC;
            C2(j2);
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, (int) (jC >> 32), (int) (jC & 4294967295L), null, new b(abstractC21430te5L0), 4, null);
        }
        if (!((Boolean) this.u.invoke()).booleanValue()) {
            AbstractC21430te5 abstractC21430te5L02 = zv3.l0(j2);
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L02.P0(), abstractC21430te5L02.A0(), null, new d(abstractC21430te5L02), 4, null);
        }
        UA2 ua2Init = this.v.init();
        AbstractC21430te5 abstractC21430te5L03 = zv3.l0(j2);
        long jC2 = C4414Fa3.c((abstractC21430te5L03.P0() << 32) | (abstractC21430te5L03.A0() & 4294967295L));
        long j3 = androidx.compose.animation.e.d(this.x) ? this.x : jC2;
        C21669tv7.a aVar = this.p;
        InterfaceC9664aL6 interfaceC9664aL6A3 = aVar != null ? aVar.a(this.A, new e(j3)) : null;
        if (interfaceC9664aL6A3 != null) {
            jC2 = ((C4414Fa3) interfaceC9664aL6A3.getValue()).j();
        }
        long jD = AbstractC19606qe1.d(j2, jC2);
        C21669tv7.a aVar2 = this.q;
        long jB = (aVar2 == null || (interfaceC9664aL6A2 = aVar2.a(f.e, new C0028g(j3))) == null) ? C22045ua3.b.b() : ((C22045ua3) interfaceC9664aL6A2.getValue()).r();
        C21669tv7.a aVar3 = this.r;
        long jB2 = (aVar3 == null || (interfaceC9664aL6A = aVar3.a(this.B, new h(j3))) == null) ? C22045ua3.b.b() : ((C22045ua3) interfaceC9664aL6A.getValue()).r();
        InterfaceC12529em interfaceC12529em = this.z;
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, (int) (jD >> 32), (int) (jD & 4294967295L), null, new c(abstractC21430te5L03, C22045ua3.o(interfaceC12529em != null ? interfaceC12529em.a(j3, jD, EnumC12613eu3.a) : C22045ua3.b.b(), jB2), jB, ua2Init), 4, null);
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        super.e2();
        this.w = false;
        this.x = androidx.compose.animation.e.c();
    }

    public final InterfaceC12529em v2() {
        InterfaceC12529em interfaceC12529emA;
        if (this.o.m().c(EnumC17550n92.a, EnumC17550n92.b)) {
            C15866kJ0 c15866kJ0A = this.s.b().a();
            if (c15866kJ0A == null || (interfaceC12529emA = c15866kJ0A.a()) == null) {
                C15866kJ0 c15866kJ0A2 = this.t.b().a();
                if (c15866kJ0A2 != null) {
                    return c15866kJ0A2.a();
                }
                return null;
            }
        } else {
            C15866kJ0 c15866kJ0A3 = this.t.b().a();
            if (c15866kJ0A3 == null || (interfaceC12529emA = c15866kJ0A3.a()) == null) {
                C15866kJ0 c15866kJ0A4 = this.s.b().a();
                if (c15866kJ0A4 != null) {
                    return c15866kJ0A4.a();
                }
                return null;
            }
        }
        return interfaceC12529emA;
    }

    public final androidx.compose.animation.h w2() {
        return this.s;
    }

    public final androidx.compose.animation.j x2() {
        return this.t;
    }

    public final void y2(SA2 sa2) {
        this.u = sa2;
    }

    public final void z2(androidx.compose.animation.h hVar) {
        this.s = hVar;
    }
}
