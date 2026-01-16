package ir.nasim;

/* renamed from: ir.nasim.cp3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C11329cp3 {
    public static final a g = new a(null);
    private static final C11329cp3 h = new C11329cp3(null, null, null, null, null, null, 63, null);
    private final UA2 a;
    private final UA2 b;
    private final UA2 c;
    private final UA2 d;
    private final UA2 e;
    private final UA2 f;

    /* renamed from: ir.nasim.cp3$a */
    public static final class a {
        private a() {
        }

        public final C11329cp3 a() {
            return C11329cp3.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C11329cp3(UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25, UA2 ua26) {
        this.a = ua2;
        this.b = ua22;
        this.c = ua23;
        this.d = ua24;
        this.e = ua25;
        this.f = ua26;
    }

    public final UA2 b() {
        return this.a;
    }

    public final UA2 c() {
        return this.b;
    }

    public final UA2 d() {
        return this.c;
    }

    public final UA2 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11329cp3)) {
            return false;
        }
        C11329cp3 c11329cp3 = (C11329cp3) obj;
        return this.a == c11329cp3.a && this.b == c11329cp3.b && this.c == c11329cp3.c && this.d == c11329cp3.d && this.e == c11329cp3.e && this.f == c11329cp3.f;
    }

    public final UA2 f() {
        return this.e;
    }

    public final UA2 g() {
        return this.f;
    }

    public int hashCode() {
        UA2 ua2 = this.a;
        int iHashCode = (ua2 != null ? ua2.hashCode() : 0) * 31;
        UA2 ua22 = this.b;
        int iHashCode2 = (iHashCode + (ua22 != null ? ua22.hashCode() : 0)) * 31;
        UA2 ua23 = this.c;
        int iHashCode3 = (iHashCode2 + (ua23 != null ? ua23.hashCode() : 0)) * 31;
        UA2 ua24 = this.d;
        int iHashCode4 = (iHashCode3 + (ua24 != null ? ua24.hashCode() : 0)) * 31;
        UA2 ua25 = this.e;
        int iHashCode5 = (iHashCode4 + (ua25 != null ? ua25.hashCode() : 0)) * 31;
        UA2 ua26 = this.f;
        return iHashCode5 + (ua26 != null ? ua26.hashCode() : 0);
    }

    public /* synthetic */ C11329cp3(UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25, UA2 ua26, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : ua2, (i & 2) != 0 ? null : ua22, (i & 4) != 0 ? null : ua23, (i & 8) != 0 ? null : ua24, (i & 16) != 0 ? null : ua25, (i & 32) != 0 ? null : ua26);
    }
}
