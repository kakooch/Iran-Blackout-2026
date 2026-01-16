package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.gX1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13611gX1 extends AbstractC22207uq5 {
    private double[] a;
    private int b;

    public C13611gX1(double[] dArr) {
        AbstractC13042fc3.i(dArr, "bufferWithData");
        this.a = dArr;
        this.b = dArr.length;
        b(10);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        double[] dArr = this.a;
        if (dArr.length < i) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, AbstractC23053wG5.e(i, dArr.length * 2));
            AbstractC13042fc3.h(dArrCopyOf, "copyOf(...)");
            this.a = dArrCopyOf;
        }
    }

    @Override // ir.nasim.AbstractC22207uq5
    public int d() {
        return this.b;
    }

    public final void e(double d) {
        AbstractC22207uq5.c(this, 0, 1, null);
        double[] dArr = this.a;
        int iD = d();
        this.b = iD + 1;
        dArr[iD] = d;
    }

    @Override // ir.nasim.AbstractC22207uq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }
}
