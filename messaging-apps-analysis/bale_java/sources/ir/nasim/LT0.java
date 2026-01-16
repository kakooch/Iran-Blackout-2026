package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC22148uk6;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class LT0 implements InterfaceC22148uk6 {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public LT0(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    public int a(long j) {
        return AbstractC9683aN7.i(this.e, j, true, true);
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        int iA = a(j);
        C23334wk6 c23334wk6 = new C23334wk6(this.e[iA], this.c[iA]);
        if (c23334wk6.a >= j || iA == this.a - 1) {
            return new InterfaceC22148uk6.a(c23334wk6);
        }
        int i = iA + 1;
        return new InterfaceC22148uk6.a(c23334wk6, new C23334wk6(this.e[i], this.c[i]));
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return true;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + Separators.RPAREN;
    }
}
