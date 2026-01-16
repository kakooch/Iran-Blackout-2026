package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import j$.util.t;

/* loaded from: classes2.dex */
final class z4 extends A4 implements t.c {
    z4(t.c cVar, long j, long j2) {
        super(cVar, j, j2);
    }

    z4(t.c cVar, long j, long j2, long j3, long j4) {
        super(cVar, j, j2, j3, j4, null);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.l(this, consumer);
    }

    @Override // j$.util.stream.E4
    protected j$.util.t b(j$.util.t tVar, long j, long j2, long j3, long j4) {
        return new z4((t.c) tVar, j, j2, j3, j4);
    }

    @Override // j$.util.stream.A4
    protected /* bridge */ /* synthetic */ Object f() {
        return new j$.util.function.q() { // from class: j$.util.stream.y4
            @Override // j$.util.function.q
            public final void accept(long j) {
            }

            @Override // j$.util.function.q
            public j$.util.function.q f(j$.util.function.q qVar) {
                qVar.getClass();
                return new j$.util.function.p(this, qVar);
            }
        };
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.d(this, consumer);
    }
}
