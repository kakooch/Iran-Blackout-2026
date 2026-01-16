package ir.nasim;

/* loaded from: classes.dex */
public class AY7 implements QB0 {
    private final QB0 a;
    private final C14935ij7 b;
    private final long c;

    public AY7(C14935ij7 c14935ij7, QB0 qb0) {
        this(qb0, c14935ij7, -1L);
    }

    @Override // ir.nasim.QB0
    public C14935ij7 b() {
        return this.b;
    }

    @Override // ir.nasim.QB0
    public PB0 c() {
        QB0 qb0 = this.a;
        return qb0 != null ? qb0.c() : PB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public NB0 e() {
        QB0 qb0 = this.a;
        return qb0 != null ? qb0.e() : NB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public OB0 f() {
        QB0 qb0 = this.a;
        return qb0 != null ? qb0.f() : OB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public MB0 g() {
        QB0 qb0 = this.a;
        return qb0 != null ? qb0.g() : MB0.UNKNOWN;
    }

    @Override // ir.nasim.QB0
    public long getTimestamp() {
        QB0 qb0 = this.a;
        if (qb0 != null) {
            return qb0.getTimestamp();
        }
        long j = this.c;
        if (j != -1) {
            return j;
        }
        throw new IllegalStateException("No timestamp is available.");
    }

    public AY7(C14935ij7 c14935ij7, long j) {
        this(null, c14935ij7, j);
    }

    private AY7(QB0 qb0, C14935ij7 c14935ij7, long j) {
        this.a = qb0;
        this.b = c14935ij7;
        this.c = j;
    }
}
