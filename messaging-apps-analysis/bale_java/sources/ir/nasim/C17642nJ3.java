package ir.nasim;

/* renamed from: ir.nasim.nJ3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17642nJ3 extends C16460lJ3 implements InterfaceC10967cW0 {
    public static final a e = new a(null);
    private static final C17642nJ3 f = new C17642nJ3(1, 0);

    /* renamed from: ir.nasim.nJ3$a */
    public static final class a {
        private a() {
        }

        public final C17642nJ3 a() {
            return C17642nJ3.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C17642nJ3(long j, long j2) {
        super(j, j2, 1L);
    }

    public boolean B(long j) {
        return o() <= j && j <= t();
    }

    @Override // ir.nasim.InterfaceC10967cW0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Long j() {
        return Long.valueOf(t());
    }

    @Override // ir.nasim.InterfaceC10967cW0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public Long f() {
        return Long.valueOf(o());
    }

    @Override // ir.nasim.C16460lJ3
    public boolean equals(Object obj) {
        if (obj instanceof C17642nJ3) {
            if (!isEmpty() || !((C17642nJ3) obj).isEmpty()) {
                C17642nJ3 c17642nJ3 = (C17642nJ3) obj;
                if (o() != c17642nJ3.o() || t() != c17642nJ3.t()) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.InterfaceC10967cW0
    public /* bridge */ /* synthetic */ boolean h(Comparable comparable) {
        return B(((Number) comparable).longValue());
    }

    @Override // ir.nasim.C16460lJ3
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (o() ^ (o() >>> 32))) + (t() ^ (t() >>> 32)));
    }

    @Override // ir.nasim.C16460lJ3, ir.nasim.InterfaceC10967cW0
    public boolean isEmpty() {
        return o() > t();
    }

    @Override // ir.nasim.C16460lJ3
    public String toString() {
        return o() + ".." + t();
    }
}
