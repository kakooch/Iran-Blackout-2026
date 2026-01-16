package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class AG2 implements InterfaceC15283jK {
    private int a;

    public AG2(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AG2) && this.a == ((AG2) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "GetUserDefaultCard(userId=" + this.a + Separators.RPAREN;
    }
}
