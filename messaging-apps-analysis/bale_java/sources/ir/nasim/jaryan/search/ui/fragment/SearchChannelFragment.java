package ir.nasim.jaryan.search.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14035hE5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9869ah6;
import ir.nasim.C11458d25;
import ir.nasim.C12692f25;
import ir.nasim.C14479hz2;
import ir.nasim.C14819iX7;
import ir.nasim.C16130kl1;
import ir.nasim.C16731lm1;
import ir.nasim.C18987pb3;
import ir.nasim.C19938rB7;
import ir.nasim.C22042ua0;
import ir.nasim.C24815zF2;
import ir.nasim.C25226zw5;
import ir.nasim.C3343Am;
import ir.nasim.C6011Lu2;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.EnumC8772Xg3;
import ir.nasim.FF2;
import ir.nasim.GX2;
import ir.nasim.HC5;
import ir.nasim.HJ0;
import ir.nasim.ID5;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC13295fz2;
import ir.nasim.InterfaceC14341hl1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.J17;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.W25;
import ir.nasim.XV4;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.jaryan.search.ui.fragment.SearchChannelFragment;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001AB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lir/nasim/jaryan/search/ui/fragment/SearchChannelFragment;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ja", "ga", "", "query", "ba", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/J17;", "h1", "Lir/nasim/Yu3;", "fa", "()Lir/nasim/J17;", "viewModel", "Lir/nasim/hz2;", "i1", "Lir/nasim/bW7;", "ca", "()Lir/nasim/hz2;", "binding", "Lir/nasim/HJ0;", "j1", "Lir/nasim/HJ0;", "channelAdapter", "Lir/nasim/kl1;", "k1", "Lir/nasim/kl1;", "contentsAdapter", "l1", "Ljava/lang/String;", "lastQuerySearch", "Lir/nasim/FF2;", "m1", "Lir/nasim/FF2;", "ea", "()Lir/nasim/FF2;", "setContentRegex", "(Lir/nasim/FF2;)V", "contentRegex", "Lir/nasim/zF2;", "n1", "Lir/nasim/zF2;", "da", "()Lir/nasim/zF2;", "setChannelRegex", "(Lir/nasim/zF2;)V", "channelRegex", "o1", "a", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class SearchChannelFragment extends GX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: j1, reason: from kotlin metadata */
    private HJ0 channelAdapter;

    /* renamed from: k1, reason: from kotlin metadata */
    private C16130kl1 contentsAdapter;

    /* renamed from: l1, reason: from kotlin metadata */
    private String lastQuerySearch;

    /* renamed from: m1, reason: from kotlin metadata */
    public FF2 contentRegex;

    /* renamed from: n1, reason: from kotlin metadata */
    public C24815zF2 channelRegex;
    static final /* synthetic */ InterfaceC5239Im3[] p1 = {AbstractC10882cM5.i(new C25226zw5(SearchChannelFragment.class, "binding", "getBinding()Lir/nasim/jaryan/databinding/FragmentSearchChannelBinding;", 0))};
    public static final int q1 = 8;

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ SearchChannelFragment d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SearchChannelFragment searchChannelFragment, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = searchChannelFragment;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC9869ah6 abstractC9869ah6 = (AbstractC9869ah6) this.c;
                if (abstractC9869ah6 instanceof AbstractC9869ah6.b) {
                    AbstractC9869ah6.b bVar = (AbstractC9869ah6.b) abstractC9869ah6;
                    if (bVar.b().isEmpty() && bVar.a().isEmpty()) {
                        this.d.ca().c.getRoot().setVisibility(0);
                        this.d.ca().f.setVisibility(8);
                        this.d.ca().e.setVisibility(8);
                        this.d.ca().b.setVisibility(8);
                        return C19938rB7.a;
                    }
                    this.d.ca().c.getRoot().setVisibility(8);
                    this.d.ca().f.setVisibility(0);
                    this.d.ca().e.setVisibility(8);
                    this.d.ca().b.setVisibility(0);
                    HJ0 hj0 = this.d.channelAdapter;
                    C16130kl1 c16130kl1 = null;
                    if (hj0 == null) {
                        AbstractC13042fc3.y("channelAdapter");
                        hj0 = null;
                    }
                    hj0.D(bVar.b(), this.d.da().a(this.d.lastQuerySearch));
                    C16130kl1 c16130kl12 = this.d.contentsAdapter;
                    if (c16130kl12 == null) {
                        AbstractC13042fc3.y("contentsAdapter");
                    } else {
                        c16130kl1 = c16130kl12;
                    }
                    c16130kl1.D(bVar.a(), this.d.ea().a(this.d.lastQuerySearch));
                    this.d.V5().G1("request_key_load_suggestion", AbstractC23348wm0.b(new XV4("query_text", this.d.lastQuerySearch)));
                } else {
                    if (!(abstractC9869ah6 instanceof AbstractC9869ah6.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.d.ca().e.setVisibility(0);
                    this.d.ca().b.setVisibility(8);
                    this.d.ca().c.getRoot().setVisibility(8);
                    this.d.ca().f.setVisibility(0);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC9869ah6 abstractC9869ah6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC9869ah6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SearchChannelFragment.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6U0 = SearchChannelFragment.this.fa().U0();
                a aVar = new a(SearchChannelFragment.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6U0, aVar, this) == objE) {
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

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C14479hz2.a(fragment.V7());
        }
    }

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

    public SearchChannelFragment() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(J17.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());
        this.lastQuerySearch = "";
    }

    private final void ba(String query) {
        fa().V0(query);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C14479hz2 ca() {
        return (C14479hz2) this.binding.a(this, p1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final J17 fa() {
        return (J17) this.viewModel.getValue();
    }

    private final void ga() {
        for (int i = 0; i < 7; i++) {
            ca().d.addView(LayoutInflater.from(new C16731lm1(S7(), AbstractC14035hE5.Theme_Bale_Base)).inflate(HC5.peer_loading_item, (ViewGroup) null));
        }
        String strH6 = h6(ID5.content);
        AbstractC13042fc3.h(strH6, "getString(...)");
        this.contentsAdapter = new C16130kl1(strH6, new UA2() { // from class: ir.nasim.Mf6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return SearchChannelFragment.ha(this.a, (InterfaceC14341hl1) obj);
            }
        });
        String strH62 = h6(ID5.channel_title);
        AbstractC13042fc3.h(strH62, "getString(...)");
        this.channelAdapter = new HJ0(strH62, false, new UA2() { // from class: ir.nasim.Nf6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return SearchChannelFragment.ia(this.a, (C12692f25) obj);
            }
        });
        RecyclerView recyclerView = ca().b;
        HJ0 hj0 = this.channelAdapter;
        if (hj0 == null) {
            AbstractC13042fc3.y("channelAdapter");
            hj0 = null;
        }
        C16130kl1 c16130kl1 = this.contentsAdapter;
        if (c16130kl1 == null) {
            AbstractC13042fc3.y("contentsAdapter");
            c16130kl1 = null;
        }
        recyclerView.setAdapter(new androidx.recyclerview.widget.f(hj0, c16130kl1));
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ha(SearchChannelFragment searchChannelFragment, InterfaceC14341hl1 interfaceC14341hl1) {
        AbstractC13042fc3.i(searchChannelFragment, "this$0");
        AbstractC13042fc3.i(interfaceC14341hl1, "it");
        C18987pb3.x1(C18987pb3.a, interfaceC14341hl1.l().e(), Long.valueOf(interfaceC14341hl1.l().f()), Long.valueOf(interfaceC14341hl1.l().d()), true, null, null, false, null, null, false, null, 2032, null);
        XV4 xv4A = AbstractC4616Fw7.a("action_type", 3);
        XV4 xv4A2 = AbstractC4616Fw7.a("query_text", searchChannelFragment.lastQuerySearch);
        XV4 xv4A3 = AbstractC4616Fw7.a("event_type", "any");
        XV4 xv4A4 = AbstractC4616Fw7.a(DialogEntity.COLUMN_RID, Long.valueOf(interfaceC14341hl1.l().f()));
        XV4 xv4A5 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(interfaceC14341hl1.l().e().getPeerId()));
        String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        XV4 xv4A6 = AbstractC4616Fw7.a("peer_type", lowerCase);
        C16130kl1 c16130kl1 = searchChannelFragment.contentsAdapter;
        if (c16130kl1 == null) {
            AbstractC13042fc3.y("contentsAdapter");
            c16130kl1 = null;
        }
        C3343Am.i("flow_search_v2", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, xv4A6, AbstractC4616Fw7.a("index", Integer.valueOf(c16130kl1.z().indexOf(interfaceC14341hl1) + 1))));
        searchChannelFragment.V5().G1("request_key_click_on_content", AbstractC23348wm0.b(new XV4("arg_is_peer", Boolean.FALSE), new XV4("query_text", searchChannelFragment.lastQuerySearch)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ia(SearchChannelFragment searchChannelFragment, C12692f25 c12692f25) {
        AbstractC13042fc3.i(searchChannelFragment, "this$0");
        AbstractC13042fc3.i(c12692f25, "it");
        XV4 xv4A = AbstractC4616Fw7.a("action_type", 3);
        XV4 xv4A2 = AbstractC4616Fw7.a("query_text", searchChannelFragment.lastQuerySearch);
        XV4 xv4A3 = AbstractC4616Fw7.a("event_type", "channel");
        XV4 xv4A4 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(c12692f25.b()));
        String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        XV4 xv4A5 = AbstractC4616Fw7.a("peer_type", lowerCase);
        HJ0 hj0 = searchChannelFragment.channelAdapter;
        if (hj0 == null) {
            AbstractC13042fc3.y("channelAdapter");
            hj0 = null;
        }
        C3343Am.i("flow_search_v2", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, AbstractC4616Fw7.a("index", Integer.valueOf(hj0.z().indexOf(c12692f25) + 1))));
        C18987pb3.x1(C18987pb3.a, new C11458d25(W25.b, c12692f25.b()), null, null, false, null, null, false, null, null, false, null, 2046, null);
        searchChannelFragment.V5().G1("request_key_click_on_content", AbstractC23348wm0.b(new XV4("arg_is_peer", Boolean.TRUE), new XV4("query_text", Integer.valueOf(c12692f25.a().r())), new XV4("peer_title", c12692f25.e())));
        return C19938rB7.a;
    }

    private final void ja() {
        ca().c.b.setTypeface(C6011Lu2.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ka(SearchChannelFragment searchChannelFragment, String str, Bundle bundle) {
        AbstractC13042fc3.i(searchChannelFragment, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        String string = bundle.getString("query_text", "");
        searchChannelFragment.lastQuerySearch = string;
        AbstractC13042fc3.f(string);
        searchChannelFragment.ba(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(SearchChannelFragment searchChannelFragment, View view) {
        AbstractC13042fc3.i(searchChannelFragment, "this$0");
        C3343Am.i("flow_search_v2", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 4), AbstractC4616Fw7.a("query_text", searchChannelFragment.lastQuerySearch), AbstractC4616Fw7.a("event_type", "ui")));
        C22042ua0.A9(searchChannelFragment, ir.nasim.jaryan.search.ui.fragment.d.INSTANCE.a(searchChannelFragment.lastQuerySearch, EnumC8772Xg3.b), false, null, 6, null);
        searchChannelFragment.V5().G1("request_key_click_on_content", AbstractC23348wm0.b(new XV4("arg_is_peer", Boolean.FALSE), new XV4("query_text", searchChannelFragment.lastQuerySearch)));
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        FragmentManager fragmentManagerO5;
        super.M6(savedInstanceState);
        Fragment fragmentU5 = U5();
        if (fragmentU5 == null || (fragmentManagerO5 = fragmentU5.O5()) == null) {
            return;
        }
        fragmentManagerO5.H1("request_key_do_jaryan_search", this, new InterfaceC13295fz2() { // from class: ir.nasim.Lf6
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                SearchChannelFragment.ka(this.a, str, bundle);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.cloneInContext(new C16731lm1(S7(), AbstractC14035hE5.Theme_Bale_Base)).inflate(HC5.fragment_search_channel, container, false);
    }

    public final C24815zF2 da() {
        C24815zF2 c24815zF2 = this.channelRegex;
        if (c24815zF2 != null) {
            return c24815zF2;
        }
        AbstractC13042fc3.y("channelRegex");
        return null;
    }

    public final FF2 ea() {
        FF2 ff2 = this.contentRegex;
        if (ff2 != null) {
            return ff2;
        }
        AbstractC13042fc3.y("contentRegex");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ca().f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Kf6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SearchChannelFragment.la(this.a, view2);
            }
        });
        ja();
        ga();
    }
}
