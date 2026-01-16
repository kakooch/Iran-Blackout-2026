package j$.util;

import ir.eitaa.tgnet.ConnectionsManager;
import j$.util.function.C0098i;
import j$.util.function.y;

/* loaded from: classes2.dex */
public class m implements y {
    private long count;
    private long sum;
    private int min = ConnectionsManager.DEFAULT_DATACENTER_ID;
    private int max = Integer.MIN_VALUE;

    @Override // j$.util.function.y
    public void accept(int i) {
        this.count++;
        this.sum += i;
        this.min = Math.min(this.min, i);
        this.max = Math.max(this.max, i);
    }

    public void b(m mVar) {
        this.count += mVar.count;
        this.sum += mVar.sum;
        this.min = Math.min(this.min, mVar.min);
        this.max = Math.max(this.max, mVar.max);
    }

    @Override // j$.util.function.y
    public y k(y yVar) {
        yVar.getClass();
        return new C0098i(this, yVar);
    }

    public String toString() {
        double d;
        Object[] objArr = new Object[6];
        objArr[0] = m.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Integer.valueOf(this.min);
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
        objArr[5] = Integer.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
