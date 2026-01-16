package ir.nasim;

import ir.nasim.C12315eP4;
import ir.nasim.features.pfm.entity.PFMTransactionId;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class UP4 extends AbstractC21707u0 {
    private final C9057Yh4 b;
    private final InterfaceC9173Yu3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UP4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.SP4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return UP4.K(this.a);
            }
        });
    }

    private final C9528a7 E() {
        C9528a7 c9528a7F = C12736f7.n().f("actor/pfm", C4614Fw5.d(new V6() { // from class: ir.nasim.TP4
            @Override // ir.nasim.V6
            public final K6 create() {
                return UP4.F(this.a);
            }
        }).a("D_default"));
        AbstractC13042fc3.h(c9528a7F, "actorOf(...)");
        return c9528a7F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 F(UP4 up4) {
        AbstractC13042fc3.i(up4, "this$0");
        return new C12315eP4(up4.b);
    }

    private final C12924fP4 G() {
        return (C12924fP4) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C12924fP4 K(UP4 up4) {
        AbstractC13042fc3.i(up4, "this$0");
        return new C12924fP4(up4.E());
    }

    public final C6517Nv5 C(PFMTransactionId pFMTransactionId, String str) {
        AbstractC13042fc3.i(pFMTransactionId, "id");
        AbstractC13042fc3.i(str, "detail");
        return G().j(new P8(pFMTransactionId, str));
    }

    public final C6517Nv5 D(C14838ia c14838ia) {
        AbstractC13042fc3.i(c14838ia, "addUserTag");
        return G().k(c14838ia);
    }

    public final C6517Nv5 H(C12315eP4.a aVar) {
        AbstractC13042fc3.i(aVar, "getUserAccounts");
        return G().l(aVar);
    }

    public final C6517Nv5 I() {
        return G().m();
    }

    public final C6517Nv5 J(C12315eP4.b bVar) {
        AbstractC13042fc3.i(bVar, "loadTransactions");
        return G().n(bVar);
    }

    public final C6517Nv5 L(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "ids");
        return G().o(new JN5(arrayList));
    }

    public final C6517Nv5 M(LN5 ln5) {
        AbstractC13042fc3.i(ln5, "removeUserTag");
        return G().p(ln5);
    }

    public final C6517Nv5 N(C18289oP5 c18289oP5) {
        AbstractC13042fc3.i(c18289oP5, "reportError");
        return G().q(c18289oP5.c(), c18289oP5.d(), c18289oP5.b(), c18289oP5.a());
    }

    public final C6517Nv5 O(C24614yu6 c24614yu6) {
        AbstractC13042fc3.i(c24614yu6, "setTransactionTag");
        return G().r(c24614yu6);
    }
}
