package ir.nasim;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.widget.EditText;

/* loaded from: classes5.dex */
public final class F62 implements TextWatcher {
    private final EditText a;
    private boolean b;
    private int c;
    private boolean d;

    public F62(EditText editText) {
        AbstractC13042fc3.i(editText, "messageEditText");
        this.a = editText;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        AbstractC13042fc3.i(editable, "editable");
        if (this.c == 0 && this.b) {
            for (ImageSpan imageSpan : (ImageSpan[]) editable.getSpans(0, editable.length(), ImageSpan.class)) {
                editable.removeSpan(imageSpan);
            }
            R62.W(editable, this.a.getPaint().getFontMetricsInt(), AbstractC7426Rr.a.f(20.0f), false, null, null, 48, null);
            this.b = false;
        }
    }

    public final void b(int i) {
        this.c = i;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AbstractC13042fc3.i(charSequence, "charSequence");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AbstractC13042fc3.i(charSequence, "charSequence");
        int i4 = this.c;
        if (i4 == 1 || i4 == 2) {
            return;
        }
        if (this.d || (i2 != i3 && i3 - i2 > 1)) {
            this.b = true;
            this.d = false;
        }
    }
}
