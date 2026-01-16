package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.Dw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4144Dw3 {

    /* renamed from: ir.nasim.Dw3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ GT4 f;
        final /* synthetic */ TS4 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ EnumC24286yM4 i;
        final /* synthetic */ InterfaceC4031Dj7 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ InterfaceC14124hO4 l;
        final /* synthetic */ int m;
        final /* synthetic */ float n;
        final /* synthetic */ InterfaceC10944cT4 o;
        final /* synthetic */ InterfaceC24572yq4 p;
        final /* synthetic */ UA2 q;
        final /* synthetic */ InterfaceC12529em.b r;
        final /* synthetic */ InterfaceC12529em.c s;
        final /* synthetic */ FG6 t;
        final /* synthetic */ InterfaceC16978mB2 u;
        final /* synthetic */ int v;
        final /* synthetic */ int w;
        final /* synthetic */ int x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.e eVar, GT4 gt4, TS4 ts4, boolean z, EnumC24286yM4 enumC24286yM4, InterfaceC4031Dj7 interfaceC4031Dj7, boolean z2, InterfaceC14124hO4 interfaceC14124hO4, int i, float f, InterfaceC10944cT4 interfaceC10944cT4, InterfaceC24572yq4 interfaceC24572yq4, UA2 ua2, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, FG6 fg6, InterfaceC16978mB2 interfaceC16978mB2, int i2, int i3, int i4) {
            super(2);
            this.e = eVar;
            this.f = gt4;
            this.g = ts4;
            this.h = z;
            this.i = enumC24286yM4;
            this.j = interfaceC4031Dj7;
            this.k = z2;
            this.l = interfaceC14124hO4;
            this.m = i;
            this.n = f;
            this.o = interfaceC10944cT4;
            this.p = interfaceC24572yq4;
            this.q = ua2;
            this.r = bVar;
            this.s = cVar;
            this.t = fg6;
            this.u = interfaceC16978mB2;
            this.v = i2;
            this.w = i3;
            this.x = i4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC4144Dw3.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, interfaceC22053ub1, QJ5.a(this.v | 1), QJ5.a(this.w), this.x);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Dw3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ GT4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(GT4 gt4) {
            super(0);
            this.e = gt4;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(this.e.H());
        }
    }

    /* renamed from: ir.nasim.Dw3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ GT4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(GT4 gt4) {
            super(0);
            this.e = gt4;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(this.e.H());
        }
    }

    /* renamed from: ir.nasim.Dw3$d */
    static final class d implements PointerInputEventHandler {
        final /* synthetic */ GT4 a;

        /* renamed from: ir.nasim.Dw3$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9049Yg5 c;
            final /* synthetic */ GT4 d;

            /* renamed from: ir.nasim.Dw3$d$a$a, reason: collision with other inner class name */
            static final class C0330a extends V06 implements InterfaceC14603iB2 {
                Object a;
                Object b;
                int c;
                private /* synthetic */ Object d;
                final /* synthetic */ GT4 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0330a(GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.e = gt4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0330a c0330a = new C0330a(this.e, interfaceC20295rm1);
                    c0330a.d = obj;
                    return c0330a;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0065 -> B:18:0x0068). Please report as a decompilation issue!!! */
                @Override // ir.nasim.E90
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                        int r1 = r10.c
                        r2 = 2
                        r3 = 0
                        r4 = 1
                        if (r1 == 0) goto L2f
                        if (r1 == r4) goto L27
                        if (r1 != r2) goto L1f
                        java.lang.Object r1 = r10.b
                        ir.nasim.Og5 r1 = (ir.nasim.C6616Og5) r1
                        java.lang.Object r4 = r10.a
                        ir.nasim.Og5 r4 = (ir.nasim.C6616Og5) r4
                        java.lang.Object r5 = r10.d
                        ir.nasim.EV r5 = (ir.nasim.EV) r5
                        ir.nasim.AbstractC10685c16.b(r11)
                        goto L68
                    L1f:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L27:
                        java.lang.Object r1 = r10.d
                        ir.nasim.EV r1 = (ir.nasim.EV) r1
                        ir.nasim.AbstractC10685c16.b(r11)
                        goto L44
                    L2f:
                        ir.nasim.AbstractC10685c16.b(r11)
                        java.lang.Object r11 = r10.d
                        r1 = r11
                        ir.nasim.EV r1 = (ir.nasim.EV) r1
                        ir.nasim.Dg5 r11 = ir.nasim.EnumC4002Dg5.a
                        r10.d = r1
                        r10.c = r4
                        java.lang.Object r11 = ir.nasim.AbstractC20271rj7.e(r1, r3, r11, r10)
                        if (r11 != r0) goto L44
                        return r0
                    L44:
                        ir.nasim.Og5 r11 = (ir.nasim.C6616Og5) r11
                        ir.nasim.GT4 r4 = r10.e
                        ir.nasim.ZG4$a r5 = ir.nasim.ZG4.b
                        long r5 = r5.c()
                        r4.l0(r5)
                        r4 = 0
                        r5 = r1
                        r1 = r4
                        r4 = r11
                    L55:
                        if (r1 != 0) goto L94
                        ir.nasim.Dg5 r11 = ir.nasim.EnumC4002Dg5.a
                        r10.d = r5
                        r10.a = r4
                        r10.b = r1
                        r10.c = r2
                        java.lang.Object r11 = r5.f0(r11, r10)
                        if (r11 != r0) goto L68
                        return r0
                    L68:
                        ir.nasim.Bg5 r11 = (ir.nasim.C3534Bg5) r11
                        java.util.List r6 = r11.c()
                        r7 = r6
                        java.util.Collection r7 = (java.util.Collection) r7
                        int r7 = r7.size()
                        r8 = r3
                    L76:
                        if (r8 >= r7) goto L88
                        java.lang.Object r9 = r6.get(r8)
                        ir.nasim.Og5 r9 = (ir.nasim.C6616Og5) r9
                        boolean r9 = ir.nasim.AbstractC3768Cg5.c(r9)
                        if (r9 != 0) goto L85
                        goto L55
                    L85:
                        int r8 = r8 + 1
                        goto L76
                    L88:
                        java.util.List r11 = r11.c()
                        java.lang.Object r11 = r11.get(r3)
                        r1 = r11
                        ir.nasim.Og5 r1 = (ir.nasim.C6616Og5) r1
                        goto L55
                    L94:
                        ir.nasim.GT4 r11 = r10.e
                        long r0 = r1.h()
                        long r2 = r4.h()
                        long r0 = ir.nasim.ZG4.p(r0, r2)
                        r11.l0(r0)
                        ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4144Dw3.d.a.C0330a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0330a) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9049Yg5 interfaceC9049Yg5, GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9049Yg5;
                this.d = gt4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC9049Yg5 interfaceC9049Yg5 = this.c;
                    C0330a c0330a = new C0330a(this.d, null);
                    this.b = 1;
                    if (AbstractC8163Uu2.d(interfaceC9049Yg5, c0330a, this) == objE) {
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

        d(GT4 gt4) {
            this.a = gt4;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objE = AbstractC20906so1.e(new a(interfaceC9049Yg5, this.a, null), interfaceC20295rm1);
            return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Dw3$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ SA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, SA2 sa2) {
            super(0);
            this.e = interfaceC9664aL6;
            this.f = interfaceC9664aL62;
            this.g = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C18915pT4 invoke() {
            return new C18915pT4((InterfaceC16978mB2) this.e.getValue(), (UA2) this.f.getValue(), ((Number) this.g.invoke()).intValue());
        }
    }

    /* renamed from: ir.nasim.Dw3$g */
    static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ GT4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC9664aL6 interfaceC9664aL6, GT4 gt4) {
            super(0);
            this.e = interfaceC9664aL6;
            this.f = gt4;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19506qT4 invoke() {
            C18915pT4 c18915pT4 = (C18915pT4) this.e.getValue();
            return new C19506qT4(this.f, c18915pT4, new C19729qq4(this.f.G(), c18915pT4));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:268:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(androidx.compose.ui.e r34, ir.nasim.GT4 r35, ir.nasim.TS4 r36, boolean r37, ir.nasim.EnumC24286yM4 r38, ir.nasim.InterfaceC4031Dj7 r39, boolean r40, ir.nasim.InterfaceC14124hO4 r41, int r42, float r43, ir.nasim.InterfaceC10944cT4 r44, ir.nasim.InterfaceC24572yq4 r45, ir.nasim.UA2 r46, ir.nasim.InterfaceC12529em.b r47, ir.nasim.InterfaceC12529em.c r48, ir.nasim.FG6 r49, ir.nasim.InterfaceC16978mB2 r50, ir.nasim.InterfaceC22053ub1 r51, int r52, int r53, int r54) {
        /*
            Method dump skipped, instructions count: 1209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4144Dw3.a(androidx.compose.ui.e, ir.nasim.GT4, ir.nasim.TS4, boolean, ir.nasim.yM4, ir.nasim.Dj7, boolean, ir.nasim.hO4, int, float, ir.nasim.cT4, ir.nasim.yq4, ir.nasim.UA2, ir.nasim.em$b, ir.nasim.em$c, ir.nasim.FG6, ir.nasim.mB2, ir.nasim.ub1, int, int, int):void");
    }

    private static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, GT4 gt4) {
        return eVar.i(AbstractC21071t37.c(androidx.compose.ui.e.a, gt4, new d(gt4)));
    }

    private static final SA2 c(GT4 gt4, InterfaceC16978mB2 interfaceC16978mB2, UA2 ua2, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1372505274, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:259)");
        }
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(interfaceC16978mB2, interfaceC22053ub1, (i >> 3) & 14);
        InterfaceC9664aL6 interfaceC9664aL6Q2 = AbstractC10222bH6.q(ua2, interfaceC22053ub1, (i >> 6) & 14);
        boolean zV = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(gt4)) || (i & 6) == 4) | interfaceC22053ub1.V(interfaceC9664aL6Q) | interfaceC22053ub1.V(interfaceC9664aL6Q2) | ((((i & 7168) ^ SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) > 2048 && interfaceC22053ub1.V(sa2)) || (i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 2048);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new AbstractC24042xw5(AbstractC10222bH6.e(AbstractC10222bH6.p(), new g(AbstractC10222bH6.e(AbstractC10222bH6.p(), new f(interfaceC9664aL6Q, interfaceC9664aL6Q2, sa2)), gt4))) { // from class: ir.nasim.Dw3.e
                @Override // ir.nasim.InterfaceC3820Cm3
                public Object get() {
                    return ((InterfaceC9664aL6) this.receiver).getValue();
                }
            };
            interfaceC22053ub1.s(objB);
        }
        InterfaceC3820Cm3 interfaceC3820Cm3 = (InterfaceC3820Cm3) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC3820Cm3;
    }
}
