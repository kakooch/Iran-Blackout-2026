package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class H07 {
    private final String a;

    public H07(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof H07) && AbstractC13042fc3.d(this.a, ((H07) obj).a);
    }

    public int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "SuccessGetFileLogs(path=" + this.a + Separators.RPAREN;
    }

    public /* synthetic */ H07(String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str);
    }
}
