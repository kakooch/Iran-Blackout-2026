package ir.nasim;

/* renamed from: ir.nasim.Jw6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5566Jw6 {
    public static final a d = new a(null);
    private static final C5566Jw6 e = new C5566Jw6(0, 0, 0.0f, 7, null);
    private final long a;
    private final long b;
    private final float c;

    /* renamed from: ir.nasim.Jw6$a */
    public static final class a {
        private a() {
        }

        public final C5566Jw6 a() {
            return C5566Jw6.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C5566Jw6(long j, long j2, float f, ED1 ed1) {
        this(j, j2, f);
    }

    public final float b() {
        return this.c;
    }

    public final long c() {
        return this.a;
    }

    public final long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5566Jw6)) {
            return false;
        }
        C5566Jw6 c5566Jw6 = (C5566Jw6) obj;
        return C24381yX0.q(this.a, c5566Jw6.a) && ZG4.j(this.b, c5566Jw6.b) && this.c == c5566Jw6.c;
    }

    public int hashCode() {
        return (((C24381yX0.w(this.a) * 31) + ZG4.o(this.b)) * 31) + Float.hashCode(this.c);
    }

    public String toString() {
        return "Shadow(color=" + ((Object) C24381yX0.x(this.a)) + ", offset=" + ((Object) ZG4.s(this.b)) + ", blurRadius=" + this.c + ')';
    }

    private C5566Jw6(long j, long j2, float f) {
        this.a = j;
        this.b = j2;
        this.c = f;
    }

    public /* synthetic */ C5566Jw6(long j, long j2, float f, int i, ED1 ed1) {
        this((i & 1) != 0 ? DX0.d(4278190080L) : j, (i & 2) != 0 ? ZG4.b.c() : j2, (i & 4) != 0 ? 0.0f : f, null);
    }
}
