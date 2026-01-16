package ir.nasim;

import ai.bale.proto.WalletOuterClass$ResponseGetWalletInvoice;

/* loaded from: classes5.dex */
public final class H38 extends AbstractC4177Ea0 {
    private final I38 f;
    private final String g;
    private final C11461d28 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H38(I38 i38) {
        super(i38);
        AbstractC13042fc3.i(i38, "mvpView");
        this.f = i38;
        this.g = "WalletStatementAbolContentMVPPresenter";
        this.h = ((InterfaceC9291Zh4) C92.a(C5721Ko.a.d(), InterfaceC9291Zh4.class)).N0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(H38 h38, String str, int i, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        AbstractC13042fc3.i(h38, "this$0");
        AbstractC13042fc3.i(interfaceC15419jZ0, "callback");
        h38.h.G(str, i).m0(new InterfaceC24449ye1() { // from class: ir.nasim.F38
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                H38.k(interfaceC15419jZ0, (WalletOuterClass$ResponseGetWalletInvoice) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.G38
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                H38.l(interfaceC15419jZ0, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(InterfaceC15419jZ0 interfaceC15419jZ0, WalletOuterClass$ResponseGetWalletInvoice walletOuterClass$ResponseGetWalletInvoice) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.a(walletOuterClass$ResponseGetWalletInvoice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(InterfaceC15419jZ0 interfaceC15419jZ0, Exception exc) {
        AbstractC13042fc3.i(interfaceC15419jZ0, "$callback");
        interfaceC15419jZ0.onError(exc);
    }

    public final InterfaceC14830iZ0 i(final String str, final int i) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.E38
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                H38.j(this.a, str, i, interfaceC15419jZ0);
            }
        };
    }
}
