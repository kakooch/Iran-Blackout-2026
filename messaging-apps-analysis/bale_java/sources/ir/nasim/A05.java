package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* loaded from: classes7.dex */
public final class A05 {
    private final String a;
    private final String b;

    public A05(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ A05 b(A05 a05, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = a05.a;
        }
        if ((i & 2) != 0) {
            str2 = a05.b;
        }
        return a05.a(str, str2);
    }

    public final A05 a(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        return new A05(str, str2);
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A05)) {
            return false;
        }
        A05 a05 = (A05) obj;
        return AbstractC13042fc3.d(this.a, a05.a) && AbstractC13042fc3.d(this.b, a05.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PasswordModel(password=" + this.a + ", error=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ A05(String str, String str2, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2);
    }
}
