package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC16365l9;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OA2;
import java.util.List;

/* renamed from: ir.nasim.l9, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16365l9 {

    /* renamed from: ir.nasim.l9$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        public a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.l9$b */
    public static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.l9$c */
    public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ InterfaceC21797u9 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list, InterfaceC21797u9 interfaceC21797u9) {
            super(4);
            this.e = list;
            this.f = interfaceC21797u9;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) throws Resources.NotFoundException {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            RM1 rm1 = (RM1) this.e.get(i);
            interfaceC22053ub1.W(1008258683);
            AbstractC10271bN1.i(rm1.a((383 & 1) != 0 ? rm1.a : 0L, (383 & 2) != 0 ? rm1.b : null, (383 & 4) != 0 ? rm1.c : null, (383 & 8) != 0 ? rm1.d : null, (383 & 16) != 0 ? rm1.e : false, (383 & 32) != 0 ? rm1.f : false, (383 & 64) != 0 ? rm1.g : true, (383 & 128) != 0 ? rm1.h : null, (383 & 256) != 0 ? rm1.i : null), null, null, 0.0f, 0.0f, 0.0f, null, this.f.b(), interfaceC22053ub1, 0, 126);
            interfaceC22053ub1.Q();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) throws Resources.NotFoundException {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.l9$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19911r9 c;
        final /* synthetic */ Integer d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C19911r9 c19911r9, Integer num, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19911r9;
            this.d = num;
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.A1(this.d, this.e);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.l9$e */
    static final class e implements InterfaceC14603iB2 {
        final /* synthetic */ Integer a;
        final /* synthetic */ UA2 b;

        /* renamed from: ir.nasim.l9$e$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ Integer a;
            final /* synthetic */ UA2 b;

            a(Integer num, UA2 ua2) {
                this.a = num;
                this.b = ua2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(UA2 ua2) {
                AbstractC13042fc3.i(ua2, "$onBackPressedCallback");
                ua2.invoke(Boolean.FALSE);
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                String strC;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (this.a != null) {
                    interfaceC22053ub1.W(889320857);
                    strC = UY6.c(FD5.edit_folder, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(889416771);
                    strC = UY6.c(FD5.add_folder, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                }
                String str = strC;
                interfaceC22053ub1.W(-525492413);
                boolean zV = interfaceC22053ub1.V(this.b);
                final UA2 ua2 = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.m9
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC16365l9.e.a.c(ua2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC21639ts7.i(str, null, (SA2) objB, null, null, null, null, interfaceC22053ub1, 0, 122);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        e(Integer num, UA2 ua2) {
            this.a = num;
            this.b = ua2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-621884278, true, new a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.l9$f */
    static final class f implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        f(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, G11.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.l9$g */
    static final class g implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9664aL6 a;
        final /* synthetic */ C19911r9 b;
        final /* synthetic */ C19391qG6 c;
        final /* synthetic */ Integer d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ InterfaceC21797u9 f;
        final /* synthetic */ C8588Wp4 g;
        final /* synthetic */ InterfaceC9664aL6 h;
        final /* synthetic */ InterfaceC9664aL6 i;

        /* renamed from: ir.nasim.l9$g$a */
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
                    WF6 wf6Y = AbstractC16365l9.y(this.c);
                    if (wf6Y != null) {
                        C19391qG6 c19391qG6 = this.d;
                        Resources resources = this.e;
                        final C19911r9 c19911r9 = this.f;
                        AbstractC13042fc3.f(resources);
                        SA2 sa2 = new SA2() { // from class: ir.nasim.p9
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC16365l9.g.a.y(c19911r9);
                            }
                        };
                        this.b = 1;
                        if (AbstractC16365l9.F(c19391qG6, wf6Y, resources, sa2, this) == objE) {
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

        g(InterfaceC9664aL6 interfaceC9664aL6, C19911r9 c19911r9, C19391qG6 c19391qG6, Integer num, UA2 ua2, InterfaceC21797u9 interfaceC21797u9, C8588Wp4 c8588Wp4, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63) {
            this.a = interfaceC9664aL6;
            this.b = c19911r9;
            this.c = c19391qG6;
            this.d = num;
            this.e = ua2;
            this.f = interfaceC21797u9;
            this.g = c8588Wp4;
            this.h = interfaceC9664aL62;
            this.i = interfaceC9664aL63;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(UA2 ua2, boolean z) {
            AbstractC13042fc3.i(ua2, "$onBackPressedCallback");
            ua2.invoke(Boolean.valueOf(z));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C8588Wp4 c8588Wp4, String str) throws Resources.NotFoundException {
            AbstractC13042fc3.i(c8588Wp4, "$navController");
            AbstractC13042fc3.i(str, "folderName");
            androidx.navigation.e.S(c8588Wp4, C9960aq4.a.a(str), null, null, 6, null);
            return C19938rB7.a;
        }

        public final void c(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
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
            WF6 wf6Y = AbstractC16365l9.y(this.a);
            interfaceC22053ub1.W(1966519480);
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
            AbstractC10721c52.e(wf6Y, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            Integer num = this.d;
            final UA2 ua2 = this.e;
            InterfaceC21797u9 interfaceC21797u9 = this.f;
            final C8588Wp4 c8588Wp4 = this.g;
            InterfaceC9664aL6 interfaceC9664aL62 = this.h;
            InterfaceC9664aL6 interfaceC9664aL63 = this.i;
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
            String strX = AbstractC16365l9.x(interfaceC9664aL62);
            C8379Vs2 c8379Vs2W = AbstractC16365l9.w(interfaceC9664aL63);
            interfaceC22053ub1.W(-525454302);
            boolean zV2 = interfaceC22053ub1.V(ua2);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.n9
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16365l9.g.d(ua2, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            UA2 ua22 = (UA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-525447803);
            boolean zD = interfaceC22053ub1.D(c8588Wp4);
            Object objB3 = interfaceC22053ub1.B();
            if (zD || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.o9
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16365l9.g.f(c8588Wp4, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC16365l9.j(eVarF, num, strX, ua22, c8379Vs2W, interfaceC21797u9, (UA2) objB3, null, interfaceC22053ub1, 6, 128);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.l9$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC16365l9.F(null, null, null, null, this);
        }
    }

    private static final OA2 E(String str, C8379Vs2 c8379Vs2) {
        return c8379Vs2.f() ? OA2.a.b : (str.length() == 0 || c8379Vs2.c().isEmpty() || AbstractC20762sZ6.n1(str).toString().length() > 12) ? OA2.b.a.c : OA2.b.C0545b.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object F(ir.nasim.C19391qG6 r9, ir.nasim.WF6 r10, android.content.res.Resources r11, ir.nasim.SA2 r12, ir.nasim.InterfaceC20295rm1 r13) throws android.content.res.Resources.NotFoundException {
        /*
            boolean r0 = r13 instanceof ir.nasim.AbstractC16365l9.h
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.l9$h r0 = (ir.nasim.AbstractC16365l9.h) r0
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
            ir.nasim.l9$h r0 = new ir.nasim.l9$h
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16365l9.F(ir.nasim.qG6, ir.nasim.WF6, android.content.res.Resources, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(androidx.compose.ui.e r55, final java.lang.Integer r56, final java.lang.String r57, final ir.nasim.UA2 r58, final ir.nasim.C8379Vs2 r59, final ir.nasim.InterfaceC21797u9 r60, final ir.nasim.UA2 r61, ir.nasim.C19206px3 r62, ir.nasim.InterfaceC22053ub1 r63, final int r64, final int r65) {
        /*
            Method dump skipped, instructions count: 1620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16365l9.j(androidx.compose.ui.e, java.lang.Integer, java.lang.String, ir.nasim.UA2, ir.nasim.Vs2, ir.nasim.u9, ir.nasim.UA2, ir.nasim.px3, ir.nasim.ub1, int, int):void");
    }

    private static final void k(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(InterfaceC20600sH6 interfaceC20600sH6, InterfaceC10566bp3 interfaceC10566bp3) {
        AbstractC13042fc3.i(interfaceC10566bp3, "$this$KeyboardActions");
        if (interfaceC20600sH6 != null) {
            interfaceC20600sH6.b();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(InterfaceC21797u9 interfaceC21797u9, String str) {
        AbstractC13042fc3.i(interfaceC21797u9, "$addFolderAction");
        AbstractC13042fc3.i(str, "it");
        interfaceC21797u9.d().invoke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(InterfaceC20600sH6 interfaceC20600sH6, UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(ua2, "$onAddDialogClicked");
        AbstractC13042fc3.i(interfaceC9664aL6, "$name$delegate");
        if (interfaceC20600sH6 != null) {
            interfaceC20600sH6.b();
        }
        ua2.invoke(t(interfaceC9664aL6));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(C8379Vs2 c8379Vs2, InterfaceC21797u9 interfaceC21797u9, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(c8379Vs2, "$folderUiState");
        AbstractC13042fc3.i(interfaceC21797u9, "$addFolderAction");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        List listC = c8379Vs2.c();
        interfaceC15069ix3.a(listC.size(), null, new b(a.e, listC), AbstractC19242q11.c(-632812321, true, new c(listC, interfaceC21797u9)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C8379Vs2 c8379Vs2, InterfaceC21797u9 interfaceC21797u9, Integer num, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4, final UA2 ua2) {
        AbstractC13042fc3.i(c8379Vs2, "$folderUiState");
        AbstractC13042fc3.i(interfaceC21797u9, "$addFolderAction");
        AbstractC13042fc3.i(interfaceC9664aL6, "$name$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$emptyError$delegate");
        AbstractC13042fc3.i(ua2, "$onBackPress");
        if (t(interfaceC9664aL6).length() == 0) {
            k(interfaceC9102Ym4, true);
        } else if (c8379Vs2.c().isEmpty()) {
            interfaceC21797u9.c().invoke();
        } else if (AbstractC20762sZ6.n1(t(interfaceC9664aL6)).toString().length() <= 12 && !c8379Vs2.f()) {
            if (num != null) {
                interfaceC21797u9.a().q(num, t(interfaceC9664aL6), new SA2() { // from class: ir.nasim.c9
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16365l9.q(ua2);
                    }
                });
            } else {
                interfaceC21797u9.e().invoke(t(interfaceC9664aL6), new SA2() { // from class: ir.nasim.d9
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16365l9.r(ua2);
                    }
                });
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onBackPress");
        ua2.invoke(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onBackPress");
        ua2.invoke(Boolean.TRUE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(androidx.compose.ui.e eVar, Integer num, String str, UA2 ua2, C8379Vs2 c8379Vs2, InterfaceC21797u9 interfaceC21797u9, UA2 ua22, C19206px3 c19206px3, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$folderName");
        AbstractC13042fc3.i(ua2, "$onBackPress");
        AbstractC13042fc3.i(c8379Vs2, "$folderUiState");
        AbstractC13042fc3.i(interfaceC21797u9, "$addFolderAction");
        AbstractC13042fc3.i(ua22, "$onAddDialogClicked");
        j(eVar, num, str, ua2, c8379Vs2, interfaceC21797u9, ua22, c19206px3, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final String t(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    private static final boolean u(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    public static final void v(final C8588Wp4 c8588Wp4, final Integer num, final List list, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        Object obj;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c8588Wp4, "navController");
        AbstractC13042fc3.i(ua2, "onBackPressedCallback");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1785214350);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c8588Wp4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(num) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(list) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.navigation.d dVarB = c8588Wp4.B();
            interfaceC22053ub1J.W(-421454933);
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
            InterfaceC21797u9 interfaceC21797u9S1 = c19911r9.s1();
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(c19911r9.v1(), null, interfaceC22053ub1J, 0, 1);
            InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(c19911r9.u1(), null, interfaceC22053ub1J, 0, 1);
            interfaceC22053ub1J.W(-421442830);
            Object objB2 = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB2 == aVar.a()) {
                objB2 = new C19391qG6();
                interfaceC22053ub1J.s(objB2);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB2;
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(c19911r9.z1(), null, null, null, interfaceC22053ub1J, 0, 7);
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(-421438384);
            boolean zD = interfaceC22053ub1J.D(c19911r9) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.D(list);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD || objB3 == aVar.a()) {
                obj = null;
                objB3 = new d(c19911r9, num, list, null);
                interfaceC22053ub1J.s(objB3);
            } else {
                obj = null;
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB3, interfaceC22053ub1J, 6);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, obj);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1J, i3).r(), null, 2, null);
            long jR = g10.a(interfaceC22053ub1J, i3).r();
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1351121226, true, new e(num, ua2), interfaceC22053ub1J, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(27942280, true, new f(c19391qG6), interfaceC22053ub1J, 54);
            InterfaceC18060o11 interfaceC18060o11E3 = AbstractC19242q11.e(-581340193, true, new g(interfaceC9664aL6C, c19911r9, c19391qG6, num, ua2, interfaceC21797u9S1, c8588Wp4, interfaceC9664aL6B2, interfaceC9664aL6B), interfaceC22053ub1J, 54);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(eVarD, interfaceC18060o11E, null, interfaceC18060o11E2, null, 0, jR, 0L, null, interfaceC18060o11E3, interfaceC22053ub12, 805309488, 436);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.e9
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return AbstractC16365l9.z(c8588Wp4, num, list, ua2, i, (InterfaceC22053ub1) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8379Vs2 w(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C8379Vs2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String x(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WF6 y(InterfaceC9664aL6 interfaceC9664aL6) {
        return (WF6) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(C8588Wp4 c8588Wp4, Integer num, List list, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8588Wp4, "$navController");
        AbstractC13042fc3.i(ua2, "$onBackPressedCallback");
        v(c8588Wp4, num, list, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
