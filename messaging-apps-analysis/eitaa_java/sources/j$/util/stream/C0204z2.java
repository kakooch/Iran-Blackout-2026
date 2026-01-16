package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0192w2;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.z2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0204z2<P_IN, P_OUT, R, S extends InterfaceC0192w2<P_OUT, R, S>> extends AbstractC0160o1<P_IN, P_OUT, S, C0204z2<P_IN, P_OUT, R, S>> {
    private final AbstractC0200y2 h;

    C0204z2(AbstractC0200y2 abstractC0200y2, V1 v1, Spliterator spliterator) {
        super(v1, spliterator);
        this.h = abstractC0200y2;
    }

    C0204z2(C0204z2 c0204z2, Spliterator spliterator) {
        super(c0204z2, spliterator);
        this.h = c0204z2.h;
    }

    @Override // j$.util.stream.AbstractC0160o1
    protected Object a() {
        V1 v1 = this.b;
        InterfaceC0192w2 interfaceC0192w2A = this.h.a();
        v1.s0(interfaceC0192w2A, this.c);
        return interfaceC0192w2A;
    }

    @Override // j$.util.stream.AbstractC0160o1
    protected AbstractC0160o1 f(Spliterator spliterator) {
        return new C0204z2(this, spliterator);
    }

    @Override // j$.util.stream.AbstractC0160o1, java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        if (!d()) {
            InterfaceC0192w2 interfaceC0192w2 = (InterfaceC0192w2) ((C0204z2) this.e).b();
            interfaceC0192w2.h((InterfaceC0192w2) ((C0204z2) this.f).b());
            g(interfaceC0192w2);
        }
        this.c = null;
        this.f = null;
        this.e = null;
    }
}
