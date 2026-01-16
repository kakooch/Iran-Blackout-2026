package ir.nasim;

/* renamed from: ir.nasim.ji3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15511ji3 implements InterfaceC6450Np2 {
    public static final C15511ji3 a = new C15511ji3();

    private C15511ji3() {
    }

    @Override // ir.nasim.InterfaceC6450Np2
    public AbstractC4099Dr3 a(C10647bx5 c10647bx5, String str, XC6 xc6, XC6 xc62) {
        AbstractC13042fc3.i(c10647bx5, "proto");
        AbstractC13042fc3.i(str, "flexibleId");
        AbstractC13042fc3.i(xc6, "lowerBound");
        AbstractC13042fc3.i(xc62, "upperBound");
        if (AbstractC13042fc3.d(str, "kotlin.jvm.PlatformType")) {
            return c10647bx5.y(AbstractC7849Tl3.g) ? new FG5(xc6, xc62) : C4567Fr3.d(xc6, xc62);
        }
        XC6 xc6J = AbstractC14230ha2.j("Error java flexible type with id: " + str + ". (" + xc6 + ".." + xc62 + ')');
        AbstractC13042fc3.h(xc6J, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
        return xc6J;
    }
}
