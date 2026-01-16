package ir.nasim;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C11680dQ3;
import ir.nasim.C12950fS3;
import ir.nasim.C14486i0;
import ir.nasim.C20096rT3;
import ir.nasim.C21753u45;
import ir.nasim.HQ3;
import ir.nasim.core.modules.market.model.Action;
import ir.nasim.core.modules.market.model.GetMarketDataResponse;
import ir.nasim.core.modules.market.model.MarketDialog;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketItemMore;
import ir.nasim.core.modules.market.model.MarketMenuItem;
import ir.nasim.core.modules.market.model.MarketPost;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.core.modules.market.model.MarketSlideItem;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import ir.nasim.features.root.RootActivity;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u007f2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002\u0080\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0016\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020%H\u0002¢\u0006\u0004\b*\u0010(J\u0017\u0010+\u001a\u00020\f2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b+\u0010(J\u001f\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020%H\u0002¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J+\u00109\u001a\u0002082\u0006\u00105\u001a\u0002042\b\u00107\u001a\u0004\u0018\u0001062\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b9\u0010:J!\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u0002082\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\fH\u0016¢\u0006\u0004\b>\u0010\u000bJ\u000f\u0010?\u001a\u00020\fH\u0016¢\u0006\u0004\b?\u0010\u000bJ\u0017\u0010A\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\bC\u0010\u001aJ\u0017\u0010D\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001bH\u0016¢\u0006\u0004\bD\u0010\u001dJ\u0017\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u001eH\u0016¢\u0006\u0004\bF\u0010 J\u001f\u0010H\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020G2\u0006\u0010E\u001a\u00020\u001eH\u0016¢\u0006\u0004\bH\u0010IJ\u001f\u0010K\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020J2\u0006\u0010E\u001a\u00020\u001eH\u0016¢\u0006\u0004\bK\u0010LJ\u001f\u0010N\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020M2\u0006\u0010E\u001a\u00020\u001eH\u0016¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020\f¢\u0006\u0004\bP\u0010\u000bJ\u0017\u0010R\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020QH\u0016¢\u0006\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001b\u0010_\u001a\u00020Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\"\u0010g\u001a\u00020`8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010o\u001a\u00020h8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010~\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}¨\u0006\u0081\u0001"}, d2 = {"Lir/nasim/dQ3;", "Lir/nasim/ua0;", "Lir/nasim/HQ3$a;", "Lir/nasim/rT3$a;", "Lir/nasim/hS3;", "Lir/nasim/iS3;", "Lir/nasim/gS3;", "Lir/nasim/fS3$c;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$j;", "Lir/nasim/fS3$b;", "<init>", "()V", "Lir/nasim/rB7;", "Ra", "pa", "ma", "ja", "", "ignoreVersionCheck", "qa", "(Z)V", "ya", "Na", "Lir/nasim/core/modules/market/model/MarketMenuItem;", "item", "Oa", "(Lir/nasim/core/modules/market/model/MarketMenuItem;)V", "Lir/nasim/core/modules/market/model/MarketSlideItem;", "Qa", "(Lir/nasim/core/modules/market/model/MarketSlideItem;)V", "Lir/nasim/core/modules/market/model/MarketSection;", "Pa", "(Lir/nasim/core/modules/market/model/MarketSection;)V", "Lir/nasim/core/modules/market/model/Action;", "action", "Ea", "(Lir/nasim/core/modules/market/model/Action;)V", "", "url", "Ma", "(Ljava/lang/String;)V", "nick", "Ha", "Fa", "", "id", "Ga", "(JLjava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "H1", "R6", "", "x2", "(Ljava/lang/Object;)V", "s0", "U4", "row", "a3", "Lir/nasim/core/modules/market/model/MarketItem;", TokenNames.C, "(Lir/nasim/core/modules/market/model/MarketItem;Lir/nasim/core/modules/market/model/MarketSection;)V", "Lir/nasim/core/modules/market/model/MarketProductItem;", "k", "(Lir/nasim/core/modules/market/model/MarketProductItem;Lir/nasim/core/modules/market/model/MarketSection;)V", "Lir/nasim/core/modules/market/model/MarketItemMore;", "x", "(Lir/nasim/core/modules/market/model/MarketItemMore;Lir/nasim/core/modules/market/model/MarketSection;)V", "xa", "Lir/nasim/mS3;", "g3", "(Lir/nasim/mS3;)V", "Lir/nasim/wy2;", "h1", "Lir/nasim/bW7;", "la", "()Lir/nasim/wy2;", "binding", "Lir/nasim/iU3;", "i1", "Lir/nasim/Yu3;", "wa", "()Lir/nasim/iU3;", "viewModel", "Lir/nasim/iR3;", "j1", "Lir/nasim/iR3;", "oa", "()Lir/nasim/iR3;", "setMarketNavigator", "(Lir/nasim/iR3;)V", "marketNavigator", "Lir/nasim/zP5;", "k1", "Lir/nasim/zP5;", "va", "()Lir/nasim/zP5;", "setReportNavigator", "(Lir/nasim/zP5;)V", "reportNavigator", "Lir/nasim/core/modules/market/model/GetMarketDataResponse;", "l1", "Lir/nasim/core/modules/market/model/GetMarketDataResponse;", "data", "Lir/nasim/fS3;", "m1", "Lir/nasim/fS3;", "rowsItemAdapter", "Lir/nasim/uQ3;", "n1", "Lir/nasim/uQ3;", "marketHeaderAdapter", "o1", "Z", "isChannelLoading", "p1", "a", "market_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.dQ3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11680dQ3 extends XW2 implements HQ3.a, C20096rT3.a, InterfaceC14159hS3, InterfaceC14770iS3, InterfaceC13568gS3, C12950fS3.c, SwipeRefreshLayout.j, C12950fS3.b {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new j(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC14761iR3 marketNavigator;

    /* renamed from: k1, reason: from kotlin metadata */
    public InterfaceC24908zP5 reportNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    private GetMarketDataResponse data;

    /* renamed from: m1, reason: from kotlin metadata */
    private C12950fS3 rowsItemAdapter;

    /* renamed from: n1, reason: from kotlin metadata */
    private C21955uQ3 marketHeaderAdapter;

    /* renamed from: o1, reason: from kotlin metadata */
    private boolean isChannelLoading;
    static final /* synthetic */ InterfaceC5239Im3[] q1 = {AbstractC10882cM5.i(new C25226zw5(C11680dQ3.class, "binding", "getBinding()Lir/nasim/databinding/FragmentMarketBinding;", 0))};
    public static final int r1 = 8;

    /* renamed from: ir.nasim.dQ3$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[QO3.values().length];
            try {
                iArr[QO3.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QO3.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QO3.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.dQ3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11680dQ3.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(500L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            GetMarketDataResponse getMarketDataResponse = C11680dQ3.this.data;
            if (getMarketDataResponse != null) {
                C11680dQ3.this.wa().h1(getMarketDataResponse);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dQ3$d */
    public static final class d extends RecyclerView.t {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (AbstractC13042fc3.d(recyclerView.getTag(), 1) || recyclerView.canScrollVertically(1) || i != 0) {
                return;
            }
            recyclerView.setTag(1);
            C21946uP3 c21946uP3 = new C21946uP3(20, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null);
            C3343Am.i("market_page", c21946uP3.a());
            C3343Am.j("market_page", c21946uP3.b());
        }
    }

    /* renamed from: ir.nasim.dQ3$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11680dQ3.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C11680dQ3.this.Ma("https://tooshle.bale.ai/seller");
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dQ3$f */
    static final class f implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        f(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* renamed from: ir.nasim.dQ3$g */
    static final class g implements InterfaceC15796kB2 {
        final /* synthetic */ MarketMenuItem a;

        /* renamed from: ir.nasim.dQ3$g$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ MarketMenuItem a;

            a(MarketMenuItem marketMenuItem) {
                this.a = marketMenuItem;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                MarketDialog dialog = this.a.getDialog();
                String title = dialog != null ? dialog.getTitle() : null;
                if (title == null) {
                    title = "";
                }
                String str = title;
                Integer dialogDrawableIdResource = this.a.getDialogDrawableIdResource();
                AbstractC13042fc3.f(dialogDrawableIdResource);
                AbstractC19555qZ.v0(str, null, FV4.c(dialogDrawableIdResource.intValue(), interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, 27648, 2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.dQ3$g$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ MarketMenuItem a;

            b(MarketMenuItem marketMenuItem) {
                this.a = marketMenuItem;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                MarketDialog dialog = this.a.getDialog();
                String description = dialog != null ? dialog.getDescription() : null;
                if (description == null) {
                    description = "";
                }
                AbstractC19555qZ.e0(description, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        g(MarketMenuItem marketMenuItem) {
            this.a = marketMenuItem;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1046145403, true, new a(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1027875399, true, new b(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-734152998);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.eQ3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C11680dQ3.g.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, null, null, (SA2) objB, AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dQ3$h */
    static final class h implements InterfaceC15796kB2 {
        final /* synthetic */ MarketSection a;

        /* renamed from: ir.nasim.dQ3$h$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ MarketSection a;

            a(MarketSection marketSection) {
                this.a = marketSection;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                MarketDialog dialog = this.a.getDialog();
                String title = dialog != null ? dialog.getTitle() : null;
                if (title == null) {
                    title = "";
                }
                AbstractC19555qZ.v0(title, null, FV4.c(this.a.getDialogDrawableIdResource(), interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, 27648, 2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.dQ3$h$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ MarketSection a;

            b(MarketSection marketSection) {
                this.a = marketSection;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                MarketDialog dialog = this.a.getDialog();
                String description = dialog != null ? dialog.getDescription() : null;
                if (description == null) {
                    description = "";
                }
                AbstractC19555qZ.e0(description, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        h(MarketSection marketSection) {
            this.a = marketSection;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1571851350, true, new a(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1302685972, true, new b(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(1384309172);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.fQ3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C11680dQ3.h.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, null, null, (SA2) objB, AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dQ3$i */
    static final class i implements InterfaceC15796kB2 {
        final /* synthetic */ MarketSlideItem a;

        /* renamed from: ir.nasim.dQ3$i$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ MarketSlideItem a;

            a(MarketSlideItem marketSlideItem) {
                this.a = marketSlideItem;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                MarketDialog dialog = this.a.getDialog();
                String title = dialog != null ? dialog.getTitle() : null;
                if (title == null) {
                    title = "";
                }
                AbstractC19555qZ.B0(title, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.dQ3$i$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ MarketSlideItem a;

            b(MarketSlideItem marketSlideItem) {
                this.a = marketSlideItem;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                MarketDialog dialog = this.a.getDialog();
                String description = dialog != null ? dialog.getDescription() : null;
                if (description == null) {
                    description = "";
                }
                AbstractC19555qZ.e0(description, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        i(MarketSlideItem marketSlideItem) {
            this.a = marketSlideItem;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(986859407, true, new a(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1232667281, true, new b(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(779467580);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.gQ3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C11680dQ3.i.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, null, (SA2) objB, AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dQ3$j */
    public static final class j extends AbstractC8614Ws3 implements UA2 {
        public j() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C23467wy2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.dQ3$k */
    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.dQ3$l */
    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.dQ3$m */
    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.dQ3$n */
    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.dQ3$o */
    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C11680dQ3() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new l(new k(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C14788iU3.class), new m(interfaceC9173Yu3B), new n(null, interfaceC9173Yu3B), new o(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(Object obj) {
        AbstractC13042fc3.i(obj, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(C11680dQ3 c11680dQ3) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        AbstractC10533bm0.d(AbstractC16751lo1.a(c11680dQ3), null, null, c11680dQ3.new e(null), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(Object obj, final C11680dQ3 c11680dQ3, String str, Bundle bundle) {
        final OP5 op5;
        Integer groupId;
        MarketPost marketPost;
        Integer groupId2;
        AbstractC13042fc3.i(obj, "$item");
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        if (Build.VERSION.SDK_INT >= 33) {
            op5 = (OP5) bundle.getSerializable("report_type_result_key", OP5.class);
        } else {
            Serializable serializable = bundle.getSerializable("report_type_result_key");
            op5 = serializable instanceof OP5 ? (OP5) serializable : null;
        }
        if (op5 == null) {
            return;
        }
        final int iIntValue = 0;
        int i2 = bundle.getInt("market_report_title_result_key", 0);
        if (obj instanceof MarketItem) {
            ArrayList<MarketPost> posts = ((MarketItem) obj).getPosts();
            if (posts != null && (marketPost = (MarketPost) AbstractC15401jX0.s0(posts)) != null && (groupId2 = marketPost.getGroupId()) != null) {
                iIntValue = groupId2.intValue();
            }
        } else if ((obj instanceof MarketProductItem) && (groupId = ((MarketProductItem) obj).getPost().getGroupId()) != null) {
            iIntValue = groupId.intValue();
        }
        Context contextS7 = c11680dQ3.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = c11680dQ3.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        C24398yZ.k(contextS7, interfaceC18633oz3P6, i2, false, null, new UA2() { // from class: ir.nasim.ZP3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj2) {
                return C11680dQ3.Da(this.a, iIntValue, op5, (String) obj2);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Da(C11680dQ3 c11680dQ3, int i2, OP5 op5, String str) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        AbstractC13042fc3.i(op5, "$selectedReportType");
        AbstractC13042fc3.i(str, "reportDescription");
        c11680dQ3.wa().j1(str, i2, op5);
        return C19938rB7.a;
    }

    private final void Ea(Action action) {
        String url;
        int i2 = b.a[QO3.values()[action.getType()].ordinal()];
        if (i2 == 1) {
            String url2 = action.getUrl();
            if (url2 != null) {
                Ma(url2);
                return;
            }
            return;
        }
        if (i2 != 2) {
            if (i2 == 3 && (url = action.getUrl()) != null) {
                Fa(url);
                return;
            }
            return;
        }
        String url3 = action.getUrl();
        if (url3 != null) {
            Ha(url3);
        }
    }

    private final void Fa(String url) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c18987pb3.k0(intent, fragmentActivityQ7);
    }

    private final void Ga(long id, final String nick) {
        if (this.isChannelLoading) {
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (C4100Dr4.a(contextS7)) {
            this.isChannelLoading = true;
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            final ProgressDialog progressDialogE = C8920Xu5.e(contextS72, true);
            progressDialogE.setCancelable(false);
            AbstractC5969Lp4.b().k(id).m0(new InterfaceC24449ye1() { // from class: ir.nasim.VP3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C11680dQ3.Ia(this.a, nick, progressDialogE, (C14733iO2) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.WP3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C11680dQ3.Ka(this.a, nick, progressDialogE, (Exception) obj);
                }
            });
            return;
        }
        LinearLayout root = la().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(la().f);
        String strH6 = h6(AbstractC12217eE5.card_payment_please_check_your_internet_conenction);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10.o(strH6);
    }

    private final void Ha(String nick) {
        C5735Kp4.w().J(S7(), nick, "market");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(final C11680dQ3 c11680dQ3, String str, ProgressDialog progressDialog, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        if (c14733iO2 != null) {
            C11458d25 c11458d25 = new C11458d25(W25.b, c14733iO2.r());
            C5735Kp4.w().o(c11458d25);
            C18987pb3.a.y1(c11458d25, null, null, false, "market");
        } else {
            C5735Kp4.w().J(c11680dQ3.S7(), str, "market");
        }
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.XP3
            @Override // java.lang.Runnable
            public final void run() {
                C11680dQ3.Ja(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(C11680dQ3 c11680dQ3) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        c11680dQ3.isChannelLoading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(final C11680dQ3 c11680dQ3, String str, ProgressDialog progressDialog, Exception exc) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        C5735Kp4.w().J(c11680dQ3.S7(), str, "market");
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.YP3
            @Override // java.lang.Runnable
            public final void run() {
                C11680dQ3.La(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(C11680dQ3 c11680dQ3) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        c11680dQ3.isChannelLoading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma(String url) {
        C14486i0.a aVar = C14486i0.f;
        AppCompatActivity appCompatActivity = (AppCompatActivity) Q7();
        AbstractC13042fc3.f(appCompatActivity);
        C14486i0 c14486i0A = aVar.a(appCompatActivity);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (!C4100Dr4.a(contextS7)) {
            Toast.makeText(S7(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            return;
        }
        Context contextS72 = S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        RootActivity rootActivity = (RootActivity) A5();
        AbstractC13042fc3.f(rootActivity);
        c14486i0A.o(new BottomSheetWebView(contextS72, rootActivity, url, c14486i0A, null, null, 32, null));
    }

    private final void Na() {
        ArrayList<Object> structuredData;
        GetMarketDataResponse getMarketDataResponse = this.data;
        C12950fS3 c12950fS3 = null;
        if (getMarketDataResponse != null && (structuredData = getMarketDataResponse.getStructuredData()) != null) {
            C12950fS3 c12950fS32 = this.rowsItemAdapter;
            if (c12950fS32 == null) {
                AbstractC13042fc3.y("rowsItemAdapter");
                c12950fS32 = null;
            }
            c12950fS32.z().clear();
            C12950fS3 c12950fS33 = this.rowsItemAdapter;
            if (c12950fS33 == null) {
                AbstractC13042fc3.y("rowsItemAdapter");
                c12950fS33 = null;
            }
            c12950fS33.z().addAll(structuredData);
        }
        C12950fS3 c12950fS34 = this.rowsItemAdapter;
        if (c12950fS34 == null) {
            AbstractC13042fc3.y("rowsItemAdapter");
        } else {
            c12950fS3 = c12950fS34;
        }
        c12950fS3.notifyDataSetChanged();
        if (wa().g1()) {
            return;
        }
        wa().k1(true);
        wa().i1();
    }

    private final void Oa(MarketMenuItem item) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1209384490, true, new g(item)), 4, null).show();
    }

    private final void Pa(MarketSection item) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-469175995, true, new h(item)), 4, null).show();
    }

    private final void Qa(MarketSlideItem item) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(2139521152, true, new i(item)), 4, null).show();
    }

    private final void Ra() {
        if (wa().o1() && C7183Qq.p().getInt("counter_of_show_market_fragment", 0) > 0) {
            new C17671nM5().K8(Q7().B0(), null);
        } else if (AbstractC5969Lp4.e().S().B5(EnumC4716Gg2.D)) {
            ja();
        }
    }

    private final void ja() {
        wa().l1().j(p6(), new f(new UA2() { // from class: ir.nasim.RP3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C11680dQ3.ka(this.a, (Boolean) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ka(C11680dQ3 c11680dQ3, Boolean bool) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        if (bool.booleanValue()) {
            C22042ua0.A9(c11680dQ3, new C16514lP3(), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    private final C23467wy2 la() {
        Object objA = this.binding.a(this, q1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C23467wy2) objA;
    }

    private final void ma() {
        la().d.setVisibility(0);
        wa().c1().j(p6(), new f(new UA2() { // from class: ir.nasim.SP3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C11680dQ3.na(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 na(C11680dQ3 c11680dQ3, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        if (c5354Iz1.c() || c5354Iz1.a() == null) {
            ra(c11680dQ3, false, 1, null);
        } else {
            c11680dQ3.data = (GetMarketDataResponse) c5354Iz1.a();
            c11680dQ3.Na();
            AbstractC10533bm0.d(AbstractC16751lo1.a(c11680dQ3), null, null, c11680dQ3.new c(null), 3, null);
            c11680dQ3.la().d.setVisibility(8);
            ra(c11680dQ3, false, 1, null);
        }
        return C19938rB7.a;
    }

    private final void pa() {
        if (Build.VERSION.SDK_INT >= 30 || C5505Jq.F()) {
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        Integer numValueOf = Integer.valueOf(AbstractC12217eE5.market_permission);
        C21753u45.d dVar = C21753u45.d.m;
        C21753u45.R0(c21753u45, this, 0, numValueOf, null, null, new C21753u45.d[]{dVar, C21753u45.d.j, dVar}, 24, null);
    }

    private final void qa(boolean ignoreVersionCheck) {
        InterfaceC10952cU3.H(wa(), 0, 0, 0, false, ignoreVersionCheck, 15, null).j(p6(), new f(new UA2() { // from class: ir.nasim.aQ3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C11680dQ3.sa(this.a, (C5354Iz1) obj);
            }
        }));
    }

    static /* synthetic */ void ra(C11680dQ3 c11680dQ3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        c11680dQ3.qa(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(final C11680dQ3 c11680dQ3, final C5354Iz1 c5354Iz1) {
        GetMarketDataResponse getMarketDataResponse;
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        if (!c5354Iz1.c() && (getMarketDataResponse = (GetMarketDataResponse) c5354Iz1.a()) != null) {
            c11680dQ3.wa().h1(getMarketDataResponse).j(c11680dQ3.p6(), new f(new UA2() { // from class: ir.nasim.TP3
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C11680dQ3.ta(this.a, c5354Iz1, (C5354Iz1) obj);
                }
            }));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(final C11680dQ3 c11680dQ3, C5354Iz1 c5354Iz1, C5354Iz1 c5354Iz12) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        if (!c5354Iz12.c()) {
            c11680dQ3.data = (GetMarketDataResponse) c5354Iz1.a();
            c11680dQ3.Na();
            c11680dQ3.la().e.post(new Runnable() { // from class: ir.nasim.PP3
                @Override // java.lang.Runnable
                public final void run() {
                    C11680dQ3.ua(this.a);
                }
            });
            c11680dQ3.la().d.setVisibility(8);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(C11680dQ3 c11680dQ3) {
        AbstractC13042fc3.i(c11680dQ3, "this$0");
        c11680dQ3.la().e.smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C14788iU3 wa() {
        return (C14788iU3) this.viewModel.getValue();
    }

    private final void ya() {
        RecyclerView recyclerView = la().e;
        C21955uQ3 c21955uQ3 = this.marketHeaderAdapter;
        C12950fS3 c12950fS3 = null;
        if (c21955uQ3 == null) {
            AbstractC13042fc3.y("marketHeaderAdapter");
            c21955uQ3 = null;
        }
        C12950fS3 c12950fS32 = this.rowsItemAdapter;
        if (c12950fS32 == null) {
            AbstractC13042fc3.y("rowsItemAdapter");
            c12950fS32 = null;
        }
        recyclerView.setAdapter(new androidx.recyclerview.widget.f(c21955uQ3, c12950fS32));
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        recyclerView.addItemDecoration(new C21937uO3(aVar.f(10.0f), aVar.f(24.0f), aVar.f(16.0f), 0, 0, 24, null));
        recyclerView.setTag(0);
        recyclerView.addOnScrollListener(new d());
        C12950fS3 c12950fS33 = this.rowsItemAdapter;
        if (c12950fS33 == null) {
            AbstractC13042fc3.y("rowsItemAdapter");
        } else {
            c12950fS3 = c12950fS33;
        }
        c12950fS3.B(this);
        c12950fS3.E(this);
        c12950fS3.A(this);
        c12950fS3.G(this);
        c12950fS3.D(this);
        c12950fS3.F(this);
        c12950fS3.C(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 za(Object obj) {
        AbstractC13042fc3.i(obj, "it");
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC14159hS3
    public void C(MarketItem item, MarketSection row) {
        AbstractC13042fc3.i(item, "item");
        AbstractC13042fc3.i(row, "row");
        Ga(item.getId(), item.getUrl());
        C3343Am.e("market_item_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("peer_id", String.valueOf(item.getId())), AbstractC4616Fw7.a("row_title", row.getTitle()), AbstractC4616Fw7.a("service_id", "15")));
        C21946uP3 c21946uP3 = new C21946uP3(1, Integer.valueOf(row.getId()), null, row.getTitle(), null, null, null, Long.valueOf(item.getId()), null, null, null, null, Integer.valueOf(row.getPosition()), Integer.valueOf(row.getItems().indexOf(item)), 0, 3956, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void H1() {
        C21946uP3 c21946uP3 = new C21946uP3(40, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
        qa(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        this.rowsItemAdapter = new C12950fS3((wa().o1() || wa().p1() || !C8386Vt0.a.U3()) ? false : true, new UA2() { // from class: ir.nasim.bQ3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C11680dQ3.za(obj);
            }
        }, new UA2() { // from class: ir.nasim.cQ3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C11680dQ3.Aa(obj);
            }
        });
        this.marketHeaderAdapter = new C21955uQ3(new SA2() { // from class: ir.nasim.QP3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C11680dQ3.Ba(this.a);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        LinearLayout root = C23467wy2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        la().e.setAdapter(null);
        super.R6();
    }

    @Override // ir.nasim.C20096rT3.a
    public void U4(MarketSlideItem item) {
        AbstractC13042fc3.i(item, "item");
        if (item.getAction() != null || item.getDialog() == null) {
            Action action = item.getAction();
            AbstractC13042fc3.f(action);
            Ea(action);
        } else {
            Qa(item);
        }
        C3343Am.e("market_banner_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("item_url", item.getImageUrl()), AbstractC4616Fw7.a("service_id", "15")));
        int id = item.getId();
        Action action2 = item.getAction();
        Long id2 = action2 != null ? action2.getId() : null;
        Action action3 = item.getAction();
        String url = action3 != null ? action3.getUrl() : null;
        C21946uP3 c21946uP3 = new C21946uP3(0, null, null, null, null, Integer.valueOf(id), url, id2, null, null, null, item.getUrlPathOnly(), null, null, null, 30494, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    @Override // ir.nasim.InterfaceC13568gS3
    public void a3(MarketSection row) {
        AbstractC13042fc3.i(row, "row");
        Pa(row);
        C21946uP3 c21946uP3 = new C21946uP3(3, null, null, null, null, Integer.valueOf(row.getId()), null, null, null, null, null, null, null, null, null, 32734, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    @Override // ir.nasim.C12950fS3.c
    public void g3(C17132mS3 item) {
        AbstractC13042fc3.i(item, "item");
        C22042ua0.A9(this, oa().b(), false, null, 6, null);
    }

    @Override // ir.nasim.InterfaceC14159hS3
    public void k(MarketProductItem item, MarketSection row) {
        AbstractC13042fc3.i(item, "item");
        AbstractC13042fc3.i(row, "row");
        Fa(item.getUrl());
        int i2 = row.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber() ? 1 : 2;
        int id = row.getId();
        int id2 = row.getId();
        Long lValueOf = item.getPost().getGroupId() != null ? Long.valueOf(r6.intValue()) : null;
        String title = row.getTitle();
        String urlPathOnly = item.getUrlPathOnly();
        int position = row.getPosition();
        ArrayList<MarketProductItem> products = row.getProducts();
        C21946uP3 c21946uP3 = new C21946uP3(4, Integer.valueOf(id), null, title, null, Integer.valueOf(id2), null, lValueOf, null, null, null, urlPathOnly, Integer.valueOf(position), products != null ? Integer.valueOf(products.indexOf(item)) : null, Integer.valueOf(i2), 1876, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ya();
        ma();
        pa();
        Ra();
    }

    public final InterfaceC14761iR3 oa() {
        InterfaceC14761iR3 interfaceC14761iR3 = this.marketNavigator;
        if (interfaceC14761iR3 != null) {
            return interfaceC14761iR3;
        }
        AbstractC13042fc3.y("marketNavigator");
        return null;
    }

    @Override // ir.nasim.HQ3.a
    public void s0(MarketMenuItem item) {
        AbstractC13042fc3.i(item, "item");
        if (item.isDisable() || (item.getAction() == null && item.getDialog() != null)) {
            Oa(item);
        } else if (item.getAction() != null) {
            Action action = item.getAction();
            AbstractC13042fc3.f(action);
            Ea(action);
        }
        C3343Am.e("market_menu_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("item_title", item.getTitle()), AbstractC4616Fw7.a("service_id", "15")));
        int id = item.getId();
        String title = item.getTitle();
        Action action2 = item.getAction();
        Long id2 = action2 != null ? action2.getId() : null;
        Action action3 = item.getAction();
        C21946uP3 c21946uP3 = new C21946uP3(2, null, null, null, title, Integer.valueOf(id), action3 != null ? action3.getUrl() : null, id2, null, Integer.valueOf(!item.isDisable() ? 1 : 0), null, null, null, null, null, 32014, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    public final InterfaceC24908zP5 va() {
        InterfaceC24908zP5 interfaceC24908zP5 = this.reportNavigator;
        if (interfaceC24908zP5 != null) {
            return interfaceC24908zP5;
        }
        AbstractC13042fc3.y("reportNavigator");
        return null;
    }

    @Override // ir.nasim.InterfaceC14770iS3
    public void x(MarketItemMore item, MarketSection row) {
        AbstractC13042fc3.i(item, "item");
        AbstractC13042fc3.i(row, "row");
        C22042ua0.A9(this, C7359Rj4.y1.a(row), false, null, 6, null);
    }

    @Override // ir.nasim.C12950fS3.b
    public void x2(final Object item) {
        AbstractC13042fc3.i(item, "item");
        if (C8386Vt0.a.U3()) {
            F5().z("market_report_result_key");
            F5().H1("market_report_result_key", this, new InterfaceC13295fz2() { // from class: ir.nasim.UP3
                @Override // ir.nasim.InterfaceC13295fz2
                public final void a(String str, Bundle bundle) {
                    C11680dQ3.Ca(item, this, str, bundle);
                }
            });
            InterfaceC24908zP5.b(va(), "market_report_result_key", "market_report_title_result_key", "report_type_result_key", null, 8, null).K8(F5(), null);
        }
    }

    public final void xa() {
        la().e.smoothScrollToPosition(0);
    }
}
