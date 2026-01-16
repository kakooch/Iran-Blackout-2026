package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Set;

/* renamed from: ir.nasim.Xi5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8792Xi5 {
    private final boolean a;
    private final boolean b;
    private final long c;
    private final long d;
    private final Set e;

    public C8792Xi5(boolean z, boolean z2, long j, long j2, Set set) {
        AbstractC13042fc3.i(set, "totalCachedSpans");
        this.a = z;
        this.b = z2;
        this.c = j;
        this.d = j2;
        this.e = set;
    }

    public final long a() {
        return this.d;
    }

    public final Set b() {
        return this.e;
    }

    public final long c() {
        return this.c;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8792Xi5)) {
            return false;
        }
        C8792Xi5 c8792Xi5 = (C8792Xi5) obj;
        return this.a == c8792Xi5.a && this.b == c8792Xi5.b && this.c == c8792Xi5.c && this.d == c8792Xi5.d && AbstractC13042fc3.d(this.e, c8792Xi5.e);
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "PositionState(isPlaying=" + this.a + ", isSeeking=" + this.b + ", totalDurationMs=" + this.c + ", currentPositionMs=" + this.d + ", totalCachedSpans=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C8792Xi5(boolean z, boolean z2, long j, long j2, Set set, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) == 0 ? z2 : false, (i & 4) != 0 ? 0L : j, (i & 8) == 0 ? j2 : 0L, (i & 16) != 0 ? AbstractC4597Fu6.d() : set);
    }
}
