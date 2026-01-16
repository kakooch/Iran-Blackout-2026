package androidx.compose.ui.window;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import ir.nasim.SA2;

/* loaded from: classes2.dex */
final class b {
    public static final b a = new b();

    private b() {
    }

    public static final OnBackInvokedCallback b(final SA2 sa2) {
        return new OnBackInvokedCallback() { // from class: androidx.compose.ui.window.a
            public final void onBackInvoked() {
                b.c(sa2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SA2 sa2) {
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public static final void d(View view, Object obj) {
        OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        if (!(obj instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
            return;
        }
        onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj);
    }

    public static final void e(View view, Object obj) {
        OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        if (!(obj instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
            return;
        }
        onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj);
    }
}
