package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.a;
import androidx.compose.ui.focus.r;
import androidx.compose.ui.focus.u;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13780go3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22775vo3;
import ir.nasim.AbstractC23371wo3;
import ir.nasim.AbstractC4091Dq4;
import ir.nasim.AbstractC4236Eg5;
import ir.nasim.AbstractC4559Fq4;
import ir.nasim.AbstractC7397Rn6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9133Yq;
import ir.nasim.AbstractC9939ao6;
import ir.nasim.C17718nR7;
import ir.nasim.C18487ok4;
import ir.nasim.C19938rB7;
import ir.nasim.C23553x7;
import ir.nasim.C23864xe6;
import ir.nasim.C25166zq4;
import ir.nasim.C3534Bg5;
import ir.nasim.C4751Gk1;
import ir.nasim.C6616Og5;
import ir.nasim.C6951Pr2;
import ir.nasim.C8305Vk0;
import ir.nasim.C9839ae6;
import ir.nasim.EnumC15562jn4;
import ir.nasim.EnumC24286yM4;
import ir.nasim.EnumC4002Dg5;
import ir.nasim.InterfaceC11049ce6;
import ir.nasim.InterfaceC11379cu3;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC14124hO4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24551yo3;
import ir.nasim.InterfaceC4325Eq4;
import ir.nasim.InterfaceC7163Qn6;
import ir.nasim.InterfaceC7645Sp2;
import ir.nasim.InterfaceC8539Wk0;
import ir.nasim.InterfaceC9814ac1;
import ir.nasim.JI6;
import ir.nasim.KG1;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.VD1;
import ir.nasim.ZG4;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends androidx.compose.foundation.gestures.b implements InterfaceC24551yo3, InterfaceC7163Qn6, InterfaceC9814ac1 {
    private InterfaceC7645Sp2 A;
    private InterfaceC14603iB2 A0;
    private final boolean B;
    private C18487ok4 B0;
    private final C25166zq4 D;
    private final C9839ae6 G;
    private final VD1 H;
    private final C23864xe6 J;
    private final androidx.compose.foundation.gestures.e Y;
    private final C4751Gk1 Z;
    private InterfaceC14124hO4 z;
    private InterfaceC14603iB2 z0;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
            f.this.Z.P2(interfaceC11379cu3);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11379cu3) obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC14603iB2 d;
        final /* synthetic */ C23864xe6 e;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC4325Eq4 e;
            final /* synthetic */ C23864xe6 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC4325Eq4 interfaceC4325Eq4, C23864xe6 c23864xe6) {
                super(1);
                this.e = interfaceC4325Eq4;
                this.f = c23864xe6;
            }

            public final void a(a.b bVar) {
                this.e.a(this.f.C(bVar.a()), AbstractC4559Fq4.a.c());
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((a.b) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC14603iB2 interfaceC14603iB2, C23864xe6 c23864xe6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
            this.e = c23864xe6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4325Eq4 interfaceC4325Eq4 = (InterfaceC4325Eq4) this.c;
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                a aVar = new a(interfaceC4325Eq4, this.e);
                this.b = 1;
                if (interfaceC14603iB2.invoke(aVar, this) == objE) {
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
        public final Object invoke(InterfaceC4325Eq4 interfaceC4325Eq4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC4325Eq4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* synthetic */ class c extends C23553x7 implements InterfaceC14603iB2 {
        c(Object obj) {
            super(2, obj, f.class, "onWheelScrollStopped", "onWheelScrollStopped-TH1AsA0(J)V", 4);
        }

        public final Object a(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.b3((f) this.a, j, interfaceC20295rm1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((C17718nR7) obj).o(), (InterfaceC20295rm1) obj2);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C23864xe6 c23864xe6 = f.this.J;
                long j = this.d;
                this.b = 1;
                if (c23864xe6.u(j, false, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ long d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((InterfaceC4325Eq4) this.c).b(this.d, AbstractC4559Fq4.a.c());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC4325Eq4 interfaceC4325Eq4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC4325Eq4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C23864xe6 c23864xe6 = f.this.J;
                EnumC15562jn4 enumC15562jn4 = EnumC15562jn4.b;
                a aVar = new a(this.d, null);
                this.b = 1;
                if (c23864xe6.z(enumC15562jn4, aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: androidx.compose.foundation.gestures.f$f, reason: collision with other inner class name */
    static final class C0040f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0040f(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new C0040f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C23864xe6 c23864xe6 = f.this.J;
                long j = this.d;
                this.b = 1;
                if (c23864xe6.u(j, true, this) == objE) {
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
            return ((C0040f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC8614Ws3 implements SA2 {
        g() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(f.this.b2());
        }
    }

    static final class h extends AbstractC8614Ws3 implements InterfaceC14603iB2 {

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ f c;
            final /* synthetic */ float d;
            final /* synthetic */ float e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar, float f, float f2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = fVar;
                this.d = f;
                this.e = f2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C23864xe6 c23864xe6 = this.c.J;
                    float f = this.d;
                    float f2 = this.e;
                    long jE = ZG4.e((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
                    this.b = 1;
                    if (androidx.compose.foundation.gestures.d.l(c23864xe6, jE, this) == objE) {
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

        h() {
            super(2);
        }

        public final Boolean a(float f, float f2) {
            AbstractC10533bm0.d(f.this.U1(), null, null, new a(f.this, f, f2, null), 3, null);
            return Boolean.TRUE;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).floatValue(), ((Number) obj2).floatValue());
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ long c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = f.this.new i(interfaceC20295rm1);
            iVar.c = ((ZG4) obj).t();
            return iVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((ZG4) obj).t(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long j = this.c;
                C23864xe6 c23864xe6 = f.this.J;
                this.b = 1;
                obj = androidx.compose.foundation.gestures.d.l(c23864xe6, j, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        public final Object n(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(ZG4.d(j), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [ir.nasim.Sp2] */
    public f(InterfaceC11049ce6 interfaceC11049ce6, InterfaceC14124hO4 interfaceC14124hO4, InterfaceC7645Sp2 interfaceC7645Sp2, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2, InterfaceC18507om4 interfaceC18507om4, InterfaceC8539Wk0 interfaceC8539Wk0) {
        super(androidx.compose.foundation.gestures.d.a, z, interfaceC18507om4, enumC24286yM4);
        this.z = interfaceC14124hO4;
        this.A = interfaceC7645Sp2;
        C25166zq4 c25166zq4 = new C25166zq4();
        this.D = c25166zq4;
        this.G = (C9839ae6) v2(new C9839ae6(z));
        VD1 vd1 = new VD1(JI6.c(androidx.compose.foundation.gestures.d.d), null, 2, null);
        this.H = vd1;
        InterfaceC14124hO4 interfaceC14124hO42 = this.z;
        ?? r2 = this.A;
        C23864xe6 c23864xe6 = new C23864xe6(interfaceC11049ce6, interfaceC14124hO42, r2 == 0 ? vd1 : r2, enumC24286yM4, z2, c25166zq4, new g());
        this.J = c23864xe6;
        androidx.compose.foundation.gestures.e eVar = new androidx.compose.foundation.gestures.e(c23864xe6, z);
        this.Y = eVar;
        C4751Gk1 c4751Gk1 = (C4751Gk1) v2(new C4751Gk1(enumC24286yM4, c23864xe6, z2, interfaceC8539Wk0));
        this.Z = c4751Gk1;
        v2(AbstractC4091Dq4.c(eVar, c25166zq4));
        v2(r.b(u.a.b(), null, 2, null));
        v2(new C8305Vk0(c4751Gk1));
        v2(new C6951Pr2(new a()));
    }

    private final void Z2() {
        this.z0 = null;
        this.A0 = null;
    }

    private final void a3() {
        if (this.B0 == null) {
            this.B0 = new C18487ok4(this.J, AbstractC9133Yq.a(this), new c(this), KG1.k(this));
        }
        C18487ok4 c18487ok4 = this.B0;
        if (c18487ok4 != null) {
            c18487ok4.v(U1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object b3(f fVar, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        fVar.c3(j);
        return C19938rB7.a;
    }

    private final void c3(long j) {
        AbstractC10533bm0.d(this.D.e(), null, null, new C0040f(j, null), 3, null);
    }

    private final void d3() {
        this.z0 = new h();
        this.A0 = new i(null);
    }

    private final void f3() {
        if (b2()) {
            this.H.g(KG1.k(this));
        }
    }

    @Override // ir.nasim.JG1, ir.nasim.InterfaceC8508Wg5
    public void E() {
        i1();
        f3();
        C18487ok4 c18487ok4 = this.B0;
        if (c18487ok4 != null) {
            c18487ok4.z(KG1.k(this));
        }
    }

    @Override // androidx.compose.foundation.gestures.b
    public Object K2(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        C23864xe6 c23864xe6 = this.J;
        Object objZ = c23864xe6.z(EnumC15562jn4.b, new b(interfaceC14603iB2, c23864xe6, null), interfaceC20295rm1);
        return objZ == AbstractC14862ic3.e() ? objZ : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC24551yo3
    public boolean O0(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.foundation.gestures.b
    public void O2(long j) {
    }

    @Override // androidx.compose.foundation.gestures.b
    public void P2(long j) {
        AbstractC10533bm0.d(this.D.e(), null, null, new d(j, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.b
    public boolean T2() {
        return this.J.B();
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        if (M2() && (this.z0 == null || this.A0 == null)) {
            d3();
        }
        InterfaceC14603iB2 interfaceC14603iB2 = this.z0;
        if (interfaceC14603iB2 != null) {
            AbstractC9939ao6.V(interfaceC11943do6, null, interfaceC14603iB2, 1, null);
        }
        InterfaceC14603iB2 interfaceC14603iB22 = this.A0;
        if (interfaceC14603iB22 != null) {
            AbstractC9939ao6.W(interfaceC11943do6, interfaceC14603iB22);
        }
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return this.B;
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        f3();
        C18487ok4 c18487ok4 = this.B0;
        if (c18487ok4 != null) {
            c18487ok4.z(KG1.k(this));
        }
    }

    public final void e3(InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, InterfaceC14124hO4 interfaceC14124hO4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, InterfaceC18507om4 interfaceC18507om4, InterfaceC8539Wk0 interfaceC8539Wk0) {
        boolean z3;
        if (M2() != z) {
            this.Y.a(z);
            this.G.w2(z);
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z4 = z3;
        boolean zI = this.J.I(interfaceC11049ce6, enumC24286yM4, interfaceC14124hO4, z2, interfaceC7645Sp2 == null ? this.H : interfaceC7645Sp2, this.D);
        this.Z.S2(enumC24286yM4, z2, interfaceC8539Wk0);
        this.z = interfaceC14124hO4;
        this.A = interfaceC7645Sp2;
        V2(androidx.compose.foundation.gestures.d.a, z, interfaceC18507om4, this.J.t() ? EnumC24286yM4.a : EnumC24286yM4.b, zI);
        if (z4) {
            Z2();
            AbstractC7397Rn6.b(this);
        }
    }

    @Override // ir.nasim.InterfaceC24551yo3
    public boolean g1(KeyEvent keyEvent) {
        long jE;
        if (M2()) {
            long jA = AbstractC23371wo3.a(keyEvent);
            AbstractC13780go3.a aVar = AbstractC13780go3.a;
            if ((AbstractC13780go3.o(jA, aVar.j()) || AbstractC13780go3.o(AbstractC23371wo3.a(keyEvent), aVar.k())) && AbstractC22775vo3.e(AbstractC23371wo3.b(keyEvent), AbstractC22775vo3.a.a()) && !AbstractC23371wo3.e(keyEvent)) {
                if (this.J.t()) {
                    int iL2 = (int) (this.Z.L2() & 4294967295L);
                    jE = ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(AbstractC13780go3.o(AbstractC23371wo3.a(keyEvent), aVar.k()) ? iL2 : -iL2) & 4294967295L));
                } else {
                    int iL22 = (int) (this.Z.L2() >> 32);
                    jE = ZG4.e((Float.floatToRawIntBits(0.0f) & 4294967295L) | (Float.floatToRawIntBits(AbstractC13780go3.o(AbstractC23371wo3.a(keyEvent), aVar.k()) ? iL22 : -iL22) << 32));
                }
                AbstractC10533bm0.d(U1(), null, null, new e(jE, null), 3, null);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.foundation.gestures.b, ir.nasim.InterfaceC8508Wg5
    public void k1(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j) {
        List listC = c3534Bg5.c();
        int size = listC.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (((Boolean) L2().invoke((C6616Og5) listC.get(i2))).booleanValue()) {
                super.k1(c3534Bg5, enumC4002Dg5, j);
                break;
            }
            i2++;
        }
        if (M2()) {
            if (enumC4002Dg5 == EnumC4002Dg5.a && AbstractC4236Eg5.i(c3534Bg5.g(), AbstractC4236Eg5.a.f())) {
                a3();
            }
            C18487ok4 c18487ok4 = this.B0;
            if (c18487ok4 != null) {
                c18487ok4.u(c3534Bg5, enumC4002Dg5, j);
            }
        }
    }
}
