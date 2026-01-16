package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import j$.util.t;

/* loaded from: classes2.dex */
final class t4 extends AbstractC0157g4 implements t.c {
    t4(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        super(abstractC0256y2, zVar, z);
    }

    t4(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z) {
        super(abstractC0256y2, tVar, z);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.l(this, consumer);
    }

    @Override // j$.util.u
    /* renamed from: d */
    public void e(j$.util.function.q qVar) {
        if (this.h != null || this.i) {
            while (j(qVar)) {
            }
            return;
        }
        qVar.getClass();
        i();
        this.b.v0(new s4(qVar), this.d);
        this.i = true;
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.d(this, consumer);
    }

    @Override // j$.util.u
    /* renamed from: h */
    public boolean j(j$.util.function.q qVar) {
        qVar.getClass();
        boolean zB = b();
        if (zB) {
            Y3 y3 = (Y3) this.h;
            long j = this.g;
            int iX = y3.x(j);
            qVar.accept((y3.c == 0 && iX == 0) ? ((long[]) y3.e)[(int) j] : ((long[][]) y3.f)[iX][(int) (j - y3.d[iX])]);
        }
        return zB;
    }

    @Override // j$.util.stream.AbstractC0157g4
    void k() {
        Y3 y3 = new Y3();
        this.h = y3;
        this.e = this.b.w0(new s4(y3));
        this.f = new C0122b(this);
    }

    @Override // j$.util.stream.AbstractC0157g4
    AbstractC0157g4 l(j$.util.t tVar) {
        return new t4(this.b, tVar, this.a);
    }

    @Override // j$.util.stream.AbstractC0157g4, j$.util.t
    public t.c trySplit() {
        return (t.c) super.trySplit();
    }
}
