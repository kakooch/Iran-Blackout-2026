package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9620aG7 extends AbstractC20556sC7 {
    private final int a;

    public C9620aG7(int i) {
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
        return (obj instanceof C9620aG7) && this.a == ((C9620aG7) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "UpdateUserDefaultCardNumberRemoved(uid=" + this.a + Separators.RPAREN;
    }
}
