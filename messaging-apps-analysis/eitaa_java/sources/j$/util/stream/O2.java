package j$.util.stream;

import j$.util.Comparator;
import j$.util.Spliterator;
import j$.util.stream.A2;
import j$.util.stream.U1;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class O2<T> extends A2.l<T, T> {
    private final boolean l;
    private final Comparator m;

    O2(AbstractC0148l1 abstractC0148l1) {
        super(abstractC0148l1, W2.REFERENCE, V2.l | V2.j);
        this.l = true;
        this.m = Comparator.CC.a();
    }

    O2(AbstractC0148l1 abstractC0148l1, java.util.Comparator comparator) {
        super(abstractC0148l1, W2.REFERENCE, V2.l | V2.k);
        this.l = false;
        comparator.getClass();
        this.m = comparator;
    }

    @Override // j$.util.stream.AbstractC0148l1
    public T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
        if (V2.SORTED.n(v1.q0()) && this.l) {
            return v1.n0(spliterator, false, zVar);
        }
        Object[] objArrP = v1.n0(spliterator, true, zVar).p(zVar);
        Arrays.sort(objArrP, this.m);
        return new U1.c(objArrP);
    }

    @Override // j$.util.stream.AbstractC0148l1
    public C2 F0(int i, C2 c2) {
        c2.getClass();
        return (V2.SORTED.n(i) && this.l) ? c2 : V2.SIZED.n(i) ? new T2(c2, this.m) : new P2(c2, this.m);
    }
}
