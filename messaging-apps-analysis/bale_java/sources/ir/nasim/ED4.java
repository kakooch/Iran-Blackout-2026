package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class ED4 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    public ED4(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
    }

    public final boolean a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ED4)) {
            return false;
        }
        ED4 ed4 = (ED4) obj;
        return this.a == ed4.a && this.b == ed4.b && this.c == ed4.c && this.d == ed4.d && this.e == ed4.e;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "NotificationPolicy(canReply=" + this.a + ", canRead=" + this.b + ", shouldDownloadPhoto=" + this.c + ", shouldDownloadSticker=" + this.d + ", canWakeupScreen=" + this.e + Separators.RPAREN;
    }
}
