package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qS0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C19493qS0 {
    private final boolean a;
    private final boolean b;

    public C19493qS0(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19493qS0)) {
            return false;
        }
        C19493qS0 c19493qS0 = (C19493qS0) obj;
        return this.a == c19493qS0.a && this.b == c19493qS0.b;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "CheckPasswordResult(hasSetPassword=" + this.a + ", isSessionAuthorized=" + this.b + Separators.RPAREN;
    }
}
