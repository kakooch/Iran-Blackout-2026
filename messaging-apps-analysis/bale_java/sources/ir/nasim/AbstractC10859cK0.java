package ir.nasim;

/* renamed from: ir.nasim.cK0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10859cK0 implements Iterable, InterfaceC17915nm3 {
    public static final a d = new a(null);
    private final char a;
    private final char b;
    private final int c;

    /* renamed from: ir.nasim.cK0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AbstractC10859cK0(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = c;
        this.b = (char) AbstractC16234kv5.c(c, c2, i);
        this.c = i;
    }

    public final char o() {
        return this.a;
    }

    public final char t() {
        return this.b;
    }

    @Override // java.lang.Iterable
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public ZJ0 iterator() {
        return new C11623dK0(this.a, this.b, this.c);
    }
}
