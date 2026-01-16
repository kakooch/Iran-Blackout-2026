package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import j$.util.t;

/* loaded from: classes2.dex */
final class G4 extends I4 implements t.b, j$.util.function.l {
    int e;

    G4(t.b bVar, long j, long j2) {
        super(bVar, j, j2);
    }

    G4(t.b bVar, G4 g4) {
        super(bVar, g4);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.k(this, consumer);
    }

    @Override // j$.util.function.l
    public void accept(int i) {
        this.e = i;
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.c(this, consumer);
    }

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        lVar.getClass();
        return new j$.util.function.k(this, lVar);
    }

    @Override // j$.util.stream.K4
    protected j$.util.t q(j$.util.t tVar) {
        return new G4((t.b) tVar, this);
    }

    @Override // j$.util.stream.I4
    protected void s(Object obj) {
        ((j$.util.function.l) obj).accept(this.e);
    }

    @Override // j$.util.stream.I4
    protected AbstractC0181k4 t(int i) {
        return new C0169i4(i);
    }
}
