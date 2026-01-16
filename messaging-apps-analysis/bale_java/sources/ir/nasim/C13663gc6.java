package ir.nasim;

import ir.nasim.OU3;

/* renamed from: ir.nasim.gc6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13663gc6 {
    public static final a Companion = new a(null);
    private static final C20644sM5 d = new C20644sM5("L(\\d)T(\\d)(h|_KEY|_KEY_SHIFT)?");
    private final int a;
    private final int b;
    private final String c;

    /* renamed from: ir.nasim.gc6$a */
    public static final class a {
        private a() {
        }

        public final C13663gc6 a(String str) {
            AbstractC13042fc3.i(str, "mode");
            OU3 ou3F = C13663gc6.d.f(str);
            if (ou3F == null) {
                throw new IllegalArgumentException("can't parse scalability mode: " + str);
            }
            OU3.b bVarA = ou3F.a();
            return new C13663gc6(Integer.parseInt((String) bVarA.a().b().get(1)), Integer.parseInt((String) bVarA.a().b().get(2)), (String) bVarA.a().b().get(3));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C13663gc6(int i, int i2, String str) {
        AbstractC13042fc3.i(str, "suffix");
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13663gc6)) {
            return false;
        }
        C13663gc6 c13663gc6 = (C13663gc6) obj;
        return this.a == c13663gc6.a && this.b == c13663gc6.b && AbstractC13042fc3.d(this.c, c13663gc6.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ScalabilityMode(spatial=" + this.a + ", temporal=" + this.b + ", suffix=" + this.c + ')';
    }
}
