package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.AbstractC18884pQ0;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.pQ0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC18884pQ0 {

    /* renamed from: ir.nasim.pQ0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ InterfaceC20600sH6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, InterfaceC20600sH6 interfaceC20600sH6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = interfaceC20600sH6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c) {
                InterfaceC20600sH6 interfaceC20600sH6 = this.d;
                if (interfaceC20600sH6 != null) {
                    interfaceC20600sH6.a();
                }
            } else {
                InterfaceC20600sH6 interfaceC20600sH62 = this.d;
                if (interfaceC20600sH62 != null) {
                    interfaceC20600sH62.b();
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pQ0$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C25068zg6 a;
        final /* synthetic */ InterfaceC6344Ne6 b;
        final /* synthetic */ InterfaceC9102Ym4 c;
        final /* synthetic */ String d;
        final /* synthetic */ boolean e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ String g;

        /* renamed from: ir.nasim.pQ0$b$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC6344Ne6 a;
            final /* synthetic */ C25068zg6 b;

            a(InterfaceC6344Ne6 interfaceC6344Ne6, C25068zg6 c25068zg6) {
                this.a = interfaceC6344Ne6;
                this.b = c25068zg6;
            }

            public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                AbstractC14785iU0.e(null, AbstractC15208jB5.calendar, true, "", 0.0f, 0.0f, 0L, AbstractC17343mo2.a(this.b.e(), interfaceC22053ub1, 0), this.a.e(), interfaceC22053ub1, 3456, 113);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pQ0$b$b, reason: collision with other inner class name */
        static final class C1446b implements InterfaceC15796kB2 {
            final /* synthetic */ C25068zg6 a;
            final /* synthetic */ InterfaceC6344Ne6 b;

            C1446b(C25068zg6 c25068zg6, InterfaceC6344Ne6 interfaceC6344Ne6) {
                this.a = c25068zg6;
                this.b = interfaceC6344Ne6;
            }

            public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                AbstractC14785iU0.e(null, this.a.g() == EnumC16752lo2.c ? AbstractC15208jB5.bold_profile : AbstractC15208jB5.profile, true, "", 0.0f, 0.0f, 0L, AbstractC17343mo2.a(this.a.g(), interfaceC22053ub1, 0), this.b.b(), interfaceC22053ub1, 3456, 113);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pQ0$b$c */
        static final class c implements InterfaceC14603iB2 {
            final /* synthetic */ C25068zg6 a;
            final /* synthetic */ InterfaceC9102Ym4 b;
            final /* synthetic */ L66 c;
            final /* synthetic */ InterfaceC6344Ne6 d;
            final /* synthetic */ String e;
            final /* synthetic */ boolean f;
            final /* synthetic */ InterfaceC9102Ym4 g;
            final /* synthetic */ String h;

            /* renamed from: ir.nasim.pQ0$b$c$a */
            public /* synthetic */ class a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC21528th6.values().length];
                    try {
                        iArr[EnumC21528th6.c.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC21528th6.b.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    a = iArr;
                }
            }

            c(C25068zg6 c25068zg6, InterfaceC9102Ym4 interfaceC9102Ym4, L66 l66, InterfaceC6344Ne6 interfaceC6344Ne6, String str, boolean z, InterfaceC9102Ym4 interfaceC9102Ym42, String str2) {
                this.a = c25068zg6;
                this.b = interfaceC9102Ym4;
                this.c = l66;
                this.d = interfaceC6344Ne6;
                this.e = str;
                this.f = z;
                this.g = interfaceC9102Ym42;
                this.h = str2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(InterfaceC6344Ne6 interfaceC6344Ne6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC10566bp3 interfaceC10566bp3) {
                AbstractC13042fc3.i(interfaceC6344Ne6, "$searchBarActions");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$queryKeyword");
                AbstractC13042fc3.i(interfaceC10566bp3, "$this$KeyboardActions");
                interfaceC6344Ne6.c().invoke(interfaceC9102Ym4.getValue());
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC6344Ne6 interfaceC6344Ne6, String str) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$queryKeyword");
                AbstractC13042fc3.i(interfaceC6344Ne6, "$searchBarActions");
                AbstractC13042fc3.i(str, "newQuery");
                interfaceC9102Ym4.setValue(str);
                interfaceC6344Ne6.a().invoke();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC6344Ne6 interfaceC6344Ne6, String str) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$personSearchKeyword");
                AbstractC13042fc3.i(interfaceC6344Ne6, "$searchBarActions");
                AbstractC13042fc3.i(str, "newQuery");
                interfaceC9102Ym4.setValue(str);
                interfaceC6344Ne6.a().invoke();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(String str) {
                AbstractC13042fc3.i(str, "it");
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (this.a.o()) {
                    interfaceC22053ub1.W(-1494777845);
                    String str = (String) this.g.getValue();
                    androidx.compose.ui.e eVarB = L66.b(this.c, androidx.compose.ui.e.a, 0.5714286f, false, 2, null);
                    AbstractC17858ng6.a aVar = new AbstractC17858ng6.a(false, false, true, 3, null);
                    String str2 = this.h;
                    interfaceC22053ub1.W(-879497354);
                    boolean zV = interfaceC22053ub1.V(this.g) | interfaceC22053ub1.D(this.d);
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.g;
                    final InterfaceC6344Ne6 interfaceC6344Ne6 = this.d;
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.sQ0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC18884pQ0.b.c.k(interfaceC9102Ym4, interfaceC6344Ne6, (String) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    UA2 ua2 = (UA2) objB;
                    interfaceC22053ub1.Q();
                    boolean z = this.f;
                    interfaceC22053ub1.W(-879485901);
                    Object objB2 = interfaceC22053ub1.B();
                    if (objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new UA2() { // from class: ir.nasim.tQ0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC18884pQ0.b.c.n((String) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC16075kf6.j(str2, str, ua2, true, null, aVar, z, eVarB, (UA2) objB2, null, null, interfaceC22053ub1, (AbstractC17858ng6.a.e << 15) | 100666368, 0, 1552);
                    interfaceC22053ub1.Q();
                    return;
                }
                interfaceC22053ub1.W(-1496119463);
                String str3 = (String) this.b.getValue();
                androidx.compose.ui.e eVarB2 = L66.b(this.c, androidx.compose.ui.e.a, 0.5714286f, false, 2, null);
                UA2 ua2C = this.d.c();
                int i2 = a.a[this.a.l().ordinal()];
                AbstractC17858ng6 aVar2 = i2 != 1 ? i2 != 2 ? AbstractC17858ng6.b.b : new AbstractC17858ng6.a(false, false, true, 3, null) : new AbstractC17858ng6.a(false, true, false, 5, null);
                C21605tp3 c21605tp3C = C21605tp3.c(C21605tp3.g.a(), 0, null, 0, S33.b.g(), null, null, null, 119, null);
                interfaceC22053ub1.W(-879509399);
                boolean zD = interfaceC22053ub1.D(this.d) | interfaceC22053ub1.V(this.b);
                final InterfaceC6344Ne6 interfaceC6344Ne62 = this.d;
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.b;
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.qQ0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18884pQ0.b.c.h(interfaceC6344Ne62, interfaceC9102Ym42, (InterfaceC10566bp3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                C11329cp3 c11329cp3 = new C11329cp3(null, null, null, null, (UA2) objB3, null, 47, null);
                String str4 = this.e;
                interfaceC22053ub1.W(-879541937);
                boolean zV2 = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(this.d);
                final InterfaceC9102Ym4 interfaceC9102Ym43 = this.b;
                final InterfaceC6344Ne6 interfaceC6344Ne63 = this.d;
                Object objB4 = interfaceC22053ub1.B();
                if (zV2 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new UA2() { // from class: ir.nasim.rQ0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18884pQ0.b.c.i(interfaceC9102Ym43, interfaceC6344Ne63, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC16075kf6.j(str4, str3, (UA2) objB4, true, null, aVar2, this.f, eVarB2, ua2C, c21605tp3C, c11329cp3, interfaceC22053ub1, (AbstractC17858ng6.a << 15) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0, 16);
                interfaceC22053ub1.Q();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(C25068zg6 c25068zg6, InterfaceC6344Ne6 interfaceC6344Ne6, InterfaceC9102Ym4 interfaceC9102Ym4, String str, boolean z, InterfaceC9102Ym4 interfaceC9102Ym42, String str2) {
            this.a = c25068zg6;
            this.b = interfaceC6344Ne6;
            this.c = interfaceC9102Ym4;
            this.d = str;
            this.e = z;
            this.f = interfaceC9102Ym42;
            this.g = str2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(7)), 0.0f, 1, null);
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            C25068zg6 c25068zg6 = this.a;
            InterfaceC6344Ne6 interfaceC6344Ne6 = this.b;
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            String str = this.d;
            boolean z = this.e;
            InterfaceC9102Ym4 interfaceC9102Ym42 = this.f;
            String str2 = this.g;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), cVarI, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
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
            EnumC16752lo2 enumC16752lo2E = c25068zg6.e();
            EnumC16752lo2 enumC16752lo2 = EnumC16752lo2.a;
            AbstractC22231ut.e(m66, enumC16752lo2E != enumC16752lo2, null, null, null, null, AbstractC19242q11.e(-1142077179, true, new a(interfaceC6344Ne6, c25068zg6), interfaceC22053ub1, 54), interfaceC22053ub1, 1572870, 30);
            AbstractC22231ut.e(m66, c25068zg6.g() != enumC16752lo2, null, null, null, null, AbstractC19242q11.e(-1370145028, true, new C1446b(c25068zg6, interfaceC6344Ne6), interfaceC22053ub1, 54), interfaceC22053ub1, 1572870, 30);
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(AbstractC18884pQ0.g(interfaceC22053ub1, 0) ? EnumC12613eu3.b : EnumC12613eu3.a), AbstractC19242q11.e(-1510637843, true, new c(c25068zg6, interfaceC9102Ym4, m66, interfaceC6344Ne6, str, z, interfaceC9102Ym42, str2), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            AbstractC14785iU0.e(null, AbstractC15208jB5.back_grey_vd, false, "", 0.0f, C17784nZ1.q(16), 0L, G10.a.a(interfaceC22053ub1, G10.b).G(), interfaceC6344Ne6.d(), interfaceC22053ub1, 199680, 85);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pQ0$c */
    public static final class c implements InterfaceC6344Ne6 {
        private final SA2 a = new SA2() { // from class: ir.nasim.uQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC18884pQ0.c.l();
            }
        };
        private final SA2 b = new SA2() { // from class: ir.nasim.vQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC18884pQ0.c.m();
            }
        };
        private final SA2 c = new SA2() { // from class: ir.nasim.wQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC18884pQ0.c.k();
            }
        };
        private final UA2 d = new UA2() { // from class: ir.nasim.xQ0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC18884pQ0.c.o((String) obj);
            }
        };
        private final SA2 e = new SA2() { // from class: ir.nasim.yQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC18884pQ0.c.n();
            }
        };

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 l() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 m() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(String str) {
            AbstractC13042fc3.i(str, "it");
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC6344Ne6
        public SA2 a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC6344Ne6
        public SA2 b() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC6344Ne6
        public UA2 c() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC6344Ne6
        public SA2 d() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC6344Ne6
        public SA2 e() {
            return this.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(java.lang.String r18, java.lang.String r19, final ir.nasim.InterfaceC9102Ym4 r20, final ir.nasim.InterfaceC9102Ym4 r21, boolean r22, final ir.nasim.InterfaceC6344Ne6 r23, final ir.nasim.C25068zg6 r24, ir.nasim.InterfaceC22053ub1 r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18884pQ0.c(java.lang.String, java.lang.String, ir.nasim.Ym4, ir.nasim.Ym4, boolean, ir.nasim.Ne6, ir.nasim.zg6, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(String str, String str2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, boolean z, InterfaceC6344Ne6 interfaceC6344Ne6, C25068zg6 c25068zg6, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$queryKeyword");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$personSearchKeyword");
        AbstractC13042fc3.i(interfaceC6344Ne6, "$searchBarActions");
        AbstractC13042fc3.i(c25068zg6, "$searchMessageUiState");
        c(str, str2, interfaceC9102Ym4, interfaceC9102Ym42, z, interfaceC6344Ne6, c25068zg6, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-479273475);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-579416301);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d("", null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-579414317);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d("", null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            c("Search", "Search Members", interfaceC9102Ym4, (InterfaceC9102Ym4) objB2, true, new c(), new C25068zg6(0L, null, null, null, null, null, null, 0, null, 0, 0, null, false, 8191, null), interfaceC22053ub1J, 28086, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.nQ0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18884pQ0.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final boolean g(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(1061295722);
        String language = ((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).getResources().getConfiguration().getLocales().get(0).getLanguage();
        AbstractC13042fc3.h(language, "getLanguage(...)");
        boolean zV = AbstractC20762sZ6.V("fa, ks, ar", language, true);
        interfaceC22053ub1.Q();
        return zV;
    }
}
