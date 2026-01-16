package ir.nasim;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class E62 implements TextWatcher {
    private final EditText a;
    private final boolean b;
    private e.f c;
    private int d = Integer.MAX_VALUE;
    private int e = 0;
    private boolean f = true;

    private static class a extends e.f {
        private final Reference a;

        a(EditText editText) {
            this.a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            super.b();
            E62.b((EditText) this.a.get(), 1);
        }
    }

    E62(EditText editText, boolean z) {
        this.a = editText;
        this.b = z;
    }

    private e.f a() {
        if (this.c == null) {
            this.c = new a(this.a);
        }
        return this.c;
    }

    static void b(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.e.c().r(editableText);
            Z52.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return (this.f && (this.b || androidx.emoji2.text.e.k())) ? false : true;
    }

    public void c(boolean z) {
        if (this.f != z) {
            if (this.c != null) {
                androidx.emoji2.text.e.c().w(this.c);
            }
            this.f = z;
            if (z) {
                b(this.a, androidx.emoji2.text.e.c().g());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.a.isInEditMode() || d() || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iG = androidx.emoji2.text.e.c().g();
        if (iG != 0) {
            if (iG == 1) {
                androidx.emoji2.text.e.c().u((Spannable) charSequence, i, i + i3, this.d, this.e);
                return;
            } else if (iG != 3) {
                return;
            }
        }
        androidx.emoji2.text.e.c().v(a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
