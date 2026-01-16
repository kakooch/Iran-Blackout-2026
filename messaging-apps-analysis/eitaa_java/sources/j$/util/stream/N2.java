package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.F1;
import j$.util.stream.T1;
import j$.util.stream.U1;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class N2 extends F1.h<Long> {
    N2(AbstractC0148l1 abstractC0148l1) {
        super(abstractC0148l1, W2.LONG_VALUE, V2.l | V2.j);
    }

    @Override // j$.util.stream.AbstractC0148l1
    public T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
        if (V2.SORTED.n(v1.q0())) {
            return v1.n0(spliterator, false, zVar);
        }
        long[] jArr = (long[]) ((T1.d) v1.n0(spliterator, true, zVar)).e();
        Arrays.sort(jArr);
        return new U1.p(jArr);
    }

    @Override // j$.util.stream.AbstractC0148l1
    public C2 F0(int i, C2 c2) {
        c2.getClass();
        return V2.SORTED.n(i) ? c2 : V2.SIZED.n(i) ? new S2(c2) : new K2(c2);
    }
}
