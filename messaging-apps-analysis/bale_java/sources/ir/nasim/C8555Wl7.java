package ir.nasim;

/* renamed from: ir.nasim.Wl7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8555Wl7 {
    public static final C8555Wl7 a = new C8555Wl7();
    private static final float b = C17784nZ1.q(56);
    private static final float c = C17784nZ1.q(280);
    private static final float d = C17784nZ1.q(1);
    private static final float e = C17784nZ1.q(2);

    /* renamed from: ir.nasim.Wl7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ InterfaceC23241wb3 h;
        final /* synthetic */ InterfaceC7614Sl7 i;
        final /* synthetic */ InterfaceC10031ax6 j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;
        final /* synthetic */ int m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, boolean z2, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC7614Sl7 interfaceC7614Sl7, InterfaceC10031ax6 interfaceC10031ax6, float f, float f2, int i, int i2) {
            super(2);
            this.f = z;
            this.g = z2;
            this.h = interfaceC23241wb3;
            this.i = interfaceC7614Sl7;
            this.j = interfaceC10031ax6;
            this.k = f;
            this.l = f2;
            this.m = i;
            this.n = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C8555Wl7.this.a(this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC22053ub1, QJ5.a(this.m | 1), this.n);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wl7$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC23241wb3 g;
        final /* synthetic */ InterfaceC7614Sl7 h;
        final /* synthetic */ InterfaceC10031ax6 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z, boolean z2, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC7614Sl7 interfaceC7614Sl7, InterfaceC10031ax6 interfaceC10031ax6) {
            super(2);
            this.e = z;
            this.f = z2;
            this.g = interfaceC23241wb3;
            this.h = interfaceC7614Sl7;
            this.i = interfaceC10031ax6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(2147252344, i, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:659)");
            }
            C8555Wl7.a.a(this.e, this.f, this.g, this.h, this.i, 0.0f, 0.0f, interfaceC22053ub1, 12582912, 96);
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

    /* renamed from: ir.nasim.Wl7$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ QY7 j;
        final /* synthetic */ InterfaceC23241wb3 k;
        final /* synthetic */ boolean l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ InterfaceC14603iB2 o;
        final /* synthetic */ InterfaceC14603iB2 p;
        final /* synthetic */ InterfaceC10031ax6 q;
        final /* synthetic */ InterfaceC7614Sl7 r;
        final /* synthetic */ TS4 s;
        final /* synthetic */ InterfaceC14603iB2 t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;
        final /* synthetic */ int w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC14603iB2 interfaceC14603iB2, boolean z, boolean z2, QY7 qy7, InterfaceC23241wb3 interfaceC23241wb3, boolean z3, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC14603iB2 interfaceC14603iB25, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7, TS4 ts4, InterfaceC14603iB2 interfaceC14603iB26, int i, int i2, int i3) {
            super(2);
            this.f = str;
            this.g = interfaceC14603iB2;
            this.h = z;
            this.i = z2;
            this.j = qy7;
            this.k = interfaceC23241wb3;
            this.l = z3;
            this.m = interfaceC14603iB22;
            this.n = interfaceC14603iB23;
            this.o = interfaceC14603iB24;
            this.p = interfaceC14603iB25;
            this.q = interfaceC10031ax6;
            this.r = interfaceC7614Sl7;
            this.s = ts4;
            this.t = interfaceC14603iB26;
            this.u = i;
            this.v = i2;
            this.w = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C8555Wl7.this.b(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, interfaceC22053ub1, QJ5.a(this.u | 1), QJ5.a(this.v), this.w);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wl7$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ QY7 j;
        final /* synthetic */ InterfaceC23241wb3 k;
        final /* synthetic */ boolean l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ InterfaceC14603iB2 o;
        final /* synthetic */ InterfaceC14603iB2 p;
        final /* synthetic */ InterfaceC10031ax6 q;
        final /* synthetic */ InterfaceC7614Sl7 r;
        final /* synthetic */ TS4 s;
        final /* synthetic */ int t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, InterfaceC14603iB2 interfaceC14603iB2, boolean z, boolean z2, QY7 qy7, InterfaceC23241wb3 interfaceC23241wb3, boolean z3, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC14603iB2 interfaceC14603iB25, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7, TS4 ts4, int i, int i2, int i3) {
            super(2);
            this.f = str;
            this.g = interfaceC14603iB2;
            this.h = z;
            this.i = z2;
            this.j = qy7;
            this.k = interfaceC23241wb3;
            this.l = z3;
            this.m = interfaceC14603iB22;
            this.n = interfaceC14603iB23;
            this.o = interfaceC14603iB24;
            this.p = interfaceC14603iB25;
            this.q = interfaceC10031ax6;
            this.r = interfaceC7614Sl7;
            this.s = ts4;
            this.t = i;
            this.u = i2;
            this.v = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C8555Wl7.this.c(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, interfaceC22053ub1, QJ5.a(this.t | 1), QJ5.a(this.u), this.v);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wl7$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC23241wb3 g;
        final /* synthetic */ InterfaceC7614Sl7 h;
        final /* synthetic */ float i;
        final /* synthetic */ float j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(boolean z, boolean z2, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC7614Sl7 interfaceC7614Sl7, float f, float f2) {
            super(3);
            this.e = z;
            this.f = z2;
            this.g = interfaceC23241wb3;
            this.h = interfaceC7614Sl7;
            this.i = f;
            this.j = f2;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(1398930845);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1398930845, i, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:288)");
            }
            androidx.compose.ui.e eVarJ = AbstractC14965im7.j(androidx.compose.ui.e.a, (C10493bi0) AbstractC8821Xl7.b(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC22053ub1, 0).getValue());
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarJ;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.Wl7$f */
    public static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC23241wb3 g;
        final /* synthetic */ InterfaceC7614Sl7 h;
        final /* synthetic */ float i;
        final /* synthetic */ float j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z, boolean z2, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC7614Sl7 interfaceC7614Sl7, float f, float f2) {
            super(1);
            this.e = z;
            this.f = z2;
            this.g = interfaceC23241wb3;
            this.h = interfaceC7614Sl7;
            this.i = f;
            this.j = f2;
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

    private C8555Wl7() {
    }

    public static /* synthetic */ TS4 l(C8555Wl7 c8555Wl7, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = AbstractC11925dm7.f();
        }
        if ((i & 2) != 0) {
            f3 = AbstractC11925dm7.f();
        }
        if ((i & 4) != 0) {
            f4 = AbstractC11925dm7.f();
        }
        if ((i & 8) != 0) {
            f5 = AbstractC11925dm7.f();
        }
        return c8555Wl7.k(f2, f3, f4, f5);
    }

    public static /* synthetic */ TS4 o(C8555Wl7 c8555Wl7, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = AbstractC11925dm7.f();
        }
        if ((i & 2) != 0) {
            f3 = AbstractC11925dm7.f();
        }
        if ((i & 4) != 0) {
            f4 = AbstractC14965im7.k();
        }
        if ((i & 8) != 0) {
            f5 = AbstractC14965im7.l();
        }
        return c8555Wl7.n(f2, f3, f4, f5);
    }

    public static /* synthetic */ TS4 q(C8555Wl7 c8555Wl7, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = AbstractC11925dm7.f();
        }
        if ((i & 2) != 0) {
            f3 = AbstractC11925dm7.f();
        }
        if ((i & 4) != 0) {
            f4 = AbstractC11925dm7.f();
        }
        if ((i & 8) != 0) {
            f5 = AbstractC11925dm7.f();
        }
        return c8555Wl7.p(f2, f3, f4, f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r19, boolean r20, ir.nasim.InterfaceC23241wb3 r21, ir.nasim.InterfaceC7614Sl7 r22, ir.nasim.InterfaceC10031ax6 r23, float r24, float r25, ir.nasim.InterfaceC22053ub1 r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8555Wl7.a(boolean, boolean, ir.nasim.wb3, ir.nasim.Sl7, ir.nasim.ax6, float, float, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r60, ir.nasim.InterfaceC14603iB2 r61, boolean r62, boolean r63, ir.nasim.QY7 r64, ir.nasim.InterfaceC23241wb3 r65, boolean r66, ir.nasim.InterfaceC14603iB2 r67, ir.nasim.InterfaceC14603iB2 r68, ir.nasim.InterfaceC14603iB2 r69, ir.nasim.InterfaceC14603iB2 r70, ir.nasim.InterfaceC10031ax6 r71, ir.nasim.InterfaceC7614Sl7 r72, ir.nasim.TS4 r73, ir.nasim.InterfaceC14603iB2 r74, ir.nasim.InterfaceC22053ub1 r75, int r76, int r77, int r78) {
        /*
            Method dump skipped, instructions count: 1027
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8555Wl7.b(java.lang.String, ir.nasim.iB2, boolean, boolean, ir.nasim.QY7, ir.nasim.wb3, boolean, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.ax6, ir.nasim.Sl7, ir.nasim.TS4, ir.nasim.iB2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.String r61, ir.nasim.InterfaceC14603iB2 r62, boolean r63, boolean r64, ir.nasim.QY7 r65, ir.nasim.InterfaceC23241wb3 r66, boolean r67, ir.nasim.InterfaceC14603iB2 r68, ir.nasim.InterfaceC14603iB2 r69, ir.nasim.InterfaceC14603iB2 r70, ir.nasim.InterfaceC14603iB2 r71, ir.nasim.InterfaceC10031ax6 r72, ir.nasim.InterfaceC7614Sl7 r73, ir.nasim.TS4 r74, ir.nasim.InterfaceC22053ub1 r75, int r76, int r77, int r78) {
        /*
            Method dump skipped, instructions count: 967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8555Wl7.c(java.lang.String, ir.nasim.iB2, boolean, boolean, ir.nasim.QY7, ir.nasim.wb3, boolean, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.ax6, ir.nasim.Sl7, ir.nasim.TS4, ir.nasim.ub1, int, int, int):void");
    }

    public final float d() {
        return b;
    }

    public final float e() {
        return c;
    }

    public final InterfaceC10031ax6 f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1899109048, i, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:227)");
        }
        AbstractC8333Vn1 abstractC8333Vn1E = C15977kV3.a.b(interfaceC22053ub1, 6).e();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return abstractC8333Vn1E;
    }

    public final InterfaceC10031ax6 g(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1117199624, i, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:220)");
        }
        AbstractC8333Vn1 abstractC8333Vn1D = AbstractC8333Vn1.d(C15977kV3.a.b(interfaceC22053ub1, 6).e(), null, null, AbstractC10554bo1.d(), AbstractC10554bo1.d(), 3, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return abstractC8333Vn1D;
    }

    public final androidx.compose.ui.e h(androidx.compose.ui.e eVar, boolean z, boolean z2, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC7614Sl7 interfaceC7614Sl7, float f2, float f3) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new f(z, z2, interfaceC23241wb3, interfaceC7614Sl7, f2, f3) : Q93.a(), new e(z, z2, interfaceC23241wb3, interfaceC7614Sl7, f2, f3));
    }

    public final InterfaceC7614Sl7 j(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2, int i3, int i4) {
        long j22;
        long jO;
        long j23;
        int i5;
        long jD;
        long j24;
        long jO2;
        long j25;
        long jO3;
        long j26;
        long jO4;
        long j27;
        int i6;
        long jD2;
        long j28;
        long jO5;
        long j29;
        long jO6;
        long j30;
        int i7;
        long jD3;
        long j31;
        long j32;
        long jO7 = (i4 & 1) != 0 ? C24381yX0.o(((C24381yX0) interfaceC22053ub1.H(AbstractC20866sk1.a())).y(), ((Number) interfaceC22053ub1.H(AbstractC16711lk1.a())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        long jO8 = (i4 & 2) != 0 ? C24381yX0.o(jO7, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jH = (i4 & 4) != 0 ? C24381yX0.b.h() : j3;
        long j33 = (i4 & 8) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).j() : j4;
        long jD4 = (i4 & 16) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).d() : j5;
        long jO9 = (i4 & 32) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).j(), C16120kk1.a.c(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if ((i4 & 64) != 0) {
            j22 = jH;
            jO = C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j22 = jH;
            jO = j7;
        }
        long jO10 = (i4 & 128) != 0 ? C24381yX0.o(jO, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if ((i4 & 256) != 0) {
            j23 = jO10;
            i5 = 6;
            jD = C15977kV3.a.a(interfaceC22053ub1, 6).d();
        } else {
            j23 = jO10;
            i5 = 6;
            jD = j9;
        }
        long jO11 = (i4 & 512) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, i5).i(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            j24 = jO;
            jO2 = C24381yX0.o(jO11, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j24 = jO;
            jO2 = j11;
        }
        long j34 = (i4 & 2048) != 0 ? jO11 : j12;
        if ((i4 & 4096) != 0) {
            j25 = jO2;
            jO3 = C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j25 = jO2;
            jO3 = j13;
        }
        if ((i4 & 8192) != 0) {
            j26 = jO11;
            jO4 = C24381yX0.o(jO3, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j26 = jO11;
            jO4 = j14;
        }
        if ((i4 & 16384) != 0) {
            j27 = jO4;
            i6 = 6;
            jD2 = C15977kV3.a.a(interfaceC22053ub1, 6).d();
        } else {
            j27 = jO4;
            i6 = 6;
            jD2 = j15;
        }
        long jO12 = (32768 & i4) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, i6).j(), C16120kk1.a.c(interfaceC22053ub1, i6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        if ((65536 & i4) != 0) {
            j28 = jO12;
            jO5 = C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), C16120kk1.a.d(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j28 = jO12;
            jO5 = j17;
        }
        if ((131072 & i4) != 0) {
            j29 = jO3;
            jO6 = C24381yX0.o(jO5, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j29 = jO3;
            jO6 = j18;
        }
        if ((262144 & i4) != 0) {
            j30 = jO6;
            i7 = 6;
            jD3 = C15977kV3.a.a(interfaceC22053ub1, 6).d();
        } else {
            j30 = jO6;
            i7 = 6;
            jD3 = j19;
        }
        long jO13 = (524288 & i4) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, i7).i(), C16120kk1.a.d(interfaceC22053ub1, i7), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long jO14 = (i4 & 1048576) != 0 ? C24381yX0.o(jO13, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if (AbstractC5138Ib1.I()) {
            j31 = jO14;
            j32 = jO13;
            AbstractC5138Ib1.Q(1762667317, i, i2, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:462)");
        } else {
            j31 = jO14;
            j32 = jO13;
        }
        EF1 ef1 = new EF1(jO7, jO8, j33, jD4, jO9, j24, jD, j23, j26, j25, j34, j29, j27, jD2, j22, j28, jO5, j30, jD3, j32, j31, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return ef1;
    }

    public final TS4 k(float f2, float f3, float f4, float f5) {
        return androidx.compose.foundation.layout.q.d(f2, f3, f4, f5);
    }

    public final InterfaceC7614Sl7 m(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2, int i3, int i4) {
        long j22;
        long jO;
        long j23;
        int i5;
        long jD;
        long j24;
        long jO2;
        long j25;
        long jO3;
        long j26;
        long jO4;
        long j27;
        int i6;
        long jD2;
        long j28;
        long jO5;
        long j29;
        long jO6;
        long j30;
        int i7;
        long jD3;
        long j31;
        long j32;
        long jO7 = (i4 & 1) != 0 ? C24381yX0.o(((C24381yX0) interfaceC22053ub1.H(AbstractC20866sk1.a())).y(), ((Number) interfaceC22053ub1.H(AbstractC16711lk1.a())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        long jO8 = (i4 & 2) != 0 ? C24381yX0.o(jO7, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jO9 = (i4 & 4) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j33 = (i4 & 8) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).j() : j4;
        long jD4 = (i4 & 16) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).d() : j5;
        long jO10 = (i4 & 32) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).j(), C16120kk1.a.c(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jO11 = (i4 & 64) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            j22 = jO9;
            jO = C24381yX0.o(jO11, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j22 = jO9;
            jO = j8;
        }
        if ((i4 & 256) != 0) {
            j23 = jO;
            i5 = 6;
            jD = C15977kV3.a.a(interfaceC22053ub1, 6).d();
        } else {
            j23 = jO;
            i5 = 6;
            jD = j9;
        }
        long jO12 = (i4 & 512) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, i5).i(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            j24 = jO11;
            jO2 = C24381yX0.o(jO12, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j24 = jO11;
            jO2 = j11;
        }
        long j34 = (i4 & 2048) != 0 ? jO12 : j12;
        if ((i4 & 4096) != 0) {
            j25 = jO2;
            jO3 = C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j25 = jO2;
            jO3 = j13;
        }
        if ((i4 & 8192) != 0) {
            j26 = jO12;
            jO4 = C24381yX0.o(jO3, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j26 = jO12;
            jO4 = j14;
        }
        if ((i4 & 16384) != 0) {
            j27 = jO4;
            i6 = 6;
            jD2 = C15977kV3.a.a(interfaceC22053ub1, 6).d();
        } else {
            j27 = jO4;
            i6 = 6;
            jD2 = j15;
        }
        long jO13 = (32768 & i4) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, i6).j(), C16120kk1.a.c(interfaceC22053ub1, i6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        if ((65536 & i4) != 0) {
            j28 = jO13;
            jO5 = C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), C16120kk1.a.d(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j28 = jO13;
            jO5 = j17;
        }
        if ((131072 & i4) != 0) {
            j29 = jO3;
            jO6 = C24381yX0.o(jO5, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j29 = jO3;
            jO6 = j18;
        }
        if ((262144 & i4) != 0) {
            j30 = jO6;
            i7 = 6;
            jD3 = C15977kV3.a.a(interfaceC22053ub1, 6).d();
        } else {
            j30 = jO6;
            i7 = 6;
            jD3 = j19;
        }
        long jO14 = (524288 & i4) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, i7).i(), C16120kk1.a.d(interfaceC22053ub1, i7), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long jO15 = (i4 & 1048576) != 0 ? C24381yX0.o(jO14, C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if (AbstractC5138Ib1.I()) {
            j31 = jO15;
            j32 = jO14;
            AbstractC5138Ib1.Q(231892599, i, i2, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:408)");
        } else {
            j31 = jO15;
            j32 = jO14;
        }
        EF1 ef1 = new EF1(jO7, jO8, j33, jD4, jO10, j24, jD, j23, j26, j25, j34, j29, j27, jD2, j22, j28, jO5, j30, jD3, j32, j31, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return ef1;
    }

    public final TS4 n(float f2, float f3, float f4, float f5) {
        return androidx.compose.foundation.layout.q.d(f2, f4, f3, f5);
    }

    public final TS4 p(float f2, float f3, float f4, float f5) {
        return androidx.compose.foundation.layout.q.d(f2, f3, f4, f5);
    }
}
