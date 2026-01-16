package ir.nasim;

import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.Fs, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4572Fs {
    private static final C18827pJ6 a = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
    private static final C18827pJ6 b = AbstractC5999Lt.j(0.0f, 0.0f, C17784nZ1.j(IY7.a(C17784nZ1.b)), 3, null);
    private static final C18827pJ6 c = AbstractC5999Lt.j(0.0f, 0.0f, OD6.c(IY7.f(OD6.b)), 3, null);
    private static final C18827pJ6 d = AbstractC5999Lt.j(0.0f, 0.0f, ZG4.d(IY7.e(ZG4.b)), 3, null);
    private static final C18827pJ6 e = AbstractC5999Lt.j(0.0f, 0.0f, IY7.g(CK5.e), 3, null);
    private static final C18827pJ6 f = AbstractC5999Lt.j(0.0f, 0.0f, Integer.valueOf(IY7.b(C15431ja3.a)), 3, null);
    private static final C18827pJ6 g = AbstractC5999Lt.j(0.0f, 0.0f, C22045ua3.c(IY7.c(C22045ua3.b)), 3, null);
    private static final C18827pJ6 h = AbstractC5999Lt.j(0.0f, 0.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 3, null);

    /* renamed from: ir.nasim.Fs$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC17639nJ0 e;
        final /* synthetic */ Object f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC17639nJ0 interfaceC17639nJ0, Object obj) {
            super(0);
            this.e = interfaceC17639nJ0;
            this.f = obj;
        }

        public final void a() {
            this.e.h(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Fs$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ InterfaceC17639nJ0 e;
        final /* synthetic */ C15607js f;
        final /* synthetic */ InterfaceC9664aL6 g;
        final /* synthetic */ InterfaceC9664aL6 h;

        /* renamed from: ir.nasim.Fs$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ Object c;
            final /* synthetic */ C15607js d;
            final /* synthetic */ InterfaceC9664aL6 e;
            final /* synthetic */ InterfaceC9664aL6 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, C15607js c15607js, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = obj;
                this.d = c15607js;
                this.e = interfaceC9664aL6;
                this.f = interfaceC9664aL62;
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
                    if (!AbstractC13042fc3.d(this.c, this.d.n())) {
                        C15607js c15607js = this.d;
                        Object obj2 = this.c;
                        InterfaceC5766Kt interfaceC5766KtI = AbstractC4572Fs.i(this.e);
                        this.b = 1;
                        if (C15607js.h(c15607js, obj2, interfaceC5766KtI, null, null, this, 12, null) == objE) {
                            return objE;
                        }
                    }
                    return C19938rB7.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                UA2 ua2H = AbstractC4572Fs.h(this.f);
                if (ua2H != null) {
                    ua2H.invoke(this.d.q());
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC17639nJ0 interfaceC17639nJ0, C15607js c15607js, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC17639nJ0;
            this.f = c15607js;
            this.g = interfaceC9664aL6;
            this.h = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.e, this.f, this.g, this.h, interfaceC20295rm1);
            bVar.d = obj;
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003a -> B:12:0x003d). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r13.c
                r2 = 1
                if (r1 == 0) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r1 = r13.b
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r3 = r13.d
                ir.nasim.ro1 r3 = (ir.nasim.InterfaceC20315ro1) r3
                ir.nasim.AbstractC10685c16.b(r14)
                r4 = r14
                goto L3d
            L18:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L20:
                ir.nasim.AbstractC10685c16.b(r14)
                java.lang.Object r1 = r13.d
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.nJ0 r3 = r13.e
                ir.nasim.CJ0 r3 = r3.iterator()
                r12 = r3
                r3 = r1
                r1 = r12
            L30:
                r13.d = r3
                r13.b = r1
                r13.c = r2
                java.lang.Object r4 = r1.a(r13)
                if (r4 != r0) goto L3d
                return r0
            L3d:
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L6f
                java.lang.Object r4 = r1.next()
                ir.nasim.nJ0 r5 = r13.e
                java.lang.Object r5 = r5.v()
                java.lang.Object r5 = ir.nasim.GJ0.f(r5)
                if (r5 != 0) goto L57
                r7 = r4
                goto L58
            L57:
                r7 = r5
            L58:
                ir.nasim.Fs$b$a r4 = new ir.nasim.Fs$b$a
                ir.nasim.js r8 = r13.f
                ir.nasim.aL6 r9 = r13.g
                ir.nasim.aL6 r10 = r13.h
                r11 = 0
                r6 = r4
                r6.<init>(r7, r8, r9, r10, r11)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                r5 = r3
                r8 = r4
                ir.nasim.AbstractC9323Zl0.d(r5, r6, r7, r8, r9, r10)
                goto L30
            L6f:
                ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4572Fs.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC9664aL6 c(float f2, InterfaceC5766Kt interfaceC5766Kt, String str, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            interfaceC5766Kt = b;
        }
        InterfaceC5766Kt interfaceC5766Kt2 = interfaceC5766Kt;
        if ((i2 & 4) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            ua2 = null;
        }
        UA2 ua22 = ua2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1407150062, i, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:111)");
        }
        int i3 = i << 6;
        InterfaceC9664aL6 interfaceC9664aL6G = g(C17784nZ1.j(f2), PQ7.b(C17784nZ1.b), interfaceC5766Kt2, null, str2, ua22, interfaceC22053ub1, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6G;
    }

    public static final InterfaceC9664aL6 d(float f2, InterfaceC5766Kt interfaceC5766Kt, float f3, String str, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        InterfaceC5766Kt interfaceC5766Kt2;
        InterfaceC5766Kt interfaceC5766Kt3 = (i2 & 2) != 0 ? a : interfaceC5766Kt;
        float f4 = (i2 & 4) != 0 ? 0.01f : f3;
        String str2 = (i2 & 8) != 0 ? "FloatAnimation" : str;
        UA2 ua22 = (i2 & 16) != 0 ? null : ua2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(668842840, i, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:67)");
        }
        if (interfaceC5766Kt3 == a) {
            interfaceC22053ub1.W(1125558999);
            boolean z = (((i & 896) ^ 384) > 256 && interfaceC22053ub1.c(f4)) || (i & 384) == 256;
            Object objB = interfaceC22053ub1.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC5999Lt.j(0.0f, 0.0f, Float.valueOf(f4), 3, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC5766Kt2 = (C18827pJ6) objB;
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(1125668925);
            interfaceC22053ub1.Q();
            interfaceC5766Kt2 = interfaceC5766Kt3;
        }
        int i3 = i << 3;
        InterfaceC9664aL6 interfaceC9664aL6G = g(Float.valueOf(f2), PQ7.d(C9361Zp2.a), interfaceC5766Kt2, Float.valueOf(f4), str2, ua22, interfaceC22053ub1, (i & 14) | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6G;
    }

    public static final InterfaceC9664aL6 e(int i, InterfaceC5766Kt interfaceC5766Kt, String str, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        if ((i3 & 2) != 0) {
            interfaceC5766Kt = f;
        }
        InterfaceC5766Kt interfaceC5766Kt2 = interfaceC5766Kt;
        if ((i3 & 4) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            ua2 = null;
        }
        UA2 ua22 = ua2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(428074472, i2, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:270)");
        }
        int i4 = i2 << 6;
        InterfaceC9664aL6 interfaceC9664aL6G = g(Integer.valueOf(i), PQ7.e(C15431ja3.a), interfaceC5766Kt2, null, str2, ua22, interfaceC22053ub1, (i2 & 14) | ((i2 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6G;
    }

    public static final InterfaceC9664aL6 f(CK5 ck5, InterfaceC5766Kt interfaceC5766Kt, String str, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            interfaceC5766Kt = e;
        }
        InterfaceC5766Kt interfaceC5766Kt2 = interfaceC5766Kt;
        if ((i2 & 4) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            ua2 = null;
        }
        UA2 ua22 = ua2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(536062978, i, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:232)");
        }
        int i3 = i << 6;
        InterfaceC9664aL6 interfaceC9664aL6G = g(ck5, PQ7.i(CK5.e), interfaceC5766Kt2, null, str2, ua22, interfaceC22053ub1, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6G;
    }

    public static final InterfaceC9664aL6 g(Object obj, InterfaceC5342Ix7 interfaceC5342Ix7, InterfaceC5766Kt interfaceC5766Kt, Object obj2, String str, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        InterfaceC5766Kt interfaceC5766KtI;
        if ((i2 & 4) != 0) {
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC5766KtI = (C18827pJ6) objB;
        } else {
            interfaceC5766KtI = interfaceC5766Kt;
        }
        Object obj3 = (i2 & 8) != 0 ? null : obj2;
        String str2 = (i2 & 16) != 0 ? "ValueAnimation" : str;
        UA2 ua22 = (i2 & 32) != 0 ? null : ua2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1994373980, i, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:395)");
        }
        Object objB2 = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB2 == aVar.a()) {
            objB2 = AbstractC13472gH6.d(null, null, 2, null);
            interfaceC22053ub1.s(objB2);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
        Object objB3 = interfaceC22053ub1.B();
        if (objB3 == aVar.a()) {
            objB3 = new C15607js(obj, interfaceC5342Ix7, obj3, str2);
            interfaceC22053ub1.s(objB3);
        }
        C15607js c15607js = (C15607js) objB3;
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(ua22, interfaceC22053ub1, (i >> 15) & 14);
        if (obj3 != null && (interfaceC5766KtI instanceof C18827pJ6)) {
            C18827pJ6 c18827pJ6 = (C18827pJ6) interfaceC5766KtI;
            if (!AbstractC13042fc3.d(c18827pJ6.h(), obj3)) {
                interfaceC5766KtI = AbstractC5999Lt.i(c18827pJ6.f(), c18827pJ6.g(), obj3);
            }
        }
        InterfaceC9664aL6 interfaceC9664aL6Q2 = AbstractC10222bH6.q(interfaceC5766KtI, interfaceC22053ub1, 0);
        Object objB4 = interfaceC22053ub1.B();
        if (objB4 == aVar.a()) {
            objB4 = DJ0.b(-1, null, null, 6, null);
            interfaceC22053ub1.s(objB4);
        }
        InterfaceC17639nJ0 interfaceC17639nJ0 = (InterfaceC17639nJ0) objB4;
        boolean zD = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.D(obj)) || (i & 6) == 4) | interfaceC22053ub1.D(interfaceC17639nJ0);
        Object objB5 = interfaceC22053ub1.B();
        if (zD || objB5 == aVar.a()) {
            objB5 = new a(interfaceC17639nJ0, obj);
            interfaceC22053ub1.s(objB5);
        }
        AbstractC10721c52.i((SA2) objB5, interfaceC22053ub1, 0);
        boolean zD2 = interfaceC22053ub1.D(interfaceC17639nJ0) | interfaceC22053ub1.D(c15607js) | interfaceC22053ub1.V(interfaceC9664aL6Q2) | interfaceC22053ub1.V(interfaceC9664aL6Q);
        Object objB6 = interfaceC22053ub1.B();
        if (zD2 || objB6 == aVar.a()) {
            objB6 = new b(interfaceC17639nJ0, c15607js, interfaceC9664aL6Q2, interfaceC9664aL6Q, null);
            interfaceC22053ub1.s(objB6);
        }
        AbstractC10721c52.e(interfaceC17639nJ0, (InterfaceC14603iB2) objB6, interfaceC22053ub1, 0);
        InterfaceC9664aL6 interfaceC9664aL6I = (InterfaceC9664aL6) interfaceC9102Ym4.getValue();
        if (interfaceC9664aL6I == null) {
            interfaceC9664aL6I = c15607js.i();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UA2 h(InterfaceC9664aL6 interfaceC9664aL6) {
        return (UA2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC5766Kt i(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC5766Kt) interfaceC9664aL6.getValue();
    }
}
