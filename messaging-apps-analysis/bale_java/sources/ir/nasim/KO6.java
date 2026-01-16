package ir.nasim;

/* loaded from: classes2.dex */
public final class KO6 {
    private static final KO6 c = new a().a();
    private final long a;
    private final long b;

    public static final class a {
        private long a = 0;
        private long b = 0;

        a() {
        }

        public KO6 a() {
            return new KO6(this.a, this.b);
        }

        public a b(long j) {
            this.a = j;
            return this;
        }

        public a c(long j) {
            this.b = j;
            return this;
        }
    }

    KO6(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }
}
