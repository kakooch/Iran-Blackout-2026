package ir.nasim;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: ir.nasim.lX7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C16590lX7 implements InterfaceC17181mX7 {
    private final ViewOverlay a;

    C16590lX7(View view) {
        this.a = view.getOverlay();
    }

    @Override // ir.nasim.InterfaceC17181mX7
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // ir.nasim.InterfaceC17181mX7
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}
