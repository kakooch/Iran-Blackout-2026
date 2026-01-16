package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class ZI7 {
    private EnumC5052Hr5 a;
    private int b;
    private List c;
    private boolean d;

    public ZI7(EnumC5052Hr5 enumC5052Hr5, int i, List list, boolean z) {
        AbstractC13042fc3.i(enumC5052Hr5, "exceptionType");
        AbstractC13042fc3.i(list, "exceptionUserIdsList");
        this.a = enumC5052Hr5;
        this.b = i;
        this.c = list;
        this.d = z;
    }

    public final EnumC5052Hr5 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final List c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZI7)) {
            return false;
        }
        ZI7 zi7 = (ZI7) obj;
        return this.a == zi7.a && this.b == zi7.b && AbstractC13042fc3.d(this.c, zi7.c) && this.d == zi7.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "UserPrivacyConfig(exceptionType=" + this.a + ", exceptionUserIdsCount=" + this.b + ", exceptionUserIdsList=" + this.c + ", isActive=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ ZI7(EnumC5052Hr5 enumC5052Hr5, int i, List list, boolean z, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? EnumC5052Hr5.d : enumC5052Hr5, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? new ArrayList() : list, (i2 & 8) != 0 ? false : z);
    }
}
