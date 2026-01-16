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
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001IB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0004J+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lir/nasim/lP3;", "Lir/nasim/ua0;", "Lir/nasim/fP3$a;", "<init>", "()V", "ja", "()Lir/nasim/lP3;", "ba", "ca", "ka", "fa", "W9", "ga", "ia", "Lir/nasim/rB7;", "T9", "U9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroidx/constraintlayout/widget/ConstraintLayout;", "la", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/core/modules/market/model/MarketCategory;", SearchSuggestion.CATEGORY_ICON, "J2", "(Lir/nasim/core/modules/market/model/MarketCategory;)V", "Lir/nasim/qP3;", "c1", "Lir/nasim/Yu3;", "aa", "()Lir/nasim/qP3;", "viewModel", "Lir/nasim/xy2;", "d1", "Lir/nasim/bW7;", "V9", "()Lir/nasim/xy2;", "binding", "Lir/nasim/zy2;", "e1", "Z9", "()Lir/nasim/zy2;", "toolbarBinding", "Lir/nasim/n10;", "f1", "Lir/nasim/n10;", "Y9", "()Lir/nasim/n10;", "ma", "(Lir/nasim/n10;)V", "snackBar", "Lir/nasim/bU0;", "g1", "Lir/nasim/bU0;", "loadingFragment", "Lir/nasim/fP3;", "h1", "Lir/nasim/fP3;", "adapter", "Ljava/util/ArrayList;", "", "i1", "Ljava/util/ArrayList;", "selectedIds", "j1", "a", "market_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.lP3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16514lP3 extends C22042ua0 implements C12923fP3.a {

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: e1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 toolbarBinding;

    /* renamed from: f1, reason: from kotlin metadata */
    public C17468n10 snackBar;

    /* renamed from: g1, reason: from kotlin metadata */
    private C10333bU0 loadingFragment;

    /* renamed from: h1, reason: from kotlin metadata */
    private final C12923fP3 adapter;

    /* renamed from: i1, reason: from kotlin metadata */
    private final ArrayList selectedIds;
    static final /* synthetic */ InterfaceC5239Im3[] k1 = {AbstractC10882cM5.i(new C25226zw5(C16514lP3.class, "binding", "getBinding()Lir/nasim/databinding/FragmentMarketCategorySelectorBinding;", 0)), AbstractC10882cM5.i(new C25226zw5(C16514lP3.class, "toolbarBinding", "getToolbarBinding()Lir/nasim/databinding/FragmentMarketOnboardingToolbarMenuBinding;", 0))};
    public static final int l1 = 8;

    /* renamed from: ir.nasim.lP3$b */
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

    /* renamed from: ir.nasim.lP3$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C24057xy2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.lP3$d */
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

    /* renamed from: ir.nasim.lP3$e */
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

    /* renamed from: ir.nasim.lP3$f */
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

    /* renamed from: ir.nasim.lP3$g */
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

    /* renamed from: ir.nasim.lP3$h */
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

    public C16514lP3() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C19469qP3.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());
        this.toolbarBinding = AbstractC6056Lz2.e(this, new UA2() { // from class: ir.nasim.jP3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C16514lP3.na(this.a, (C16514lP3) obj);
            }
        });
        this.loadingFragment = new C10333bU0();
        this.adapter = new C12923fP3();
        this.selectedIds = new ArrayList();
    }

    private final void T9() {
        V9().e.setDisableStyle();
    }

    private final void U9() {
        V9().e.setEnableStyle();
    }

    private final C24057xy2 V9() {
        Object objA = this.binding.a(this, k1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C24057xy2) objA;
    }

    private final C16514lP3 W9() {
        C10333bU0 c10333bU0 = this.loadingFragment;
        FragmentManager fragmentManagerB0 = Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
        aa().U0().j(p6(), new b(new UA2() { // from class: ir.nasim.iP3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C16514lP3.X9(this.a, (C5354Iz1) obj);
            }
        }));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X9(C16514lP3 c16514lP3, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(c16514lP3, "this$0");
        if (c5354Iz1.c()) {
            Throwable thB = c5354Iz1.b();
            c16514lP3.J9(thB != null ? thB.getLocalizedMessage() : null);
        } else {
            C12923fP3 c12923fP3 = c16514lP3.adapter;
            ArrayList arrayListZ = c12923fP3.z();
            Object objA = c5354Iz1.a();
            AbstractC13042fc3.f(objA);
            arrayListZ.addAll((Collection) objA);
            c12923fP3.notifyItemRangeInserted(0, c12923fP3.z().size());
        }
        AbstractC16494lN1.a(c16514lP3.loadingFragment);
        return C19938rB7.a;
    }

    private final C25241zy2 Z9() {
        Object objA = this.toolbarBinding.a(this, k1[1]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C25241zy2) objA;
    }

    private final C19469qP3 aa() {
        return (C19469qP3) this.viewModel.getValue();
    }

    private final C16514lP3 ba() {
        ConstraintLayout root = V9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ma(new C17468n10(root, null, 0, 6, null));
        Y9().k(V9().e);
        return this;
    }

    private final C16514lP3 ca() {
        Z9().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kP3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16514lP3.da(this.a, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(final C16514lP3 c16514lP3, View view) {
        AbstractC13042fc3.i(c16514lP3, "this$0");
        C10333bU0 c10333bU0 = c16514lP3.loadingFragment;
        FragmentManager fragmentManagerB0 = c16514lP3.Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
        c16514lP3.aa().X0(true, c16514lP3.selectedIds).j(c16514lP3.p6(), new b(new UA2() { // from class: ir.nasim.gP3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C16514lP3.ea(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ea(C16514lP3 c16514lP3, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(c16514lP3, "this$0");
        AbstractC16494lN1.a(c16514lP3.loadingFragment);
        if (c5354Iz1.c()) {
            Throwable thB = c5354Iz1.b();
            c16514lP3.J9(thB != null ? thB.getLocalizedMessage() : null);
        } else {
            C22042ua0.m9(c16514lP3, c16514lP3, false, 2, null);
        }
        return C19938rB7.a;
    }

    private final C16514lP3 fa() {
        this.adapter.C(this);
        return this;
    }

    private final C16514lP3 ga() {
        V9().e.setTag(0);
        V9().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hP3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16514lP3.ha(this.a, view);
            }
        });
        T9();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(C16514lP3 c16514lP3, View view) {
        AbstractC13042fc3.i(c16514lP3, "this$0");
        if (AbstractC13042fc3.d(view.getTag(), 1)) {
            C22042ua0.m9(c16514lP3, c16514lP3, false, 2, null);
            C22042ua0.A9(c16514lP3, C18296oQ3.l1.a(c16514lP3.selectedIds), false, null, 6, null);
        } else {
            C17468n10 c17468n10Y9 = c16514lP3.Y9();
            String strH6 = c16514lP3.h6(AbstractC12217eE5.market_choose_atleast_three_categories);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c17468n10Y9.o(strH6);
        }
    }

    private final C16514lP3 ia() {
        V9().g.setVisibility(8);
        V9().c.setTypeface(C6011Lu2.k());
        V9().h.setTypeface(C6011Lu2.k());
        return this;
    }

    private final C16514lP3 ja() {
        V9().l.setTypeface(C6011Lu2.i());
        V9().i.setTypeface(C6011Lu2.k());
        Z9().c.setTypeface(C6011Lu2.k());
        return this;
    }

    private final C16514lP3 ka() {
        RecyclerView recyclerView = V9().k;
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        recyclerView.addItemDecoration(new C11634dL2(2, aVar.f(8.0f), aVar.f(8.0f), 0, 0, 0, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null));
        recyclerView.setAdapter(this.adapter);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C25241zy2 na(C16514lP3 c16514lP3, C16514lP3 c16514lP32) {
        AbstractC13042fc3.i(c16514lP3, "this$0");
        AbstractC13042fc3.i(c16514lP32, "it");
        Menu menu = c16514lP3.V9().m.getMenu();
        AbstractC13042fc3.h(menu, "getMenu(...)");
        View actionView = menu.getItem(0).getActionView();
        AbstractC13042fc3.f(actionView);
        return C25241zy2.a(actionView);
    }

    @Override // ir.nasim.C12923fP3.a
    public void J2(MarketCategory category) {
        AbstractC13042fc3.i(category, SearchSuggestion.CATEGORY_ICON);
        this.selectedIds.clear();
        for (MarketCategory marketCategory : this.adapter.z()) {
            if (marketCategory.isSelected()) {
                this.selectedIds.add(Integer.valueOf(marketCategory.getId()));
            }
        }
        if (this.selectedIds.size() >= 3) {
            U9();
            V9().c.setText(GY6.a(String.valueOf(this.selectedIds.size())));
            if (this.selectedIds.size() == 3) {
                V9().h.setText(i6(AbstractC12217eE5.market_choose_categories_countbar, V9().c.getText()));
            } else {
                V9().h.setText(i6(AbstractC12217eE5.market_choose_categories_countbar_extra, V9().c.getText()));
            }
            V9().d.setVisibility(0);
            V9().e.setTag(1);
            return;
        }
        int size = this.selectedIds.size();
        if (1 > size || size >= 3) {
            T9();
            V9().g.setVisibility(8);
            V9().e.setTag(0);
        } else {
            T9();
            V9().c.setText(GY6.a(String.valueOf(this.selectedIds.size())));
            V9().h.setText(i6(AbstractC12217eE5.market_choose_categories_countbar, V9().c.getText()));
            V9().d.setVisibility(8);
            V9().g.setVisibility(0);
            V9().e.setTag(0);
        }
    }

    public final C17468n10 Y9() {
        C17468n10 c17468n10 = this.snackBar;
        if (c17468n10 != null) {
            return c17468n10;
        }
        AbstractC13042fc3.y("snackBar");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ja().ca().ba().ka().fa().W9().ga().ia();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: la, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C24057xy2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final void ma(C17468n10 c17468n10) {
        AbstractC13042fc3.i(c17468n10, "<set-?>");
        this.snackBar = c17468n10;
    }
}
