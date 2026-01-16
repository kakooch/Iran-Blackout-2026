package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C12950fS3;
import ir.nasim.C23731xQ3;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketPost;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.market.util.NpaGridLayoutManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* renamed from: ir.nasim.Rj4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7359Rj4 extends AbstractC11742dX2 implements C23731xQ3.b, C12950fS3.b, SwipeRefreshLayout.j {
    private final InterfaceC10358bW7 h1;
    private final InterfaceC9173Yu3 i1;
    public InterfaceC14761iR3 j1;
    public InterfaceC24908zP5 k1;
    private MarketSection l1;
    private final InterfaceC9173Yu3 m1;
    private boolean n1;
    private int o1;
    private boolean p1;
    private final InterfaceC9173Yu3 q1;
    private int r1;
    private int s1;
    private int t1;
    private int u1;
    private final InterfaceC9173Yu3 v1;
    private final InterfaceC9173Yu3 w1;
    private final c x1;
    static final /* synthetic */ InterfaceC5239Im3[] z1 = {AbstractC10882cM5.i(new C25226zw5(C7359Rj4.class, "binding", "getBinding()Lir/nasim/databinding/FragmentMoreMarketItemsBinding;", 0))};
    public static final a y1 = new a(null);
    public static final int A1 = 8;

    /* renamed from: ir.nasim.Rj4$a */
    public static final class a {
        private a() {
        }

        public final C7359Rj4 a(MarketSection marketSection) {
            AbstractC13042fc3.i(marketSection, "row");
            C7359Rj4 c7359Rj4 = new C7359Rj4(null);
            c7359Rj4.l1 = marketSection;
            return c7359Rj4;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Rj4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7359Rj4.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C7359Rj4.this.Fa().d.setRefreshing(false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Rj4$c */
    public static final class c extends RecyclerView.t {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.b(recyclerView, i, i2);
            try {
                if (recyclerView.canScrollVertically(1)) {
                    return;
                }
                C7359Rj4.this.s1 = recyclerView.getChildCount();
                RecyclerView.p layoutManager = C7359Rj4.this.Fa().c.getLayoutManager();
                AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type ir.nasim.market.util.NpaGridLayoutManager");
                NpaGridLayoutManager npaGridLayoutManager = (NpaGridLayoutManager) layoutManager;
                C7359Rj4.this.t1 = npaGridLayoutManager.Z();
                C7359Rj4.this.r1 = npaGridLayoutManager.d2();
                if (C7359Rj4.this.Ha() && C7359Rj4.this.t1 > C7359Rj4.this.o1) {
                    C7359Rj4.this.lb(false);
                    C7359Rj4 c7359Rj4 = C7359Rj4.this;
                    c7359Rj4.o1 = c7359Rj4.t1;
                }
                if (C7359Rj4.this.Ha() || C7359Rj4.this.t1 - C7359Rj4.this.s1 > C7359Rj4.this.r1 + C7359Rj4.this.Qa()) {
                    return;
                }
                C7359Rj4.this.Ta();
                MarketSection marketSection = C7359Rj4.this.l1;
                MarketSection marketSection2 = null;
                if (marketSection == null) {
                    AbstractC13042fc3.y("row");
                    marketSection = null;
                }
                String title = marketSection.getTitle();
                MarketSection marketSection3 = C7359Rj4.this.l1;
                if (marketSection3 == null) {
                    AbstractC13042fc3.y("row");
                } else {
                    marketSection2 = marketSection3;
                }
                C21946uP3 c21946uP3 = new C21946uP3(30, null, null, title, null, Integer.valueOf(marketSection2.getId()), null, null, null, null, null, null, null, null, null, 32726, null);
                C3343Am.i("market_page", c21946uP3.a());
                C3343Am.j("market_page", c21946uP3.b());
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
        }
    }

    /* renamed from: ir.nasim.Rj4$d */
    static final class d implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        d(UA2 ua2) {
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

    /* renamed from: ir.nasim.Rj4$e */
    public static final class e extends AbstractC8614Ws3 implements UA2 {
        public e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C5112Hy2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Rj4$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Rj4$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Rj4$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Rj4$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Rj4$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public /* synthetic */ C7359Rj4(ED1 ed1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(Object obj) {
        AbstractC13042fc3.i(obj, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(Object obj) {
        AbstractC13042fc3.i(obj, "it");
        return C19938rB7.a;
    }

    private final void Ca(C7359Rj4 c7359Rj4) {
        SwipeRefreshLayout swipeRefreshLayout = Fa().d;
        swipeRefreshLayout.setOnRefreshListener(c7359Rj4);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(c5495Jo7.i0());
        swipeRefreshLayout.setColorSchemeColors(c5495Jo7.t2());
        swipeRefreshLayout.setAnimation(null);
    }

    private final void Da() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(null), 3, null);
    }

    private final C23731xQ3 Ea() {
        return (C23731xQ3) this.m1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5112Hy2 Fa() {
        Object objA = this.h1.a(this, z1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C5112Hy2) objA;
    }

    private final C11634dL2 Ga() {
        return (C11634dL2) this.w1.getValue();
    }

    private final void Ja() {
        final int size = Ea().z().size();
        C12332eR3 c12332eR3Pa = Pa();
        MarketSection marketSection = this.l1;
        if (marketSection == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        }
        c12332eR3Pa.W0(marketSection.getId(), Qa(), this.u1).j(p6(), new d(new UA2() { // from class: ir.nasim.xj4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7359Rj4.Ka(this.a, size, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ka(C7359Rj4 c7359Rj4, int i2, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        if (c5354Iz1.c() || c5354Iz1.a() == null) {
            c7359Rj4.Da();
        } else {
            Object objA = c5354Iz1.a();
            AbstractC13042fc3.f(objA);
            if (((ArrayList) objA).isEmpty()) {
                c7359Rj4.Fa().c.removeOnScrollListener(c7359Rj4.x1);
                c7359Rj4.Da();
                MarketSection marketSection = c7359Rj4.l1;
                MarketSection marketSection2 = null;
                if (marketSection == null) {
                    AbstractC13042fc3.y("row");
                    marketSection = null;
                }
                String title = marketSection.getTitle();
                MarketSection marketSection3 = c7359Rj4.l1;
                if (marketSection3 == null) {
                    AbstractC13042fc3.y("row");
                } else {
                    marketSection2 = marketSection3;
                }
                C21946uP3 c21946uP3 = new C21946uP3(21, null, null, title, null, Integer.valueOf(marketSection2.getId()), null, null, null, null, null, null, null, null, null, 32726, null);
                C3343Am.i("market_page", c21946uP3.a());
                C3343Am.j("market_page", c21946uP3.b());
            } else {
                AbstractC13042fc3.f(c5354Iz1);
                c7359Rj4.Ua(c5354Iz1, i2);
            }
        }
        return C19938rB7.a;
    }

    private final void La() {
        final int size = Ea().z().size();
        MarketSection marketSection = this.l1;
        MarketSection marketSection2 = null;
        if (marketSection == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        }
        if (marketSection.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber()) {
            if (this.u1 == 0) {
                Pa().f0(0, true);
            } else {
                XQ3.W(Pa(), this.u1, false, 2, null);
            }
        }
        if (AbstractC5969Lp4.e().S().B5(EnumC4716Gg2.Y)) {
            J9("Request for page " + this.u1);
        }
        C12332eR3 c12332eR3Pa = Pa();
        MarketSection marketSection3 = this.l1;
        if (marketSection3 == null) {
            AbstractC13042fc3.y("row");
        } else {
            marketSection2 = marketSection3;
        }
        c12332eR3Pa.Z0(marketSection2.getId(), Qa(), this.u1).j(p6(), new d(new UA2() { // from class: ir.nasim.Ij4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7359Rj4.Ma(this.a, size, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ma(C7359Rj4 c7359Rj4, int i2, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        if (!c5354Iz1.c() && c5354Iz1.a() != null) {
            Object objA = c5354Iz1.a();
            AbstractC13042fc3.f(objA);
            if (((ArrayList) objA).isEmpty()) {
                c7359Rj4.u1 = 0;
                MarketSection marketSection = c7359Rj4.l1;
                MarketSection marketSection2 = null;
                if (marketSection == null) {
                    AbstractC13042fc3.y("row");
                    marketSection = null;
                }
                String title = marketSection.getTitle();
                MarketSection marketSection3 = c7359Rj4.l1;
                if (marketSection3 == null) {
                    AbstractC13042fc3.y("row");
                } else {
                    marketSection2 = marketSection3;
                }
                C21946uP3 c21946uP3 = new C21946uP3(21, null, null, title, null, Integer.valueOf(marketSection2.getId()), null, null, null, null, null, null, null, null, null, 32726, null);
                C3343Am.i("market_page", c21946uP3.a());
                C3343Am.j("market_page", c21946uP3.b());
            } else {
                AbstractC13042fc3.f(c5354Iz1);
                c7359Rj4.Ya(c5354Iz1, i2);
            }
        }
        c7359Rj4.Da();
        return C19938rB7.a;
    }

    private final int Oa() {
        return ((Number) this.v1.getValue()).intValue();
    }

    private final C12332eR3 Pa() {
        return (C12332eR3) this.i1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Qa() {
        return ((Number) this.q1.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C11634dL2 Ra(C7359Rj4 c7359Rj4) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        int iF = aVar.f(16.0f);
        if (c7359Rj4.l1 == null) {
            AbstractC13042fc3.y("row");
        }
        MarketSection marketSection = c7359Rj4.l1;
        MarketSection marketSection2 = null;
        if (marketSection == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        }
        if (marketSection.isProduct()) {
            iF = aVar.f(10.0f);
        }
        int i2 = iF;
        if (c7359Rj4.l1 == null) {
            AbstractC13042fc3.y("row");
        }
        MarketSection marketSection3 = c7359Rj4.l1;
        if (marketSection3 == null) {
            AbstractC13042fc3.y("row");
        } else {
            marketSection2 = marketSection3;
        }
        return marketSection2.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber() ? new C11634dL2(c7359Rj4.Oa(), i2, i2, aVar.f(7.0f), 0, 0, aVar.f(7.0f), 48, null) : new C11634dL2(c7359Rj4.Oa(), i2, i2, 0, 0, 0, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
    }

    private final void Sa() {
        BaleToolbar baleToolbar = Fa().e;
        MarketSection marketSection = this.l1;
        if (marketSection == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        }
        baleToolbar.setTitle(marketSection.getTitle());
        BaleToolbar baleToolbar2 = Fa().e;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar2, fragmentActivityQ7, true, false, 4, null);
        Ea().A(this);
        Ea().B(this);
        Fa().c.setAdapter(Ea());
        Fa().c.setLayoutManager(new NpaGridLayoutManager(S7(), Oa()));
        Fa().c.addItemDecoration(Ga());
        Fa().c.addOnScrollListener(this.x1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ta() {
        this.p1 = true;
        Fa().d.setRefreshing(true);
        MarketSection marketSection = this.l1;
        if (marketSection == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        }
        if (marketSection.isProduct()) {
            La();
        } else {
            Ja();
        }
    }

    private final void Ua(final C5354Iz1 c5354Iz1, final int i2) {
        C12332eR3 c12332eR3Pa = Pa();
        Object objA = c5354Iz1.a();
        AbstractC13042fc3.f(objA);
        c12332eR3Pa.d1((ArrayList) objA).j(p6(), new d(new UA2() { // from class: ir.nasim.Nj4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7359Rj4.Va(c5354Iz1, this, i2, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Va(C5354Iz1 c5354Iz1, final C7359Rj4 c7359Rj4, final int i2, C5354Iz1 c5354Iz12) {
        AbstractC13042fc3.i(c5354Iz1, "$getMarketsResponse");
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        if (!c5354Iz12.c()) {
            try {
                Object objA = c5354Iz1.a();
                AbstractC13042fc3.f(objA);
                if (((ArrayList) objA).size() < c7359Rj4.Qa()) {
                    c7359Rj4.Fa().c.removeOnScrollListener(c7359Rj4.x1);
                }
                ArrayList arrayListZ = c7359Rj4.Ea().z();
                Object objA2 = c5354Iz1.a();
                AbstractC13042fc3.f(objA2);
                arrayListZ.addAll((Collection) objA2);
                final int size = c7359Rj4.Ea().z().size();
                c7359Rj4.Q7().runOnUiThread(new Runnable() { // from class: ir.nasim.Bj4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C7359Rj4.Wa(this.a, i2, size);
                    }
                });
                c7359Rj4.u1++;
            } catch (Exception e2) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            }
        }
        c7359Rj4.Da();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wa(final C7359Rj4 c7359Rj4, final int i2, final int i3) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        c7359Rj4.Fa().c.post(new Runnable() { // from class: ir.nasim.Hj4
            @Override // java.lang.Runnable
            public final void run() {
                C7359Rj4.Xa(this.a, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xa(C7359Rj4 c7359Rj4, int i2, int i3) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        c7359Rj4.Ea().notifyItemRangeInserted(i2, i3);
        c7359Rj4.Fa().c.invalidateItemDecorations();
        c7359Rj4.Ea().notifyItemRangeChanged(i2 - c7359Rj4.Oa(), c7359Rj4.Oa());
    }

    private final void Ya(final C5354Iz1 c5354Iz1, final int i2) {
        C12332eR3 c12332eR3Pa = Pa();
        Object objA = c5354Iz1.a();
        AbstractC13042fc3.f(objA);
        c12332eR3Pa.e1((ArrayList) objA).j(p6(), new d(new UA2() { // from class: ir.nasim.zj4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7359Rj4.Za(c5354Iz1, this, i2, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Za(C5354Iz1 c5354Iz1, final C7359Rj4 c7359Rj4, final int i2, C5354Iz1 c5354Iz12) {
        AbstractC13042fc3.i(c5354Iz1, "$it");
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        if (!c5354Iz1.c()) {
            try {
                Object objA = c5354Iz1.a();
                AbstractC13042fc3.f(objA);
                if (((ArrayList) objA).size() < c7359Rj4.Qa()) {
                    c7359Rj4.u1 = -1;
                }
                ArrayList arrayListZ = c7359Rj4.Ea().z();
                Object objA2 = c5354Iz1.a();
                AbstractC13042fc3.f(objA2);
                arrayListZ.addAll((Collection) objA2);
                final int size = c7359Rj4.Ea().z().size();
                c7359Rj4.Q7().runOnUiThread(new Runnable() { // from class: ir.nasim.Cj4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C7359Rj4.ab(this.a, i2, size);
                    }
                });
                c7359Rj4.u1++;
            } catch (Exception e2) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ab(final C7359Rj4 c7359Rj4, final int i2, final int i3) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        c7359Rj4.Fa().c.post(new Runnable() { // from class: ir.nasim.Gj4
            @Override // java.lang.Runnable
            public final void run() {
                C7359Rj4.bb(this.a, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bb(C7359Rj4 c7359Rj4, int i2, int i3) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        c7359Rj4.Ea().notifyItemRangeInserted(i2, i3);
        c7359Rj4.Fa().c.invalidateItemDecorations();
        c7359Rj4.Ea().notifyItemRangeChanged(i2 - c7359Rj4.Oa(), c7359Rj4.Oa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void db(Object obj, final C7359Rj4 c7359Rj4, String str, Bundle bundle) {
        final OP5 op5;
        Integer groupId;
        MarketPost marketPost;
        Integer groupId2;
        AbstractC13042fc3.i(obj, "$item");
        AbstractC13042fc3.i(c7359Rj4, "this$0");
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
        Context contextS7 = c7359Rj4.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = c7359Rj4.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        C24398yZ.k(contextS7, interfaceC18633oz3P6, i2, false, null, new UA2() { // from class: ir.nasim.Ej4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj2) {
                return C7359Rj4.eb(this.a, iIntValue, op5, (String) obj2);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 eb(C7359Rj4 c7359Rj4, int i2, OP5 op5, String str) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        AbstractC13042fc3.i(op5, "$selectedReportType");
        AbstractC13042fc3.i(str, "reportDescription");
        c7359Rj4.Pa().f1(str, i2, op5);
        return C19938rB7.a;
    }

    private final void fb(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c18987pb3.k0(intent, fragmentActivityQ7);
    }

    private final void gb(long j2, final String str) {
        if (this.n1) {
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (C4100Dr4.a(contextS7)) {
            this.n1 = true;
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            final ProgressDialog progressDialogE = C8920Xu5.e(contextS72, true);
            progressDialogE.setCancelable(false);
            AbstractC5969Lp4.b().k(j2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Oj4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C7359Rj4.hb(this.a, str, progressDialogE, (C14733iO2) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Pj4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C7359Rj4.jb(str, this, progressDialogE, (Exception) obj);
                }
            });
            return;
        }
        ConstraintLayout root = Fa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(Fa().getRoot());
        String strH6 = h6(AbstractC12217eE5.card_payment_please_check_your_internet_conenction);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10.o(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hb(final C7359Rj4 c7359Rj4, String str, ProgressDialog progressDialog, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        if (c14733iO2 != null) {
            C11458d25 c11458d25 = new C11458d25(W25.b, c14733iO2.r());
            C5735Kp4.w().o(c11458d25);
            C18987pb3.a.y1(c11458d25, null, null, false, "market");
        } else {
            C5735Kp4.w().J(c7359Rj4.S7(), str, "market");
        }
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Dj4
            @Override // java.lang.Runnable
            public final void run() {
                C7359Rj4.ib(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(C7359Rj4 c7359Rj4) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        c7359Rj4.n1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jb(String str, final C7359Rj4 c7359Rj4, ProgressDialog progressDialog, Exception exc) {
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        if (str.length() > 0) {
            C5735Kp4.w().J(c7359Rj4.S7(), str, "market");
        }
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Fj4
            @Override // java.lang.Runnable
            public final void run() {
                C7359Rj4.kb(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kb(C7359Rj4 c7359Rj4) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        c7359Rj4.n1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int mb(C7359Rj4 c7359Rj4) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        MarketSection marketSection = c7359Rj4.l1;
        if (marketSection == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        }
        return marketSection.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber() ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nb(C7359Rj4 c7359Rj4) {
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        MarketSection marketSection = c7359Rj4.l1;
        if (marketSection == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        }
        return marketSection.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber() ? AbstractC5969Lp4.e().S().c3() : AbstractC5969Lp4.e().S().b3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C23731xQ3 za(C7359Rj4 c7359Rj4) {
        MarketSection marketSection;
        AbstractC13042fc3.i(c7359Rj4, "this$0");
        MarketSection marketSection2 = c7359Rj4.l1;
        if (marketSection2 == null) {
            AbstractC13042fc3.y("row");
            marketSection2 = null;
        }
        int categoryType = marketSection2.getCategoryType();
        int i2 = categoryType == EnumC21325tT3.CategoryItemsType_PRODUCT_ONLY.getNumber() ? 6 : categoryType == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber() ? 4 : 2;
        MarketSection marketSection3 = c7359Rj4.l1;
        if (marketSection3 == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        } else {
            marketSection = marketSection3;
        }
        return new C23731xQ3(marketSection, i2, false, new UA2() { // from class: ir.nasim.Qj4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7359Rj4.Aa(obj);
            }
        }, new UA2() { // from class: ir.nasim.yj4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C7359Rj4.Ba(obj);
            }
        });
    }

    @Override // ir.nasim.C23731xQ3.b
    public void C(MarketItem marketItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        gb(marketItem.getId(), marketItem.getUrl());
        XV4 xv4A = AbstractC4616Fw7.a("peer_id", String.valueOf(marketItem.getId()));
        String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        C3343Am.e("market_item_click", AbstractC20051rO3.n(xv4A, AbstractC4616Fw7.a("peer_type", lowerCase), AbstractC4616Fw7.a("row_title", marketSection.getTitle()), AbstractC4616Fw7.a("service_id", "15")));
        C21946uP3 c21946uP3 = new C21946uP3(1, Integer.valueOf(marketSection.getId()), null, marketSection.getTitle(), null, null, null, Long.valueOf(marketItem.getId()), null, null, null, null, Integer.valueOf(Ea().z().indexOf(marketItem)), null, 3, 12148, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void H1() {
        this.o1 = 0;
        this.r1 = 0;
        this.s1 = 0;
        this.t1 = 0;
        this.u1 = 0;
        int size = Ea().z().size();
        Ea().z().clear();
        Ea().notifyItemRangeRemoved(0, size);
        Ta();
    }

    public final boolean Ha() {
        return this.p1;
    }

    public final InterfaceC14761iR3 Ia() {
        InterfaceC14761iR3 interfaceC14761iR3 = this.j1;
        if (interfaceC14761iR3 != null) {
            return interfaceC14761iR3;
        }
        AbstractC13042fc3.y("marketNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        MarketSection marketSection = this.l1;
        if (marketSection == null) {
            AbstractC13042fc3.y("row");
            marketSection = null;
        }
        if (marketSection.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber()) {
            this.u1 = Pa().c1();
        }
    }

    public final InterfaceC24908zP5 Na() {
        InterfaceC24908zP5 interfaceC24908zP5 = this.k1;
        if (interfaceC24908zP5 != null) {
            return interfaceC24908zP5;
        }
        AbstractC13042fc3.y("reportNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        if (AbstractC5969Lp4.e().S().B5(EnumC4716Gg2.Z)) {
            MarketSection marketSection = this.l1;
            if (marketSection == null) {
                AbstractC13042fc3.y("row");
                marketSection = null;
            }
            if (marketSection.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber() && Pa().g1()) {
                C22042ua0.A9(this, Ia().a(), false, null, 6, null);
                Pa().V0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: cb, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        ConstraintLayout root = C5112Hy2.c(layoutInflater, viewGroup, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23731xQ3.b
    public void k(MarketProductItem marketProductItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketProductItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        fb(marketProductItem.getUrl());
        int i2 = marketSection.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber() ? 4 : 5;
        C21946uP3 c21946uP3 = new C21946uP3(4, null, null, marketSection.getTitle(), null, Integer.valueOf(marketSection.getId()), null, marketProductItem.getPost().getGroupId() != null ? Long.valueOf(r6.intValue()) : null, null, null, null, marketProductItem.getUrlPathOnly(), Integer.valueOf(Ea().z().indexOf(marketProductItem)), null, Integer.valueOf(i2), 10070, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        Sa();
        Ca(this);
        Ta();
    }

    public final void lb(boolean z) {
        this.p1 = z;
    }

    @Override // ir.nasim.C12950fS3.b
    public void x2(final Object obj) {
        AbstractC13042fc3.i(obj, "item");
        if (C8386Vt0.a.U3()) {
            F5().z("market_more_item_report_result_key");
            F5().H1("market_more_item_report_result_key", this, new InterfaceC13295fz2() { // from class: ir.nasim.Aj4
                @Override // ir.nasim.InterfaceC13295fz2
                public final void a(String str, Bundle bundle) {
                    C7359Rj4.db(obj, this, str, bundle);
                }
            });
            InterfaceC24908zP5.b(Na(), "market_more_item_report_result_key", "market_report_title_result_key", "report_type_result_key", null, 8, null).K8(F5(), null);
        }
    }

    private C7359Rj4() {
        this.h1 = AbstractC6056Lz2.f(this, new e(), AbstractC20046rN7.c());
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new g(new f(this)));
        this.i1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C12332eR3.class), new h(interfaceC9173Yu3B), new i(null, interfaceC9173Yu3B), new j(this, interfaceC9173Yu3B));
        this.m1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Jj4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C7359Rj4.za(this.a);
            }
        });
        this.p1 = true;
        this.q1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Kj4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C7359Rj4.nb(this.a));
            }
        });
        this.v1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Lj4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C7359Rj4.mb(this.a));
            }
        });
        this.w1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Mj4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C7359Rj4.Ra(this.a);
            }
        });
        this.x1 = new c();
    }
}
