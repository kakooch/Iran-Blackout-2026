package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class CX4 {
    private final String a;
    private final boolean b;
    private final List c;

    public CX4(String str, boolean z, List list) {
        AbstractC13042fc3.i(list, "fields");
        this.a = str;
        this.b = z;
        this.c = list;
    }

    public static /* synthetic */ CX4 b(CX4 cx4, String str, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cx4.a;
        }
        if ((i & 2) != 0) {
            z = cx4.b;
        }
        if ((i & 4) != 0) {
            list = cx4.c;
        }
        return cx4.a(str, z, list);
    }

    public final CX4 a(String str, boolean z, List list) {
        AbstractC13042fc3.i(list, "fields");
        return new CX4(str, z, list);
    }

    public final List c() {
        return this.c;
    }

    public final String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CX4)) {
            return false;
        }
        CX4 cx4 = (CX4) obj;
        return AbstractC13042fc3.d(this.a, cx4.a) && this.b == cx4.b && AbstractC13042fc3.d(this.c, cx4.c);
    }

    public int hashCode() {
        String str = this.a;
        return ((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PassportFieldGroup(title=" + this.a + ", inline=" + this.b + ", fields=" + this.c + Separators.RPAREN;
    }
}
