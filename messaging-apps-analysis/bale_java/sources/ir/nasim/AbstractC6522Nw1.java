package ir.nasim;

/* renamed from: ir.nasim.Nw1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6522Nw1 {

    /* renamed from: ir.nasim.Nw1$a */
    static class a extends AbstractC6522Nw1 {
        double a;
        double[] b;

        a(double d, double[] dArr) {
            this.a = d;
            this.b = dArr;
        }

        @Override // ir.nasim.AbstractC6522Nw1
        public double c(double d, int i) {
            return this.b[i];
        }

        @Override // ir.nasim.AbstractC6522Nw1
        public void d(double d, double[] dArr) {
            double[] dArr2 = this.b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // ir.nasim.AbstractC6522Nw1
        public void e(double d, float[] fArr) {
            int i = 0;
            while (true) {
                double[] dArr = this.b;
                if (i >= dArr.length) {
                    return;
                }
                fArr[i] = (float) dArr[i];
                i++;
            }
        }

        @Override // ir.nasim.AbstractC6522Nw1
        public double f(double d, int i) {
            return 0.0d;
        }

        @Override // ir.nasim.AbstractC6522Nw1
        public void g(double d, double[] dArr) {
            for (int i = 0; i < this.b.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        @Override // ir.nasim.AbstractC6522Nw1
        public double[] h() {
            return new double[]{this.a};
        }
    }

    public static AbstractC6522Nw1 a(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        return i != 0 ? i != 2 ? new C5824Kz3(dArr, dArr2) : new a(dArr[0], dArr2[0]) : new C14932ij4(dArr, dArr2);
    }

    public static AbstractC6522Nw1 b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new NI(iArr, dArr, dArr2);
    }

    public abstract double c(double d, int i);

    public abstract void d(double d, double[] dArr);

    public abstract void e(double d, float[] fArr);

    public abstract double f(double d, int i);

    public abstract void g(double d, double[] dArr);

    public abstract double[] h();
}
