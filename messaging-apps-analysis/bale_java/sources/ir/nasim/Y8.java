package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.Y8;

/* loaded from: classes5.dex */
public abstract class Y8 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ String a;
        final /* synthetic */ C8588Wp4 b;

        /* renamed from: ir.nasim.Y8$a$a, reason: collision with other inner class name */
        static final class C0783a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;
            final /* synthetic */ C8588Wp4 b;

            C0783a(String str, C8588Wp4 c8588Wp4) {
                this.a = str;
                this.b = c8588Wp4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C8588Wp4 c8588Wp4) {
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                c8588Wp4.V();
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                String strC;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String str = this.a;
                if (str == null || str.length() == 0) {
                    interfaceC22053ub1.W(-1633155791);
                    strC = UY6.c(FD5.add_dialog, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(-1633062078);
                    strC = UY6.d(FD5.add_dialog_to, new Object[]{this.a}, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                }
                String str2 = strC;
                interfaceC22053ub1.W(2025535321);
                boolean zD = interfaceC22053ub1.D(this.b);
                final C8588Wp4 c8588Wp4 = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.X8
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return Y8.a.C0783a.c(c8588Wp4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC21639ts7.i(str2, null, (SA2) objB, null, null, null, null, interfaceC22053ub1, 0, 122);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(String str, C8588Wp4 c8588Wp4) {
            this.a = str;
            this.b = c8588Wp4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-1789096479, true, new C0783a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        b(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, E11.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9664aL6 a;
        final /* synthetic */ C19911r9 b;
        final /* synthetic */ C19391qG6 c;
        final /* synthetic */ C20996sx3 d;
        final /* synthetic */ d e;
        final /* synthetic */ C8588Wp4 f;
        final /* synthetic */ InterfaceC9664aL6 g;
        final /* synthetic */ InterfaceC9664aL6 h;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ C19391qG6 d;
            final /* synthetic */ Resources e;
            final /* synthetic */ C19911r9 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6, C19391qG6 c19391qG6, Resources resources, C19911r9 c19911r9, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9664aL6;
                this.d = c19391qG6;
                this.e = resources;
                this.f = c19911r9;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(C19911r9 c19911r9) {
                c19911r9.G1(null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    WF6 wf6K = Y8.k(this.c);
                    if (wf6K != null) {
                        C19391qG6 c19391qG6 = this.d;
                        Resources resources = this.e;
                        final C19911r9 c19911r9 = this.f;
                        AbstractC13042fc3.f(resources);
                        SA2 sa2 = new SA2() { // from class: ir.nasim.a9
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return Y8.c.a.y(c19911r9);
                            }
                        };
                        this.b = 1;
                        if (Y8.A(c19391qG6, wf6K, resources, sa2, this) == objE) {
                            return objE;
                        }
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC9664aL6 interfaceC9664aL6, C19911r9 c19911r9, C19391qG6 c19391qG6, C20996sx3 c20996sx3, d dVar, C8588Wp4 c8588Wp4, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63) {
            this.a = interfaceC9664aL6;
            this.b = c19911r9;
            this.c = c19391qG6;
            this.d = c20996sx3;
            this.e = dVar;
            this.f = c8588Wp4;
            this.g = interfaceC9664aL62;
            this.h = interfaceC9664aL63;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C8588Wp4 c8588Wp4) {
            AbstractC13042fc3.i(c8588Wp4, "$navController");
            c8588Wp4.V();
            return C19938rB7.a;
        }

        public final void b(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "padding");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Resources resources = ((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).getResources();
            WF6 wf6K = Y8.k(this.a);
            interfaceC22053ub1.W(1457319040);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(resources) | interfaceC22053ub1.D(this.b);
            InterfaceC9664aL6 interfaceC9664aL6 = this.a;
            C19391qG6 c19391qG6 = this.c;
            C19911r9 c19911r9 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                Object aVar = new a(interfaceC9664aL6, c19391qG6, resources, c19911r9, null);
                interfaceC22053ub1.s(aVar);
                objB = aVar;
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(wf6K, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            C20996sx3 c20996sx3 = this.d;
            d dVar = this.e;
            final C8588Wp4 c8588Wp4 = this.f;
            InterfaceC9664aL6 interfaceC9664aL62 = this.g;
            InterfaceC9664aL6 interfaceC9664aL63 = this.h;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null);
            String strI = Y8.i(interfaceC9664aL62);
            C8379Vs2 c8379Vs2J = Y8.j(interfaceC9664aL63);
            interfaceC22053ub1.W(2025572153);
            boolean zD = interfaceC22053ub1.D(c8588Wp4);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Z8
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Y8.c.c(c8588Wp4);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            Y8.m(eVarF, c20996sx3, c8379Vs2J, dVar, strI, null, (SA2) objB2, interfaceC22053ub1, (C20996sx3.f << 3) | 6, 32);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class d implements InterfaceC10142b9 {
        private final /* synthetic */ InterfaceC10142b9 a;

        d(C19911r9 c19911r9) {
            this.a = c19911r9.q1();
        }

        @Override // ir.nasim.InterfaceC10142b9
        public UA2 a() {
            return this.a.a();
        }

        @Override // ir.nasim.InterfaceC10142b9
        public InterfaceC14603iB2 b() {
            return this.a.b();
        }

        @Override // ir.nasim.InterfaceC10142b9
        public UA2 c() {
            return this.a.c();
        }

        @Override // ir.nasim.InterfaceC10142b9
        public UA2 d() {
            return this.a.d();
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC10142b9 c;
        final /* synthetic */ InterfaceC9664aL6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC10142b9 interfaceC10142b9, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC10142b9;
            this.d = interfaceC9664aL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (!Y8.s(this.d)) {
                this.c.c().invoke(new AbstractC17858ng6.a(false, false, false, 5, null));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ InterfaceC10142b9 b;

        f(C20996sx3 c20996sx3, InterfaceC10142b9 interfaceC10142b9) {
            this.a = c20996sx3;
            this.b = interfaceC10142b9;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) throws Resources.NotFoundException {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            RM1 rm1 = (RM1) this.a.f(i);
            if (rm1 == null) {
                return;
            }
            AbstractC10271bN1.i(rm1, null, null, 0.0f, 0.0f, 0.0f, this.b.b(), null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) throws Resources.NotFoundException {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return Y8.A(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object A(ir.nasim.C19391qG6 r9, ir.nasim.WF6 r10, android.content.res.Resources r11, ir.nasim.SA2 r12, ir.nasim.InterfaceC20295rm1 r13) throws android.content.res.Resources.NotFoundException {
        /*
            boolean r0 = r13 instanceof ir.nasim.Y8.g
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.Y8$g r0 = (ir.nasim.Y8.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.Y8$g r0 = new ir.nasim.Y8$g
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r9 = r6.a
            r12 = r9
            ir.nasim.SA2 r12 = (ir.nasim.SA2) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto L52
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            ir.nasim.AbstractC10685c16.b(r13)
            java.lang.String r10 = ir.nasim.AbstractC10829cG6.a(r10, r11)
            r6.a = r12
            r6.c = r2
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            r1 = r9
            r2 = r10
            java.lang.Object r9 = ir.nasim.C19391qG6.f(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 != r0) goto L52
            return r0
        L52:
            r12.invoke()
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Y8.A(ir.nasim.qG6, ir.nasim.WF6, android.content.res.Resources, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    private static final boolean B(int i, String str, AbstractC17858ng6 abstractC17858ng6) {
        return (i != 0 || str == null || str.length() == 0 || AbstractC13042fc3.d(abstractC17858ng6, new AbstractC17858ng6.a(false, true, false, 5, null))) ? false : true;
    }

    public static final void h(final C8588Wp4 c8588Wp4, final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c8588Wp4, "navController");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1699785701);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c8588Wp4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.navigation.d dVarB = c8588Wp4.B();
            interfaceC22053ub1J.W(1640774952);
            boolean zV = interfaceC22053ub1J.V(dVarB);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = c8588Wp4.z("root");
                interfaceC22053ub1J.s(objB);
            }
            androidx.navigation.d dVar = (androidx.navigation.d) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.A(-550968255);
            G.c cVarA = EV2.a(dVar, interfaceC22053ub1J, 8);
            interfaceC22053ub1J.A(564614654);
            VW7 vw7A = AbstractC10983cX7.a(C19911r9.class, dVar, null, cVarA, interfaceC22053ub1J, 4168, 0);
            interfaceC22053ub1J.U();
            interfaceC22053ub1J.U();
            C19911r9 c19911r9 = (C19911r9) vw7A;
            interfaceC22053ub1J.W(1640781659);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new C19391qG6();
                interfaceC22053ub1J.s(objB2);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB2;
            interfaceC22053ub1J.Q();
            C20996sx3 c20996sx3B = AbstractC21683tx3.b(c19911r9.y1(), null, interfaceC22053ub1J, 0, 1);
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(c19911r9.x1(), null, interfaceC22053ub1J, 0, 1);
            InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(c19911r9.v1(), null, interfaceC22053ub1J, 0, 1);
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(c19911r9.z1(), null, null, null, interfaceC22053ub1J, 0, 7);
            d dVar2 = new d(c19911r9);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1J, i3).r(), null, 2, null), AbstractC19242q11.e(436415137, true, new a(str, c8588Wp4), interfaceC22053ub1J, 54), null, AbstractC19242q11.e(854303839, true, new b(c19391qG6), interfaceC22053ub1J, 54), null, 0, g10.a(interfaceC22053ub1J, i3).r(), 0L, null, AbstractC19242q11.e(-2049217674, true, new c(interfaceC9664aL6C, c19911r9, c19391qG6, c20996sx3B, dVar2, c8588Wp4, interfaceC9664aL6B, interfaceC9664aL6B2), interfaceC22053ub1J, 54), interfaceC22053ub12, 805309488, 436);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.W8
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Y8.l(c8588Wp4, str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8379Vs2 j(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C8379Vs2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WF6 k(InterfaceC9664aL6 interfaceC9664aL6) {
        return (WF6) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(C8588Wp4 c8588Wp4, String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8588Wp4, "$navController");
        h(c8588Wp4, str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0425  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(androidx.compose.ui.e r33, final ir.nasim.C20996sx3 r34, final ir.nasim.C8379Vs2 r35, final ir.nasim.InterfaceC10142b9 r36, final java.lang.String r37, ir.nasim.C19206px3 r38, final ir.nasim.SA2 r39, ir.nasim.InterfaceC22053ub1 r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 1120
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Y8.m(androidx.compose.ui.e, ir.nasim.sx3, ir.nasim.Vs2, ir.nasim.b9, java.lang.String, ir.nasim.px3, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(C20996sx3 c20996sx3, InterfaceC10142b9 interfaceC10142b9, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(c20996sx3, "$searchDialogs");
        AbstractC13042fc3.i(interfaceC10142b9, "$addDialogsUiAction");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.V8
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Y8.o((RM1) obj);
            }
        }), null, AbstractC19242q11.c(1747541553, true, new f(c20996sx3, interfaceC10142b9)), 4, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object o(RM1 rm1) {
        AbstractC13042fc3.i(rm1, "it");
        return Long.valueOf(rm1.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onBackPress");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(androidx.compose.ui.e eVar, C20996sx3 c20996sx3, C8379Vs2 c8379Vs2, InterfaceC10142b9 interfaceC10142b9, String str, C19206px3 c19206px3, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c20996sx3, "$searchDialogs");
        AbstractC13042fc3.i(c8379Vs2, "$folderUiState");
        AbstractC13042fc3.i(interfaceC10142b9, "$addDialogsUiAction");
        AbstractC13042fc3.i(sa2, "$onBackPress");
        m(eVar, c20996sx3, c8379Vs2, interfaceC10142b9, str, c19206px3, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(C20996sx3 c20996sx3) {
        AbstractC13042fc3.i(c20996sx3, "$searchDialogs");
        return c20996sx3.i().d() instanceof AbstractC13460gG3.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    private static final void t(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-7963196);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.b(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
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
            C12700f33 c12700f33D = FN1.d(EnumC23487x03.C0, interfaceC22053ub1J, 6);
            String strC = UY6.c(AbstractC12217eE5.market_search_no_result, interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC24077y03.a(c12700f33D, strC, androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(48.0f)), g10.a(interfaceC22053ub1J, i2).B(), interfaceC22053ub1J, 384, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i2).b().j()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.market_search_no_result, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i2).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i2).l(), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.U8
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Y8.u(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        t(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
