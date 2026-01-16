package ir.nasim;

/* loaded from: classes8.dex */
public interface LB2 extends InterfaceC4557Fq2 {

    public static final class a {
        public static /* synthetic */ InterfaceC4557Fq2 a(LB2 lb2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i2 & 1) != 0) {
                interfaceC11938do1 = C18712p72.a;
            }
            if ((i2 & 2) != 0) {
                i = -3;
            }
            if ((i2 & 4) != 0) {
                enumC6162Ml0 = EnumC6162Ml0.SUSPEND;
            }
            return lb2.g(interfaceC11938do1, i, enumC6162Ml0);
        }
    }

    InterfaceC4557Fq2 g(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0);
}
