package ir.nasim.core.modules.banking;

import ai.bale.proto.BankOuterClass$RequestGetPaymentToken;
import ai.bale.proto.BankOuterClass$RequestGrantBankiAccess;
import ai.bale.proto.BankOuterClass$ResponseGetPaymentToken;
import ai.bale.proto.BankOuterClass$ResponseGetRemainToken;
import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.Crowdfunding$RequestGetTotalPaidAmount;
import ai.bale.proto.Crowdfunding$ResponseGetTotalPaidAmount;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import ai.bale.proto.Microbanki$RequestGetBamServiceToken;
import ai.bale.proto.Microbanki$ResponseGetBamServiceToken;
import ai.bale.proto.Misc$ResponseSeq;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.SapOuterClass$RequestAddNewCards;
import ai.bale.proto.SapOuterClass$RequestDeliverOtp;
import ai.bale.proto.SapOuterClass$RequestEditCardExpirationDate;
import ai.bale.proto.SapOuterClass$RequestGetCardInfo;
import ai.bale.proto.SapOuterClass$RequestGetDestinationCardInfo;
import ai.bale.proto.SapOuterClass$RequestReactivateApp;
import ai.bale.proto.SapOuterClass$RequestTransferMoneyByCard;
import ai.bale.proto.SapOuterClass$ResponseAddNewCards;
import ai.bale.proto.SapOuterClass$ResponseGetCardInfo;
import ai.bale.proto.SapOuterClass$ResponseGetDestinationCardInfo;
import ai.bale.proto.SapOuterClass$ResponseReactivateApp;
import ai.bale.proto.SapOuterClass$ResponseTransferMoneyByCard;
import ai.bale.proto.SapStruct$CardExpirationDate;
import ai.bale.proto.SapStruct$CardInfo;
import ai.bale.proto.UsersOuterClass$RequestAddCard;
import ai.bale.proto.UsersOuterClass$RequestChangeDefaultCardNumber;
import ai.bale.proto.UsersOuterClass$RequestGetUsersDefaultCardNumber;
import ai.bale.proto.UsersOuterClass$RequestRemoveDefaultCardNumber;
import ai.bale.proto.UsersOuterClass$ResponseGetUsersDefaultCardNumber;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.A7;
import ir.nasim.AG2;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20471s40;
import ir.nasim.AbstractC22311v13;
import ir.nasim.AbstractC6360Ng4;
import ir.nasim.B14;
import ir.nasim.C10410bZ6;
import ir.nasim.C11458d25;
import ir.nasim.C12262eJ5;
import ir.nasim.C12889fL5;
import ir.nasim.C13466gH0;
import ir.nasim.C14505i18;
import ir.nasim.C14688iK2;
import ir.nasim.C14697iL2;
import ir.nasim.C16358l82;
import ir.nasim.C17637nI7;
import ir.nasim.C19406qI3;
import ir.nasim.C19999rI5;
import ir.nasim.C20587sG2;
import ir.nasim.C21231tK7;
import ir.nasim.C22423vC7;
import ir.nasim.C22454vG2;
import ir.nasim.C22871vx5;
import ir.nasim.C24221yF2;
import ir.nasim.C3423Au7;
import ir.nasim.C6517Nv5;
import ir.nasim.C7183Qq;
import ir.nasim.C7234Qv5;
import ir.nasim.C9057Yh4;
import ir.nasim.C9620aG7;
import ir.nasim.ED1;
import ir.nasim.EnumC16311l35;
import ir.nasim.FN5;
import ir.nasim.HF2;
import ir.nasim.InterfaceC17569nB2;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC6990Pv5;
import ir.nasim.J44;
import ir.nasim.KF2;
import ir.nasim.KS2;
import ir.nasim.M15;
import ir.nasim.O60;
import ir.nasim.OG0;
import ir.nasim.S64;
import ir.nasim.U9;
import ir.nasim.UH1;
import ir.nasim.W25;
import ir.nasim.XY6;
import ir.nasim.Y50;
import ir.nasim.YF7;
import ir.nasim.core.modules.banking.BankActor;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.payment.data.model.BankCreditCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class BankActor extends AbstractC6360Ng4 {
    public static final a s = new a(null);
    public static final int t = 8;
    private final C9057Yh4 m;
    private final C12262eJ5 n;
    private final g o;
    private final s p;
    private String q;
    private String r;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[W25.values().length];
            try {
                iArr[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankActor(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.o = new g(c9057Yh4.c());
        this.p = new s(c9057Yh4);
        this.n = new C12262eJ5(c9057Yh4.c());
    }

    private final void A1(ArrayList arrayList, BankCreditCard.c cVar) {
        ArrayList arrayListL2 = l2(cVar);
        if (arrayListL2 == null) {
            arrayListL2 = new ArrayList();
        }
        arrayListL2.addAll(arrayList);
        C16358l82 c16358l82 = C16358l82.a;
        String strT = new KS2().t(arrayListL2);
        AbstractC13042fc3.h(strT, "toJson(...)");
        String strF = C16358l82.f(c16358l82, strT, null, 2, null);
        C7183Qq.p().putString(BankCreditCard.STORAGE_PREFIX + cVar, strF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 A2(BankActor bankActor, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.k2();
    }

    private final C6517Nv5 B1(final AbstractC20471s40 abstractC20471s40) {
        C6517Nv5 c6517Nv5H = b2().H(new InterfaceC17569nB2() { // from class: ir.nasim.e40
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.F1(abstractC20471s40, this, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 B2(BankActor bankActor, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.k2();
    }

    private final C6517Nv5 C1(C13466gH0 c13466gH0) {
        C6517Nv5 c6517Nv5H = T1(c13466gH0).H(new InterfaceC17569nB2() { // from class: ir.nasim.j40
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.D1(this.a, (OG0) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 C2(C13466gH0 c13466gH0) {
        String str;
        C21231tK7 c21231tK7I0 = this.m.H().i0(this.m.H().X0());
        if ((c21231tK7I0 != null ? c21231tK7I0.l() : null) != null) {
            C10410bZ6 c10410bZ6L = c21231tK7I0.l();
            AbstractC13042fc3.f(c10410bZ6L);
            str = (String) c10410bZ6L.b();
        } else {
            str = "";
        }
        if (AbstractC13042fc3.d(new C13466gH0(str), c13466gH0)) {
            C6517Nv5 c6517Nv5H = this.o.j(c13466gH0).H(new InterfaceC17569nB2() { // from class: ir.nasim.C30
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.D2(this.a, (C14505i18) obj);
                }
            }).H(new InterfaceC17569nB2() { // from class: ir.nasim.D30
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.E2(this.a, (List) obj);
                }
            });
            AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
            return c6517Nv5H;
        }
        C6517Nv5 c6517Nv5J = this.o.j(c13466gH0);
        AbstractC13042fc3.h(c6517Nv5J, "removeCard(...)");
        return c6517Nv5J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 D1(final BankActor bankActor, final OG0 og0) {
        AbstractC13042fc3.i(bankActor, "this$0");
        StringValue.b bVarNewBuilder = StringValue.newBuilder();
        if (og0 != null) {
            bVarNewBuilder.A(og0.d());
        }
        UsersOuterClass$RequestChangeDefaultCardNumber usersOuterClass$RequestChangeDefaultCardNumber = (UsersOuterClass$RequestChangeDefaultCardNumber) UsersOuterClass$RequestChangeDefaultCardNumber.newBuilder().A(bVarNewBuilder).a();
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.f(usersOuterClass$RequestChangeDefaultCardNumber);
        AbstractC13042fc3.f(defaultInstance);
        return bankActor.M(new C22871vx5("/bale.users.v1.Users/ChangeDefaultCardNumber", usersOuterClass$RequestChangeDefaultCardNumber, defaultInstance), 18000L).H(new InterfaceC17569nB2() { // from class: ir.nasim.v30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.E1(this.a, og0, (Misc$ResponseSeq) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 D2(BankActor bankActor, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 E1(BankActor bankActor, OG0 og0, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.m.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new YF7(bankActor.m.i0(), og0 != null ? og0.d() : null), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 E2(BankActor bankActor, List list) {
        AbstractC13042fc3.i(bankActor, "this$0");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return bankActor.F2();
        }
        C13466gH0 c13466gH0 = (C13466gH0) list.get(0);
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C13466gH0 c13466gH02 = (C13466gH0) it.next();
            if (c13466gH02.r() == Y50.e) {
                c13466gH0 = c13466gH02;
                break;
            }
        }
        AbstractC13042fc3.f(c13466gH0);
        return bankActor.B1(new l(c13466gH0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 F1(AbstractC20471s40 abstractC20471s40, BankActor bankActor, List list) {
        AbstractC13042fc3.i(abstractC20471s40, "$bankCard");
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(list, "cardMasks");
        try {
            l lVar = (l) abstractC20471s40;
            C13466gH0 c13466gH0E = lVar.e() != null ? lVar.e() : new C13466gH0(lVar.f());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C13466gH0 c13466gH0 = (C13466gH0) it.next();
                if (AbstractC13042fc3.d(c13466gH0, c13466gH0E)) {
                    return bankActor.C1(c13466gH0);
                }
            }
            return C6517Nv5.F(new Exception("SAVED_CARD_NOT_FOUND"));
        } catch (Exception e) {
            C19406qI3.b("BankActor", "Error: " + e.getMessage());
            return C6517Nv5.F(e);
        }
    }

    private final C6517Nv5 F2() {
        UsersOuterClass$RequestRemoveDefaultCardNumber usersOuterClass$RequestRemoveDefaultCardNumber = (UsersOuterClass$RequestRemoveDefaultCardNumber) UsersOuterClass$RequestRemoveDefaultCardNumber.newBuilder().a();
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.f(usersOuterClass$RequestRemoveDefaultCardNumber);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5H = L(new C22871vx5("/bale.users.v1.Users/RemoveDefaultCardNumber", usersOuterClass$RequestRemoveDefaultCardNumber, defaultInstance)).E(new InterfaceC24449ye1() { // from class: ir.nasim.X30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.G2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.Y30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.H2(this.a, (Misc$ResponseSeq) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final PeersStruct$OutPeer G1(long j) {
        C11458d25 c11458d25R = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        int iJ = c11458d25R.s().p().j();
        if (iJ == -1) {
            iJ = 0;
        }
        GeneratedMessageLite generatedMessageLiteA = PeersStruct$OutPeer.newBuilder().B(c11458d25R.getPeerId()).C(EnumC16311l35.j(iJ)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (PeersStruct$OutPeer) generatedMessageLiteA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(Exception exc) {
        AbstractC13042fc3.i(exc, "obj");
        C19406qI3.d("BankActor", exc);
    }

    private final C6517Nv5 H1(UH1 uh1) {
        GeneratedMessageLite generatedMessageLiteA = SapOuterClass$RequestDeliverOtp.newBuilder().C(uh1.d()).D(uh1.c()).A((int) uh1.a()).B(uh1.b()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.sap.v1.Sap/DeliverOtp", generatedMessageLiteA, defaultInstance)).E(new InterfaceC24449ye1() { // from class: ir.nasim.x30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.I1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 H2(BankActor bankActor, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.m.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new C9620aG7(bankActor.m.i0()), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(Exception exc) {
        AbstractC13042fc3.i(exc, "e");
        C19406qI3.b("BankActor", "Error: " + exc.getMessage());
    }

    private final C6517Nv5 I2(final Long l, C11458d25 c11458d25, final long j, final long j2, final String str) {
        C6517Nv5 c6517Nv5H = h2(c11458d25).E(new InterfaceC24449ye1() { // from class: ir.nasim.f40
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.J2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.g40
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.K2(j, j2, str, l, this, (PeersStruct$OutPeer) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 J1(final d dVar) {
        m mVarB = dVar.b();
        AbstractC13042fc3.f(mVarB);
        C6517Nv5 c6517Nv5S1 = S1(mVarB);
        if (dVar instanceof n) {
            C6517Nv5 c6517Nv5H = c6517Nv5S1.H(new InterfaceC17569nB2() { // from class: ir.nasim.k40
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.K1(this.a, dVar, (OG0) obj);
                }
            }).H(new InterfaceC17569nB2() { // from class: ir.nasim.l40
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.L1((ir.nasim.core.modules.banking.h) obj);
                }
            });
            AbstractC13042fc3.f(c6517Nv5H);
            return c6517Nv5H;
        }
        if (dVar instanceof o) {
            C6517Nv5 c6517Nv5H2 = c6517Nv5S1.H(new InterfaceC17569nB2() { // from class: ir.nasim.m40
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.M1(this.a, dVar, (OG0) obj);
                }
            }).H(new InterfaceC17569nB2() { // from class: ir.nasim.n40
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.N1((ir.nasim.core.modules.banking.i) obj);
                }
            });
            AbstractC13042fc3.f(c6517Nv5H2);
            return c6517Nv5H2;
        }
        if (dVar instanceof p) {
            C6517Nv5 c6517Nv5H3 = c6517Nv5S1.H(new InterfaceC17569nB2() { // from class: ir.nasim.o40
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.O1(this.a, dVar, (OG0) obj);
                }
            }).H(new InterfaceC17569nB2() { // from class: ir.nasim.l30
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.P1((B14) obj);
                }
            });
            AbstractC13042fc3.f(c6517Nv5H3);
            return c6517Nv5H3;
        }
        C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("BANK OPERATION NOT VALID"));
        AbstractC13042fc3.f(c6517Nv5F);
        return c6517Nv5F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(Exception exc) {
        C19406qI3.d("BankActor", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 K1(BankActor bankActor, d dVar, OG0 og0) {
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(dVar, "$bankOperation");
        if (og0 != null) {
            return bankActor.Y1(og0, ((n) dVar).a());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 K2(long j, long j2, String str, Long l, BankActor bankActor, PeersStruct$OutPeer peersStruct$OutPeer) {
        Int32Value.b bVarA;
        AbstractC13042fc3.i(bankActor, "this$0");
        MessagingStruct$HistoryMessageIdentifier.a aVarA = MessagingStruct$HistoryMessageIdentifier.newBuilder().C(peersStruct$OutPeer).D(j).A(j2);
        StringValue.b bVarA2 = StringValue.newBuilder().A(str);
        if (l != null) {
            bVarA = Int32Value.newBuilder().A((int) l.longValue());
        } else {
            bVarA = null;
        }
        BankOuterClass$RequestGetPaymentToken bankOuterClass$RequestGetPaymentToken = (BankOuterClass$RequestGetPaymentToken) BankOuterClass$RequestGetPaymentToken.newBuilder().C(aVarA).B(bVarA2).A(bVarA).a();
        BankOuterClass$ResponseGetPaymentToken defaultInstance = BankOuterClass$ResponseGetPaymentToken.getDefaultInstance();
        AbstractC13042fc3.f(bankOuterClass$RequestGetPaymentToken);
        AbstractC13042fc3.f(defaultInstance);
        return bankActor.M(new C22871vx5("/bale.bank.v1.Bank/GetPaymentToken", bankOuterClass$RequestGetPaymentToken, defaultInstance), 18000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 L1(h hVar) {
        return C6517Nv5.l0(hVar);
    }

    private final C6517Nv5 L2(m mVar) {
        final C13466gH0 c13466gH0E = mVar.e();
        if (c13466gH0E == null) {
            OG0 og0 = new OG0(mVar.f(), mVar.m(), mVar.l());
            og0.n(mVar.j());
            k1(og0).H(new InterfaceC17569nB2() { // from class: ir.nasim.O30
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.M2(this.a, (C14505i18) obj);
                }
            }).H(new InterfaceC17569nB2() { // from class: ir.nasim.P30
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.N2((List) obj);
                }
            });
            return C6517Nv5.l0(og0);
        }
        long jS = c13466gH0E.s();
        String strL = mVar.l();
        AbstractC13042fc3.h(strL, "getCvv2(...)");
        String strM = mVar.m();
        AbstractC13042fc3.h(strM, "getExpireDate(...)");
        return Q1(jS, strL, strM, mVar.j()).H(new InterfaceC17569nB2() { // from class: ir.nasim.Q30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.O2(this.a, c13466gH0E, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 M1(BankActor bankActor, d dVar, OG0 og0) {
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(dVar, "$bankOperation");
        if (og0 != null) {
            return bankActor.V1(og0, ((o) dVar).a());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 M2(BankActor bankActor, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 N1(i iVar) {
        return C6517Nv5.l0(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 N2(List list) {
        List list2 = list;
        return (list2 == null || list2.isEmpty()) ? C6517Nv5.F(new Exception("CANT_SAVE_CARD__CARD_MASKS_NULL_OR_EMPTY")) : C6517Nv5.l0(list.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 O1(BankActor bankActor, d dVar, OG0 og0) {
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(dVar, "$bankOperation");
        if (og0 == null) {
            return null;
        }
        p pVar = (p) dVar;
        String strA = pVar.a();
        S64 s64E = pVar.e();
        AbstractC13042fc3.h(s64E, "getMessageIdentifier(...)");
        return bankActor.U2(og0, strA, s64E, pVar.d(), pVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 O2(BankActor bankActor, C13466gH0 c13466gH0, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.T1(c13466gH0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 P1(B14 b14) {
        return C6517Nv5.l0(b14);
    }

    private final C6517Nv5 P2(C3423Au7 c3423Au7) {
        SapOuterClass$RequestTransferMoneyByCard.a aVarF = SapOuterClass$RequestTransferMoneyByCard.newBuilder().C(c3423Au7.h()).B(c3423Au7.b()).E(c3423Au7.d()).A(c3423Au7.a()).D(CollectionsStruct$StringValue.newBuilder().A(c3423Au7.c())).F((CollectionsStruct$StringValue) CollectionsStruct$StringValue.newBuilder().A(c3423Au7.e()).a());
        if (c3423Au7.g() != null) {
            aVarF.H(CollectionsStruct$StringValue.newBuilder().A(c3423Au7.g()));
        }
        HistoryMessageData historyMessageDataF = c3423Au7.f();
        if (historyMessageDataF != null) {
            aVarF.G((MessagingStruct$HistoryMessageIdentifier) MessagingStruct$HistoryMessageIdentifier.newBuilder().A(historyMessageDataF.getDate()).D(historyMessageDataF.getId()).C(G1(historyMessageDataF.getPeer())).a());
        }
        Long lI = c3423Au7.i();
        if (lI != null) {
            aVarF.I((CollectionsStruct$Int32Value) CollectionsStruct$Int32Value.newBuilder().A(Math.toIntExact(lI.longValue())).a());
        }
        GeneratedMessageLite generatedMessageLiteA = aVarF.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        SapOuterClass$ResponseTransferMoneyByCard defaultInstance = SapOuterClass$ResponseTransferMoneyByCard.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.sap.v1.Sap/TransferMoneyByCard", generatedMessageLiteA, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 Q1(long j, final String str, final String str2, final boolean z) {
        C6517Nv5 c6517Nv5H = this.o.f(Long.valueOf(j)).H(new InterfaceC17569nB2() { // from class: ir.nasim.a40
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.R1(str2, str, z, this, (OG0) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 Q2(final C22423vC7 c22423vC7) {
        final BankCreditCard bankCreditCardA = c22423vC7.a();
        SapStruct$CardExpirationDate.a aVarA = SapStruct$CardExpirationDate.newBuilder().B(c22423vC7.d()).A(c22423vC7.c());
        SapOuterClass$RequestEditCardExpirationDate.a aVarNewBuilder = SapOuterClass$RequestEditCardExpirationDate.newBuilder();
        String id = bankCreditCardA.getId();
        if (id == null) {
            id = "";
        }
        SapOuterClass$RequestEditCardExpirationDate sapOuterClass$RequestEditCardExpirationDate = (SapOuterClass$RequestEditCardExpirationDate) aVarNewBuilder.B(id).A(aVarA).a();
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.f(sapOuterClass$RequestEditCardExpirationDate);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.sap.v1.Sap/EditCardExpirationDate", sapOuterClass$RequestEditCardExpirationDate, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.m30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.R2(bankCreditCardA, c22423vC7, this, (Misc$ResponseVoid) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.n30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.S2((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 R1(String str, String str2, boolean z, BankActor bankActor, OG0 og0) {
        AbstractC13042fc3.i(str, "$exDate");
        AbstractC13042fc3.i(str2, "$cvv2");
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(og0, "cardInfo");
        OG0 og02 = new OG0(og0.d(), str, str2);
        og02.n(z);
        return bankActor.o.c(og02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R2(BankCreditCard bankCreditCard, C22423vC7 c22423vC7, BankActor bankActor, Misc$ResponseVoid misc$ResponseVoid) {
        AbstractC13042fc3.i(bankCreditCard, "$card");
        AbstractC13042fc3.i(c22423vC7, "$update");
        AbstractC13042fc3.i(bankActor, "this$0");
        ArrayList arrayList = new ArrayList();
        bankCreditCard.setExpirationMonth(Integer.valueOf(c22423vC7.c()));
        bankCreditCard.setExpirationYear(Integer.valueOf(c22423vC7.d()));
        bankCreditCard.setCvv2(c22423vC7.b());
        arrayList.add(bankCreditCard);
        bankActor.T2(bankCreditCard);
    }

    private final C6517Nv5 S1(m mVar) {
        return v2(mVar) ? T1(mVar.e()) : L2(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S2(Exception exc) {
        AbstractC13042fc3.i(exc, "e");
        C19406qI3.b("BankActor", "Error: " + exc.getMessage());
    }

    private final C6517Nv5 T1(C13466gH0 c13466gH0) {
        C6517Nv5 c6517Nv5E = this.o.e(c13466gH0);
        AbstractC13042fc3.h(c6517Nv5E, "getCard(...)");
        return c6517Nv5E;
    }

    private final C6517Nv5 U1(C24221yF2 c24221yF2) {
        SapOuterClass$RequestGetCardInfo sapOuterClass$RequestGetCardInfo = (SapOuterClass$RequestGetCardInfo) SapOuterClass$RequestGetCardInfo.newBuilder().B(c24221yF2.b()).A(CollectionsStruct$StringValue.newBuilder().A(c24221yF2.a())).a();
        AbstractC13042fc3.f(sapOuterClass$RequestGetCardInfo);
        SapOuterClass$ResponseGetCardInfo defaultInstance = SapOuterClass$ResponseGetCardInfo.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5M = M(new C22871vx5("/bale.sap.v1.Sap/GetCardInfo", sapOuterClass$RequestGetCardInfo, defaultInstance), 5000L);
        AbstractC13042fc3.h(c6517Nv5M, "api(...)");
        return c6517Nv5M;
    }

    private final C6517Nv5 U2(final OG0 og0, final String str, S64 s64, String str2, final long j) {
        Long lValueOf = Long.valueOf(j);
        C11458d25 c11458d25B = s64.b();
        AbstractC13042fc3.h(c11458d25B, "getPeer(...)");
        C6517Nv5 c6517Nv5E = I2(lValueOf, c11458d25B, s64.c(), s64.a(), str2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.K30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.V2(this.a, (BankOuterClass$ResponseGetPaymentToken) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.L30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.W2(this.a, j, (BankOuterClass$ResponseGetPaymentToken) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.M30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.X2(this.a, og0, str, (M15) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.N30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.Y2((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    private final C6517Nv5 V1(final OG0 og0, final String str) {
        Microbanki$RequestGetBamServiceToken microbanki$RequestGetBamServiceToken = (Microbanki$RequestGetBamServiceToken) Microbanki$RequestGetBamServiceToken.newBuilder().A(O60.BamServiceType_CARD_STATEMENT).a();
        Microbanki$ResponseGetBamServiceToken defaultInstance = Microbanki$ResponseGetBamServiceToken.getDefaultInstance();
        AbstractC13042fc3.f(microbanki$RequestGetBamServiceToken);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/bale.microbanki.v1.MicroBanki/GetBamServiceToken", microbanki$RequestGetBamServiceToken, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.E30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.W1(this.a, og0, str, (Microbanki$ResponseGetBamServiceToken) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.F30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.X1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(BankActor bankActor, BankOuterClass$ResponseGetPaymentToken bankOuterClass$ResponseGetPaymentToken) {
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(bankOuterClass$ResponseGetPaymentToken, "responseGetPaymentToken");
        bankActor.q = bankOuterClass$ResponseGetPaymentToken.getToken();
        bankActor.r = bankOuterClass$ResponseGetPaymentToken.getEndpoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 W1(BankActor bankActor, OG0 og0, String str, Microbanki$ResponseGetBamServiceToken microbanki$ResponseGetBamServiceToken) {
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(og0, "$cardInfo");
        AbstractC13042fc3.i(microbanki$ResponseGetBamServiceToken, "responseGetBamServiceToken");
        return bankActor.p.l(og0.d(), str, og0.a(), og0.b(), microbanki$ResponseGetBamServiceToken.getEndpoint(), microbanki$ResponseGetBamServiceToken.getToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 W2(BankActor bankActor, long j, BankOuterClass$ResponseGetPaymentToken bankOuterClass$ResponseGetPaymentToken) {
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(bankOuterClass$ResponseGetPaymentToken, "responseGetPaymentToken");
        return bankActor.p.q(bankOuterClass$ResponseGetPaymentToken.getEndpoint(), j, bankOuterClass$ResponseGetPaymentToken.getToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(Exception exc) {
        AbstractC13042fc3.i(exc, "obj");
        C19406qI3.d("BankActor", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 X2(BankActor bankActor, OG0 og0, String str, M15 m15) {
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(og0, "$cardInfo");
        AbstractC13042fc3.i(m15, "payLoanVerifyResponse");
        String str2 = bankActor.q;
        AbstractC13042fc3.f(str2);
        String str3 = bankActor.r;
        AbstractC13042fc3.f(str3);
        s sVar = bankActor.p;
        if (str == null) {
            str = "";
        }
        return C6517Nv5.l0(new B14(true, null, str2, str3, sVar, og0, str, m15.c(), m15.b(), m15.a()));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C6517Nv5 Y1(final ir.nasim.OG0 r5, final java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = r5.d()
            int r1 = r0.length()
            r2 = 6
            if (r1 < r2) goto Lc
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 == 0) goto L1b
            r1 = 0
            java.lang.String r0 = r0.substring(r1, r2)
            java.lang.String r1 = "substring(...)"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            if (r0 != 0) goto L1d
        L1b:
            java.lang.String r0 = "123456"
        L1d:
            ai.bale.proto.BankOuterClass$RequestGetRemainToken$a r1 = ai.bale.proto.BankOuterClass$RequestGetRemainToken.newBuilder()
            ai.bale.proto.BankOuterClass$RequestGetRemainToken$a r0 = r1.A(r0)
            com.google.protobuf.GeneratedMessageLite r0 = r0.a()
            ai.bale.proto.BankOuterClass$RequestGetRemainToken r0 = (ai.bale.proto.BankOuterClass$RequestGetRemainToken) r0
            ai.bale.proto.BankOuterClass$ResponseGetRemainToken r1 = ai.bale.proto.BankOuterClass$ResponseGetRemainToken.getDefaultInstance()
            ir.nasim.vx5 r2 = new ir.nasim.vx5
            ir.nasim.AbstractC13042fc3.f(r0)
            ir.nasim.AbstractC13042fc3.f(r1)
            java.lang.String r3 = "/bale.bank.v1.Bank/GetRemainToken"
            r2.<init>(r3, r0, r1)
            ir.nasim.Nv5 r0 = r4.L(r2)
            ir.nasim.V30 r1 = new ir.nasim.V30
            r1.<init>()
            ir.nasim.Nv5 r5 = r0.H(r1)
            ir.nasim.W30 r6 = new ir.nasim.W30
            r6.<init>()
            ir.nasim.Nv5 r5 = r5.E(r6)
            java.lang.String r6 = "failure(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.core.modules.banking.BankActor.Y1(ir.nasim.OG0, java.lang.String):ir.nasim.Nv5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(Exception exc) {
        C19406qI3.d("BankActor", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Z1(BankActor bankActor, OG0 og0, String str, BankOuterClass$ResponseGetRemainToken bankOuterClass$ResponseGetRemainToken) {
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(og0, "$cardInfo");
        AbstractC13042fc3.i(bankOuterClass$ResponseGetRemainToken, "responseGetRemainToken");
        return bankActor.p.m(og0.d(), str, og0.a(), og0.b(), bankOuterClass$ResponseGetRemainToken.getRequestEndPoint(), bankOuterClass$ResponseGetRemainToken.getToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(Exception exc) {
        AbstractC13042fc3.i(exc, "obj");
        C19406qI3.d("BankActor", exc);
    }

    private final C6517Nv5 b2() {
        C6517Nv5 c6517Nv5G = this.o.g();
        AbstractC13042fc3.h(c6517Nv5G, "getCardsMask(...)");
        return c6517Nv5G;
    }

    private final C6517Nv5 c2(C11458d25 c11458d25, final J44 j44) {
        return h2(c11458d25).H(new InterfaceC17569nB2() { // from class: ir.nasim.y30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.d2(j44, this, (PeersStruct$OutPeer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 d2(J44 j44, BankActor bankActor, PeersStruct$OutPeer peersStruct$OutPeer) {
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(bankActor, "this$0");
        Crowdfunding$RequestGetTotalPaidAmount crowdfunding$RequestGetTotalPaidAmount = (Crowdfunding$RequestGetTotalPaidAmount) Crowdfunding$RequestGetTotalPaidAmount.newBuilder().A(MessagingStruct$HistoryMessageIdentifier.newBuilder().C(peersStruct$OutPeer).D(j44.i()).A(j44.h())).a();
        Crowdfunding$ResponseGetTotalPaidAmount defaultInstance = Crowdfunding$ResponseGetTotalPaidAmount.getDefaultInstance();
        AbstractC13042fc3.f(crowdfunding$RequestGetTotalPaidAmount);
        AbstractC13042fc3.f(defaultInstance);
        return bankActor.L(new C22871vx5("/bale.crowdfunding.v1.CrowdFunding/GetTotalPaidAmount", crowdfunding$RequestGetTotalPaidAmount, defaultInstance));
    }

    private final C6517Nv5 e2(KF2 kf2) {
        SapOuterClass$RequestGetDestinationCardInfo.a aVarA = SapOuterClass$RequestGetDestinationCardInfo.newBuilder().B(kf2.b()).C(kf2.c()).D(0).F("").A(kf2.a());
        HistoryMessageData historyMessageDataD = kf2.d();
        if (historyMessageDataD != null) {
            aVarA.E((MessagingStruct$HistoryMessageIdentifier) MessagingStruct$HistoryMessageIdentifier.newBuilder().A(historyMessageDataD.getDate()).D(historyMessageDataD.getId()).C(G1(historyMessageDataD.getPeer())).a());
        }
        if (kf2.e() != null) {
            CollectionsStruct$Int32Value.a aVarNewBuilder = CollectionsStruct$Int32Value.newBuilder();
            AbstractC13042fc3.f(kf2.e());
            aVarA.G((CollectionsStruct$Int32Value) aVarNewBuilder.A(Math.toIntExact(r6.intValue())).a());
        }
        GeneratedMessageLite generatedMessageLiteA = aVarA.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        SapOuterClass$ResponseGetDestinationCardInfo defaultInstance = SapOuterClass$ResponseGetDestinationCardInfo.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.sap.v1.Sap/GetDestinationCardInfo", generatedMessageLiteA, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 f2(C11458d25 c11458d25) {
        C6517Nv5 c6517Nv5H0 = this.m.E().X1().a(c11458d25.getPeerId()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.i40
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.g2((C14697iL2) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PeersStruct$OutPeer g2(C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c14697iL2, "group");
        return (PeersStruct$OutPeer) PeersStruct$OutPeer.newBuilder().B(c14697iL2.p0()).A(c14697iL2.getAccessHash()).C(EnumC16311l35.PeerType_GROUP).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 h1(List list) {
        ArrayList arrayList = new ArrayList();
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C13466gH0 c13466gH0 = (C13466gH0) it.next();
                if (c13466gH0 != null) {
                    arrayList.add(new l(c13466gH0));
                }
            }
        }
        return C6517Nv5.l0(arrayList);
    }

    private final C6517Nv5 h2(final C11458d25 c11458d25) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.J30
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                BankActor.i2(c11458d25, this, c7234Qv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 i1(List list) {
        ArrayList arrayList = new ArrayList();
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C13466gH0 c13466gH0 = (C13466gH0) it.next();
                if (XY6.m(c13466gH0.w())) {
                    arrayList.add(new m(c13466gH0));
                } else {
                    arrayList.add(new l(c13466gH0));
                }
            }
        }
        return C6517Nv5.l0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(C11458d25 c11458d25, BankActor bankActor, C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        int i = b.a[c11458d25.s().ordinal()];
        if (i == 1) {
            bankActor.q2(c11458d25).i0(c7234Qv5);
        } else {
            if (i == 2) {
                bankActor.f2(c11458d25).i0(c7234Qv5);
                return;
            }
            throw new RuntimeException("Unknown peer: " + c11458d25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 j1(List list) {
        ArrayList arrayList = new ArrayList();
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C13466gH0 c13466gH0 = (C13466gH0) it.next();
                if (XY6.m(c13466gH0.w())) {
                    arrayList.add(new m(c13466gH0));
                } else {
                    arrayList.add(new l(c13466gH0));
                }
            }
        }
        return C6517Nv5.l0(arrayList);
    }

    private final C6517Nv5 j2() {
        C6517Nv5 c6517Nv5H = this.n.e().H(new InterfaceC17569nB2() { // from class: ir.nasim.w30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.h1((List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 k1(OG0 og0) {
        C6517Nv5 c6517Nv5H = this.o.c(og0).H(new InterfaceC17569nB2() { // from class: ir.nasim.H30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.l1(this.a, (C14505i18) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.I30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.m1(this.a, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 l1(BankActor bankActor, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.k2();
    }

    private final ArrayList l2(BankCreditCard.c cVar) {
        String strE = C7183Qq.p().e(BankCreditCard.STORAGE_PREFIX + cVar);
        if (strE == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) new KS2().l(C16358l82.c(C16358l82.a, strE, null, 2, null), new TypeToken<ArrayList<BankCreditCard>>() { // from class: ir.nasim.core.modules.banking.BankActor$getSavedCreditCards$cards$1
        }.d());
        Comparator comparator = new Comparator() { // from class: ir.nasim.b40
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BankActor.m2((BankCreditCard) obj, (BankCreditCard) obj2);
            }
        };
        AbstractC13042fc3.g(comparator, "null cannot be cast to non-null type java.util.Comparator<ir.nasim.features.payment.data.model.BankCreditCard>");
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 m1(BankActor bankActor, List list) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return (list == null || list.size() != 1) ? C6517Nv5.l0(C14505i18.a) : bankActor.B1((AbstractC20471s40) list.get(0)).G(new InterfaceC17569nB2() { // from class: ir.nasim.Z30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.n1((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m2(BankCreditCard bankCreditCard, BankCreditCard bankCreditCard2) {
        AbstractC13042fc3.i(bankCreditCard, "<destruct>");
        AbstractC13042fc3.i(bankCreditCard2, "<destruct>");
        String number = bankCreditCard.getNumber();
        boolean isDefault = bankCreditCard.getIsDefault();
        boolean isShaparkMigrationNeed = bankCreditCard.getIsShaparkMigrationNeed();
        boolean isEnrolled = bankCreditCard.getIsEnrolled();
        String number2 = bankCreditCard2.getNumber();
        boolean isDefault2 = bankCreditCard2.getIsDefault();
        boolean isShaparkMigrationNeed2 = bankCreditCard2.getIsShaparkMigrationNeed();
        boolean isEnrolled2 = bankCreditCard2.getIsEnrolled();
        if (isDefault2) {
            return 1;
        }
        if (isDefault) {
            return -1;
        }
        if (!isEnrolled && isEnrolled2) {
            return 1;
        }
        if (isEnrolled && !isEnrolled2) {
            return -1;
        }
        if (isShaparkMigrationNeed && !isShaparkMigrationNeed2) {
            return 1;
        }
        if (isShaparkMigrationNeed || !isShaparkMigrationNeed2) {
            return AbstractC20153rZ6.v(number, number2, true);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 n1(Exception exc) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final C6517Nv5 n2() {
        C6517Nv5 c6517Nv5H = b2().H(new InterfaceC17569nB2() { // from class: ir.nasim.q30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.j1((List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 o1(A7 a7) {
        final C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = a7.a();
        SapStruct$CardExpirationDate.a aVarNewBuilder = SapStruct$CardExpirationDate.newBuilder();
        Integer expirationYear = ((BankCreditCard) c12889fL5.a).getExpirationYear();
        if (expirationYear != null) {
            aVarNewBuilder.B(expirationYear.intValue());
        }
        Integer expirationMonth = ((BankCreditCard) c12889fL5.a).getExpirationMonth();
        if (expirationMonth != null) {
            aVarNewBuilder.A(expirationMonth.intValue());
        }
        SapOuterClass$RequestAddNewCards sapOuterClass$RequestAddNewCards = (SapOuterClass$RequestAddNewCards) SapOuterClass$RequestAddNewCards.newBuilder().B(SapStruct$CardInfo.newBuilder().C(((BankCreditCard) c12889fL5.a).getNumber()).A(aVarNewBuilder)).a();
        SapOuterClass$ResponseAddNewCards defaultInstance = SapOuterClass$ResponseAddNewCards.getDefaultInstance();
        AbstractC13042fc3.f(sapOuterClass$RequestAddNewCards);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5H = L(new C22871vx5("/bale.sap.v1.Sap/AddNewCards", sapOuterClass$RequestAddNewCards, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.r30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.u1(c12889fL5, this, (SapOuterClass$ResponseAddNewCards) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.s30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.v1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.t30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.q1(c12889fL5, (SapOuterClass$ResponseAddNewCards) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 o2(AG2 ag2) {
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestGetUsersDefaultCardNumber.newBuilder().A(AbstractC22311v13.a(new Object[]{Integer.valueOf(ag2.a())})).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        UsersOuterClass$ResponseGetUsersDefaultCardNumber defaultInstance = UsersOuterClass$ResponseGetUsersDefaultCardNumber.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = M(new C22871vx5("/bale.users.v1.Users/GetUsersDefaultCardNumber", generatedMessageLiteA, defaultInstance), 4000L).H(new InterfaceC17569nB2() { // from class: ir.nasim.u30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.p2((UsersOuterClass$ResponseGetUsersDefaultCardNumber) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 p1(U9 u9) {
        l lVarA = u9.a();
        if (XY6.m(lVarA.f())) {
            C19406qI3.j("BankActor", "digitOnlyBankCard.getCardNumber() null or empty, something seems wrong", new Object[0]);
            C6517Nv5 c6517Nv5H = T1(lVarA.e()).H(new InterfaceC17569nB2() { // from class: ir.nasim.R30
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.s1(this.a, (OG0) obj);
                }
            }).H(new InterfaceC17569nB2() { // from class: ir.nasim.c40
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.t1(this.a, (C14505i18) obj);
                }
            });
            AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
            return c6517Nv5H;
        }
        x2(lVarA.f());
        C6517Nv5 c6517Nv5H2 = w1("TEMP", lVarA.f()).H(new InterfaceC17569nB2() { // from class: ir.nasim.G30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.r1(this.a, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H2, "flatMap(...)");
        return c6517Nv5H2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 p2(UsersOuterClass$ResponseGetUsersDefaultCardNumber usersOuterClass$ResponseGetUsersDefaultCardNumber) {
        AbstractC13042fc3.i(usersOuterClass$ResponseGetUsersDefaultCardNumber, "response");
        return usersOuterClass$ResponseGetUsersDefaultCardNumber.getDefaultCardNoList().isEmpty() ? C6517Nv5.l0("") : C6517Nv5.l0(usersOuterClass$ResponseGetUsersDefaultCardNumber.getDefaultCardNo(0).getDefaultCardNo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 q1(C12889fL5 c12889fL5, SapOuterClass$ResponseAddNewCards sapOuterClass$ResponseAddNewCards) {
        AbstractC13042fc3.i(c12889fL5, "$card");
        return C6517Nv5.l0(c12889fL5.a);
    }

    private final C6517Nv5 q2(C11458d25 c11458d25) {
        C6517Nv5 c6517Nv5H0 = this.m.W().p0().a(c11458d25.getPeerId()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.h40
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.r2((C17637nI7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 r1(BankActor bankActor, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.k2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PeersStruct$OutPeer r2(C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(c17637nI7, "user");
        return (PeersStruct$OutPeer) PeersStruct$OutPeer.newBuilder().B(c17637nI7.n0()).A(c17637nI7.getAccessHash()).C(EnumC16311l35.PeerType_PRIVATE).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 s1(BankActor bankActor, OG0 og0) {
        AbstractC13042fc3.i(bankActor, "this$0");
        if (og0 != null) {
            bankActor.x2(og0.d());
        }
        return bankActor.k1(og0);
    }

    private final C6517Nv5 s2(C14688iK2 c14688iK2) {
        BankOuterClass$RequestGrantBankiAccess bankOuterClass$RequestGrantBankiAccess = (BankOuterClass$RequestGrantBankiAccess) BankOuterClass$RequestGrantBankiAccess.newBuilder().A(PeersStruct$UserOutPeer.newBuilder().B(c14688iK2.b()).A(((C17637nI7) this.m.W().p0().d(c14688iK2.b())).getAccessHash())).B(c14688iK2.a()).a();
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.f(bankOuterClass$RequestGrantBankiAccess);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5H = L(new C22871vx5("/bale.bank.v1.Bank/GrantBankiAccess", bankOuterClass$RequestGrantBankiAccess, defaultInstance)).E(new InterfaceC24449ye1() { // from class: ir.nasim.o30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.t2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.p30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.u2((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 t1(BankActor bankActor, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.k2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(Exception exc) {
        AbstractC13042fc3.i(exc, "obj");
        C19406qI3.d("BankActor", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(C12889fL5 c12889fL5, BankActor bankActor, SapOuterClass$ResponseAddNewCards sapOuterClass$ResponseAddNewCards) {
        AbstractC13042fc3.i(c12889fL5, "$card");
        AbstractC13042fc3.i(bankActor, "this$0");
        AbstractC13042fc3.i(sapOuterClass$ResponseAddNewCards, "responseAddNewCards");
        BankCreditCard bankCreditCard = (BankCreditCard) c12889fL5.a;
        String number = bankCreditCard.getNumber();
        Integer expirationMonth = bankCreditCard.getExpirationMonth();
        Integer expirationYear = bankCreditCard.getExpirationYear();
        String cvv2 = bankCreditCard.getCvv2();
        boolean isDefault = bankCreditCard.getIsDefault();
        String cardId = sapOuterClass$ResponseAddNewCards.getCardId(0);
        BankCreditCard.c cVar = BankCreditCard.c.a;
        BankCreditCard bankCreditCard2 = new BankCreditCard(cardId, number, expirationYear, expirationMonth, cvv2, null, true, cVar, isDefault, false, false);
        c12889fL5.a = bankCreditCard2;
        bankActor.A1(AbstractC10360bX0.g(bankCreditCard2), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 u2(Misc$ResponseVoid misc$ResponseVoid) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(Exception exc) {
        AbstractC13042fc3.i(exc, "e");
        C19406qI3.b("BankActor", "Error: " + exc.getMessage());
    }

    private final boolean v2(m mVar) {
        if (mVar.e() != null) {
            C13466gH0 c13466gH0E = mVar.e();
            if (XY6.m(c13466gH0E != null ? c13466gH0E.w() : null)) {
                return true;
            }
        }
        return false;
    }

    private final C6517Nv5 w1(String str, String str2) {
        C6517Nv5 c6517Nv5H = this.o.d(str, str2).H(new InterfaceC17569nB2() { // from class: ir.nasim.T30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.x1(this.a, (C14505i18) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.U30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.y1(this.a, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final C6517Nv5 w2() {
        GeneratedMessageLite generatedMessageLiteA = SapOuterClass$RequestReactivateApp.newBuilder().a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        SapOuterClass$ResponseReactivateApp defaultInstance = SapOuterClass$ResponseReactivateApp.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.sap.v1.Sap/ReactivateApp", generatedMessageLiteA, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 x1(BankActor bankActor, C14505i18 c14505i18) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return bankActor.k2();
    }

    private final void x2(String str) {
        if (str == null || str.length() < 6) {
            return;
        }
        String strSubstring = str.substring(0, 6);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        UsersOuterClass$RequestAddCard usersOuterClass$RequestAddCard = (UsersOuterClass$RequestAddCard) UsersOuterClass$RequestAddCard.newBuilder().A(strSubstring).a();
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.f(usersOuterClass$RequestAddCard);
        AbstractC13042fc3.f(defaultInstance);
        L(new C22871vx5("/bale.users.v1.Users/AddCard", usersOuterClass$RequestAddCard, defaultInstance)).E(new InterfaceC24449ye1() { // from class: ir.nasim.S30
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankActor.y2((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 y1(BankActor bankActor, List list) {
        AbstractC13042fc3.i(bankActor, "this$0");
        return (list == null || list.size() != 1) ? C6517Nv5.l0(C14505i18.a) : bankActor.B1((AbstractC20471s40) list.get(0)).G(new InterfaceC17569nB2() { // from class: ir.nasim.d40
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.z1((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(Exception exc) {
        AbstractC13042fc3.i(exc, "e");
        C19406qI3.a("BankActor", exc.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 z1(Exception exc) {
        return C6517Nv5.l0(C14505i18.a);
    }

    private final C6517Nv5 z2(FN5 fn5) {
        AbstractC20471s40 abstractC20471s40A = fn5.a();
        if (!(abstractC20471s40A instanceof l)) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("WRONG BANK CARD TYPE FOR DELETE"));
            AbstractC13042fc3.h(c6517Nv5F, "failure(...)");
            return c6517Nv5F;
        }
        l lVar = (l) abstractC20471s40A;
        if (lVar.e() != null) {
            C6517Nv5 c6517Nv5H = C2(lVar.e()).H(new InterfaceC17569nB2() { // from class: ir.nasim.z30
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return BankActor.A2(this.a, (C14505i18) obj);
                }
            });
            AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
            return c6517Nv5H;
        }
        C19406qI3.j("BankActor", "bankCard.getCardMask() is null, something seems wrong", new Object[0]);
        C6517Nv5 c6517Nv5H2 = C2(new C13466gH0(lVar.f())).H(new InterfaceC17569nB2() { // from class: ir.nasim.A30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.B2(this.a, (C14505i18) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H2, "flatMap(...)");
        return c6517Nv5H2;
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (!(obj instanceof HF2)) {
            return obj instanceof C19999rI5 ? w2() : obj instanceof UH1 ? H1((UH1) obj) : obj instanceof C3423Au7 ? P2((C3423Au7) obj) : obj instanceof C24221yF2 ? U1((C24221yF2) obj) : obj instanceof KF2 ? e2((KF2) obj) : obj instanceof AG2 ? o2((AG2) obj) : obj instanceof C14688iK2 ? s2((C14688iK2) obj) : obj instanceof d ? J1((d) obj) : obj instanceof C22454vG2 ? n2() : obj instanceof C20587sG2 ? j2() : obj instanceof U9 ? p1((U9) obj) : obj instanceof FN5 ? z2((FN5) obj) : obj instanceof A7 ? o1((A7) obj) : obj instanceof C22423vC7 ? Q2((C22423vC7) obj) : super.G(obj);
        }
        HF2 hf2 = (HF2) obj;
        return c2(hf2.b(), hf2.a());
    }

    public final void T2(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "updateCard");
        ArrayList arrayListL2 = l2(BankCreditCard.c.a);
        if (arrayListL2 == null) {
            arrayListL2 = new ArrayList();
        }
        Iterator it = arrayListL2.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            BankCreditCard bankCreditCard2 = (BankCreditCard) next;
            if (AbstractC20153rZ6.D(bankCreditCard2.getId(), bankCreditCard.getId(), true)) {
                bankCreditCard2.setExpirationMonth(bankCreditCard.getExpirationMonth());
                bankCreditCard2.setExpirationYear(bankCreditCard.getExpirationYear());
                bankCreditCard2.setCvv2(bankCreditCard.getCvv2());
            }
        }
        C16358l82 c16358l82 = C16358l82.a;
        String strT = new KS2().t(arrayListL2);
        AbstractC13042fc3.h(strT, "toJson(...)");
        String strF = C16358l82.f(c16358l82, strT, null, 2, null);
        C7183Qq.p().putString(BankCreditCard.STORAGE_PREFIX + BankCreditCard.c.a, strF);
    }

    public final C6517Nv5 k2() {
        C6517Nv5 c6517Nv5H = b2().H(new InterfaceC17569nB2() { // from class: ir.nasim.B30
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankActor.i1((List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    @Override // ir.nasim.K6
    public void o() {
    }
}
