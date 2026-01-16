package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import ir.nasim.InterfaceC6379Ni5;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e implements InterfaceC6379Ni5 {
    @Override // ir.nasim.InterfaceC6379Ni5
    public void a(View view, Rect rect) {
        view.getWindowVisibleDisplayFrame(rect);
    }

    @Override // ir.nasim.InterfaceC6379Ni5
    public void b(WindowManager windowManager, View view, ViewGroup.LayoutParams layoutParams) {
        windowManager.updateViewLayout(view, layoutParams);
    }

    @Override // ir.nasim.InterfaceC6379Ni5
    public void c(View view, int i, int i2) {
    }
}
