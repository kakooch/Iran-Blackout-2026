package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.gK6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13499gK6 {
    private final boolean a;
    private final boolean b;
    private final J35 c;

    public C13499gK6(boolean z, boolean z2, J35 j35) {
        this.a = z;
        this.b = z2;
        this.c = j35;
    }

    public static /* synthetic */ C13499gK6 b(C13499gK6 c13499gK6, boolean z, boolean z2, J35 j35, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c13499gK6.a;
        }
        if ((i & 2) != 0) {
            z2 = c13499gK6.b;
        }
        if ((i & 4) != 0) {
            j35 = c13499gK6.c;
        }
        return c13499gK6.a(z, z2, j35);
    }

    public final C13499gK6 a(boolean z, boolean z2, J35 j35) {
        return new C13499gK6(z, z2, j35);
    }

    public final boolean c() {
        return this.b;
    }

    public final J35 d() {
        return this.c;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13499gK6)) {
            return false;
        }
        C13499gK6 c13499gK6 = (C13499gK6) obj;
        return this.a == c13499gK6.a && this.b == c13499gK6.b && AbstractC13042fc3.d(this.c, c13499gK6.c);
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31;
        J35 j35 = this.c;
        return iHashCode + (j35 == null ? 0 : j35.hashCode());
    }

    public String toString() {
        return "StartOutGoingCallState(isNeedCloseActivity=" + this.a + ", canCallStart=" + this.b + ", permissionRequired=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C13499gK6(boolean z, boolean z2, J35 j35, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : j35);
    }
}
