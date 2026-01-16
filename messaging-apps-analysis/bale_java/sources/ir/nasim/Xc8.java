package ir.nasim;

/* loaded from: classes.dex */
public final class Xc8 extends NJ {
    public Xc8(int i, InterfaceC15120j26 interfaceC15120j26) {
        super(i, interfaceC15120j26);
    }

    private boolean e(W13 w13) {
        QB0 qb0A = SB0.a(w13);
        return (qb0A.e() == NB0.LOCKED_FOCUSED || qb0A.e() == NB0.PASSIVE_FOCUSED) && qb0A.g() == MB0.CONVERGED && qb0A.f() == OB0.CONVERGED;
    }

    public void d(androidx.camera.core.f fVar) {
        if (e(fVar.u1())) {
            super.b(fVar);
        } else {
            this.d.a(fVar);
        }
    }
}
