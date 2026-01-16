package ir.nasim;

/* renamed from: ir.nasim.xc8, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23846xc8 {
    public static final Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE;
        InterfaceC11938do1 context = interfaceC20295rm1.getContext();
        AbstractC19067pj3.n(context);
        InterfaceC20295rm1 interfaceC20295rm1C = AbstractC14251hc3.c(interfaceC20295rm1);
        TU1 tu1 = interfaceC20295rm1C instanceof TU1 ? (TU1) interfaceC20295rm1C : null;
        if (tu1 == null) {
            objE = C19938rB7.a;
        } else {
            if (tu1.d.A0(context)) {
                tu1.k(context, C19938rB7.a);
            } else {
                C23256wc8 c23256wc8 = new C23256wc8();
                InterfaceC11938do1 interfaceC11938do1X = context.X(c23256wc8);
                C19938rB7 c19938rB7 = C19938rB7.a;
                tu1.k(interfaceC11938do1X, c19938rB7);
                objE = (!c23256wc8.b || UU1.d(tu1)) ? AbstractC14862ic3.e() : c19938rB7;
            }
            objE = AbstractC14862ic3.e();
        }
        if (objE == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }
}
