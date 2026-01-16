package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.xz6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24070xz6 extends AbstractC22207uq5 {
    private short[] a;
    private int b;

    public C24070xz6(short[] sArr) {
        AbstractC13042fc3.i(sArr, "bufferWithData");
        this.a = sArr;
        this.b = sArr.length;
        b(10);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        short[] sArr = this.a;
        if (sArr.length < i) {
            short[] sArrCopyOf = Arrays.copyOf(sArr, AbstractC23053wG5.e(i, sArr.length * 2));
            AbstractC13042fc3.h(sArrCopyOf, "copyOf(...)");
            this.a = sArrCopyOf;
        }
    }

    @Override // ir.nasim.AbstractC22207uq5
    public int d() {
        return this.b;
    }

    public final void e(short s) {
        AbstractC22207uq5.c(this, 0, 1, null);
        short[] sArr = this.a;
        int iD = d();
        this.b = iD + 1;
        sArr[iD] = s;
    }

    @Override // ir.nasim.AbstractC22207uq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] sArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }
}
