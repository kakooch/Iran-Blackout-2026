package ir.eitaa.ui.Components;

import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;

/* loaded from: classes3.dex */
public final class ViewHelper {
    public static void setPadding(View view, float left, float top, float right, float bottom) {
        view.setPadding(AndroidUtilities.dp(left), AndroidUtilities.dp(top), AndroidUtilities.dp(right), AndroidUtilities.dp(bottom));
    }

    public static void setPaddingRelative(View view, float start, float top, float end, float bottom) {
        boolean z = LocaleController.isRTL;
        float f = z ? end : start;
        if (!z) {
            start = end;
        }
        setPadding(view, f, top, start, bottom);
    }
}
