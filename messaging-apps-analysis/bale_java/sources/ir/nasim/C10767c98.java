package ir.nasim;

/* renamed from: ir.nasim.c98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10767c98 {
    private final float a;
    private final float b;

    public C10767c98(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final float[] c() {
        float f = this.a;
        float f2 = this.b;
        return new float[]{f / f2, 1.0f, ((1.0f - f) - f2) / f2};
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10767c98)) {
            return false;
        }
        C10767c98 c10767c98 = (C10767c98) obj;
        return Float.compare(this.a, c10767c98.a) == 0 && Float.compare(this.b, c10767c98.b) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.a) * 31) + Float.hashCode(this.b);
    }

    public String toString() {
        return "WhitePoint(x=" + this.a + ", y=" + this.b + ')';
    }
}
