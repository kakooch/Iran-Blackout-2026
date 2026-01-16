package ir.nasim;

import android.view.View;

/* loaded from: classes2.dex */
final class RW7 {
    public static final RW7 a = new RW7();

    private RW7() {
    }

    public final void a(View view) {
        view.resetPivot();
    }

    public final void b(View view, int i) {
        view.setOutlineAmbientShadowColor(i);
    }

    public final void c(View view, int i) {
        view.setOutlineSpotShadowColor(i);
    }
}
