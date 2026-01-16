package ir.nasim;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* renamed from: ir.nasim.kp3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC16172kp3 {
    public static final void a(View view) {
        AbstractC13042fc3.i(view, "<this>");
        if (Build.VERSION.SDK_INT < 30) {
            Object systemService = view.getContext().getSystemService("input_method");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        } else {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.hide(WindowInsets.Type.ime());
            }
        }
    }

    public static final void b(View view, boolean z) {
        AbstractC13042fc3.i(view, "<this>");
        if (z) {
            view.requestFocus();
        }
        if (Build.VERSION.SDK_INT < 30) {
            Object systemService = view.getContext().getSystemService("input_method");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(view, 0);
        } else {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
        }
    }

    public static /* synthetic */ void c(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        b(view, z);
    }
}
