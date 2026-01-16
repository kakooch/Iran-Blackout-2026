package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class MD7 extends AbstractC20556sC7 {
    private final int a;

    public MD7(int i) {
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
        return (obj instanceof MD7) && this.a == ((MD7) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "UpdateGroupBecameOrphaned(groupId=" + this.a + Separators.RPAREN;
    }
}
