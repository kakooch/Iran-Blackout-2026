package ir.nasim;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* loaded from: classes2.dex */
public final class W52 {
    private final b a;
    private int b = Integer.MAX_VALUE;
    private int c = 0;

    private static class a extends b {
        private final EditText a;
        private final E62 b;

        a(EditText editText, boolean z) {
            this.a = editText;
            E62 e62 = new E62(editText, z);
            this.b = e62;
            editText.addTextChangedListener(e62);
            editText.setEditableFactory(X52.getInstance());
        }

        @Override // ir.nasim.W52.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof C9521a62) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new C9521a62(keyListener);
        }

        @Override // ir.nasim.W52.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof Y52 ? inputConnection : new Y52(this.a, inputConnection, editorInfo);
        }

        @Override // ir.nasim.W52.b
        void c(boolean z) {
            this.b.c(z);
        }
    }

    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void c(boolean z);
    }

    public W52(EditText editText, boolean z) {
        AbstractC4980Hj5.h(editText, "editText cannot be null");
        this.a = new a(editText, z);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.a.b(inputConnection, editorInfo);
    }

    public void c(boolean z) {
        this.a.c(z);
    }
}
