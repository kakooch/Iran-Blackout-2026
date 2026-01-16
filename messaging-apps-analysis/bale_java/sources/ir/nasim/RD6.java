package ir.nasim;

/* loaded from: classes7.dex */
public final class RD6 {
    public final int a;
    public final int b;

    public RD6(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RD6)) {
            return false;
        }
        RD6 rd6 = (RD6) obj;
        return this.a == rd6.a && this.b == rd6.b;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = this.a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
