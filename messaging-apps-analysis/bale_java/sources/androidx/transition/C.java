package androidx.transition;

import android.view.View;

/* loaded from: classes2.dex */
abstract class C extends H {
    private static boolean c = true;

    C() {
    }

    @Override // androidx.transition.H
    public void a(View view) {
    }

    @Override // androidx.transition.H
    public float b(View view) {
        if (c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // androidx.transition.H
    public void c(View view) {
    }

    @Override // androidx.transition.H
    public void f(View view, float f) {
        if (c) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                c = false;
            }
        }
        view.setAlpha(f);
    }
}
