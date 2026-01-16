package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC16194kr5;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC4335Er5;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.kr5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC16194kr5 {
    private static final f a = new f();
    private static final g b = new g();
    private static final e c = new e();

    /* renamed from: ir.nasim.kr5$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC4335Er5.a a;
        final /* synthetic */ InterfaceC13136fj0 b;

        a(InterfaceC4335Er5.a aVar, InterfaceC13136fj0 interfaceC13136fj0) {
            this.a = aVar;
            this.b = interfaceC13136fj0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC13136fj0 interfaceC13136fj0, InterfaceC4335Er5.a aVar) {
            AbstractC13042fc3.i(interfaceC13136fj0, "$uiAction");
            AbstractC13042fc3.i(aVar, "$uiMode");
            interfaceC13136fj0.b().invoke(aVar.e());
            return C19938rB7.a;
        }

        public final void b(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$PrivacyBarContainer");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C19705qo0 c19705qo0B = this.a.b();
            C19705qo0 c19705qo0C = this.a.c();
            C19705qo0 c19705qo0A = this.a.a();
            SA2 sa2C = this.b.c();
            interfaceC22053ub1.W(1914159414);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
            final InterfaceC13136fj0 interfaceC13136fj0 = this.b;
            final InterfaceC4335Er5.a aVar = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.jr5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16194kr5.a.c(interfaceC13136fj0, aVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16194kr5.s(c19705qo0B, c19705qo0C, c19705qo0A, sa2C, (SA2) objB, null, interfaceC22053ub1, 0, 32);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kr5$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC4335Er5.b a;
        final /* synthetic */ HM2 b;

        b(InterfaceC4335Er5.b bVar, HM2 hm2) {
            this.a = bVar;
            this.b = hm2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(HM2 hm2) {
            AbstractC13042fc3.i(hm2, "$uiAction");
            hm2.b().invoke(ZN2.CHANNEL);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(HM2 hm2) {
            AbstractC13042fc3.i(hm2, "$uiAction");
            hm2.d().invoke(ZN2.CHANNEL);
            return C19938rB7.a;
        }

        public final void c(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$PrivacyBarContainer");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C19705qo0 c19705qo0B = this.a.b();
            C19705qo0 c19705qo0C = this.a.c();
            C19705qo0 c19705qo0A = this.a.a();
            SA2 sa2C = this.b.c();
            interfaceC22053ub1.W(2066712148);
            boolean zD = interfaceC22053ub1.D(this.b);
            final HM2 hm2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.lr5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16194kr5.b.d(hm2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(2066714939);
            boolean zD2 = interfaceC22053ub1.D(this.b);
            final HM2 hm22 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.mr5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16194kr5.b.f(hm22);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC16194kr5.s(c19705qo0B, c19705qo0C, c19705qo0A, sa2C, sa2, (SA2) objB2, interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kr5$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC4335Er5.c a;
        final /* synthetic */ HM2 b;

        c(InterfaceC4335Er5.c cVar, HM2 hm2) {
            this.a = cVar;
            this.b = hm2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(HM2 hm2) {
            AbstractC13042fc3.i(hm2, "$uiAction");
            hm2.b().invoke(ZN2.GROUP);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(HM2 hm2) {
            AbstractC13042fc3.i(hm2, "$uiAction");
            hm2.d().invoke(ZN2.GROUP);
            return C19938rB7.a;
        }

        public final void c(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$PrivacyBarContainer");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C19705qo0 c19705qo0B = this.a.b();
            C19705qo0 c19705qo0C = this.a.c();
            C19705qo0 c19705qo0A = this.a.a();
            SA2 sa2C = this.b.c();
            interfaceC22053ub1.W(-887938706);
            boolean zD = interfaceC22053ub1.D(this.b);
            final HM2 hm2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.nr5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16194kr5.c.d(hm2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-887935979);
            boolean zD2 = interfaceC22053ub1.D(this.b);
            final HM2 hm22 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.or5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16194kr5.c.f(hm22);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC16194kr5.s(c19705qo0B, c19705qo0C, c19705qo0A, sa2C, sa2, (SA2) objB2, interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kr5$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC4335Er5.e a;
        final /* synthetic */ InterfaceC5520Jr5 b;

        d(InterfaceC4335Er5.e eVar, InterfaceC5520Jr5 interfaceC5520Jr5) {
            this.a = eVar;
            this.b = interfaceC5520Jr5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC5520Jr5 interfaceC5520Jr5, InterfaceC4335Er5.e eVar) {
            AbstractC13042fc3.i(interfaceC5520Jr5, "$uiAction");
            AbstractC13042fc3.i(eVar, "$uiMode");
            interfaceC5520Jr5.b().invoke(eVar.e());
            return C19938rB7.a;
        }

        public final void b(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$PrivacyBarContainer");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C19705qo0 c19705qo0B = this.a.b();
            C19705qo0 c19705qo0C = this.a.c();
            C19705qo0 c19705qo0A = this.a.a();
            SA2 sa2C = this.b.c();
            interfaceC22053ub1.W(-133014606);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
            final InterfaceC5520Jr5 interfaceC5520Jr5 = this.b;
            final InterfaceC4335Er5.e eVar = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.pr5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16194kr5.d.c(interfaceC5520Jr5, eVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16194kr5.s(c19705qo0B, c19705qo0C, c19705qo0A, sa2C, (SA2) objB, this.b.d(), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kr5$e */
    public static final class e implements InterfaceC13136fj0 {
        private final SA2 a = new SA2() { // from class: ir.nasim.qr5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC16194kr5.e.i();
            }
        };
        private final UA2 b = new UA2() { // from class: ir.nasim.rr5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC16194kr5.e.g((String) obj);
            }
        };
        private final SA2 c = new SA2() { // from class: ir.nasim.sr5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC16194kr5.e.h();
            }
        };

        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g(String str) {
            AbstractC13042fc3.i(str, "it");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i() {
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC13136fj0
        public SA2 a() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC13136fj0
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC13136fj0
        public SA2 c() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.kr5$f */
    public static final class f implements HM2 {
        private final SA2 a = new SA2() { // from class: ir.nasim.tr5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC16194kr5.f.i();
            }
        };
        private final UA2 b = new UA2() { // from class: ir.nasim.ur5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC16194kr5.f.l((ZN2) obj);
            }
        };
        private final UA2 c = new UA2() { // from class: ir.nasim.vr5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC16194kr5.f.k((ZN2) obj);
            }
        };
        private final SA2 d = new SA2() { // from class: ir.nasim.wr5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC16194kr5.f.j();
            }
        };

        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 j() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(ZN2 zn2) {
            AbstractC13042fc3.i(zn2, "it");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 l(ZN2 zn2) {
            AbstractC13042fc3.i(zn2, "it");
            return C19938rB7.a;
        }

        @Override // ir.nasim.HM2
        public SA2 a() {
            return this.d;
        }

        @Override // ir.nasim.HM2
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.HM2
        public SA2 c() {
            return this.a;
        }

        @Override // ir.nasim.HM2
        public UA2 d() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.kr5$g */
    public static final class g implements InterfaceC5520Jr5 {
        private final SA2 a = new SA2() { // from class: ir.nasim.xr5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC16194kr5.g.i();
            }
        };
        private final UA2 b = new UA2() { // from class: ir.nasim.yr5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC16194kr5.g.j((String) obj);
            }
        };
        private final SA2 c = new SA2() { // from class: ir.nasim.zr5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC16194kr5.g.k();
            }
        };
        private final SA2 d = new SA2() { // from class: ir.nasim.Ar5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC16194kr5.g.l();
            }
        };

        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 j(String str) {
            AbstractC13042fc3.i(str, "it");
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 l() {
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC5520Jr5
        public SA2 a() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC5520Jr5
        public UA2 b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC5520Jr5
        public SA2 c() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC5520Jr5
        public SA2 d() {
            return this.c;
        }
    }

    private static final void A(final InterfaceC4335Er5.b bVar, final HM2 hm2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-796366775);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(bVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(hm2) : interfaceC22053ub1J.D(hm2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            String strE = bVar.e();
            SA2 sa2A = hm2.a();
            interfaceC22053ub1J.W(2098390170);
            boolean zD = interfaceC22053ub1J.D(context) | interfaceC22053ub1J.D(bVar);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.cr5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16194kr5.B(context, bVar, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            N(strE, 3, sa2A, (UA2) objB, AbstractC19242q11.e(1035275104, true, new b(bVar, hm2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 24624);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.dr5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16194kr5.C(bVar, hm2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String B(Context context, InterfaceC4335Er5.b bVar, String str) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(bVar, "$uiMode");
        if (str == null || !(!AbstractC20762sZ6.n0(str))) {
            String string = context.getString(DD5.you_have_invited_to_channel);
            AbstractC13042fc3.f(string);
            return string;
        }
        String string2 = context.getString(bVar.d().intValue(), str);
        AbstractC13042fc3.f(string2);
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(InterfaceC4335Er5.b bVar, HM2 hm2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(bVar, "$uiMode");
        AbstractC13042fc3.i(hm2, "$uiAction");
        A(bVar, hm2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void D(final InterfaceC4335Er5.c cVar, final HM2 hm2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2058508351);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(cVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(hm2) : interfaceC22053ub1J.D(hm2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            String strE = cVar.e();
            SA2 sa2A = hm2.a();
            interfaceC22053ub1J.W(-697353740);
            boolean zD = interfaceC22053ub1J.D(context) | interfaceC22053ub1J.D(cVar);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.ir5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16194kr5.E(context, cVar, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            N(strE, 3, sa2A, (UA2) objB, AbstractC19242q11.e(-1283625384, true, new c(cVar, hm2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 24624);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Sq5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16194kr5.F(cVar, hm2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String E(Context context, InterfaceC4335Er5.c cVar, String str) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(cVar, "$uiMode");
        if (str == null || !(!AbstractC20762sZ6.n0(str))) {
            String string = context.getString(DD5.you_have_invited_to_group);
            AbstractC13042fc3.f(string);
            return string;
        }
        String string2 = context.getString(cVar.d().intValue(), str);
        AbstractC13042fc3.f(string2);
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(InterfaceC4335Er5.c cVar, HM2 hm2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(cVar, "$uiMode");
        AbstractC13042fc3.i(hm2, "$uiAction");
        D(cVar, hm2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void G(final java.lang.String r64, androidx.compose.ui.e r65, int r66, final ir.nasim.UA2 r67, ir.nasim.InterfaceC22053ub1 r68, final int r69, final int r70) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16194kr5.G(java.lang.String, androidx.compose.ui.e, int, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    private static final String H(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    private static final void I(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J(String str, int i, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, C13774gn7 c13774gn7) {
        AbstractC13042fc3.i(ua2, "$getFormattedString");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$title$delegate");
        AbstractC13042fc3.i(c13774gn7, "textLayoutResult");
        if (str == null) {
            return C19938rB7.a;
        }
        if (c13774gn7.i() && i == 1) {
            int iO = c13774gn7.o(0, true) - 3;
            int length = str.length() - (H(interfaceC9102Ym4).length() - iO);
            if (length > 4) {
                String strSubstring = str.substring(0, length);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                I(interfaceC9102Ym4, (String) ua2.invoke(strSubstring + "..."));
            } else {
                C19406qI3.a("NewChatPrivacyBar", "EllipsisIndex is greater to large, titleSize: " + H(interfaceC9102Ym4).length() + ", endOffset: " + iO, new Object[0]);
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(String str, androidx.compose.ui.e eVar, int i, UA2 ua2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(ua2, "$getFormattedString");
        G(str, eVar, i, ua2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void L(final InterfaceC4335Er5 interfaceC4335Er5, final HM2 hm2, final InterfaceC5520Jr5 interfaceC5520Jr5, final InterfaceC13136fj0 interfaceC13136fj0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(hm2, "groupUiAction");
        AbstractC13042fc3.i(interfaceC5520Jr5, "privateUIAction");
        AbstractC13042fc3.i(interfaceC13136fj0, "botUIAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1612948005);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(interfaceC4335Er5) : interfaceC22053ub1J.D(interfaceC4335Er5) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(hm2) : interfaceC22053ub1J.D(hm2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? interfaceC22053ub1J.V(interfaceC5520Jr5) : interfaceC22053ub1J.D(interfaceC5520Jr5) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= (i & 4096) == 0 ? interfaceC22053ub1J.V(interfaceC13136fj0) : interfaceC22053ub1J.D(interfaceC13136fj0) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (interfaceC4335Er5 instanceof InterfaceC4335Er5.b) {
            interfaceC22053ub1J.W(1200551855);
            A((InterfaceC4335Er5.b) interfaceC4335Er5, hm2, interfaceC22053ub1J, i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1J.Q();
        } else if (interfaceC4335Er5 instanceof InterfaceC4335Er5.c) {
            interfaceC22053ub1J.W(1200555021);
            D((InterfaceC4335Er5.c) interfaceC4335Er5, hm2, interfaceC22053ub1J, i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1J.Q();
        } else if (interfaceC4335Er5 instanceof InterfaceC4335Er5.e) {
            interfaceC22053ub1J.W(1200558228);
            T((InterfaceC4335Er5.e) interfaceC4335Er5, interfaceC5520Jr5, interfaceC22053ub1J, (i2 >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1J.Q();
        } else if (interfaceC4335Er5 instanceof InterfaceC4335Er5.a) {
            interfaceC22053ub1J.W(1200562508);
            x((InterfaceC4335Er5.a) interfaceC4335Er5, interfaceC13136fj0, interfaceC22053ub1J, (i2 >> 6) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1J.Q();
        } else if (AbstractC13042fc3.d(interfaceC4335Er5, InterfaceC4335Er5.d.a)) {
            interfaceC22053ub1J.W(-1437146642);
            interfaceC22053ub1J.Q();
        } else if (AbstractC13042fc3.d(interfaceC4335Er5, InterfaceC4335Er5.f.a)) {
            interfaceC22053ub1J.W(-1437103986);
            interfaceC22053ub1J.Q();
        } else {
            if (interfaceC4335Er5 != null) {
                interfaceC22053ub1J.W(1200550635);
                interfaceC22053ub1J.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1J.W(1200568578);
            interfaceC22053ub1J.Q();
            C19406qI3.a("NewChatPrivacyBar", "PrivacyBarUI mode is NULL!", new Object[0]);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.br5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16194kr5.M(interfaceC4335Er5, hm2, interfaceC5520Jr5, interfaceC13136fj0, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(InterfaceC4335Er5 interfaceC4335Er5, HM2 hm2, InterfaceC5520Jr5 interfaceC5520Jr5, InterfaceC13136fj0 interfaceC13136fj0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(hm2, "$groupUiAction");
        AbstractC13042fc3.i(interfaceC5520Jr5, "$privateUIAction");
        AbstractC13042fc3.i(interfaceC13136fj0, "$botUIAction");
        L(interfaceC4335Er5, hm2, interfaceC5520Jr5, interfaceC13136fj0, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void N(final String str, final int i, final SA2 sa2, final UA2 ua2, final InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2128676179);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 16384 : 8192;
        }
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i4 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1J, i4).r(), null, 2, null);
            C24254yJ c24254yJ = C24254yJ.a;
            float fQ = C17784nZ1.q(0);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.q(fQ, aVar2.i()), aVar2.k(), interfaceC22053ub1J, 6);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.e(), aVar2.l(), interfaceC22053ub1J, 54);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH2);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            G(str, androidx.compose.foundation.layout.q.m(L66.b(M66.a, aVar, 1.0f, false, 2, null), g10.c(interfaceC22053ub1J, i4).b().c(), g10.c(interfaceC22053ub1J, i4).b().c(), g10.c(interfaceC22053ub1J, i4).b().r(), 0.0f, 8, null), i, ua2, interfaceC22053ub1J, (i3 & 14) | ((i3 << 3) & 896) | (i3 & 7168), 0);
            AbstractC20434s03.a(sa2, null, false, null, null, K81.a.a(), interfaceC22053ub1J, ((i3 >> 6) & 14) | 196608, 30);
            interfaceC22053ub1J.u();
            interfaceC15796kB2.q(c9784aZ0, interfaceC22053ub1J, Integer.valueOf(6 | ((i3 >> 9) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER)));
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Tq5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16194kr5.O(str, i, sa2, ua2, interfaceC15796kB2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O(String str, int i, SA2 sa2, UA2 ua2, InterfaceC15796kB2 interfaceC15796kB2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onDismissClicked");
        AbstractC13042fc3.i(ua2, "$getFormattedString");
        AbstractC13042fc3.i(interfaceC15796kB2, "$actionButtons");
        N(str, i, sa2, ua2, interfaceC15796kB2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void P(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1640303039);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            InterfaceC4335Er5.a aVar3 = new InterfaceC4335Er5.a("بازوی کالابرگ");
            g gVar = b;
            f fVar = a;
            e eVar = c;
            L(aVar3, fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.e("سعید درویش"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.c("سعید درویش"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.b("سعید درویش"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.e("این یک نام کاملا طولانی است که ما انتظار داریم در حالت نمایش کوتاه نمایش داده شود"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.c("این یک نام کاملا طولانی است که ما انتظار داریم در حالت نمایش کوتاه نمایش داده شود"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.b("این یک نام کاملا طولانی است که ما انتظار داریم در حالت نمایش کوتاه نمایش داده شود"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ar5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16194kr5.Q(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        P(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void R(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-577071850);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            InterfaceC4335Er5.a aVar3 = new InterfaceC4335Er5.a("OnCallBot");
            g gVar = b;
            f fVar = a;
            e eVar = c;
            L(aVar3, fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.e("Saeed Darvish"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.c("Saeed Darvish"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.b("Saeed Darvish"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.e("This is a long string that we expect to display in short mode"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.c("This is a long string that we expect to display in short mode"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            L(new InterfaceC4335Er5.b("This is a long string that we expect to display in short mode"), fVar, gVar, eVar, interfaceC22053ub1J, 3504);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Rq5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16194kr5.S(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        R(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void T(final InterfaceC4335Er5.e eVar, final InterfaceC5520Jr5 interfaceC5520Jr5, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-105774451);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(interfaceC5520Jr5) : interfaceC22053ub1J.D(interfaceC5520Jr5) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            String strE = eVar.e();
            SA2 sa2A = interfaceC5520Jr5.a();
            interfaceC22053ub1J.W(1418628903);
            boolean zD = interfaceC22053ub1J.D(context) | interfaceC22053ub1J.D(eVar);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.er5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16194kr5.U(context, eVar, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            N(strE, 1, sa2A, (UA2) objB, AbstractC19242q11.e(-834520092, true, new d(eVar, interfaceC5520Jr5), interfaceC22053ub1J, 54), interfaceC22053ub1J, 24624);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fr5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16194kr5.V(eVar, interfaceC5520Jr5, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String U(Context context, InterfaceC4335Er5.e eVar, String str) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(eVar, "$uiMode");
        String string = context.getString(eVar.d().intValue(), str);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V(InterfaceC4335Er5.e eVar, InterfaceC5520Jr5 interfaceC5520Jr5, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$uiMode");
        AbstractC13042fc3.i(interfaceC5520Jr5, "$uiAction");
        T(eVar, interfaceC5520Jr5, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a7  */
    /* JADX WARN: Type inference failed for: r7v10, types: [androidx.compose.ui.e] */
    /* JADX WARN: Type inference failed for: r8v16, types: [androidx.compose.ui.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void s(final ir.nasim.C19705qo0 r21, final ir.nasim.C19705qo0 r22, final ir.nasim.C19705qo0 r23, ir.nasim.SA2 r24, ir.nasim.SA2 r25, ir.nasim.SA2 r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16194kr5.s(ir.nasim.qo0, ir.nasim.qo0, ir.nasim.qo0, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(C19705qo0 c19705qo0, C19705qo0 c19705qo02, C19705qo0 c19705qo03, SA2 sa2, SA2 sa22, SA2 sa23, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        s(c19705qo0, c19705qo02, c19705qo03, sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final void x(final InterfaceC4335Er5.a aVar, final InterfaceC13136fj0 interfaceC13136fj0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1145779495);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(aVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(interfaceC13136fj0) : interfaceC22053ub1J.D(interfaceC13136fj0) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            String strE = aVar.e();
            SA2 sa2A = interfaceC13136fj0.a();
            interfaceC22053ub1J.W(1268513451);
            boolean zD = interfaceC22053ub1J.D(context) | interfaceC22053ub1J.D(aVar);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.gr5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16194kr5.y(context, aVar, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            N(strE, 2, sa2A, (UA2) objB, AbstractC19242q11.e(-1601761616, true, new a(aVar, interfaceC13136fj0), interfaceC22053ub1J, 54), interfaceC22053ub1J, 24624);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.hr5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16194kr5.z(aVar, interfaceC13136fj0, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y(Context context, InterfaceC4335Er5.a aVar, String str) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(aVar, "$uiMode");
        String string = context.getString(aVar.d().intValue(), str);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(InterfaceC4335Er5.a aVar, InterfaceC13136fj0 interfaceC13136fj0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(aVar, "$uiMode");
        AbstractC13042fc3.i(interfaceC13136fj0, "$uiAction");
        x(aVar, interfaceC13136fj0, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
