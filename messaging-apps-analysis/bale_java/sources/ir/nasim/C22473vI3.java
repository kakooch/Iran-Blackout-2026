package ir.nasim;

/* renamed from: ir.nasim.vI3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22473vI3 {
    private static final C22473vI3 c = new a().a();
    private final long a;
    private final b b;

    /* renamed from: ir.nasim.vI3$a */
    public static final class a {
        private long a = 0;
        private b b = b.REASON_UNKNOWN;

        a() {
        }

        public C22473vI3 a() {
            return new C22473vI3(this.a, this.b);
        }

        public a b(long j) {
            this.a = j;
            return this;
        }

        public a c(b bVar) {
            this.b = bVar;
            return this;
        }
    }

    /* renamed from: ir.nasim.vI3$b */
    public enum b implements InterfaceC18026nx5 {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // ir.nasim.InterfaceC18026nx5
        public int getNumber() {
            return this.a;
        }
    }

    C22473vI3(long j, b bVar) {
        this.a = j;
        this.b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }
}
