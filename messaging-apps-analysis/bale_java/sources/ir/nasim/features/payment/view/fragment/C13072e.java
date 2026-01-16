package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SapOuterClass$ResponseEnrollNewCard;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C10333bU0;
import ir.nasim.C14819iX7;
import ir.nasim.C17468n10;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C21937uO3;
import ir.nasim.C25226zw5;
import ir.nasim.C3641Bs4;
import ir.nasim.C4152Dx2;
import ir.nasim.C6011Lu2;
import ir.nasim.GY6;
import ir.nasim.InterfaceC10040ay6;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.KB5;
import ir.nasim.NY;
import ir.nasim.O40;
import ir.nasim.QA7;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.YV2;
import ir.nasim.features.bank.mybank.webview.shaparak.ShaparakWebViewActivity;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.view.fragment.C13069b;
import ir.nasim.features.payment.view.fragment.C13072e;
import ir.nasim.features.payment.view.fragment.x;
import ir.nasim.features.payment.view.fragment.y;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J'\u0010\u000f\u001a\u00020\u00042\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\fj\b\u0012\u0004\u0012\u00020\u0006`\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0016J+\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b$\u0010%J)\u0010+\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00105R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00105R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006S"}, d2 = {"Lir/nasim/features/payment/view/fragment/e;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ma", "Lir/nasim/features/payment/data/model/BankCreditCard;", "ha", "()Lir/nasim/features/payment/data/model/BankCreditCard;", "la", "ja", "ka", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "va", "(Ljava/util/ArrayList;)V", "Ba", "Aa", "za", ParameterNames.CARD, "ua", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "newDefault", "wa", "sa", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "Lir/nasim/Bs4;", "h1", "Lir/nasim/Yu3;", "ia", "()Lir/nasim/Bs4;", "viewModel", "Lkotlin/Function1;", "i1", "Lir/nasim/UA2;", "onSetDefaultClick", "j1", "setOnEditClick", "k1", "shaparakAuthenticationClick", "Lir/nasim/Dx2;", "l1", "Lir/nasim/bW7;", "ga", "()Lir/nasim/Dx2;", "binding", "m1", "onDeleteClick", "Lir/nasim/O40;", "n1", "Lir/nasim/O40;", "adapter", "Lir/nasim/uO3;", "o1", "Lir/nasim/uO3;", "itemDecoration", "Lir/nasim/n10;", "p1", "Lir/nasim/n10;", "snackBar", "Lir/nasim/bU0;", "q1", "Lir/nasim/bU0;", "loadingInitData", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.e, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13072e extends YV2 {
    static final /* synthetic */ InterfaceC5239Im3[] r1 = {AbstractC10882cM5.i(new C25226zw5(C13072e.class, "binding", "getBinding()Lir/nasim/databinding/FragmentCardManagementBinding;", 0))};
    public static final int s1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3641Bs4.class), new c(this), new d(null, this), new C1203e(this));

    /* renamed from: i1, reason: from kotlin metadata */
    private UA2 onSetDefaultClick = new UA2() { // from class: ir.nasim.TG0
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return C13072e.ta(this.a, (BankCreditCard) obj);
        }
    };

    /* renamed from: j1, reason: from kotlin metadata */
    private UA2 setOnEditClick = new UA2() { // from class: ir.nasim.UG0
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return C13072e.xa(this.a, (BankCreditCard) obj);
        }
    };

    /* renamed from: k1, reason: from kotlin metadata */
    private UA2 shaparakAuthenticationClick = new UA2() { // from class: ir.nasim.VG0
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return C13072e.ya(this.a, (BankCreditCard) obj);
        }
    };

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new f(), AbstractC20046rN7.c());

    /* renamed from: m1, reason: from kotlin metadata */
    private UA2 onDeleteClick;

    /* renamed from: n1, reason: from kotlin metadata */
    private final O40 adapter;

    /* renamed from: o1, reason: from kotlin metadata */
    private final C21937uO3 itemDecoration;

    /* renamed from: p1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: q1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData;

    /* renamed from: ir.nasim.features.payment.view.fragment.e$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.payment.view.fragment.e$a$a, reason: collision with other inner class name */
        static final class C1201a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13072e c;

            /* renamed from: ir.nasim.features.payment.view.fragment.e$a$a$a, reason: collision with other inner class name */
            static final class C1202a implements InterfaceC4806Gq2 {
                final /* synthetic */ C13072e a;

                C1202a(C13072e c13072e) {
                    this.a = c13072e;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(QA7 qa7, InterfaceC20295rm1 interfaceC20295rm1) {
                    if (qa7 instanceof QA7.d) {
                        C13072e c13072e = this.a;
                        Object objA = ((QA7.d) qa7).a();
                        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.features.payment.data.model.BankCreditCard>");
                        c13072e.va((ArrayList) objA);
                        this.a.Ba();
                        AbstractC16494lN1.a(this.a.loadingInitData);
                    } else if (qa7 instanceof QA7.b) {
                        this.a.Aa();
                        AbstractC16494lN1.a(this.a.loadingInitData);
                    } else if (qa7 instanceof QA7.a) {
                        AbstractC16494lN1.a(this.a.loadingInitData);
                    } else {
                        if (!(qa7 instanceof QA7.c)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        C10333bU0 c10333bU0 = this.a.loadingInitData;
                        FragmentManager fragmentManagerB0 = this.a.Q7().B0();
                        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
                        AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1201a(C13072e c13072e, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13072e;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1201a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10040ay6 interfaceC10040ay6E1 = this.c.ia().e1();
                    C1202a c1202a = new C1202a(this.c);
                    this.b = 1;
                    if (interfaceC10040ay6E1.b(c1202a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1201a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13072e.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13072e c13072e = C13072e.this;
                j.b bVar = j.b.STARTED;
                C1201a c1201a = new C1201a(c13072e, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c13072e, bVar, c1201a, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.e$b */
    public static final class b implements x.a {
        final /* synthetic */ BankCreditCard b;

        b(BankCreditCard bankCreditCard) {
            this.b = bankCreditCard;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            C13072e.this.ua(this.b);
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.e$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.e$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.e$e, reason: collision with other inner class name */
    public static final class C1203e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1203e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.e$f */
    public static final class f extends AbstractC8614Ws3 implements UA2 {
        public f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C4152Dx2.a(fragment.V7());
        }
    }

    public C13072e() {
        UA2 ua2 = new UA2() { // from class: ir.nasim.WG0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13072e.ra(this.a, (BankCreditCard) obj);
            }
        };
        this.onDeleteClick = ua2;
        this.adapter = new O40(O40.a.b, this.shaparakAuthenticationClick, null, ua2, this.onSetDefaultClick, this.setOnEditClick, 4, null);
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        this.itemDecoration = new C21937uO3(aVar.f(14.0f), aVar.f(74.0f), aVar.f(8.0f), aVar.f(14.0f), aVar.f(14.0f));
        this.loadingInitData = new C10333bU0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa() {
        ga().e.setVisibility(0);
        ga().h.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ba() {
        ga().e.setVisibility(8);
        ga().h.setVisibility(0);
    }

    private final C4152Dx2 ga() {
        return (C4152Dx2) this.binding.a(this, r1[0]);
    }

    private final BankCreditCard ha() {
        BankCreditCard bankCreditCard;
        String id;
        Iterator it = ia().k1().iterator();
        do {
            if (!it.hasNext()) {
                return null;
            }
            bankCreditCard = (BankCreditCard) it.next();
            id = bankCreditCard.getId();
        } while (!AbstractC13042fc3.d(id != null ? GY6.b(id) : null, ia().Y()));
        return bankCreditCard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3641Bs4 ia() {
        return (C3641Bs4) this.viewModel.getValue();
    }

    private final void ja() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new a(null), 3, null);
    }

    private final void ka() {
        ga().f.setTypeface(C6011Lu2.i());
        ga().c.setTypeface(C6011Lu2.k());
        ga().b.setTypeface(C6011Lu2.i());
        ga().g.setTypeface(C6011Lu2.i());
    }

    private final void la() {
        ga().i.setAdapter(this.adapter);
        ga().i.addItemDecoration(this.itemDecoration);
    }

    private final void ma() {
        ConstraintLayout root = ga().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        this.snackBar = c17468n10;
        c17468n10.k(ga().g);
        ga().e.setVisibility(8);
        ga().h.setVisibility(8);
        ka();
        la();
        ga().g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.RG0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13072e.na(this.a, view);
            }
        });
        ga().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.SG0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13072e.oa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(C13072e c13072e, View view) {
        AbstractC13042fc3.i(c13072e, "this$0");
        c13072e.za();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(C13072e c13072e, View view) {
        AbstractC13042fc3.i(c13072e, "this$0");
        c13072e.za();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(final C13072e c13072e, View view) {
        AbstractC13042fc3.i(c13072e, "this$0");
        final BankCreditCard bankCreditCardHa = c13072e.ha();
        if (bankCreditCardHa != null) {
            c13072e.ia().z0(bankCreditCardHa).m0(new InterfaceC24449ye1() { // from class: ir.nasim.YG0
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C13072e.qa(this.a, bankCreditCardHa, (SapOuterClass$ResponseEnrollNewCard) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(C13072e c13072e, BankCreditCard bankCreditCard, SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard) {
        AbstractC13042fc3.i(c13072e, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        ShaparakWebViewActivity.Companion companion = ShaparakWebViewActivity.INSTANCE;
        Context contextS7 = c13072e.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        String number = bankCreditCard.getNumber();
        String url = sapOuterClass$ResponseEnrollNewCard.getUrl();
        AbstractC13042fc3.h(url, "getUrl(...)");
        c13072e.n8(companion.a(contextS7, number, url));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(C13072e c13072e, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(c13072e, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        x xVar = new x();
        xVar.S8(c13072e.new b(bankCreditCard));
        xVar.K8(c13072e.Q7().B0(), null);
        return C19938rB7.a;
    }

    private final void sa(BankCreditCard card) {
        C13069b.INSTANCE.a(0, card).K8(Q7().B0(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(C13072e c13072e, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(c13072e, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        c13072e.wa(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(BankCreditCard card) {
        ia().a1(card);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va(ArrayList list) {
        this.adapter.J().clear();
        this.adapter.J().addAll(list);
        this.adapter.notifyDataSetChanged();
    }

    private final void wa(BankCreditCard newDefault) {
        ia().s1(newDefault);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 xa(C13072e c13072e, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(c13072e, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        c13072e.sa(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(C13072e c13072e, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(c13072e, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        y.Companion companion = y.INSTANCE;
        y yVarA = companion.a(bankCreditCard);
        FragmentManager fragmentManagerB0 = c13072e.Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        companion.b(yVarA, fragmentManagerB0, "EnrollmentCardFragment");
        return C19938rB7.a;
    }

    private final void za() {
        C13069b.Companion.b(C13069b.INSTANCE, 0, null, 2, null).K8(Q7().B0(), null);
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        super.H6(requestCode, resultCode, data);
        try {
            if (requestCode == 2) {
                Context contextS7 = S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                NY nyF = new NY(contextS7).E(4).j(true).k(4).e(true).F(true);
                if (resultCode == -1) {
                    nyF.p(KB5.ic_success_dialog);
                    nyF.h(AbstractC12217eE5.card_saved_in_shaprak_success);
                    nyF.w(AbstractC12217eE5.verify_confirm);
                    nyF.a().z();
                    ia().t1(ia().j1());
                } else if (resultCode == 0) {
                    nyF.t(AbstractC12217eE5.negative_remove_custom_tag);
                    nyF.h(AbstractC12217eE5.card_saved_in_shaprak_unsuccess);
                    nyF.w(AbstractC12217eE5.send_gift_packet_retry);
                    nyF.p(KB5.ic_alert_dialog);
                    nyF.F(true);
                    nyF.v(new View.OnClickListener() { // from class: ir.nasim.XG0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C13072e.pa(this.a, view);
                        }
                    });
                    nyF.a().z();
                }
            } else {
                if (requestCode != 3) {
                    return;
                }
                if (resultCode == -1) {
                    C10333bU0 c10333bU0 = this.loadingInitData;
                    FragmentManager fragmentManagerB0 = Q7().B0();
                    AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
                    AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
                } else {
                    AbstractC16494lN1.a(this.loadingInitData);
                }
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C4152Dx2.c(inflater).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ma();
        ja();
    }
}
