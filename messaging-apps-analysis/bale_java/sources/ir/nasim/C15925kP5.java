package ir.nasim;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20375ru1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0003R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R0\u00109\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006<"}, d2 = {"Lir/nasim/kP5;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Lir/nasim/rB7;", "e9", "Lir/nasim/hP5;", "Y8", "()Lir/nasim/hP5;", "Lir/nasim/uP5;", "reportItem", "c9", "(Lir/nasim/uP5;)V", "adapter", "g9", "(Lir/nasim/hP5;)V", "Lir/nasim/gj3;", "X8", "(Lir/nasim/hP5;)Lir/nasim/gj3;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "Lir/nasim/lP5;", "s1", "Lir/nasim/bW7;", "a9", "()Lir/nasim/lP5;", "binding", "Lir/nasim/mP5;", "t1", "Lir/nasim/Yu3;", "b9", "()Lir/nasim/mP5;", "viewModel", "u1", "Lir/nasim/hP5;", "Lkotlin/Function1;", "Lir/nasim/OP5;", "v1", "Lir/nasim/UA2;", "getOnItemSelected", "()Lir/nasim/UA2;", "d9", "(Lir/nasim/UA2;)V", "onItemSelected", "w1", "a", "report_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.kP5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15925kP5 extends DX2 {

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());

    /* renamed from: t1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: u1, reason: from kotlin metadata */
    private C14134hP5 adapter;

    /* renamed from: v1, reason: from kotlin metadata */
    private UA2 onItemSelected;
    static final /* synthetic */ InterfaceC5239Im3[] x1 = {AbstractC10882cM5.i(new C25226zw5(C15925kP5.class, "binding", "getBinding()Lir/nasim/report/databinding/ReportBottomSheetBinding;", 0))};

    /* renamed from: w1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ir.nasim.kP5$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C15925kP5 a(String str, String str2, String str3, UA2 ua2) {
            AbstractC13042fc3.i(str, "fragmentResultKey");
            AbstractC13042fc3.i(str2, "selectedReportTitleKey");
            AbstractC13042fc3.i(str3, "selectedReportTypeKey");
            C15925kP5 c15925kP5 = new C15925kP5();
            c15925kP5.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("argumentFragmentResultKey", str), AbstractC4616Fw7.a("argumentSelectedReportTitleKey", str2), AbstractC4616Fw7.a("argumentSelectedReportTypeKey", str3)));
            c15925kP5.d9(ua2);
            return c15925kP5;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.kP5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14134hP5 d;

        /* renamed from: ir.nasim.kP5$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14134hP5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14134hP5 c14134hP5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14134hP5;
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
                this.d.C(((C10160bA7) this.c).a());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C10160bA7 c10160bA7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c10160bA7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C14134hP5 c14134hP5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c14134hP5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15925kP5.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R0 = C15925kP5.this.b9().R0();
                a aVar = new a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2R0, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.kP5$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C16516lP5.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.kP5$d */
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

    /* renamed from: ir.nasim.kP5$e */
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

    /* renamed from: ir.nasim.kP5$f */
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

    /* renamed from: ir.nasim.kP5$g */
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

    /* renamed from: ir.nasim.kP5$h */
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

    public C15925kP5() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C17107mP5.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    private final InterfaceC13730gj3 X8(C14134hP5 adapter) {
        return AbstractC16751lo1.c(this, j.b.STARTED, new b(adapter, null));
    }

    private final C14134hP5 Y8() {
        return new C14134hP5(new UA2() { // from class: ir.nasim.jP5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15925kP5.Z8(this.a, (C21948uP5) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z8(C15925kP5 c15925kP5, C21948uP5 c21948uP5) {
        AbstractC13042fc3.i(c15925kP5, "this$0");
        AbstractC13042fc3.i(c21948uP5, "reportItem");
        UA2 ua2 = c15925kP5.onItemSelected;
        if (ua2 != null) {
            ua2.invoke(c21948uP5.b());
            c15925kP5.v8();
        } else {
            c15925kP5.c9(c21948uP5);
            c15925kP5.u8();
        }
        return C19938rB7.a;
    }

    private final C16516lP5 a9() {
        return (C16516lP5) this.binding.a(this, x1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17107mP5 b9() {
        return (C17107mP5) this.viewModel.getValue();
    }

    private final void c9(C21948uP5 reportItem) {
        Bundle bundleR7 = R7();
        AbstractC13042fc3.h(bundleR7, "requireArguments(...)");
        String string = bundleR7.getString("argumentFragmentResultKey");
        if (string == null) {
            return;
        }
        Bundle bundle = new Bundle();
        String string2 = bundleR7.getString("argumentSelectedReportTitleKey");
        if (string2 != null) {
            bundle.putInt(string2, reportItem.c());
        }
        String string3 = bundleR7.getString("argumentSelectedReportTypeKey");
        if (string3 != null) {
            bundle.putSerializable(string3, reportItem.b());
        }
        AbstractC18623oy2.c(this, string, bundle);
    }

    private final void e9() {
        a9().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iP5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15925kP5.f9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f9(C15925kP5 c15925kP5, View view) {
        AbstractC13042fc3.i(c15925kP5, "this$0");
        c15925kP5.u8();
    }

    private final void g9(C14134hP5 adapter) {
        RecyclerView recyclerView = a9().c;
        recyclerView.setAdapter(adapter);
        C16731lm1 c16731lm1 = new C16731lm1(S7(), AbstractC14637iE5.Theme_Bale_Base);
        OZ oz = new OZ(c16731lm1, 1, false);
        Drawable drawableF = AbstractC4043Dl1.f(c16731lm1, AbstractC21148tB5.list_divider);
        if (drawableF != null) {
            oz.o(drawableF);
        }
        recyclerView.addItemDecoration(oz);
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        return new com.google.android.material.bottomsheet.a(S7(), AbstractC14637iE5.Theme_ReportBottomSheet);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C16516lP5 c16516lP5C = C16516lP5.c(inflater, container, false);
        c16516lP5C.d.setTypeface(C6011Lu2.i());
        c16516lP5C.d.setTextSize(16.0f);
        ConstraintLayout root = c16516lP5C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void T6() {
        this.adapter = null;
        super.T6();
    }

    public final void d9(UA2 ua2) {
        this.onItemSelected = ua2;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        C14134hP5 c14134hP5Y8 = Y8();
        this.adapter = c14134hP5Y8;
        g9(c14134hP5Y8);
        e9();
        X8(c14134hP5Y8);
    }
}
