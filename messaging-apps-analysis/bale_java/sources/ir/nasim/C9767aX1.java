package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aX1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9767aX1 {
    private String a;
    private long b;
    private final long c;
    private final int d;
    private final Integer e;
    private final String f;

    public C9767aX1(String str, long j, long j2, int i, Integer num, String str2) {
        AbstractC13042fc3.i(str2, "mimeType");
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = i;
        this.e = num;
        this.f = str2;
    }

    public final long a() {
        return this.c;
    }

    public final String b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final int d() {
        return this.d;
    }

    public final Integer e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9767aX1)) {
            return false;
        }
        C9767aX1 c9767aX1 = (C9767aX1) obj;
        return AbstractC13042fc3.d(this.a, c9767aX1.a) && this.b == c9767aX1.b && this.c == c9767aX1.c && this.d == c9767aX1.d && AbstractC13042fc3.d(this.e, c9767aX1.e) && AbstractC13042fc3.d(this.f, c9767aX1.f);
    }

    public final String f() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31;
        Integer num = this.e;
        return ((iHashCode + (num != null ? num.hashCode() : 0)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "DomainDocumentExPhoto(caption=" + this.a + ", fileId=" + this.b + ", accessHash=" + this.c + ", fileSize=" + this.d + ", fileStorageVersion=" + this.e + ", mimeType=" + this.f + Separators.RPAREN;
    }
}
