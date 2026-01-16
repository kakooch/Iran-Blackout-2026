package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.dX1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11741dX1 {
    private final C10361bX1 a;
    private final int b;
    private final int c;
    private final int d;

    public C11741dX1(C10361bX1 c10361bX1, int i, int i2, int i3) {
        this.a = c10361bX1;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final C10361bX1 a() {
        return this.a;
    }

    public final int b() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11741dX1)) {
            return false;
        }
        C11741dX1 c11741dX1 = (C11741dX1) obj;
        return AbstractC13042fc3.d(this.a, c11741dX1.a) && this.b == c11741dX1.b && this.c == c11741dX1.c && this.d == c11741dX1.d;
    }

    public int hashCode() {
        C10361bX1 c10361bX1 = this.a;
        return ((((((c10361bX1 == null ? 0 : c10361bX1.hashCode()) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "DomainImageLocation(fileLocation=" + this.a + ", width=" + this.b + ", height=" + this.c + ", fileSize=" + this.d + Separators.RPAREN;
    }
}
