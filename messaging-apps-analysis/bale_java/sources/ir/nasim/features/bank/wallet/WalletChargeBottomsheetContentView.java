package ir.nasim.features.bank.wallet;

import ai.bale.proto.WalletOuterClass$ResponseGetWalletChargeToken;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13554gQ7;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC24223yF4;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.BC5;
import ir.nasim.C14486i0;
import ir.nasim.C19406qI3;
import ir.nasim.C20012rK0;
import ir.nasim.C21231tK7;
import ir.nasim.C22055ub3;
import ir.nasim.C4100Dr4;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC12737f70;
import ir.nasim.InterfaceC13373g70;
import ir.nasim.InterfaceC14756iQ7;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.M18;
import ir.nasim.NI7;
import ir.nasim.XV4;
import ir.nasim.XY6;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.bank.BankiMoneyAmountView;
import ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity;
import ir.nasim.features.bank.wallet.WalletChargeBottomsheetContentView;
import ir.nasim.features.root.RootActivity;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0010J7\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u0010J\u000f\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010\u0010J\u000f\u0010#\u001a\u00020\rH\u0002¢\u0006\u0004\b#\u0010\u0010J\u0019\u0010&\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'R\u001c\u0010+\u001a\n (*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R$\u0010<\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010*\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010B\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lir/nasim/features/bank/wallet/WalletChargeBottomsheetContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "s", "q", "()V", TokenNames.F, "", "amount", "", "o", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "v", TokenNames.C, "p", "token", "endpoint", "terminalId", "merchantId", "", "u", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "x", TokenNames.E, "r", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "TAG", "b", "Lir/nasim/i0;", "bottomsheet", "Landroid/view/View;", "c", "Landroid/view/View;", "view", "Lir/nasim/rK0;", "d", "Lir/nasim/rK0;", "viewModel", "e", "getDefaultWalletId", "()Ljava/lang/String;", "setDefaultWalletId", "(Ljava/lang/String;)V", "defaultWalletId", "Lir/nasim/M18;", "f", "Lir/nasim/M18;", "getBinding", "()Lir/nasim/M18;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class WalletChargeBottomsheetContentView extends RelativeLayout implements InterfaceC16866m0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private C14486i0 bottomsheet;

    /* renamed from: c, reason: from kotlin metadata */
    private View view;

    /* renamed from: d, reason: from kotlin metadata */
    private final C20012rK0 viewModel;

    /* renamed from: e, reason: from kotlin metadata */
    private String defaultWalletId;

    /* renamed from: f, reason: from kotlin metadata */
    private final M18 binding;

    public static final class a implements InterfaceC15419jZ0 {
        final /* synthetic */ long b;
        final /* synthetic */ InterfaceC12737f70 c;

        a(long j, InterfaceC12737f70 interfaceC12737f70) {
            this.b = j;
            this.c = interfaceC12737f70;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(WalletOuterClass$ResponseGetWalletChargeToken walletOuterClass$ResponseGetWalletChargeToken) {
            WalletChargeBottomsheetContentView.this.r();
            if (walletOuterClass$ResponseGetWalletChargeToken != null) {
                WalletChargeBottomsheetContentView walletChargeBottomsheetContentView = WalletChargeBottomsheetContentView.this;
                String token = walletOuterClass$ResponseGetWalletChargeToken.getToken();
                AbstractC13042fc3.h(token, "getToken(...)");
                String endpoint = walletOuterClass$ResponseGetWalletChargeToken.getEndpoint();
                AbstractC13042fc3.h(endpoint, "getEndpoint(...)");
                String terminalId = walletOuterClass$ResponseGetWalletChargeToken.getTerminalId();
                AbstractC13042fc3.h(terminalId, "getTerminalId(...)");
                String merchantId = walletOuterClass$ResponseGetWalletChargeToken.getMerchantId();
                AbstractC13042fc3.h(merchantId, "getMerchantId(...)");
                walletChargeBottomsheetContentView.u(token, endpoint, terminalId, merchantId, this.b);
                C14486i0 c14486i0 = WalletChargeBottomsheetContentView.this.bottomsheet;
                if (c14486i0 != null) {
                    c14486i0.g();
                }
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            WalletChargeBottomsheetContentView.this.r();
            InterfaceC12737f70 interfaceC12737f70 = this.c;
            int i = AbstractC12217eE5.bank_operation_failed;
            interfaceC12737f70.e(i, i, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletChargeBottomsheetContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.TAG = WalletChargeBottomsheetContentView.class.getName();
        this.viewModel = new C20012rK0(C5735Kp4.w().i().Y());
        M18 m18C = M18.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(m18C, "inflate(...)");
        this.binding = m18C;
        s(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(WalletChargeBottomsheetContentView walletChargeBottomsheetContentView, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(walletChargeBottomsheetContentView, "this$0");
        BankiMoneyAmountView bankiMoneyAmountView = walletChargeBottomsheetContentView.binding.k;
        String string = walletChargeBottomsheetContentView.getContext().getResources().getString(AbstractC12217eE5.wallet_charge_amount_100000);
        AbstractC13042fc3.h(string, "getString(...)");
        bankiMoneyAmountView.setVariableAmount(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(WalletChargeBottomsheetContentView walletChargeBottomsheetContentView, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(walletChargeBottomsheetContentView, "this$0");
        BankiMoneyAmountView bankiMoneyAmountView = walletChargeBottomsheetContentView.binding.k;
        String string = walletChargeBottomsheetContentView.getContext().getResources().getString(AbstractC12217eE5.wallet_charge_amount_200000);
        AbstractC13042fc3.h(string, "getString(...)");
        bankiMoneyAmountView.setVariableAmount(string);
    }

    private final void C() {
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        final InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
        final BaleButton baleButton = this.binding.d;
        baleButton.setTypeface(C6011Lu2.i());
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.G18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletChargeBottomsheetContentView.D(baleButton, this, interfaceC12737f70A, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(BaleButton baleButton, WalletChargeBottomsheetContentView walletChargeBottomsheetContentView, InterfaceC12737f70 interfaceC12737f70, View view) {
        AbstractC13042fc3.i(baleButton, "$this_apply");
        AbstractC13042fc3.i(walletChargeBottomsheetContentView, "this$0");
        AbstractC13042fc3.i(interfaceC12737f70, "$bankingDialog");
        Context context = baleButton.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        if (C4100Dr4.a(context)) {
            walletChargeBottomsheetContentView.p();
        } else {
            interfaceC12737f70.e(AbstractC12217eE5.bank_second_toast_for_check_network_description, AbstractC12217eE5.bank_operation_failed, null);
        }
    }

    private final void E() {
        this.binding.b.setVisibility(0);
        this.binding.e.getRoot().setVisibility(0);
    }

    private final void F() {
        this.viewModel.g().f(new InterfaceC14756iQ7() { // from class: ir.nasim.F18
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                WalletChargeBottomsheetContentView.G(this.a, (Long) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(WalletChargeBottomsheetContentView walletChargeBottomsheetContentView, Long l, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(walletChargeBottomsheetContentView, "this$0");
        String strD = XY6.d(l.toString());
        walletChargeBottomsheetContentView.binding.g.setText(strD);
        walletChargeBottomsheetContentView.binding.h.setText(walletChargeBottomsheetContentView.o(strD));
    }

    private final String o(CharSequence amount) {
        try {
            return Separators.SP + getContext().getString(AbstractC12217eE5.amount_for_wallet, AbstractC24223yF4.a(Long.parseLong(XY6.q(amount.toString())) / 10, true)) + Separators.SP;
        } catch (Exception e) {
            String str = this.TAG;
            AbstractC13042fc3.h(str, "TAG");
            C19406qI3.d(str, e);
            return "";
        }
    }

    private final void p() {
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
        View view = this.view;
        if (view == null) {
            AbstractC13042fc3.y("view");
            view = null;
        }
        long amount = ((BankiMoneyAmountView) view.findViewById(BC5.wallet_charge_amount)).getAmount();
        if (this.binding.k.getAmount() != 0) {
            E();
            this.viewModel.e(this.defaultWalletId, amount).a(new a(amount, interfaceC12737f70A));
        } else {
            Context context2 = getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            aVar.a(context2).i(AbstractC12217eE5.wallet_pay_amount_dialog_is_null, AbstractC12217eE5.bank_operation_failed, null);
            this.binding.k.requestFocus();
        }
    }

    private final void q() {
        this.binding.m.setTypeface(C6011Lu2.i());
        this.binding.l.setTypeface(C6011Lu2.k());
        this.binding.j.setTypeface(C6011Lu2.i());
        this.binding.g.setTypeface(C6011Lu2.i());
        this.binding.i.setTypeface(C6011Lu2.k());
        this.binding.h.setTypeface(C6011Lu2.k());
        this.binding.p.setTypeface(C6011Lu2.i());
        this.binding.r.setTypeface(C6011Lu2.i());
        this.binding.o.setTypeface(C6011Lu2.i());
        this.binding.q.setTypeface(C6011Lu2.i());
        this.binding.t.setTypeface(C6011Lu2.i());
        this.binding.s.setTypeface(C6011Lu2.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        this.binding.b.setVisibility(8);
        this.binding.e.getRoot().setVisibility(8);
    }

    private final void s(Context context) {
        this.view = this.binding.getRoot();
        v();
        x();
        C();
        F();
        q();
        this.viewModel.h().f(new InterfaceC14756iQ7() { // from class: ir.nasim.E18
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                WalletChargeBottomsheetContentView.t(this.a, (String) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(WalletChargeBottomsheetContentView walletChargeBottomsheetContentView, String str, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(walletChargeBottomsheetContentView, "this$0");
        walletChargeBottomsheetContentView.defaultWalletId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String token, String endpoint, String terminalId, String merchantId, long amount) {
        try {
            C21231tK7 c21231tK7C = AbstractC5969Lp4.c();
            AbstractC13042fc3.f(c21231tK7C);
            long jA = ((NI7) ((ArrayList) c21231tK7C.u().b()).get(0)).a();
            StringBuilder sb = new StringBuilder();
            sb.append(jA);
            String string = sb.toString();
            if (AbstractC20153rZ6.S(string, "9811", false, 2, null)) {
                AbstractC13042fc3.h(string.substring(4), "substring(...)");
            } else if (AbstractC20153rZ6.S(string, "98", false, 2, null)) {
                AbstractC13042fc3.h(string.substring(2), "substring(...)");
            }
        } catch (Exception unused) {
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(ServicesPageSectionEntity.WALLET_SECTION_TITLE, 0);
        sharedPreferences.edit().putString("endpoint", endpoint).apply();
        sharedPreferences.edit().putString("originalToken", token).apply();
        RootActivity.Companion.i(RootActivity.INSTANCE, null, "action_set_payment_original_token_and_set_payment_end_point", AbstractC23348wm0.b(new XV4("arg_payment_original_token", token), new XV4("arg_payment_end_point", endpoint)), 1, null);
        C22055ub3.a.o("https://sadad.shaparak.ir/VPG/Purchase?Token=" + token, C5721Ko.a.d());
    }

    private final void v() {
        setBackgroundColor(C5495Jo7.a.o());
        this.binding.l.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.L18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletChargeBottomsheetContentView.w(this.a, view);
            }
        });
        this.binding.m.setTypeface(C6011Lu2.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(WalletChargeBottomsheetContentView walletChargeBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletChargeBottomsheetContentView, "this$0");
        C14486i0 c14486i0 = walletChargeBottomsheetContentView.bottomsheet;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    private final void x() {
        this.binding.p.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.H18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                WalletChargeBottomsheetContentView.y(this.a, view);
            }
        });
        this.binding.r.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.I18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                WalletChargeBottomsheetContentView.z(this.a, view);
            }
        });
        this.binding.o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.J18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                WalletChargeBottomsheetContentView.A(this.a, view);
            }
        });
        this.binding.q.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.K18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                WalletChargeBottomsheetContentView.B(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(WalletChargeBottomsheetContentView walletChargeBottomsheetContentView, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(walletChargeBottomsheetContentView, "this$0");
        BankiMoneyAmountView bankiMoneyAmountView = walletChargeBottomsheetContentView.binding.k;
        String string = walletChargeBottomsheetContentView.getContext().getResources().getString(AbstractC12217eE5.wallet_charge_amount_20000);
        AbstractC13042fc3.h(string, "getString(...)");
        bankiMoneyAmountView.setVariableAmount(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(WalletChargeBottomsheetContentView walletChargeBottomsheetContentView, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(walletChargeBottomsheetContentView, "this$0");
        BankiMoneyAmountView bankiMoneyAmountView = walletChargeBottomsheetContentView.binding.k;
        String string = walletChargeBottomsheetContentView.getContext().getResources().getString(AbstractC12217eE5.wallet_charge_amount_50000);
        AbstractC13042fc3.h(string, "getString(...)");
        bankiMoneyAmountView.setVariableAmount(string);
    }

    public final M18 getBinding() {
        return this.binding;
    }

    public final String getDefaultWalletId() {
        return this.defaultWalletId;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.bottomsheet = abol;
    }

    public final void setDefaultWalletId(String str) {
        this.defaultWalletId = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletChargeBottomsheetContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.TAG = WalletChargeBottomsheetContentView.class.getName();
        this.viewModel = new C20012rK0(C5735Kp4.w().i().Y());
        M18 m18C = M18.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(m18C, "inflate(...)");
        this.binding = m18C;
        s(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletChargeBottomsheetContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.TAG = WalletChargeBottomsheetContentView.class.getName();
        this.viewModel = new C20012rK0(C5735Kp4.w().i().Y());
        M18 m18C = M18.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(m18C, "inflate(...)");
        this.binding = m18C;
        s(context);
    }
}
