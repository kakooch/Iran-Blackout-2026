package ir.nasim;

import android.util.Pair;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.Uf4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C8030Uf4 implements InterfaceC24514yk6 {
    private final long[] a;
    private final long[] b;
    private final long c;

    private C8030Uf4(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j == -9223372036854775807L ? AbstractC9683aN7.B0(jArr2[jArr2.length - 1]) : j;
    }

    public static C8030Uf4 a(long j, MlltFrame mlltFrame, long j2) {
        int length = mlltFrame.e.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += mlltFrame.c + mlltFrame.e[i3];
            j3 += mlltFrame.d + mlltFrame.f[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new C8030Uf4(jArr, jArr2, j2);
    }

    private static Pair b(long j, long[] jArr, long[] jArr2) {
        int i = AbstractC9683aN7.i(jArr, j, true, true);
        long j2 = jArr[i];
        long j3 = jArr2[i];
        int i2 = i + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr[i2] == j2 ? 0.0d : (j - j2) / (r6 - j2)) * (jArr2[i2] - j3))) + j3));
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        Pair pairB = b(AbstractC9683aN7.c1(AbstractC9683aN7.q(j, 0L, this.c)), this.b, this.a);
        return new InterfaceC22148uk6.a(new C23334wk6(AbstractC9683aN7.B0(((Long) pairB.first).longValue()), ((Long) pairB.second).longValue()));
    }

    @Override // ir.nasim.InterfaceC24514yk6
    public long f() {
        return -1L;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return true;
    }

    @Override // ir.nasim.InterfaceC24514yk6
    public long h(long j) {
        return AbstractC9683aN7.B0(((Long) b(j, this.a, this.b).second).longValue());
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.c;
    }
}
