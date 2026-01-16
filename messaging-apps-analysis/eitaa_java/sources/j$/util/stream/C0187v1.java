package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Predicate;

/* renamed from: j$.util.stream.v1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0187v1<T, O> implements i3<T, O> {
    private final W2 a;
    final boolean b;
    final Object c;
    final Predicate d;
    final j$.util.function.L e;

    C0187v1(boolean z, W2 w2, Object obj, Predicate predicate, j$.util.function.L l) {
        this.b = z;
        this.a = w2;
        this.c = obj;
        this.d = predicate;
        this.e = l;
    }

    @Override // j$.util.stream.i3
    public int b() {
        return V2.p | (this.b ? 0 : V2.m);
    }

    @Override // j$.util.stream.i3
    public Object c(V1 v1, Spliterator spliterator) {
        return new C0195x1(this, v1, spliterator).invoke();
    }

    @Override // j$.util.stream.i3
    public Object d(V1 v1, Spliterator spliterator) {
        j3 j3Var = (j3) this.e.get();
        AbstractC0148l1 abstractC0148l1 = (AbstractC0148l1) v1;
        j3Var.getClass();
        abstractC0148l1.l0(abstractC0148l1.t0(j3Var), spliterator);
        Object obj = j3Var.get();
        return obj != null ? obj : this.c;
    }
}
