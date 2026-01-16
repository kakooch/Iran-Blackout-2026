package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aS7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9728aS7 {
    private final int a;

    public C9728aS7(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9728aS7) && this.a == ((C9728aS7) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "VersionCodeNumber(number=" + this.a + Separators.RPAREN;
    }
}
