package j$.util.stream;

import j$.util.function.InterfaceC0109b;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
class N1 extends AbstractC0146f {
    protected final AbstractC0256y2 h;
    protected final j$.util.function.r i;
    protected final InterfaceC0109b j;

    N1(N1 n1, j$.util.t tVar) {
        super(n1, tVar);
        this.h = n1.h;
        this.i = n1.i;
        this.j = n1.j;
    }

    N1(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, j$.util.function.r rVar, InterfaceC0109b interfaceC0109b) {
        super(abstractC0256y2, tVar);
        this.h = abstractC0256y2;
        this.i = rVar;
        this.j = interfaceC0109b;
    }

    @Override // j$.util.stream.AbstractC0146f
    protected Object a() {
        InterfaceC0225s1 interfaceC0225s1 = (InterfaceC0225s1) this.i.apply(this.h.r0(this.b));
        this.h.v0(interfaceC0225s1, this.b);
        return interfaceC0225s1.b();
    }

    @Override // j$.util.stream.AbstractC0146f
    protected AbstractC0146f f(j$.util.t tVar) {
        return new N1(this, tVar);
    }

    @Override // j$.util.stream.AbstractC0146f, java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        if (!d()) {
            g((A1) this.j.apply((A1) ((N1) this.d).b(), (A1) ((N1) this.e).b()));
        }
        this.b = null;
        this.e = null;
        this.d = null;
    }
}
