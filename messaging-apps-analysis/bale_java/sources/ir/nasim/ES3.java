package ir.nasim;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.core.modules.market.model.SearchSuggestion;

/* loaded from: classes4.dex */
public final class ES3 extends ZW2 implements InterfaceC24762z98 {
    private String h1;
    private final InterfaceC10358bW7 i1;
    private final InterfaceC9173Yu3 j1;
    private final InterfaceC9173Yu3 k1;
    static final /* synthetic */ InterfaceC5239Im3[] m1 = {AbstractC10882cM5.i(new C25226zw5(ES3.class, "binding", "getBinding()Lir/nasim/market/databinding/FragmentMarketSearchResultBinding;", 0))};
    public static final a l1 = new a(null);
    public static final int n1 = 8;

    public static final class a {
        private a() {
        }

        public final ES3 a(String str) {
            AbstractC13042fc3.i(str, "term");
            ES3 es3 = new ES3(null);
            Bundle bundle = new Bundle();
            bundle.putString("term", str);
            es3.a8(bundle);
            return es3;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements TabLayout.d {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            AbstractC13042fc3.i(gVar, "tab");
            C14779iT3 c14779iT3A = C14779iT3.a(gVar.i);
            AbstractC13042fc3.h(c14779iT3A, "bind(...)");
            c14779iT3A.d.setTextColor(AbstractC4043Dl1.c(ES3.this.S7(), BA5.secondary_2));
            c14779iT3A.b.setVisibility(0);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            AbstractC13042fc3.i(gVar, "tab");
            C14779iT3 c14779iT3A = C14779iT3.a(gVar.i);
            AbstractC13042fc3.h(c14779iT3A, "bind(...)");
            c14779iT3A.d.setTextColor(AbstractC4043Dl1.c(ES3.this.S7(), BA5.color8));
            c14779iT3A.b.setVisibility(8);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
            AbstractC13042fc3.i(gVar, "tab");
        }
    }

    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C3693By2.a(fragment.V7());
        }
    }

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public /* synthetic */ ES3(ED1 ed1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20841sh6 Y9(ES3 es3) {
        AbstractC13042fc3.i(es3, "this$0");
        FragmentManager fragmentManagerV5 = es3.V5();
        AbstractC13042fc3.h(fragmentManagerV5, "getParentFragmentManager(...)");
        androidx.lifecycle.j lifecycle = es3.getLifecycle();
        AbstractC13042fc3.h(lifecycle, "<get-lifecycle>(...)");
        String str = es3.h1;
        if (str == null) {
            AbstractC13042fc3.y("term");
            str = null;
        }
        return new C20841sh6(fragmentManagerV5, lifecycle, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3693By2 Z9() {
        Object objA = this.i1.a(this, m1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C3693By2) objA;
    }

    private final C20841sh6 aa() {
        return (C20841sh6) this.k1.getValue();
    }

    private final C13577gT3 ba() {
        return (C13577gT3) this.j1.getValue();
    }

    private final ES3 ca() {
        Z9().f.d(new b());
        return this;
    }

    private final ES3 da() {
        EditText editText = Z9().e;
        AbstractC13042fc3.h(editText, "editTxt");
        editText.addTextChangedListener(new c());
        Z9().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zS3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ES3.ea(this.a, view);
            }
        });
        EditText editText2 = Z9().e;
        String str = this.h1;
        if (str == null) {
            AbstractC13042fc3.y("term");
            str = null;
        }
        editText2.setText(str);
        Z9().e.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.AS3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return ES3.fa(this.a, textView, i2, keyEvent);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(ES3 es3, View view) {
        AbstractC13042fc3.i(es3, "this$0");
        C22042ua0.m9(es3, es3, false, 2, null);
        C22042ua0.A9(es3, new C22563vS3(), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean fa(ES3 es3, TextView textView, int i2, KeyEvent keyEvent) {
        AbstractC13042fc3.i(es3, "this$0");
        if (!AbstractC20762sZ6.n0(textView.getText().toString())) {
            es3.ba().P0(new SearchSuggestion(SearchSuggestion.a.a, textView.getText().toString(), null, null, null, null, null, 124, null));
            es3.aa().V(textView.getText().toString());
            EditText editText = es3.Z9().e;
            AbstractC13042fc3.h(editText, "editTxt");
            AbstractC24706z42.a(editText);
        }
        return true;
    }

    private final ES3 ga() {
        Z9().g.setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.DS3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ES3.ha(this.a, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(ES3 es3, View view) {
        AbstractC13042fc3.i(es3, "this$0");
        C22042ua0.m9(es3, es3, false, 2, null);
    }

    private final ES3 ia() {
        Z9().h.setAdapter(aa());
        new com.google.android.material.tabs.d(Z9().f, Z9().h, new d.b() { // from class: ir.nasim.CS3
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i2) {
                ES3.ja(this.a, gVar, i2);
            }
        }).a();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(ES3 es3, TabLayout.g gVar, int i2) {
        AbstractC13042fc3.i(es3, "this$0");
        AbstractC13042fc3.i(gVar, "tab");
        gVar.q(JC5.market_search_tab);
        C14779iT3 c14779iT3A = C14779iT3.a(gVar.i.getRootView());
        AbstractC13042fc3.h(c14779iT3A, "bind(...)");
        c14779iT3A.d.setTypeface(C6011Lu2.i());
        TextView textView = c14779iT3A.d;
        String strH6 = (i2 == 0 || i2 != 1) ? es3.h6(JD5.market_search_product_tab) : es3.h6(JD5.market_search_market_tab);
        textView.setText(strH6);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            if (bundleE5.getString("term") == null) {
                C22042ua0.m9(this, this, false, 2, null);
                return;
            }
            String string = bundleE5.getString("term");
            if (string != null) {
                this.h1 = string;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        LinearLayout root = C3693By2.c(layoutInflater, viewGroup, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.InterfaceC24762z98
    /* renamed from: l2 */
    public boolean getAutoIme() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        ga().da().ca().ia();
    }

    private ES3() {
        this.i1 = AbstractC6056Lz2.f(this, new d(), AbstractC20046rN7.c());
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.j1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C13577gT3.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
        this.k1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.BS3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ES3.Y9(this.a);
            }
        });
    }

    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4 = 0;
            int length = charSequence != null ? charSequence.length() : 0;
            ImageView imageView = ES3.this.Z9().d;
            if (i3 <= 0 && length <= 0) {
                i4 = 8;
            }
            imageView.setVisibility(i4);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
