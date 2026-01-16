package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class Q1 extends R1 implements InterfaceC0255y1 {
    Q1(InterfaceC0255y1 interfaceC0255y1, InterfaceC0255y1 interfaceC0255y12) {
        super(interfaceC0255y1, interfaceC0255y12);
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ void a(Consumer consumer) {
        AbstractC0202o1.m(this, consumer);
    }

    @Override // j$.util.stream.A1
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Long[] lArr, int i) {
        AbstractC0202o1.j(this, lArr, i);
    }

    @Override // j$.util.stream.InterfaceC0260z1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public long[] d(int i) {
        return new long[i];
    }

    @Override // j$.util.stream.A1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ InterfaceC0255y1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.p(this, j, j2, mVar);
    }

    @Override // j$.util.stream.A1
    public j$.util.u spliterator() {
        return new C0161h2(this);
    }

    @Override // j$.util.stream.A1
    public j$.util.t spliterator() {
        return new C0161h2(this);
    }
}
