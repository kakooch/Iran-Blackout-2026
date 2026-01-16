package ir.nasim;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* renamed from: ir.nasim.wp3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23381wp3 {
    public static final C23381wp3 a = new C23381wp3();

    private C23381wp3() {
    }

    private final void a(View view, View view2) {
        b(new C15581jp3(), view, view2);
    }

    private final void b(C15581jp3 c15581jp3, View view, View view2) {
        c15581jp3.c(view, false);
        view.clearFocus();
        if (view2 != null) {
            view2.requestFocus();
        }
    }

    public static final void c(Activity activity) {
        View currentFocus;
        if (activity == null || (currentFocus = activity.getCurrentFocus()) == null) {
            return;
        }
        a.a(currentFocus, null);
    }

    public static final void d(View view) {
        AbstractC13042fc3.i(view, "view");
        e(new C15581jp3(), view);
    }

    public static final void e(C15581jp3 c15581jp3, View view) {
        AbstractC13042fc3.i(c15581jp3, "keyboardUtils");
        AbstractC13042fc3.i(view, "view");
        view.requestFocus();
        c15581jp3.c(view, true);
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (editText.getText() != null) {
                editText.setSelection(editText.getText().length());
            }
        }
    }

    public static final void f(View view) {
        if (view == null) {
            return;
        }
        try {
            Object systemService = view.getContext().getSystemService("input_method");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            C19406qI3.d("keyboard-utils", e);
        }
    }

    public static final void g(View view) {
        if (view == null) {
            return;
        }
        try {
            Object systemService = view.getContext().getSystemService("input_method");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(view, 1);
        } catch (Exception e) {
            C19406qI3.d("keyboard-utils", e);
        }
    }
}
