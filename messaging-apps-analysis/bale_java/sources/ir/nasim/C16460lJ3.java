package ir.nasim;

/* renamed from: ir.nasim.lJ3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C16460lJ3 implements Iterable, InterfaceC17915nm3 {
    public static final a d = new a(null);
    private final long a;
    private final long b;
    private final long c;

    /* renamed from: ir.nasim.lJ3$a */
    public static final class a {
        private a() {
        }

        public final C16460lJ3 a(long j, long j2, long j3) {
            return new C16460lJ3(j, j2, j3);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C16460lJ3(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = j;
        this.b = AbstractC16234kv5.d(j, j2, j3);
        this.c = j3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C16460lJ3) {
            if (!isEmpty() || !((C16460lJ3) obj).isEmpty()) {
                C16460lJ3 c16460lJ3 = (C16460lJ3) obj;
                if (this.a != c16460lJ3.a || this.b != c16460lJ3.b || this.c != c16460lJ3.c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = 31;
        long j2 = this.a;
        long j3 = this.b;
        long j4 = j * (((j2 ^ (j2 >>> 32)) * j) + (j3 ^ (j3 >>> 32)));
        long j5 = this.c;
        return (int) (j4 + (j5 ^ (j5 >>> 32)));
    }

    public boolean isEmpty() {
        long j = this.c;
        long j2 = this.a;
        long j3 = this.b;
        if (j > 0) {
            if (j2 <= j3) {
                return false;
            }
        } else if (j2 >= j3) {
            return false;
        }
        return true;
    }

    public final long o() {
        return this.a;
    }

    public final long t() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb;
        long j;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            j = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            j = -this.c;
        }
        sb.append(j);
        return sb.toString();
    }

    public final long v() {
        return this.c;
    }

    @Override // java.lang.Iterable
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public AbstractC12869fJ3 iterator() {
        return new C17051mJ3(this.a, this.b, this.c);
    }
}
