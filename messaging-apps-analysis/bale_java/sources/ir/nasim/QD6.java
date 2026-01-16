package ir.nasim;

/* loaded from: classes2.dex */
public final class QD6 {
    public static final QD6 c = new QD6(-1, -1);
    public static final QD6 d = new QD6(0, 0);
    private final int a;
    private final int b;

    public QD6(int i, int i2) {
        AbstractC20011rK.a((i == -1 || i >= 0) && (i2 == -1 || i2 >= 0));
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
        if (!(obj instanceof QD6)) {
            return false;
        }
        QD6 qd6 = (QD6) obj;
        return this.a == qd6.a && this.b == qd6.b;
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
