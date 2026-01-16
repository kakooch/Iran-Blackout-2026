package ir.nasim;

/* renamed from: ir.nasim.Wi7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8528Wi7 {
    public static final C8528Wi7 a = new C8528Wi7();
    private static final float b = C17784nZ1.q(52);
    public static final int c = 0;

    /* renamed from: ir.nasim.Wi7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ float g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.e eVar, float f, long j, int i, int i2) {
            super(2);
            this.f = eVar;
            this.g = f;
            this.h = j;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C8528Wi7.this.a(this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wi7$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ float g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, float f, long j, int i, int i2) {
            super(2);
            this.f = eVar;
            this.g = f;
            this.h = j;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C8528Wi7.this.b(this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wi7$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C7587Si7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C7587Si7 c7587Si7) {
            super(1);
            this.e = c7587Si7;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wi7$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ C7587Si7 e;

        /* renamed from: ir.nasim.Wi7$d$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC9664aL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6) {
                super(1);
                this.e = interfaceC9664aL6;
            }

            public final long a(WH1 wh1) {
                return AbstractC22635va3.a(wh1.B0(d.d(this.e)), 0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return C22045ua3.c(a((WH1) obj));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C7587Si7 c7587Si7) {
            super(3);
            this.e = c7587Si7;
        }

        private static final float c(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((C17784nZ1) interfaceC9664aL6.getValue()).v();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float d(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((C17784nZ1) interfaceC9664aL6.getValue()).v();
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1541271084);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1541271084, i, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1271)");
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC4572Fs.c(this.e.c(), AbstractC8794Xi7.c, null, null, interfaceC22053ub1, 0, 12);
            InterfaceC9664aL6 interfaceC9664aL6C2 = AbstractC4572Fs.c(this.e.a(), AbstractC8794Xi7.c, null, null, interfaceC22053ub1, 0, 12);
            androidx.compose.ui.e eVarE = androidx.compose.foundation.layout.t.E(androidx.compose.foundation.layout.t.h(eVar, 0.0f, 1, null), InterfaceC12529em.a.d(), false, 2, null);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(interfaceC9664aL6C2);
                interfaceC22053ub1.s(objB);
            }
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.n.a(eVarE, (UA2) objB), c(interfaceC9664aL6C));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarY;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    private C8528Wi7() {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.compose.ui.e r16, float r17, long r18, ir.nasim.InterfaceC22053ub1 r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8528Wi7.a(androidx.compose.ui.e, float, long, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.compose.ui.e r16, float r17, long r18, ir.nasim.InterfaceC22053ub1 r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8528Wi7.b(androidx.compose.ui.e, float, long, ir.nasim.ub1, int, int):void");
    }

    public final long c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-2069154037, i, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:1169)");
        }
        long jF = ZX0.f(C21617tq5.a.d(), interfaceC22053ub1, 6);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return jF;
    }

    public final long d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1410362619, i, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1185)");
        }
        long jF = ZX0.f(C21617tq5.a.c(), interfaceC22053ub1, 6);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return jF;
    }

    public final float e() {
        return b;
    }

    public final androidx.compose.ui.e f(androidx.compose.ui.e eVar, C7587Si7 c7587Si7) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new c(c7587Si7) : Q93.a(), new d(c7587Si7));
    }
}
