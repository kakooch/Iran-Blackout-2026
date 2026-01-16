package ir.nasim;

/* renamed from: ir.nasim.wa3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C23231wa3 implements Iterable, InterfaceC17915nm3 {
    public static final a d = new a(null);
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: ir.nasim.wa3$a */
    public static final class a {
        private a() {
        }

        public final C23231wa3 a(int i, int i2, int i3) {
            return new C23231wa3(i, i2, i3);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C23231wa3(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = i;
        this.b = AbstractC16234kv5.c(i, i2, i3);
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C23231wa3) {
            if (!isEmpty() || !((C23231wa3) obj).isEmpty()) {
                C23231wa3 c23231wa3 = (C23231wa3) obj;
                if (this.a != c23231wa3.a || this.b != c23231wa3.b || this.c != c23231wa3.c) {
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
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        if (this.c > 0) {
            if (this.a <= this.b) {
                return false;
            }
        } else if (this.a >= this.b) {
            return false;
        }
        return true;
    }

    public final int o() {
        return this.a;
    }

    public final int t() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }

    public final int v() {
        return this.c;
    }

    @Override // java.lang.Iterable
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public AbstractC18386oa3 iterator() {
        return new C23821xa3(this.a, this.b, this.c);
    }
}
