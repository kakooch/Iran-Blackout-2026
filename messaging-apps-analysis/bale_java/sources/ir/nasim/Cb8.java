package ir.nasim;

import android.view.ViewParent;
import androidx.compose.ui.platform.AndroidComposeView;

/* loaded from: classes2.dex */
public final class Cb8 {
    public static final Cb8 a = new Cb8();

    private Cb8() {
    }

    public final void a(AndroidComposeView androidComposeView) {
        ViewParent parent = androidComposeView.getParent();
        if (parent != null) {
            parent.onDescendantInvalidated(androidComposeView, androidComposeView);
        }
    }
}
