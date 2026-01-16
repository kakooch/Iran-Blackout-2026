package ir.nasim;

/* renamed from: ir.nasim.qw6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19791qw6 extends AbstractC17902nl0 {
    public static final a c = new a(null);
    public static final int d = 8;
    private String a;
    private String b;

    /* renamed from: ir.nasim.qw6$a */
    public static final class a {
        private a() {
        }

        public final C19791qw6 a(byte[] bArr) {
            AbstractC13042fc3.i(bArr, "data");
            AbstractC17902nl0 abstractC17902nl0B = AbstractC16720ll0.b(new C19791qw6(null), bArr);
            AbstractC13042fc3.h(abstractC17902nl0B, "parse(...)");
            return (C19791qw6) abstractC17902nl0B;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C19791qw6(ED1 ed1) {
        this();
    }

    public final String getKey() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("key");
        return null;
    }

    public final String getValue() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.A(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.o(1, getKey());
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
        }
    }

    public C19791qw6(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        this.a = str;
        this.b = str2;
    }

    private C19791qw6() {
    }
}
