package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Mo, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6188Mo {
    private static final float a;
    private static final float b;

    /* renamed from: ir.nasim.Mo$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ long e;
        final /* synthetic */ androidx.compose.ui.e f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, androidx.compose.ui.e eVar) {
            super(2);
            this.e = j;
            this.f = eVar;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1653527038, i, -1, "androidx.compose.foundation.text.CursorHandle.<anonymous> (AndroidCursorHandle.android.kt:63)");
            }
            if (this.e != 9205357640488583168L) {
                interfaceC22053ub1.W(1828931592);
                androidx.compose.ui.e eVarP = androidx.compose.foundation.layout.t.p(this.f, C20148rZ1.j(this.e), C20148rZ1.i(this.e), 0.0f, 0.0f, 12, null);
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.m(), false);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                AbstractC6188Mo.b(null, interfaceC22053ub1, 0, 1);
                interfaceC22053ub1.u();
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1829298756);
                AbstractC6188Mo.b(this.f, interfaceC22053ub1, 0, 0);
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

    /* renamed from: ir.nasim.Mo$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC12243eH4 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ long g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC12243eH4 interfaceC12243eH4, androidx.compose.ui.e eVar, long j, int i, int i2) {
            super(2);
            this.e = interfaceC12243eH4;
            this.f = eVar;
            this.g = j;
            this.h = i;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6188Mo.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1), this.i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mo$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC12243eH4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC12243eH4 interfaceC12243eH4) {
            super(1);
            this.e = interfaceC12243eH4;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            interfaceC11943do6.f(AbstractC3832Cn6.d(), new C3598Bn6(EnumC10942cT2.a, this.e.a(), EnumC3359An6.b, true, null));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mo$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(androidx.compose.ui.e eVar, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = i;
            this.g = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6188Mo.b(this.e, interfaceC22053ub1, QJ5.a(this.f | 1), this.g);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mo$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final e e = new e();

        /* renamed from: ir.nasim.Mo$e$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ long e;

            /* renamed from: ir.nasim.Mo$e$a$a, reason: collision with other inner class name */
            static final class C0508a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ float e;
                final /* synthetic */ Y03 f;
                final /* synthetic */ AbstractC24975zX0 g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0508a(float f, Y03 y03, AbstractC24975zX0 abstractC24975zX0) {
                    super(1);
                    this.e = f;
                    this.f = y03;
                    this.g = abstractC24975zX0;
                }

                public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
                    interfaceC23919xk1.N1();
                    float f = this.e;
                    Y03 y03 = this.f;
                    AbstractC24975zX0 abstractC24975zX0 = this.g;
                    YZ1 yz1Z1 = interfaceC23919xk1.z1();
                    long jD = yz1Z1.d();
                    yz1Z1.e().n();
                    try {
                        InterfaceC19824r02 interfaceC19824r02B = yz1Z1.b();
                        InterfaceC19824r02.i(interfaceC19824r02B, f, 0.0f, 2, null);
                        interfaceC19824r02B.g(45.0f, ZG4.b.c());
                        InterfaceC17460n02.r1(interfaceC23919xk1, y03, 0L, 0.0f, null, abstractC24975zX0, 0, 46, null);
                    } finally {
                        yz1Z1.e().i();
                        yz1Z1.g(jD);
                    }
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((InterfaceC23919xk1) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j) {
                super(1);
                this.e = j;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C16869m02 invoke(C14988ip0 c14988ip0) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (c14988ip0.d() >> 32)) / 2.0f;
                return c14988ip0.h(new C0508a(fIntBitsToFloat, AbstractC9367Zq.d(c14988ip0, fIntBitsToFloat), AbstractC24975zX0.a.b(AbstractC24975zX0.b, this.e, 0, 2, null)));
            }
        }

        e() {
            super(3);
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-2126899193);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-2126899193, i, -1, "androidx.compose.foundation.text.drawCursorHandle.<anonymous> (AndroidCursorHandle.android.kt:87)");
            }
            long jB = ((C6426Nn7) interfaceC22053ub1.H(AbstractC6686On7.b())).b();
            e.a aVar = androidx.compose.ui.e.a;
            boolean zF = interfaceC22053ub1.f(jB);
            Object objB = interfaceC22053ub1.B();
            if (zF || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(jB);
                interfaceC22053ub1.s(objB);
            }
            androidx.compose.ui.e eVarI = eVar.i(androidx.compose.ui.draw.b.c(aVar, (UA2) objB));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarI;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    static {
        float fQ = C17784nZ1.q(25);
        a = fQ;
        b = C17784nZ1.q(C17784nZ1.q(fQ * 2.0f) / 2.4142137f);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.InterfaceC12243eH4 r8, androidx.compose.ui.e r9, long r10, ir.nasim.InterfaceC22053ub1 r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6188Mo.a(ir.nasim.eH4, androidx.compose.ui.e, long, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(694251107);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (interfaceC22053ub1J.o((i3 & 3) != 2, i3 & 1)) {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(694251107, i3, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:82)");
            }
            ZH6.a(d(androidx.compose.foundation.layout.t.v(eVar, b, a)), interfaceC22053ub1J, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new d(eVar, i, i2));
        }
    }

    private static final androidx.compose.ui.e d(androidx.compose.ui.e eVar) {
        return androidx.compose.ui.c.c(eVar, null, e.e, 1, null);
    }
}
