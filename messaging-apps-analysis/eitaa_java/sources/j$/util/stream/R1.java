package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
final class R1<P_IN, P_OUT> extends AbstractC0152m1<P_IN, P_OUT, Boolean, R1<P_IN, P_OUT>> {
    private final Q1 j;

    R1(Q1 q1, V1 v1, Spliterator spliterator) {
        super(v1, spliterator);
        this.j = q1;
    }

    R1(R1 r1, Spliterator spliterator) {
        super(r1, spliterator);
        this.j = r1.j;
    }

    @Override // j$.util.stream.AbstractC0160o1
    protected Object a() {
        V1 v1 = this.b;
        O1 o1 = (O1) this.j.c.get();
        v1.s0(o1, this.c);
        boolean z = o1.b;
        if (z != this.j.b.c) {
            return null;
        }
        l(Boolean.valueOf(z));
        return null;
    }

    @Override // j$.util.stream.AbstractC0160o1
    protected AbstractC0160o1 f(Spliterator spliterator) {
        return new R1(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0152m1
    protected Object k() {
        return Boolean.valueOf(!this.j.b.c);
    }
}
