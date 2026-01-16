package j$.util.stream;

import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
final class V2 extends AbstractC0146f {
    private final U2 h;

    V2(U2 u2, AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        super(abstractC0256y2, tVar);
        this.h = u2;
    }

    V2(V2 v2, j$.util.t tVar) {
        super(v2, tVar);
        this.h = v2.h;
    }

    @Override // j$.util.stream.AbstractC0146f
    protected Object a() {
        AbstractC0256y2 abstractC0256y2 = this.a;
        S2 s2B = this.h.b();
        abstractC0256y2.v0(s2B, this.b);
        return s2B;
    }

    @Override // j$.util.stream.AbstractC0146f
    protected AbstractC0146f f(j$.util.t tVar) {
        return new V2(this, tVar);
    }

    @Override // j$.util.stream.AbstractC0146f, java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        if (!d()) {
            S2 s2 = (S2) ((V2) this.d).b();
            s2.i((S2) ((V2) this.e).b());
            g(s2);
        }
        this.b = null;
        this.e = null;
        this.d = null;
    }
}
