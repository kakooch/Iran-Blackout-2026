package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.AbstractC0171r1;
import j$.util.stream.T1;
import j$.util.stream.U1;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class L2 extends AbstractC0171r1.h<Double> {
    L2(AbstractC0148l1 abstractC0148l1) {
        super(abstractC0148l1, W2.DOUBLE_VALUE, V2.l | V2.j);
    }

    @Override // j$.util.stream.AbstractC0148l1
    public T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
        if (V2.SORTED.n(v1.q0())) {
            return v1.n0(spliterator, false, zVar);
        }
        double[] dArr = (double[]) ((T1.b) v1.n0(spliterator, true, zVar)).e();
        Arrays.sort(dArr);
        return new U1.g(dArr);
    }

    @Override // j$.util.stream.AbstractC0148l1
    public C2 F0(int i, C2 c2) {
        c2.getClass();
        return V2.SORTED.n(i) ? c2 : V2.SIZED.n(i) ? new Q2(c2) : new I2(c2);
    }
}
