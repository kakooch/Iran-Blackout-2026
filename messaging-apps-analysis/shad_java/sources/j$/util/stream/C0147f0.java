package j$.util.stream;

import j$.util.C0114k;

/* renamed from: j$.util.stream.f0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0147f0 extends AbstractC0165i0 implements InterfaceC0180k3 {
    C0147f0() {
    }

    @Override // j$.util.stream.AbstractC0165i0, j$.util.stream.InterfaceC0192m3
    public void accept(int i) {
        accept(Integer.valueOf(i));
    }

    @Override // j$.util.function.z
    public Object get() {
        if (this.a) {
            return C0114k.d(((Integer) this.b).intValue());
        }
        return null;
    }

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        lVar.getClass();
        return new j$.util.function.k(this, lVar);
    }
}
