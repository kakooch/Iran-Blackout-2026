package ir.nasim;

/* renamed from: ir.nasim.mz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17449mz1 {
    private long a;
    private float b;

    public C17449mz1(long j, float f) {
        this.a = j;
        this.b = f;
    }

    public final float a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public final void c(float f) {
        this.b = f;
    }

    public final void d(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17449mz1)) {
            return false;
        }
        C17449mz1 c17449mz1 = (C17449mz1) obj;
        return this.a == c17449mz1.a && Float.compare(this.b, c17449mz1.b) == 0;
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + Float.hashCode(this.b);
    }

    public String toString() {
        return "DataPointAtTime(time=" + this.a + ", dataPoint=" + this.b + ')';
    }
}
