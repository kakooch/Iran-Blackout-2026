package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.b3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0126b3 extends AbstractC0144e3 {
    C0126b3(j$.util.t tVar, int i, boolean z) {
        super(tVar, i, z);
    }

    @Override // j$.util.stream.AbstractC0128c
    final boolean H0() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.AbstractC0128c
    final InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.AbstractC0144e3, j$.util.stream.InterfaceC0127b4
    public void a(Consumer consumer) {
        if (isParallel()) {
            super.a(consumer);
        } else {
            K0().forEachRemaining(consumer);
        }
    }

    @Override // j$.util.stream.AbstractC0144e3, j$.util.stream.InterfaceC0127b4
    public void f(Consumer consumer) {
        if (!isParallel()) {
            K0().forEachRemaining(consumer);
        } else {
            consumer.getClass();
            y0(new C0195n0(consumer, true));
        }
    }
}
