package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.LP;

/* loaded from: classes4.dex */
public final class SB6 {
    private final boolean a;
    private final boolean b;
    private final LP c;
    private final long d;
    private final String e;
    private final U75 f;
    private final SQ g;
    private final long h;
    private final SQ i;
    private final long j;

    public SB6(boolean z, boolean z2, LP lp, long j, String str, U75 u75, SQ sq, long j2, SQ sq2, long j3) {
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(str, "transactionHash");
        AbstractC13042fc3.i(u75, "phoneData");
        AbstractC13042fc3.i(sq, "sentCodeType");
        AbstractC13042fc3.i(sq2, "nextSendCodeType");
        this.a = z;
        this.b = z2;
        this.c = lp;
        this.d = j;
        this.e = str;
        this.f = u75;
        this.g = sq;
        this.h = j2;
        this.i = sq2;
        this.j = j3;
    }

    public final SB6 a(boolean z, boolean z2, LP lp, long j, String str, U75 u75, SQ sq, long j2, SQ sq2, long j3) {
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(str, "transactionHash");
        AbstractC13042fc3.i(u75, "phoneData");
        AbstractC13042fc3.i(sq, "sentCodeType");
        AbstractC13042fc3.i(sq2, "nextSendCodeType");
        return new SB6(z, z2, lp, j, str, u75, sq, j2, sq2, j3);
    }

    public final long c() {
        return this.h;
    }

    public final LP d() {
        return this.c;
    }

    public final long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SB6)) {
            return false;
        }
        SB6 sb6 = (SB6) obj;
        return this.a == sb6.a && this.b == sb6.b && AbstractC13042fc3.d(this.c, sb6.c) && this.d == sb6.d && AbstractC13042fc3.d(this.e, sb6.e) && AbstractC13042fc3.d(this.f, sb6.f) && this.g == sb6.g && this.h == sb6.h && this.i == sb6.i && this.j == sb6.j;
    }

    public final boolean f() {
        return this.a;
    }

    public final SQ g() {
        return this.i;
    }

    public final long h() {
        return this.j;
    }

    public int hashCode() {
        return (((((((((((((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Long.hashCode(this.j);
    }

    public final U75 i() {
        return this.f;
    }

    public final SQ j() {
        return this.g;
    }

    public final String k() {
        return this.e;
    }

    public final boolean l() {
        return this.b;
    }

    public String toString() {
        return "SignPhoneState(futureToken=" + this.a + ", isLoading=" + this.b + ", error=" + this.c + ", fullPhoneNumber=" + this.d + ", transactionHash=" + this.e + ", phoneData=" + this.f + ", sentCodeType=" + this.g + ", codeTimeoutMillis=" + this.h + ", nextSendCodeType=" + this.i + ", nextSendCodeWaitTimeMillis=" + this.j + Separators.RPAREN;
    }

    public /* synthetic */ SB6(boolean z, boolean z2, LP lp, long j, String str, U75 u75, SQ sq, long j2, SQ sq2, long j3, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) == 0 ? z2 : false, (i & 4) != 0 ? LP.c.b : lp, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? new U75(null, null, null, 7, null) : u75, (i & 64) != 0 ? SQ.a : sq, (i & 128) != 0 ? 0L : j2, (i & 256) != 0 ? SQ.a : sq2, (i & 512) == 0 ? j3 : 0L);
    }
}
