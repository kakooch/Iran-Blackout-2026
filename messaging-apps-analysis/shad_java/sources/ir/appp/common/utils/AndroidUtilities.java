package ir.appp.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes3.dex */
public class AndroidUtilities {
    public static int getScreenHeight(Context context) throws NoSuchMethodException, SecurityException {
        Point realScreenSize = getRealScreenSize(context);
        return Math.max(realScreenSize.x, realScreenSize.y);
    }

    public static Point getRealScreenSize(Context context) throws NoSuchMethodException, SecurityException {
        Point point = new Point();
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealSize(point);
            } else {
                try {
                    point.set(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(windowManager.getDefaultDisplay(), new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(windowManager.getDefaultDisplay(), new Object[0])).intValue());
                } catch (Exception e) {
                    point.set(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
                    FileLog.e(e);
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        return point;
    }

    public static int dp(float f) {
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        if (f == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(f2 * f);
    }
}
