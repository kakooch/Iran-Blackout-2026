package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.kA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15792kA7 extends AbstractC22207uq5 {
    private long[] a;
    private int b;

    public /* synthetic */ C15792kA7(long[] jArr, ED1 ed1) {
        this(jArr);
    }

    @Override // ir.nasim.AbstractC22207uq5
    public /* bridge */ /* synthetic */ Object a() {
        return C15201jA7.f(f());
    }

    @Override // ir.nasim.AbstractC22207uq5
    public void b(int i) {
        if (C15201jA7.B(this.a) < i) {
            long[] jArr = this.a;
            long[] jArrCopyOf = Arrays.copyOf(jArr, AbstractC23053wG5.e(i, C15201jA7.B(jArr) * 2));
            AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
            this.a = C15201jA7.i(jArrCopyOf);
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
        C15201jA7.I(jArr, iD, j);
    }

    public long[] f() {
        long[] jArrCopyOf = Arrays.copyOf(this.a, d());
        AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
        return C15201jA7.i(jArrCopyOf);
    }

    private C15792kA7(long[] jArr) {
        AbstractC13042fc3.i(jArr, "bufferWithData");
        this.a = jArr;
        this.b = C15201jA7.B(jArr);
        b(10);
    }
}
