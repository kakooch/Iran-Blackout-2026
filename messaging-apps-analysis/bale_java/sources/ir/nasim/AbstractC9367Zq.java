package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.C20576sF0;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Zq, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9367Zq {

    /* renamed from: ir.nasim.Zq$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC12243eH4 e;
        final /* synthetic */ InterfaceC12529em f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC12243eH4 interfaceC12243eH4, InterfaceC12529em interfaceC12529em, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = interfaceC12243eH4;
            this.f = interfaceC12529em;
            this.g = interfaceC14603iB2;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC9367Zq.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zq$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC18354oW7 e;
        final /* synthetic */ long f;
        final /* synthetic */ boolean g;
        final /* synthetic */ androidx.compose.ui.e h;
        final /* synthetic */ InterfaceC12243eH4 i;

        /* renamed from: ir.nasim.Zq$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ long e;
            final /* synthetic */ boolean f;
            final /* synthetic */ androidx.compose.ui.e g;
            final /* synthetic */ InterfaceC12243eH4 h;

            /* renamed from: ir.nasim.Zq$b$a$a, reason: collision with other inner class name */
            static final class C0813a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ InterfaceC12243eH4 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0813a(InterfaceC12243eH4 interfaceC12243eH4) {
                    super(0);
                    this.e = interfaceC12243eH4;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    return Boolean.valueOf((this.e.a() & 9223372034707292159L) != 9205357640488583168L);
                }
            }

            /* renamed from: ir.nasim.Zq$b$a$b, reason: collision with other inner class name */
            static final class C0814b extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ InterfaceC12243eH4 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0814b(InterfaceC12243eH4 interfaceC12243eH4) {
                    super(0);
                    this.e = interfaceC12243eH4;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    return Boolean.valueOf((this.e.a() & 9223372034707292159L) != 9205357640488583168L);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j, boolean z, androidx.compose.ui.e eVar, InterfaceC12243eH4 interfaceC12243eH4) {
                super(2);
                this.e = j;
                this.f = z;
                this.g = eVar;
                this.h = interfaceC12243eH4;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, 1 & i)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(1260045569, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:86)");
                }
                if (this.e != 9205357640488583168L) {
                    interfaceC22053ub1.W(-837626688);
                    C24254yJ.e eVarB = this.f ? C24254yJ.a.a.b() : C24254yJ.a.a.a();
                    androidx.compose.ui.e eVarP = androidx.compose.foundation.layout.t.p(this.g, C20148rZ1.j(this.e), C20148rZ1.i(this.e), 0.0f, 0.0f, 12, null);
                    InterfaceC12243eH4 interfaceC12243eH4 = this.h;
                    boolean z = this.f;
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarB, InterfaceC12529em.a.l(), interfaceC22053ub1, 0);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarP);
                    InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                    M66 m66 = M66.a;
                    e.a aVar2 = androidx.compose.ui.e.a;
                    boolean zD = interfaceC22053ub1.D(interfaceC12243eH4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0813a(interfaceC12243eH4);
                        interfaceC22053ub1.s(objB);
                    }
                    AbstractC9367Zq.c(aVar2, (SA2) objB, z, interfaceC22053ub1, 6);
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(-836697680);
                    androidx.compose.ui.e eVar = this.g;
                    boolean zD2 = interfaceC22053ub1.D(this.h);
                    InterfaceC12243eH4 interfaceC12243eH42 = this.h;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0814b(interfaceC12243eH42);
                        interfaceC22053ub1.s(objB2);
                    }
                    AbstractC9367Zq.c(eVar, (SA2) objB2, this.f, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC18354oW7 interfaceC18354oW7, long j, boolean z, androidx.compose.ui.e eVar, InterfaceC12243eH4 interfaceC12243eH4) {
            super(2);
            this.e = interfaceC18354oW7;
            this.f = j;
            this.g = z;
            this.h = eVar;
            this.i = interfaceC12243eH4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1365123137, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:85)");
            }
            AbstractC11024cc1.a(AbstractC13040fc1.u().d(this.e), AbstractC19242q11.e(1260045569, true, new a(this.f, this.g, this.h, this.i), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zq$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC12243eH4 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ AW5 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ long i;
        final /* synthetic */ float j;
        final /* synthetic */ androidx.compose.ui.e k;
        final /* synthetic */ int l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC12243eH4 interfaceC12243eH4, boolean z, AW5 aw5, boolean z2, long j, float f, androidx.compose.ui.e eVar, int i, int i2) {
            super(2);
            this.e = interfaceC12243eH4;
            this.f = z;
            this.g = aw5;
            this.h = z2;
            this.i = j;
            this.j = f;
            this.k = eVar;
            this.l = i;
            this.m = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC9367Zq.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC22053ub1, QJ5.a(this.l | 1), this.m);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zq$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC12243eH4 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC12243eH4 interfaceC12243eH4, boolean z, boolean z2) {
            super(1);
            this.e = interfaceC12243eH4;
            this.f = z;
            this.g = z2;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            long jA = this.e.a();
            interfaceC11943do6.f(AbstractC3832Cn6.d(), new C3598Bn6(this.f ? EnumC10942cT2.b : EnumC10942cT2.c, jA, this.g ? EnumC3359An6.a : EnumC3359An6.c, (9223372034707292159L & jA) != 9205357640488583168L, null));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zq$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ boolean g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(androidx.compose.ui.e eVar, SA2 sa2, boolean z, int i) {
            super(2);
            this.e = eVar;
            this.f = sa2;
            this.g = z;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC9367Zq.c(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zq$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ boolean f;

        /* renamed from: ir.nasim.Zq$f$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ long e;
            final /* synthetic */ SA2 f;
            final /* synthetic */ boolean g;

            /* renamed from: ir.nasim.Zq$f$a$a, reason: collision with other inner class name */
            static final class C0815a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ SA2 e;
                final /* synthetic */ boolean f;
                final /* synthetic */ Y03 g;
                final /* synthetic */ AbstractC24975zX0 h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0815a(SA2 sa2, boolean z, Y03 y03, AbstractC24975zX0 abstractC24975zX0) {
                    super(1);
                    this.e = sa2;
                    this.f = z;
                    this.g = y03;
                    this.h = abstractC24975zX0;
                }

                public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
                    interfaceC23919xk1.N1();
                    if (((Boolean) this.e.invoke()).booleanValue()) {
                        if (!this.f) {
                            InterfaceC17460n02.r1(interfaceC23919xk1, this.g, 0L, 0.0f, null, this.h, 0, 46, null);
                            return;
                        }
                        Y03 y03 = this.g;
                        AbstractC24975zX0 abstractC24975zX0 = this.h;
                        long jE1 = interfaceC23919xk1.E1();
                        YZ1 yz1Z1 = interfaceC23919xk1.z1();
                        long jD = yz1Z1.d();
                        yz1Z1.e().n();
                        try {
                            yz1Z1.b().f(-1.0f, 1.0f, jE1);
                            InterfaceC17460n02.r1(interfaceC23919xk1, y03, 0L, 0.0f, null, abstractC24975zX0, 0, 46, null);
                        } finally {
                            yz1Z1.e().i();
                            yz1Z1.g(jD);
                        }
                    }
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((InterfaceC23919xk1) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j, SA2 sa2, boolean z) {
                super(1);
                this.e = j;
                this.f = sa2;
                this.g = z;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C16869m02 invoke(C14988ip0 c14988ip0) {
                return c14988ip0.h(new C0815a(this.f, this.g, AbstractC9367Zq.d(c14988ip0, Float.intBitsToFloat((int) (c14988ip0.d() >> 32)) / 2.0f), AbstractC24975zX0.a.b(AbstractC24975zX0.b, this.e, 0, 2, null)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(SA2 sa2, boolean z) {
            super(3);
            this.e = sa2;
            this.f = z;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-196777734);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-196777734, i, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:133)");
            }
            long jB = ((C6426Nn7) interfaceC22053ub1.H(AbstractC6686On7.b())).b();
            boolean zF = interfaceC22053ub1.f(jB) | interfaceC22053ub1.V(this.e) | interfaceC22053ub1.a(this.f);
            SA2 sa2 = this.e;
            boolean z = this.f;
            Object objB = interfaceC22053ub1.B();
            if (zF || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(jB, sa2, z);
                interfaceC22053ub1.s(objB);
            }
            androidx.compose.ui.e eVarC = androidx.compose.ui.draw.b.c(eVar, (UA2) objB);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarC;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final void a(InterfaceC12243eH4 interfaceC12243eH4, InterfaceC12529em interfaceC12529em, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(476043083);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(interfaceC12243eH4) : interfaceC22053ub1J.D(interfaceC12243eH4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(interfaceC12529em) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        boolean z = false;
        if (interfaceC22053ub1J.o((i2 & 147) != 146, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(476043083, i2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:223)");
            }
            boolean z2 = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && interfaceC22053ub1J.V(interfaceC12243eH4))) {
                z = true;
            }
            boolean z3 = z2 | z;
            Object objB = interfaceC22053ub1J.B();
            if (z3 || objB == InterfaceC22053ub1.a.a()) {
                objB = new C15367jT2(interfaceC12529em, interfaceC12243eH4);
                interfaceC22053ub1J.s(objB);
            }
            AbstractC6456Nq.a((C15367jT2) objB, null, new C7117Qi5(false, false, false, null, true, false, 15, null), interfaceC14603iB2, interfaceC22053ub1J, ((i2 << 3) & 7168) | 384, 2);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(interfaceC12243eH4, interfaceC12529em, interfaceC14603iB2, i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ir.nasim.InterfaceC12243eH4 r20, boolean r21, ir.nasim.AW5 r22, boolean r23, long r24, float r26, androidx.compose.ui.e r27, ir.nasim.InterfaceC22053ub1 r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9367Zq.b(ir.nasim.eH4, boolean, ir.nasim.AW5, boolean, long, float, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    public static final void c(androidx.compose.ui.e eVar, SA2 sa2, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2111672474);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        if (interfaceC22053ub1J.o((i2 & 147) != 146, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(2111672474, i2, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:127)");
            }
            ZH6.a(e(androidx.compose.foundation.layout.t.v(eVar, AbstractC3832Cn6.c(), AbstractC3832Cn6.b()), sa2, z), interfaceC22053ub1J, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new e(eVar, sa2, z, i));
        }
    }

    public static final Y03 d(C14988ip0 c14988ip0, float f2) {
        int iCeil = ((int) Math.ceil(f2)) * 2;
        C12958fT2 c12958fT2 = C12958fT2.a;
        Y03 y03C = c12958fT2.c();
        UE0 ue0A = c12958fT2.a();
        C20576sF0 c20576sF0B = c12958fT2.b();
        if (y03C == null || ue0A == null || iCeil > y03C.getWidth() || iCeil > y03C.getHeight()) {
            y03C = AbstractC9472a13.b(iCeil, iCeil, Z03.b.a(), false, null, 24, null);
            c12958fT2.f(y03C);
            ue0A = AbstractC23039wF0.a(y03C);
            c12958fT2.d(ue0A);
        }
        Y03 y03 = y03C;
        UE0 ue0 = ue0A;
        if (c20576sF0B == null) {
            c20576sF0B = new C20576sF0();
            c12958fT2.e(c20576sF0B);
        }
        C20576sF0 c20576sF0 = c20576sF0B;
        EnumC12613eu3 layoutDirection = c14988ip0.getLayoutDirection();
        float width = y03.getWidth();
        float height = y03.getHeight();
        long jD = OD6.d((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32));
        C20576sF0.a aVarE = c20576sF0.E();
        WH1 wh1A = aVarE.a();
        EnumC12613eu3 enumC12613eu3B = aVarE.b();
        UE0 ue0C = aVarE.c();
        long jD2 = aVarE.d();
        C20576sF0.a aVarE2 = c20576sF0.E();
        aVarE2.j(c14988ip0);
        aVarE2.k(layoutDirection);
        aVarE2.i(ue0);
        aVarE2.l(jD);
        ue0.n();
        InterfaceC17460n02.C1(c20576sF0, C24381yX0.b.a(), 0L, c20576sF0.d(), 0.0f, null, null, AbstractC7094Qg0.a.a(), 58, null);
        InterfaceC17460n02.C1(c20576sF0, DX0.d(4278190080L), ZG4.b.c(), OD6.d((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
        InterfaceC17460n02.L(c20576sF0, DX0.d(4278190080L), f2, ZG4.e((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32)), 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
        ue0.i();
        C20576sF0.a aVarE3 = c20576sF0.E();
        aVarE3.j(wh1A);
        aVarE3.k(enumC12613eu3B);
        aVarE3.i(ue0C);
        aVarE3.l(jD2);
        return y03;
    }

    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar, SA2 sa2, boolean z) {
        return androidx.compose.ui.c.c(eVar, null, new f(sa2, z), 1, null);
    }
}
