package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.fK5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12880fK5 {
    private final String a;
    private final String b;
    private final String c;
    private final boolean d;
    private final A05 e;
    private final A05 f;
    private final int g;

    public C12880fK5(String str, String str2, String str3, boolean z, A05 a05, A05 a052, int i) {
        AbstractC13042fc3.i(str3, "code");
        AbstractC13042fc3.i(a05, "newPasswordModel");
        AbstractC13042fc3.i(a052, "confirmNewPasswordModel");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = a05;
        this.f = a052;
        this.g = i;
    }

    public static /* synthetic */ C12880fK5 b(C12880fK5 c12880fK5, String str, String str2, String str3, boolean z, A05 a05, A05 a052, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c12880fK5.a;
        }
        if ((i2 & 2) != 0) {
            str2 = c12880fK5.b;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = c12880fK5.c;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            z = c12880fK5.d;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            a05 = c12880fK5.e;
        }
        A05 a053 = a05;
        if ((i2 & 32) != 0) {
            a052 = c12880fK5.f;
        }
        A05 a054 = a052;
        if ((i2 & 64) != 0) {
            i = c12880fK5.g;
        }
        return c12880fK5.a(str, str4, str5, z2, a053, a054, i);
    }

    public final C12880fK5 a(String str, String str2, String str3, boolean z, A05 a05, A05 a052, int i) {
        AbstractC13042fc3.i(str3, "code");
        AbstractC13042fc3.i(a05, "newPasswordModel");
        AbstractC13042fc3.i(a052, "confirmNewPasswordModel");
        return new C12880fK5(str, str2, str3, z, a05, a052, i);
    }

    public final String c() {
        return this.c;
    }

    public final A05 d() {
        return this.f;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12880fK5)) {
            return false;
        }
        C12880fK5 c12880fK5 = (C12880fK5) obj;
        return AbstractC13042fc3.d(this.a, c12880fK5.a) && AbstractC13042fc3.d(this.b, c12880fK5.b) && AbstractC13042fc3.d(this.c, c12880fK5.c) && this.d == c12880fK5.d && AbstractC13042fc3.d(this.e, c12880fK5.e) && AbstractC13042fc3.d(this.f, c12880fK5.f) && this.g == c12880fK5.g;
    }

    public final String f() {
        return this.b;
    }

    public final A05 g() {
        return this.e;
    }

    public final int h() {
        return this.g;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return ((((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g);
    }

    public final boolean i() {
        return this.d;
    }

    public String toString() {
        return "RecoverPasswordModel(email=" + this.a + ", error=" + this.b + ", code=" + this.c + ", isLoading=" + this.d + ", newPasswordModel=" + this.e + ", confirmNewPasswordModel=" + this.f + ", sendNextCodeTime=" + this.g + Separators.RPAREN;
    }

    public /* synthetic */ C12880fK5(String str, String str2, String str3, boolean z, A05 a05, A05 a052, int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? new A05(null, null, 3, null) : a05, (i2 & 32) != 0 ? new A05(null, null, 3, null) : a052, (i2 & 64) != 0 ? 90 : i);
    }
}
