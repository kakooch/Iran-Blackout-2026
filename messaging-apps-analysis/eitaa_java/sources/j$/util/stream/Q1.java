package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
final class Q1<T> implements i3<T, Boolean> {
    private final W2 a;
    final P1 b;
    final j$.util.function.L c;

    Q1(W2 w2, P1 p1, j$.util.function.L l) {
        this.a = w2;
        this.b = p1;
        this.c = l;
    }

    @Override // j$.util.stream.i3
    public int b() {
        return V2.p | V2.m;
    }

    @Override // j$.util.stream.i3
    public Object c(V1 v1, Spliterator spliterator) {
        return new R1(this, v1, spliterator).invoke();
    }

    @Override // j$.util.stream.i3
    public Object d(V1 v1, Spliterator spliterator) {
        O1 o1 = (O1) this.c.get();
        AbstractC0148l1 abstractC0148l1 = (AbstractC0148l1) v1;
        o1.getClass();
        abstractC0148l1.l0(abstractC0148l1.t0(o1), spliterator);
        return Boolean.valueOf(o1.b);
    }
}
