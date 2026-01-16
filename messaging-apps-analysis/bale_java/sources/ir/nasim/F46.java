package ir.nasim;

/* loaded from: classes2.dex */
public final class F46 {
    private final float a;
    private final float b;
    private final long c;
    private final int d;

    public F46(float f, float f2, long j, int i) {
        this.a = f;
        this.b = f2;
        this.c = j;
        this.d = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof F46) {
            F46 f46 = (F46) obj;
            if (f46.a == this.a && f46.b == this.b && f46.c == this.c && f46.d == this.d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.a + ",horizontalScrollPixels=" + this.b + ",uptimeMillis=" + this.c + ",deviceId=" + this.d + ')';
    }
}
