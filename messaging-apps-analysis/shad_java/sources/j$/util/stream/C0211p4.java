package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import j$.util.t;

/* renamed from: j$.util.stream.p4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0211p4 extends AbstractC0157g4 implements t.a {
    C0211p4(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        super(abstractC0256y2, zVar, z);
    }

    C0211p4(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z) {
        super(abstractC0256y2, tVar, z);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.j(this, consumer);
    }

    @Override // j$.util.u
    public void e(j$.util.function.f fVar) {
        if (this.h != null || this.i) {
            while (j(fVar)) {
            }
            return;
        }
        fVar.getClass();
        i();
        this.b.v0(new C0205o4(fVar), this.d);
        this.i = true;
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.b(this, consumer);
    }

    @Override // j$.util.u
    public boolean j(j$.util.function.f fVar) {
        fVar.getClass();
        boolean zB = b();
        if (zB) {
            U3 u3 = (U3) this.h;
            long j = this.g;
            int iX = u3.x(j);
            fVar.accept((u3.c == 0 && iX == 0) ? ((double[]) u3.e)[(int) j] : ((double[][]) u3.f)[iX][(int) (j - u3.d[iX])]);
        }
        return zB;
    }

    @Override // j$.util.stream.AbstractC0157g4
    void k() {
        U3 u3 = new U3();
        this.h = u3;
        this.e = this.b.w0(new C0205o4(u3));
        this.f = new C0122b(this);
    }

    @Override // j$.util.stream.AbstractC0157g4
    AbstractC0157g4 l(j$.util.t tVar) {
        return new C0211p4(this.b, tVar, this.a);
    }

    @Override // j$.util.stream.AbstractC0157g4, j$.util.t
    public t.a trySplit() {
        return (t.a) super.trySplit();
    }
}
