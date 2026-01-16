package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class M4 extends AbstractC0157g4 {
    M4(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z) {
        super(abstractC0256y2, zVar, z);
    }

    M4(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z) {
        super(abstractC0256y2, tVar, z);
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        Object obj;
        consumer.getClass();
        boolean zB = b();
        if (zB) {
            C0121a4 c0121a4 = (C0121a4) this.h;
            long j = this.g;
            if (c0121a4.c != 0) {
                if (j >= c0121a4.count()) {
                    throw new IndexOutOfBoundsException(Long.toString(j));
                }
                for (int i = 0; i <= c0121a4.c; i++) {
                    long[] jArr = c0121a4.d;
                    long j2 = jArr[i];
                    Object[][] objArr = c0121a4.f;
                    if (j < j2 + objArr[i].length) {
                        obj = objArr[i][(int) (j - jArr[i])];
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            if (j >= c0121a4.b) {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            obj = c0121a4.e[(int) j];
            consumer.accept(obj);
        }
        return zB;
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        if (this.h != null || this.i) {
            while (a(consumer)) {
            }
            return;
        }
        consumer.getClass();
        i();
        this.b.v0(new L4(consumer), this.d);
        this.i = true;
    }

    @Override // j$.util.stream.AbstractC0157g4
    void k() {
        C0121a4 c0121a4 = new C0121a4();
        this.h = c0121a4;
        this.e = this.b.w0(new L4(c0121a4));
        this.f = new C0122b(this);
    }

    @Override // j$.util.stream.AbstractC0157g4
    AbstractC0157g4 l(j$.util.t tVar) {
        return new M4(this.b, tVar, this.a);
    }
}
