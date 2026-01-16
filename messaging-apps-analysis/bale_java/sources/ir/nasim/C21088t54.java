package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.t54, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21088t54 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public C21088t54(boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21088t54)) {
            return false;
        }
        C21088t54 c21088t54 = (C21088t54) obj;
        return this.a == c21088t54.a && this.b == c21088t54.b && this.c == c21088t54.c && this.d == c21088t54.d;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "MessageAttributes(isNotified=" + this.a + ", isMentioned=" + this.b + ", isOnlyForYou=" + this.c + ", isHighlighted=" + this.d + Separators.RPAREN;
    }
}
