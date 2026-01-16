package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class N52 {
    private final String a;
    private final String b;
    private final boolean c;
    private final boolean d;

    public N52(String str, String str2, boolean z, boolean z2) {
        AbstractC13042fc3.i(str, "email");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
    }

    public static /* synthetic */ N52 b(N52 n52, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = n52.a;
        }
        if ((i & 2) != 0) {
            str2 = n52.b;
        }
        if ((i & 4) != 0) {
            z = n52.c;
        }
        if ((i & 8) != 0) {
            z2 = n52.d;
        }
        return n52.a(str, str2, z, z2);
    }

    public final N52 a(String str, String str2, boolean z, boolean z2) {
        AbstractC13042fc3.i(str, "email");
        return new N52(str, str2, z, z2);
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N52)) {
            return false;
        }
        N52 n52 = (N52) obj;
        return AbstractC13042fc3.d(this.a, n52.a) && AbstractC13042fc3.d(this.b, n52.b) && this.c == n52.c && this.d == n52.d;
    }

    public final boolean f() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "EmailModel(email=" + this.a + ", error=" + this.b + ", isLoading=" + this.c + ", isFinish=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ N52(String str, String str2, boolean z, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }
}
