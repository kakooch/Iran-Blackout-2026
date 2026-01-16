package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC20375ru1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lir/nasim/tA3;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lir/nasim/rB7;", "I8", "H8", "E8", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/py2;", "b1", "Lir/nasim/bW7;", "C8", "()Lir/nasim/py2;", "binding", "Lir/nasim/Wy6;", "c1", "Lir/nasim/Yu3;", "D8", "()Lir/nasim/Wy6;", "viewModel", "", "d1", "Z", "loadInitialMember", "e1", "a", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.tA3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21137tA3 extends WW2 {

    /* renamed from: b1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new d(), AbstractC20046rN7.c());

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: d1, reason: from kotlin metadata */
    private boolean loadInitialMember;
    static final /* synthetic */ InterfaceC5239Im3[] f1 = {AbstractC10882cM5.i(new C25226zw5(C21137tA3.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentLinkProfileBinding;", 0))};

    /* renamed from: e1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int g1 = 8;

    /* renamed from: ir.nasim.tA3$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C21137tA3 a() {
            return new C21137tA3();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tA3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ DA3 d;

        /* renamed from: ir.nasim.tA3$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ DA3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(DA3 da3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = da3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NT4 nt4 = (NT4) this.c;
                    DA3 da3 = this.d;
                    this.b = 1;
                    if (da3.L(nt4, this) == objE) {
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
                return ((a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(DA3 da3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = da3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21137tA3.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2K3 = C21137tA3.this.D8().k3();
                if (interfaceC4557Fq2K3 != null) {
                    a aVar = new a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2K3, aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tA3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ DA3 c;
        final /* synthetic */ C21137tA3 d;

        /* renamed from: ir.nasim.tA3$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C21137tA3 d;
            final /* synthetic */ DA3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21137tA3 c21137tA3, DA3 da3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21137tA3;
                this.e = da3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
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
                    this.d.C8().e.setVisibility(0);
                    this.d.C8().d.setVisibility(8);
                    this.d.C8().b.setVisibility(8);
                } else if (!(abstractC13460gG3D instanceof AbstractC13460gG3.c)) {
                    this.d.C8().e.setVisibility(0);
                    this.d.C8().d.setVisibility(8);
                    this.d.C8().b.setVisibility(8);
                } else if (this.e.getItemCount() == 0) {
                    this.d.C8().b.setVisibility(0);
                    this.d.C8().e.setVisibility(8);
                    this.d.C8().d.setVisibility(8);
                } else {
                    this.d.C8().e.setVisibility(8);
                    this.d.C8().d.setVisibility(0);
                    this.d.C8().b.setVisibility(8);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(DA3 da3, C21137tA3 c21137tA3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = da3;
            this.d = c21137tA3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2E = this.c.E();
                a aVar = new a(this.d, this.c, null);
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tA3$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C19214py2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.tA3$e */
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

    /* renamed from: ir.nasim.tA3$f */
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

    /* renamed from: ir.nasim.tA3$g */
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

    /* renamed from: ir.nasim.tA3$h */
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

    public C21137tA3() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new SA2() { // from class: ir.nasim.qA3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21137tA3.J8(this.a);
            }
        }));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C8671Wy6.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19214py2 C8() {
        Object objA = this.binding.a(this, f1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C19214py2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8671Wy6 D8() {
        return (C8671Wy6) this.viewModel.getValue();
    }

    private final void E8() {
        DA3 da3 = new DA3(D8().v3(), D8().F3(), D8().Z3(), new UA2() { // from class: ir.nasim.rA3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21137tA3.F8(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.sA3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21137tA3.G8(this.a, (C9562aA3) obj);
            }
        });
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(da3, null), 3, null);
        C8().d.setAdapter(da3);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new c(da3, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F8(C21137tA3 c21137tA3, boolean z) {
        AbstractC13042fc3.i(c21137tA3, "this$0");
        c21137tA3.D8().x4(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G8(C21137tA3 c21137tA3, C9562aA3 c9562aA3) {
        AbstractC13042fc3.i(c21137tA3, "this$0");
        AbstractC13042fc3.i(c9562aA3, "item");
        c21137tA3.D8().g4(c9562aA3);
        return C19938rB7.a;
    }

    private final void H8() {
        ImageView imageView = C8().c;
        if (C5495Jo7.a.J2()) {
            imageView.setImageResource(AbstractC22412vB5.empty_link_state_dark);
        } else {
            imageView.setImageResource(AbstractC22412vB5.empty_link_state_light);
        }
    }

    private final void I8() {
        C8().f.setTypeface(C6011Lu2.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC15408jX7 J8(C21137tA3 c21137tA3) {
        AbstractC13042fc3.i(c21137tA3, "this$0");
        Fragment fragmentU7 = c21137tA3.U7();
        AbstractC13042fc3.h(fragmentU7, "requireParentFragment(...)");
        return fragmentU7;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.cloneInContext(new C16731lm1(S7(), AbstractC15235jE5.Theme_Bale_Base)).inflate(QC5.fragment_link_profile, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        I8();
        H8();
        E8();
    }
}
