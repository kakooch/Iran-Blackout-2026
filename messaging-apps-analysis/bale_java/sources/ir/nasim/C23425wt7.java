package ir.nasim;

/* renamed from: ir.nasim.wt7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23425wt7 {
    private final String a;
    private final long b;

    public C23425wt7(String str, long j) {
        AbstractC13042fc3.i(str, "codec");
        this.a = str;
        this.b = j;
    }

    public final String a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23425wt7)) {
            return false;
        }
        C23425wt7 c23425wt7 = (C23425wt7) obj;
        return AbstractC13042fc3.d(this.a, c23425wt7.a) && this.b == c23425wt7.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "TrackBitrateInfo(codec=" + this.a + ", maxBitrate=" + this.b + ')';
    }
}
