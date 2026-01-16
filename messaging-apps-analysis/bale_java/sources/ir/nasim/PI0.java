package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes7.dex */
public final class PI0 {
    private final String a;
    private final List b;

    public PI0(String str, List list) {
        this.a = str;
        this.b = list;
    }

    public final List a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PI0)) {
            return false;
        }
        PI0 pi0 = (PI0) obj;
        return AbstractC13042fc3.d(this.a, pi0.a) && AbstractC13042fc3.d(this.b, pi0.b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List list = this.b;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ChangeLogUiData(versionName=" + this.a + ", changes=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ PI0(String str, List list, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }
}
