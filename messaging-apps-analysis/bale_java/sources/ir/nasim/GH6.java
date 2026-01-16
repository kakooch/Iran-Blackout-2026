package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class GH6 {
    private final String a;
    private final boolean b;

    public GH6(String str, boolean z) {
        AbstractC13042fc3.i(str, "userUniqId");
        this.a = str;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GH6)) {
            return false;
        }
        GH6 gh6 = (GH6) obj;
        return AbstractC13042fc3.d(this.a, gh6.a) && this.b == gh6.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "SortedRemoteParticipant(userUniqId=" + this.a + ", isCameraEnabled=" + this.b + Separators.RPAREN;
    }
}
