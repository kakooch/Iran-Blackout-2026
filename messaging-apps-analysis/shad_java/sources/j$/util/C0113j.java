package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0113j {
    private static final C0113j c = new C0113j();
    private final boolean a;
    private final double b;

    private C0113j() {
        this.a = false;
        this.b = Double.NaN;
    }

    private C0113j(double d) {
        this.a = true;
        this.b = d;
    }

    public static C0113j a() {
        return c;
    }

    public static C0113j d(double d) {
        return new C0113j(d);
    }

    public double b() {
        if (this.a) {
            return this.b;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0113j)) {
            return false;
        }
        C0113j c0113j = (C0113j) obj;
        boolean z = this.a;
        if (z && c0113j.a) {
            if (Double.compare(this.b, c0113j.b) == 0) {
                return true;
            }
        } else if (z == c0113j.a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.a) {
            return 0;
        }
        long jDoubleToLongBits = Double.doubleToLongBits(this.b);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public String toString() {
        return this.a ? String.format("OptionalDouble[%s]", Double.valueOf(this.b)) : "OptionalDouble.empty";
    }
}
