package ir.nasim;

/* renamed from: ir.nasim.rU5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C20107rU5 extends AbstractC6302Na0 {
    private static C20107rU5 A;
    private static C20107rU5 B;

    public static C20107rU5 B0(InterfaceC15645jv7 interfaceC15645jv7) {
        return (C20107rU5) new C20107rU5().u0(interfaceC15645jv7);
    }

    public static C20107rU5 D0(Class cls) {
        return (C20107rU5) new C20107rU5().h(cls);
    }

    public static C20107rU5 E0(AbstractC23175wU1 abstractC23175wU1) {
        return (C20107rU5) new C20107rU5().i(abstractC23175wU1);
    }

    public static C20107rU5 F0(InterfaceC14373ho3 interfaceC14373ho3) {
        return (C20107rU5) new C20107rU5().n0(interfaceC14373ho3);
    }

    public static C20107rU5 G0(boolean z) {
        if (z) {
            if (A == null) {
                A = (C20107rU5) ((C20107rU5) new C20107rU5().p0(true)).c();
            }
            return A;
        }
        if (B == null) {
            B = (C20107rU5) ((C20107rU5) new C20107rU5().p0(false)).c();
        }
        return B;
    }

    @Override // ir.nasim.AbstractC6302Na0
    public boolean equals(Object obj) {
        return (obj instanceof C20107rU5) && super.equals(obj);
    }

    @Override // ir.nasim.AbstractC6302Na0
    public int hashCode() {
        return super.hashCode();
    }
}
