package j$.util;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class o {
    private static final o a = new o();
    private final boolean b;
    private final double c;

    private o() {
        this.b = false;
        this.c = Double.NaN;
    }

    private o(double d) {
        this.b = true;
        this.c = d;
    }

    public static o a() {
        return a;
    }

    public static o d(double d) {
        return new o(d);
    }

    public double b() {
        if (this.b) {
            return this.c;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        boolean z = this.b;
        if (z && oVar.b) {
            if (Double.compare(this.c, oVar.c) == 0) {
                return true;
            }
        } else if (z == oVar.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.b) {
            return 0;
        }
        long jDoubleToLongBits = Double.doubleToLongBits(this.c);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public String toString() {
        return this.b ? String.format("OptionalDouble[%s]", Double.valueOf(this.c)) : "OptionalDouble.empty";
    }
}
