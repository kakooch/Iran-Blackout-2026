package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import j$.util.t;

/* loaded from: classes2.dex */
final class x4 extends A4 implements t.b {
    x4(t.b bVar, long j, long j2) {
        super(bVar, j, j2);
    }

    x4(t.b bVar, long j, long j2, long j3, long j4) {
        super(bVar, j, j2, j3, j4, null);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.k(this, consumer);
    }

    @Override // j$.util.stream.E4
    protected j$.util.t b(j$.util.t tVar, long j, long j2, long j3, long j4) {
        return new x4((t.b) tVar, j, j2, j3, j4);
    }

    @Override // j$.util.stream.A4
    protected /* bridge */ /* synthetic */ Object f() {
        return new j$.util.function.l() { // from class: j$.util.stream.w4
            @Override // j$.util.function.l
            public final void accept(int i) {
            }

            @Override // j$.util.function.l
            public j$.util.function.l m(j$.util.function.l lVar) {
                lVar.getClass();
                return new j$.util.function.k(this, lVar);
            }
        };
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.c(this, consumer);
    }
}
