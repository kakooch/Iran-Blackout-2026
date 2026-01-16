package ir.nasim;

/* renamed from: ir.nasim.nn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17929nn7 {
    private final C12863fI6 a;
    private final C12863fI6 b;
    private final C12863fI6 c;
    private final C12863fI6 d;

    public C17929nn7(C12863fI6 c12863fI6, C12863fI6 c12863fI62, C12863fI6 c12863fI63, C12863fI6 c12863fI64) {
        this.a = c12863fI6;
        this.b = c12863fI62;
        this.c = c12863fI63;
        this.d = c12863fI64;
    }

    public final C12863fI6 a() {
        return this.b;
    }

    public final C12863fI6 b() {
        return this.c;
    }

    public final C12863fI6 c() {
        return this.d;
    }

    public final C12863fI6 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C17929nn7)) {
            return false;
        }
        C17929nn7 c17929nn7 = (C17929nn7) obj;
        return AbstractC13042fc3.d(this.a, c17929nn7.a) && AbstractC13042fc3.d(this.b, c17929nn7.b) && AbstractC13042fc3.d(this.c, c17929nn7.c) && AbstractC13042fc3.d(this.d, c17929nn7.d);
    }

    public int hashCode() {
        C12863fI6 c12863fI6 = this.a;
        int iHashCode = (c12863fI6 != null ? c12863fI6.hashCode() : 0) * 31;
        C12863fI6 c12863fI62 = this.b;
        int iHashCode2 = (iHashCode + (c12863fI62 != null ? c12863fI62.hashCode() : 0)) * 31;
        C12863fI6 c12863fI63 = this.c;
        int iHashCode3 = (iHashCode2 + (c12863fI63 != null ? c12863fI63.hashCode() : 0)) * 31;
        C12863fI6 c12863fI64 = this.d;
        return iHashCode3 + (c12863fI64 != null ? c12863fI64.hashCode() : 0);
    }

    public /* synthetic */ C17929nn7(C12863fI6 c12863fI6, C12863fI6 c12863fI62, C12863fI6 c12863fI63, C12863fI6 c12863fI64, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : c12863fI6, (i & 2) != 0 ? null : c12863fI62, (i & 4) != 0 ? null : c12863fI63, (i & 8) != 0 ? null : c12863fI64);
    }
}
