package ir.nasim;

/* renamed from: ir.nasim.ya3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24411ya3 extends C23231wa3 implements InterfaceC10967cW0 {
    public static final a e = new a(null);
    private static final C24411ya3 f = new C24411ya3(1, 0);

    /* renamed from: ir.nasim.ya3$a */
    public static final class a {
        private a() {
        }

        public final C24411ya3 a() {
            return C24411ya3.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C24411ya3(int i, int i2) {
        super(i, i2, 1);
    }

    public boolean B(int i) {
        return o() <= i && i <= t();
    }

    @Override // ir.nasim.InterfaceC10967cW0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public Integer j() {
        return Integer.valueOf(t());
    }

    @Override // ir.nasim.InterfaceC10967cW0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public Integer f() {
        return Integer.valueOf(o());
    }

    @Override // ir.nasim.C23231wa3
    public boolean equals(Object obj) {
        if (obj instanceof C24411ya3) {
            if (!isEmpty() || !((C24411ya3) obj).isEmpty()) {
                C24411ya3 c24411ya3 = (C24411ya3) obj;
                if (o() != c24411ya3.o() || t() != c24411ya3.t()) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.InterfaceC10967cW0
    public /* bridge */ /* synthetic */ boolean h(Comparable comparable) {
        return B(((Number) comparable).intValue());
    }

    @Override // ir.nasim.C23231wa3
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (o() * 31) + t();
    }

    @Override // ir.nasim.C23231wa3, ir.nasim.InterfaceC10967cW0
    public boolean isEmpty() {
        return o() > t();
    }

    @Override // ir.nasim.C23231wa3
    public String toString() {
        return o() + ".." + t();
    }
}
