package ir.nasim;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: ir.nasim.jp3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C15581jp3 {
    private Runnable a;

    public void c(final View view, boolean z) {
        final InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            view.removeCallbacks(runnable);
        }
        if (!z) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: ir.nasim.ip3
            @Override // java.lang.Runnable
            public final void run() {
                inputMethodManager.showSoftInput(view, 0);
            }
        };
        this.a = runnable2;
        view.postDelayed(runnable2, 100L);
    }
}
