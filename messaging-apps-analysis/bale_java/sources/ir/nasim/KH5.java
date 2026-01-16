package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13863gw6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.InterfaceC24633yw6;
import ir.nasim.O98;
import ir.nasim.components.appbar.view.BaleToolbar;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0003R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00065"}, d2 = {"Lir/nasim/KH5;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lir/nasim/rB7;", "A8", "Lir/nasim/IH5;", "adapter", "Lir/nasim/gj3;", "z8", "(Lir/nasim/IH5;)Lir/nasim/gj3;", "I8", "C8", "()Lir/nasim/IH5;", "Lir/nasim/gw6$c;", "option", "F8", "(Lir/nasim/gw6$c;)V", "Lir/nasim/gw6$d;", "item", "G8", "(Lir/nasim/gw6$d;)V", "H8", "(Lir/nasim/IH5;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "Lir/nasim/LH5;", "b1", "Lir/nasim/bW7;", "D8", "()Lir/nasim/LH5;", "binding", "Lir/nasim/TH5;", "c1", "Lir/nasim/Yu3;", "E8", "()Lir/nasim/TH5;", "viewModel", "d1", "Lir/nasim/IH5;", "e1", "a", "reaction_settings_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class KH5 extends BX2 {

    /* renamed from: b1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: d1, reason: from kotlin metadata */
    private IH5 adapter;
    static final /* synthetic */ InterfaceC5239Im3[] f1 = {AbstractC10882cM5.i(new C25226zw5(KH5.class, "binding", "getBinding()Lir/nasim/reaction_settings/databinding/ReactionSettingsFragmentBinding;", 0))};

    /* renamed from: e1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ir.nasim.KH5$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final KH5 a(long j, ZN2 zn2) {
            AbstractC13042fc3.i(zn2, "groupType");
            KH5 kh5 = new KH5();
            kh5.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("ARGUMENT_KEY_PEER_ID", Long.valueOf(j)), AbstractC4616Fw7.a("ARGUMENT_KEY_IS_GROUP", Boolean.valueOf(zn2 == ZN2.GROUP))));
            return kh5;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ IH5 d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ IH5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(IH5 ih5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = ih5;
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
                InterfaceC24633yw6 interfaceC24633yw6 = (InterfaceC24633yw6) this.c;
                if (!AbstractC13042fc3.d(interfaceC24633yw6, InterfaceC24633yw6.c.b)) {
                    if (interfaceC24633yw6 instanceof InterfaceC24633yw6.d) {
                        this.d.C(((InterfaceC24633yw6.d) interfaceC24633yw6).a());
                    } else {
                        if (!(interfaceC24633yw6 instanceof InterfaceC24633yw6.b)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        C19406qI3.b("ReactionSettingsFragment", String.valueOf(((InterfaceC24633yw6.b) interfaceC24633yw6).a().getMessage()));
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC24633yw6 interfaceC24633yw6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC24633yw6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(IH5 ih5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ih5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KH5.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6F1 = KH5.this.E8().f1();
                a aVar = new a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6F1, aVar, this) == objE) {
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

    /* synthetic */ class c extends EB2 implements UA2 {
        c(Object obj) {
            super(1, obj, KH5.class, "onOptionClicked", "onOptionClicked(Lir/nasim/reactionsettings/model/SettingsItem$Option;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((AbstractC13863gw6.c) obj);
            return C19938rB7.a;
        }

        public final void y(AbstractC13863gw6.c cVar) {
            AbstractC13042fc3.i(cVar, "p0");
            ((KH5) this.receiver).F8(cVar);
        }
    }

    /* synthetic */ class d extends EB2 implements UA2 {
        d(Object obj) {
            super(1, obj, KH5.class, "onReactionItemClicked", "onReactionItemClicked(Lir/nasim/reactionsettings/model/SettingsItem$ReactionItem;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((AbstractC13863gw6.d) obj);
            return C19938rB7.a;
        }

        public final void y(AbstractC13863gw6.d dVar) {
            AbstractC13042fc3.i(dVar, "p0");
            ((KH5) this.receiver).G8(dVar);
        }
    }

    public static final class e extends AbstractC8614Ws3 implements UA2 {
        public e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return LH5.a(fragment.V7());
        }
    }

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

    public KH5() {
        super(MC5.reaction_settings_fragment);
        this.binding = AbstractC6056Lz2.f(this, new e(), AbstractC20046rN7.c());
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new g(new f(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(TH5.class), new h(interfaceC9173Yu3B), new i(null, interfaceC9173Yu3B), new j(this, interfaceC9173Yu3B));
    }

    private final void A8() {
        AbstractC12990fW7.E0(D8().getRoot(), new InterfaceC22474vI4() { // from class: ir.nasim.JH5
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view, O98 o98) {
                return KH5.B8(view, o98);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 B8(View view, O98 o98) {
        AbstractC13042fc3.i(view, "root");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.g());
        AbstractC13042fc3.h(l93F, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), l93F.d);
        return new O98.b(o98).e(O98.m.g(), false).a();
    }

    private final IH5 C8() {
        return new IH5(new c(this), new d(this));
    }

    private final LH5 D8() {
        return (LH5) this.binding.a(this, f1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TH5 E8() {
        return (TH5) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F8(AbstractC13863gw6.c option) {
        E8().j1(EnumC18609ow6.a.a(option.g()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G8(AbstractC13863gw6.d item) {
        E8().i1(item.h(), !item.i());
    }

    private final void H8(IH5 adapter) {
        RecyclerView recyclerView = D8().d;
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new OH5(AbstractC4043Dl1.c(recyclerView.getContext(), DA5.background_5), 0, 2, null));
    }

    private final void I8() {
        BaleToolbar baleToolbar = D8().c;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final InterfaceC13730gj3 z8(IH5 adapter) {
        return AbstractC16751lo1.c(this, j.b.STARTED, new b(adapter, null));
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = LH5.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void T6() {
        AbstractC12990fW7.E0(D8().getRoot(), null);
        super.T6();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        IH5 ih5C8 = C8();
        this.adapter = ih5C8;
        H8(ih5C8);
        I8();
        z8(ih5C8);
        A8();
    }
}
