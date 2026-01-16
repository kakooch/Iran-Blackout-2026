package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.Feedback$RequestSendFeedBack;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PfmOuterClass$RequestAddDetailToTransaction;
import ai.bale.proto.PfmOuterClass$RequestAddTransactionTags;
import ai.bale.proto.PfmOuterClass$RequestAddUserTags;
import ai.bale.proto.PfmOuterClass$RequestGetUserAccounts;
import ai.bale.proto.PfmOuterClass$RequestGetUserTags;
import ai.bale.proto.PfmOuterClass$RequestLoadTransactions;
import ai.bale.proto.PfmOuterClass$RequestRemoveTransaction;
import ai.bale.proto.PfmOuterClass$RequestRemoveUserTags;
import ai.bale.proto.PfmOuterClass$ResponseGetUserAccounts;
import ai.bale.proto.PfmOuterClass$ResponseGetUserTags;
import ai.bale.proto.PfmOuterClass$ResponseLoadTransactions;
import ai.bale.proto.PfmStruct$PfmTransactionTag;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.features.pfm.entity.PFMTransactionId;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.eP4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12315eP4 extends AbstractC6360Ng4 {

    /* renamed from: ir.nasim.eP4$a */
    public static final class a implements InterfaceC15283jK {
    }

    /* renamed from: ir.nasim.eP4$b */
    public static final class b implements InterfaceC15283jK {
        private final long a;
        private final Long b;
        private final Long c;
        private final EnumC18897pR4 d;
        private final List e;
        private final int f;
        private final OC g;
        private final RB3 h;

        public b(long j, Long l, Long l2, EnumC18897pR4 enumC18897pR4, List list, int i, OC oc, RB3 rb3) {
            AbstractC13042fc3.i(list, "label");
            this.a = j;
            this.b = l;
            this.c = l2;
            this.d = enumC18897pR4;
            this.e = list;
            this.f = i;
            this.g = oc;
            this.h = rb3;
        }

        public final long a() {
            return this.a;
        }

        public final Long b() {
            return this.c;
        }

        public final List c() {
            return this.e;
        }

        public final int d() {
            return this.f;
        }

        public final RB3 e() {
            return this.h;
        }

        public final Long f() {
            return this.b;
        }

        public final EnumC18897pR4 g() {
            return this.d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12315eP4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A0(Misc$ResponseVoid misc$ResponseVoid) {
        return C19938rB7.a;
    }

    private final C6517Nv5 k0(PFMTransactionId pFMTransactionId, String str) {
        PfmOuterClass$RequestAddDetailToTransaction pfmOuterClass$RequestAddDetailToTransaction = (PfmOuterClass$RequestAddDetailToTransaction) PfmOuterClass$RequestAddDetailToTransaction.newBuilder().B(EP4.a.b(pFMTransactionId)).A(str).a();
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.f(pfmOuterClass$RequestAddDetailToTransaction);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.pfm.v1.Pfm/AddDetailToTransaction", pfmOuterClass$RequestAddDetailToTransaction, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.XO4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C12315eP4.l0((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l0(Misc$ResponseVoid misc$ResponseVoid) {
        return C19938rB7.a;
    }

    private final C6517Nv5 m0(List list) {
        try {
            PfmOuterClass$RequestAddUserTags.a aVarNewBuilder = PfmOuterClass$RequestAddUserTags.newBuilder();
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(RQ4.c((PFMTag) it.next()));
            }
            PfmOuterClass$RequestAddUserTags pfmOuterClass$RequestAddUserTags = (PfmOuterClass$RequestAddUserTags) aVarNewBuilder.A(arrayList).a();
            Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
            AbstractC13042fc3.f(pfmOuterClass$RequestAddUserTags);
            AbstractC13042fc3.f(defaultInstance);
            C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.pfm.v1.Pfm/AddUserTags", pfmOuterClass$RequestAddUserTags, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.YO4
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C12315eP4.n0((Misc$ResponseVoid) obj);
                }
            });
            AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
            return c6517Nv5H0;
        } catch (Exception e) {
            return C6517Nv5.F(new Exception(e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n0(Misc$ResponseVoid misc$ResponseVoid) {
        return C19938rB7.a;
    }

    private final CollectionsStruct$Int64Value o0(long j) {
        GeneratedMessageLite generatedMessageLiteA = CollectionsStruct$Int64Value.newBuilder().A(j).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (CollectionsStruct$Int64Value) generatedMessageLiteA;
    }

    private final C6517Nv5 p0() {
        PfmOuterClass$RequestGetUserAccounts defaultInstance = PfmOuterClass$RequestGetUserAccounts.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        PfmOuterClass$ResponseGetUserAccounts defaultInstance2 = PfmOuterClass$ResponseGetUserAccounts.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5M = M(new C22871vx5("/bale.pfm.v1.Pfm/GetUserAccounts", defaultInstance, defaultInstance2), 16500L);
        AbstractC13042fc3.h(c6517Nv5M, "api(...)");
        return c6517Nv5M;
    }

    private final C6517Nv5 q0() {
        PfmOuterClass$RequestGetUserTags pfmOuterClass$RequestGetUserTags = (PfmOuterClass$RequestGetUserTags) PfmOuterClass$RequestGetUserTags.newBuilder().A(F75.PfmUserTagsType_WITHCHILD).a();
        PfmOuterClass$ResponseGetUserTags defaultInstance = PfmOuterClass$ResponseGetUserTags.getDefaultInstance();
        AbstractC13042fc3.f(pfmOuterClass$RequestGetUserTags);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.pfm.v1.Pfm/GetUserTags", pfmOuterClass$RequestGetUserTags, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.dP4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C12315eP4.r0((PfmOuterClass$ResponseGetUserTags) obj);
            }
        });
        AbstractC13042fc3.f(c6517Nv5H0);
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List r0(PfmOuterClass$ResponseGetUserTags pfmOuterClass$ResponseGetUserTags) {
        List<PfmStruct$PfmTransactionTag> tagsList = pfmOuterClass$ResponseGetUserTags.getTagsList();
        AbstractC13042fc3.h(tagsList, "getTagsList(...)");
        List<PfmStruct$PfmTransactionTag> list = tagsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag : list) {
            AbstractC13042fc3.f(pfmStruct$PfmTransactionTag);
            arrayList.add(RQ4.b(pfmStruct$PfmTransactionTag));
        }
        return arrayList;
    }

    private final C6517Nv5 s0(b bVar) {
        EnumC18897pR4 enumC18897pR4G = bVar.g();
        int iJ = enumC18897pR4G != null ? enumC18897pR4G.j() : 0;
        RB3 rb3E = bVar.e();
        int iOrdinal = rb3E != null ? rb3E.ordinal() : 0;
        if (iJ == -1) {
            iJ = 0;
        }
        PfmOuterClass$RequestLoadTransactions.a aVarB = PfmOuterClass$RequestLoadTransactions.newBuilder().B(bVar.a());
        Long lF = bVar.f();
        PfmOuterClass$RequestLoadTransactions.a aVarF = aVarB.F(o0(lF != null ? lF.longValue() : 0L));
        Long lB = bVar.b();
        PfmOuterClass$RequestLoadTransactions.a aVarH = aVarF.C(o0(lB != null ? lB.longValue() : 0L)).G(C75.j(iJ)).D(bVar.d()).E(EnumC6845Pf4.j(iOrdinal)).H(F75.PfmUserTagsType_WITHCHILD);
        List<PFMTag> listC = bVar.c();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listC, 10));
        for (PFMTag pFMTag : listC) {
            int iJ2 = pFMTag.getTransactionType().j();
            if (iJ2 == -1) {
                iJ2 = 0;
            }
            PfmStruct$PfmTransactionTag.a aVarA = PfmStruct$PfmTransactionTag.newBuilder().B(pFMTag.getId()).C(pFMTag.getLabel()).F(pFMTag.getUserId()).E(C75.j(iJ2)).A(StringValue.of(String.valueOf(pFMTag.getColor())));
            PFMTag parentTag = pFMTag.getParentTag();
            if (parentTag != null) {
                aVarA.D(RQ4.c(parentTag));
            }
            arrayList.add((PfmStruct$PfmTransactionTag) aVarA.a());
        }
        PfmOuterClass$RequestLoadTransactions pfmOuterClass$RequestLoadTransactions = (PfmOuterClass$RequestLoadTransactions) aVarH.A(arrayList).a();
        AbstractC13042fc3.f(pfmOuterClass$RequestLoadTransactions);
        PfmOuterClass$ResponseLoadTransactions defaultInstance = PfmOuterClass$ResponseLoadTransactions.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.pfm.v1.Pfm/LoadTransactions", pfmOuterClass$RequestLoadTransactions, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 t0(List list) {
        PfmOuterClass$RequestRemoveTransaction.a aVarNewBuilder = PfmOuterClass$RequestRemoveTransaction.newBuilder();
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(EP4.a.b((PFMTransactionId) it.next()));
        }
        PfmOuterClass$RequestRemoveTransaction pfmOuterClass$RequestRemoveTransaction = (PfmOuterClass$RequestRemoveTransaction) aVarNewBuilder.A(arrayList).a();
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.f(pfmOuterClass$RequestRemoveTransaction);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.pfm.v1.Pfm/RemoveTransaction", pfmOuterClass$RequestRemoveTransaction, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.ZO4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C12315eP4.u0((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u0(Misc$ResponseVoid misc$ResponseVoid) {
        return C19938rB7.a;
    }

    private final C6517Nv5 v0(List list) {
        PfmOuterClass$RequestRemoveUserTags.a aVarNewBuilder = PfmOuterClass$RequestRemoveUserTags.newBuilder();
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(RQ4.c((PFMTag) it.next()));
        }
        PfmOuterClass$RequestRemoveUserTags pfmOuterClass$RequestRemoveUserTags = (PfmOuterClass$RequestRemoveUserTags) aVarNewBuilder.A(arrayList).a();
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.f(pfmOuterClass$RequestRemoveUserTags);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.pfm.v1.Pfm/RemoveUserTags", pfmOuterClass$RequestRemoveUserTags, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.bP4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C12315eP4.w0((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w0(Misc$ResponseVoid misc$ResponseVoid) {
        return C19938rB7.a;
    }

    private final C6517Nv5 x0(C18289oP5 c18289oP5) {
        Feedback$RequestSendFeedBack feedback$RequestSendFeedBack = (Feedback$RequestSendFeedBack) Feedback$RequestSendFeedBack.newBuilder().C(c18289oP5.c()).D(c18289oP5.d()).A(c18289oP5.b()).B(C18732p92.u0(c18289oP5.a())).a();
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.f(feedback$RequestSendFeedBack);
        AbstractC13042fc3.f(defaultInstance);
        C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.feedback.v1.FeedBack/SendFeedBack", feedback$RequestSendFeedBack, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.cP4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C12315eP4.y0((Misc$ResponseVoid) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y0(Misc$ResponseVoid misc$ResponseVoid) {
        return C19938rB7.a;
    }

    private final C6517Nv5 z0(PFMTransactionId pFMTransactionId, List list) {
        try {
            PfmOuterClass$RequestAddTransactionTags.a aVarB = PfmOuterClass$RequestAddTransactionTags.newBuilder().B(EP4.a.b(pFMTransactionId));
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(RQ4.c((PFMTag) it.next()));
            }
            PfmOuterClass$RequestAddTransactionTags pfmOuterClass$RequestAddTransactionTags = (PfmOuterClass$RequestAddTransactionTags) aVarB.A(arrayList).a();
            Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
            AbstractC13042fc3.f(pfmOuterClass$RequestAddTransactionTags);
            AbstractC13042fc3.f(defaultInstance);
            C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.pfm.v1.Pfm/AddTransactionTags", pfmOuterClass$RequestAddTransactionTags, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.aP4
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return C12315eP4.A0((Misc$ResponseVoid) obj);
                }
            });
            AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
            return c6517Nv5H0;
        } catch (Exception e) {
            return C6517Nv5.F(new Exception(e.getMessage()));
        }
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (obj instanceof b) {
            return s0((b) obj);
        }
        if (obj instanceof a) {
            return p0();
        }
        if (obj instanceof C24614yu6) {
            C24614yu6 c24614yu6 = (C24614yu6) obj;
            return z0(c24614yu6.b(), c24614yu6.a());
        }
        if (obj instanceof C14838ia) {
            return m0(((C14838ia) obj).a());
        }
        if (obj instanceof CG2) {
            return q0();
        }
        if (obj instanceof LN5) {
            return v0(((LN5) obj).a());
        }
        if (obj instanceof C18289oP5) {
            return x0((C18289oP5) obj);
        }
        if (obj instanceof P8) {
            P8 p8 = (P8) obj;
            return k0(p8.b(), p8.a());
        }
        if (obj instanceof JN5) {
            return t0(((JN5) obj).a());
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.f(c6517Nv5G);
        return c6517Nv5G;
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        super.m(obj);
    }
}
