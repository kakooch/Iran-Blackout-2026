package ir.nasim;

/* renamed from: ir.nasim.r35, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19857r35 extends AbstractC17902nl0 {
    public static final a h = new a(null);
    public static final int i = 8;
    private C7880To7 a;
    private C11458d25 b;
    private long c;
    private AbstractC17457n0 d;
    private boolean e;
    private J44 f;
    private C3933Cz g;

    /* renamed from: ir.nasim.r35$a */
    public static final class a {
        private a() {
        }

        public final C19857r35 a(byte[] bArr) {
            AbstractC17902nl0 abstractC17902nl0B = AbstractC16720ll0.b(new C19857r35(null, 0L, null, null, null, null, 63, null), bArr);
            AbstractC13042fc3.h(abstractC17902nl0B, "parse(...)");
            return (C19857r35) abstractC17902nl0B;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C19857r35(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, C3933Cz c3933Cz) {
        this(c11458d25, j, abstractC17457n0, c3933Cz, null, null, 48, null);
        AbstractC13042fc3.i(c11458d25, "peer");
    }

    public static /* synthetic */ C19857r35 s(C19857r35 c19857r35, C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, C3933Cz c3933Cz, J44 j44, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            c11458d25 = c19857r35.b;
        }
        if ((i2 & 2) != 0) {
            j = c19857r35.c;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            abstractC17457n0 = c19857r35.d;
        }
        AbstractC17457n0 abstractC17457n02 = abstractC17457n0;
        if ((i2 & 8) != 0) {
            c3933Cz = c19857r35.g;
        }
        C3933Cz c3933Cz2 = c3933Cz;
        if ((i2 & 16) != 0) {
            j44 = c19857r35.f;
        }
        return c19857r35.r(c11458d25, j2, abstractC17457n02, c3933Cz2, j44);
    }

    public static final C19857r35 u(byte[] bArr) {
        return h.a(bArr);
    }

    public final C11458d25 C() {
        return this.b;
    }

    public final C7880To7 D() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C19857r35.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.actions.entity.PendingMessage");
        C19857r35 c19857r35 = (C19857r35) obj;
        return AbstractC13042fc3.d(this.b, c19857r35.b) && this.c == c19857r35.c;
    }

    public int hashCode() {
        C11458d25 c11458d25 = this.b;
        return ((c11458d25 != null ? c11458d25.hashCode() : 0) * 31) + Long.hashCode(this.c);
    }

    public final long i() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.b = C11458d25.r(c19084pl0.i(1));
        this.c = c19084pl0.i(2);
        this.d = AbstractC17457n0.n(c19084pl0.d(3));
        this.e = c19084pl0.c(4, false);
        if (c19084pl0.t()) {
            this.g = (C3933Cz) c19084pl0.z(5, new C3933Cz());
        }
        if (c19084pl0.t()) {
            this.f = (J44) c19084pl0.z(6, new J44(0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524287, null));
        }
        if (c19084pl0.t()) {
            this.a = (C7880To7) c19084pl0.z(7, new C7880To7(0L, 0L, null, 7, null));
        }
    }

    public final C19857r35 q(AbstractC17457n0 abstractC17457n0) {
        AbstractC13042fc3.i(abstractC17457n0, "content");
        return s(this, null, 0L, abstractC17457n0, null, null, 27, null);
    }

    public final C19857r35 r(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, C3933Cz c3933Cz, J44 j44) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return new C19857r35(c11458d25, j, abstractC17457n0, c3933Cz, this.a, j44);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        C11458d25 c11458d25 = this.b;
        if (c11458d25 != null) {
            c19675ql0.g(1, c11458d25.u());
        }
        c19675ql0.g(2, this.c);
        c19675ql0.b(3, AbstractC17457n0.o(this.d));
        c19675ql0.a(4, this.e);
        C3933Cz c3933Cz = this.g;
        if (c3933Cz != null) {
            c19675ql0.i(5, c3933Cz);
        }
        J44 j44 = this.f;
        if (j44 != null) {
            c19675ql0.i(6, j44);
        }
        C7880To7 c7880To7 = this.a;
        if (c7880To7 != null) {
            c19675ql0.i(7, c7880To7);
        }
    }

    public final C3933Cz w() {
        return this.g;
    }

    public final AbstractC17457n0 y() {
        return this.d;
    }

    public final J44 z() {
        return this.f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C19857r35(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, C3933Cz c3933Cz, C7880To7 c7880To7) {
        this(c11458d25, j, abstractC17457n0, c3933Cz, c7880To7, null, 32, null);
        AbstractC13042fc3.i(c11458d25, "peer");
    }

    public /* synthetic */ C19857r35(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, C3933Cz c3933Cz, C7880To7 c7880To7, J44 j44, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? C11458d25.E(0) : c11458d25, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? null : abstractC17457n0, (i2 & 8) != 0 ? null : c3933Cz, (i2 & 16) != 0 ? null : c7880To7, (i2 & 32) != 0 ? null : j44);
    }

    public C19857r35(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0, C3933Cz c3933Cz, C7880To7 c7880To7, J44 j44) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c7880To7;
        this.b = c11458d25;
        this.c = j;
        this.d = abstractC17457n0;
        this.f = j44;
        this.g = c3933Cz;
    }
}
