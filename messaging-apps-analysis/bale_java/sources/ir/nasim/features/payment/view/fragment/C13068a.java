package ir.nasim.features.payment.view.fragment;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.gov.nist.core.Separators;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C10748c8;
import ir.nasim.C13396g93;
import ir.nasim.C15659jx2;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC21074t40;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.KB5;
import ir.nasim.QG4;
import ir.nasim.UA2;
import ir.nasim.XY6;
import ir.nasim.Z7;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import ir.nasim.features.payment.view.fragment.C13068a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 92\u00020\u0001:\u0001:B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J-\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J!\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lir/nasim/features/payment/view/fragment/a;", "Landroidx/fragment/app/l;", "<init>", "()V", "", "mTitle", "mInputHint", "Lir/nasim/rB7;", "T8", "(Ljava/lang/String;Ljava/lang/String;)V", "pattern", "Lir/nasim/features/payment/data/response/Bank;", "R8", "(Ljava/lang/String;)Lir/nasim/features/payment/data/response/Bank;", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "j7", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/jx2;", "m1", "Lir/nasim/jx2;", "_binding", "", "n1", "Ljava/lang/Integer;", "type", "Lir/nasim/Z7;", "o1", "Lir/nasim/Z7;", "viewModel", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "p1", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "config", "Lir/nasim/t40;", "q1", "Lir/nasim/t40;", "getBankCardChangeListener", "()Lir/nasim/t40;", "X8", "(Lir/nasim/t40;)V", "bankCardChangeListener", "S8", "()Lir/nasim/jx2;", "binding", "r1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.a, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13068a extends androidx.fragment.app.l {

    /* renamed from: r1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int s1 = 8;

    /* renamed from: m1, reason: from kotlin metadata */
    private C15659jx2 _binding;

    /* renamed from: n1, reason: from kotlin metadata */
    private Integer type;

    /* renamed from: o1, reason: from kotlin metadata */
    private Z7 viewModel;

    /* renamed from: p1, reason: from kotlin metadata */
    private CardToCardConfig config;

    /* renamed from: q1, reason: from kotlin metadata */
    private InterfaceC21074t40 bankCardChangeListener;

    /* renamed from: ir.nasim.features.payment.view.fragment.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C13068a a(int i) {
            C13068a c13068a = new C13068a();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            c13068a.a8(bundle);
            return c13068a;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.a$b */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                if (ZY6.a(editable.toString()).length() < 6) {
                    C13068a.this.S8().b.setEnabled(false);
                    C13068a.this.S8().d.setMaxLength(-1);
                    C13068a.this.S8().d.setErrorStroke(false);
                    C13068a.this.S8().d.setDrawableStart(AbstractC4043Dl1.f(C13068a.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                    C13068a.this.S8().d.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
                    return;
                }
                if (ZY6.a(editable.toString()).length() >= 6) {
                    C13068a c13068a = C13068a.this;
                    String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    Bank bankR8 = c13068a.R8(strSubstring);
                    if (bankR8 == null) {
                        C13068a.this.S8().d.setMaxLength(7);
                        CustomInputView customInputView = C13068a.this.S8().d;
                        String strH6 = C13068a.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        customInputView.setInputError(strH6);
                        return;
                    }
                    if (editable.length() == 19) {
                        C13068a.this.S8().d.setMaxLength(19);
                        C13068a.this.S8().b.setEnabled(true);
                    } else {
                        C13068a.this.S8().b.setEnabled(false);
                    }
                    Drawable drawableF = null;
                    C13068a.this.S8().d.setDrawableStartTint(null);
                    CustomInputView customInputView2 = C13068a.this.S8().d;
                    Integer drawableId = bankR8.getDrawableId();
                    if (drawableId != null) {
                        C13068a c13068a2 = C13068a.this;
                        drawableF = AbstractC4043Dl1.f(c13068a2.S7(), drawableId.intValue());
                    }
                    customInputView2.setDrawableStart(drawableF);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.a$c */
    static final class c implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        c(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bank R8(String pattern) {
        Bank bank = null;
        try {
            CardToCardConfig cardToCardConfig = this.config;
            if (cardToCardConfig == null) {
                AbstractC13042fc3.y("config");
                cardToCardConfig = null;
            }
            for (Bank bank2 : cardToCardConfig.getBankList()) {
                if (bank2.getCardNumberPattern().contains(XY6.h(pattern))) {
                    bank = bank2;
                }
            }
        } catch (Exception e) {
            AbstractC16494lN1.a(this);
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
        return bank;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C15659jx2 S8() {
        C15659jx2 c15659jx2 = this._binding;
        AbstractC13042fc3.f(c15659jx2);
        return c15659jx2;
    }

    private final void T8(String mTitle, String mInputHint) {
        S8().e.setText(mTitle);
        S8().d.setHint(mInputHint);
        S8().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.S7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13068a.U8(this.a, view);
            }
        });
        S8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.T7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13068a.V8(this.a, view);
            }
        });
        CustomInputView customInputView = S8().d;
        CustomInputView customInputView2 = S8().d;
        AbstractC13042fc3.h(customInputView2, "cardNumber");
        customInputView.b(new C13396g93(customInputView2));
        S8().d.b(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U8(C13068a c13068a, View view) {
        AbstractC13042fc3.i(c13068a, "this$0");
        AbstractC16494lN1.a(c13068a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V8(C13068a c13068a, View view) {
        AbstractC13042fc3.i(c13068a, "this$0");
        if (c13068a.S8().d.getText().length() == 19) {
            Z7 z7 = c13068a.viewModel;
            if (z7 == null) {
                AbstractC13042fc3.y("viewModel");
                z7 = null;
            }
            z7.e0(AbstractC20153rZ6.M(c13068a.S8().d.getText().toString(), Separators.SP, "", false, 4, null));
            InterfaceC21074t40 interfaceC21074t40 = c13068a.bankCardChangeListener;
            if (interfaceC21074t40 != null) {
                interfaceC21074t40.m3(AbstractC20153rZ6.M(c13068a.S8().d.getText().toString(), Separators.SP, "", false, 4, null));
            }
            InterfaceC21074t40 interfaceC21074t402 = c13068a.bankCardChangeListener;
            if (interfaceC21074t402 != null) {
                interfaceC21074t402.Q();
            }
            AbstractC16494lN1.a(c13068a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W8(C13068a c13068a, CardToCardConfig cardToCardConfig) {
        AbstractC13042fc3.i(c13068a, "this$0");
        c13068a.config = cardToCardConfig;
        return C19938rB7.a;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.type = Integer.valueOf(bundleE5.getInt("type"));
        }
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        this.viewModel = (Z7) new androidx.lifecycle.G(fragmentActivityQ7).b(C10748c8.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C15659jx2.c(inflater, container, false);
        return S8().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    public final void X8(InterfaceC21074t40 interfaceC21074t40) {
        this.bankCardChangeListener = interfaceC21074t40;
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
        Z7 z7 = this.viewModel;
        if (z7 == null) {
            AbstractC13042fc3.y("viewModel");
            z7 = null;
        }
        z7.getConfig().j(p6(), new c(new UA2() { // from class: ir.nasim.R7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13068a.W8(this.a, (CardToCardConfig) obj);
            }
        }));
        Integer num = this.type;
        if (num != null && num.intValue() == 0) {
            String strH6 = h6(AbstractC12217eE5.card_payment_add_new_source_card);
            AbstractC13042fc3.h(strH6, "getString(...)");
            String strH62 = h6(AbstractC12217eE5.card_payment_source_card);
            AbstractC13042fc3.h(strH62, "getString(...)");
            T8(strH6, strH62);
        } else if (num != null && num.intValue() == 1) {
            String strH63 = h6(AbstractC12217eE5.card_payment_add_new_destination_card);
            AbstractC13042fc3.h(strH63, "getString(...)");
            String strH64 = h6(AbstractC12217eE5.card_payment_destination_card);
            AbstractC13042fc3.h(strH64, "getString(...)");
            T8(strH63, strH64);
        }
        S8().e.setTypeface(C6011Lu2.i());
        S8().b.setTypeface(C6011Lu2.i());
        S8().c.setTypeface(C6011Lu2.i());
    }
}
