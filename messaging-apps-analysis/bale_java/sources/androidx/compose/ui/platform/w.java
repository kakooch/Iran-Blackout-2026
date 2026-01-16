package androidx.compose.ui.platform;

import android.view.View;

/* loaded from: classes2.dex */
final class w {
    public static final w a = new w();

    private w() {
    }

    public final void a(View view, int i) {
        view.setOutlineAmbientShadowColor(i);
    }

    public final void b(View view, int i) {
        view.setOutlineSpotShadowColor(i);
    }
}
