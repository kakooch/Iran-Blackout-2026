package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class AJ6 {
    private final int a;
    private final BJ6 b;

    public AJ6(int i, BJ6 bj6) {
        AbstractC13042fc3.i(bj6, "type");
        this.a = i;
        this.b = bj6;
    }

    public final int a() {
        return this.a;
    }

    public final BJ6 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AJ6)) {
            return false;
        }
        AJ6 aj6 = (AJ6) obj;
        return this.a == aj6.a && this.b == aj6.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "StablePagerTab(id=" + this.a + ", type=" + this.b + Separators.RPAREN;
    }
}
