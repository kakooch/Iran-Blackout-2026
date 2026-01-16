package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class WP1 {
    private final long a;
    private final String b;

    public WP1(long j, String str) {
        this.a = j;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WP1)) {
            return false;
        }
        WP1 wp1 = (WP1) obj;
        return this.a == wp1.a && AbstractC13042fc3.d(this.b, wp1.b);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DialogWithFoldersList(peerUid=" + this.a + ", foldersList=" + this.b + Separators.RPAREN;
    }
}
