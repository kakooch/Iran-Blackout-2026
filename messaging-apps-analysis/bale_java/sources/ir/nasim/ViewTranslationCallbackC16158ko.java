package ir.nasim;

import android.view.View;
import android.view.translation.ViewTranslationCallback;
import androidx.compose.ui.platform.AndroidComposeView;

/* renamed from: ir.nasim.ko, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class ViewTranslationCallbackC16158ko implements ViewTranslationCallback {
    public static final ViewTranslationCallbackC16158ko a = new ViewTranslationCallbackC16158ko();

    private ViewTranslationCallbackC16158ko() {
    }

    public boolean onClearTranslation(View view) {
        AbstractC13042fc3.g(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        ((AndroidComposeView) view).getContentCaptureManager().u();
        return true;
    }

    public boolean onHideTranslation(View view) {
        AbstractC13042fc3.g(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        ((AndroidComposeView) view).getContentCaptureManager().w();
        return true;
    }

    public boolean onShowTranslation(View view) {
        AbstractC13042fc3.g(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        ((AndroidComposeView) view).getContentCaptureManager().A();
        return true;
    }
}
