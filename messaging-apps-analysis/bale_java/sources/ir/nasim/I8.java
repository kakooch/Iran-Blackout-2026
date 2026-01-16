package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes4.dex */
public final class I8 {
    private final String a;
    private final String b;
    private final C13788gp1 c;
    private final List d;
    private final boolean e;

    public I8(String str, String str2, C13788gp1 c13788gp1, List list, boolean z) {
        AbstractC13042fc3.i(str, "contactName");
        AbstractC13042fc3.i(str2, "contactPhoneNumber");
        AbstractC13042fc3.i(c13788gp1, "currentSelectedCountry");
        AbstractC13042fc3.i(list, "countryList");
        this.a = str;
        this.b = str2;
        this.c = c13788gp1;
        this.d = list;
        this.e = z;
    }

    public static /* synthetic */ I8 b(I8 i8, String str, String str2, C13788gp1 c13788gp1, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = i8.a;
        }
        if ((i & 2) != 0) {
            str2 = i8.b;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            c13788gp1 = i8.c;
        }
        C13788gp1 c13788gp12 = c13788gp1;
        if ((i & 8) != 0) {
            list = i8.d;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            z = i8.e;
        }
        return i8.a(str, str3, c13788gp12, list2, z);
    }

    public final I8 a(String str, String str2, C13788gp1 c13788gp1, List list, boolean z) {
        AbstractC13042fc3.i(str, "contactName");
        AbstractC13042fc3.i(str2, "contactPhoneNumber");
        AbstractC13042fc3.i(c13788gp1, "currentSelectedCountry");
        AbstractC13042fc3.i(list, "countryList");
        return new I8(str, str2, c13788gp1, list, z);
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final List e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I8)) {
            return false;
        }
        I8 i8 = (I8) obj;
        return AbstractC13042fc3.d(this.a, i8.a) && AbstractC13042fc3.d(this.b, i8.b) && AbstractC13042fc3.d(this.c, i8.c) && AbstractC13042fc3.d(this.d, i8.d) && this.e == i8.e;
    }

    public final C13788gp1 f() {
        return this.c;
    }

    public final boolean g() {
        return this.e;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "AddContactUiState(contactName=" + this.a + ", contactPhoneNumber=" + this.b + ", currentSelectedCountry=" + this.c + ", countryList=" + this.d + ", isLoading=" + this.e + Separators.RPAREN;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ I8(String str, String str2, C13788gp1 c13788gp1, List list, boolean z, int i, ED1 ed1) {
        String str3 = (i & 1) != 0 ? "" : str;
        String str4 = (i & 2) == 0 ? str2 : "";
        C13788gp1 c13788gp1A = (i & 4) != 0 ? J8.a() : c13788gp1;
        this(str3, str4, c13788gp1A, (i & 8) != 0 ? AbstractC9766aX0.e(c13788gp1A) : list, (i & 16) != 0 ? false : z);
    }
}
