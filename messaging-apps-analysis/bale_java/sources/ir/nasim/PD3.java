package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class PD3 {
    private final C11458d25 a;
    private final long b;
    private final String c;
    private final long d;
    private final long e;
    private final String f;
    private final byte[] g;

    public PD3(C11458d25 c11458d25, long j, String str, long j2, long j3, String str2, byte[] bArr) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str2, "userCount");
        this.a = c11458d25;
        this.b = j;
        this.c = str;
        this.d = j2;
        this.e = j3;
        this.f = str2;
        this.g = bArr;
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.e;
    }

    public final long c() {
        return this.d;
    }

    public final C11458d25 d() {
        return this.a;
    }

    public final byte[] e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PD3)) {
            return false;
        }
        PD3 pd3 = (PD3) obj;
        return AbstractC13042fc3.d(this.a, pd3.a) && this.b == pd3.b && AbstractC13042fc3.d(this.c, pd3.c) && this.d == pd3.d && this.e == pd3.e && AbstractC13042fc3.d(this.f, pd3.f) && AbstractC13042fc3.d(this.g, pd3.g);
    }

    public final String f() {
        return this.c;
    }

    public final String g() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31;
        String str = this.c;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
        byte[] bArr = this.g;
        return iHashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public String toString() {
        return "LiveUiState(peer=" + this.a + ", liveKey=" + this.b + ", title=" + this.c + ", messageRid=" + this.d + ", messageDate=" + this.e + ", userCount=" + this.f + ", thumbnail=" + Arrays.toString(this.g) + Separators.RPAREN;
    }
}
