package ir.nasim;

/* renamed from: ir.nasim.Og4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC6615Og4 implements InterfaceC21331tU0 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.Og4$a */
    public static final class a {
        private a() {
        }

        public final W24 a(InterfaceC21331tU0 interfaceC21331tU0, AbstractC5117Hy7 abstractC5117Hy7, AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(interfaceC21331tU0, "<this>");
            AbstractC13042fc3.i(abstractC5117Hy7, "typeSubstitution");
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            AbstractC6615Og4 abstractC6615Og4 = interfaceC21331tU0 instanceof AbstractC6615Og4 ? (AbstractC6615Og4) interfaceC21331tU0 : null;
            if (abstractC6615Og4 != null) {
                return abstractC6615Og4.x(abstractC5117Hy7, abstractC5284Ir3);
            }
            W24 w24H = interfaceC21331tU0.H(abstractC5117Hy7);
            AbstractC13042fc3.h(w24H, "this.getMemberScope(\n                typeSubstitution\n            )");
            return w24H;
        }

        public final W24 b(InterfaceC21331tU0 interfaceC21331tU0, AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(interfaceC21331tU0, "<this>");
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            AbstractC6615Og4 abstractC6615Og4 = interfaceC21331tU0 instanceof AbstractC6615Og4 ? (AbstractC6615Og4) interfaceC21331tU0 : null;
            if (abstractC6615Og4 != null) {
                return abstractC6615Og4.M(abstractC5284Ir3);
            }
            W24 w24W = interfaceC21331tU0.W();
            AbstractC13042fc3.h(w24W, "this.unsubstitutedMemberScope");
            return w24W;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    protected abstract W24 M(AbstractC5284Ir3 abstractC5284Ir3);

    protected abstract W24 x(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5284Ir3 abstractC5284Ir3);
}
