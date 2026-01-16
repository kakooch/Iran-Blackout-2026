package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.Rh0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7337Rh0 extends AbstractC22207uq5 {
    private boolean[] a;
    private int b;

    public C7337Rh0(boolean[] zArr) {
        AbstractC13042fc3.i(zArr, "bufferWithData");
        this.a = zArr;
        this.b = zArr.length;
        b(10);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        boolean[] zArr = this.a;
        if (zArr.length < i) {
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, AbstractC23053wG5.e(i, zArr.length * 2));
            AbstractC13042fc3.h(zArrCopyOf, "copyOf(...)");
            this.a = zArrCopyOf;
        }
    }

    @Override // ir.nasim.AbstractC22207uq5
    public int d() {
        return this.b;
    }

    public final void e(boolean z) {
        AbstractC22207uq5.c(this, 0, 1, null);
        boolean[] zArr = this.a;
        int iD = d();
        this.b = iD + 1;
        zArr[iD] = z;
    }

    @Override // ir.nasim.AbstractC22207uq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }
}
