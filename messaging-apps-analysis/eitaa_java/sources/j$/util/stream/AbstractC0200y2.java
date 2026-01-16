package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0192w2;

/* renamed from: j$.util.stream.y2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0200y2<T, R, S extends InterfaceC0192w2<T, R, S>> implements i3<T, R> {
    private final W2 a;

    AbstractC0200y2(W2 w2) {
        this.a = w2;
    }

    public abstract InterfaceC0192w2 a();

    @Override // j$.util.stream.i3
    public /* synthetic */ int b() {
        return 0;
    }

    @Override // j$.util.stream.i3
    public Object c(V1 v1, Spliterator spliterator) {
        return ((InterfaceC0192w2) new C0204z2(this, v1, spliterator).invoke()).get();
    }

    @Override // j$.util.stream.i3
    public Object d(V1 v1, Spliterator spliterator) {
        InterfaceC0192w2 interfaceC0192w2A = a();
        AbstractC0148l1 abstractC0148l1 = (AbstractC0148l1) v1;
        interfaceC0192w2A.getClass();
        abstractC0148l1.l0(abstractC0148l1.t0(interfaceC0192w2A), spliterator);
        return interfaceC0192w2A.get();
    }
}
