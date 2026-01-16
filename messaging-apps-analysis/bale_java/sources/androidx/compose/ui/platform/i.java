package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewStructure;

/* loaded from: classes2.dex */
final class i {
    public static final i a = new i();

    private i() {
    }

    public final void a(ViewStructure viewStructure, View view) {
        viewStructure.setClassName(view.getAccessibilityClassName().toString());
    }
}
