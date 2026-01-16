package ir.nasim.features.bank;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import ir.nasim.A14;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20471s40;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14;
import ir.nasim.C14486i0;
import ir.nasim.C23381wp3;
import ir.nasim.C23498x14;
import ir.nasim.C4100Dr4;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC12737f70;
import ir.nasim.InterfaceC13373g70;
import ir.nasim.InterfaceC24088y14;
import ir.nasim.TA5;
import ir.nasim.V50;
import ir.nasim.XY6;
import ir.nasim.Y50;
import ir.nasim.core.modules.banking.l;
import ir.nasim.core.modules.banking.m;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.designsystem.button.a;
import ir.nasim.features.bank.MelliLoanBottomSheetContentView;
import ir.nasim.features.conversation.view.TitledBankCardView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0010J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010\u0010J\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\u0010J\u0017\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\rH\u0016¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010'\u001a\u00020\rH\u0016¢\u0006\u0004\b'\u0010\u0010R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b/\u0010\u000fR\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lir/nasim/features/bank/MelliLoanBottomSheetContentView;", "Lir/nasim/features/bank/BankContentView;", "Lir/nasim/y14;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "D", "J", "()V", "", TokenNames.I, "()Z", TokenNames.M, "", "refundNumber", TokenNames.R, "(J)Lir/nasim/features/bank/MelliLoanBottomSheetContentView;", "refundAmount", "Q", "(Ljava/lang/Long;)Lir/nasim/features/bank/MelliLoanBottomSheetContentView;", "Lir/nasim/A14;", "responseEntity", "e5", "(Lir/nasim/A14;)V", "p5", "G1", "", "error", "x3", "(Ljava/lang/String;)V", "X4", "x0", "k", "Z", "isCardValid", "Lir/nasim/f70;", "l", "Lir/nasim/f70;", "bankingDialog", "m", "SEND_REQUEST_DELAY", "Lir/nasim/C14;", "n", "Lir/nasim/C14;", "getBinding", "()Lir/nasim/C14;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class MelliLoanBottomSheetContentView extends BankContentView implements InterfaceC24088y14 {

    /* renamed from: k, reason: from kotlin metadata */
    private boolean isCardValid;

    /* renamed from: l, reason: from kotlin metadata */
    private InterfaceC12737f70 bankingDialog;

    /* renamed from: m, reason: from kotlin metadata */
    private final long SEND_REQUEST_DELAY;

    /* renamed from: n, reason: from kotlin metadata */
    private final C14 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelliLoanBottomSheetContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.SEND_REQUEST_DELAY = 200L;
        C14 c14C = C14.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c14C, "inflate(...)");
        this.binding = c14C;
        D(context);
    }

    private final void D(final Context context) {
        setBackgroundColor(C5495Jo7.a.j0());
        this.binding.e.setTypeface(C6011Lu2.k());
        setPresenter(new C23498x14(this));
        setShadow(this.binding.j);
        setProgressBar(this.binding.B.getRoot());
        BaleButton baleButton = this.binding.A;
        baleButton.setTypeface(C6011Lu2.i());
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.l14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MelliLoanBottomSheetContentView.E(context, this, view);
            }
        });
        setOkButton(baleButton);
        TitledBankCardView titledBankCardView = this.binding.L;
        V50 presenter = getPresenter();
        AbstractC13042fc3.g(presenter, "null cannot be cast to non-null type ir.nasim.features.bank.mybank.MelliLoanBottomSheetMVPPresenter");
        setSourceCardView(titledBankCardView.Z0(((C23498x14) presenter).z()).d1(context.getResources().getString(AbstractC12217eE5.source_card_title)).V0(true).Y0(context.getResources().getString(AbstractC12217eE5.bank_card_number)));
        this.binding.v.setTypeface(C6011Lu2.i());
        this.binding.o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.m14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MelliLoanBottomSheetContentView.G(this.a, view);
            }
        });
        TextView textView = this.binding.E;
        textView.setTypeface(C6011Lu2.i());
        textView.setTextColor(textView.getResources().getColor(TA5.c10));
        getSourceCardView().setBankNameChangeListener(new TitledBankCardView.f() { // from class: ir.nasim.n14
            @Override // ir.nasim.features.conversation.view.TitledBankCardView.f
            public final void a(Y50 y50) {
                MelliLoanBottomSheetContentView.H(this.a, y50);
            }
        });
        this.bankingDialog = InterfaceC13373g70.a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Context context, MelliLoanBottomSheetContentView melliLoanBottomSheetContentView, View view) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(melliLoanBottomSheetContentView, "this$0");
        if (!C4100Dr4.a(context)) {
            Toast.makeText(context, AbstractC12217eE5.bank_second_toast_for_check_network_description, 0).show();
        } else if (melliLoanBottomSheetContentView.I()) {
            melliLoanBottomSheetContentView.getSourceCardView().l0();
        } else {
            melliLoanBottomSheetContentView.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MelliLoanBottomSheetContentView melliLoanBottomSheetContentView, View view) {
        AbstractC13042fc3.i(melliLoanBottomSheetContentView, "this$0");
        melliLoanBottomSheetContentView.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(MelliLoanBottomSheetContentView melliLoanBottomSheetContentView, Y50 y50) {
        AbstractC13042fc3.i(melliLoanBottomSheetContentView, "this$0");
        V50 presenter = melliLoanBottomSheetContentView.getPresenter();
        AbstractC13042fc3.g(presenter, "null cannot be cast to non-null type ir.nasim.features.bank.mybank.MelliLoanBottomSheetMVPPresenter");
        AbstractC13042fc3.f(y50);
        boolean zB = ((C23498x14) presenter).B(y50);
        melliLoanBottomSheetContentView.isCardValid = zB;
        if (zB) {
            melliLoanBottomSheetContentView.binding.e.setTextColor(C5495Jo7.a.e2());
        } else if (y50 == Y50.d) {
            melliLoanBottomSheetContentView.binding.e.setTextColor(C5495Jo7.a.n0());
        } else {
            melliLoanBottomSheetContentView.binding.e.setTextColor(C5495Jo7.a.B0());
        }
    }

    private final boolean I() {
        return (getSourceCardView().o0() && getSourceCardView().s0() && getSourceCardView().t0() && getSourceCardView().v0() && this.isCardValid) ? false : true;
    }

    private final void J() {
        V50 presenter = getPresenter();
        AbstractC13042fc3.g(presenter, "null cannot be cast to non-null type ir.nasim.features.bank.mybank.MelliLoanBottomSheetMVPPresenter");
        ((C23498x14) presenter).I(Long.valueOf(Long.parseLong(this.binding.w.getAmount())));
        C23381wp3.f(getSourceCardView());
        new Handler().postDelayed(new Runnable() { // from class: ir.nasim.o14
            @Override // java.lang.Runnable
            public final void run() {
                MelliLoanBottomSheetContentView.K(this.a);
            }
        }, this.SEND_REQUEST_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(final MelliLoanBottomSheetContentView melliLoanBottomSheetContentView) {
        AbstractC13042fc3.i(melliLoanBottomSheetContentView, "this$0");
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.p14
            @Override // java.lang.Runnable
            public final void run() {
                MelliLoanBottomSheetContentView.L(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(MelliLoanBottomSheetContentView melliLoanBottomSheetContentView) {
        AbstractC13042fc3.i(melliLoanBottomSheetContentView, "this$0");
        V50 presenter = melliLoanBottomSheetContentView.getPresenter();
        AbstractC20471s40 bankCard = melliLoanBottomSheetContentView.getSourceCardView().getBankCard();
        AbstractC13042fc3.g(bankCard, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        m mVarK = m.k((l) bankCard, melliLoanBottomSheetContentView.getSourceCardView().getCvv2(), melliLoanBottomSheetContentView.getSourceCardView().getExpireYear(), melliLoanBottomSheetContentView.getSourceCardView().getExpireMonth());
        AbstractC13042fc3.f(mVarK);
        String pin2 = melliLoanBottomSheetContentView.getSourceCardView().getPin2();
        AbstractC13042fc3.h(pin2, "getPin2(...)");
        presenter.q(mVarK, pin2, "");
    }

    private final void M() {
        this.binding.l.setVisibility(0);
        this.binding.K.setVisibility(8);
        BaleButton okButton = getOkButton();
        okButton.setButtonType(a.m);
        okButton.setText(getContext().getString(AbstractC12217eE5.bank_agree_and_continue));
        TextView textView = this.binding.o;
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.q14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MelliLoanBottomSheetContentView.N(this.a, view);
            }
        });
        textView.setText(getContext().getString(AbstractC12217eE5.persian_close));
        V50 presenter = getPresenter();
        AbstractC13042fc3.g(presenter, "null cannot be cast to non-null type ir.nasim.features.bank.mybank.MelliLoanBottomSheetMVPPresenter");
        ((C23498x14) presenter).H(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(MelliLoanBottomSheetContentView melliLoanBottomSheetContentView, View view) {
        AbstractC13042fc3.i(melliLoanBottomSheetContentView, "this$0");
        melliLoanBottomSheetContentView.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(MelliLoanBottomSheetContentView melliLoanBottomSheetContentView, View view) {
        AbstractC13042fc3.i(melliLoanBottomSheetContentView, "this$0");
        melliLoanBottomSheetContentView.M();
    }

    @Override // ir.nasim.InterfaceC24088y14
    public void G1() {
        InterfaceC12737f70 interfaceC12737f70 = this.bankingDialog;
        if (interfaceC12737f70 == null) {
            AbstractC13042fc3.y("bankingDialog");
            interfaceC12737f70 = null;
        }
        InterfaceC12737f70.k(interfaceC12737f70, AbstractC12217eE5.bank_operation_success_description, AbstractC12217eE5.bank_loan_has_been_paid, null, 4, null);
        C14486i0 bottomSheet = getBottomSheet();
        if (bottomSheet != null) {
            bottomSheet.g();
        }
    }

    public final MelliLoanBottomSheetContentView Q(Long refundAmount) {
        if (refundAmount != null) {
            this.binding.w.setVariableAmount(XY6.e(String.valueOf(refundAmount.longValue())));
        }
        return this;
    }

    public final MelliLoanBottomSheetContentView R(long refundNumber) {
        V50 presenter = getPresenter();
        AbstractC13042fc3.g(presenter, "null cannot be cast to non-null type ir.nasim.features.bank.mybank.MelliLoanBottomSheetMVPPresenter");
        ((C23498x14) presenter).J(Long.valueOf(refundNumber));
        this.binding.E.setText(XY6.e(String.valueOf(refundNumber)));
        return this;
    }

    @Override // ir.nasim.InterfaceC24088y14
    public void X4() throws Resources.NotFoundException {
        String string = getContext().getResources().getString(AbstractC12217eE5.abol_error_timeout);
        AbstractC13042fc3.h(string, "getString(...)");
        x3(string);
    }

    @Override // ir.nasim.InterfaceC24088y14
    public void e5(A14 responseEntity) {
        AbstractC13042fc3.i(responseEntity, "responseEntity");
        this.binding.l.setVisibility(8);
        this.binding.K.setVisibility(0);
        BaleButton okButton = getOkButton();
        okButton.setButtonType(a.n);
        okButton.setText(getContext().getString(AbstractC12217eE5.purchase_button));
        TextView textView = this.binding.o;
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.r14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MelliLoanBottomSheetContentView.O(this.a, view);
            }
        });
        textView.setText(getContext().getString(AbstractC12217eE5.bank_return));
        TextView textView2 = this.binding.d;
        textView2.setTypeface(C6011Lu2.i());
        textView2.setText(XY6.e(XY6.c(String.valueOf(responseEntity.a()), (char) 0, 2, null)) + " ریال");
        TextView textView3 = this.binding.P;
        textView3.setTypeface(C6011Lu2.i());
        textView3.setText(responseEntity.e());
        TextView textView4 = this.binding.z;
        textView4.setTypeface(C6011Lu2.i());
        textView4.setText(responseEntity.c());
        TextView textView5 = this.binding.I;
        textView5.setTypeface(C6011Lu2.i());
        textView5.setText(XY6.e(responseEntity.d().toString()));
        TextView textView6 = this.binding.g;
        textView6.setTypeface(C6011Lu2.i());
        textView6.setText("XXXX XXXX XXXX " + XY6.e(responseEntity.b().h()));
    }

    public final C14 getBinding() {
        return this.binding;
    }

    @Override // ir.nasim.InterfaceC24088y14
    public void p5() {
        this.binding.e.setVisibility(8);
    }

    @Override // ir.nasim.InterfaceC24088y14
    public void x0() throws Resources.NotFoundException {
        String string = getContext().getResources().getString(AbstractC12217eE5.error_unknown);
        AbstractC13042fc3.h(string, "getString(...)");
        x3(string);
    }

    @Override // ir.nasim.InterfaceC24088y14
    public void x3(String error) {
        AbstractC13042fc3.i(error, "error");
        InterfaceC12737f70 interfaceC12737f70 = this.bankingDialog;
        if (interfaceC12737f70 == null) {
            AbstractC13042fc3.y("bankingDialog");
            interfaceC12737f70 = null;
        }
        String string = getContext().getString(AbstractC12217eE5.bank_loan_has_not_been_paid);
        AbstractC13042fc3.h(string, "getString(...)");
        InterfaceC12737f70.l(interfaceC12737f70, error, string, null, 4, null);
        M();
        R4();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelliLoanBottomSheetContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.SEND_REQUEST_DELAY = 200L;
        C14 c14C = C14.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c14C, "inflate(...)");
        this.binding = c14C;
        D(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelliLoanBottomSheetContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.SEND_REQUEST_DELAY = 200L;
        C14 c14C = C14.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c14C, "inflate(...)");
        this.binding = c14C;
        D(context);
    }
}
