package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC20375ru1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lir/nasim/Cn4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "aa", "Y9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "Lir/nasim/mz2;", "h1", "Lir/nasim/bW7;", "W9", "()Lir/nasim/mz2;", "binding", "Lir/nasim/Wy6;", "i1", "Lir/nasim/Yu3;", "X9", "()Lir/nasim/Wy6;", "viewModel", "j1", "a", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Cn4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3830Cn4 extends AbstractC12385eX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new d(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;
    static final /* synthetic */ InterfaceC5239Im3[] k1 = {AbstractC10882cM5.i(new C25226zw5(C3830Cn4.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentSharedGroupsBinding;", 0))};

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: ir.nasim.Cn4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C3830Cn4 a() {
            return new C3830Cn4();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Cn4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C22176un4 d;

        /* renamed from: ir.nasim.Cn4$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C22176un4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C22176un4 c22176un4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c22176un4;
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
                    C22176un4 c22176un4 = this.d;
                    this.b = 1;
                    if (c22176un4.L(nt4, this) == objE) {
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
        b(C22176un4 c22176un4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c22176un4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3830Cn4.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2P3 = C3830Cn4.this.X9().p3();
                if (interfaceC4557Fq2P3 != null) {
                    a aVar = new a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2P3, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Cn4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C22176un4 c;
        final /* synthetic */ C3830Cn4 d;

        /* renamed from: ir.nasim.Cn4$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C3830Cn4 d;
            final /* synthetic */ C22176un4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C3830Cn4 c3830Cn4, C22176un4 c22176un4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c3830Cn4;
                this.e = c22176un4;
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
                    this.d.W9().d.setVisibility(0);
                    this.d.W9().b.setVisibility(8);
                } else if (!(abstractC13460gG3D instanceof AbstractC13460gG3.c)) {
                    this.d.W9().d.setVisibility(0);
                    this.d.W9().c.setVisibility(8);
                    this.d.W9().b.setVisibility(8);
                } else if (this.e.getItemCount() == 0) {
                    this.d.W9().b.setVisibility(0);
                    this.d.W9().d.setVisibility(8);
                    this.d.W9().c.setVisibility(8);
                } else {
                    this.d.W9().d.setVisibility(8);
                    this.d.W9().c.setVisibility(0);
                    this.d.W9().b.setVisibility(8);
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
        c(C22176un4 c22176un4, C3830Cn4 c3830Cn4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c22176un4;
            this.d = c3830Cn4;
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

    /* renamed from: ir.nasim.Cn4$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C17450mz2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Cn4$e */
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

    /* renamed from: ir.nasim.Cn4$f */
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

    /* renamed from: ir.nasim.Cn4$g */
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

    /* renamed from: ir.nasim.Cn4$h */
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

    public C3830Cn4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new SA2() { // from class: ir.nasim.Bn4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C3830Cn4.ba(this.a);
            }
        }));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C8671Wy6.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17450mz2 W9() {
        Object objA = this.binding.a(this, k1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C17450mz2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8671Wy6 X9() {
        return (C8671Wy6) this.viewModel.getValue();
    }

    private final void Y9() {
        C22176un4 c22176un4 = new C22176un4(new UA2() { // from class: ir.nasim.An4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C3830Cn4.Z9((C21586tn4) obj);
            }
        });
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(c22176un4, null), 3, null);
        W9().c.setAdapter(c22176un4);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new c(c22176un4, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z9(C21586tn4 c21586tn4) {
        AbstractC13042fc3.i(c21586tn4, "it");
        C18987pb3 c18987pb3 = C18987pb3.a;
        C11458d25 c11458d25Y = C11458d25.y(c21586tn4.b());
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        C18987pb3.x1(c18987pb3, c11458d25Y, null, null, false, null, null, false, null, null, false, null, 2046, null);
        return C19938rB7.a;
    }

    private final void aa() {
        W9().e.setTypeface(C6011Lu2.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC15408jX7 ba(C3830Cn4 c3830Cn4) {
        AbstractC13042fc3.i(c3830Cn4, "this$0");
        Fragment fragmentU7 = c3830Cn4.U7();
        AbstractC13042fc3.h(fragmentU7, "requireParentFragment(...)");
        return fragmentU7;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.cloneInContext(new C16731lm1(S7(), AbstractC15235jE5.Theme_Bale_Base)).inflate(QC5.fragment_shared_groups, container, false);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        W9().c.setAdapter(null);
        W9().c.clearOnScrollListeners();
        super.T6();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        aa();
        Y9();
    }
}
