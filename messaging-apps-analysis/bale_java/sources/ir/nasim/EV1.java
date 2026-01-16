package ir.nasim;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes8.dex */
public abstract class EV1 {
    public static int a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
            return 3;
        }
        return defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 2;
    }
}
