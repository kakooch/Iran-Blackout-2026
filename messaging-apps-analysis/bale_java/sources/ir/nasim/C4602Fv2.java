package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;

/* renamed from: ir.nasim.Fv2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4602Fv2 {
    private final Spannable a;
    private final int b;
    private final long c;
    private final long d;
    private final C11458d25 e;

    public C4602Fv2(Spannable spannable, int i, long j, long j2, C11458d25 c11458d25) {
        this.a = spannable;
        this.b = i;
        this.c = j;
        this.d = j2;
        this.e = c11458d25;
    }

    public final long a() {
        return this.d;
    }

    public final Spannable b() {
        return this.a;
    }

    public final long c() {
        return this.c;
    }

    public final C11458d25 d() {
        return this.e;
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4602Fv2)) {
            return false;
        }
        C4602Fv2 c4602Fv2 = (C4602Fv2) obj;
        return AbstractC13042fc3.d(this.a, c4602Fv2.a) && this.b == c4602Fv2.b && this.c == c4602Fv2.c && this.d == c4602Fv2.d && AbstractC13042fc3.d(this.e, c4602Fv2.e);
    }

    public int hashCode() {
        Spannable spannable = this.a;
        int iHashCode = (((((((spannable == null ? 0 : spannable.hashCode()) * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31;
        C11458d25 c11458d25 = this.e;
        return iHashCode + (c11458d25 != null ? c11458d25.hashCode() : 0);
    }

    public String toString() {
        Spannable spannable = this.a;
        return "Forward(forwardFrom=" + ((Object) spannable) + ", publicGroupId=" + this.b + ", messageId=" + this.c + ", date=" + this.d + ", peer=" + this.e + Separators.RPAREN;
    }
}
