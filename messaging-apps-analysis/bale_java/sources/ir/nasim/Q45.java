package ir.nasim;

import android.text.Editable;
import android.text.TextWatcher;

/* loaded from: classes6.dex */
public final class Q45 implements TextWatcher {
    private InterfaceC12049dx1 a;

    public Q45(InterfaceC12049dx1 interfaceC12049dx1) {
        AbstractC13042fc3.i(interfaceC12049dx1, "bankingCustomInput");
        this.a = interfaceC12049dx1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        AbstractC13042fc3.i(editable, "s");
        if (editable.length() > 0) {
            this.a.a(this);
            editable.replace(0, editable.length(), XY6.e(editable.toString()));
            this.a.b(this);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
