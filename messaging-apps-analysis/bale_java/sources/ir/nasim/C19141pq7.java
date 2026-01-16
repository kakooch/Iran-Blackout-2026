package ir.nasim;

/* renamed from: ir.nasim.pq7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19141pq7 {
    private static final C19141pq7 c = new a().a();
    private final long a;
    private final long b;

    /* renamed from: ir.nasim.pq7$a */
    public static final class a {
        private long a = 0;
        private long b = 0;

        a() {
        }

        public C19141pq7 a() {
            return new C19141pq7(this.a, this.b);
        }

        public a b(long j) {
            this.b = j;
            return this;
        }

        public a c(long j) {
            this.a = j;
            return this;
        }
    }

    C19141pq7(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }
}
