package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class QF7 extends AbstractC20556sC7 {
    private final int a;

    public QF7(int i) {
        super(null);
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QF7) && this.a == ((QF7) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "UpdateUserBlocked(uid=" + this.a + Separators.RPAREN;
    }
}
