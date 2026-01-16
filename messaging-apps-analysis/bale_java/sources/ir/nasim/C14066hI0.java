package ir.nasim;

import ir.nasim.UK6;

/* renamed from: ir.nasim.hI0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14066hI0 {
    public static final a c;
    private static final C14066hI0 d;
    private static final C14066hI0 e;
    private static final C14066hI0 f;
    private final UK6.b a;
    private final Float b;

    /* renamed from: ir.nasim.hI0$a */
    public static final class a {
        private a() {
        }

        public final C14066hI0 a(float f) {
            return new C14066hI0(UK6.b.PACKED, Float.valueOf(f));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a aVar = new a(null);
        c = aVar;
        int i = 2;
        d = new C14066hI0(UK6.b.SPREAD, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        e = new C14066hI0(UK6.b.SPREAD_INSIDE, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        f = aVar.a(0.5f);
    }

    public C14066hI0(UK6.b bVar, Float f2) {
        AbstractC13042fc3.i(bVar, "style");
        this.a = bVar;
        this.b = f2;
    }

    public final Float a() {
        return this.b;
    }

    public final UK6.b b() {
        return this.a;
    }

    public /* synthetic */ C14066hI0(UK6.b bVar, Float f2, int i, ED1 ed1) {
        this(bVar, (i & 2) != 0 ? null : f2);
    }
}
