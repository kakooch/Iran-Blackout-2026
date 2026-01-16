package j$.util.stream;

import j$.util.C0113j;

/* renamed from: j$.util.stream.e0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0141e0 extends AbstractC0165i0 implements InterfaceC0174j3 {
    C0141e0() {
    }

    @Override // j$.util.stream.AbstractC0165i0, j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        accept(Double.valueOf(d));
    }

    @Override // j$.util.function.z
    public Object get() {
        if (this.a) {
            return C0113j.d(((Double) this.b).doubleValue());
        }
        return null;
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }
}
