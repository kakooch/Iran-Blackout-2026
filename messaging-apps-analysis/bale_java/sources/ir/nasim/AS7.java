package ir.nasim;

/* loaded from: classes3.dex */
public final class AS7 {
    private final int a;
    private final int b;
    private final int c;
    private final boolean d;

    public AS7(int i, int i2, int i3, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
    }

    public final boolean a() {
        return this.d;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AS7)) {
            return false;
        }
        AS7 as7 = (AS7) obj;
        return this.a == as7.a && this.b == as7.b && this.c == as7.c && this.d == as7.d;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "VideoCaptureParameter(width=" + this.a + ", height=" + this.b + ", maxFps=" + this.c + ", adaptOutputToDimensions=" + this.d + ')';
    }

    public /* synthetic */ AS7(int i, int i2, int i3, boolean z, int i4, ED1 ed1) {
        this(i, i2, i3, (i4 & 8) != 0 ? true : z);
    }
}
