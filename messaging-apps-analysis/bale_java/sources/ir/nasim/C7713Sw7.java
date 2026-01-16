package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.Sw7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7713Sw7 {
    private final String a;
    private final String b;
    private final String c;
    private final boolean d;
    private final String e;
    private final B05 f;
    private final B05 g;
    private final int h;

    public C7713Sw7(String str, String str2, String str3, boolean z, String str4, B05 b05, B05 b052, int i) {
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        AbstractC13042fc3.i(str2, "code");
        AbstractC13042fc3.i(b05, "newPasswordForRecovery");
        AbstractC13042fc3.i(b052, "confirmNewPasswordForRecovery");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = str4;
        this.f = b05;
        this.g = b052;
        this.h = i;
    }

    public final C7713Sw7 a(String str, String str2, String str3, boolean z, String str4, B05 b05, B05 b052, int i) {
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        AbstractC13042fc3.i(str2, "code");
        AbstractC13042fc3.i(b05, "newPasswordForRecovery");
        AbstractC13042fc3.i(b052, "confirmNewPasswordForRecovery");
        return new C7713Sw7(str, str2, str3, z, str4, b05, b052, i);
    }

    public final String c() {
        return this.b;
    }

    public final B05 d() {
        return this.g;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7713Sw7)) {
            return false;
        }
        C7713Sw7 c7713Sw7 = (C7713Sw7) obj;
        return AbstractC13042fc3.d(this.a, c7713Sw7.a) && AbstractC13042fc3.d(this.b, c7713Sw7.b) && AbstractC13042fc3.d(this.c, c7713Sw7.c) && this.d == c7713Sw7.d && AbstractC13042fc3.d(this.e, c7713Sw7.e) && AbstractC13042fc3.d(this.f, c7713Sw7.f) && AbstractC13042fc3.d(this.g, c7713Sw7.g) && this.h == c7713Sw7.h;
    }

    public final B05 f() {
        return this.f;
    }

    public final String g() {
        return this.a;
    }

    public final String h() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31;
        String str2 = this.e;
        return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h);
    }

    public final int i() {
        return this.h;
    }

    public final boolean j() {
        return this.d;
    }

    public String toString() {
        return "TwoFAModel(password=" + this.a + ", code=" + this.b + ", error=" + this.c + ", isLoading=" + this.d + ", recoverEmail=" + this.e + ", newPasswordForRecovery=" + this.f + ", confirmNewPasswordForRecovery=" + this.g + ", sendNextCodeTime=" + this.h + Separators.RPAREN;
    }

    public /* synthetic */ C7713Sw7(String str, String str2, String str3, boolean z, String str4, B05 b05, B05 b052, int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? new B05(null, null, 3, null) : b05, (i2 & 64) != 0 ? new B05(null, null, 3, null) : b052, (i2 & 128) != 0 ? 90 : i);
    }
}
