package ir.nasim;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.PeersStruct$Peer;
import ai.bale.proto.WalletOuterClass$RequestGetMyWallets;
import ai.bale.proto.WalletOuterClass$RequestGetPaymentTokenByCard;
import ai.bale.proto.WalletOuterClass$RequestGetWalletChargeToken;
import ai.bale.proto.WalletOuterClass$RequestGetWalletInvoice;
import ai.bale.proto.WalletOuterClass$RequestPayByWallet;
import ai.bale.proto.WalletOuterClass$RequestPayMoneyRequestByWallet;
import ai.bale.proto.WalletOuterClass$RequestVerifyQRCode;
import ai.bale.proto.WalletOuterClass$ResponseGetMyWallets;
import ai.bale.proto.WalletOuterClass$ResponseGetPaymentTokenByCard;
import ai.bale.proto.WalletOuterClass$ResponseGetWalletChargeToken;
import ai.bale.proto.WalletOuterClass$ResponseGetWalletInvoice;
import ai.bale.proto.WalletOuterClass$ResponseVerifyQRCode;
import ai.bale.proto.WalletStruct$Balance;
import ai.bale.proto.WalletStruct$Wallet;
import com.google.protobuf.BoolValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class A38 extends AbstractC6360Ng4 {
    public static final a q = new a(null);
    public static final int r = 8;
    private final C9057Yh4 m;
    private final String n;
    private boolean o;
    private boolean p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A38(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        String name = A38.class.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        this.n = name;
        this.o = true;
    }

    private final C6517Nv5 A0(final String str, N38 n38, final long j) {
        p0();
        final EnumC17422mw1 enumC17422mw1J = EnumC17422mw1.j(n38.getNumber());
        AbstractC13042fc3.h(enumC17422mw1J, "fromValue(...)");
        C6517Nv5 c6517Nv5Z = this.m.Y().F().a(str.hashCode()).G(new InterfaceC17569nB2() { // from class: ir.nasim.u38
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return A38.B0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.v38
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return A38.C0(enumC17422mw1J, j, str, this, (D18) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.w38
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                A38.D0(this.a, (C14505i18) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 B0(Exception exc) {
        return C6517Nv5.l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 C0(EnumC17422mw1 enumC17422mw1, long j, String str, A38 a38, D18 d18) {
        AbstractC13042fc3.i(enumC17422mw1, "$currency");
        AbstractC13042fc3.i(str, "$walletId");
        AbstractC13042fc3.i(a38, "this$0");
        if (d18 != null && d18.s(enumC17422mw1).q() != j) {
            a38.m.Y().F().e(d18.z(str, enumC17422mw1, j));
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(A38 a38, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(a38, "this$0");
        a38.O0();
    }

    private final C6517Nv5 E0(AbstractC20556sC7 abstractC20556sC7) {
        if (abstractC20556sC7 instanceof C24829zG7) {
            C24829zG7 c24829zG7 = (C24829zG7) abstractC20556sC7;
            String strB = c24829zG7.b();
            N38 n38Q = c24829zG7.a().r().q();
            AbstractC13042fc3.h(n38Q, "toStruct(...)");
            return A0(strB, n38Q, c24829zG7.a().q());
        }
        if (!(abstractC20556sC7 instanceof BG7)) {
            C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
            AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
            return c6517Nv5L0;
        }
        BG7 bg7 = (BG7) abstractC20556sC7;
        WalletStruct$Wallet.a aVarB = WalletStruct$Wallet.newBuilder().B(bg7.a().w());
        String strY = bg7.a().y();
        AbstractC13042fc3.h(strY, "getWalletLink(...)");
        WalletStruct$Wallet.a aVarD = aVarB.D(GY6.h(strY));
        Boolean boolR = bg7.a().r();
        AbstractC13042fc3.h(boolR, "getActivate(...)");
        WalletStruct$Wallet.a aVarC = aVarD.C(BoolValue.of(boolR.booleanValue()));
        List listU = bg7.a().u();
        AbstractC13042fc3.h(listU, "getBalances(...)");
        List<SW> list = listU;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (SW sw : list) {
            arrayList.add((WalletStruct$Balance) WalletStruct$Balance.newBuilder().A(sw.q()).B(sw.r().p()).a());
        }
        return F0(AbstractC10360bX0.s((WalletStruct$Wallet) aVarC.A(arrayList).a()), false);
    }

    private final C6517Nv5 F0(final List list, final boolean z) {
        p0();
        C6517Nv5 c6517Nv5H0 = this.m.Y().F().h().m0(new InterfaceC24449ye1() { // from class: ir.nasim.x38
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                A38.G0(z, this, list, (List) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.y38
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return A38.H0(this.a, (List) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.z38
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                A38.I0(this.a, (C14505i18) obj);
            }
        }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.p38
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return A38.J0((C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(boolean z, A38 a38, List list, List list2) {
        AbstractC13042fc3.i(a38, "this$0");
        AbstractC13042fc3.i(list, "$walletList");
        if (z && !a38.z0(list2, list)) {
            a38.m.Y().F().clear();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WalletStruct$Wallet walletStruct$Wallet = (WalletStruct$Wallet) it.next();
            ArrayList arrayList = new ArrayList();
            for (WalletStruct$Balance walletStruct$Balance : walletStruct$Wallet.getBalancesList()) {
                arrayList.add(new SW(EnumC17422mw1.j(walletStruct$Balance.getCurrencyValue()), Long.valueOf(walletStruct$Balance.getAmount())));
            }
            a38.m.Y().F().e(new D18(walletStruct$Wallet.getId(), arrayList, walletStruct$Wallet.getWalletLink().getValue(), Boolean.valueOf(walletStruct$Wallet.getIsActive().getValue())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 H0(A38 a38, List list) {
        AbstractC13042fc3.i(a38, "this$0");
        return a38.M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(A38 a38, C14505i18 c14505i18) {
        AbstractC13042fc3.i(a38, "this$0");
        a38.O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14505i18 J0(C14505i18 c14505i18) {
        return C14505i18.a;
    }

    private final C6517Nv5 K0(String str, String str2, long j, String str3, N38 n38) {
        try {
            GeneratedMessageLite generatedMessageLiteA = WalletOuterClass$RequestPayByWallet.newBuilder().D(str).E(str2).A(j).C(GY6.h(str3)).B(n38).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
            return M(new C22871vx5("/bale.wallet.v1.Wallet/PayByWallet", generatedMessageLiteA, defaultInstance), 18000L);
        } catch (IOException e) {
            C19406qI3.a(this.n, "payQRByWallet", e);
            return null;
        }
    }

    private final C6517Nv5 L0(String str, long j, String str2, long j2, PeersStruct$Peer peersStruct$Peer, long j3) {
        GeneratedMessageLite generatedMessageLiteA = WalletOuterClass$RequestPayMoneyRequestByWallet.newBuilder().D(str).A(AbstractC5565Jw5.a(j)).C(GY6.h(str2)).B(MessagingStruct$HistoryMessageIdentifier.newBuilder().B(PeersStruct$OutPeer.newBuilder().B(peersStruct$Peer.getId()).C(peersStruct$Peer.getType()).A(0L)).A(j2).D(j3)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5M = M(new C22871vx5("/bale.wallet.v1.Wallet/PayMoneyRequestByWallet", generatedMessageLiteA, defaultInstance), 18000L);
        AbstractC13042fc3.h(c6517Nv5M, "api(...)");
        return c6517Nv5M;
    }

    private final C6517Nv5 M0() {
        C6517Nv5 c6517Nv5H0 = this.m.Y().F().h().h0(new InterfaceC17569nB2() { // from class: ir.nasim.t38
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return A38.N0(this.a, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14505i18 N0(A38 a38, List list) {
        AbstractC13042fc3.i(a38, "this$0");
        if (list != null && list.size() > 0) {
            a38.m.Y().B().i(((D18) list.get(0)).w());
        }
        return C14505i18.a;
    }

    private final void O0() {
        this.o = false;
        w();
    }

    private final C6517Nv5 P0(String str) {
        GeneratedMessageLite generatedMessageLiteA = WalletOuterClass$RequestVerifyQRCode.newBuilder().A(str).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        WalletOuterClass$ResponseVerifyQRCode defaultInstance = WalletOuterClass$ResponseVerifyQRCode.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5M = M(new C22871vx5("/bale.wallet.v1.Wallet/VerifyQRCode", generatedMessageLiteA, defaultInstance), 16500L);
        AbstractC13042fc3.h(c6517Nv5M, "api(...)");
        return c6517Nv5M;
    }

    private final void p0() {
        this.o = true;
    }

    private final C6517Nv5 q0(String str, long j, String str2) {
        GeneratedMessageLite generatedMessageLiteA = WalletOuterClass$RequestGetPaymentTokenByCard.newBuilder().C(str).A(j).B(GY6.h(str2)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        WalletOuterClass$ResponseGetPaymentTokenByCard defaultInstance = WalletOuterClass$ResponseGetPaymentTokenByCard.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5M = M(new C22871vx5("/bale.wallet.v1.Wallet/GetPaymentTokenByCard", generatedMessageLiteA, defaultInstance), 16500L);
        AbstractC13042fc3.h(c6517Nv5M, "api(...)");
        return c6517Nv5M;
    }

    private final C6517Nv5 r0(String str, long j) {
        GeneratedMessageLite generatedMessageLiteA = WalletOuterClass$RequestGetWalletChargeToken.newBuilder().B(str).A(j).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        WalletOuterClass$ResponseGetWalletChargeToken defaultInstance = WalletOuterClass$ResponseGetWalletChargeToken.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5M = M(new C22871vx5("/bale.wallet.v1.Wallet/GetWalletChargeToken", generatedMessageLiteA, defaultInstance), 16500L);
        AbstractC13042fc3.h(c6517Nv5M, "api(...)");
        return c6517Nv5M;
    }

    private final C6517Nv5 s0(String str, int i) {
        GeneratedMessageLite generatedMessageLiteA = WalletOuterClass$RequestGetWalletInvoice.newBuilder().B(str).A(Int32Value.of(i)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        WalletOuterClass$ResponseGetWalletInvoice defaultInstance = WalletOuterClass$ResponseGetWalletInvoice.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5M = M(new C22871vx5("/bale.wallet.v1.Wallet/GetWalletInvoice", generatedMessageLiteA, defaultInstance), 16500L);
        AbstractC13042fc3.h(c6517Nv5M, "api(...)");
        return c6517Nv5M;
    }

    private final C6517Nv5 t0(boolean z) {
        C6517Nv5 c6517Nv5H0;
        if (!this.m.c().h("my_wallets_are_loaded", false) || z) {
            WalletOuterClass$RequestGetMyWallets defaultInstance = WalletOuterClass$RequestGetMyWallets.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
            WalletOuterClass$ResponseGetMyWallets defaultInstance2 = WalletOuterClass$ResponseGetMyWallets.getDefaultInstance();
            AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
            c6517Nv5H0 = L(new C22871vx5("/bale.wallet.v1.Wallet/GetMyWallets", defaultInstance, defaultInstance2)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.o38
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    A38.x0(this.a, (WalletOuterClass$ResponseGetMyWallets) obj);
                }
            }).h0(new InterfaceC17569nB2() { // from class: ir.nasim.r38
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return A38.v0((WalletOuterClass$ResponseGetMyWallets) obj);
                }
            });
        } else {
            c6517Nv5H0 = M0();
        }
        C6517Nv5 c6517Nv5M0 = c6517Nv5H0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.s38
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                A38.w0(this.a, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    private final void u0() {
        t0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14505i18 v0(WalletOuterClass$ResponseGetMyWallets walletOuterClass$ResponseGetMyWallets) {
        return C14505i18.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(A38 a38, C14505i18 c14505i18) {
        AbstractC13042fc3.i(a38, "this$0");
        a38.p = true;
        a38.O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(final A38 a38, WalletOuterClass$ResponseGetMyWallets walletOuterClass$ResponseGetMyWallets) {
        AbstractC13042fc3.i(a38, "this$0");
        AbstractC13042fc3.i(walletOuterClass$ResponseGetMyWallets, "responseGetMyWallets");
        List<WalletStruct$Wallet> walletsList = walletOuterClass$ResponseGetMyWallets.getWalletsList();
        AbstractC13042fc3.h(walletsList, "getWalletsList(...)");
        a38.F0(walletsList, true).m0(new InterfaceC24449ye1() { // from class: ir.nasim.q38
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                A38.y0(this.a, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(A38 a38, C14505i18 c14505i18) {
        AbstractC13042fc3.i(a38, "this$0");
        a38.m.c().g("my_wallets_are_loaded", true);
    }

    private final boolean z0(List list, List list2) {
        if (list2 == null || list == null || list2.size() <= 0 || list.size() <= 0) {
            return false;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            WalletStruct$Wallet walletStruct$Wallet = (WalletStruct$Wallet) it.next();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (walletStruct$Wallet.getId().hashCode() == ((D18) it2.next()).w().hashCode()) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof E66) {
            if (!this.o && this.p) {
                return E0(((E66) obj).a());
            }
            t();
            return null;
        }
        if (obj instanceof C66) {
            if (!this.o && this.p) {
                return C6517Nv5.l0(C14505i18.a);
            }
            t();
            return null;
        }
        if (obj instanceof D66) {
            if (!this.o && this.p) {
                return t0(true);
            }
            t();
            return null;
        }
        if (obj instanceof C13960h66) {
            C13960h66 c13960h66 = (C13960h66) obj;
            return r0(c13960h66.b(), c13960h66.a());
        }
        if (obj instanceof B66) {
            return P0(((B66) obj).a());
        }
        if (obj instanceof C21774u66) {
            C21774u66 c21774u66 = (C21774u66) obj;
            return K0(c21774u66.d(), c21774u66.e(), c21774u66.a(), c21774u66.c(), c21774u66.b());
        }
        if (obj instanceof C13369g66) {
            C13369g66 c13369g66 = (C13369g66) obj;
            return q0(c13369g66.c(), c13369g66.a(), c13369g66.b());
        }
        if (obj instanceof C22364v66) {
            C22364v66 c22364v66 = (C22364v66) obj;
            return L0(c22364v66.f(), c22364v66.a(), c22364v66.e(), c22364v66.b(), c22364v66.c(), c22364v66.d());
        }
        if (!(obj instanceof C14558i66)) {
            return super.G(obj);
        }
        C14558i66 c14558i66 = (C14558i66) obj;
        return s0(c14558i66.b(), c14558i66.a());
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof b) {
            u0();
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        r().d(new b());
    }
}
