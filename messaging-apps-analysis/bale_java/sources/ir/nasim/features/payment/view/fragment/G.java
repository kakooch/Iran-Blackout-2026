package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.compose.ui.e;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC22039uZ6;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C10661bz2;
import ir.nasim.C11335cq;
import ir.nasim.C11458d25;
import ir.nasim.C12366eV1;
import ir.nasim.C15196jA2;
import ir.nasim.C16969mA2;
import ir.nasim.C17067mL1;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C21231tK7;
import ir.nasim.C21753u45;
import ir.nasim.C22527vO3;
import ir.nasim.C23057wH0;
import ir.nasim.C23564x80;
import ir.nasim.C4619Fx1;
import ir.nasim.C5495Jo7;
import ir.nasim.C5505Jq;
import ir.nasim.C6011Lu2;
import ir.nasim.C6409Nm;
import ir.nasim.C8386Vt0;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G10;
import ir.nasim.G92;
import ir.nasim.InterfaceC10156bA3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17527n7;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC20667sP1;
import ir.nasim.InterfaceC21103t7;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.J44;
import ir.nasim.L60;
import ir.nasim.M46;
import ir.nasim.N46;
import ir.nasim.SA2;
import ir.nasim.V03;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.payment.data.model.BalanceReceipt;
import ir.nasim.features.payment.data.model.CardToCardReceipt;
import ir.nasim.features.payment.view.fragment.B;
import ir.nasim.features.payment.view.fragment.G;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0003\u007f\u0080\u0001B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J-\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J!\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010D\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\b=\u0010>\u0012\u0004\bC\u0010\u0004\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010L\u001a\u00020E8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\\\u001a\u00020U8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00140a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010}\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|¨\u0006\u0081\u0001"}, d2 = {"Lir/nasim/features/payment/view/fragment/G;", "Landroidx/fragment/app/l;", "Lir/nasim/jA2$a;", "<init>", "()V", "Lir/nasim/rB7;", "g9", "Lir/nasim/features/payment/data/model/CardToCardReceipt;", "cardToCardReceipt", "k9", "(Lir/nasim/features/payment/data/model/CardToCardReceipt;)V", "b9", "c9", "d9", "", "traceNumber", "i9", "(Ljava/lang/String;)V", "e9", "", "", "peerUniqueIds", "m9", "(Ljava/util/List;)V", "Lir/nasim/features/payment/data/model/BalanceReceipt;", "balanceReceipt", "j9", "(Lir/nasim/features/payment/data/model/BalanceReceipt;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "j7", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/mA2;", "friend", "s5", "(Lir/nasim/mA2;)V", "Lir/nasim/bz2;", "r1", "Lir/nasim/bz2;", "_binding", "Lir/nasim/sP1;", "s1", "Lir/nasim/sP1;", "Z8", "()Lir/nasim/sP1;", "setDialogRepository", "(Lir/nasim/sP1;)V", "dialogRepository", "Lir/nasim/go1;", "t1", "Lir/nasim/go1;", "a9", "()Lir/nasim/go1;", "setMainDispatcher", "(Lir/nasim/go1;)V", "getMainDispatcher$annotations", "mainDispatcher", "Lir/nasim/Nm;", "u1", "Lir/nasim/Nm;", "X8", "()Lir/nasim/Nm;", "setAnalyticsRepository", "(Lir/nasim/Nm;)V", "analyticsRepository", "Lir/nasim/t7;", "v1", "Lir/nasim/t7;", "W8", "()Lir/nasim/t7;", "setAdRepository", "(Lir/nasim/t7;)V", "adRepository", "Lir/nasim/n7;", "w1", "Lir/nasim/n7;", "V8", "()Lir/nasim/n7;", "setAdEventRepository", "(Lir/nasim/n7;)V", "adEventRepository", "Lir/nasim/jA2;", "x1", "Lir/nasim/jA2;", "friendsAdapter", "Ljava/util/ArrayList;", "y1", "Ljava/util/ArrayList;", "getSelectedItemIds", "()Ljava/util/ArrayList;", "selectedItemIds", "Lir/nasim/features/payment/view/fragment/B$b;", "z1", "Lir/nasim/features/payment/view/fragment/B$b;", "operationType", "Lir/nasim/J44;", "A1", "Lir/nasim/J44;", DialogEntity.COLUMN_MESSAGE, "Lir/nasim/d25;", "B1", "Lir/nasim/d25;", "peer", "Lir/nasim/features/payment/view/fragment/G$b;", "C1", "Lir/nasim/features/payment/view/fragment/G$b;", "type", "D1", "Lir/nasim/features/payment/data/model/CardToCardReceipt;", "E1", "Lir/nasim/features/payment/data/model/BalanceReceipt;", "Y8", "()Lir/nasim/bz2;", "binding", "F1", "a", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class G extends A implements C15196jA2.a {

    /* renamed from: F1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int G1 = 8;

    /* renamed from: A1, reason: from kotlin metadata */
    private J44 message;

    /* renamed from: B1, reason: from kotlin metadata */
    private C11458d25 peer;

    /* renamed from: C1, reason: from kotlin metadata */
    private b type;

    /* renamed from: D1, reason: from kotlin metadata */
    private CardToCardReceipt cardToCardReceipt;

    /* renamed from: E1, reason: from kotlin metadata */
    private BalanceReceipt balanceReceipt;

    /* renamed from: r1, reason: from kotlin metadata */
    private C10661bz2 _binding;

    /* renamed from: s1, reason: from kotlin metadata */
    public InterfaceC20667sP1 dialogRepository;

    /* renamed from: t1, reason: from kotlin metadata */
    public AbstractC13778go1 mainDispatcher;

    /* renamed from: u1, reason: from kotlin metadata */
    public C6409Nm analyticsRepository;

    /* renamed from: v1, reason: from kotlin metadata */
    public InterfaceC21103t7 adRepository;

    /* renamed from: w1, reason: from kotlin metadata */
    public InterfaceC17527n7 adEventRepository;

    /* renamed from: x1, reason: from kotlin metadata */
    private final C15196jA2 friendsAdapter = new C15196jA2();

    /* renamed from: y1, reason: from kotlin metadata */
    private final ArrayList selectedItemIds = new ArrayList();

    /* renamed from: z1, reason: from kotlin metadata */
    private B.b operationType;

    /* renamed from: ir.nasim.features.payment.view.fragment.G$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final G a(BalanceReceipt balanceReceipt) {
            AbstractC13042fc3.i(balanceReceipt, "balanceReceipt");
            G g = new G();
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_TYPE", b.b.ordinal());
            bundle.putParcelable("ARG_DATA", balanceReceipt);
            g.a8(bundle);
            return g;
        }

        public final G b(int i, byte[] bArr, Long l, CardToCardReceipt cardToCardReceipt) {
            AbstractC13042fc3.i(cardToCardReceipt, "cardToCardReceipt");
            G g = new G();
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_OPERATION_TYPE", i);
            if (bArr != null) {
                bundle.putByteArray("ARG_MESSAGE", bArr);
            }
            if (l != null) {
                bundle.putLong("ARG_PEER_UNIQUE_ID", l.longValue());
            }
            bundle.putInt("ARG_TYPE", b.a.ordinal());
            bundle.putParcelable("ARG_DATA", cardToCardReceipt);
            g.a8(bundle);
            return g;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class b {
        public static final b a = new b("CARD_TO_CARD", 0);
        public static final b b = new b("BALANCE", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C23564x80 a;
            final /* synthetic */ G b;

            /* renamed from: ir.nasim.features.payment.view.fragment.G$d$a$a, reason: collision with other inner class name */
            static final class C1187a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C23564x80 c;
                final /* synthetic */ G d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1187a(C23564x80 c23564x80, G g, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c23564x80;
                    this.d = g;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1187a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10156bA3 interfaceC10156bA3C = this.c.c();
                        Context contextS7 = this.d.S7();
                        this.b = 1;
                        if (InterfaceC10156bA3.b(interfaceC10156bA3C, contextS7, false, this, 2, null) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    this.d.V8().d(this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1187a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            a(C23564x80 c23564x80, G g) {
                this.a = c23564x80;
                this.b = g;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(G g, C23564x80 c23564x80) {
                AbstractC13042fc3.i(g, "this$0");
                AbstractC10533bm0.d(AbstractC19224pz3.a(g), null, null, new C1187a(c23564x80, g, null), 3, null);
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g10.c(interfaceC22053ub1, i2).b().e(), 0.0f, 0.0f, 13, null), 0.0f, 1, null), 4.3182f, false, 2, null);
                String strF = this.a.f();
                M46 m46D = N46.d(g10.c(interfaceC22053ub1, i2).a().b());
                interfaceC22053ub1.W(-1614520462);
                boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.a);
                final G g = this.b;
                final C23564x80 c23564x80 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.H
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return G.d.a.c(g, c23564x80);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                V03.c(eVarB, strF, m46D, (SA2) objB, null, null, null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
                this.b.V8().e(this.a);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return G.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC21103t7 interfaceC21103t7W8 = G.this.W8();
                this.b = 1;
                obj = interfaceC21103t7W8.e(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C23564x80 c23564x80 = (C23564x80) obj;
            if (c23564x80 != null && (c23564x80.c() instanceof InterfaceC10156bA3.a)) {
                G.this.Y8().b.setContent(AbstractC19242q11.c(926066164, true, new a(c23564x80, G.this)));
            }
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

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ G c;
            final /* synthetic */ List d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(G g, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = g;
                this.d = list;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.m9(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return G.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20667sP1 interfaceC20667sP1Z8 = G.this.Z8();
                this.b = 1;
                obj = interfaceC20667sP1Z8.s(100, 0, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC13778go1 abstractC13778go1A9 = G.this.a9();
            a aVar = new a(G.this, (List) obj, null);
            this.b = 2;
            if (AbstractC9323Zl0.g(abstractC13778go1A9, aVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10661bz2 Y8() {
        C10661bz2 c10661bz2 = this._binding;
        AbstractC13042fc3.f(c10661bz2);
        return c10661bz2;
    }

    private final void b9() {
        if ((!this.selectedItemIds.isEmpty()) && this.message != null && this.peer != null) {
            Iterator it = this.selectedItemIds.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                ArrayList arrayList = new ArrayList();
                J44 j44 = this.message;
                AbstractC13042fc3.f(j44);
                arrayList.add(j44);
                C11335cq c11335cqD = AbstractC5969Lp4.d();
                C11458d25 c11458d25E = C11458d25.E((int) jLongValue);
                C11458d25 c11458d25 = this.peer;
                AbstractC13042fc3.f(c11458d25);
                c11335cqD.K(c11458d25E, c11458d25, arrayList, null);
            }
        }
        Q7().finish();
        AbstractC16494lN1.a(this);
    }

    private final void c9(CardToCardReceipt cardToCardReceipt) {
        if (!C5505Jq.F()) {
            C21753u45 c21753u45 = C21753u45.a;
            FragmentActivity fragmentActivityQ7 = Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            C21753u45.O0(c21753u45, fragmentActivityQ7, 0, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
            return;
        }
        L60 l60 = new L60();
        C23057wH0 c23057wH0 = new C23057wH0();
        c23057wH0.h(cardToCardReceipt.getDate());
        c23057wH0.j(cardToCardReceipt.getDestCard());
        c23057wH0.m(cardToCardReceipt.getSrcCard());
        c23057wH0.k(cardToCardReceipt.getDestName());
        c23057wH0.i(cardToCardReceipt.getDescription());
        c23057wH0.n(cardToCardReceipt.getTraceNumber());
        c23057wH0.l(cardToCardReceipt.getMoneyAmount());
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        FragmentActivity fragmentActivityQ72 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ72, "requireActivity(...)");
        l60.a(contextS7, c23057wH0, fragmentActivityQ72);
        AbstractC16494lN1.a(this);
        i9(cardToCardReceipt.getTraceNumber());
        Q7().finish();
    }

    private final void d9() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new d(null), 3, null);
    }

    private final void e9() {
        if (C8386Vt0.u8()) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), C12366eV1.b(), null, new e(null), 2, null);
        } else {
            AbstractC5969Lp4.d().N().m0(new InterfaceC24449ye1() { // from class: ir.nasim.QI5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.payment.view.fragment.G.f9(this.a, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f9(G g, List list) {
        AbstractC13042fc3.i(g, "this$0");
        AbstractC13042fc3.i(list, "allDialogs");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((C17067mL1) it.next()).R().u()));
        }
        g.m9(arrayList);
    }

    private final void g9() {
        BalanceReceipt balanceReceipt;
        CardToCardReceipt cardToCardReceipt;
        Y8().z.setTypeface(C6011Lu2.i());
        Y8().k.setTypeface(C6011Lu2.k());
        Y8().x.setTypeface(C6011Lu2.k());
        Y8().n.setTypeface(C6011Lu2.k());
        Y8().o.setTypeface(C6011Lu2.k());
        Y8().w.setTypeface(C6011Lu2.k());
        Y8().l.setTypeface(C6011Lu2.k());
        Y8().m.setTypeface(C6011Lu2.k());
        Y8().p.setTypeface(C6011Lu2.i());
        Y8().v.setTypeface(C6011Lu2.i());
        Y8().s.setTypeface(C6011Lu2.i());
        Y8().t.setTypeface(C6011Lu2.i());
        Y8().u.setTypeface(C6011Lu2.i());
        Y8().q.setTypeface(C6011Lu2.i());
        Y8().r.setTypeface(C6011Lu2.i());
        Y8().y.setTypeface(C6011Lu2.i());
        Y8().c.setTypeface(C6011Lu2.i());
        Y8().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.OI5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.G.h9(this.a, view);
            }
        });
        b bVar = this.type;
        b bVar2 = null;
        if (bVar == null) {
            AbstractC13042fc3.y("type");
            bVar = null;
        }
        if (bVar == b.a && (cardToCardReceipt = this.cardToCardReceipt) != null) {
            AbstractC13042fc3.f(cardToCardReceipt);
            k9(cardToCardReceipt);
            return;
        }
        b bVar3 = this.type;
        if (bVar3 == null) {
            AbstractC13042fc3.y("type");
        } else {
            bVar2 = bVar3;
        }
        if (bVar2 != b.b || (balanceReceipt = this.balanceReceipt) == null) {
            return;
        }
        AbstractC13042fc3.f(balanceReceipt);
        j9(balanceReceipt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h9(G g, View view) {
        AbstractC13042fc3.i(g, "this$0");
        g.b9();
    }

    private final void i9(String traceNumber) {
        String name;
        try {
            X8().d("c2c_receipt_banner", AbstractC20051rO3.n(AbstractC4616Fw7.a("notif_id", Long.valueOf(Long.parseLong(traceNumber))), AbstractC4616Fw7.a("action_type", 3)));
        } catch (Exception e2) {
            if (G.class.isAnonymousClass()) {
                name = G.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = G.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e2);
        }
    }

    private final void j9(BalanceReceipt balanceReceipt) {
        StringBuilder sb = new StringBuilder();
        sb.append(balanceReceipt.getBalance());
        sb.append(Separators.RETURN);
        int length = sb.length();
        sb.append(h6(AbstractC12217eE5.card_balance));
        SpannableString spannableString = new SpannableString(sb);
        spannableString.setSpan(new RelativeSizeSpan(0.835f), length, sb.length(), 33);
        spannableString.setSpan(new C4619Fx1(C6011Lu2.k()), length, sb.length(), 33);
        Y8().z.setText(spannableString);
        Y8().k.setText(h6(AbstractC12217eE5.card_payment_balance_receipt_title_card_number));
        Y8().x.setText(h6(AbstractC12217eE5.card_payment_balance_receipt_title_bank));
        Y8().n.setText(h6(AbstractC12217eE5.card_payment_balance_receipt_title_restante));
        Y8().o.setText(h6(AbstractC12217eE5.card_payment_balance_receipt_title_restante_withdraw));
        Y8().w.setText(h6(AbstractC12217eE5.card_payment_balance_receipt_title_restante_salario));
        Y8().g.setVisibility(8);
        Y8().y.setVisibility(8);
        Y8().p.setText(balanceReceipt.getCardNumber());
        Y8().v.setText(balanceReceipt.getBankName());
        Y8().s.setText(balanceReceipt.getRealBalance());
        Y8().t.setText(balanceReceipt.getBalance());
        Y8().u.setText(balanceReceipt.getWage());
    }

    private final void k9(final CardToCardReceipt cardToCardReceipt) {
        Y8().y.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.PI5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.G.l9(this.a, cardToCardReceipt, view);
            }
        });
        String description = cardToCardReceipt.getDescription();
        if (description == null) {
            description = "";
        } else if (description.length() > 23) {
            description = AbstractC22039uZ6.A1(description, 17) + "...";
        }
        Y8().p.setText(cardToCardReceipt.getMoneyAmount());
        Y8().v.setText(cardToCardReceipt.getSrcCard());
        Y8().s.setText(cardToCardReceipt.getDestCard());
        Y8().t.setText(cardToCardReceipt.getDestName());
        Y8().u.setText(cardToCardReceipt.getTraceNumber());
        Y8().q.setText(cardToCardReceipt.getDate());
        Y8().r.setText(description);
        B.b bVar = this.operationType;
        B.b bVar2 = null;
        if (bVar == null) {
            AbstractC13042fc3.y("operationType");
            bVar = null;
        }
        if (bVar == B.b.a) {
            d9();
        }
        B.b bVar3 = this.operationType;
        if (bVar3 == null) {
            AbstractC13042fc3.y("operationType");
        } else {
            bVar2 = bVar3;
        }
        if (bVar2 != B.b.c || this.message == null) {
            return;
        }
        e9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l9(G g, CardToCardReceipt cardToCardReceipt, View view) {
        AbstractC13042fc3.i(g, "this$0");
        AbstractC13042fc3.i(cardToCardReceipt, "$cardToCardReceipt");
        g.c9(cardToCardReceipt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m9(List peerUniqueIds) {
        ArrayList arrayList = new ArrayList();
        int size = peerUniqueIds.size();
        for (int i = 0; i < size; i++) {
            C11458d25 c11458d25R = C11458d25.r(((Number) peerUniqueIds.get(i)).longValue());
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            if (c11458d25R.C() && c11458d25R.getPeerId() != AbstractC5969Lp4.f()) {
                long peerId = c11458d25R.getPeerId();
                C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(peerId);
                if (c21231tK7 != null && !((Boolean) c21231tK7.p().b()).booleanValue() && !c21231tK7.y() && !arrayList.contains(Long.valueOf(peerId)) && !((Boolean) c21231tK7.A().b()).booleanValue()) {
                    arrayList.add(Long.valueOf(peerId));
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Y8().y.setVisibility(8);
            Y8().d.setVisibility(0);
            Y8().j.setVisibility(0);
            Y8().i.setVisibility(0);
            Y8().j.setTypeface(C6011Lu2.i());
            this.friendsAdapter.C(this);
            this.friendsAdapter.z().clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.friendsAdapter.z().add(new C16969mA2(((Number) it.next()).longValue(), false, 2, null));
            }
            Y8().i.setAdapter(this.friendsAdapter);
            this.friendsAdapter.notifyItemRangeInserted(0, arrayList.size());
            RecyclerView recyclerView = Y8().i;
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            recyclerView.addItemDecoration(new C22527vO3(aVar.f(32.0f), aVar.f(32.0f), 0, 0, 0, 28, null));
        }
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.operationType = B.b.values()[bundleE5.getInt("ARG_OPERATION_TYPE")];
            if (bundleE5.getByteArray("ARG_MESSAGE") != null) {
                this.message = J44.v.a(bundleE5.getByteArray("ARG_MESSAGE"));
            }
            if (bundleE5.getLong("ARG_PEER_UNIQUE_ID", -1L) != -1) {
                this.peer = C11458d25.r(bundleE5.getLong("ARG_PEER_UNIQUE_ID"));
            }
            b bVar = b.values()[bundleE5.getInt("ARG_TYPE")];
            this.type = bVar;
            if (bVar == null) {
                AbstractC13042fc3.y("type");
                bVar = null;
            }
            int i = c.a[bVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                this.balanceReceipt = (BalanceReceipt) bundleE5.getParcelable("ARG_DATA");
            } else {
                Parcelable parcelable = bundleE5.getParcelable("ARG_DATA");
                AbstractC13042fc3.f(parcelable);
                this.cardToCardReceipt = (CardToCardReceipt) parcelable;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C10661bz2.c(inflater, container, false);
        return Y8().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    public final InterfaceC17527n7 V8() {
        InterfaceC17527n7 interfaceC17527n7 = this.adEventRepository;
        if (interfaceC17527n7 != null) {
            return interfaceC17527n7;
        }
        AbstractC13042fc3.y("adEventRepository");
        return null;
    }

    public final InterfaceC21103t7 W8() {
        InterfaceC21103t7 interfaceC21103t7 = this.adRepository;
        if (interfaceC21103t7 != null) {
            return interfaceC21103t7;
        }
        AbstractC13042fc3.y("adRepository");
        return null;
    }

    public final C6409Nm X8() {
        C6409Nm c6409Nm = this.analyticsRepository;
        if (c6409Nm != null) {
            return c6409Nm;
        }
        AbstractC13042fc3.y("analyticsRepository");
        return null;
    }

    public final InterfaceC20667sP1 Z8() {
        InterfaceC20667sP1 interfaceC20667sP1 = this.dialogRepository;
        if (interfaceC20667sP1 != null) {
            return interfaceC20667sP1;
        }
        AbstractC13042fc3.y("dialogRepository");
        return null;
    }

    public final AbstractC13778go1 a9() {
        AbstractC13778go1 abstractC13778go1 = this.mainDispatcher;
        if (abstractC13778go1 != null) {
            return abstractC13778go1;
        }
        AbstractC13042fc3.y("mainDispatcher");
        return null;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void j7() {
        Window window;
        Window window2;
        super.j7();
        if (y8() != null) {
            Dialog dialogY8 = y8();
            if (dialogY8 != null && (window2 = dialogY8.getWindow()) != null) {
                window2.setLayout(-1, -1);
            }
            Dialog dialogY82 = y8();
            if (dialogY82 != null && (window = dialogY82.getWindow()) != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            G8(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        g9();
    }

    @Override // ir.nasim.C15196jA2.a
    public void s5(C16969mA2 friend) {
        AbstractC13042fc3.i(friend, "friend");
        if (friend.b()) {
            this.selectedItemIds.add(Long.valueOf(friend.a()));
        } else {
            this.selectedItemIds.remove(Long.valueOf(friend.a()));
        }
        Drawable background = Y8().c.getBackground();
        if (this.selectedItemIds.isEmpty()) {
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            AbstractC21710u02.h(background, c5495Jo7.X());
            Y8().c.setTextColor(c5495Jo7.c0());
            Y8().c.setText(AbstractC12217eE5.card_payment_close);
        } else {
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            AbstractC21710u02.h(background, c5495Jo72.Y());
            Y8().c.setTextColor(c5495Jo72.b0());
            Y8().c.setText(AbstractC12217eE5.crowdfunding_send);
        }
        Y8().c.setBackground(background);
    }
}
