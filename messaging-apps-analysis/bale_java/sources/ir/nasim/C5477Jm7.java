package ir.nasim;

/* renamed from: ir.nasim.Jm7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5477Jm7 {
    public static final a c = new a(null);
    private static final C5477Jm7 d = new C5477Jm7(0, 0, 3, null);
    private final long a;
    private final long b;

    /* renamed from: ir.nasim.Jm7$a */
    public static final class a {
        private a() {
        }

        public final C5477Jm7 a() {
            return C5477Jm7.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C5477Jm7(long j, long j2, ED1 ed1) {
        this(j, j2);
    }

    public final long b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5477Jm7)) {
            return false;
        }
        C5477Jm7 c5477Jm7 = (C5477Jm7) obj;
        return C13193fo7.e(this.a, c5477Jm7.a) && C13193fo7.e(this.b, c5477Jm7.b);
    }

    public int hashCode() {
        return (C13193fo7.i(this.a) * 31) + C13193fo7.i(this.b);
    }

    public String toString() {
        return "TextIndent(firstLine=" + ((Object) C13193fo7.j(this.a)) + ", restLine=" + ((Object) C13193fo7.j(this.b)) + ')';
    }

    private C5477Jm7(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public /* synthetic */ C5477Jm7(long j, long j2, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC13784go7.g(0) : j, (i & 2) != 0 ? AbstractC13784go7.g(0) : j2, null);
    }
}
