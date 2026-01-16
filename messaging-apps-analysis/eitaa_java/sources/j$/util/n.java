package j$.util;

import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.E;
import j$.util.function.y;

/* loaded from: classes2.dex */
public class n implements E, y {
    private long count;
    private long sum;
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;

    @Override // j$.util.function.y
    public void accept(int i) {
        accept(i);
    }

    @Override // j$.util.function.E
    public void accept(long j) {
        this.count++;
        this.sum += j;
        this.min = Math.min(this.min, j);
        this.max = Math.max(this.max, j);
    }

    public void b(n nVar) {
        this.count += nVar.count;
        this.sum += nVar.sum;
        this.min = Math.min(this.min, nVar.min);
        this.max = Math.max(this.max, nVar.max);
    }

    @Override // j$.util.function.E
    public E f(E e) {
        e.getClass();
        return new C0099j(this, e);
    }

    @Override // j$.util.function.y
    public y k(y yVar) {
        yVar.getClass();
        return new C0098i(this, yVar);
    }

    public String toString() {
        double d;
        Object[] objArr = new Object[6];
        objArr[0] = n.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Long.valueOf(this.min);
        long j = this.count;
        if (j > 0) {
            double d2 = this.sum;
            double d3 = j;
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d2);
            Double.isNaN(d3);
            d = d2 / d3;
        } else {
            d = 0.0d;
        }
        objArr[4] = Double.valueOf(d);
        objArr[5] = Long.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
