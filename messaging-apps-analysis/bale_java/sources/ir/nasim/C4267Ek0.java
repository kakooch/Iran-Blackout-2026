package ir.nasim;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ir.nasim.Ek0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C4267Ek0 implements InterfaceC3799Ck0 {
    public static final C4267Ek0 b = new C4267Ek0();

    private C4267Ek0() {
    }

    @Override // ir.nasim.InterfaceC3799Ck0
    public Rect a(Activity activity) throws Exception {
        DisplayCutout displayCutoutF;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (activity.isInMultiWindowMode()) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                AbstractC13042fc3.g(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                AbstractC13042fc3.g(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke2);
            }
        } catch (Exception e) {
            if (!(e instanceof NoSuchFieldException ? true : e instanceof NoSuchMethodException ? true : e instanceof IllegalAccessException ? true : e instanceof InvocationTargetException)) {
                throw e;
            }
            AbstractC13816gs.h(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (!activity.isInMultiWindowMode()) {
            int iG = AbstractC13816gs.g(activity);
            int i = rect.bottom;
            if (i + iG == point.y) {
                rect.bottom = i + iG;
            } else {
                int i2 = rect.right;
                if (i2 + iG == point.x) {
                    rect.right = i2 + iG;
                } else if (rect.left == iG) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activity.isInMultiWindowMode() && (displayCutoutF = AbstractC13816gs.f(defaultDisplay)) != null) {
            if (rect.left == displayCutoutF.getSafeInsetLeft()) {
                rect.left = 0;
            }
            if (point.x - rect.right == displayCutoutF.getSafeInsetRight()) {
                rect.right += displayCutoutF.getSafeInsetRight();
            }
            if (rect.top == displayCutoutF.getSafeInsetTop()) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == displayCutoutF.getSafeInsetBottom()) {
                rect.bottom += displayCutoutF.getSafeInsetBottom();
            }
        }
        return rect;
    }
}
