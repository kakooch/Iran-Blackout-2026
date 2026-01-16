package ir.nasim;

/* renamed from: ir.nasim.Bm7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3590Bm7 {
    public static final a c = new a(null);
    private static final C3590Bm7 d = new C3590Bm7(1.0f, 0.0f);
    private final float a;
    private final float b;

    /* renamed from: ir.nasim.Bm7$a */
    public static final class a {
        private a() {
        }

        public final C3590Bm7 a() {
            return C3590Bm7.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C3590Bm7(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public final float b() {
        return this.a;
    }

    public final float c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3590Bm7)) {
            return false;
        }
        C3590Bm7 c3590Bm7 = (C3590Bm7) obj;
        return this.a == c3590Bm7.a && this.b == c3590Bm7.b;
    }

    public int hashCode() {
        return (Float.hashCode(this.a) * 31) + Float.hashCode(this.b);
    }

    public String toString() {
        return "TextGeometricTransform(scaleX=" + this.a + ", skewX=" + this.b + ')';
    }
}
