package ir.nasim;

import android.app.Activity;
import android.graphics.Rect;
import android.view.WindowManager;

/* renamed from: ir.nasim.Gk0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C4750Gk0 implements InterfaceC3799Ck0 {
    public static final C4750Gk0 b = new C4750Gk0();

    private C4750Gk0() {
    }

    @Override // ir.nasim.InterfaceC3799Ck0
    public Rect a(Activity activity) {
        return ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
    }
}
