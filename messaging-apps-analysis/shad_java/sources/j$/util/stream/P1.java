package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class P1 extends R1 implements InterfaceC0245w1 {
    P1(InterfaceC0245w1 interfaceC0245w1, InterfaceC0245w1 interfaceC0245w12) {
        super(interfaceC0245w1, interfaceC0245w12);
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ void a(Consumer consumer) {
        AbstractC0202o1.l(this, consumer);
    }

    @Override // j$.util.stream.A1
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Integer[] numArr, int i) {
        AbstractC0202o1.i(this, numArr, i);
    }

    @Override // j$.util.stream.InterfaceC0260z1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int[] d(int i) {
        return new int[i];
    }

    @Override // j$.util.stream.A1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ InterfaceC0245w1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.o(this, j, j2, mVar);
    }

    @Override // j$.util.stream.A1
    public j$.util.u spliterator() {
        return new C0155g2(this);
    }

    @Override // j$.util.stream.A1
    public j$.util.t spliterator() {
        return new C0155g2(this);
    }
}
