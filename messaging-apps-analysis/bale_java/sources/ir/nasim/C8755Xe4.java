package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;

/* renamed from: ir.nasim.Xe4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C8755Xe4 implements Serializable {
    private final int a;
    private final long b;
    private final long c;
    private final int d;

    public C8755Xe4(int i, long j, long j2, int i2) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = i2;
    }

    public final int a() {
        return this.d;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8755Xe4)) {
            return false;
        }
        C8755Xe4 c8755Xe4 = (C8755Xe4) obj;
        return this.a == c8755Xe4.a && this.b == c8755Xe4.b && this.c == c8755Xe4.c && this.d == c8755Xe4.d;
    }

    public final long h() {
        return this.b;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public final long i() {
        return this.c;
    }

    public String toString() {
        return "Mid(peerId=" + this.a + ", date=" + this.b + ", rid=" + this.c + ", categoryId=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C8755Xe4(int i, long j, long j2, int i2, int i3, ED1 ed1) {
        this(i, j, j2, (i3 & 8) != 0 ? -1 : i2);
    }
}
