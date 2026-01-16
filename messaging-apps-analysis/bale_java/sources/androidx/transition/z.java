package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes2.dex */
class z implements A {
    private final ViewOverlay a;

    z(View view) {
        this.a = view.getOverlay();
    }

    @Override // androidx.transition.A
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // androidx.transition.A
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}
