package ir.nasim;

/* renamed from: ir.nasim.Ce6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3751Ce6 {
    private final long a;
    private final String b;
    private final Long c;
    private final String d;

    public C3751Ce6(long j, String str, Long l, String str2) {
        AbstractC13042fc3.i(str, "codec");
        this.a = j;
        this.b = str;
        this.c = l;
        this.d = str2;
    }

    public final String a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3751Ce6)) {
            return false;
        }
        C3751Ce6 c3751Ce6 = (C3751Ce6) obj;
        return this.a == c3751Ce6.a && AbstractC13042fc3.d(this.b, c3751Ce6.b) && AbstractC13042fc3.d(this.c, c3751Ce6.c) && AbstractC13042fc3.d(this.d, c3751Ce6.d);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Long l = this.c;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.d;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SdpRtp(payload=" + this.a + ", codec=" + this.b + ", rate=" + this.c + ", encoding=" + this.d + ')';
    }
}
