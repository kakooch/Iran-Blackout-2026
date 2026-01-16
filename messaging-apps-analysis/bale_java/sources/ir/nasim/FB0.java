package ir.nasim;

import android.util.Size;
import androidx.camera.core.impl.v;

/* loaded from: classes.dex */
final class FB0 implements v.e {
    static final FB0 a = new FB0();

    FB0() {
    }

    @Override // androidx.camera.core.impl.v.e
    public void a(Size size, androidx.camera.core.impl.C c, v.b bVar) {
        androidx.camera.core.impl.v vVarM = c.m(null);
        androidx.camera.core.impl.j jVarW = androidx.camera.core.impl.r.W();
        int iO = androidx.camera.core.impl.v.b().o();
        if (vVarM != null) {
            iO = vVarM.o();
            bVar.b(vVarM.c());
            bVar.d(vVarM.k());
            bVar.c(vVarM.i());
            jVarW = vVarM.f();
        }
        bVar.s(jVarW);
        if (c instanceof androidx.camera.core.impl.s) {
            AbstractC8355Vp5.b(size, bVar);
        }
        BB0 bb0 = new BB0(c);
        bVar.w(bb0.X(iO));
        bVar.f(bb0.Y(WC0.b()));
        bVar.k(bb0.b0(AbstractC15803kC0.b()));
        bVar.e(FF0.e(bb0.a0(AbstractC19340qB0.c())));
        bVar.x(c.v());
        bVar.v(c.B());
        androidx.camera.core.impl.q qVarZ = androidx.camera.core.impl.q.Z();
        qVarZ.p(BB0.O, bb0.Z(null));
        qVarZ.p(BB0.J, Long.valueOf(bb0.c0(-1L)));
        bVar.g(qVarZ);
        bVar.g(bb0.W());
    }
}
