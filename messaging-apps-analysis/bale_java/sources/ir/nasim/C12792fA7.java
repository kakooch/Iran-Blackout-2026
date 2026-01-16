package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.fA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12792fA7 extends AbstractC22207uq5 {
    private int[] a;
    private int b;

    public /* synthetic */ C12792fA7(int[] iArr, ED1 ed1) {
        this(iArr);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public /* bridge */ /* synthetic */ Object a() {
        return C12183eA7.f(f());
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        if (C12183eA7.B(this.a) < i) {
            int[] iArr = this.a;
            int[] iArrCopyOf = Arrays.copyOf(iArr, AbstractC23053wG5.e(i, C12183eA7.B(iArr) * 2));
            AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
            this.a = C12183eA7.i(iArrCopyOf);
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
        C12183eA7.I(iArr, iD, i);
    }

    public int[] f() {
        int[] iArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
        return C12183eA7.i(iArrCopyOf);
    }

    private C12792fA7(int[] iArr) {
        AbstractC13042fc3.i(iArr, "bufferWithData");
        this.a = iArr;
        this.b = C12183eA7.B(iArr);
        b(10);
    }
}
