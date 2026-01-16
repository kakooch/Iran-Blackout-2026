package ir.nasim.jaryan.search.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.lifecycle.h;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14035hE5;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C13713gh6;
import ir.nasim.C14503i16;
import ir.nasim.C14819iX7;
import ir.nasim.C16731lm1;
import ir.nasim.C17441my2;
import ir.nasim.C19406qI3;
import ir.nasim.C25226zw5;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.EnumC4453Fe6;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.EnumC8772Xg3;
import ir.nasim.HC5;
import ir.nasim.ID5;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.O98;
import ir.nasim.SA2;
import ir.nasim.TW2;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.lang.reflect.Field;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 02\u00020\u0001:\u0001\u0017B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lir/nasim/jaryan/search/ui/fragment/d;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ca", "Z9", "ga", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "a", "()Z", "h1", "Z", "handleBackPress", "Lir/nasim/my2;", "i1", "Lir/nasim/bW7;", "X9", "()Lir/nasim/my2;", "binding", "", "j1", "Ljava/lang/String;", "query", "Lir/nasim/Xg3;", "k1", "Lir/nasim/Xg3;", "defaultTab", "Lir/nasim/i16;", "l1", "Lir/nasim/Yu3;", "Y9", "()Lir/nasim/i16;", "viewModel", "m1", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class d extends TW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private boolean handleBackPress;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new b(), AbstractC20046rN7.c());

    /* renamed from: j1, reason: from kotlin metadata */
    private String query = "";

    /* renamed from: k1, reason: from kotlin metadata */
    private EnumC8772Xg3 defaultTab = EnumC8772Xg3.b;

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;
    static final /* synthetic */ InterfaceC5239Im3[] n1 = {AbstractC10882cM5.i(new C25226zw5(d.class, "binding", "getBinding()Lir/nasim/jaryan/databinding/FragmentJaryanSearchResultBinding;", 0))};

    /* renamed from: m1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int o1 = 8;

    /* renamed from: ir.nasim.jaryan.search.ui.fragment.d$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ d b(Companion companion, String str, EnumC8772Xg3 enumC8772Xg3, int i, Object obj) {
            if ((i & 2) != 0) {
                enumC8772Xg3 = EnumC8772Xg3.b;
            }
            return companion.a(str, enumC8772Xg3);
        }

        public final d a(String str, EnumC8772Xg3 enumC8772Xg3) {
            AbstractC13042fc3.i(str, "query");
            AbstractC13042fc3.i(enumC8772Xg3, "defaultTab");
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putString("search_query", str);
            bundle.putString("arg_default_tab", enumC8772Xg3.toString());
            dVar.a8(bundle);
            return dVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b extends AbstractC8614Ws3 implements UA2 {
        public b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C17441my2.a(fragment.V7());
        }
    }

    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.jaryan.search.ui.fragment.d$d, reason: collision with other inner class name */
    public static final class C1322d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1322d(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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
            h hVar = interfaceC15408jX7C instanceof h ? (h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            h hVar = interfaceC15408jX7C instanceof h ? (h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public d() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new C1322d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C14503i16.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
    }

    private final C17441my2 X9() {
        Object objA = this.binding.a(this, n1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C17441my2) objA;
    }

    private final C14503i16 Y9() {
        return (C14503i16) this.viewModel.getValue();
    }

    private final void Z9() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        final Integer[] numArr = {Integer.valueOf(ID5.content), Integer.valueOf(ID5.avatar_title_person), Integer.valueOf(ID5.channel_title)};
        X9().e.setAdapter(new C13713gh6(this, this.query));
        new com.google.android.material.tabs.d(X9().g, X9().e, new d.b() { // from class: ir.nasim.lh3
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i) {
                ir.nasim.jaryan.search.ui.fragment.d.aa(this.a, numArr, gVar, i);
            }
        }).a();
        ga();
        X9().e.post(new Runnable() { // from class: ir.nasim.mh3
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.jaryan.search.ui.fragment.d.ba(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(d dVar, Integer[] numArr, TabLayout.g gVar, int i) {
        AbstractC13042fc3.i(dVar, "this$0");
        AbstractC13042fc3.i(numArr, "$title");
        AbstractC13042fc3.i(gVar, "tab");
        gVar.y(dVar.h6(numArr[i].intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(d dVar) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.X9().e.setCurrentItem(dVar.defaultTab.ordinal(), false);
    }

    private final void ca() {
        AbstractC19329q98.a(Q7().getWindow(), X9().getRoot()).a(O98.m.d());
        X9().f.setTypeface(C6011Lu2.k());
        X9().f.setText(this.query);
        X9().f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.jaryan.search.ui.fragment.d.da(this.a, view);
            }
        });
        X9().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.oh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.jaryan.search.ui.fragment.d.ea(this.a, view);
            }
        });
        X9().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ph3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.jaryan.search.ui.fragment.d.fa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(d dVar, View view) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.handleBackPress = true;
        dVar.Q7().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(d dVar, View view) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.handleBackPress = true;
        dVar.V5().G1("request_key_search_Action", AbstractC23348wm0.b(new XV4("arg_search_Action", EnumC4453Fe6.a.toString())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(d dVar, View view) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.handleBackPress = true;
        dVar.V5().G1("request_key_search_Action", AbstractC23348wm0.b(new XV4("arg_search_Action", EnumC4453Fe6.b.toString())));
        dVar.Q7().onBackPressed();
    }

    private final void ga() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        String name;
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(X9().e);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) obj;
            Field declaredField2 = RecyclerView.class.getDeclaredField("O0");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(recyclerView);
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Int");
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * 4));
        } catch (Exception e2) {
            if (d.class.isAnonymousClass()) {
                name = d.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = d.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.j(name, "reduceDragSensitivity: " + e2.getMessage(), new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.query = bundleE5.getString("search_query", "");
            String string = bundleE5.getString("arg_default_tab", "ANY");
            AbstractC13042fc3.h(string, "getString(...)");
            this.defaultTab = EnumC8772Xg3.valueOf(string);
            Y9().V0(this.query);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.cloneInContext(new C16731lm1(S7(), AbstractC14035hE5.Theme_Bale_Base)).inflate(HC5.fragment_jaryan_search_result, container, false);
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        if (this.handleBackPress) {
            return super.a();
        }
        this.handleBackPress = true;
        V5().G1("request_key_search_Action", AbstractC23348wm0.b(new XV4("arg_search_Action", EnumC4453Fe6.a.toString())));
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Z9();
        ca();
    }
}
