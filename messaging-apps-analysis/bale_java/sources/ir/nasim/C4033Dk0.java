package ir.nasim;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;

/* renamed from: ir.nasim.Dk0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C4033Dk0 implements InterfaceC3799Ck0 {
    public static final C4033Dk0 b = new C4033Dk0();

    private C4033Dk0() {
    }

    @Override // ir.nasim.InterfaceC3799Ck0
    public Rect a(Activity activity) {
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!activity.isInMultiWindowMode()) {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int iG = AbstractC13816gs.g(activity);
            int i = rect.bottom;
            if (i + iG == point.y) {
                rect.bottom = i + iG;
            } else {
                int i2 = rect.right;
                if (i2 + iG == point.x) {
                    rect.right = i2 + iG;
                }
            }
        }
        return rect;
    }
}
