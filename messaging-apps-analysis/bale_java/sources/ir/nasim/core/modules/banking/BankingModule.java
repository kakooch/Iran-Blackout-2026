package ir.nasim.core.modules.banking;

import ai.bale.proto.BankOuterClass$RequestBuyFastCharge;
import ai.bale.proto.BankOuterClass$RequestGetOTPToken;
import ai.bale.proto.BankOuterClass$RequestGetRecentCharges;
import ai.bale.proto.BankOuterClass$RequestGetSadadPSPPaymentToken;
import ai.bale.proto.BankOuterClass$ResponseBuyFastCharge;
import ai.bale.proto.BankOuterClass$ResponseGetOTPToken;
import ai.bale.proto.BankOuterClass$ResponseGetRecentCharges;
import ai.bale.proto.BankOuterClass$ResponseGetSadadPSPPaymentToken;
import ai.bale.proto.BankStruct$MoneyRequestPayment;
import ai.bale.proto.BankStruct$RecentCharge;
import ai.bale.proto.KifpoolOuterClass$RequestGetMyKifpools;
import ai.bale.proto.KifpoolOuterClass$ResponseGetMyKifpools;
import ai.bale.proto.KifpoolStruct$Kifpool;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import ai.bale.proto.Microbanki$RequestGetMoneyRequestDetails;
import ai.bale.proto.Microbanki$RequestGetMoneyRequestPaymentList;
import ai.bale.proto.Microbanki$ResponseGetMoneyRequestDetails;
import ai.bale.proto.Microbanki$ResponseGetMoneyRequestPaymentList;
import ai.bale.proto.Misc$ResponseSeq;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.SapOuterClass$RequestAddDestinationCards;
import ai.bale.proto.SapOuterClass$RequestAddNewCards;
import ai.bale.proto.SapOuterClass$RequestEnrollNewCard;
import ai.bale.proto.SapOuterClass$RequestGetCards;
import ai.bale.proto.SapOuterClass$RequestGetDestinationCards;
import ai.bale.proto.SapOuterClass$RequestRemoveCard;
import ai.bale.proto.SapOuterClass$RequestRemoveDestinationCards;
import ai.bale.proto.SapOuterClass$ResponseAddDestinationCards;
import ai.bale.proto.SapOuterClass$ResponseAddNewCards;
import ai.bale.proto.SapOuterClass$ResponseEnrollNewCard;
import ai.bale.proto.SapOuterClass$ResponseGetCards;
import ai.bale.proto.SapOuterClass$ResponseGetDestinationCards;
import ai.bale.proto.SapStruct$DestinationCard;
import ai.bale.proto.SapStruct$UserCard;
import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.UsersOuterClass$RequestChangeDefaultCardNumber;
import ai.bale.proto.UsersOuterClass$RequestRemoveDefaultCardNumber;
import android.gov.nist.javax.sip.header.ParameterNames;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC12992fX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13130fi4;
import ir.nasim.AbstractC18427oe4;
import ir.nasim.AbstractC19902r80;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20471s40;
import ir.nasim.AbstractC21707u0;
import ir.nasim.AbstractC4970Hi4;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C10356bW5;
import ir.nasim.C10410bZ6;
import ir.nasim.C11458d25;
import ir.nasim.C12262eJ5;
import ir.nasim.C12889fL5;
import ir.nasim.C13375g72;
import ir.nasim.C13461gG4;
import ir.nasim.C13466gH0;
import ir.nasim.C14052hG4;
import ir.nasim.C14057hH0;
import ir.nasim.C14688iK2;
import ir.nasim.C16247kx;
import ir.nasim.C16358l82;
import ir.nasim.C16672lg2;
import ir.nasim.C17285mi4;
import ir.nasim.C17557nA;
import ir.nasim.C17876ni4;
import ir.nasim.C18732p92;
import ir.nasim.C19406qI3;
import ir.nasim.C21231tK7;
import ir.nasim.C22423vC7;
import ir.nasim.C22694vg2;
import ir.nasim.C22871vx5;
import ir.nasim.C23490x06;
import ir.nasim.C6517Nv5;
import ir.nasim.C7183Qq;
import ir.nasim.C7792Tf2;
import ir.nasim.C9057Yh4;
import ir.nasim.C9620aG7;
import ir.nasim.C9625aH3;
import ir.nasim.DB3;
import ir.nasim.DE7;
import ir.nasim.ED1;
import ir.nasim.EnumC15044iu7;
import ir.nasim.EnumC16694li4;
import ir.nasim.EnumC6786Oz;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14654iG4;
import ir.nasim.InterfaceC17569nB2;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.J44;
import ir.nasim.KN6;
import ir.nasim.KS2;
import ir.nasim.OG0;
import ir.nasim.P15;
import ir.nasim.Q12;
import ir.nasim.R60;
import ir.nasim.T12;
import ir.nasim.W12;
import ir.nasim.XY6;
import ir.nasim.Y50;
import ir.nasim.Z50;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.banking.entity.DuplicateTransactionException;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.payment.data.model.BankCreditCard;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class BankingModule extends AbstractC21707u0 {
    public static final a l = new a(null);
    public static final int m = 8;
    private final C9057Yh4 b;
    private s c;
    private c d;
    private final g e;
    private final C12262eJ5 f;
    private final DB3 g;
    private byte[] h;
    private boolean i;
    private boolean j;
    private final InterfaceC14654iG4 k;

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
            int[] iArr = new int[R60.values().length];
            try {
                iArr[R60.MoneyRequestDetailResponseType_MINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[R60.MoneyRequestDetailResponseType_OTHERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[R60.UNRECOGNIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankingModule(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        this.e = new g(c9057Yh4.c());
        this.f = new C12262eJ5(c9057Yh4.c());
        DB3 db3L = KN6.l("PaymentDetailsItemListEngine", P15.i);
        AbstractC13042fc3.h(db3L, "createList(...)");
        this.g = db3L;
        this.i = true;
        this.k = new C14052hG4().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 A2(BankingModule bankingModule, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(misc$ResponseSeq, "responseSeq");
        return bankingModule.b.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new C9620aG7(bankingModule.b.i0()), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 C1(BankingModule bankingModule, long j, long j2, C17557nA c17557nA) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c17557nA, "outPeer");
        GeneratedMessageLite generatedMessageLiteA = Microbanki$RequestGetMoneyRequestDetails.newBuilder().A((MessagingStruct$HistoryMessageIdentifier) MessagingStruct$HistoryMessageIdentifier.newBuilder().C(C18732p92.a.y1(c17557nA)).D(j).A(j2).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Microbanki$ResponseGetMoneyRequestDetails defaultInstance = Microbanki$ResponseGetMoneyRequestDetails.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return bankingModule.x(new C22871vx5("/bale.microbanki.v1.MicroBanki/GetMoneyRequestDetails", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.f80
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.D1((Microbanki$ResponseGetMoneyRequestDetails) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 D1(Microbanki$ResponseGetMoneyRequestDetails microbanki$ResponseGetMoneyRequestDetails) {
        AbstractC13042fc3.i(microbanki$ResponseGetMoneyRequestDetails, "responseGetMoneyRequestDetails");
        return C6517Nv5.l0(new C17876ni4(microbanki$ResponseGetMoneyRequestDetails.getTotalAmount(), microbanki$ResponseGetMoneyRequestDetails.getPayCount(), microbanki$ResponseGetMoneyRequestDetails.getLastPayDate(), EnumC16694li4.a.a(microbanki$ResponseGetMoneyRequestDetails.getResponseType())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 D2(BankingModule bankingModule, BankCreditCard bankCreditCard, Misc$ResponseVoid misc$ResponseVoid) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        return C6517Nv5.l0(Boolean.valueOf(bankingModule.G2(bankCreditCard, BankCreditCard.c.b)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(Exception exc) {
        C19406qI3.d("BankingModule", exc);
    }

    private final void E2() {
        C7183Qq.p().remove(BankCreditCard.STORAGE_PREFIX + BankCreditCard.c.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(KifpoolOuterClass$ResponseGetMyKifpools kifpoolOuterClass$ResponseGetMyKifpools) {
        AbstractC13042fc3.i(kifpoolOuterClass$ResponseGetMyKifpools, "responseGetMyKifpools");
        List<KifpoolStruct$Kifpool> myWalletsList = kifpoolOuterClass$ResponseGetMyKifpools.getMyWalletsList();
        int size = myWalletsList.size();
        long balance = 0;
        for (int i = 0; i < size; i++) {
            KifpoolStruct$Kifpool kifpoolStruct$Kifpool = myWalletsList.get(i);
            if (kifpoolStruct$Kifpool.getBalance() > balance) {
                balance = kifpoolStruct$Kifpool.getBalance();
            }
        }
    }

    private final boolean G2(BankCreditCard bankCreditCard, BankCreditCard.c cVar) {
        ArrayList arrayListZ1 = Z1(cVar);
        if (arrayListZ1 == null || arrayListZ1.isEmpty() || !arrayListZ1.contains(bankCreditCard)) {
            return false;
        }
        arrayListZ1.remove(bankCreditCard);
        C7183Qq.p().remove(BankCreditCard.STORAGE_PREFIX + cVar);
        L2(new ArrayList(arrayListZ1), cVar);
        if (cVar == BankCreditCard.c.a && bankCreditCard.isDefault() && (!arrayListZ1.isEmpty())) {
            y2();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    private final C6517Nv5 H1(final String str, final String str2, final EnumC15044iu7 enumC15044iu7, final long j) {
        BankOuterClass$RequestGetOTPToken.a aVarNewBuilder = BankOuterClass$RequestGetOTPToken.newBuilder();
        String strSubstring = str.substring(0, 6);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.A(strSubstring).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        BankOuterClass$ResponseGetOTPToken defaultInstance = BankOuterClass$ResponseGetOTPToken.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.bank.v1.Bank/GetOTPToken", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.i80
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.I1(this.a, str, str2, enumC15044iu7, j, (BankOuterClass$ResponseGetOTPToken) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 I0(BankOuterClass$ResponseGetRecentCharges bankOuterClass$ResponseGetRecentCharges) {
        AbstractC13042fc3.i(bankOuterClass$ResponseGetRecentCharges, "recentCharges");
        ArrayList arrayList = new ArrayList();
        for (BankStruct$RecentCharge bankStruct$RecentCharge : bankOuterClass$ResponseGetRecentCharges.getRecentChargesList()) {
            arrayList.add(new C7792Tf2(bankStruct$RecentCharge.getAmount(), bankStruct$RecentCharge.getPhoneNo().toString(), C18732p92.O0(bankStruct$RecentCharge.getOperator()), C18732p92.N0(bankStruct$RecentCharge.getChargeType())));
        }
        return C6517Nv5.l0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 I1(BankingModule bankingModule, String str, String str2, EnumC15044iu7 enumC15044iu7, long j, BankOuterClass$ResponseGetOTPToken bankOuterClass$ResponseGetOTPToken) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(str, "$srcPan");
        AbstractC13042fc3.i(enumC15044iu7, "$transactionType");
        AbstractC13042fc3.i(bankOuterClass$ResponseGetOTPToken, "responseGetOTPToken");
        s sVar = bankingModule.c;
        if (sVar == null) {
            AbstractC13042fc3.y("transactorActor");
            sVar = null;
        }
        return sVar.o(str, str2, enumC15044iu7.j(), j, bankOuterClass$ResponseGetOTPToken.getRequestEndPoint(), bankOuterClass$ResponseGetOTPToken.getToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(BankingModule bankingModule, SapOuterClass$ResponseGetDestinationCards sapOuterClass$ResponseGetDestinationCards) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(sapOuterClass$ResponseGetDestinationCards, "responseGetCards");
        BankCreditCard.Companion aVar = BankCreditCard.INSTANCE;
        List<SapStruct$DestinationCard> cardsList = sapOuterClass$ResponseGetDestinationCards.getCardsList();
        AbstractC13042fc3.h(cardsList, "getCardsList(...)");
        ArrayList arrayListB = aVar.b(cardsList);
        bankingModule.E2();
        bankingModule.L2(arrayListB, BankCreditCard.c.b);
    }

    private final long J1() {
        try {
            return this.b.S().r3() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        } catch (Exception unused) {
            Q12.a aVar = Q12.b;
            return Q12.A(T12.s(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, W12.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 J2(BankingModule bankingModule, BankCreditCard bankCreditCard, Misc$ResponseVoid misc$ResponseVoid) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        return C6517Nv5.l0(Boolean.valueOf(bankingModule.G2(bankCreditCard, BankCreditCard.c.a)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    private final C6517Nv5 K1(m mVar) {
        if (mVar.e() != null) {
            return v1(mVar.e());
        }
        OG0 og0 = new OG0(mVar.f(), mVar.m(), mVar.l());
        og0.n(mVar.j());
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(og0);
        AbstractC13042fc3.f(c6517Nv5L0);
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 L0(SapOuterClass$ResponseGetDestinationCards sapOuterClass$ResponseGetDestinationCards) {
        AbstractC13042fc3.i(sapOuterClass$ResponseGetDestinationCards, "responseGetCards");
        BankCreditCard.Companion aVar = BankCreditCard.INSTANCE;
        List<SapStruct$DestinationCard> cardsList = sapOuterClass$ResponseGetDestinationCards.getCardsList();
        AbstractC13042fc3.h(cardsList, "getCardsList(...)");
        return C6517Nv5.l0(aVar.b(cardsList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 N0(BankingModule bankingModule, SapOuterClass$ResponseGetCards sapOuterClass$ResponseGetCards) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(sapOuterClass$ResponseGetCards, "responseGetCards");
        BankCreditCard.Companion aVar = BankCreditCard.INSTANCE;
        List<SapStruct$UserCard> userCardsList = sapOuterClass$ResponseGetCards.getUserCardsList();
        AbstractC13042fc3.h(userCardsList, "getUserCardsList(...)");
        ArrayList arrayListD = aVar.d(userCardsList);
        bankingModule.L2(arrayListD, BankCreditCard.c.a);
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.N70
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(BankingModule.O0((BankCreditCard) obj, (BankCreditCard) obj2));
            }
        };
        AbstractC12992fX0.B(arrayListD, new Comparator() { // from class: ir.nasim.O70
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BankingModule.P0(interfaceC14603iB2, obj, obj2);
            }
        });
        return C6517Nv5.l0(arrayListD);
    }

    private final C6517Nv5 N1(C13466gH0 c13466gH0) {
        C6517Nv5 c6517Nv5D = this.f.d(c13466gH0);
        AbstractC13042fc3.h(c6517Nv5D, "getCardNumber(...)");
        return c6517Nv5D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int O0(BankCreditCard bankCreditCard, BankCreditCard bankCreditCard2) {
        AbstractC13042fc3.i(bankCreditCard, "<destruct>");
        AbstractC13042fc3.i(bankCreditCard2, "<destruct>");
        String strComponent2 = bankCreditCard.getNumber();
        boolean zComponent9 = bankCreditCard.getIsDefault();
        boolean zComponent10 = bankCreditCard.getIsShaparkMigrationNeed();
        boolean zComponent11 = bankCreditCard.getIsEnrolled();
        String strComponent22 = bankCreditCard2.getNumber();
        boolean zComponent92 = bankCreditCard2.getIsDefault();
        boolean zComponent102 = bankCreditCard2.getIsShaparkMigrationNeed();
        boolean zComponent112 = bankCreditCard2.getIsEnrolled();
        if (zComponent92) {
            return 1;
        }
        if (zComponent9) {
            return -1;
        }
        if (!zComponent11 && zComponent112) {
            return 1;
        }
        if (zComponent11 && !zComponent112) {
            return -1;
        }
        if (zComponent10 && !zComponent102) {
            return 1;
        }
        if (zComponent10 || !zComponent102) {
            return AbstractC20153rZ6.v(strComponent2, strComponent22, true);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 O2(OG0 og0) {
        AbstractC13042fc3.i(og0, "cardInfo");
        return C6517Nv5.l0(new C14057hH0(og0.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int P0(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(BankingModule bankingModule, C11458d25 c11458d25, String str, int i, int i2, C22694vg2 c22694vg2, String str2, String str3, AbstractC13130fi4 abstractC13130fi4, String str4, AbstractC4970Hi4 abstractC4970Hi4) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(str, "$fileName");
        AbstractC13042fc3.i(str2, "$descriptor");
        AbstractC13042fc3.i(abstractC13130fi4, "$moneyRequestAmount");
        AbstractC13042fc3.i(abstractC4970Hi4, "receiver");
        bankingModule.b.G().E2(c11458d25, abstractC4970Hi4, str, i, i2, c22694vg2, str2, str3, abstractC13130fi4, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 S0(List list, List list2) {
        AbstractC13042fc3.i(list, "$cards");
        return C6517Nv5.l0(list.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S2(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(Exception exc) {
        C19406qI3.d("BankingModule", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 U1(BankingModule bankingModule, long j, long j2, long j3, String str, C17557nA c17557nA) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c17557nA, "apiOutPeer");
        BankOuterClass$RequestGetSadadPSPPaymentToken.a aVarC = BankOuterClass$RequestGetSadadPSPPaymentToken.newBuilder().B((MessagingStruct$HistoryMessageIdentifier) MessagingStruct$HistoryMessageIdentifier.newBuilder().C(C18732p92.a.y1(c17557nA)).D(j).A(j2).a()).C(j3);
        if (str == null) {
            str = "";
        }
        GeneratedMessageLite generatedMessageLiteA = aVarC.A(StringValue.of(str)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        BankOuterClass$ResponseGetSadadPSPPaymentToken defaultInstance = BankOuterClass$ResponseGetSadadPSPPaymentToken.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return bankingModule.y(new C22871vx5("/bale.bank.v1.Bank/GetSadadPSPPaymentToken", generatedMessageLiteA, defaultInstance), 18000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(List list, BankingModule bankingModule, SapOuterClass$ResponseAddDestinationCards sapOuterClass$ResponseAddDestinationCards) {
        AbstractC13042fc3.i(list, "$list");
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(sapOuterClass$ResponseAddDestinationCards, "responseAddNewCards");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            BankCreditCard bankCreditCard = (BankCreditCard) list.get(i);
            list.set(i, new BankCreditCard(sapOuterClass$ResponseAddDestinationCards.getIdsList().get(i), bankCreditCard.getNumber(), null, null, null, bankCreditCard.getOwnerName(), true, BankCreditCard.c.b, false, false, false));
        }
        bankingModule.L2(list, BankCreditCard.c.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 X0(List list, SapOuterClass$ResponseAddDestinationCards sapOuterClass$ResponseAddDestinationCards) {
        AbstractC13042fc3.i(list, "$list");
        return C6517Nv5.l0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 X1(BankingModule bankingModule, C12889fL5 c12889fL5, Z50 z50, List list) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$defaultCardNumber");
        AbstractC13042fc3.i(z50, "$operationType");
        q qVar = new q();
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            Y50 y50D = AbstractC19902r80.d((String) c12889fL5.a);
            AbstractC13042fc3.h(y50D, "getCardBankName(...)");
            if (bankingModule.i2(y50D, z50)) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C13466gH0 c13466gH0 = (C13466gH0) it.next();
                    if (c13466gH0.equals(c12889fL5.a)) {
                        String strW = c13466gH0.w();
                        AbstractC13042fc3.h(strW, "getPayvandIndex(...)");
                        if (strW.length() > 0) {
                            qVar.c(new l(c13466gH0));
                        } else {
                            qVar.c(new m(c13466gH0));
                        }
                    }
                }
            }
            if (qVar.a() instanceof C13375g72) {
                int size = list2.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        i = -1;
                        break;
                    }
                    Y50 y50R = ((C13466gH0) list.get(i)).r();
                    AbstractC13042fc3.h(y50R, "getBankName(...)");
                    if (bankingModule.i2(y50R, z50)) {
                        break;
                    }
                    i++;
                }
                if (i >= 0 && i < list.size()) {
                    C13466gH0 c13466gH02 = (C13466gH0) list.get(i);
                    String strW2 = c13466gH02.w();
                    AbstractC13042fc3.h(strW2, "getPayvandIndex(...)");
                    if (strW2.length() > 0) {
                        qVar.c(new l(c13466gH02));
                    } else {
                        qVar.c(new m(c13466gH02));
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C13466gH0 c13466gH03 = (C13466gH0) it2.next();
                if (XY6.m(c13466gH03.w())) {
                    arrayList.add(new m(c13466gH03));
                } else {
                    arrayList.add(new l(c13466gH03));
                }
            }
            qVar.d(arrayList);
        }
        return C6517Nv5.l0(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y1(Exception exc) {
        C6517Nv5.l0(new q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(ArrayList arrayList, BankingModule bankingModule, SapOuterClass$ResponseAddNewCards sapOuterClass$ResponseAddNewCards) {
        AbstractC13042fc3.i(arrayList, "$list");
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(sapOuterClass$ResponseAddNewCards, "responseAddNewCards");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            AbstractC13042fc3.h(obj, "get(...)");
            BankCreditCard bankCreditCard = (BankCreditCard) obj;
            String strComponent2 = bankCreditCard.getNumber();
            Integer numComponent3 = bankCreditCard.getExpirationMonth();
            arrayList.set(i, new BankCreditCard(sapOuterClass$ResponseAddNewCards.getCardIdList().get(i), strComponent2, bankCreditCard.getExpirationYear(), numComponent3, null, null, true, BankCreditCard.c.a, bankCreditCard.getIsDefault(), false, false));
        }
        bankingModule.L2(arrayList, BankCreditCard.c.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int a2(BankCreditCard bankCreditCard, BankCreditCard bankCreditCard2) {
        AbstractC13042fc3.i(bankCreditCard, "<destruct>");
        AbstractC13042fc3.i(bankCreditCard2, "<destruct>");
        String strComponent2 = bankCreditCard.getNumber();
        boolean zComponent9 = bankCreditCard.getIsDefault();
        boolean zComponent10 = bankCreditCard.getIsShaparkMigrationNeed();
        boolean zComponent11 = bankCreditCard.getIsEnrolled();
        String strComponent22 = bankCreditCard2.getNumber();
        boolean zComponent92 = bankCreditCard2.getIsDefault();
        boolean zComponent102 = bankCreditCard2.getIsShaparkMigrationNeed();
        boolean zComponent112 = bankCreditCard2.getIsEnrolled();
        if (zComponent92) {
            return 1;
        }
        if (zComponent9) {
            return -1;
        }
        if (!zComponent11 && zComponent112) {
            return 1;
        }
        if (zComponent11 && !zComponent112) {
            return -1;
        }
        if (zComponent10 && !zComponent102) {
            return 1;
        }
        if (zComponent10 || !zComponent102) {
            return AbstractC20153rZ6.v(strComponent2, strComponent22, true);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b2(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 c1(ArrayList arrayList, SapOuterClass$ResponseAddNewCards sapOuterClass$ResponseAddNewCards) {
        AbstractC13042fc3.i(arrayList, "$list");
        return C6517Nv5.l0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 f1(BankOuterClass$ResponseBuyFastCharge bankOuterClass$ResponseBuyFastCharge) {
        return C6517Nv5.l0(new C16672lg2());
    }

    private final C6517Nv5 g2(String str, String str2, EnumC15044iu7 enumC15044iu7, long j) {
        final C13461gG4 c13461gG4 = new C13461gG4(str);
        if (this.k.c(c13461gG4)) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new DuplicateTransactionException("DUPLICATE_TRANSACTION", this.k.b(c13461gG4)));
            AbstractC13042fc3.f(c6517Nv5F);
            return c6517Nv5F;
        }
        C6517Nv5 c6517Nv5M0 = H1(str, str2, enumC15044iu7, j).m0(new InterfaceC24449ye1() { // from class: ir.nasim.e80
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.h2(this.a, c13461gG4, (ir.nasim.core.modules.banking.k) obj);
            }
        });
        AbstractC13042fc3.f(c6517Nv5M0);
        return c6517Nv5M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(BankingModule bankingModule, BankCreditCard bankCreditCard, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        ArrayList arrayListZ1 = bankingModule.Z1(BankCreditCard.c.a);
        if (arrayListZ1 == null || arrayListZ1.isEmpty()) {
            return;
        }
        Iterator it = arrayListZ1.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            BankCreditCard bankCreditCard2 = (BankCreditCard) next;
            if (bankCreditCard2.getId() != null) {
                bankCreditCard2.setDefault(AbstractC13042fc3.d(bankCreditCard2.getId(), bankCreditCard.getId()));
                bankCreditCard.setDefault(AbstractC13042fc3.d(bankCreditCard2.getId(), bankCreditCard.getId()));
            }
        }
        bankingModule.L2(arrayListZ1, BankCreditCard.c.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(BankingModule bankingModule, C13461gG4 c13461gG4, k kVar) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c13461gG4, "$otpTransaction");
        AbstractC13042fc3.i(kVar, "deliverOTPResponse");
        if (kVar.b()) {
            bankingModule.k.a(c13461gG4, bankingModule.J1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 j1(BankCreditCard bankCreditCard, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(bankCreditCard, "$card");
        return C6517Nv5.l0(bankCreditCard);
    }

    private final C6517Nv5 j2(C11458d25 c11458d25, final long j, final long j2) {
        C6517Nv5 c6517Nv5H = this.b.o(c11458d25).E(new InterfaceC24449ye1() { // from class: ir.nasim.E70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.o2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.F70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.k2(j, j2, this, (C17557nA) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.H70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.l2((Exception) obj);
            }
        }).A(new InterfaceC17569nB2() { // from class: ir.nasim.I70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.m2(this.a, (Microbanki$ResponseGetMoneyRequestPaymentList) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.J70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.n2(this.a, (Microbanki$ResponseGetMoneyRequestPaymentList) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 k2(long j, long j2, BankingModule bankingModule, C17557nA c17557nA) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c17557nA, "apiOutPeer");
        Microbanki$RequestGetMoneyRequestPaymentList.a aVarB = Microbanki$RequestGetMoneyRequestPaymentList.newBuilder().B((MessagingStruct$HistoryMessageIdentifier) MessagingStruct$HistoryMessageIdentifier.newBuilder().C(C18732p92.a.y1(c17557nA)).D(j).A(j2).a());
        byte[] bArr = bankingModule.h;
        BytesValue bytesValueOf = bArr != null ? BytesValue.of(AbstractC2383g.F(bArr)) : null;
        if (bytesValueOf != null) {
            aVarB.A(bytesValueOf);
        }
        GeneratedMessageLite generatedMessageLiteA = aVarB.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Microbanki$ResponseGetMoneyRequestPaymentList defaultInstance = Microbanki$ResponseGetMoneyRequestPaymentList.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return bankingModule.x(new C22871vx5("/bale.microbanki.v1.MicroBanki/GetMoneyRequestPaymentList", generatedMessageLiteA, defaultInstance));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(Exception exc) {
        C19406qI3.d("BankingModule", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 m2(BankingModule bankingModule, Microbanki$ResponseGetMoneyRequestPaymentList microbanki$ResponseGetMoneyRequestPaymentList) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(microbanki$ResponseGetMoneyRequestPaymentList, "response");
        ArrayList arrayList = new ArrayList();
        for (PeersStruct$UserOutPeer peersStruct$UserOutPeer : microbanki$ResponseGetMoneyRequestPaymentList.getUserPeersList()) {
            C18732p92 c18732p92 = C18732p92.a;
            AbstractC13042fc3.f(peersStruct$UserOutPeer);
            arrayList.add(c18732p92.w1(peersStruct$UserOutPeer));
        }
        ArrayList arrayList2 = new ArrayList();
        for (PeersStruct$GroupOutPeer peersStruct$GroupOutPeer : microbanki$ResponseGetMoneyRequestPaymentList.getGroupPeersList()) {
            C18732p92 c18732p922 = C18732p92.a;
            AbstractC13042fc3.f(peersStruct$GroupOutPeer);
            arrayList2.add(c18732p922.q1(peersStruct$GroupOutPeer));
        }
        return bankingModule.b.V().s0(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 n2(BankingModule bankingModule, Microbanki$ResponseGetMoneyRequestPaymentList microbanki$ResponseGetMoneyRequestPaymentList) {
        EnumC6786Oz enumC6786Oz;
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(microbanki$ResponseGetMoneyRequestPaymentList, "response");
        ArrayList arrayList = new ArrayList();
        R60 responseType = microbanki$ResponseGetMoneyRequestPaymentList.getResponseType();
        int i = responseType == null ? -1 : b.a[responseType.ordinal()];
        if (i == -1) {
            enumC6786Oz = EnumC6786Oz.UNSUPPORTED_VALUE;
        } else if (i == 1) {
            enumC6786Oz = EnumC6786Oz.MINE;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            enumC6786Oz = EnumC6786Oz.UNSUPPORTED_VALUE;
        } else {
            enumC6786Oz = EnumC6786Oz.OTHERS;
        }
        for (BankStruct$MoneyRequestPayment bankStruct$MoneyRequestPayment : microbanki$ResponseGetMoneyRequestPaymentList.getPaymentList()) {
            arrayList.add(new P15(Long.valueOf(bankStruct$MoneyRequestPayment.getId()), Long.valueOf(bankStruct$MoneyRequestPayment.getReceiptRandomId()), Long.valueOf(bankStruct$MoneyRequestPayment.getReceiptDate()), Long.valueOf(bankStruct$MoneyRequestPayment.getTraceNumber()), Long.valueOf(bankStruct$MoneyRequestPayment.getAmount()), Long.valueOf(bankStruct$MoneyRequestPayment.getDate()), Integer.valueOf(bankStruct$MoneyRequestPayment.getPayerUserId()), enumC6786Oz));
        }
        bankingModule.i = false;
        bankingModule.j = true;
        bankingModule.h = microbanki$ResponseGetMoneyRequestPaymentList.getLoadMoreState().toByteArray();
        bankingModule.g.c(arrayList);
        return C6517Nv5.l0(new C17285mi4(EnumC16694li4.a.a(microbanki$ResponseGetMoneyRequestPaymentList.getResponseType()), microbanki$ResponseGetMoneyRequestPaymentList.getPaymentList().size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(Exception exc) {
        C19406qI3.d("BankingModule", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 p1(BankingModule bankingModule, long j, C16247kx c16247kx, C17557nA c17557nA) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c16247kx, "$apiCrowdFundingMessage");
        return bankingModule.q(new C10356bW5(c17557nA, j, c16247kx));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 q1(BankingModule bankingModule, C11458d25 c11458d25, long j, C16247kx c16247kx, long j2, C23490x06 c23490x06) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(c16247kx, "$apiCrowdFundingMessage");
        AbstractC13042fc3.i(c23490x06, "responseSeqDate");
        return bankingModule.b.V().S(c23490x06.w(), c23490x06.y(), new DE7(c11458d25, j, c16247kx, Long.valueOf(j2), bankingModule.b.w().p()), bankingModule.b.E().V1(c11458d25.getPeerId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 q2(BankingModule bankingModule, C17285mi4 c17285mi4) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(c17285mi4, "moneyRequestDetailsListResponse");
        bankingModule.i = false;
        if (bankingModule.j && c17285mi4.a() < 20) {
            bankingModule.j = false;
        }
        return C6517Nv5.l0(c17285mi4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(BankingModule bankingModule, Exception exc) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(exc, "e");
        bankingModule.i = false;
        C19406qI3.a("BankingModule", exc.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 t2(l lVar, final BankingModule bankingModule, final EnumC15044iu7 enumC15044iu7, final long j, final OG0 og0) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(enumC15044iu7, "$transactionType");
        AbstractC13042fc3.i(og0, "cardInfo");
        C13466gH0 c13466gH0E = lVar != null ? lVar.e() : null;
        String strF = lVar != null ? lVar.f() : null;
        if (XY6.m(strF)) {
            if (c13466gH0E != null) {
                return bankingModule.N1(c13466gH0E).H(new InterfaceC17569nB2() { // from class: ir.nasim.Q70
                    @Override // ir.nasim.InterfaceC17569nB2
                    public final Object apply(Object obj) {
                        return BankingModule.u2(this.a, og0, enumC15044iu7, j, (String) obj);
                    }
                });
            }
            strF = "";
        }
        String str = strF;
        String strD = og0.d();
        AbstractC13042fc3.h(strD, "getPan(...)");
        return bankingModule.g2(strD, str, enumC15044iu7, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 u2(BankingModule bankingModule, OG0 og0, EnumC15044iu7 enumC15044iu7, long j, String str) {
        AbstractC13042fc3.i(bankingModule, "this$0");
        AbstractC13042fc3.i(og0, "$cardInfo");
        AbstractC13042fc3.i(enumC15044iu7, "$transactionType");
        AbstractC13042fc3.i(str, "recentCardNumber");
        String strD = og0.d();
        AbstractC13042fc3.h(strD, "getPan(...)");
        return bankingModule.g2(strD, str, enumC15044iu7, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    private final C6517Nv5 y1() {
        C6517Nv5 c6517Nv5G = this.e.g();
        AbstractC13042fc3.h(c6517Nv5G, "getCardsMask(...)");
        return c6517Nv5G;
    }

    private final void y2() {
        UsersOuterClass$RequestRemoveDefaultCardNumber defaultInstance = UsersOuterClass$RequestRemoveDefaultCardNumber.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        Misc$ResponseSeq defaultInstance2 = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        y(new C22871vx5("/bale.users.v1.Users/RemoveDefaultCardNumber", defaultInstance, defaultInstance2), 18000L).E(new InterfaceC24449ye1() { // from class: ir.nasim.b80
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.z2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.d80
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.A2(this.a, (Misc$ResponseSeq) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(Exception exc) {
        C19406qI3.d("BankingModule", exc);
    }

    public final C6517Nv5 B1(C11458d25 c11458d25, final long j, final long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C6517Nv5 c6517Nv5E = this.b.o(c11458d25).H(new InterfaceC17569nB2() { // from class: ir.nasim.W70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.C1(this.a, j, j2, (C17557nA) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.X70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.E1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 B2(final BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        if (bankCreditCard.getId() == null) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("cardId is null"));
            AbstractC13042fc3.f(c6517Nv5F);
            return c6517Nv5F;
        }
        GeneratedMessageLite generatedMessageLiteA = SapOuterClass$RequestRemoveDestinationCards.newBuilder().A(AbstractC9766aX0.e(bankCreditCard.getId())).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.sap.v1.Sap/RemoveDestinationCards", generatedMessageLiteA, defaultInstance)).E(new InterfaceC24449ye1() { // from class: ir.nasim.B70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.C2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.C70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.D2(this.a, bankCreditCard, (Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.f(c6517Nv5H);
        return c6517Nv5H;
    }

    public final C6517Nv5 F1(C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.h = null;
        this.g.l(false);
        return j2(c11458d25, j, j2);
    }

    public final C6517Nv5 F2(AbstractC20471s40 abstractC20471s40) {
        AbstractC13042fc3.i(abstractC20471s40, "bankCard");
        if (abstractC20471s40 instanceof l) {
            l lVar = (l) abstractC20471s40;
            if (lVar.e() != null) {
                C6517Nv5 c6517Nv5H = this.f.h(lVar.e());
                AbstractC13042fc3.h(c6517Nv5H, "removeCard(...)");
                return c6517Nv5H;
            }
        }
        C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("MASK IS NULL"));
        AbstractC13042fc3.h(c6517Nv5F, "failure(...)");
        return c6517Nv5F;
    }

    public final C6517Nv5 G1() {
        KifpoolOuterClass$RequestGetMyKifpools defaultInstance = KifpoolOuterClass$RequestGetMyKifpools.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        KifpoolOuterClass$ResponseGetMyKifpools defaultInstance2 = KifpoolOuterClass$ResponseGetMyKifpools.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = y(new C22871vx5("/bale.kifpool.v1.Kifpool/GetMyKifpools", defaultInstance, defaultInstance2), 5001L).m0(new InterfaceC24449ye1() { // from class: ir.nasim.j80
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.G0((KifpoolOuterClass$ResponseGetMyKifpools) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.k80
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.H0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 H2(final BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        if (bankCreditCard.getId() == null) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("cardId is null"));
            AbstractC13042fc3.f(c6517Nv5F);
            return c6517Nv5F;
        }
        GeneratedMessageLite generatedMessageLiteA = SapOuterClass$RequestRemoveCard.newBuilder().A(bankCreditCard.getId()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.sap.v1.Sap/RemoveCard", generatedMessageLiteA, defaultInstance)).E(new InterfaceC24449ye1() { // from class: ir.nasim.p80
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.I2((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.l70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.J2(this.a, bankCreditCard, (Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.f(c6517Nv5H);
        return c6517Nv5H;
    }

    public final BankingModule K2() {
        this.c = new s(this.b);
        this.d = new c(this.b);
        return this;
    }

    public final DB3 L1() {
        return this.g;
    }

    public final void L2(List list, BankCreditCard.c cVar) {
        String strT;
        AbstractC13042fc3.i(list, "list");
        AbstractC13042fc3.i(cVar, "type");
        ArrayList arrayListZ1 = Z1(cVar);
        if (arrayListZ1 == null) {
            strT = new KS2().t(list);
        } else {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (arrayListZ1.contains(list.get(i))) {
                    String cvv2 = ((BankCreditCard) arrayListZ1.get(arrayListZ1.indexOf(list.get(i)))).getCvv2();
                    String cvv22 = ((BankCreditCard) list.get(i)).getCvv2();
                    if (cvv2 != null && cvv22 == null) {
                        ((BankCreditCard) list.get(i)).setCvv2(cvv2);
                    }
                }
            }
            strT = new KS2().t(list);
        }
        C16358l82 c16358l82 = C16358l82.a;
        AbstractC13042fc3.f(strT);
        String strF = C16358l82.f(c16358l82, strT, null, 2, null);
        C7183Qq.p().putString(BankCreditCard.STORAGE_PREFIX + cVar, strF);
    }

    public final C6517Nv5 M1() {
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5R = cVar.r();
        AbstractC13042fc3.h(c6517Nv5R, "getRecentCard2CardDestinationCards(...)");
        return c6517Nv5R;
    }

    public final void M2(C11458d25 c11458d25, C9625aH3 c9625aH3, String str, String str2, long j, long j2, long j3, String str3) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c9625aH3, "localPhoto");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(str3, "cardNumber");
        this.b.G().s2(c11458d25, c9625aH3, str, str2, j, j2, j3, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N2(final ir.nasim.C11458d25 r15, final java.lang.String r16, final int r17, final int r18, final ir.nasim.C22694vg2 r19, final java.lang.String r20, final java.lang.String r21, final ir.nasim.AbstractC13130fi4 r22, ir.nasim.AbstractC20471s40 r23, final java.lang.String r24) {
        /*
            r14 = this;
            r0 = r23
            java.lang.String r1 = "peer"
            r4 = r15
            ir.nasim.AbstractC13042fc3.i(r15, r1)
            java.lang.String r1 = "fileName"
            r5 = r16
            ir.nasim.AbstractC13042fc3.i(r5, r1)
            java.lang.String r1 = "descriptor"
            r9 = r20
            ir.nasim.AbstractC13042fc3.i(r9, r1)
            java.lang.String r1 = "moneyRequestAmount"
            r11 = r22
            ir.nasim.AbstractC13042fc3.i(r11, r1)
            java.lang.String r1 = "moneyRequestReceiverBankCard"
            ir.nasim.AbstractC13042fc3.i(r0, r1)
            boolean r1 = r0 instanceof ir.nasim.core.modules.banking.l
            if (r1 == 0) goto L42
            r2 = r0
            ir.nasim.core.modules.banking.l r2 = (ir.nasim.core.modules.banking.l) r2
            ir.nasim.gH0 r3 = r2.e()
            if (r3 == 0) goto L42
            ir.nasim.gH0 r0 = r2.e()
            r13 = r14
            ir.nasim.Nv5 r0 = r14.v1(r0)
            ir.nasim.v70 r1 = new ir.nasim.v70
            r1.<init>()
            ir.nasim.Nv5 r0 = r0.H(r1)
            goto L6a
        L42:
            r13 = r14
            if (r1 == 0) goto L5f
            ir.nasim.core.modules.banking.l r0 = (ir.nasim.core.modules.banking.l) r0
            java.lang.String r1 = r0.f()
            boolean r1 = ir.nasim.XY6.m(r1)
            if (r1 != 0) goto L5f
            ir.nasim.hH0 r1 = new ir.nasim.hH0
            java.lang.String r0 = r0.f()
            r1.<init>(r0)
            ir.nasim.Nv5 r0 = ir.nasim.C6517Nv5.l0(r1)
            goto L6a
        L5f:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "MoneyRequestReceiverBankCard Not Valid"
            r0.<init>(r1)
            ir.nasim.Nv5 r0 = ir.nasim.C6517Nv5.F(r0)
        L6a:
            ir.nasim.G70 r1 = new ir.nasim.G70
            r2 = r1
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r24
            r2.<init>()
            r0.m0(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.core.modules.banking.BankingModule.N2(ir.nasim.d25, java.lang.String, int, int, ir.nasim.vg2, java.lang.String, java.lang.String, ir.nasim.fi4, ir.nasim.s40, java.lang.String):void");
    }

    public final C12262eJ5 O1() {
        return this.f;
    }

    public final C6517Nv5 P1() {
        BankOuterClass$RequestGetRecentCharges defaultInstance = BankOuterClass$RequestGetRecentCharges.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        BankOuterClass$ResponseGetRecentCharges defaultInstance2 = BankOuterClass$ResponseGetRecentCharges.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.bank.v1.Bank/GetRecentCharges", defaultInstance, defaultInstance2)).H(new InterfaceC17569nB2() { // from class: ir.nasim.D70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.I0((BankOuterClass$ResponseGetRecentCharges) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 Q0(l lVar) {
        AbstractC13042fc3.i(lVar, "digitOnlyBankCard");
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5K = cVar.k(lVar);
        AbstractC13042fc3.h(c6517Nv5K, "addNewBankCard(...)");
        return c6517Nv5K;
    }

    public final C6517Nv5 Q1() {
        SapOuterClass$RequestGetDestinationCards defaultInstance = SapOuterClass$RequestGetDestinationCards.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        SapOuterClass$ResponseGetDestinationCards defaultInstance2 = SapOuterClass$ResponseGetDestinationCards.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.sap.v1.Sap/GetDestinationCards", defaultInstance, defaultInstance2)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.m70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.J0(this.a, (SapOuterClass$ResponseGetDestinationCards) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.n70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.K0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.o70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.L0((SapOuterClass$ResponseGetDestinationCards) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final void Q2(int i) {
        C7183Qq.p().putInt("STORAGE_MY_BANK_VERSION_KEY", i);
    }

    public final C6517Nv5 R0(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "newCard");
        final List listS = AbstractC10360bX0.s(bankCreditCard);
        C6517Nv5 c6517Nv5E = U0(listS).H(new InterfaceC17569nB2() { // from class: ir.nasim.m80
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.S0(listS, (List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.n80
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.T0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 R1() {
        SapOuterClass$RequestGetCards defaultInstance = SapOuterClass$RequestGetCards.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        SapOuterClass$ResponseGetCards defaultInstance2 = SapOuterClass$ResponseGetCards.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.sap.v1.Sap/GetCards", defaultInstance, defaultInstance2)).E(new InterfaceC24449ye1() { // from class: ir.nasim.x70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.M0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.y70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.N0(this.a, (SapOuterClass$ResponseGetCards) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 R2(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, HistoryMessageData historyMessageData, Long l2, String str8, String str9) {
        if (str == null) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("Source card is null"));
            AbstractC13042fc3.f(c6517Nv5F);
            return c6517Nv5F;
        }
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5E = cVar.y(str, str2, i, str3, str4, str5, str6, str7, historyMessageData, l2, str8, str9).E(new InterfaceC24449ye1() { // from class: ir.nasim.o80
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.S2((Exception) obj);
            }
        });
        AbstractC13042fc3.f(c6517Nv5E);
        return c6517Nv5E;
    }

    public final C6517Nv5 S1(final long j, C11458d25 c11458d25, final long j2, final long j3, final String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C6517Nv5 c6517Nv5H = this.b.o(c11458d25).E(new InterfaceC24449ye1() { // from class: ir.nasim.g80
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.T1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.h80
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.U1(this.a, j2, j3, j, str, (C17557nA) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 U0(final List list) {
        AbstractC13042fc3.i(list, "list");
        GeneratedMessageLite generatedMessageLiteA = SapOuterClass$RequestAddDestinationCards.newBuilder().A(BankCreditCard.INSTANCE.a(list)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        SapOuterClass$ResponseAddDestinationCards defaultInstance = SapOuterClass$ResponseAddDestinationCards.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.sap.v1.Sap/AddDestinationCards", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Y70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.V0(list, this, (SapOuterClass$ResponseAddDestinationCards) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Z70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.W0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.a80
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.X0(list, (SapOuterClass$ResponseAddDestinationCards) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 V1() {
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5S = cVar.s();
        AbstractC13042fc3.h(c6517Nv5S, "getSourceSavedCards(...)");
        return c6517Nv5S;
    }

    public final C6517Nv5 W1(final Z50 z50) {
        AbstractC13042fc3.i(z50, "operationType");
        final C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = "";
        AbstractC18427oe4 abstractC18427oe4H = this.b.H();
        C21231tK7 c21231tK7I0 = abstractC18427oe4H != null ? abstractC18427oe4H.i0(this.b.i0()) : null;
        if (c21231tK7I0 != null) {
            C10410bZ6 c10410bZ6L = c21231tK7I0.l();
            String str = c10410bZ6L != null ? (String) c10410bZ6L.b() : "";
            if (str != null && str.length() != 0) {
                c12889fL5.a = XY6.q(str);
            }
        }
        C6517Nv5 c6517Nv5E = y1().H(new InterfaceC17569nB2() { // from class: ir.nasim.p70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.X1(this.a, c12889fL5, z50, (List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.q70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.Y1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 Y0(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "newCard");
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5L = cVar.l(bankCreditCard);
        AbstractC13042fc3.h(c6517Nv5L, "addNewBankCard(...)");
        return c6517Nv5L;
    }

    public final C6517Nv5 Z0(final ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "list");
        GeneratedMessageLite generatedMessageLiteA = SapOuterClass$RequestAddNewCards.newBuilder().A(BankCreditCard.INSTANCE.c(arrayList)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        SapOuterClass$ResponseAddNewCards defaultInstance = SapOuterClass$ResponseAddNewCards.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.sap.v1.Sap/AddNewCards", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.T70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.a1(arrayList, this, (SapOuterClass$ResponseAddNewCards) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.U70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.b1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.V70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.c1(arrayList, (SapOuterClass$ResponseAddNewCards) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final ArrayList Z1(BankCreditCard.c cVar) {
        AbstractC13042fc3.i(cVar, "type");
        String strE = C7183Qq.p().e(BankCreditCard.STORAGE_PREFIX + cVar);
        ArrayList arrayList = null;
        if (strE != null) {
            arrayList = (ArrayList) new KS2().l(C16358l82.c(C16358l82.a, strE, null, 2, null), new TypeToken<ArrayList<BankCreditCard>>() { // from class: ir.nasim.core.modules.banking.BankingModule$getSavedCreditCards$cards$1
            }.d());
            if (arrayList == null) {
                return new ArrayList();
            }
            final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.z70
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Integer.valueOf(BankingModule.a2((BankCreditCard) obj, (BankCreditCard) obj2));
                }
            };
            AbstractC12992fX0.B(arrayList, new Comparator() { // from class: ir.nasim.A70
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return BankingModule.b2(interfaceC14603iB2, obj, obj2);
                }
            });
        }
        return arrayList;
    }

    public final int c2() {
        return this.b.S().l3();
    }

    public final C6517Nv5 d1(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "endPoint");
        AbstractC13042fc3.i(str2, "originalToken");
        AbstractC13042fc3.i(str3, "responseToken");
        s sVar = this.c;
        if (sVar == null) {
            AbstractC13042fc3.y("transactorActor");
            sVar = null;
        }
        C6517Nv5 c6517Nv5K = sVar.k(str, str2, str3);
        AbstractC13042fc3.h(c6517Nv5K, "advicePaymentToken(...)");
        return c6517Nv5K;
    }

    public final C6517Nv5 d2(C11458d25 c11458d25, J44 j44) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5P = cVar.p(c11458d25, j44);
        AbstractC13042fc3.h(c6517Nv5P, "getCrowdFundingTotalPaidAmount(...)");
        return c6517Nv5P;
    }

    public final C6517Nv5 e1(C7792Tf2 c7792Tf2) {
        AbstractC13042fc3.i(c7792Tf2, "fastCharge");
        BankOuterClass$RequestBuyFastCharge.a aVarA = BankOuterClass$RequestBuyFastCharge.newBuilder().A(c7792Tf2.a());
        String strD = c7792Tf2.d();
        if (strD == null) {
            strD = "";
        }
        GeneratedMessageLite generatedMessageLiteA = aVarA.D(StringValue.of(strD)).C(C18732p92.G(c7792Tf2.c())).B(C18732p92.F(c7792Tf2.b())).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        BankOuterClass$ResponseBuyFastCharge defaultInstance = BankOuterClass$ResponseBuyFastCharge.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.bank.v1.Bank/BuyFastCharge", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.S70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.f1((BankOuterClass$ResponseBuyFastCharge) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 e2(int i) {
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5T = cVar.t(i);
        AbstractC13042fc3.h(c6517Nv5T, "getUserDefualtCard(...)");
        return c6517Nv5T;
    }

    public final C6517Nv5 f2(int i, String str) {
        AbstractC13042fc3.i(str, "serviceKey");
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5U = cVar.u(new C14688iK2(i, str));
        AbstractC13042fc3.h(c6517Nv5U, "grantBotBankiAccess(...)");
        return c6517Nv5U;
    }

    public final C6517Nv5 g1(final BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestChangeDefaultCardNumber.newBuilder().B(StringValue.of(bankCreditCard.getNumber())).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = x(new C22871vx5("/bale.users.v1.Users/ChangeDefaultCardNumber", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.t70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.h1(this.a, bankCreditCard, (Misc$ResponseSeq) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.u70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.i1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.w70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.j1(bankCreditCard, (Misc$ResponseSeq) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final boolean i2(Y50 y50, Z50 z50) {
        AbstractC13042fc3.i(y50, "bankName");
        AbstractC13042fc3.i(z50, "bankOperationType");
        return this.b.S().t5(y50, z50);
    }

    public final C6517Nv5 k1(String str, String str2, int i, String str3) {
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5E = cVar.m(str, str2, i, str3).E(new InterfaceC24449ye1() { // from class: ir.nasim.R70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.l1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 m1(d dVar) {
        AbstractC13042fc3.i(dVar, "bankOperation");
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5N = cVar.n(dVar);
        AbstractC13042fc3.h(c6517Nv5N, "doBankOperation(...)");
        return c6517Nv5N;
    }

    public final C6517Nv5 n1(BankCreditCard bankCreditCard, int i, int i2, String str) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        AbstractC13042fc3.i(str, "cvv2");
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5Z = cVar.z(new C22423vC7(bankCreditCard, i, i2, str));
        AbstractC13042fc3.h(c6517Nv5Z, "updateCreditCard(...)");
        return c6517Nv5Z;
    }

    public final C6517Nv5 o1(final C11458d25 c11458d25, final long j, final long j2, final C16247kx c16247kx) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c16247kx, "apiCrowdFundingMessage");
        C6517Nv5 c6517Nv5H = this.b.o(c11458d25).H(new InterfaceC17569nB2() { // from class: ir.nasim.c80
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.p1(this.a, j, c16247kx, (C17557nA) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.l80
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.q1(this.a, c11458d25, j, c16247kx, j2, (C23490x06) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 p2(C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        byte[] bArr = this.h;
        if (!this.i && this.j && bArr != null) {
            if (!(bArr.length == 0)) {
                this.i = true;
                C6517Nv5 c6517Nv5E = j2(c11458d25, j, j2).H(new InterfaceC17569nB2() { // from class: ir.nasim.r70
                    @Override // ir.nasim.InterfaceC17569nB2
                    public final Object apply(Object obj) {
                        return BankingModule.q2(this.a, (C17285mi4) obj);
                    }
                }).E(new InterfaceC24449ye1() { // from class: ir.nasim.s70
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        BankingModule.r2(this.a, (Exception) obj);
                    }
                });
                AbstractC13042fc3.f(c6517Nv5E);
                return c6517Nv5E;
            }
        }
        C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("Incorrect call for load more"));
        AbstractC13042fc3.f(c6517Nv5F);
        return c6517Nv5F;
    }

    public final C6517Nv5 r1() {
        SapOuterClass$RequestEnrollNewCard defaultInstance = SapOuterClass$RequestEnrollNewCard.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        SapOuterClass$ResponseEnrollNewCard defaultInstance2 = SapOuterClass$ResponseEnrollNewCard.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = x(new C22871vx5("/bale.sap.v1.Sap/EnrollNewCard", defaultInstance, defaultInstance2)).E(new InterfaceC24449ye1() { // from class: ir.nasim.L70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.s1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 s2(m mVar, final l lVar, final EnumC15044iu7 enumC15044iu7, final long j) {
        AbstractC13042fc3.i(mVar, "srcFullBankCard");
        AbstractC13042fc3.i(enumC15044iu7, "transactionType");
        C6517Nv5 c6517Nv5H = K1(mVar).H(new InterfaceC17569nB2() { // from class: ir.nasim.M70
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return BankingModule.t2(lVar, this, enumC15044iu7, j, (OG0) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final List t1(Z50 z50) {
        AbstractC13042fc3.i(z50, "bankOperationType");
        ArrayList arrayList = new ArrayList();
        int iB = Y50.b.b();
        for (int i = 1; i < iB; i++) {
            Y50 y50A = Y50.b.a(i);
            if (i2(y50A, z50)) {
                arrayList.add(y50A);
            }
        }
        return arrayList;
    }

    public final int u1() {
        return C7183Qq.p().getInt("STORAGE_MY_BANK_VERSION_KEY", 0);
    }

    public final C6517Nv5 v1(C13466gH0 c13466gH0) {
        C6517Nv5 c6517Nv5E = this.e.e(c13466gH0);
        AbstractC13042fc3.h(c6517Nv5E, "getCard(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 v2() {
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5E = cVar.w().E(new InterfaceC24449ye1() { // from class: ir.nasim.P70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.w2((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 w1(String str, String str2) {
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5E = cVar.o(str, str2).E(new InterfaceC24449ye1() { // from class: ir.nasim.K70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.x1((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    public final C6517Nv5 x2(AbstractC20471s40 abstractC20471s40) {
        AbstractC13042fc3.i(abstractC20471s40, "bankCard");
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5X = cVar.x(abstractC20471s40);
        AbstractC13042fc3.h(c6517Nv5X, "removeBankCard(...)");
        return c6517Nv5X;
    }

    public final C6517Nv5 z1(String str, String str2, int i, HistoryMessageData historyMessageData, Integer num) {
        if (str == null) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("Card id not available"));
            AbstractC13042fc3.f(c6517Nv5F);
            return c6517Nv5F;
        }
        c cVar = this.d;
        if (cVar == null) {
            AbstractC13042fc3.y("bankActor");
            cVar = null;
        }
        C6517Nv5 c6517Nv5E = cVar.q(str, str2, i, historyMessageData, num).E(new InterfaceC24449ye1() { // from class: ir.nasim.k70
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                BankingModule.A1((Exception) obj);
            }
        });
        AbstractC13042fc3.f(c6517Nv5E);
        return c6517Nv5E;
    }
}
