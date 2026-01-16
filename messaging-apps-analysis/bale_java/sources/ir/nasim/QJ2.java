package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class QJ2 {
    private final boolean a;
    private final Long b;
    private final boolean c;

    public QJ2(boolean z, Long l, boolean z2) {
        this.a = z;
        this.b = l;
        this.c = z2;
    }

    public static /* synthetic */ QJ2 b(QJ2 qj2, boolean z, Long l, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = qj2.a;
        }
        if ((i & 2) != 0) {
            l = qj2.b;
        }
        if ((i & 4) != 0) {
            z2 = qj2.c;
        }
        return qj2.a(z, l, z2);
    }

    public final QJ2 a(boolean z, Long l, boolean z2) {
        return new QJ2(z, l, z2);
    }

    public final Long c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QJ2)) {
            return false;
        }
        QJ2 qj2 = (QJ2) obj;
        return this.a == qj2.a && AbstractC13042fc3.d(this.b, qj2.b) && this.c == qj2.c;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.a) * 31;
        Long l = this.b;
        return ((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "GoldWalletUI(isAuthenticated=" + this.a + ", balance=" + this.b + ", isLoading=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ QJ2(boolean z, Long l, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : l, (i & 4) != 0 ? false : z2);
    }
}
