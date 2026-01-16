package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.ia3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14842ia3 extends AbstractC22207uq5 {
    private int[] a;
    private int b;

    public C14842ia3(int[] iArr) {
        AbstractC13042fc3.i(iArr, "bufferWithData");
        this.a = iArr;
        this.b = iArr.length;
        b(10);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        int[] iArr = this.a;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, AbstractC23053wG5.e(i, iArr.length * 2));
            AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
        }
    }

    @Override // ir.nasim.AbstractC22207uq5
    public int d() {
        return this.b;
    }

    public final void e(int i) {
        AbstractC22207uq5.c(this, 0, 1, null);
        int[] iArr = this.a;
        int iD = d();
        this.b = iD + 1;
        iArr[iD] = i;
    }

    @Override // ir.nasim.AbstractC22207uq5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] iArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }
}
