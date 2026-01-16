package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.function.Consumer;
import j$.util.t;

/* renamed from: j$.util.stream.r4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0222r4 extends AbstractC0157g4 implements t.b {
    C0222r4(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        super(abstractC0256y2, zVar, z);
    }

    C0222r4(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z) {
        super(abstractC0256y2, tVar, z);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.k(this, consumer);
    }

    @Override // j$.util.u
    /* renamed from: c */
    public void e(j$.util.function.l lVar) {
        if (this.h != null || this.i) {
            while (j(lVar)) {
            }
            return;
        }
        lVar.getClass();
        i();
        this.b.v0(new C0217q4(lVar), this.d);
        this.i = true;
    }

    @Override // j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.c(this, consumer);
    }

    @Override // j$.util.u
    /* renamed from: g */
    public boolean j(j$.util.function.l lVar) {
        lVar.getClass();
        boolean zB = b();
        if (zB) {
            W3 w3 = (W3) this.h;
            long j = this.g;
            int iX = w3.x(j);
            lVar.accept((w3.c == 0 && iX == 0) ? ((int[]) w3.e)[(int) j] : ((int[][]) w3.f)[iX][(int) (j - w3.d[iX])]);
        }
        return zB;
    }

    @Override // j$.util.stream.AbstractC0157g4
    void k() {
        W3 w3 = new W3();
        this.h = w3;
        this.e = this.b.w0(new C0217q4(w3));
        this.f = new C0122b(this);
    }

    @Override // j$.util.stream.AbstractC0157g4
    AbstractC0157g4 l(j$.util.t tVar) {
        return new C0222r4(this.b, tVar, this.a);
    }

    @Override // j$.util.stream.AbstractC0157g4, j$.util.t
    public t.b trySplit() {
        return (t.b) super.trySplit();
    }
}
