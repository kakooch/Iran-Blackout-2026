package ir.nasim;

import java.util.Arrays;

/* loaded from: classes8.dex */
public final class ZI3 extends AbstractC22207uq5 {
    private long[] a;
    private int b;

    public ZI3(long[] jArr) {
        AbstractC13042fc3.i(jArr, "bufferWithData");
        this.a = jArr;
        this.b = jArr.length;
        b(10);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        long[] jArr = this.a;
        if (jArr.length < i) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, AbstractC23053wG5.e(i, jArr.length * 2));
            AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
            this.a = jArrCopyOf;
        }
    }

    @Override // ir.nasim.AbstractC22207uq5
    public int d() {
        return this.b;
    }

    public final void e(long j) {
        AbstractC22207uq5.c(this, 0, 1, null);
        long[] jArr = this.a;
        int iD = d();
        this.b = iD + 1;
        jArr[iD] = j;
    }

    @Override // ir.nasim.AbstractC22207uq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public long[] a() {
        long[] jArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }
}
