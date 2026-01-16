package ir.nasim.features.payment.view.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15251jG3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC18623oy2;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.BC5;
import ir.nasim.C13886gz2;
import ir.nasim.C14819iX7;
import ir.nasim.C17468n10;
import ir.nasim.C19938rB7;
import ir.nasim.C21937uO3;
import ir.nasim.C25226zw5;
import ir.nasim.C3641Bs4;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.FX2;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC8327Vm4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.O40;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.WB5;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.view.fragment.C13069b;
import ir.nasim.features.payment.view.fragment.x;
import ir.nasim.features.payment.view.fragment.y;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001GB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\"\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0004068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0004068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0017\u0010A\u001a\u00020<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lir/nasim/features/payment/view/fragment/J;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Lir/nasim/rB7;", "l9", "", "mTitle", "mDescription", "j9", "(Ljava/lang/String;Ljava/lang/String;)V", "i9", "h9", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lir/nasim/features/payment/data/model/BankCreditCard;", "bankCreditCard", "p9", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "Lir/nasim/gz2;", "s1", "Lir/nasim/bW7;", "e9", "()Lir/nasim/gz2;", "binding", "Lir/nasim/Bs4;", "t1", "Lir/nasim/Yu3;", "g9", "()Lir/nasim/Bs4;", "viewModel", "", "u1", "Ljava/lang/Integer;", "type", "Lir/nasim/n10;", "v1", "Lir/nasim/n10;", "snackBar", "Lkotlin/Function1;", "w1", "Lir/nasim/UA2;", "onDeleteClickListener", "x1", "shaparakAuthentication", "Lir/nasim/O40;", "y1", "Lir/nasim/O40;", "f9", "()Lir/nasim/O40;", "savedAdapter", "Lcom/google/android/material/button/MaterialButton;", "z1", "Lcom/google/android/material/button/MaterialButton;", "addButton", "A1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class J extends FX2 {

    /* renamed from: u1, reason: from kotlin metadata */
    private Integer type;

    /* renamed from: v1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: x1, reason: from kotlin metadata */
    private UA2 shaparakAuthentication;

    /* renamed from: y1, reason: from kotlin metadata */
    private final O40 savedAdapter;

    /* renamed from: z1, reason: from kotlin metadata */
    private MaterialButton addButton;
    static final /* synthetic */ InterfaceC5239Im3[] B1 = {AbstractC10882cM5.i(new C25226zw5(J.class, "binding", "getBinding()Lir/nasim/databinding/FragmentSavedCardListBinding;", 0))};

    /* renamed from: A1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int C1 = 8;

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new h(), AbstractC20046rN7.c());

    /* renamed from: t1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3641Bs4.class), new e(this), new f(null, this), new g(this));

    /* renamed from: w1, reason: from kotlin metadata */
    private UA2 onDeleteClickListener = new UA2() { // from class: ir.nasim.mb6
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.J.q9(this.a, (BankCreditCard) obj);
        }
    };

    /* renamed from: ir.nasim.features.payment.view.fragment.J$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final J a(int i) {
            J j = new J();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            j.a8(bundle);
            return j;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ J c;

            /* renamed from: ir.nasim.features.payment.view.fragment.J$b$a$a, reason: collision with other inner class name */
            static final class C1188a implements InterfaceC4806Gq2 {
                final /* synthetic */ J a;

                C1188a(J j) {
                    this.a = j;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(AbstractC15251jG3 abstractC15251jG3, InterfaceC20295rm1 interfaceC20295rm1) {
                    if (abstractC15251jG3 instanceof AbstractC15251jG3.b) {
                        AbstractC15251jG3.b bVar = (AbstractC15251jG3.b) abstractC15251jG3;
                        if (bVar.a() instanceof ArrayList) {
                            Object objA = bVar.a();
                            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.features.payment.data.model.BankCreditCard>");
                            this.a.getSavedAdapter().M(new ArrayList((ArrayList) objA));
                            this.a.getSavedAdapter().notifyDataSetChanged();
                        }
                    } else if (abstractC15251jG3 instanceof AbstractC15251jG3.a) {
                        C17468n10 c17468n10 = this.a.snackBar;
                        if (c17468n10 == null) {
                            AbstractC13042fc3.y("snackBar");
                            c17468n10 = null;
                        }
                        String strH6 = this.a.h6(AbstractC12217eE5.error_when_get_dst_cards);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        c17468n10.o(strH6);
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(J j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC8327Vm4 interfaceC8327Vm4I1 = this.c.g9().i1();
                    C1188a c1188a = new C1188a(this.c);
                    this.b = 1;
                    if (interfaceC8327Vm4I1.b(c1188a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return J.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                J j = J.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(j, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(j, bVar, aVar, this) == objE) {
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

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ J c;

            /* renamed from: ir.nasim.features.payment.view.fragment.J$c$a$a, reason: collision with other inner class name */
            static final class C1189a implements InterfaceC4806Gq2 {
                final /* synthetic */ J a;

                C1189a(J j) {
                    this.a = j;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(AbstractC15251jG3 abstractC15251jG3, InterfaceC20295rm1 interfaceC20295rm1) {
                    if (abstractC15251jG3 instanceof AbstractC15251jG3.b) {
                        AbstractC15251jG3.b bVar = (AbstractC15251jG3.b) abstractC15251jG3;
                        if (bVar.a() instanceof ArrayList) {
                            Object objA = bVar.a();
                            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.features.payment.data.model.BankCreditCard>");
                            this.a.getSavedAdapter().M(new ArrayList((ArrayList) objA));
                            this.a.getSavedAdapter().notifyDataSetChanged();
                        }
                    } else if (abstractC15251jG3 instanceof AbstractC15251jG3.a) {
                        C17468n10 c17468n10 = this.a.snackBar;
                        if (c17468n10 == null) {
                            AbstractC13042fc3.y("snackBar");
                            c17468n10 = null;
                        }
                        String strH6 = this.a.h6(AbstractC12217eE5.error_when_get_src_cards);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        c17468n10.o(strH6);
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(J j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC8327Vm4 interfaceC8327Vm4L1 = this.c.g9().l1();
                    C1189a c1189a = new C1189a(this.c);
                    this.b = 1;
                    if (interfaceC8327Vm4L1.b(c1189a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return J.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                J j = J.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(j, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(j, bVar, aVar, this) == objE) {
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

    public static final class d implements x.a {
        final /* synthetic */ BankCreditCard b;

        d(BankCreditCard bankCreditCard) {
            this.b = bankCreditCard;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            Integer num = J.this.type;
            if (num != null && num.intValue() == 0) {
                J.this.g9().a1(this.b);
            } else if (num != null && num.intValue() == 1) {
                J.this.g9().Z0(this.b);
            }
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
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, Fragment fragment) {
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

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
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

    public static final class h extends AbstractC8614Ws3 implements UA2 {
        public h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C13886gz2.a(fragment.V7());
        }
    }

    public J() {
        UA2 ua2 = new UA2() { // from class: ir.nasim.nb6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.payment.view.fragment.J.s9(this.a, (BankCreditCard) obj);
            }
        };
        this.shaparakAuthentication = ua2;
        this.savedAdapter = new O40(O40.a.a, ua2, new UA2() { // from class: ir.nasim.ob6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.payment.view.fragment.J.r9(this.a, (BankCreditCard) obj);
            }
        }, this.onDeleteClickListener, null, null, 48, null);
    }

    private final C13886gz2 e9() {
        return (C13886gz2) this.binding.a(this, B1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3641Bs4 g9() {
        return (C3641Bs4) this.viewModel.getValue();
    }

    private final void h9() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(null), 3, null);
    }

    private final void i9() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new c(null), 3, null);
    }

    private final void j9(String mTitle, String mDescription) {
        e9().e.setText(mTitle);
        e9().c.setText(mDescription);
        e9().e.setTypeface(C6011Lu2.i());
        e9().c.setTypeface(C6011Lu2.k());
        e9().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qb6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.J.k9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k9(J j, View view) {
        AbstractC13042fc3.i(j, "this$0");
        AbstractC16494lN1.a(j);
    }

    private final void l9() {
        Integer num = this.type;
        if (num != null && num.intValue() == 0) {
            String strH6 = h6(AbstractC12217eE5.card_payment_select_source_card);
            AbstractC13042fc3.h(strH6, "getString(...)");
            String strH62 = h6(AbstractC12217eE5.card_payment_select_source_card_description);
            AbstractC13042fc3.h(strH62, "getString(...)");
            j9(strH6, strH62);
        } else if (num != null && num.intValue() == 1) {
            String strH63 = h6(AbstractC12217eE5.card_payment_select_destination_card);
            AbstractC13042fc3.h(strH63, "getString(...)");
            String strH64 = h6(AbstractC12217eE5.card_payment_select_destination_card_description);
            AbstractC13042fc3.h(strH64, "getString(...)");
            j9(strH63, strH64);
        }
        e9().d.setAdapter(this.savedAdapter);
        e9().d.addItemDecoration(new C21937uO3(14, 14, 8, 14, 30));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m9(com.google.android.material.bottomsheet.a aVar, final J j, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(aVar, "$bottomSheetDialog");
        AbstractC13042fc3.i(j, "this$0");
        AbstractC13042fc3.g(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar2 = (com.google.android.material.bottomsheet.a) dialogInterface;
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) aVar2.findViewById(WB5.coordinator);
        final FrameLayout frameLayout = (FrameLayout) aVar2.findViewById(WB5.container);
        MaterialButton materialButton = null;
        final View viewInflate = aVar.getLayoutInflater().inflate(AbstractC12208eD5.fragment_saved_cards_footer, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        viewInflate.setLayoutParams(layoutParams);
        AbstractC13042fc3.f(frameLayout);
        frameLayout.addView(viewInflate);
        viewInflate.post(new Runnable() { // from class: ir.nasim.rb6
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.payment.view.fragment.J.n9(coordinatorLayout, viewInflate, frameLayout);
            }
        });
        viewInflate.setBackgroundColor(C5495Jo7.a.q());
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(BC5.add);
        j.addButton = materialButton2;
        if (materialButton2 == null) {
            AbstractC13042fc3.y("addButton");
            materialButton2 = null;
        }
        materialButton2.setTypeface(C6011Lu2.i());
        MaterialButton materialButton3 = j.addButton;
        if (materialButton3 == null) {
            AbstractC13042fc3.y("addButton");
            materialButton3 = null;
        }
        materialButton3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sb6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.J.o9(this.a, view);
            }
        });
        Integer num = j.type;
        if (num != null && num.intValue() == 1) {
            MaterialButton materialButton4 = j.addButton;
            if (materialButton4 == null) {
                AbstractC13042fc3.y("addButton");
            } else {
                materialButton = materialButton4;
            }
            materialButton.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n9(CoordinatorLayout coordinatorLayout, View view, FrameLayout frameLayout) {
        AbstractC13042fc3.f(coordinatorLayout);
        ViewGroup.LayoutParams layoutParams = coordinatorLayout.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = view.getMeasuredHeight();
        frameLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o9(J j, View view) {
        AbstractC13042fc3.i(j, "this$0");
        AbstractC16494lN1.a(j);
        C13069b.Companion companion = C13069b.INSTANCE;
        Integer num = j.type;
        AbstractC13042fc3.f(num);
        C13069b.Companion.b(companion, num.intValue(), null, 2, null).K8(j.Q7().B0(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q9(J j, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(j, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        x xVar = new x();
        xVar.S8(j.new d(bankCreditCard));
        xVar.K8(j.Q7().B0(), null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r9(J j, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(j, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "it");
        j.p9(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s9(J j, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(j, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        y.Companion companion = y.INSTANCE;
        y yVarA = companion.a(bankCreditCard);
        FragmentManager fragmentManagerB0 = j.Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        companion.b(yVarA, fragmentManagerB0, "EnrollmentCardFragment");
        return C19938rB7.a;
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        Dialog dialogB8 = super.B8(savedInstanceState);
        AbstractC13042fc3.g(dialogB8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogB8;
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.pb6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ir.nasim.features.payment.view.fragment.J.m9(aVar, this, dialogInterface);
            }
        });
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.type = Integer.valueOf(bundleE5.getInt("type"));
        }
        I8(0, AbstractC23035wE5.CardPaymentBottomSheetTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C13886gz2.c(inflater).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    /* renamed from: f9, reason: from getter */
    public final O40 getSavedAdapter() {
        return this.savedAdapter;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        l9();
        Integer num = this.type;
        if (num != null && num.intValue() == 0) {
            i9();
        } else if (num != null && num.intValue() == 1) {
            h9();
        }
        ConstraintLayout root = e9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        this.snackBar = new C17468n10(root, null, 0, 6, null);
    }

    public final void p9(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "bankCreditCard");
        Integer num = this.type;
        if (num != null && num.intValue() == 0) {
            AbstractC18623oy2.c(this, "card_clicked", AbstractC23348wm0.b(AbstractC4616Fw7.a("src_card_clicked", bankCreditCard.getNumber())));
        } else if (num != null && num.intValue() == 1) {
            AbstractC18623oy2.c(this, "card_clicked", AbstractC23348wm0.b(AbstractC4616Fw7.a("dst_card_clicked", bankCreditCard.getNumber())));
        }
        AbstractC16494lN1.a(this);
    }
}
