package ir.nasim;

/* renamed from: ir.nasim.mk1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C17302mk1 {
    private final int a;
    private final long b;
    private final EnumC17893nk1 c;
    private final KX7 d;

    public C17302mk1(int i, long j, EnumC17893nk1 enumC17893nk1, KX7 kx7) {
        this.a = i;
        this.b = j;
        this.c = enumC17893nk1;
        this.d = kx7;
    }

    public final int a() {
        return this.a;
    }

    public final KX7 b() {
        return this.d;
    }

    public final EnumC17893nk1 c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17302mk1)) {
            return false;
        }
        C17302mk1 c17302mk1 = (C17302mk1) obj;
        return this.a == c17302mk1.a && this.b == c17302mk1.b && this.c == c17302mk1.c && AbstractC13042fc3.d(this.d, c17302mk1.d);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31;
        KX7 kx7 = this.d;
        return iHashCode + (kx7 == null ? 0 : kx7.hashCode());
    }

    public String toString() {
        return "ContentCaptureEvent(id=" + this.a + ", timestamp=" + this.b + ", type=" + this.c + ", structureCompat=" + this.d + ')';
    }
}
