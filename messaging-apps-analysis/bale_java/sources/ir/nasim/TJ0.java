package ir.nasim;

import java.util.Arrays;

/* loaded from: classes8.dex */
public final class TJ0 extends AbstractC22207uq5 {
    private char[] a;
    private int b;

    public TJ0(char[] cArr) {
        AbstractC13042fc3.i(cArr, "bufferWithData");
        this.a = cArr;
        this.b = cArr.length;
        b(10);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        char[] cArr = this.a;
        if (cArr.length < i) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, AbstractC23053wG5.e(i, cArr.length * 2));
            AbstractC13042fc3.h(cArrCopyOf, "copyOf(...)");
            this.a = cArrCopyOf;
        }
    }

    @Override // ir.nasim.AbstractC22207uq5
    public int d() {
        return this.b;
    }

    public final void e(char c) {
        AbstractC22207uq5.c(this, 0, 1, null);
        char[] cArr = this.a;
        int iD = d();
        this.b = iD + 1;
        cArr[iD] = c;
    }

    @Override // ir.nasim.AbstractC22207uq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] cArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }
}
