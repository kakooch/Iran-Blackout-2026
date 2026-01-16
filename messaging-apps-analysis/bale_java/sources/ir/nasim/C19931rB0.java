package ir.nasim;

import androidx.camera.core.impl.i;

/* renamed from: ir.nasim.rB0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C19931rB0 implements i.b {
    static final C19931rB0 a = new C19931rB0();

    C19931rB0() {
    }

    @Override // androidx.camera.core.impl.i.b
    public void a(androidx.camera.core.impl.C c, i.a aVar) {
        androidx.camera.core.impl.i iVarQ = c.q(null);
        androidx.camera.core.impl.j jVarW = androidx.camera.core.impl.r.W();
        int iK = androidx.camera.core.impl.i.b().k();
        if (iVarQ != null) {
            iK = iVarQ.k();
            aVar.a(iVarQ.c());
            jVarW = iVarQ.g();
        }
        aVar.p(jVarW);
        BB0 bb0 = new BB0(c);
        aVar.r(bb0.X(iK));
        aVar.c(FF0.e(bb0.a0(AbstractC19340qB0.c())));
        aVar.e(bb0.W());
    }
}
