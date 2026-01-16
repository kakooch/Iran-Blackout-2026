package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C12923fP3;
import ir.nasim.core.modules.market.model.MarketCategory;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.oQ3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18296oQ3 extends C22042ua0 implements C12923fP3.a {
    private final InterfaceC9173Yu3 c1;
    private final InterfaceC10358bW7 d1;
    private final InterfaceC10358bW7 e1;
    public C17468n10 f1;
    private ArrayList g1;
    private Integer h1;
    private C10333bU0 i1;
    private final C12923fP3 j1;
    private final ArrayList k1;
    static final /* synthetic */ InterfaceC5239Im3[] m1 = {AbstractC10882cM5.i(new C25226zw5(C18296oQ3.class, "binding", "getBinding()Lir/nasim/databinding/FragmentMarketGenderSelectorBinding;", 0)), AbstractC10882cM5.i(new C25226zw5(C18296oQ3.class, "toolbarBinding", "getToolbarBinding()Lir/nasim/databinding/FragmentMarketOnboardingToolbarMenuBinding;", 0))};
    public static final a l1 = new a(null);
    public static final int n1 = 8;

    /* renamed from: ir.nasim.oQ3$a */
    public static final class a {
        private a() {
        }

        public final C18296oQ3 a(ArrayList arrayList) {
            AbstractC13042fc3.i(arrayList, "categoryIds");
            C18296oQ3 c18296oQ3 = new C18296oQ3(null);
            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList("category_ids", arrayList);
            c18296oQ3.a8(bundle);
            return c18296oQ3;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.oQ3$b */
    static final class b implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        b(UA2 ua2) {
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

    /* renamed from: ir.nasim.oQ3$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C24647yy2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.oQ3$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.oQ3$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.oQ3$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.oQ3$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.oQ3$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public /* synthetic */ C18296oQ3(ED1 ed1) {
        this();
    }

    private final void T9() {
        V9().b.setDisableStyle();
    }

    private final void U9() {
        V9().b.setEnableStyle();
    }

    private final C24647yy2 V9() {
        Object objA = this.d1.a(this, m1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C24647yy2) objA;
    }

    private final C25241zy2 X9() {
        Object objA = this.e1.a(this, m1[1]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C25241zy2) objA;
    }

    private final C20069rQ3 Y9() {
        return (C20069rQ3) this.c1.getValue();
    }

    private final C18296oQ3 Z9() {
        ConstraintLayout root = V9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ma(new C17468n10(root, null, 0, 6, null));
        W9().k(V9().b);
        return this;
    }

    private final C18296oQ3 aa() {
        X9().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kQ3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C18296oQ3.ba(this.a, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(final C18296oQ3 c18296oQ3, View view) {
        AbstractC13042fc3.i(c18296oQ3, "this$0");
        C10333bU0 c10333bU0 = c18296oQ3.i1;
        FragmentManager fragmentManagerB0 = c18296oQ3.Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
        C20069rQ3 c20069rQ3Y9 = c18296oQ3.Y9();
        Integer num = c18296oQ3.h1;
        ArrayList arrayList = c18296oQ3.g1;
        if (arrayList == null) {
            AbstractC13042fc3.y("categoryIds");
            arrayList = null;
        }
        c20069rQ3Y9.S0(true, num, arrayList).j(c18296oQ3.p6(), new b(new UA2() { // from class: ir.nasim.mQ3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18296oQ3.ca(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(C18296oQ3 c18296oQ3, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(c18296oQ3, "this$0");
        AbstractC16494lN1.a(c18296oQ3.i1);
        if (c5354Iz1.c()) {
            Throwable thB = c5354Iz1.b();
            c18296oQ3.J9(thB != null ? thB.getLocalizedMessage() : null);
        } else {
            C22042ua0.m9(c18296oQ3, c18296oQ3, false, 2, null);
        }
        return C19938rB7.a;
    }

    private final C18296oQ3 da() {
        C12923fP3 c12923fP3 = this.j1;
        c12923fP3.C(this);
        c12923fP3.z().addAll(this.k1);
        c12923fP3.notifyItemRangeInserted(0, this.k1.size());
        return this;
    }

    private final C18296oQ3 ea() {
        V9().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lQ3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C18296oQ3.fa(this.a, view);
            }
        });
        T9();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(C18296oQ3 c18296oQ3, View view) {
        AbstractC13042fc3.i(c18296oQ3, "this$0");
        if (c18296oQ3.h1 != null) {
            c18296oQ3.ka();
            return;
        }
        C17468n10 c17468n10W9 = c18296oQ3.W9();
        String strH6 = c18296oQ3.h6(AbstractC12217eE5.market_disabled_gender_button);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10W9.o(strH6);
    }

    private final C18296oQ3 ga() {
        V9().c.setTypeface(C6011Lu2.k());
        X9().c.setTypeface(C6011Lu2.k());
        return this;
    }

    private final C18296oQ3 ha() {
        ArrayList arrayList = this.k1;
        String string = S7().getString(AbstractC12217eE5.market_female);
        AbstractC13042fc3.h(string, "getString(...)");
        arrayList.add(new MarketCategory(1, string, Integer.valueOf(KB5.market_category_female), false, 8, null));
        ArrayList arrayList2 = this.k1;
        String string2 = S7().getString(AbstractC12217eE5.market_male);
        AbstractC13042fc3.h(string2, "getString(...)");
        arrayList2.add(new MarketCategory(0, string2, Integer.valueOf(KB5.market_category_male), false, 8, null));
        return this;
    }

    private final C18296oQ3 ia() {
        RecyclerView recyclerView = V9().e;
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        recyclerView.addItemDecoration(new C11634dL2(2, aVar.f(8.0f), aVar.f(8.0f), 0, 0, 0, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null));
        recyclerView.setAdapter(this.j1);
        return this;
    }

    private final void ka() {
        C10333bU0 c10333bU0 = this.i1;
        FragmentManager fragmentManagerB0 = Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
        C20069rQ3 c20069rQ3Y9 = Y9();
        Integer num = this.h1;
        ArrayList arrayList = this.g1;
        if (arrayList == null) {
            AbstractC13042fc3.y("categoryIds");
            arrayList = null;
        }
        c20069rQ3Y9.S0(false, num, arrayList).j(p6(), new b(new UA2() { // from class: ir.nasim.nQ3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18296oQ3.la(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la(C18296oQ3 c18296oQ3, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(c18296oQ3, "this$0");
        AbstractC16494lN1.a(c18296oQ3.i1);
        if (c5354Iz1.c()) {
            Throwable thB = c5354Iz1.b();
            c18296oQ3.J9(thB != null ? thB.getLocalizedMessage() : null);
        } else {
            C22042ua0.m9(c18296oQ3, c18296oQ3, false, 2, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C25241zy2 na(C18296oQ3 c18296oQ3, C18296oQ3 c18296oQ32) {
        AbstractC13042fc3.i(c18296oQ3, "this$0");
        AbstractC13042fc3.i(c18296oQ32, "it");
        Menu menu = c18296oQ3.V9().f.getMenu();
        AbstractC13042fc3.h(menu, "getMenu(...)");
        View actionView = menu.getItem(0).getActionView();
        AbstractC13042fc3.f(actionView);
        return C25241zy2.a(actionView);
    }

    @Override // ir.nasim.C12923fP3.a
    public void J2(MarketCategory marketCategory) {
        AbstractC13042fc3.i(marketCategory, SearchSuggestion.CATEGORY_ICON);
        Iterator it = this.j1.z().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                this.j1.notifyItemRangeChanged(0, this.k1.size());
                this.h1 = Integer.valueOf(marketCategory.getId());
                U9();
                return;
            } else {
                MarketCategory marketCategory2 = (MarketCategory) it.next();
                if (marketCategory2.getId() == marketCategory.getId()) {
                    z = true;
                }
                marketCategory2.setSelected(z);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            ArrayList<Integer> integerArrayList = bundleE5.getIntegerArrayList("category_ids");
            AbstractC13042fc3.g(integerArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
            this.g1 = integerArrayList;
        }
    }

    public final C17468n10 W9() {
        C17468n10 c17468n10 = this.f1;
        if (c17468n10 != null) {
            return c17468n10;
        }
        AbstractC13042fc3.y("snackBar");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: ja, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        ConstraintLayout root = C24647yy2.c(layoutInflater, viewGroup, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        ga();
        aa().Z9().ha().ia().da().ea();
    }

    public final void ma(C17468n10 c17468n10) {
        AbstractC13042fc3.i(c17468n10, "<set-?>");
        this.f1 = c17468n10;
    }

    private C18296oQ3() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.c1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C20069rQ3.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
        this.d1 = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());
        this.e1 = AbstractC6056Lz2.e(this, new UA2() { // from class: ir.nasim.jQ3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18296oQ3.na(this.a, (C18296oQ3) obj);
            }
        });
        this.i1 = new C10333bU0();
        this.j1 = new C12923fP3();
        this.k1 = new ArrayList();
    }
}
