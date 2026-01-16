package androidx.compose.animation;

import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC24021xu3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C15607js;
import ir.nasim.C19938rB7;
import ir.nasim.C4414Fa3;
import ir.nasim.C4830Gt;
import ir.nasim.ED1;
import ir.nasim.EnumC3406At;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC5766Kt;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.PQ7;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class l extends AbstractC24021xu3 {
    private InterfaceC5766Kt o;
    private InterfaceC12529em p;
    private InterfaceC14603iB2 q;
    private boolean t;
    private long r = e.c();
    private long s = AbstractC19606qe1.b(0, 0, 0, 0, 15, null);
    private final InterfaceC9102Ym4 u = AbstractC13472gH6.d(null, null, 2, null);

    public static final class a {
        private final C15607js a;
        private long b;

        public /* synthetic */ a(C15607js c15607js, long j, ED1 ed1) {
            this(c15607js, j);
        }

        public final C15607js a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public final void c(long j) {
            this.b = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && C4414Fa3.e(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + C4414Fa3.h(this.b);
        }

        public String toString() {
            return "AnimData(anim=" + this.a + ", startSize=" + ((Object) C4414Fa3.i(this.b)) + ')';
        }

        private a(C15607js c15607js, long j) {
            this.a = c15607js;
            this.b = j;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ a c;
        final /* synthetic */ long d;
        final /* synthetic */ l e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, long j, l lVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = aVar;
            this.d = j;
            this.e = lVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC14603iB2 interfaceC14603iB2Z2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607jsA = this.c.a();
                C4414Fa3 c4414Fa3B = C4414Fa3.b(this.d);
                InterfaceC5766Kt interfaceC5766KtY2 = this.e.y2();
                this.b = 1;
                obj = C15607js.h(c15607jsA, c4414Fa3B, interfaceC5766KtY2, null, null, this, 12, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C4830Gt c4830Gt = (C4830Gt) obj;
            if (c4830Gt.a() == EnumC3406At.b && (interfaceC14603iB2Z2 = this.e.z2()) != null) {
                interfaceC14603iB2Z2.invoke(C4414Fa3.b(this.c.b()), c4830Gt.b().getValue());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ InterfaceC12377eW3 i;
        final /* synthetic */ AbstractC21430te5 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, int i, int i2, InterfaceC12377eW3 interfaceC12377eW3, AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.f = j;
            this.g = i;
            this.h = i2;
            this.i = interfaceC12377eW3;
            this.j = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.j(aVar, this.j, l.this.w2().a(this.f, C4414Fa3.c((this.g << 32) | (this.h & 4294967295L)), this.i.getLayoutDirection()), 0.0f, 2, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public l(InterfaceC5766Kt interfaceC5766Kt, InterfaceC12529em interfaceC12529em, InterfaceC14603iB2 interfaceC14603iB2) {
        this.o = interfaceC5766Kt;
        this.p = interfaceC12529em;
        this.q = interfaceC14603iB2;
    }

    private final void E2(long j) {
        this.s = j;
        this.t = true;
    }

    private final long F2(long j) {
        return this.t ? this.s : j;
    }

    public final void A2(InterfaceC12529em interfaceC12529em) {
        this.p = interfaceC12529em;
    }

    public final void B2(a aVar) {
        this.u.setValue(aVar);
    }

    public final void C2(InterfaceC5766Kt interfaceC5766Kt) {
        this.o = interfaceC5766Kt;
    }

    public final void D2(InterfaceC14603iB2 interfaceC14603iB2) {
        this.q = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0;
        long jD;
        if (interfaceC12377eW3.s0()) {
            E2(j);
            abstractC21430te5L0 = zv3.l0(j);
        } else {
            abstractC21430te5L0 = zv3.l0(F2(j));
        }
        AbstractC21430te5 abstractC21430te5 = abstractC21430te5L0;
        long jC = C4414Fa3.c((abstractC21430te5.P0() << 32) | (abstractC21430te5.A0() & 4294967295L));
        if (interfaceC12377eW3.s0()) {
            this.r = jC;
            jD = jC;
        } else {
            jD = AbstractC19606qe1.d(j, v2(e.d(this.r) ? this.r : jC));
        }
        int i = (int) (jD >> 32);
        int i2 = (int) (jD & 4294967295L);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, i, i2, null, new c(jC, i, i2, interfaceC12377eW3, abstractC21430te5), 4, null);
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        super.e2();
        this.r = e.c();
        this.t = false;
    }

    @Override // androidx.compose.ui.e.c
    public void g2() {
        super.g2();
        B2(null);
    }

    public final long v2(long j) {
        a aVarX2 = x2();
        if (aVarX2 != null) {
            boolean z = (C4414Fa3.e(j, ((C4414Fa3) aVarX2.a().q()).j()) || aVarX2.a().t()) ? false : true;
            if (!C4414Fa3.e(j, ((C4414Fa3) aVarX2.a().n()).j()) || z) {
                aVarX2.c(((C4414Fa3) aVarX2.a().q()).j());
                AbstractC10533bm0.d(U1(), null, null, new b(aVarX2, j, this, null), 3, null);
            }
        } else {
            long j2 = 1;
            aVarX2 = new a(new C15607js(C4414Fa3.b(j), PQ7.g(C4414Fa3.b), C4414Fa3.b(C4414Fa3.c((j2 & 4294967295L) | (j2 << 32))), null, 8, null), j, null);
        }
        B2(aVarX2);
        return ((C4414Fa3) aVarX2.a().q()).j();
    }

    public final InterfaceC12529em w2() {
        return this.p;
    }

    public final a x2() {
        return (a) this.u.getValue();
    }

    public final InterfaceC5766Kt y2() {
        return this.o;
    }

    public final InterfaceC14603iB2 z2() {
        return this.q;
    }
}
