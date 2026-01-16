package ir.nasim;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class BV3 {
    public static final BV3 j = new BV3(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final BV3 k = new BV3(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final BV3 l = new BV3(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final BV3 m = new BV3(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    double a;
    double b;
    double c;
    double d;
    double e;
    double f;
    double g;
    double h;
    double i;

    public BV3(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.a = d5;
        this.b = d6;
        this.c = d7;
        this.d = d;
        this.e = d2;
        this.f = d3;
        this.g = d4;
        this.h = d8;
        this.i = d9;
    }

    public static BV3 a(ByteBuffer byteBuffer) {
        return b(AbstractC5635Ke3.d(byteBuffer), AbstractC5635Ke3.d(byteBuffer), AbstractC5635Ke3.c(byteBuffer), AbstractC5635Ke3.d(byteBuffer), AbstractC5635Ke3.d(byteBuffer), AbstractC5635Ke3.c(byteBuffer), AbstractC5635Ke3.d(byteBuffer), AbstractC5635Ke3.d(byteBuffer), AbstractC5635Ke3.c(byteBuffer));
    }

    public static BV3 b(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return new BV3(d, d2, d4, d5, d3, d6, d9, d7, d8);
    }

    public void c(ByteBuffer byteBuffer) {
        AbstractC5869Le3.b(byteBuffer, this.d);
        AbstractC5869Le3.b(byteBuffer, this.e);
        AbstractC5869Le3.a(byteBuffer, this.a);
        AbstractC5869Le3.b(byteBuffer, this.f);
        AbstractC5869Le3.b(byteBuffer, this.g);
        AbstractC5869Le3.a(byteBuffer, this.b);
        AbstractC5869Le3.b(byteBuffer, this.h);
        AbstractC5869Le3.b(byteBuffer, this.i);
        AbstractC5869Le3.a(byteBuffer, this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BV3 bv3 = (BV3) obj;
        return Double.compare(bv3.d, this.d) == 0 && Double.compare(bv3.e, this.e) == 0 && Double.compare(bv3.f, this.f) == 0 && Double.compare(bv3.g, this.g) == 0 && Double.compare(bv3.h, this.h) == 0 && Double.compare(bv3.i, this.i) == 0 && Double.compare(bv3.a, this.a) == 0 && Double.compare(bv3.b, this.b) == 0 && Double.compare(bv3.c, this.c) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.a);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.b);
        int i = (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.c);
        int i2 = (i * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.d);
        int i3 = (i2 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.e);
        int i4 = (i3 * 31) + ((int) (jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32)));
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.f);
        int i5 = (i4 * 31) + ((int) (jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32)));
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.g);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)));
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.h);
        int i7 = (i6 * 31) + ((int) (jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32)));
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.i);
        return (i7 * 31) + ((int) ((jDoubleToLongBits9 >>> 32) ^ jDoubleToLongBits9));
    }

    public String toString() {
        if (equals(j)) {
            return "Rotate 0°";
        }
        if (equals(k)) {
            return "Rotate 90°";
        }
        if (equals(l)) {
            return "Rotate 180°";
        }
        if (equals(m)) {
            return "Rotate 270°";
        }
        return "Matrix{u=" + this.a + ", v=" + this.b + ", w=" + this.c + ", a=" + this.d + ", b=" + this.e + ", c=" + this.f + ", d=" + this.g + ", tx=" + this.h + ", ty=" + this.i + '}';
    }
}
