package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC5350Iy6;
import ir.nasim.InterfaceC17445my6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H'¢\u0006\u0004\b\u001b\u0010\u001aJ\u001b\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0018\u00010\"H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0007J\u000f\u0010'\u001a\u00020\bH\u0004¢\u0006\u0004\b'\u0010\u0007J\u000f\u0010(\u001a\u00020\bH\u0004¢\u0006\u0004\b(\u0010\u0007R$\u00100\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R.\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lir/nasim/Ha0;", "Lir/nasim/my6;", TokenNames.T, "Lir/nasim/Iy6;", TokenNames.V, "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ga", "fa", "da", "Landroidx/recyclerview/widget/RecyclerView$p;", "Z9", "()Landroidx/recyclerview/widget/RecyclerView$p;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "W9", "()I", "X9", "Lir/nasim/OT4;", "V9", "()Lir/nasim/OT4;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/Fq2;", "Lir/nasim/NT4;", "aa", "()Lir/nasim/Fq2;", "R6", "S9", "ca", "Landroidx/recyclerview/widget/RecyclerView$o;", "c1", "Landroidx/recyclerview/widget/RecyclerView$o;", "Y9", "()Landroidx/recyclerview/widget/RecyclerView$o;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$o;)V", "itemDecoration", "Lir/nasim/Ey2;", "d1", "Lir/nasim/bW7;", "U9", "()Lir/nasim/Ey2;", "binding", "Lir/nasim/Wy6;", "e1", "Lir/nasim/Yu3;", "ba", "()Lir/nasim/Wy6;", "viewModel", "", "f1", "Z", "loadInitialMember", "g1", "Lir/nasim/OT4;", "T9", "ea", "(Lir/nasim/OT4;)V", "adapter", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Ha0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC4894Ha0<T extends InterfaceC17445my6, V extends AbstractC5350Iy6> extends C22042ua0 {
    static final /* synthetic */ InterfaceC5239Im3[] h1 = {AbstractC10882cM5.i(new C25226zw5(AbstractC4894Ha0.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentMediaProfileBinding;", 0))};
    public static final int i1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private RecyclerView.o itemDecoration;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());

    /* renamed from: e1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: f1, reason: from kotlin metadata */
    private boolean loadInitialMember;

    /* renamed from: g1, reason: from kotlin metadata */
    public OT4 adapter;

    /* renamed from: ir.nasim.Ha0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ha0$a$a, reason: collision with other inner class name */
        static final class C0401a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ AbstractC4894Ha0 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0401a(AbstractC4894Ha0 abstractC4894Ha0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = abstractC4894Ha0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0401a c0401a = new C0401a(this.d, interfaceC20295rm1);
                c0401a.c = obj;
                return c0401a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NT4 nt4 = (NT4) this.c;
                    OT4 ot4T9 = this.d.T9();
                    this.b = 1;
                    if (ot4T9.L(nt4, this) == objE) {
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
            public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0401a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2Aa = AbstractC4894Ha0.this.aa();
                if (interfaceC4557Fq2Aa != null) {
                    C0401a c0401a = new C0401a(AbstractC4894Ha0.this, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2Aa, c0401a, this) == objE) {
                        return objE;
                    }
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ha0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ha0$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ AbstractC4894Ha0 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC4894Ha0 abstractC4894Ha0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = abstractC4894Ha0;
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
                AbstractC13460gG3 abstractC13460gG3D = ((C13628gZ0) this.c).d();
                if (abstractC13460gG3D instanceof AbstractC13460gG3.b) {
                    if (this.d.loadInitialMember) {
                        return C19938rB7.a;
                    }
                    this.d.da();
                } else if (!(abstractC13460gG3D instanceof AbstractC13460gG3.c) || this.d.T9().getItemCount() == 0) {
                    this.d.S9();
                } else {
                    this.d.ca();
                    this.d.loadInitialMember = true;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C13628gZ0 c13628gZ0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c13628gZ0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2E = AbstractC4894Ha0.this.T9().E();
                a aVar = new a(AbstractC4894Ha0.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2E, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Ha0$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C4395Ey2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Ha0$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Ha0$e */
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

    /* renamed from: ir.nasim.Ha0$f */
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
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.Ha0$g */
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
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public AbstractC4894Ha0() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new SA2() { // from class: ir.nasim.Ga0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC4894Ha0.ha(this.a);
            }
        }));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C8671Wy6.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da() {
        U9().e.setVisibility(0);
        U9().f.setVisibility(8);
        U9().b.setVisibility(8);
    }

    private final void fa() {
        ea(V9());
        U9().f.setAdapter(T9());
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new a(null), 3, null);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(null), 3, null);
    }

    private final void ga() {
        U9().g.setTypeface(C6011Lu2.k());
        U9().f.setLayoutManager(Z9());
        RecyclerView.o itemDecoration = getItemDecoration();
        if (itemDecoration != null) {
            U9().f.addItemDecoration(itemDecoration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC15408jX7 ha(AbstractC4894Ha0 abstractC4894Ha0) {
        AbstractC13042fc3.i(abstractC4894Ha0, "this$0");
        Fragment fragmentU7 = abstractC4894Ha0.U7();
        AbstractC13042fc3.h(fragmentU7, "requireParentFragment(...)");
        return fragmentU7;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(QC5.fragment_media_profile, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        U9().f.setAdapter(null);
        super.R6();
    }

    protected final void S9() {
        U9().e.setVisibility(8);
        U9().f.setVisibility(8);
        ComposeView composeView = U9().h;
        AbstractC13042fc3.h(composeView, "searchFile");
        if (composeView.getVisibility() == 0) {
            U9().b.setPadding(0, (int) ((20 * AbstractC3742Cd6.c()) + 0.5d), 0, 0);
        }
        U9().b.setVisibility(0);
        U9().c.setImageResource(W9());
        U9().c.setColorFilter(C5495Jo7.a.v0());
        U9().d.setTypeface(C6011Lu2.k());
        U9().d.setText(h6(X9()));
        U9().h.setVisibility(((CharSequence) ba().g3().getValue()).length() != 0 ? U9().h.getVisibility() : 8);
    }

    public final OT4 T9() {
        OT4 ot4 = this.adapter;
        if (ot4 != null) {
            return ot4;
        }
        AbstractC13042fc3.y("adapter");
        return null;
    }

    public final C4395Ey2 U9() {
        Object objA = this.binding.a(this, h1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C4395Ey2) objA;
    }

    public abstract OT4 V9();

    public abstract int W9();

    public abstract int X9();

    /* renamed from: Y9, reason: from getter */
    public RecyclerView.o getItemDecoration() {
        return this.itemDecoration;
    }

    public RecyclerView.p Z9() {
        return new LinearLayoutManager(S7());
    }

    public abstract InterfaceC4557Fq2 aa();

    public final C8671Wy6 ba() {
        return (C8671Wy6) this.viewModel.getValue();
    }

    protected final void ca() {
        U9().e.setVisibility(8);
        U9().f.setVisibility(0);
        U9().b.setVisibility(8);
    }

    public final void ea(OT4 ot4) {
        AbstractC13042fc3.i(ot4, "<set-?>");
        this.adapter = ot4;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ga();
        fa();
    }
}
