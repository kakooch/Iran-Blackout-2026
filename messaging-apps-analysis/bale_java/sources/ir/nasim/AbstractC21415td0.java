package ir.nasim;

/* renamed from: ir.nasim.td0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC21415td0 {
    private static final InterfaceC8321Vl7 a = h.a;
    private static final long b;

    /* renamed from: ir.nasim.td0$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C23945xm7 e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C23945xm7 c23945xm7, UA2 ua2) {
            super(1);
            this.e = c23945xm7;
            this.f = ua2;
        }

        public final void a(C23945xm7 c23945xm7) {
            if (AbstractC13042fc3.d(this.e, c23945xm7)) {
                return;
            }
            this.f.invoke(c23945xm7);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C23945xm7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.td0$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C23945xm7 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ C9348Zn7 j;
        final /* synthetic */ C21605tp3 k;
        final /* synthetic */ C11329cp3 l;
        final /* synthetic */ boolean m;
        final /* synthetic */ int n;
        final /* synthetic */ int o;
        final /* synthetic */ QY7 p;
        final /* synthetic */ UA2 q;
        final /* synthetic */ InterfaceC18507om4 r;
        final /* synthetic */ AbstractC12520el0 s;
        final /* synthetic */ InterfaceC15796kB2 t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;
        final /* synthetic */ int w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C23945xm7 c23945xm7, UA2 ua2, androidx.compose.ui.e eVar, boolean z, boolean z2, C9348Zn7 c9348Zn7, C21605tp3 c21605tp3, C11329cp3 c11329cp3, boolean z3, int i, int i2, QY7 qy7, UA2 ua22, InterfaceC18507om4 interfaceC18507om4, AbstractC12520el0 abstractC12520el0, InterfaceC15796kB2 interfaceC15796kB2, int i3, int i4, int i5) {
            super(2);
            this.e = c23945xm7;
            this.f = ua2;
            this.g = eVar;
            this.h = z;
            this.i = z2;
            this.j = c9348Zn7;
            this.k = c21605tp3;
            this.l = c11329cp3;
            this.m = z3;
            this.n = i;
            this.o = i2;
            this.p = qy7;
            this.q = ua22;
            this.r = interfaceC18507om4;
            this.s = abstractC12520el0;
            this.t = interfaceC15796kB2;
            this.u = i3;
            this.v = i4;
            this.w = i5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC21415td0.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, interfaceC22053ub1, QJ5.a(this.u | 1), QJ5.a(this.v), this.w);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.td0$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C23945xm7 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C23945xm7 c23945xm7, InterfaceC9102Ym4 interfaceC9102Ym4) {
            super(0);
            this.e = c23945xm7;
            this.f = interfaceC9102Ym4;
        }

        public final void a() {
            if (C4301En7.g(this.e.g(), AbstractC21415td0.c(this.f).g()) && AbstractC13042fc3.d(this.e.f(), AbstractC21415td0.c(this.f).f())) {
                return;
            }
            AbstractC21415td0.d(this.f, this.e);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.td0$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ InterfaceC9102Ym4 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
            super(1);
            this.e = ua2;
            this.f = interfaceC9102Ym4;
            this.g = interfaceC9102Ym42;
        }

        public final void a(C23945xm7 c23945xm7) {
            AbstractC21415td0.d(this.f, c23945xm7);
            boolean z = !AbstractC13042fc3.d(AbstractC21415td0.e(this.g), c23945xm7.h());
            AbstractC21415td0.f(this.g, c23945xm7.h());
            if (z) {
                this.e.invoke(c23945xm7.h());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C23945xm7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.td0$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ C9348Zn7 j;
        final /* synthetic */ C21605tp3 k;
        final /* synthetic */ C11329cp3 l;
        final /* synthetic */ boolean m;
        final /* synthetic */ int n;
        final /* synthetic */ int o;
        final /* synthetic */ QY7 p;
        final /* synthetic */ UA2 q;
        final /* synthetic */ InterfaceC18507om4 r;
        final /* synthetic */ AbstractC12520el0 s;
        final /* synthetic */ InterfaceC15796kB2 t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;
        final /* synthetic */ int w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, UA2 ua2, androidx.compose.ui.e eVar, boolean z, boolean z2, C9348Zn7 c9348Zn7, C21605tp3 c21605tp3, C11329cp3 c11329cp3, boolean z3, int i, int i2, QY7 qy7, UA2 ua22, InterfaceC18507om4 interfaceC18507om4, AbstractC12520el0 abstractC12520el0, InterfaceC15796kB2 interfaceC15796kB2, int i3, int i4, int i5) {
            super(2);
            this.e = str;
            this.f = ua2;
            this.g = eVar;
            this.h = z;
            this.i = z2;
            this.j = c9348Zn7;
            this.k = c21605tp3;
            this.l = c11329cp3;
            this.m = z3;
            this.n = i;
            this.o = i2;
            this.p = qy7;
            this.q = ua22;
            this.r = interfaceC18507om4;
            this.s = abstractC12520el0;
            this.t = interfaceC15796kB2;
            this.u = i3;
            this.v = i4;
            this.w = i5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC21415td0.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, interfaceC22053ub1, QJ5.a(this.u | 1), QJ5.a(this.v), this.w);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.td0$h */
    static final class h implements InterfaceC8321Vl7 {
        public static final h a = new h();

        h() {
        }
    }

    static {
        float f2 = 40;
        b = AbstractC18966pZ1.b(C17784nZ1.q(f2), C17784nZ1.q(f2));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:266:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.C23945xm7 r38, ir.nasim.UA2 r39, androidx.compose.ui.e r40, boolean r41, boolean r42, ir.nasim.C9348Zn7 r43, ir.nasim.C21605tp3 r44, ir.nasim.C11329cp3 r45, boolean r46, int r47, int r48, ir.nasim.QY7 r49, ir.nasim.UA2 r50, ir.nasim.InterfaceC18507om4 r51, ir.nasim.AbstractC12520el0 r52, ir.nasim.InterfaceC15796kB2 r53, ir.nasim.InterfaceC22053ub1 r54, int r55, int r56, int r57) {
        /*
            Method dump skipped, instructions count: 1061
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21415td0.a(ir.nasim.xm7, ir.nasim.UA2, androidx.compose.ui.e, boolean, boolean, ir.nasim.Zn7, ir.nasim.tp3, ir.nasim.cp3, boolean, int, int, ir.nasim.QY7, ir.nasim.UA2, ir.nasim.om4, ir.nasim.el0, ir.nasim.kB2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:285:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(java.lang.String r42, ir.nasim.UA2 r43, androidx.compose.ui.e r44, boolean r45, boolean r46, ir.nasim.C9348Zn7 r47, ir.nasim.C21605tp3 r48, ir.nasim.C11329cp3 r49, boolean r50, int r51, int r52, ir.nasim.QY7 r53, ir.nasim.UA2 r54, ir.nasim.InterfaceC18507om4 r55, ir.nasim.AbstractC12520el0 r56, ir.nasim.InterfaceC15796kB2 r57, ir.nasim.InterfaceC22053ub1 r58, int r59, int r60, int r61) {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21415td0.b(java.lang.String, ir.nasim.UA2, androidx.compose.ui.e, boolean, boolean, ir.nasim.Zn7, ir.nasim.tp3, ir.nasim.cp3, boolean, int, int, ir.nasim.QY7, ir.nasim.UA2, ir.nasim.om4, ir.nasim.el0, ir.nasim.kB2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23945xm7 c(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (C23945xm7) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, C23945xm7 c23945xm7) {
        interfaceC9102Ym4.setValue(c23945xm7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* renamed from: ir.nasim.td0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13774gn7) obj);
            return C19938rB7.a;
        }

        public final void a(C13774gn7 c13774gn7) {
        }
    }

    /* renamed from: ir.nasim.td0$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13774gn7) obj);
            return C19938rB7.a;
        }

        public final void a(C13774gn7 c13774gn7) {
        }
    }
}
