package ir.nasim;

/* renamed from: ir.nasim.eK0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12266eK0 extends AbstractC10859cK0 implements InterfaceC10967cW0 {
    public static final a e = new a(null);
    private static final C12266eK0 f = new C12266eK0(1, 0);

    /* renamed from: ir.nasim.eK0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C12266eK0(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // ir.nasim.InterfaceC10967cW0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public Character j() {
        return Character.valueOf(t());
    }

    @Override // ir.nasim.InterfaceC10967cW0
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Character f() {
        return Character.valueOf(o());
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12266eK0) {
            if (!isEmpty() || !((C12266eK0) obj).isEmpty()) {
                C12266eK0 c12266eK0 = (C12266eK0) obj;
                if (o() != c12266eK0.o() || t() != c12266eK0.t()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC10967cW0
    public /* bridge */ /* synthetic */ boolean h(Comparable comparable) {
        return x(((Character) comparable).charValue());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (o() * 31) + t();
    }

    @Override // ir.nasim.InterfaceC10967cW0
    public boolean isEmpty() {
        return AbstractC13042fc3.k(o(), t()) > 0;
    }

    public String toString() {
        return o() + ".." + t();
    }

    public boolean x(char c) {
        return AbstractC13042fc3.k(o(), c) <= 0 && AbstractC13042fc3.k(c, t()) <= 0;
    }
}
