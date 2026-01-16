package ir.nasim;

/* loaded from: classes8.dex */
public abstract class KE0 {
    public static final void a(HE0 he0, NV1 nv1) {
        he0.J(new SV1(nv1));
    }

    public static final IE0 b(InterfaceC20295rm1 interfaceC20295rm1) {
        if (!(interfaceC20295rm1 instanceof TU1)) {
            return new IE0(interfaceC20295rm1, 1);
        }
        IE0 ie0J = ((TU1) interfaceC20295rm1).j();
        if (ie0J != null) {
            if (!ie0J.I()) {
                ie0J = null;
            }
            if (ie0J != null) {
                return ie0J;
            }
        }
        return new IE0(interfaceC20295rm1, 2);
    }
}
