package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import j$.util.t;

/* loaded from: classes2.dex */
final class H4 extends I4 implements t.c, j$.util.function.q {
    long e;

    H4(t.c cVar, long j, long j2) {
        super(cVar, j, j2);
    }

    H4(t.c cVar, H4 h4) {
        super(cVar, h4);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.l(this, consumer);
    }

    @Override // j$.util.function.q
    public void accept(long j) {
        this.e = j;
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.d(this, consumer);
    }

    @Override // j$.util.stream.K4
    protected j$.util.t q(j$.util.t tVar) {
        return new H4((t.c) tVar, this);
    }

    @Override // j$.util.stream.I4
    protected void s(Object obj) {
        ((j$.util.function.q) obj).accept(this.e);
    }

    @Override // j$.util.stream.I4
    protected AbstractC0181k4 t(int i) {
        return new C0175j4(i);
    }
}
