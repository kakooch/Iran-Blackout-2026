package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.mO7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17100mO7 {
    private final String a;
    private final String b;
    private final boolean c;
    private final boolean d;

    public C17100mO7(String str, String str2, boolean z, boolean z2) {
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
    }

    public static /* synthetic */ C17100mO7 b(C17100mO7 c17100mO7, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c17100mO7.a;
        }
        if ((i & 2) != 0) {
            str2 = c17100mO7.b;
        }
        if ((i & 4) != 0) {
            z = c17100mO7.c;
        }
        if ((i & 8) != 0) {
            z2 = c17100mO7.d;
        }
        return c17100mO7.a(str, str2, z, z2);
    }

    public final C17100mO7 a(String str, String str2, boolean z, boolean z2) {
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        return new C17100mO7(str, str2, z, z2);
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17100mO7)) {
            return false;
        }
        C17100mO7 c17100mO7 = (C17100mO7) obj;
        return AbstractC13042fc3.d(this.a, c17100mO7.a) && AbstractC13042fc3.d(this.b, c17100mO7.b) && this.c == c17100mO7.c && this.d == c17100mO7.d;
    }

    public final boolean f() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "ValidatePasswordModel(password=" + this.a + ", error=" + this.b + ", isFinish=" + this.c + ", isLoading=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C17100mO7(String str, String str2, boolean z, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }
}
