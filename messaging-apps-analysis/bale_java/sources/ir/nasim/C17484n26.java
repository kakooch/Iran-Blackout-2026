package ir.nasim;

/* renamed from: ir.nasim.n26, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17484n26 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    public C17484n26(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17484n26)) {
            return false;
        }
        C17484n26 c17484n26 = (C17484n26) obj;
        return this.a == c17484n26.a && this.b == c17484n26.b && this.c == c17484n26.c && this.d == c17484n26.d;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }

    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.a + ", focusedAlpha=" + this.b + ", hoveredAlpha=" + this.c + ", pressedAlpha=" + this.d + ')';
    }
}
