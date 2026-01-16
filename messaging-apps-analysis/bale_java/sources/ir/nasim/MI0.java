package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AJ0;

/* loaded from: classes7.dex */
public final class MI0 {
    private final String a;
    private final W06 b;
    private final String c;
    private final AJ0 d;

    public MI0(String str, W06 w06, String str2, AJ0 aj0) {
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(w06, "groupRestriction");
        AbstractC13042fc3.i(aj0, "channelIdUiState");
        this.a = str;
        this.b = w06;
        this.c = str2;
        this.d = aj0;
    }

    public static /* synthetic */ MI0 b(MI0 mi0, String str, W06 w06, String str2, AJ0 aj0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mi0.a;
        }
        if ((i & 2) != 0) {
            w06 = mi0.b;
        }
        if ((i & 4) != 0) {
            str2 = mi0.c;
        }
        if ((i & 8) != 0) {
            aj0 = mi0.d;
        }
        return mi0.a(str, w06, str2, aj0);
    }

    public final MI0 a(String str, W06 w06, String str2, AJ0 aj0) {
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(w06, "groupRestriction");
        AbstractC13042fc3.i(aj0, "channelIdUiState");
        return new MI0(str, w06, str2, aj0);
    }

    public final AJ0 c() {
        return this.d;
    }

    public final W06 d() {
        return this.b;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MI0)) {
            return false;
        }
        MI0 mi0 = (MI0) obj;
        return AbstractC13042fc3.d(this.a, mi0.a) && this.b == mi0.b && AbstractC13042fc3.d(this.c, mi0.c) && AbstractC13042fc3.d(this.d, mi0.d);
    }

    public final String f() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ChangeGroupTypeModel(id=" + this.a + ", groupRestriction=" + this.b + ", snackBarMessage=" + this.c + ", channelIdUiState=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ MI0(String str, W06 w06, String str2, AJ0 aj0, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? W06.PRIVATE : w06, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? AJ0.b.a : aj0);
    }
}
