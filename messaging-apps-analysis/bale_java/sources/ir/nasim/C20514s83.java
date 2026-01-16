package ir.nasim;

import android.text.Editable;
import android.text.TextWatcher;
import ir.nasim.components.textfield.view.CustomInputView;

/* renamed from: ir.nasim.s83, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20514s83 implements TextWatcher {
    private InterfaceC12049dx1 a;
    private final String b;
    private final String c;

    public C20514s83(InterfaceC12049dx1 interfaceC12049dx1) {
        AbstractC13042fc3.i(interfaceC12049dx1, "customInput");
        this.a = interfaceC12049dx1;
        this.b = interfaceC12049dx1.getHint();
        this.c = this.a.getInputHint();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) throws NumberFormatException {
        AbstractC13042fc3.i(editable, "s");
        if (editable.toString().length() > 0) {
            this.a.a(this);
            if ((editable.length() == 1 && editable.toString().charAt(0) == '0') || editable.toString().charAt(0) == 1776) {
                editable.replace(0, editable.length(), "");
                this.a.b(this);
                this.a.setText(null);
                return;
            } else {
                editable.replace(0, editable.length(), XY6.e(GY6.g(XY6.h(AbstractC20153rZ6.M(editable.toString(), ",", "", false, 4, null)))));
                this.a.b(this);
            }
        }
        if (editable.length() <= 0) {
            this.a.setPostfix(null);
            this.a.setHint(this.b);
            this.a.setInputHint(this.c);
            return;
        }
        InterfaceC12049dx1 interfaceC12049dx1 = this.a;
        AbstractC13042fc3.g(interfaceC12049dx1, "null cannot be cast to non-null type ir.nasim.components.textfield.view.CustomInputView");
        interfaceC12049dx1.setPostfix(((CustomInputView) interfaceC12049dx1).getContext().getString(AbstractC12217eE5.card_payment_rial));
        this.a.setInputHint(null);
        long j = Long.parseLong(AbstractC20153rZ6.M(editable.toString(), ",", "", false, 4, null));
        long j2 = j / 10;
        if (j2 > 0) {
            String strA = AbstractC24223yF4.a(j2, true);
            InterfaceC12049dx1 interfaceC12049dx12 = this.a;
            AbstractC13042fc3.g(interfaceC12049dx12, "null cannot be cast to non-null type ir.nasim.components.textfield.view.CustomInputView");
            interfaceC12049dx12.setHint(((CustomInputView) interfaceC12049dx12).getContext().getString(AbstractC12217eE5.card_payment_persian_text_amount, strA));
            return;
        }
        if (j <= 0) {
            this.a.setText(null);
            return;
        }
        InterfaceC12049dx1 interfaceC12049dx13 = this.a;
        AbstractC13042fc3.g(interfaceC12049dx13, "null cannot be cast to non-null type ir.nasim.components.textfield.view.CustomInputView");
        interfaceC12049dx13.setHint(((CustomInputView) interfaceC12049dx13).getContext().getString(AbstractC12217eE5.card_payment_money_amount_rial));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AbstractC13042fc3.i(charSequence, "p0");
        this.a.c();
        this.a.setErrorStroke(false);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
