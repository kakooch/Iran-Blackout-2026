package ir.nasim;

/* renamed from: ir.nasim.iB7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14612iB7 {
    private final int a;
    private a b;
    private a c;
    private int d;
    private Long e;
    private boolean f;

    /* renamed from: ir.nasim.iB7$a */
    private static final class a {
        private a a;
        private C23945xm7 b;

        public a(a aVar, C23945xm7 c23945xm7) {
            this.a = aVar;
            this.b = c23945xm7;
        }

        public final a a() {
            return this.a;
        }

        public final C23945xm7 b() {
            return this.b;
        }

        public final void c(a aVar) {
            this.a = aVar;
        }

        public final void d(C23945xm7 c23945xm7) {
            this.b = c23945xm7;
        }
    }

    public C14612iB7(int i) {
        this.a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void d() {
        /*
            r3 = this;
            ir.nasim.iB7$a r0 = r3.b
            r1 = 0
            if (r0 == 0) goto La
            ir.nasim.iB7$a r2 = r0.a()
            goto Lb
        La:
            r2 = r1
        Lb:
            if (r2 != 0) goto Le
            return
        Le:
            if (r0 == 0) goto L1b
            ir.nasim.iB7$a r2 = r0.a()
            if (r2 == 0) goto L1b
            ir.nasim.iB7$a r2 = r2.a()
            goto L1c
        L1b:
            r2 = r1
        L1c:
            if (r2 == 0) goto L23
            ir.nasim.iB7$a r0 = r0.a()
            goto Le
        L23:
            if (r0 != 0) goto L26
            goto L29
        L26:
            r0.c(r1)
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14612iB7.d():void");
    }

    public static /* synthetic */ void f(C14612iB7 c14612iB7, C23945xm7 c23945xm7, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = AbstractC15801kB7.a();
        }
        c14612iB7.e(c23945xm7, j);
    }

    public final void a() {
        this.f = true;
    }

    public final void b(C23945xm7 c23945xm7) {
        C23945xm7 c23945xm7B;
        this.f = false;
        a aVar = this.b;
        if (AbstractC13042fc3.d(c23945xm7, aVar != null ? aVar.b() : null)) {
            return;
        }
        String strH = c23945xm7.h();
        a aVar2 = this.b;
        if (AbstractC13042fc3.d(strH, (aVar2 == null || (c23945xm7B = aVar2.b()) == null) ? null : c23945xm7B.h())) {
            a aVar3 = this.b;
            if (aVar3 == null) {
                return;
            }
            aVar3.d(c23945xm7);
            return;
        }
        this.b = new a(this.b, c23945xm7);
        this.c = null;
        int length = this.d + c23945xm7.h().length();
        this.d = length;
        if (length > this.a) {
            d();
        }
    }

    public final C23945xm7 c() {
        a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        this.c = aVar.a();
        this.b = new a(this.b, aVar.b());
        this.d += aVar.b().h().length();
        return aVar.b();
    }

    public final void e(C23945xm7 c23945xm7, long j) {
        if (!this.f) {
            Long l = this.e;
            if (j <= (l != null ? l.longValue() : 0L) + AbstractC15210jB7.a()) {
                return;
            }
        }
        this.e = Long.valueOf(j);
        b(c23945xm7);
    }

    public final C23945xm7 g() {
        a aVarA;
        a aVar = this.b;
        if (aVar == null || (aVarA = aVar.a()) == null) {
            return null;
        }
        this.b = aVarA;
        this.d -= aVar.b().h().length();
        this.c = new a(this.c, aVar.b());
        return aVarA.b();
    }

    public /* synthetic */ C14612iB7(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 100000 : i);
    }
}
