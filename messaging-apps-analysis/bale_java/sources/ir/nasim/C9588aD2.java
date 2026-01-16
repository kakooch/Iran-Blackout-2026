package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9588aD2 {
    private final int a;
    private final String b;
    private final Long c;
    private final long d;
    private final int e;
    private final long f;

    public C9588aD2(int i, String str, Long l, long j, int i2, long j2) {
        AbstractC13042fc3.i(str, "path");
        this.a = i;
        this.b = str;
        this.c = l;
        this.d = j;
        this.e = i2;
        this.f = j2;
    }

    public final long a() {
        return this.f;
    }

    public final Long b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final long d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9588aD2)) {
            return false;
        }
        C9588aD2 c9588aD2 = (C9588aD2) obj;
        return this.a == c9588aD2.a && AbstractC13042fc3.d(this.b, c9588aD2.b) && AbstractC13042fc3.d(this.c, c9588aD2.c) && this.d == c9588aD2.d && this.e == c9588aD2.e && this.f == c9588aD2.f;
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Long l = this.c;
        return ((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "GalleryItem(id=" + this.a + ", path=" + this.b + ", duration=" + this.c + ", modificationDate=" + this.d + ", orientation=" + this.e + ", bucketId=" + this.f + Separators.RPAREN;
    }
}
