package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class W1 extends AbstractC0119a2 implements InterfaceC0235u1 {
    W1() {
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ void a(Consumer consumer) {
        AbstractC0202o1.k(this, consumer);
    }

    @Override // j$.util.stream.A1
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Double[] dArr, int i) {
        AbstractC0202o1.h(this, dArr, i);
    }

    @Override // j$.util.stream.AbstractC0119a2, j$.util.stream.A1
    public InterfaceC0260z1 c(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.AbstractC0119a2, j$.util.stream.A1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ InterfaceC0235u1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.n(this, j, j2, mVar);
    }

    @Override // j$.util.stream.InterfaceC0260z1
    public Object g() {
        return AbstractC0251x2.g;
    }

    @Override // j$.util.stream.A1
    public j$.util.u spliterator() {
        return j$.util.J.b();
    }

    @Override // j$.util.stream.AbstractC0119a2, j$.util.stream.A1
    public /* bridge */ /* synthetic */ A1 c(int i) {
        c(i);
        throw null;
    }

    @Override // j$.util.stream.A1
    public j$.util.t spliterator() {
        return j$.util.J.b();
    }
}
