package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Cl0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3808Cl0 {
    private final long a;
    private final int b;
    private final String c;

    public C3808Cl0(long j, int i, String str) {
        this.a = j;
        this.b = i;
        this.c = str;
    }

    public static /* synthetic */ C3808Cl0 b(C3808Cl0 c3808Cl0, long j, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = c3808Cl0.a;
        }
        if ((i2 & 2) != 0) {
            i = c3808Cl0.b;
        }
        if ((i2 & 4) != 0) {
            str = c3808Cl0.c;
        }
        return c3808Cl0.a(j, i, str);
    }

    public final C3808Cl0 a(long j, int i, String str) {
        return new C3808Cl0(j, i, str);
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3808Cl0)) {
            return false;
        }
        C3808Cl0 c3808Cl0 = (C3808Cl0) obj;
        return this.a == c3808Cl0.a && this.b == c3808Cl0.b && AbstractC13042fc3.d(this.c, c3808Cl0.c);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31;
        String str = this.c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BucketInfo(bucketId=" + this.a + ", itemsCount=" + this.b + ", bucketDisplayName=" + this.c + Separators.RPAREN;
    }
}
