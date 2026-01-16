package ir.nasim;

import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.f63, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12730f63 implements InterfaceC22148uk6 {
    private final long[] a;
    private final long[] b;
    private final long c;
    private final boolean d;

    public C12730f63(long[] jArr, long[] jArr2, long j) {
        AbstractC20011rK.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.d = z;
        if (!z || jArr2[0] <= 0) {
            this.a = jArr;
            this.b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.a = jArr3;
            long[] jArr4 = new long[i];
            this.b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.c = j;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        if (!this.d) {
            return new InterfaceC22148uk6.a(C23334wk6.c);
        }
        int i = AbstractC9683aN7.i(this.b, j, true, true);
        C23334wk6 c23334wk6 = new C23334wk6(this.b[i], this.a[i]);
        if (c23334wk6.a == j || i == this.b.length - 1) {
            return new InterfaceC22148uk6.a(c23334wk6);
        }
        int i2 = i + 1;
        return new InterfaceC22148uk6.a(c23334wk6, new C23334wk6(this.b[i2], this.a[i2]));
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.c;
    }
}
