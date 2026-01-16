package ir.nasim;

/* renamed from: ir.nasim.sZ1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20757sZ1 {
    public static final a f = new a(null);
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final boolean e;

    /* renamed from: ir.nasim.sZ1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C20757sZ1(float f2, float f3, float f4, float f5, boolean z, ED1 ed1) {
        this(f2, f3, f4, f5, z);
    }

    public final long a(WH1 wh1) {
        return AbstractC15034it7.d(AbstractC15034it7.a.c(wh1.B0(this.a), wh1.B0(this.b), wh1.B0(this.c), wh1.B0(this.d), this.e));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20757sZ1)) {
            return false;
        }
        C20757sZ1 c20757sZ1 = (C20757sZ1) obj;
        return C17784nZ1.s(this.a, c20757sZ1.a) && C17784nZ1.s(this.b, c20757sZ1.b) && C17784nZ1.s(this.c, c20757sZ1.c) && C17784nZ1.s(this.d, c20757sZ1.d) && this.e == c20757sZ1.e;
    }

    public int hashCode() {
        return (((((((C17784nZ1.t(this.a) * 31) + C17784nZ1.t(this.b)) * 31) + C17784nZ1.t(this.c)) * 31) + C17784nZ1.t(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "DpTouchBoundsExpansion(start=" + ((Object) C17784nZ1.u(this.a)) + ", top=" + ((Object) C17784nZ1.u(this.b)) + ", end=" + ((Object) C17784nZ1.u(this.c)) + ", bottom=" + ((Object) C17784nZ1.u(this.d)) + ", isLayoutDirectionAware=" + this.e + ')';
    }

    private C20757sZ1(float f2, float f3, float f4, float f5, boolean z) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = z;
        if (!(f2 >= 0.0f)) {
            M73.a("Left must be non-negative");
        }
        if (!(f3 >= 0.0f)) {
            M73.a("Top must be non-negative");
        }
        if (!(f4 >= 0.0f)) {
            M73.a("Right must be non-negative");
        }
        if (f5 >= 0.0f) {
            return;
        }
        M73.a("Bottom must be non-negative");
    }
}
