package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: ir.nasim.g93, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C13396g93 implements TextWatcher {
    private InterfaceC12049dx1 a;
    private final String b;
    private final String c;

    public C13396g93(InterfaceC12049dx1 interfaceC12049dx1) {
        AbstractC13042fc3.i(interfaceC12049dx1, "bankingCustomInput");
        this.a = interfaceC12049dx1;
        this.b = Separators.SP;
        this.c = "";
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable == null || AbstractC20762sZ6.n0(editable)) {
            this.a.a(this);
            this.a.setText(null);
            this.a.b(this);
            return;
        }
        int i = 4;
        if (ZY6.a(editable.toString()).length() > 4) {
            this.a.a(this);
            StringBuilder sb = new StringBuilder(ZY6.a(new C20644sM5(this.b).k(editable, this.c)));
            do {
                sb.insert(i, this.b);
                i += 5;
            } while (i < sb.length());
            editable.replace(0, editable.length(), sb.toString());
            this.a.b(this);
        }
        this.a.a(this);
        editable.replace(0, editable.length(), XY6.e(editable.toString()));
        this.a.b(this);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
