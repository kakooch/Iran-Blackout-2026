package androidx.transition;

import android.os.Build;
import android.view.View;

/* loaded from: classes2.dex */
class F extends E {
    private static boolean h = true;

    F() {
    }

    @Override // androidx.transition.H
    public void g(View view, int i) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i);
        } else if (h) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
    }
}
