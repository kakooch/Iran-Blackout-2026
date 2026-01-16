package ir.nasim;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* renamed from: ir.nasim.fY2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C13003fY2 implements TextWatcher {
    private EditText a;

    public C13003fY2(EditText editText) {
        this.a = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.length() > 0) {
            this.a.removeTextChangedListener(this);
            editable.replace(0, editable.length(), XY6.e(editable.toString()));
            this.a.addTextChangedListener(this);
            this.a.setSelection(editable.length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
