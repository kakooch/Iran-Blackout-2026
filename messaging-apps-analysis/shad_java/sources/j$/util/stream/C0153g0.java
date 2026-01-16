package j$.util.stream;

import j$.util.C0115l;

/* renamed from: j$.util.stream.g0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0153g0 extends AbstractC0165i0 implements InterfaceC0186l3 {
    C0153g0() {
    }

    @Override // j$.util.stream.AbstractC0165i0, j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        accept(Long.valueOf(j));
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }

    @Override // j$.util.function.z
    public Object get() {
        if (this.a) {
            return C0115l.d(((Long) this.b).longValue());
        }
        return null;
    }
}
