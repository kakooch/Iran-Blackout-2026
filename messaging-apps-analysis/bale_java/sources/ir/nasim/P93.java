package ir.nasim;

/* loaded from: classes.dex */
public final class P93 {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public P93(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final int a() {
        return this.d;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P93)) {
            return false;
        }
        P93 p93 = (P93) obj;
        return this.a == p93.a && this.b == p93.b && this.c == p93.c && this.d == p93.d;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "InsetsValues(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ')';
    }
}
