package ir.nasim;

import ir.nasim.C3846Cp2;
import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.Bp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3612Bp2 implements InterfaceC22148uk6 {
    private final C3846Cp2 a;
    private final long b;

    public C3612Bp2(C3846Cp2 c3846Cp2, long j) {
        this.a = c3846Cp2;
        this.b = j;
    }

    private C23334wk6 a(long j, long j2) {
        return new C23334wk6((j * 1000000) / this.a.e, this.b + j2);
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        AbstractC20011rK.i(this.a.k);
        C3846Cp2 c3846Cp2 = this.a;
        C3846Cp2.a aVar = c3846Cp2.k;
        long[] jArr = aVar.a;
        long[] jArr2 = aVar.b;
        int i = AbstractC9683aN7.i(jArr, c3846Cp2.i(j), true, false);
        C23334wk6 c23334wk6A = a(i == -1 ? 0L : jArr[i], i != -1 ? jArr2[i] : 0L);
        if (c23334wk6A.a == j || i == jArr.length - 1) {
            return new InterfaceC22148uk6.a(c23334wk6A);
        }
        int i2 = i + 1;
        return new InterfaceC22148uk6.a(c23334wk6A, a(jArr[i2], jArr2[i2]));
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return true;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.a.f();
    }
}
