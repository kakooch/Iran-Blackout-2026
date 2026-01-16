package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class O1 extends R1 implements InterfaceC0235u1 {
    O1(InterfaceC0235u1 interfaceC0235u1, InterfaceC0235u1 interfaceC0235u12) {
        super(interfaceC0235u1, interfaceC0235u12);
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

    @Override // j$.util.stream.InterfaceC0260z1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] d(int i) {
        return new double[i];
    }

    @Override // j$.util.stream.A1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ InterfaceC0235u1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.n(this, j, j2, mVar);
    }

    @Override // j$.util.stream.A1
    public j$.util.u spliterator() {
        return new C0149f2(this);
    }

    @Override // j$.util.stream.A1
    public j$.util.t spliterator() {
        return new C0149f2(this);
    }
}
