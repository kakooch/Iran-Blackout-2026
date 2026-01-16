package ir.nasim;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* renamed from: ir.nasim.iH0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC14659iH0 implements TextWatcher {
    public static final a b = new a(null);
    public static final int c = 8;
    private final EditText a;

    /* renamed from: ir.nasim.iH0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AbstractC14659iH0(EditText editText) {
        AbstractC13042fc3.i(editText, "editText");
        this.a = editText;
    }

    private final String a(char[] cArr) {
        StringBuilder sb = new StringBuilder();
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            char c2 = cArr[i];
            if (c2 != 0) {
                sb.append(c2);
                if (i > 0 && i < cArr.length - 1 && (i + 1) % 4 == 0) {
                    sb.append('\t');
                }
            }
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    private final char[] b(Editable editable) {
        char[] cArr = new char[16];
        int i = 0;
        for (int i2 = 0; i2 < editable.length() && i < 16; i2++) {
            char cCharAt = editable.charAt(i2);
            if (Character.isDigit(cCharAt)) {
                cArr[i] = cCharAt;
                i++;
            }
        }
        return cArr;
    }

    private final boolean c(Editable editable) {
        boolean zIsDigit = editable.length() <= 19;
        int length = editable.length();
        int i = 0;
        while (i < length) {
            zIsDigit &= (i <= 0 || (i + 1) % 5 != 0) ? Character.isDigit(editable.charAt(i)) : '\t' == editable.charAt(i);
            i++;
        }
        return zIsDigit;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        AbstractC13042fc3.i(editable, "s");
        if (!c(editable)) {
            this.a.removeTextChangedListener(this);
            editable.replace(0, editable.length(), XY6.e(a(b(editable))));
            this.a.addTextChangedListener(this);
        } else if (editable.length() > 0) {
            this.a.removeTextChangedListener(this);
            editable.replace(0, editable.length(), XY6.e(editable.toString()));
            this.a.addTextChangedListener(this);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AbstractC13042fc3.i(charSequence, "s");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AbstractC13042fc3.i(charSequence, "s");
    }
}
