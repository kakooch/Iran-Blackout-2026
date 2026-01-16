package ir.nasim.features.pfm;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.PfmOuterClass$ResponseGetUserAccounts;
import ai.bale.proto.PfmOuterClass$ResponseLoadTransactions;
import ai.bale.proto.PfmStruct$PfmConfig;
import ai.bale.proto.PfmStruct$PfmTotalAmount;
import ai.bale.proto.PfmStruct$PfmTotalAmountsPerDay;
import ai.bale.proto.PfmStruct$PfmTransaction;
import ai.bale.proto.PfmStruct$PfmTransactionTag;
import ai.bale.proto.PfmStruct$PfmUserAccount;
import android.app.NotificationManager;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.lifecycle.r;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15360jS4;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16613la3;
import ir.nasim.AbstractC18306oR4;
import ir.nasim.AbstractC19488qR4;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC9773aX7;
import ir.nasim.C12315eP4;
import ir.nasim.C12366eV1;
import ir.nasim.C14505i18;
import ir.nasim.C14838ia;
import ir.nasim.C18289oP5;
import ir.nasim.C19811qz;
import ir.nasim.C19938rB7;
import ir.nasim.C20298rm4;
import ir.nasim.C21167tD6;
import ir.nasim.C23077wJ2;
import ir.nasim.C24614yu6;
import ir.nasim.C3343Am;
import ir.nasim.C5721Ko;
import ir.nasim.C6517Nv5;
import ir.nasim.C75;
import ir.nasim.D45;
import ir.nasim.DV;
import ir.nasim.ED1;
import ir.nasim.EnumC15195jA1;
import ir.nasim.EnumC18897pR4;
import ir.nasim.EnumC20036rM6;
import ir.nasim.GE4;
import ir.nasim.H75;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17569nB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3273Ae1;
import ir.nasim.LN5;
import ir.nasim.OC;
import ir.nasim.QP5;
import ir.nasim.RB3;
import ir.nasim.RQ4;
import ir.nasim.UP4;
import ir.nasim.VW7;
import ir.nasim.XV4;
import ir.nasim.XY6;
import ir.nasim.features.pfm.entity.AnalysisData;
import ir.nasim.features.pfm.entity.AnalysisDialogData;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.pfm.entity.PFMTransactionId;
import ir.nasim.features.pfm.j;
import ir.nasim.features.pfm.tags.PFMTag;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class h extends VW7 {
    public static final a S0 = new a(null);
    public static final int T0 = 8;
    private final r A;
    private String A0;
    private EnumC15195jA1 B;
    private String B0;
    private String C0;
    private final Map D;
    private List D0;
    private String E0;
    private boolean F0;
    private final Map G;
    private boolean G0;
    private List H;
    private final Map H0;
    private final Map I0;
    private final C21167tD6 J;
    private final Map J0;
    private final C21167tD6 K0;
    private final r L0;
    private final C21167tD6 M0;
    private final r N0;
    private final C20298rm4 O0;
    private final r P0;
    private final C20298rm4 Q0;
    private final r R0;
    private Boolean Y;
    private int Z;
    private final UP4 b;
    private final int c;
    private long d;
    private final QP5 e;
    private final C20298rm4 f;
    private final r g;
    private final C20298rm4 h;
    private final r i;
    private final C20298rm4 j;
    private final r k;
    private final C20298rm4 l;
    private final r m;
    private final C20298rm4 n;
    private final C20298rm4 o;
    private final r p;
    private final C20298rm4 q;
    private final C20298rm4 r;
    private final r s;
    private final C20298rm4 t;
    private final r u;
    private List v;
    private EnumC18897pR4 w;
    private long x;
    private long y;
    private final C20298rm4 z;
    private String z0;

    public static final class a {
        private a() {
        }

        public final void a(EnumC18897pR4 enumC18897pR4) {
            AbstractC13042fc3.i(enumC18897pR4, "type");
            C3343Am.i("pfm_diagram_page", AbstractC20051rO3.n(new XV4("action_type", 5), new XV4("accounting_type", Integer.valueOf(enumC18897pR4 == EnumC18897pR4.d ? 1 : 0))));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C75.values().length];
            try {
                iArr[C75.PfmTransactionType_TOPUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C75.PfmTransactionType_WITHDRAW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PfmOuterClass$ResponseLoadTransactions d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = pfmOuterClass$ResponseLoadTransactions;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return h.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            CollectionsStruct$StringValue loadMoreState;
            String text;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            h hVar = h.this;
            String str = "";
            if (this.d.getTransactionsList().size() >= h.this.k2() && (loadMoreState = this.d.getLoadMoreState()) != null && (text = loadMoreState.getText()) != null) {
                str = text;
            }
            hVar.D3(str);
            List<PfmStruct$PfmTransaction> transactionsList = this.d.getTransactionsList();
            AbstractC13042fc3.h(transactionsList, "getTransactionsList(...)");
            h hVar2 = h.this;
            for (PfmStruct$PfmTransaction pfmStruct$PfmTransaction : transactionsList) {
                AbstractC13042fc3.f(pfmStruct$PfmTransaction);
                PFMTransaction pFMTransactionB = AbstractC18306oR4.b(pfmStruct$PfmTransaction);
                if (!hVar2.z2().contains(pFMTransactionB)) {
                    hVar2.z2().add(pFMTransactionB);
                }
            }
            h.this.h.n(new j.c(h.this.z2()));
            h.this.B3(false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ PfmOuterClass$ResponseLoadTransactions e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ h c;
            final /* synthetic */ PfmOuterClass$ResponseLoadTransactions d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(h hVar, PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = hVar;
                this.d = pfmOuterClass$ResponseLoadTransactions;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws NumberFormatException {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                h hVar = this.c;
                List<PfmStruct$PfmTotalAmount> totalAmountsList = this.d.getTotalAmountsList();
                AbstractC13042fc3.h(totalAmountsList, "getTotalAmountsList(...)");
                hVar.N3(AbstractC15401jX0.p1(totalAmountsList));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ h c;
            final /* synthetic */ PfmOuterClass$ResponseLoadTransactions d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(h hVar, PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = hVar;
                this.d = pfmOuterClass$ResponseLoadTransactions;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                h hVar = this.c;
                List<PfmStruct$PfmTransaction> transactionsList = this.d.getTransactionsList();
                AbstractC13042fc3.h(transactionsList, "getTransactionsList(...)");
                hVar.O3(AbstractC15401jX0.p1(transactionsList));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = pfmOuterClass$ResponseLoadTransactions;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = h.this.new d(this.e, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String text;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                if (h.this.B == EnumC15195jA1.d) {
                    h hVar = h.this;
                    List<PfmStruct$PfmTotalAmountsPerDay> totalAmountsPerDayList = this.e.getTotalAmountsPerDayList();
                    AbstractC13042fc3.h(totalAmountsPerDayList, "getTotalAmountsPerDayList(...)");
                    hVar.K3(AbstractC15401jX0.p1(totalAmountsPerDayList));
                }
                h hVar2 = h.this;
                CollectionsStruct$StringValue loadMoreState = this.e.getLoadMoreState();
                if (loadMoreState == null || (text = loadMoreState.getText()) == null) {
                    text = "";
                }
                hVar2.D3(text);
                List listP = AbstractC10360bX0.p(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(h.this, this.e, null), 3, null), AbstractC10533bm0.b(interfaceC20315ro1, null, null, new b(h.this, this.e, null), 3, null));
                this.b = 1;
                if (DV.a(listP, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            h.this.l.n(h.this.L2());
            h.this.r.n(h.this.f2());
            h.this.h.n(new j.c(h.this.z2()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PfmOuterClass$ResponseLoadTransactions d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = pfmOuterClass$ResponseLoadTransactions;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return h.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            h hVar = h.this;
            List<PfmStruct$PfmTotalAmount> totalAmountsList = this.d.getTotalAmountsList();
            AbstractC13042fc3.h(totalAmountsList, "getTotalAmountsList(...)");
            hVar.L3(hVar.N1(AbstractC15401jX0.p1(totalAmountsList)));
            h.this.j.n(h.this.M2());
            h.this.o.n(h.this.g2());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ PfmOuterClass$ResponseLoadTransactions e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ h c;
            final /* synthetic */ PfmOuterClass$ResponseLoadTransactions d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(h hVar, PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = hVar;
                this.d = pfmOuterClass$ResponseLoadTransactions;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws NumberFormatException {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                h hVar = this.c;
                List<PfmStruct$PfmTotalAmount> totalAmountsList = this.d.getTotalAmountsList();
                AbstractC13042fc3.h(totalAmountsList, "getTotalAmountsList(...)");
                hVar.N3(AbstractC15401jX0.p1(totalAmountsList));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ h c;
            final /* synthetic */ PfmOuterClass$ResponseLoadTransactions d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(h hVar, PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = hVar;
                this.d = pfmOuterClass$ResponseLoadTransactions;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                h hVar = this.c;
                List<PfmStruct$PfmTransaction> transactionsList = this.d.getTransactionsList();
                AbstractC13042fc3.h(transactionsList, "getTransactionsList(...)");
                hVar.H1(AbstractC15401jX0.p1(transactionsList));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = pfmOuterClass$ResponseLoadTransactions;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = h.this.new f(this.e, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                List listP = AbstractC10360bX0.p(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(h.this, this.e, null), 3, null), AbstractC10533bm0.b(interfaceC20315ro1, null, null, new b(h.this, this.e, null), 3, null));
                this.b = 1;
                if (DV.a(listP, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            h.this.l.n(h.this.L2());
            h.this.r.n(h.this.f2());
            h.this.h.n(new j.c(h.this.z2()));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public h(UP4 up4) {
        AbstractC13042fc3.i(up4, "pfmModule");
        this.b = up4;
        this.c = 30;
        this.d = -1L;
        this.e = QP5.a;
        C20298rm4 c20298rm4 = new C20298rm4();
        this.f = c20298rm4;
        this.g = c20298rm4;
        C20298rm4 c20298rm42 = new C20298rm4();
        this.h = c20298rm42;
        this.i = c20298rm42;
        C20298rm4 c20298rm43 = new C20298rm4("0");
        this.j = c20298rm43;
        this.k = c20298rm43;
        C20298rm4 c20298rm44 = new C20298rm4("0");
        this.l = c20298rm44;
        this.m = c20298rm44;
        this.n = new C20298rm4(-1L);
        C20298rm4 c20298rm45 = new C20298rm4("0");
        this.o = c20298rm45;
        this.p = c20298rm45;
        this.q = new C20298rm4();
        C20298rm4 c20298rm46 = new C20298rm4("0");
        this.r = c20298rm46;
        this.s = c20298rm46;
        C20298rm4 c20298rm47 = new C20298rm4();
        this.t = c20298rm47;
        this.u = c20298rm47;
        this.v = new ArrayList();
        this.w = EnumC18897pR4.b;
        C20298rm4 c20298rm48 = new C20298rm4("");
        this.z = c20298rm48;
        this.A = c20298rm48;
        this.B = EnumC15195jA1.d;
        this.D = new LinkedHashMap();
        this.G = new LinkedHashMap();
        this.H = new ArrayList();
        this.J = new C21167tD6();
        this.z0 = "0";
        this.A0 = "0";
        this.B0 = "0";
        this.C0 = "0";
        this.D0 = new ArrayList();
        this.E0 = "";
        this.H0 = new LinkedHashMap();
        this.I0 = new LinkedHashMap();
        this.J0 = new LinkedHashMap();
        C21167tD6 c21167tD6 = new C21167tD6();
        this.K0 = c21167tD6;
        this.L0 = c21167tD6;
        C21167tD6 c21167tD62 = new C21167tD6();
        this.M0 = c21167tD62;
        this.N0 = c21167tD62;
        C20298rm4 c20298rm49 = new C20298rm4();
        this.O0 = c20298rm49;
        this.P0 = c20298rm49;
        C20298rm4 c20298rm410 = new C20298rm4();
        this.Q0 = c20298rm410;
        this.R0 = c20298rm410;
        c20298rm4.n(EnumC20036rM6.c);
        u3();
        D2();
        Q2();
    }

    private final void A3() {
        if (this.e.e() || this.e.d()) {
            return;
        }
        this.e.j(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 B1(h hVar, EnumC18897pR4 enumC18897pR4, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC13042fc3.i(enumC18897pR4, "$type");
        return hVar.R3(enumC18897pR4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 C1(Exception exc) {
        return C6517Nv5.F(new Exception(C5721Ko.a.d().getString(AbstractC12217eE5.pfm_error_custom_tag_msg_exist)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 D1(String str, EnumC18897pR4 enumC18897pR4, PFMTag pFMTag, PFMTransaction pFMTransaction, h hVar, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(str, "$label");
        AbstractC13042fc3.i(enumC18897pR4, "$type");
        AbstractC13042fc3.i(hVar, "this$0");
        PFMTag pFMTagG = C23077wJ2.g(str, enumC18897pR4, pFMTag);
        return (pFMTagG == null || pFMTransaction == null) ? C6517Nv5.F(new Exception(C5721Ko.a.d().getString(AbstractC12217eE5.pfm_error_custom_tag_msg))) : hVar.E3(pFMTagG, pFMTransaction).H(new InterfaceC17569nB2() { // from class: ir.nasim.UR4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.features.pfm.h.E1((C19938rB7) obj);
            }
        });
    }

    private final void D2() {
        this.b.H(new C12315eP4.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dS4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.pfm.h.E2(this.a, (PfmOuterClass$ResponseGetUserAccounts) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.eS4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.pfm.h.F2(this.a, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 E1(C19938rB7 c19938rB7) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(h hVar, PfmOuterClass$ResponseGetUserAccounts pfmOuterClass$ResponseGetUserAccounts) {
        CollectionsStruct$Int64Value startDate;
        AbstractC13042fc3.i(hVar, "this$0");
        List<PfmStruct$PfmUserAccount> accountsList = pfmOuterClass$ResponseGetUserAccounts.getAccountsList();
        AbstractC13042fc3.h(accountsList, "getAccountsList(...)");
        List<PfmStruct$PfmUserAccount> list = accountsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PfmStruct$PfmUserAccount pfmStruct$PfmUserAccount : list) {
            H75.a aVar = H75.e;
            AbstractC13042fc3.f(pfmStruct$PfmUserAccount);
            arrayList.add(aVar.a(pfmStruct$PfmUserAccount));
        }
        hVar.v = AbstractC15401jX0.p1(arrayList);
        PfmStruct$PfmConfig config = pfmOuterClass$ResponseGetUserAccounts.getConfig();
        hVar.d = (config == null || (startDate = config.getStartDate()) == null) ? -1L : startDate.getValue();
        List<PfmStruct$PfmUserAccount> accountsList2 = pfmOuterClass$ResponseGetUserAccounts.getAccountsList();
        if (accountsList2 == null || accountsList2.isEmpty()) {
            hVar.f.n(EnumC20036rM6.b);
            return;
        }
        C20298rm4 c20298rm4 = hVar.t;
        List<PfmStruct$PfmUserAccount> accountsList3 = pfmOuterClass$ResponseGetUserAccounts.getAccountsList();
        AbstractC13042fc3.h(accountsList3, "getAccountsList(...)");
        List<PfmStruct$PfmUserAccount> list2 = accountsList3;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (PfmStruct$PfmUserAccount pfmStruct$PfmUserAccount2 : list2) {
            H75.a aVar2 = H75.e;
            AbstractC13042fc3.f(pfmStruct$PfmUserAccount2);
            arrayList2.add(aVar2.a(pfmStruct$PfmUserAccount2));
        }
        c20298rm4.n(arrayList2);
        hVar.f.n(EnumC20036rM6.a);
        hVar.a3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(h hVar, Exception exc) {
        AbstractC13042fc3.i(hVar, "this$0");
        hVar.f.n(EnumC20036rM6.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F3(PFMTag pFMTag, final h hVar, PFMTransaction pFMTransaction, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(pFMTag, "$selectedTag");
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        if (RQ4.a(pFMTag)) {
            hVar.A3();
        }
        Object systemService = C5721Ko.a.d().getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        GE4.f((NotificationManager) systemService, String.valueOf((int) pFMTransaction.getDate()));
        AbstractC5969Lp4.d().u(pFMTransaction.getId(), false);
        List<PFMTransaction> list = hVar.D0;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PFMTransaction pFMTransaction2 : list) {
            if (pFMTransaction2.getId() == pFMTransaction.getId()) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(pFMTag);
                pFMTransaction2.k(arrayList2);
            }
            arrayList.add(C19938rB7.a);
        }
        hVar.l3(pFMTag, pFMTransaction);
        hVar.h.n(new j.c(hVar.D0));
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.WR4
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.pfm.h.G3(this.a);
            }
        });
        hVar.f.n(EnumC20036rM6.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(h hVar, C19938rB7 c19938rB7, Exception exc) {
        AbstractC13042fc3.i(hVar, "this$0");
        hVar.M1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G3(h hVar) {
        AbstractC13042fc3.i(hVar, "this$0");
        hVar.g3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(List list) {
        List listP1 = AbstractC15401jX0.p1(this.D0);
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC18306oR4.b((PfmStruct$PfmTransaction) it.next()));
        }
        this.D0 = AbstractC15401jX0.p1(AbstractC15401jX0.s1(arrayList, listP1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 J1(PFMTag pFMTag, h hVar, EnumC18897pR4 enumC18897pR4, C19938rB7 c19938rB7) {
        List list;
        AbstractC13042fc3.i(pFMTag, "$selectedTag");
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC13042fc3.i(enumC18897pR4, "$type");
        if (pFMTag.getParentTag() != null && (list = (List) C23077wJ2.a.e().get(pFMTag.getParentTag())) != null) {
            list.remove(pFMTag);
        }
        return hVar.R3(enumC18897pR4);
    }

    private final void J3() {
        this.f.n(EnumC20036rM6.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(final h hVar, final PFMTag pFMTag, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC13042fc3.i(pFMTag, "$selectedTag");
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.XR4
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.pfm.h.L1(this.a, pFMTag);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K3(List list) {
        this.H0.clear();
        this.I0.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PfmStruct$PfmTotalAmountsPerDay pfmStruct$PfmTotalAmountsPerDay = (PfmStruct$PfmTotalAmountsPerDay) it.next();
            PfmStruct$PfmTotalAmount amount = pfmStruct$PfmTotalAmountsPerDay.getAmount();
            C75 type = amount != null ? amount.getType() : null;
            int i = type == null ? -1 : b.a[type.ordinal()];
            if (i == 1) {
                Map map = this.H0;
                CollectionsStruct$Int64Value date = pfmStruct$PfmTotalAmountsPerDay.getDate();
                AbstractC13042fc3.f(date);
                Long lValueOf = Long.valueOf(date.getValue());
                PfmStruct$PfmTotalAmount amount2 = pfmStruct$PfmTotalAmountsPerDay.getAmount();
                AbstractC13042fc3.f(amount2);
                String amount3 = amount2.getAmount();
                AbstractC13042fc3.h(amount3, "getAmount(...)");
                map.put(lValueOf, Long.valueOf(Long.parseLong(amount3)));
            } else if (i == 2) {
                Map map2 = this.I0;
                CollectionsStruct$Int64Value date2 = pfmStruct$PfmTotalAmountsPerDay.getDate();
                AbstractC13042fc3.f(date2);
                Long lValueOf2 = Long.valueOf(date2.getValue());
                PfmStruct$PfmTotalAmount amount4 = pfmStruct$PfmTotalAmountsPerDay.getAmount();
                AbstractC13042fc3.f(amount4);
                String amount5 = amount4.getAmount();
                AbstractC13042fc3.h(amount5, "getAmount(...)");
                map2.put(lValueOf2, Long.valueOf(Long.parseLong(amount5)));
            }
        }
        this.K0.n(this.H0);
        this.M0.n(this.I0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(h hVar, PFMTag pFMTag) {
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC13042fc3.i(pFMTag, "$selectedTag");
        hVar.g3();
        if (pFMTag.getParentTag() != null) {
            hVar.O1(pFMTag.getParentTag());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L3(List list) {
        PfmStruct$PfmTransactionTag tag;
        PfmStruct$PfmTransactionTag tag2;
        this.B0 = "0";
        this.C0 = "0";
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount = (PfmStruct$PfmTotalAmount) it.next();
            C75 type = pfmStruct$PfmTotalAmount.getType();
            int i = type == null ? -1 : b.a[type.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    if (pfmStruct$PfmTotalAmount.getTag() == null || !(pfmStruct$PfmTotalAmount.getTag() == null || (tag = pfmStruct$PfmTotalAmount.getTag()) == null || tag.getId() != 0)) {
                        this.C0 = pfmStruct$PfmTotalAmount.getAmount();
                    } else {
                        PFMTag pFMTagM2 = m2(pfmStruct$PfmTotalAmount);
                        Map map = this.G;
                        String amount = pfmStruct$PfmTotalAmount.getAmount();
                        AbstractC13042fc3.h(amount, "getAmount(...)");
                        map.put(pFMTagM2, Long.valueOf(Long.parseLong(amount)));
                    }
                }
            } else if (pfmStruct$PfmTotalAmount.getTag() == null || !(pfmStruct$PfmTotalAmount.getTag() == null || (tag2 = pfmStruct$PfmTotalAmount.getTag()) == null || tag2.getId() != 0)) {
                this.B0 = pfmStruct$PfmTotalAmount.getAmount();
            } else {
                PFMTag pFMTagM22 = m2(pfmStruct$PfmTotalAmount);
                Map map2 = this.D;
                String amount2 = pfmStruct$PfmTotalAmount.getAmount();
                AbstractC13042fc3.h(amount2, "getAmount(...)");
                map2.put(pFMTagM22, Long.valueOf(Long.parseLong(amount2)));
            }
        }
    }

    private final void M1() {
        this.f.n(EnumC20036rM6.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List N1(List list) throws NumberFormatException {
        PfmStruct$PfmTransactionTag tag;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        this.J0.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount = (PfmStruct$PfmTotalAmount) it.next();
            if (pfmStruct$PfmTotalAmount.getTag() == null || (tag = pfmStruct$PfmTotalAmount.getTag()) == null || tag.getId() != 0) {
                PfmStruct$PfmTransactionTag tag2 = pfmStruct$PfmTotalAmount.getTag();
                AbstractC13042fc3.f(tag2);
                PFMTag pFMTagB = RQ4.b(tag2);
                String amount = pfmStruct$PfmTotalAmount.getAmount();
                AbstractC13042fc3.h(amount, "getAmount(...)");
                long j = Long.parseLong(amount);
                PfmStruct$PfmTransactionTag tag3 = pfmStruct$PfmTotalAmount.getTag();
                PFMTag pFMTagB2 = tag3 != null ? RQ4.b(tag3) : null;
                AbstractC13042fc3.f(pFMTagB2);
                if (RQ4.a(pFMTagB2)) {
                    PfmStruct$PfmTransactionTag tag4 = pfmStruct$PfmTotalAmount.getTag();
                    PfmStruct$PfmTransactionTag parentTag = tag4 != null ? tag4.getParentTag() : null;
                    AbstractC13042fc3.f(parentTag);
                    PFMTag pFMTagB3 = RQ4.b(parentTag);
                    if (linkedHashMap.containsKey(pFMTagB3)) {
                        Object obj = linkedHashMap.get(pFMTagB3);
                        AbstractC13042fc3.f(obj);
                        linkedHashMap.put(pFMTagB3, Long.valueOf(((Number) obj).longValue() + j));
                    } else {
                        linkedHashMap.put(pFMTagB3, Long.valueOf(j));
                    }
                    if (this.J0.containsKey(pFMTagB3)) {
                        Map map = (Map) this.J0.get(pFMTagB3);
                        if (map != null) {
                        }
                    } else {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put(pFMTagB, Long.valueOf(j));
                        this.J0.put(pFMTagB3, linkedHashMap2);
                    }
                } else if (linkedHashMap.containsKey(pFMTagB)) {
                    Object obj2 = linkedHashMap.get(pFMTagB);
                    AbstractC13042fc3.f(obj2);
                    linkedHashMap.put(pFMTagB, Long.valueOf(((Number) obj2).longValue() + j));
                } else {
                    linkedHashMap.put(pFMTagB, Long.valueOf(j));
                }
            } else {
                arrayList.add(pfmStruct$PfmTotalAmount);
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            GeneratedMessageLite generatedMessageLiteA = PfmStruct$PfmTotalAmount.newBuilder().A(String.valueOf(((Number) entry.getValue()).longValue())).C(AbstractC19488qR4.b(((PFMTag) entry.getKey()).getTransactionType())).B(RQ4.c((PFMTag) entry.getKey())).a();
            AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
            arrayList.add(generatedMessageLiteA);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N3(List list) throws NumberFormatException {
        PfmStruct$PfmTransactionTag tag;
        PfmStruct$PfmTransactionTag tag2;
        PfmStruct$PfmTransactionTag tag3;
        PfmStruct$PfmTransactionTag tag4;
        this.z0 = "0";
        this.A0 = "0";
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount = (PfmStruct$PfmTotalAmount) it.next();
            C75 type = pfmStruct$PfmTotalAmount.getType();
            int i = type == null ? -1 : b.a[type.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    if (this.H.isEmpty()) {
                        if (pfmStruct$PfmTotalAmount.getTag() == null || (pfmStruct$PfmTotalAmount.getTag() != null && (tag = pfmStruct$PfmTotalAmount.getTag()) != null && tag.getId() == 0)) {
                            this.A0 = pfmStruct$PfmTotalAmount.getAmount();
                        }
                    } else if (pfmStruct$PfmTotalAmount.getTag() != null && ((tag2 = pfmStruct$PfmTotalAmount.getTag()) == null || tag2.getId() != 0)) {
                        long j = Long.parseLong(this.A0);
                        String amount = pfmStruct$PfmTotalAmount.getAmount();
                        AbstractC13042fc3.h(amount, "getAmount(...)");
                        this.A0 = String.valueOf(j + Long.parseLong(amount));
                    }
                }
            } else if (this.H.isEmpty()) {
                if (pfmStruct$PfmTotalAmount.getTag() == null || (pfmStruct$PfmTotalAmount.getTag() != null && (tag3 = pfmStruct$PfmTotalAmount.getTag()) != null && tag3.getId() == 0)) {
                    this.z0 = pfmStruct$PfmTotalAmount.getAmount();
                }
            } else if (pfmStruct$PfmTotalAmount.getTag() != null && ((tag4 = pfmStruct$PfmTotalAmount.getTag()) == null || tag4.getId() != 0)) {
                long j2 = Long.parseLong(this.z0);
                String amount2 = pfmStruct$PfmTotalAmount.getAmount();
                AbstractC13042fc3.h(amount2, "getAmount(...)");
                this.z0 = String.valueOf(j2 + Long.parseLong(amount2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O3(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC18306oR4.b((PfmStruct$PfmTransaction) it.next()));
        }
        this.D0 = AbstractC15401jX0.p1(arrayList);
    }

    private final C6517Nv5 P3() {
        C6517Nv5 c6517Nv5H = this.b.I().H(new InterfaceC17569nB2() { // from class: ir.nasim.YR4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.features.pfm.h.Q3((List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    private final void Q2() {
        C23077wJ2.a.f();
        P3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 Q3(List list) {
        C23077wJ2 c23077wJ2 = C23077wJ2.a;
        AbstractC13042fc3.f(list);
        c23077wJ2.a(list);
        return C6517Nv5.l0(C14505i18.a);
    }

    private final void R2(EnumC18897pR4 enumC18897pR4) {
        T3(enumC18897pR4);
    }

    private final C6517Nv5 R3(final EnumC18897pR4 enumC18897pR4) {
        C6517Nv5 c6517Nv5H = this.b.I().H(new InterfaceC17569nB2() { // from class: ir.nasim.SR4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.features.pfm.h.S3(this.a, enumC18897pR4, (List) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 S3(h hVar, EnumC18897pR4 enumC18897pR4, List list) {
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC13042fc3.i(enumC18897pR4, "$transactionType");
        C23077wJ2 c23077wJ2 = C23077wJ2.a;
        AbstractC13042fc3.f(list);
        c23077wJ2.a(list);
        hVar.T3(enumC18897pR4);
        return C6517Nv5.l0(C14505i18.a);
    }

    private final void T3(EnumC18897pR4 enumC18897pR4) {
        C20298rm4 c20298rm4 = this.O0;
        Collection collectionValues = C23077wJ2.a.f().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((PFMTag) obj).getTransactionType() == enumC18897pR4) {
                arrayList.add(obj);
            }
        }
        c20298rm4.n(arrayList);
    }

    private final Long U1() {
        H75 h75 = (H75) AbstractC15401jX0.t0(this.v, this.Z);
        if (h75 != null) {
            return Long.valueOf(h75.a());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(h hVar, PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions) {
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC10533bm0.d(AbstractC9773aX7.a(hVar), C12366eV1.b(), null, hVar.new c(pfmOuterClass$ResponseLoadTransactions, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b3(h hVar, PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions) {
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC10533bm0.d(AbstractC9773aX7.a(hVar), C12366eV1.b(), null, hVar.new d(pfmOuterClass$ResponseLoadTransactions, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c3(h hVar, Exception exc) {
        AbstractC13042fc3.i(hVar, "this$0");
        C20298rm4 c20298rm4 = hVar.h;
        AbstractC13042fc3.f(exc);
        c20298rm4.n(new j.a(exc));
    }

    private final void d3() {
        this.D.clear();
        this.G.clear();
        this.j.n("0");
        this.o.n("0");
        Long lU1 = U1();
        if (lU1 != null) {
            this.b.J(new C12315eP4.b(lU1.longValue(), Long.valueOf(this.x), Long.valueOf(this.y), EnumC18897pR4.b, AbstractC10360bX0.m(), 0, null, RB3.c)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ZR4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.h.e3(this.a, (PfmOuterClass$ResponseLoadTransactions) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(h hVar, PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions) {
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC10533bm0.d(AbstractC9773aX7.a(hVar), C12366eV1.b(), null, hVar.new e(pfmOuterClass$ResponseLoadTransactions, null), 2, null);
    }

    private final void g3() {
        d3();
        Long lU1 = U1();
        if (lU1 != null) {
            this.b.J(new C12315eP4.b(lU1.longValue(), Long.valueOf(this.x), Long.valueOf(this.y), this.w, this.H, this.c, null, RB3.c)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.aS4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.h.h3(this.a, (PfmOuterClass$ResponseLoadTransactions) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(h hVar, PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions) {
        AbstractC13042fc3.i(hVar, "this$0");
        AbstractC10533bm0.d(AbstractC9773aX7.a(hVar), C12366eV1.b(), null, hVar.new f(pfmOuterClass$ResponseLoadTransactions, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 j3(PFMTag pFMTag, final h hVar, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(pFMTag, "$pfmTag");
        AbstractC13042fc3.i(hVar, "this$0");
        C23077wJ2.j(pFMTag);
        if (pFMTag.getParentTag() != null) {
            hVar.O1(pFMTag.getParentTag());
        }
        hVar.T3(pFMTag.getTransactionType());
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.VR4
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.pfm.h.k3(this.a);
            }
        });
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k3(h hVar) {
        AbstractC13042fc3.i(hVar, "this$0");
        hVar.g3();
    }

    private final void l3(PFMTag pFMTag, PFMTransaction pFMTransaction) {
        if (!(!this.H.isEmpty()) || this.H.contains(pFMTag)) {
            return;
        }
        this.D0.remove(pFMTransaction);
    }

    private final PFMTag m2(PfmStruct$PfmTotalAmount pfmStruct$PfmTotalAmount) {
        PfmStruct$PfmTransactionTag tag = pfmStruct$PfmTotalAmount.getTag();
        AbstractC13042fc3.f(tag);
        PFMTag pFMTagB = RQ4.b(tag);
        Map mapF = C23077wJ2.a.f();
        PfmStruct$PfmTransactionTag tag2 = pfmStruct$PfmTotalAmount.getTag();
        AbstractC13042fc3.f(tag2);
        PFMTag pFMTag = (PFMTag) mapF.get(Long.valueOf(tag2.getId()));
        return pFMTag != null ? pFMTag : pFMTagB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n3(h hVar, C19938rB7 c19938rB7, Exception exc) {
        AbstractC13042fc3.i(hVar, "this$0");
        hVar.M1();
    }

    private final String p2(D45 d45) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AbstractC16613la3.a(d45.C()));
        stringBuffer.append(Separators.SLASH);
        stringBuffer.append(AbstractC16613la3.a(d45.B()));
        stringBuffer.append(Separators.SLASH);
        stringBuffer.append(AbstractC16613la3.a(d45.A()));
        return XY6.e(stringBuffer.toString());
    }

    private final void p3(PFMTag pFMTag, String str, long j) throws NumberFormatException {
        long j2;
        try {
            j2 = Long.parseLong(str);
        } catch (Exception unused) {
            j2 = 0;
        }
        C3343Am.i("pfm_label_page", AbstractC20051rO3.n(new XV4("label_type", pFMTag.getLabel()), new XV4("label_version", Integer.valueOf(pFMTag.getUserId() == 0 ? 1 : 2)), new XV4("accounting_type", Integer.valueOf(pFMTag.getTransactionType() == EnumC18897pR4.c ? 0 : 1)), new XV4("action_type", 0), new XV4("amount", Long.valueOf(j2)), new XV4("transaction_date", Long.valueOf(j))));
    }

    private final void r3() {
        if (this.B == EnumC15195jA1.d) {
            this.z.n(C5721Ko.a.d().getString(AbstractC12217eE5.the_last_30_days));
            return;
        }
        this.z.n(p2(new D45(Long.valueOf(this.x))) + " - " + p2(new D45(Long.valueOf(this.y))) + Separators.SP);
    }

    public final C6517Nv5 A1(final String str, final EnumC18897pR4 enumC18897pR4, final PFMTransaction pFMTransaction, final PFMTag pFMTag) {
        AbstractC13042fc3.i(str, "label");
        AbstractC13042fc3.i(enumC18897pR4, "type");
        PFMTag pFMTag2 = new PFMTag(AbstractC5969Lp4.f(), 0L, str, enumC18897pR4, pFMTag, 0, 0, null, 224, null);
        UP4 up4 = this.b;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(pFMTag2);
        C6517Nv5 c6517Nv5H = up4.D(new C14838ia(arrayList)).A(new InterfaceC17569nB2() { // from class: ir.nasim.PR4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.features.pfm.h.B1(this.a, enumC18897pR4, (C19938rB7) obj);
            }
        }).G(new InterfaceC17569nB2() { // from class: ir.nasim.QR4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.features.pfm.h.C1((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.RR4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.features.pfm.h.D1(str, enumC18897pR4, pFMTag, pFMTransaction, this, (C19938rB7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final Map A2() {
        return this.J0;
    }

    public final void B3(boolean z) {
        this.F0 = z;
    }

    public final r C2() {
        return this.g;
    }

    public final void C3() {
        if (!this.e.e() || this.e.d()) {
            return;
        }
        this.e.i(true);
    }

    public final void D3(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.E0 = str;
    }

    public final C6517Nv5 E3(final PFMTag pFMTag, final PFMTransaction pFMTransaction) throws NumberFormatException {
        AbstractC13042fc3.i(pFMTag, "selectedTag");
        AbstractC13042fc3.i(pFMTransaction, "pfmTransaction");
        if (!RQ4.a(pFMTag)) {
            p3(pFMTag, pFMTransaction.getAmount(), pFMTransaction.getDate());
        }
        this.G0 = false;
        this.f.n(EnumC20036rM6.d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(pFMTag);
        C6517Nv5 c6517Nv5M0 = this.b.O(new C24614yu6(arrayList, AbstractC18306oR4.a(pFMTransaction))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.bS4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.pfm.h.F3(pFMTag, this, pFMTransaction, (C19938rB7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    public final C6517Nv5 F1(PFMTransactionId pFMTransactionId, String str) {
        AbstractC13042fc3.i(pFMTransactionId, "id");
        AbstractC13042fc3.i(str, "detail");
        J3();
        C6517Nv5 c6517Nv5Z = this.b.C(pFMTransactionId, str).z(new InterfaceC3273Ae1() { // from class: ir.nasim.NR4
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                ir.nasim.features.pfm.h.G1(this.a, (C19938rB7) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    public final Map G2() {
        return this.I0;
    }

    public final r H2() {
        return this.N0;
    }

    public final void H3(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.H = list;
    }

    public final C6517Nv5 I1(final PFMTag pFMTag, String str, final EnumC18897pR4 enumC18897pR4) {
        AbstractC13042fc3.i(pFMTag, "selectedTag");
        AbstractC13042fc3.i(str, "label");
        AbstractC13042fc3.i(enumC18897pR4, "type");
        PFMTag pFMTag2 = new PFMTag(AbstractC5969Lp4.f(), pFMTag.getId(), str, enumC18897pR4, pFMTag.getParentTag(), 0, pFMTag.getColor(), null, 160, null);
        UP4 up4 = this.b;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(pFMTag2);
        C6517Nv5 c6517Nv5M0 = up4.D(new C14838ia(arrayList)).A(new InterfaceC17569nB2() { // from class: ir.nasim.fS4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.features.pfm.h.J1(pFMTag, this, enumC18897pR4, (C19938rB7) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.gS4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.pfm.h.K1(this.a, pFMTag, (C19938rB7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    public final r I2() {
        return this.m;
    }

    public final void I3(EnumC18897pR4 enumC18897pR4) {
        AbstractC13042fc3.i(enumC18897pR4, "transactionType");
        this.w = enumC18897pR4;
    }

    public final r J2() {
        return this.k;
    }

    public final Map K2() {
        return this.G;
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        super.L0();
        C23077wJ2.a.b();
    }

    public final String L2() {
        return this.A0;
    }

    public final String M2() {
        return this.C0;
    }

    public final boolean N2(PFMTag pFMTag) {
        AbstractC13042fc3.i(pFMTag, "pfmTag");
        return pFMTag.getUserId() != 0;
    }

    public final void O1(PFMTag pFMTag) {
        AbstractC13042fc3.i(pFMTag, "pfmTag");
        this.Q0.n(C23077wJ2.a.e().get(pFMTag));
    }

    public final boolean O2() {
        return this.e.c();
    }

    public final void P1(String str, EnumC18897pR4 enumC18897pR4, PFMTag pFMTag) {
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(enumC18897pR4, "transactionType");
        AbstractC13042fc3.i(pFMTag, ParameterNames.TAG);
        C20298rm4 c20298rm4 = this.Q0;
        List list = (List) C23077wJ2.a.e().get(pFMTag);
        ArrayList arrayList = null;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                PFMTag pFMTag2 = (PFMTag) obj;
                if (AbstractC20762sZ6.X(pFMTag2.getLabel(), str, false, 2, null) && pFMTag2.getTransactionType() == enumC18897pR4) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        c20298rm4.n(arrayList);
    }

    public final boolean P2() {
        return this.e.e() && !this.e.d();
    }

    public final void Q1(String str, EnumC18897pR4 enumC18897pR4) {
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(enumC18897pR4, "transactionType");
        C20298rm4 c20298rm4 = this.O0;
        Collection collectionValues = C23077wJ2.a.f().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            PFMTag pFMTag = (PFMTag) obj;
            if (AbstractC20762sZ6.X(pFMTag.getLabel(), str, false, 2, null) && pFMTag.getTransactionType() == enumC18897pR4) {
                arrayList.add(obj);
            }
        }
        c20298rm4.n(arrayList);
    }

    public final r R1() {
        return this.u;
    }

    public final AnalysisDialogData S1() {
        AnalysisDialogData analysisDialogDataH2 = AbstractC5969Lp4.d().h2();
        if (analysisDialogDataH2 == null || analysisDialogDataH2.isEmpty()) {
            return null;
        }
        AbstractC5969Lp4.d().a2("");
        return analysisDialogDataH2;
    }

    public final void S2(EnumC18897pR4 enumC18897pR4) {
        AbstractC13042fc3.i(enumC18897pR4, "transactionType");
        R2(enumC18897pR4);
        R3(enumC18897pR4);
    }

    public final AnalysisData T1() {
        AnalysisData analysisDataG2 = AbstractC5969Lp4.d().g2();
        if (analysisDataG2 != null && !analysisDataG2.isEmpty()) {
            long jCurrentTimeMillis = (System.currentTimeMillis() - analysisDataG2.getTime()) / 86400000;
            if (0 <= jCurrentTimeMillis && jCurrentTimeMillis < 8) {
                return analysisDataG2;
            }
        }
        return null;
    }

    public final void U2(PFMTransaction pFMTransaction) {
        AbstractC13042fc3.i(pFMTransaction, "transaction");
        this.D0.remove(pFMTransaction);
        this.h.n(new j.c(this.D0));
    }

    public final int V1() {
        return this.Z;
    }

    public final EnumC15195jA1 W1() {
        return this.B;
    }

    public final void W2() {
        this.F0 = true;
        this.G0 = false;
        Long lU1 = U1();
        if (lU1 != null) {
            this.b.J(new C12315eP4.b(lU1.longValue(), Long.valueOf(this.x), Long.valueOf(this.y), this.w, this.H, this.c, new OC(this.E0), RB3.c)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.TR4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.h.Y2(this.a, (PfmOuterClass$ResponseLoadTransactions) obj);
                }
            });
        }
    }

    public final r X1() {
        return this.A;
    }

    public final int Y1() {
        return this.e.a();
    }

    public final Map Z1() {
        return this.H0;
    }

    public final r a2() {
        return this.L0;
    }

    public final void a3() {
        d3();
        this.E0 = "";
        this.l.n("0");
        this.r.n("0");
        this.h.n(j.b.a);
        this.G0 = true;
        Long lU1 = U1();
        if (lU1 != null) {
            this.b.J(new C12315eP4.b(lU1.longValue(), Long.valueOf(this.x), Long.valueOf(this.y), this.w, this.H, this.c, null, RB3.c)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.iS4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.h.b3(this.a, (PfmOuterClass$ResponseLoadTransactions) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.OR4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.h.c3(this.a, (Exception) obj);
                }
            });
        }
    }

    public final r c2() {
        return this.s;
    }

    public final r d2() {
        return this.p;
    }

    public final Map e2() {
        return this.D;
    }

    public final String f2() {
        return this.z0;
    }

    public final String g2() {
        return this.B0;
    }

    public final boolean h2() {
        if (this.Y == null) {
            this.Y = Boolean.valueOf(this.e.b());
        }
        Boolean bool = this.Y;
        AbstractC13042fc3.g(bool, "null cannot be cast to non-null type kotlin.Boolean");
        return bool.booleanValue();
    }

    public final boolean i2() {
        return this.F0;
    }

    public final C6517Nv5 i3(final PFMTag pFMTag) {
        AbstractC13042fc3.i(pFMTag, "pfmTag");
        UP4 up4 = this.b;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(pFMTag);
        C6517Nv5 c6517Nv5H = up4.M(new LN5(arrayList)).H(new InterfaceC17569nB2() { // from class: ir.nasim.hS4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.features.pfm.h.j3(pFMTag, this, (C19938rB7) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C21167tD6 j2() {
        return this.J;
    }

    public final int k2() {
        return this.c;
    }

    public final String l2() {
        return this.E0;
    }

    public final C6517Nv5 m3(PFMTransactionId pFMTransactionId) {
        AbstractC13042fc3.i(pFMTransactionId, "id");
        J3();
        C6517Nv5 c6517Nv5Z = this.b.L(AbstractC10360bX0.g(pFMTransactionId)).z(new InterfaceC3273Ae1() { // from class: ir.nasim.cS4
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                ir.nasim.features.pfm.h.n3(this.a, (C19938rB7) obj, (Exception) obj2);
            }
        });
        AbstractC13042fc3.h(c6517Nv5Z, "after(...)");
        return c6517Nv5Z;
    }

    public final boolean n2() {
        return this.G0;
    }

    public final long o2() {
        return this.d;
    }

    public final C6517Nv5 o3(String str, C19811qz c19811qz) {
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(c19811qz, "mapValue");
        this.K0.f();
        return this.b.N(new C18289oP5(0, "PFM", str, c19811qz));
    }

    public final void q3(int i) {
        this.Z = i;
    }

    public final List r2(PFMTag pFMTag) {
        AbstractC13042fc3.i(pFMTag, "pfmTag");
        return (List) C23077wJ2.a.e().get(pFMTag);
    }

    public final r s2() {
        return this.R0;
    }

    public final void s3(int i) {
        this.e.f(i);
    }

    public final List t2() {
        return this.H;
    }

    public final void t3(boolean z) {
        this.e.g(z);
        this.Y = Boolean.valueOf(z);
    }

    public final r u2() {
        return this.P0;
    }

    public final void u3() {
        this.B = EnumC15195jA1.d;
        this.x = AbstractC15360jS4.a(new D45(Long.valueOf(new D45().E().longValue() - 2505600000L)));
        this.y = AbstractC15360jS4.b(new D45());
        r3();
    }

    public final long v2() {
        return this.x;
    }

    public final void v3(long j, long j2) {
        this.B = EnumC15195jA1.e;
        this.x = j;
        this.y = j2;
        r3();
    }

    public final long w2() {
        return this.y;
    }

    public final void w3() {
        this.B = EnumC15195jA1.c;
        this.x = AbstractC15360jS4.a(new D45());
        this.y = AbstractC15360jS4.b(new D45());
        r3();
    }

    public final EnumC18897pR4 x2() {
        return this.w;
    }

    public final void x3() throws ParseException {
        this.B = EnumC15195jA1.a;
        D45 d45 = new D45();
        d45.T(1);
        d45.U(d45.B());
        d45.V(d45.C());
        this.x = AbstractC15360jS4.a(d45);
        this.y = AbstractC15360jS4.b(new D45());
        r3();
    }

    public final r y2() {
        return this.i;
    }

    public final void y3() {
        this.B = EnumC15195jA1.b;
        this.x = AbstractC15360jS4.a(new D45(Long.valueOf(new D45().E().longValue() - ((r0.o() * 86400) * 1000))));
        this.y = AbstractC15360jS4.b(new D45());
        r3();
    }

    public final List z2() {
        return this.D0;
    }

    public final void z3(boolean z) {
        this.e.h(z);
    }
}
