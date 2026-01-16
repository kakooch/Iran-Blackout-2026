package ir.nasim;

import org.xbill.DNS.TTL;

/* loaded from: classes.dex */
public final class DT4 implements CT4 {
    private final int b;

    public DT4(int i) {
        this.b = i;
    }

    @Override // ir.nasim.CT4
    public int a(int i, int i2, float f, int i3, int i4) {
        long j = i;
        return AbstractC23053wG5.m(i2, (int) AbstractC23053wG5.f(j - this.b, 0L), (int) AbstractC23053wG5.j(j + this.b, TTL.MAX_VALUE));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DT4) && this.b == ((DT4) obj).b;
    }

    public int hashCode() {
        return Integer.hashCode(this.b);
    }
}
