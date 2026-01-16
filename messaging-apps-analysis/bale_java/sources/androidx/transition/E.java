package androidx.transition;

import android.view.View;

/* loaded from: classes2.dex */
abstract class E extends D {
    private static boolean g = true;

    E() {
    }

    @Override // androidx.transition.H
    public void e(View view, int i, int i2, int i3, int i4) {
        if (g) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
