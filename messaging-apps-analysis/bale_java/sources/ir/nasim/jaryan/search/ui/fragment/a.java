package ir.nasim.jaryan.search.ui.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13999hA5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC17008mE5;
import ir.nasim.AbstractC18163oB5;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C11458d25;
import ir.nasim.C14819iX7;
import ir.nasim.C16731lm1;
import ir.nasim.C18987pb3;
import ir.nasim.C19938rB7;
import ir.nasim.C20245rh3;
import ir.nasim.C22042ua0;
import ir.nasim.C24493yi5;
import ir.nasim.C25226zw5;
import ir.nasim.C3343Am;
import ir.nasim.C6011Lu2;
import ir.nasim.C6047Ly2;
import ir.nasim.C9059Yh6;
import ir.nasim.C9293Zh6;
import ir.nasim.ED1;
import ir.nasim.EnumC25253zz5;
import ir.nasim.EnumC4453Fe6;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.EnumC8772Xg3;
import ir.nasim.HC5;
import ir.nasim.HG1;
import ir.nasim.ID5;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC13295fz2;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.O98;
import ir.nasim.OY0;
import ir.nasim.SA2;
import ir.nasim.SW2;
import ir.nasim.UA2;
import ir.nasim.W25;
import ir.nasim.XV4;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.core.modules.market.model.SearchSuggestionRow;
import ir.nasim.jaryan.search.ui.fragment.a;
import ir.nasim.jaryan.search.ui.fragment.d;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001UB\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010 \u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0011H\u0002¢\u0006\u0004\b%\u0010\u0006J\u001f\u0010(\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0011H\u0002¢\u0006\u0004\b*\u0010\u0006J1\u00100\u001a\u00020\u00112\b\b\u0001\u0010,\u001a\u00020+2\b\b\u0001\u0010-\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110.H\u0002¢\u0006\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00107R\u0016\u0010:\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010=\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00104R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001b\u0010K\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006V"}, d2 = {"Lir/nasim/jaryan/search/ui/fragment/a;", "Lir/nasim/ua0;", "Lir/nasim/Zh6$a;", "Lir/nasim/Yh6$a;", "Lir/nasim/Yh6$b;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "i9", "R6", "Lir/nasim/core/modules/market/model/SearchSuggestion;", "item", "k5", "(Lir/nasim/core/modules/market/model/SearchSuggestion;)V", "Lir/nasim/core/modules/market/model/SearchSuggestionRow;", "n5", "(Lir/nasim/core/modules/market/model/SearchSuggestionRow;)V", "i1", "", "query", "Aa", "(Ljava/lang/String;)V", "Ba", "ka", "ua", "la", "Lir/nasim/zz5;", "queryType", "ta", "(Ljava/lang/String;Lir/nasim/zz5;)V", "ma", "", "title", "description", "Lkotlin/Function0;", "remove", "sa", "(IILir/nasim/SA2;)V", "", "h1", "Z", "startedSearch", "", "J", "timeInSearch", "j1", "mustCloseFragment", "k1", "Ljava/lang/String;", "lastQueryLoaded", "l1", "clickedOnNewQuerySearch", "Lir/nasim/rh3;", "m1", "Lir/nasim/Yu3;", "ja", "()Lir/nasim/rh3;", "viewModel", "Lir/nasim/Ly2;", "n1", "Lir/nasim/bW7;", "ia", "()Lir/nasim/Ly2;", "binding", "Lir/nasim/Zh6;", "o1", "Lir/nasim/Zh6;", "suggestionRowAdapter", "Lir/nasim/yi5;", "p1", "Lir/nasim/yi5;", "popularAdapter", "q1", "a", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class a extends SW2 implements C9293Zh6.a, C9059Yh6.a, C9059Yh6.b {

    /* renamed from: h1, reason: from kotlin metadata */
    private boolean startedSearch;

    /* renamed from: i1, reason: from kotlin metadata */
    private long timeInSearch;

    /* renamed from: j1, reason: from kotlin metadata */
    private boolean mustCloseFragment;

    /* renamed from: k1, reason: from kotlin metadata */
    private String lastQueryLoaded = "";

    /* renamed from: l1, reason: from kotlin metadata */
    private boolean clickedOnNewQuerySearch = true;

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: n1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: o1, reason: from kotlin metadata */
    private final C9293Zh6 suggestionRowAdapter;

    /* renamed from: p1, reason: from kotlin metadata */
    private final C24493yi5 popularAdapter;
    static final /* synthetic */ InterfaceC5239Im3[] r1 = {AbstractC10882cM5.i(new C25226zw5(a.class, "binding", "getBinding()Lir/nasim/jaryan/databinding/FragmentNewJaryanSearchBinding;", 0))};

    /* renamed from: q1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int s1 = 8;

    /* renamed from: ir.nasim.jaryan.search.ui.fragment.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ a b(Companion companion, String str, EnumC8772Xg3 enumC8772Xg3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "";
            }
            if ((i & 2) != 0) {
                enumC8772Xg3 = EnumC8772Xg3.b;
            }
            return companion.a(str, enumC8772Xg3);
        }

        public final a a(String str, EnumC8772Xg3 enumC8772Xg3) {
            AbstractC13042fc3.i(str, "query");
            AbstractC13042fc3.i(enumC8772Xg3, "defaultTab");
            a aVar = new a();
            aVar.a8(AbstractC23348wm0.b(new XV4("arg_query", str), new XV4("arg_default_tab", enumC8772Xg3.toString())));
            return aVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.jaryan.search.ui.fragment.a$b$a, reason: collision with other inner class name */
        static final class C1320a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ a d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1320a(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1320a c1320a = new C1320a(this.d, interfaceC20295rm1);
                c1320a.c = obj;
                return c1320a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ArrayList arrayList = (ArrayList) this.c;
                if (!arrayList.isEmpty()) {
                    C9293Zh6 c9293Zh6 = this.d.suggestionRowAdapter;
                    String strH6 = this.d.h6(ID5.search_menu_recent);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    c9293Zh6.C(AbstractC10360bX0.g(new SearchSuggestionRow(strH6, AbstractC15401jX0.T0(arrayList), true)));
                } else {
                    this.d.suggestionRowAdapter.C(new ArrayList());
                }
                this.d.suggestionRowAdapter.notifyDataSetChanged();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1320a) create(arrayList, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(a.this.ja().W0());
                C1320a c1320a = new C1320a(a.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2F, c1320a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (AbstractC20762sZ6.n1(String.valueOf(editable)).toString().length() == 0) {
                a.this.ia().g.setVisibility(0);
                a.this.ia().e.setImageResource(AbstractC18163oB5.smiles_search);
                ImageView imageView = a.this.ia().e;
                Context context = a.this.ia().getRoot().getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                imageView.setImageTintList(ColorStateList.valueOf(OY0.b(context, AbstractC13999hA5.n100)));
                a.this.ia().d.setVisibility(8);
                return;
            }
            if (!a.this.startedSearch) {
                a.this.ta("", EnumC25253zz5.b);
            }
            ImageView imageView2 = a.this.ia().e;
            Context context2 = a.this.ia().getRoot().getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            imageView2.setImageTintList(ColorStateList.valueOf(OY0.b(context2, AbstractC13999hA5.n300)));
            a.this.ia().e.setImageResource(AbstractC18163oB5.ic_call_close);
            a.this.ia().g.setVisibility(8);
            a.this.ia().d.setVisibility(0);
            FragmentManager fragmentManagerO5 = a.this.O5();
            if (fragmentManagerO5 != null) {
                fragmentManagerO5.G1("request_key_do_jaryan_search", AbstractC23348wm0.b(new XV4("query_text", String.valueOf(editable))));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SearchSuggestion d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SearchSuggestion searchSuggestion, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = searchSuggestion;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(200L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            a aVar = a.this;
            String term = this.d.getTerm();
            if (term == null) {
                term = "";
            }
            aVar.Aa(term);
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
        final /* synthetic */ SearchSuggestion d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SearchSuggestion searchSuggestion, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = searchSuggestion;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(200L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            a aVar = a.this;
            String term = this.d.getTerm();
            if (term == null) {
                term = "";
            }
            aVar.Aa(term);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* renamed from: ir.nasim.jaryan.search.ui.fragment.a$f$a, reason: collision with other inner class name */
        static final class C1321a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            C1321a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.z0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.c0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        f(SA2 sa2, int i, int i2) {
            this.a = sa2;
            this.b = i;
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, SA2 sa2) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(sa2, "$remove");
            dialog.dismiss();
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-8060585, true, new C1321a(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(148181593, true, new b(this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(509494645);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.jaryan.search.ui.fragment.b
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return a.f.d(dialog, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = ID5.delete_this_recent_search_no;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(509502836);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.jaryan.search.ui.fragment.c
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return a.f.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa22, i2, c1454b, (SA2) objB2, ID5.dialog_cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C6047Ly2.a(fragment.V7());
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public a() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new i(new h(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C20245rh3.class), new j(interfaceC9173Yu3B), new k(null, interfaceC9173Yu3B), new l(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new g(), AbstractC20046rN7.c());
        this.suggestionRowAdapter = new C9293Zh6();
        this.popularAdapter = new C24493yi5(new UA2() { // from class: ir.nasim.fh3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.jaryan.search.ui.fragment.a.ra(this.a, (SearchSuggestion) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa(String query) {
        ia().h.setText(query);
        ia().h.setSelection(query.length());
    }

    private final void Ba() {
        if (this.mustCloseFragment) {
            return;
        }
        AbstractC19329q98.a(Q7().getWindow(), ia().h).e(O98.m.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6047Ly2 ia() {
        return (C6047Ly2) this.binding.a(this, r1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C20245rh3 ja() {
        return (C20245rh3) this.viewModel.getValue();
    }

    private final void ka() {
        AbstractC19329q98.a(Q7().getWindow(), ia().h).a(O98.m.d());
    }

    private final void la() {
        C9293Zh6 c9293Zh6 = this.suggestionRowAdapter;
        c9293Zh6.D(this);
        c9293Zh6.E(this);
        c9293Zh6.F(this);
        ia().g.setAdapter(new androidx.recyclerview.widget.f(this.suggestionRowAdapter, this.popularAdapter));
        this.popularAdapter.B(ja().V0());
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(null), 3, null);
    }

    private final void ma() {
        ia().f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.dh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.jaryan.search.ui.fragment.a.na(this.a, view);
            }
        });
        ia().h.setTypeface(C6011Lu2.k());
        EditText editText = ia().h;
        AbstractC13042fc3.h(editText, "searchTextInput");
        editText.addTextChangedListener(new c());
        ia().h.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.eh3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return ir.nasim.jaryan.search.ui.fragment.a.oa(this.a, textView, i2, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(a aVar, View view) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.ka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean oa(a aVar, TextView textView, int i2, KeyEvent keyEvent) {
        AbstractC13042fc3.i(aVar, "this$0");
        String string = textView.getText().toString();
        if (string.length() <= 0) {
            return false;
        }
        C3343Am.i("flow_search_v2", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 4), AbstractC4616Fw7.a("query_text", string), AbstractC4616Fw7.a("event_type", "keyboard")));
        C22042ua0.A9(aVar, d.Companion.b(ir.nasim.jaryan.search.ui.fragment.d.INSTANCE, string, null, 2, null), false, null, 6, null);
        aVar.ja().T0(string);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.ja().U0();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(a aVar, SearchSuggestion searchSuggestion) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(searchSuggestion, "$item");
        aVar.ja().Y0(searchSuggestion);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(a aVar, SearchSuggestion searchSuggestion) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(searchSuggestion, "it");
        String term = searchSuggestion.getTerm();
        if (term == null) {
            term = "";
        }
        aVar.ta(term, EnumC25253zz5.d);
        d.Companion companion = ir.nasim.jaryan.search.ui.fragment.d.INSTANCE;
        String term2 = searchSuggestion.getTerm();
        C22042ua0.A9(aVar, companion.a(term2 != null ? term2 : "", searchSuggestion.getDefaultTab()), false, null, 6, null);
        AbstractC10533bm0.d(AbstractC16751lo1.a(aVar), null, null, aVar.new e(searchSuggestion, null), 3, null);
        return C19938rB7.a;
    }

    private final void sa(int title, int description, SA2 remove) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(808004731, true, new f(remove, title, description)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(String query, EnumC25253zz5 queryType) {
        this.startedSearch = true;
        C3343Am.i("flow_search_v2", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 2), AbstractC4616Fw7.a("query_type", Integer.valueOf(queryType.j())), AbstractC4616Fw7.a("query_text", query)));
    }

    private final void ua() {
        FragmentManager fragmentManagerO5 = O5();
        if (fragmentManagerO5 != null) {
            fragmentManagerO5.H1("request_key_search_Action", p6(), new InterfaceC13295fz2() { // from class: ir.nasim.Yg3
                @Override // ir.nasim.InterfaceC13295fz2
                public final void a(String str, Bundle bundle) {
                    ir.nasim.jaryan.search.ui.fragment.a.va(this.a, str, bundle);
                }
            });
        }
        F5().H1("request_key_click_on_content", p6(), new InterfaceC13295fz2() { // from class: ir.nasim.Zg3
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                ir.nasim.jaryan.search.ui.fragment.a.wa(this.a, str, bundle);
            }
        });
        F5().H1("request_key_load_suggestion", p6(), new InterfaceC13295fz2() { // from class: ir.nasim.ah3
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                ir.nasim.jaryan.search.ui.fragment.a.xa(this.a, str, bundle);
            }
        });
        ia().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.jaryan.search.ui.fragment.a.ya(this.a, view);
            }
        });
        ia().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ch3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.jaryan.search.ui.fragment.a.za(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(a aVar, String str, Bundle bundle) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "result");
        try {
            String string = bundle.getString("arg_search_Action", "");
            AbstractC13042fc3.h(string, "getString(...)");
            if (EnumC4453Fe6.valueOf(string) == EnumC4453Fe6.a) {
                aVar.mustCloseFragment = true;
                aVar.Q7().onBackPressed();
                aVar.Q7().onBackPressed();
            } else {
                aVar.ia().h.setText("");
            }
        } catch (Exception unused) {
            aVar.Q7().onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(a aVar, String str, Bundle bundle) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "result");
        aVar.ka();
        aVar.clickedOnNewQuerySearch = true;
        if (bundle.getBoolean("arg_is_peer")) {
            C20245rh3 c20245rh3Ja = aVar.ja();
            String string = bundle.getString("peer_title", "");
            AbstractC13042fc3.h(string, "getString(...)");
            c20245rh3Ja.S0(string, bundle.getInt("query_text"));
            return;
        }
        C20245rh3 c20245rh3Ja2 = aVar.ja();
        String string2 = bundle.getString("query_text", "");
        AbstractC13042fc3.h(string2, "getString(...)");
        c20245rh3Ja2.T0(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(a aVar, String str, Bundle bundle) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "result");
        String string = bundle.getString("query_text", "");
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = AbstractC20762sZ6.n1(string).toString();
        aVar.lastQueryLoaded = string2;
        if (string2.length() > 0) {
            aVar.clickedOnNewQuerySearch = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ya(a aVar, View view) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.ia().h.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(a aVar, View view) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.Q7().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String string;
        String string2;
        AbstractC13042fc3.i(inflater, "inflater");
        Bundle bundleE5 = E5();
        String str = "";
        if (bundleE5 != null && (string2 = bundleE5.getString("arg_query", "")) != null) {
            str = string2;
        }
        if (str.length() > 0) {
            Bundle bundleE52 = E5();
            String str2 = "ANY";
            if (bundleE52 != null && (string = bundleE52.getString("arg_default_tab", "ANY")) != null) {
                str2 = string;
            }
            C22042ua0.A9(this, ir.nasim.jaryan.search.ui.fragment.d.INSTANCE.a(str, EnumC8772Xg3.valueOf(str2)), false, null, 6, null);
        }
        return inflater.cloneInContext(new C16731lm1(G5(), AbstractC17008mE5.Theme_Bale_Base)).inflate(HC5.fragment_new_jaryan_search, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        C3343Am.i("flow_search_v2", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 7), AbstractC4616Fw7.a("duration_seconds", Long.valueOf((System.currentTimeMillis() - this.timeInSearch) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT))));
        if (!this.clickedOnNewQuerySearch) {
            C3343Am.i("flow_search_v2", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 8), AbstractC4616Fw7.a("query_text", this.lastQueryLoaded)));
        }
        super.R6();
    }

    @Override // ir.nasim.C9059Yh6.b
    public void i1(final SearchSuggestion item) {
        AbstractC13042fc3.i(item, "item");
        sa(ID5.story_delete_button, ID5.are_you_sure_you_want_to_delete_this_recently_search, new SA2() { // from class: ir.nasim.hh3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.jaryan.search.ui.fragment.a.qa(this.a, item);
            }
        });
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        if (o6() != null) {
            Ba();
        }
    }

    @Override // ir.nasim.C9059Yh6.a
    public void k5(SearchSuggestion item) {
        String str;
        String title;
        String term;
        AbstractC13042fc3.i(item, "item");
        str = "";
        if (item.getAction() == SearchSuggestion.a.a && (term = item.getTerm()) != null && term.length() != 0) {
            String term2 = item.getTerm();
            if (term2 == null) {
                term2 = "";
            }
            ta(term2, EnumC25253zz5.c);
            d.Companion companion = ir.nasim.jaryan.search.ui.fragment.d.INSTANCE;
            String term3 = item.getTerm();
            C22042ua0.A9(this, d.Companion.b(companion, term3 != null ? term3 : "", null, 2, null), false, null, 6, null);
            AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new d(item, null), 3, null);
            return;
        }
        if (item.getPeer() != null) {
            this.startedSearch = true;
            XV4 xv4A = AbstractC4616Fw7.a("action_type", 2);
            XV4 xv4A2 = AbstractC4616Fw7.a("query_type", EnumC25253zz5.c);
            SearchSuggestion.Peer peer = item.getPeer();
            if (peer != null && (title = peer.getTitle()) != null) {
                str = title;
            }
            XV4 xv4A3 = AbstractC4616Fw7.a("query_text", str);
            SearchSuggestion.Peer peer2 = item.getPeer();
            C3343Am.i("flow_search_v2", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a("peer_id", Integer.valueOf(peer2 != null ? peer2.getId() : 0))));
            C18987pb3 c18987pb3 = C18987pb3.a;
            W25 w25 = W25.b;
            SearchSuggestion.Peer peer3 = item.getPeer();
            C18987pb3.x1(c18987pb3, new C11458d25(w25, peer3 != null ? peer3.getId() : 0), null, null, false, null, null, false, null, null, false, null, 2046, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        String string;
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        this.timeInSearch = System.currentTimeMillis();
        ma();
        la();
        ua();
        ia().h.requestFocus();
        Ba();
        Bundle bundleE5 = E5();
        String str = "";
        if (bundleE5 != null && (string = bundleE5.getString("arg_query", "")) != null) {
            str = string;
        }
        if (str.length() > 0) {
            ia().h.setText(str);
        }
    }

    @Override // ir.nasim.C9293Zh6.a
    public void n5(SearchSuggestionRow item) {
        AbstractC13042fc3.i(item, "item");
        sa(ID5.market_search_clear_all, ID5.are_you_sure_you_want_to_delete_all_recently_searches, new SA2() { // from class: ir.nasim.gh3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.jaryan.search.ui.fragment.a.pa(this.a);
            }
        });
    }
}
