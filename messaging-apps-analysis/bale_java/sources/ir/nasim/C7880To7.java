package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.To7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7880To7 extends AbstractC17902nl0 {
    private long a;
    private long b;
    private final HQ0 c;

    public C7880To7(long j, long j2, HQ0 hq0) {
        AbstractC13042fc3.i(hq0, "chatSpot");
        this.a = j;
        this.b = j2;
        this.c = hq0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7880To7)) {
            return false;
        }
        C7880To7 c7880To7 = (C7880To7) obj;
        return this.a == c7880To7.a && this.b == c7880To7.b;
    }

    public final long h() {
        return this.b;
    }

    public int hashCode() {
        return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public final long i() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0 != null ? c19084pl0.y(1) : 0L;
        this.a = c19084pl0 != null ? c19084pl0.y(2) : 0L;
    }

    public final HQ0 q() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        if (c19675ql0 != null) {
            c19675ql0.g(1, this.b);
        }
        if (c19675ql0 != null) {
            c19675ql0.g(2, this.a);
        }
    }

    public String toString() {
        return "ThreadId(rid=" + this.a + ", date=" + this.b + ", chatSpot=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C7880To7(long j, long j2, HQ0 hq0, int i, ED1 ed1) {
        this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? HQ0.b : hq0);
    }
}
