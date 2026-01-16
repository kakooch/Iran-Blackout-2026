package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class X34 {
    private final C11458d25 a;
    private final boolean b;

    public X34(C11458d25 c11458d25, boolean z) {
        this.a = c11458d25;
        this.b = z;
    }

    public static /* synthetic */ X34 b(X34 x34, C11458d25 c11458d25, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            c11458d25 = x34.a;
        }
        if ((i & 2) != 0) {
            z = x34.b;
        }
        return x34.a(c11458d25, z);
    }

    public final X34 a(C11458d25 c11458d25, boolean z) {
        return new X34(c11458d25, z);
    }

    public final boolean c() {
        return this.b;
    }

    public final C11458d25 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X34)) {
            return false;
        }
        X34 x34 = (X34) obj;
        return AbstractC13042fc3.d(this.a, x34.a) && this.b == x34.b;
    }

    public int hashCode() {
        C11458d25 c11458d25 = this.a;
        return ((c11458d25 == null ? 0 : c11458d25.hashCode()) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "MentionData(peer=" + this.a + ", hasNickName=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ X34(C11458d25 c11458d25, boolean z, int i, ED1 ed1) {
        this(c11458d25, (i & 2) != 0 ? true : z);
    }
}
