package ir.nasim;

import java.util.Arrays;

/* loaded from: classes8.dex */
public final class BA7 extends AbstractC22207uq5 {
    private short[] a;
    private int b;

    public /* synthetic */ BA7(short[] sArr, ED1 ed1) {
        this(sArr);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public /* bridge */ /* synthetic */ Object a() {
        return AA7.f(f());
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        if (AA7.B(this.a) < i) {
            short[] sArr = this.a;
            short[] sArrCopyOf = Arrays.copyOf(sArr, AbstractC23053wG5.e(i, AA7.B(sArr) * 2));
            AbstractC13042fc3.h(sArrCopyOf, "copyOf(...)");
            this.a = AA7.i(sArrCopyOf);
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
        AA7.I(sArr, iD, s);
    }

    public short[] f() {
        short[] sArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(sArrCopyOf, "copyOf(...)");
        return AA7.i(sArrCopyOf);
    }

    private BA7(short[] sArr) {
        AbstractC13042fc3.i(sArr, "bufferWithData");
        this.a = sArr;
        this.b = AA7.B(sArr);
        b(10);
    }
}
