package ir.nasim;

import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class C38 extends Z6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C38(final C9057Yh4 c9057Yh4) {
        super(C12736f7.n().e("wallets/router", new V6() { // from class: ir.nasim.B38
            @Override // ir.nasim.V6
            public final K6 create() {
                return C38.k(c9057Yh4);
            }
        }, true));
        AbstractC13042fc3.i(c9057Yh4, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 k(C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "$context");
        return new A38(c9057Yh4);
    }

    public final C6517Nv5 l(String str, long j) {
        AbstractC13042fc3.i(str, "walletId");
        return c(new C13960h66(str, j));
    }

    public final C6517Nv5 m(String str, long j, String str2) {
        AbstractC13042fc3.i(str, "targetWalletId");
        AbstractC13042fc3.i(str2, "regarding");
        return c(new C13369g66(str, j, str2));
    }

    public final C6517Nv5 n(String str, int i) {
        AbstractC13042fc3.i(str, "walletId");
        return c(new C14558i66(str, i));
    }

    public final C6517Nv5 o() {
        return c(new C66());
    }

    public final C6517Nv5 p(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        return c(new E66(abstractC20556sC7));
    }

    public final C6517Nv5 q(String str, PeersStruct$Peer peersStruct$Peer, long j, long j2, long j3, String str2) {
        AbstractC13042fc3.i(str, "sourceWalletId");
        AbstractC13042fc3.i(peersStruct$Peer, "peer");
        AbstractC13042fc3.i(str2, "regarding");
        return c(new C22364v66(str, peersStruct$Peer, j, j2, j3, str2));
    }

    public final C6517Nv5 r(String str, String str2, long j, N38 n38, String str3) {
        AbstractC13042fc3.i(str, "sourceWallet");
        AbstractC13042fc3.i(str2, "targetWallet");
        AbstractC13042fc3.i(n38, "currency");
        AbstractC13042fc3.i(str3, "regarding");
        return c(new C21774u66(str, str2, j, n38, str3));
    }

    public final C6517Nv5 s() {
        return c(new D66());
    }

    public final C6517Nv5 t(String str) {
        AbstractC13042fc3.i(str, "targetWalletId");
        return c(new B66(str));
    }
}
