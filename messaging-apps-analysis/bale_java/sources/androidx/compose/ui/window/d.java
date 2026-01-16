package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import ir.nasim.AbstractC10360bX0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d extends e {
    @Override // androidx.compose.ui.window.e, ir.nasim.InterfaceC6379Ni5
    public void c(View view, int i, int i2) {
        view.setSystemGestureExclusionRects(AbstractC10360bX0.s(new Rect(0, 0, i, i2)));
    }
}
