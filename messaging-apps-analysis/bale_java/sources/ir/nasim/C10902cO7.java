package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.cO7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10902cO7 {
    private final String a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final int e;

    public C10902cO7(String str, String str2, boolean z, boolean z2, int i) {
        AbstractC13042fc3.i(str, "code");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
        this.e = i;
    }

    public static /* synthetic */ C10902cO7 b(C10902cO7 c10902cO7, String str, String str2, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c10902cO7.a;
        }
        if ((i2 & 2) != 0) {
            str2 = c10902cO7.b;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            z = c10902cO7.c;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            z2 = c10902cO7.d;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            i = c10902cO7.e;
        }
        return c10902cO7.a(str, str3, z3, z4, i);
    }

    public final C10902cO7 a(String str, String str2, boolean z, boolean z2, int i) {
        AbstractC13042fc3.i(str, "code");
        return new C10902cO7(str, str2, z, z2, i);
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10902cO7)) {
            return false;
        }
        C10902cO7 c10902cO7 = (C10902cO7) obj;
        return AbstractC13042fc3.d(this.a, c10902cO7.a) && AbstractC13042fc3.d(this.b, c10902cO7.b) && this.c == c10902cO7.c && this.d == c10902cO7.d && this.e == c10902cO7.e;
    }

    public final boolean f() {
        return this.d;
    }

    public final boolean g() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "ValidateCodeModel(code=" + this.a + ", error=" + this.b + ", isLoading=" + this.c + ", isFinish=" + this.d + ", sendNextCodeTime=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C10902cO7(String str, String str2, boolean z, boolean z2, int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? false : z, (i2 & 8) == 0 ? z2 : false, (i2 & 16) != 0 ? 90 : i);
    }
}
