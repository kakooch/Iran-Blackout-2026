package ir.nasim;

/* renamed from: ir.nasim.Tu5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7932Tu5 {
    public static final a d = new a(null);
    private static final C7932Tu5 e = new C7932Tu5(0.0f, AbstractC22457vG5.b(0.0f, 0.0f), 0, 4, null);
    private final float a;
    private final InterfaceC10351bW0 b;
    private final int c;

    /* renamed from: ir.nasim.Tu5$a */
    public static final class a {
        private a() {
        }

        public final C7932Tu5 a() {
            return C7932Tu5.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C7932Tu5(float f, InterfaceC10351bW0 interfaceC10351bW0, int i) {
        this.a = f;
        this.b = interfaceC10351bW0;
        this.c = i;
        if (!(!Float.isNaN(f))) {
            throw new IllegalArgumentException("current must not be NaN".toString());
        }
    }

    public final float b() {
        return this.a;
    }

    public final InterfaceC10351bW0 c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7932Tu5)) {
            return false;
        }
        C7932Tu5 c7932Tu5 = (C7932Tu5) obj;
        return this.a == c7932Tu5.a && AbstractC13042fc3.d(this.b, c7932Tu5.b) && this.c == c7932Tu5.c;
    }

    public int hashCode() {
        return (((Float.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.a + ", range=" + this.b + ", steps=" + this.c + ')';
    }

    public /* synthetic */ C7932Tu5(float f, InterfaceC10351bW0 interfaceC10351bW0, int i, int i2, ED1 ed1) {
        this(f, interfaceC10351bW0, (i2 & 4) != 0 ? 0 : i);
    }
}
