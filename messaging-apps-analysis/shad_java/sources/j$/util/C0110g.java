package j$.util;

/* renamed from: j$.util.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0110g implements j$.util.function.f {
    private double a;
    private double b;
    private long count;
    private double sum;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    private void d(double d) {
        double d2 = d - this.a;
        double d3 = this.sum;
        double d4 = d3 + d2;
        this.a = (d4 - d3) - d2;
        this.sum = d4;
    }

    public void a(C0110g c0110g) {
        this.count += c0110g.count;
        this.b += c0110g.b;
        d(c0110g.sum);
        d(c0110g.a);
        this.min = Math.min(this.min, c0110g.min);
        this.max = Math.max(this.max, c0110g.max);
    }

    @Override // j$.util.function.f
    public void accept(double d) {
        this.count++;
        this.b += d;
        d(d);
        this.min = Math.min(this.min, d);
        this.max = Math.max(this.max, d);
    }

    public final double c() {
        double d = this.sum + this.a;
        return (Double.isNaN(d) && Double.isInfinite(this.b)) ? this.b : d;
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }

    public String toString() {
        double d;
        Object[] objArr = new Object[6];
        objArr[0] = C0110g.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Double.valueOf(c());
        objArr[3] = Double.valueOf(this.min);
        if (this.count > 0) {
            double dC = c();
            double d2 = this.count;
            Double.isNaN(d2);
            Double.isNaN(d2);
            d = dC / d2;
        } else {
            d = 0.0d;
        }
        objArr[4] = Double.valueOf(d);
        objArr[5] = Double.valueOf(this.max);
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", objArr);
    }
}
