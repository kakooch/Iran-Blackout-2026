package ir.nasim;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* loaded from: classes2.dex */
final class Y52 extends InputConnectionWrapper {
    private final TextView a;
    private final a b;

    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
            return androidx.emoji2.text.e.h(inputConnection, editable, i, i2, z);
        }

        public void b(EditorInfo editorInfo) {
            if (androidx.emoji2.text.e.k()) {
                androidx.emoji2.text.e.c().x(editorInfo);
            }
        }
    }

    Y52(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    private Editable b() {
        return this.a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        return this.b.a(this, b(), i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return this.b.a(this, b(), i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }

    Y52(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.a = textView;
        this.b = aVar;
        aVar.b(editorInfo);
    }
}
