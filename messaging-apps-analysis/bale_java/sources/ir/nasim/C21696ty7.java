package ir.nasim;

/* renamed from: ir.nasim.ty7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21696ty7 {
    public static final a k = new a(null);
    public static final C21696ty7 l;
    public static final C21696ty7 m;
    public static final C21696ty7 n;
    public static final C21696ty7 o;
    public static final C21696ty7 p;
    public static final C21696ty7 q;
    public static final C21696ty7 r;
    public static final C21696ty7 s;
    public static final C21696ty7 t;
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final C21696ty7 f;
    private final boolean g;
    private final C21696ty7 h;
    private final C21696ty7 i;
    private final boolean j;

    /* renamed from: ir.nasim.ty7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ty7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KQ7.valuesCustom().length];
            iArr[KQ7.IN_VARIANCE.ordinal()] = 1;
            iArr[KQ7.INVARIANT.ordinal()] = 2;
            a = iArr;
        }
    }

    static {
        ED1 ed1 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        C21696ty7 c21696ty7 = null;
        boolean z5 = false;
        C21696ty7 c21696ty72 = null;
        C21696ty7 c21696ty73 = null;
        boolean z6 = false;
        C21696ty7 c21696ty74 = new C21696ty7(z, false, z2, z3, z4, c21696ty7, z5, c21696ty72, c21696ty73, z6, 1023, ed1);
        l = c21696ty74;
        ED1 ed12 = null;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        C21696ty7 c21696ty75 = null;
        C21696ty7 c21696ty76 = null;
        boolean z13 = true;
        C21696ty7 c21696ty77 = new C21696ty7(z7, z8, z9, z10, z11, null, z12, c21696ty75, c21696ty76, z13, 511, ed12);
        m = c21696ty77;
        n = new C21696ty7(z, true, z2, z3, z4, c21696ty7, z5, c21696ty72, c21696ty73, z6, 1021, ed1);
        int i = 988;
        o = new C21696ty7(z, false, z2, z3, z4, c21696ty74, z5, c21696ty72, c21696ty73, z6, i, ed1);
        p = new C21696ty7(z7, z8, z9, z10, z11, c21696ty77, z12, c21696ty75, c21696ty76, z13, 476, ed12);
        q = new C21696ty7(z, true, z2, z3, z4, c21696ty74, z5, c21696ty72, c21696ty73, z6, i, ed1);
        boolean z14 = false;
        boolean z15 = true;
        r = new C21696ty7(z, z14, z2, z15, z4, c21696ty74, z5, c21696ty72, c21696ty73, z6, 983, ed1);
        s = new C21696ty7(z, z14, z2, z15, z4, c21696ty74, z5, c21696ty72, c21696ty73, z6, 919, ed1);
        t = new C21696ty7(z, z14, true, false, z4, c21696ty74, z5, c21696ty72, c21696ty73, z6, 984, ed1);
    }

    public C21696ty7(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, C21696ty7 c21696ty7, boolean z6, C21696ty7 c21696ty72, C21696ty7 c21696ty73, boolean z7) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = c21696ty7;
        this.g = z6;
        this.h = c21696ty72;
        this.i = c21696ty73;
        this.j = z7;
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.j;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    public final C21696ty7 f(KQ7 kq7, boolean z) {
        AbstractC13042fc3.i(kq7, "effectiveVariance");
        if (!z || !this.c) {
            int i = b.a[kq7.ordinal()];
            if (i == 1) {
                C21696ty7 c21696ty7 = this.h;
                if (c21696ty7 != null) {
                    return c21696ty7;
                }
            } else if (i != 2) {
                C21696ty7 c21696ty72 = this.f;
                if (c21696ty72 != null) {
                    return c21696ty72;
                }
            } else {
                C21696ty7 c21696ty73 = this.i;
                if (c21696ty73 != null) {
                    return c21696ty73;
                }
            }
        }
        return this;
    }

    public final C21696ty7 g() {
        return new C21696ty7(this.a, true, this.c, this.d, this.e, this.f, this.g, this.h, this.i, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C21696ty7(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, C21696ty7 c21696ty7, boolean z6, C21696ty7 c21696ty72, C21696ty7 c21696ty73, boolean z7, int i, ED1 ed1) {
        boolean z8 = (i & 1) != 0 ? true : z;
        boolean z9 = (i & 2) != 0 ? true : z2;
        boolean z10 = (i & 4) != 0 ? false : z3;
        boolean z11 = (i & 8) != 0 ? false : z4;
        boolean z12 = (i & 16) != 0 ? false : z5;
        C21696ty7 c21696ty74 = (i & 32) != 0 ? null : c21696ty7;
        this(z8, z9, z10, z11, z12, c21696ty74, (i & 64) == 0 ? z6 : true, (i & 128) != 0 ? c21696ty74 : c21696ty72, (i & 256) != 0 ? c21696ty74 : c21696ty73, (i & 512) == 0 ? z7 : false);
    }
}
