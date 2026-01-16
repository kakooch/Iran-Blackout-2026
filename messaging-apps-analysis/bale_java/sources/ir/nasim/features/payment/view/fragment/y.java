package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SapOuterClass$ResponseEnrollNewCard;
import android.app.Dialog;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC19902r80;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC24223yF4;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C11512d8;
import ir.nasim.C12650ey2;
import ir.nasim.C14819iX7;
import ir.nasim.C17468n10;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20481s50;
import ir.nasim.C3641Bs4;
import ir.nasim.C5167Ie3;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.ED1;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC4196Ec1;
import ir.nasim.GY6;
import ir.nasim.InterfaceC12746f8;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KV0;
import ir.nasim.SA2;
import ir.nasim.XY6;
import ir.nasim.ZY6;
import ir.nasim.features.bank.mybank.webview.shaparak.ShaparakWebViewActivity;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001<B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010\nR\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006="}, d2 = {"Lir/nasim/features/payment/view/fragment/y;", "Landroidx/fragment/app/l;", "<init>", "()V", "Lir/nasim/rB7;", "e9", "X8", "Lir/nasim/features/payment/data/model/BankCreditCard;", "creditCard", "Y8", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "j7", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/ey2;", "r1", "Lir/nasim/ey2;", "_binding", "Lir/nasim/f8;", "s1", "Lir/nasim/f8;", "viewModel", "Lir/nasim/Bs4;", "t1", "Lir/nasim/Yu3;", "c9", "()Lir/nasim/Bs4;", "cardsViewModel", "", "u1", "Z", "getDisableCopy", "()Z", "disableCopy", "v1", "Lir/nasim/features/payment/data/model/BankCreditCard;", "d9", "()Lir/nasim/features/payment/data/model/BankCreditCard;", "i9", "Lir/nasim/n10;", "w1", "Lir/nasim/n10;", "snackBar", "b9", "()Lir/nasim/ey2;", "binding", "x1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class y extends z {

    /* renamed from: x1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int y1 = 8;

    /* renamed from: r1, reason: from kotlin metadata */
    private C12650ey2 _binding;

    /* renamed from: s1, reason: from kotlin metadata */
    private InterfaceC12746f8 viewModel;

    /* renamed from: t1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 cardsViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3641Bs4.class), new c(this), new d(null, this), new e(this));

    /* renamed from: u1, reason: from kotlin metadata */
    private final boolean disableCopy = AbstractC5969Lp4.e().S().B5(EnumC4196Ec1.D);

    /* renamed from: v1, reason: from kotlin metadata */
    public BankCreditCard creditCard;

    /* renamed from: w1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: ir.nasim.features.payment.view.fragment.y$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final y a(BankCreditCard bankCreditCard) {
            AbstractC13042fc3.i(bankCreditCard, "creditCard");
            y yVar = new y();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_credit_card", bankCreditCard);
            yVar.a8(bundle);
            return yVar;
        }

        public final void b(androidx.fragment.app.l lVar, FragmentManager fragmentManager, String str) {
            AbstractC13042fc3.i(lVar, "<this>");
            AbstractC13042fc3.i(fragmentManager, "fragmentManager");
            fragmentManager.s().e(lVar, str).i();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return y.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objX0;
            y yVar;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                y yVar2 = y.this;
                C3641Bs4 c3641Bs4C9 = yVar2.c9();
                BankCreditCard bankCreditCard = new BankCreditCard(null, ZY6.a(XY6.h(y.this.d9().getNumber())), null, null, null, null, false, BankCreditCard.c.a, false, false, false, 1917, null);
                this.b = yVar2;
                this.c = 1;
                objX0 = c3641Bs4C9.X0(bankCreditCard, this);
                if (objX0 == objE) {
                    return objE;
                }
                yVar = yVar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                yVar = (y) this.b;
                AbstractC10685c16.b(obj);
                objX0 = obj;
            }
            yVar.i9((BankCreditCard) objX0);
            y yVar3 = y.this;
            yVar3.Y8(yVar3.d9());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
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
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

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

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
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

    private final void X8() {
        boolean z = false;
        for (BankCreditCard bankCreditCard : c9().k1()) {
            if (AbstractC13042fc3.d(XY6.h(bankCreditCard.getNumber()), XY6.h(d9().getNumber()))) {
                i9(bankCreditCard);
                z = true;
            }
        }
        if (z) {
            Y8(d9());
        } else {
            AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y8(final BankCreditCard creditCard) {
        try {
            C5167Ie3 c5167Ie3 = new C5167Ie3();
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            boolean zA = c5167Ie3.a(contextS7);
            InterfaceC12746f8 interfaceC12746f8 = null;
            C17468n10 c17468n10 = null;
            if (zA) {
                C17468n10 c17468n102 = this.snackBar;
                if (c17468n102 == null) {
                    AbstractC13042fc3.y("snackBar");
                } else {
                    c17468n10 = c17468n102;
                }
                String strH6 = h6(AbstractC12217eE5.turn_of_vpn);
                AbstractC13042fc3.h(strH6, "getString(...)");
                c17468n10.o(strH6);
                return;
            }
            b9().g.setVisibility(8);
            b9().i.getRoot().setVisibility(0);
            InterfaceC12746f8 interfaceC12746f82 = this.viewModel;
            if (interfaceC12746f82 == null) {
                AbstractC13042fc3.y("viewModel");
            } else {
                interfaceC12746f8 = interfaceC12746f82;
            }
            interfaceC12746f8.z0(creditCard).m0(new InterfaceC24449ye1() { // from class: ir.nasim.k92
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.payment.view.fragment.y.Z8(this.a, creditCard, (SapOuterClass$ResponseEnrollNewCard) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.l92
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.payment.view.fragment.y.a9(this.a, (Exception) obj);
                }
            });
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z8(y yVar, BankCreditCard bankCreditCard, SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard) {
        AbstractC13042fc3.i(yVar, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$creditCard");
        yVar.b9().g.setVisibility(0);
        yVar.b9().i.getRoot().setVisibility(8);
        C7183Qq.q(EnumC18608ow5.g).g("last_request_is_reactivate", false);
        ShaparakWebViewActivity.Companion companion = ShaparakWebViewActivity.INSTANCE;
        Context contextS7 = yVar.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        String number = bankCreditCard.getNumber();
        String url = sapOuterClass$ResponseEnrollNewCard.getUrl();
        AbstractC13042fc3.h(url, "getUrl(...)");
        yVar.n8(companion.a(contextS7, number, url));
        AbstractC16494lN1.a(yVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a9(y yVar, Exception exc) {
        AbstractC13042fc3.i(yVar, "this$0");
        yVar.b9().g.setVisibility(0);
        yVar.b9().i.getRoot().setVisibility(8);
    }

    private final C12650ey2 b9() {
        C12650ey2 c12650ey2 = this._binding;
        AbstractC13042fc3.f(c12650ey2);
        return c12650ey2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3641Bs4 c9() {
        return (C3641Bs4) this.cardsViewModel.getValue();
    }

    private final void e9() {
        ConstraintLayout constraintLayoutB = b9().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(constraintLayoutB, null, 0, 6, null);
        this.snackBar = c17468n10;
        c17468n10.k(b9().l);
        b9().m.setTypeface(C6011Lu2.i());
        b9().f.setTypeface(C6011Lu2.k());
        C20481s50 c20481s50 = C20481s50.a;
        String strSubstring = d9().getNumber().substring(0, 6);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        Bank bankC = c20481s50.c(strSubstring);
        String strA = AbstractC24223yF4.a(bankC != null ? bankC.getMaximumAmount() / 10000000 : 1L, true);
        if (AbstractC19902r80.a().booleanValue() || !d9().isEnrolled()) {
            b9().f.setText(i6(this.disableCopy ? AbstractC12217eE5.card_payment_enrollment_dialog_description_without_copy_description : AbstractC12217eE5.card_payment_enrollment_dialog_description, bankC != null ? bankC.getName() : null, strA));
        } else {
            b9().f.setText(h6(AbstractC12217eE5.card_payment_enrollment_dialog_description_reactivate));
        }
        b9().d.setTypeface(C6011Lu2.k());
        b9().c.setTypeface(C6011Lu2.k());
        b9().b.setTypeface(C6011Lu2.i());
        b9().g.setTypeface(C6011Lu2.i());
        b9().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.h92
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.y.f9(this.a, view);
            }
        });
        b9().g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.i92
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.y.g9(this.a, view);
            }
        });
        if (!this.disableCopy) {
            b9().e.setVisibility(0);
            b9().d.setText(GY6.a(d9().getNumber()));
            b9().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.j92
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ir.nasim.features.payment.view.fragment.y.h9(this.a, view);
                }
            });
            return;
        }
        b9().e.setVisibility(8);
        String strA2 = GY6.a(d9().getNumber());
        TextView textView = b9().d;
        String strSubstring2 = strA2.substring(0, 4);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        String strSubstring3 = strA2.substring(4, 8);
        AbstractC13042fc3.h(strSubstring3, "substring(...)");
        String strSubstring4 = strA2.substring(8, 12);
        AbstractC13042fc3.h(strSubstring4, "substring(...)");
        String strSubstring5 = strA2.substring(12, 16);
        AbstractC13042fc3.h(strSubstring5, "substring(...)");
        textView.setText(strSubstring2 + Separators.SP + strSubstring3 + Separators.SP + strSubstring4 + Separators.SP + strSubstring5);
        b9().j.setElevation(0.0f);
        b9().j.setCardElevation(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f9(y yVar, View view) {
        AbstractC13042fc3.i(yVar, "this$0");
        AbstractC16494lN1.a(yVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g9(y yVar, View view) {
        AbstractC13042fc3.i(yVar, "this$0");
        yVar.X8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h9(y yVar, View view) {
        AbstractC13042fc3.i(yVar, "this$0");
        Context contextS7 = yVar.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        KV0.a(contextS7, XY6.h(yVar.d9().getNumber()));
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            BankCreditCard bankCreditCard = (BankCreditCard) bundleE5.getParcelable("arg_credit_card");
            if (bankCreditCard == null) {
                bankCreditCard = new BankCreditCard(null, "", null, null, null, null, false, BankCreditCard.c.a, false, false, false, 1917, null);
            }
            i9(bankCreditCard);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C12650ey2.c(inflater, container, false);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        this.viewModel = (InterfaceC12746f8) new androidx.lifecycle.G(fragmentActivityQ7).b(C11512d8.class);
        ConstraintLayout constraintLayoutB = b9().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        return constraintLayoutB;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    public final BankCreditCard d9() {
        BankCreditCard bankCreditCard = this.creditCard;
        if (bankCreditCard != null) {
            return bankCreditCard;
        }
        AbstractC13042fc3.y("creditCard");
        return null;
    }

    public final void i9(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "<set-?>");
        this.creditCard = bankCreditCard;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void j7() {
        Window window;
        Window window2;
        super.j7();
        if (y8() != null) {
            Dialog dialogY8 = y8();
            if (dialogY8 != null && (window2 = dialogY8.getWindow()) != null) {
                window2.setLayout(-1, -1);
            }
            Dialog dialogY82 = y8();
            if (dialogY82 == null || (window = dialogY82.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        e9();
    }
}
