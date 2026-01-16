package ir.nasim;

import android.content.Context;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.graphics.Point;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;

/* renamed from: ir.nasim.Id6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5161Id6 {
    private static boolean e;
    private static int h;
    public static final C5161Id6 a = new C5161Id6();
    public static final float b = C5721Ko.a.d().getResources().getDisplayMetrics().density;
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Hd6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Integer.valueOf(C5161Id6.m());
        }
    });
    private static float d = 1.0f;
    private static DisplayMetrics f = new DisplayMetrics();
    private static Point g = new Point();
    public static final int i = 8;

    private C5161Id6() {
    }

    public static final void b(Context context, Configuration configuration) {
        Display defaultDisplay;
        AbstractC13042fc3.i(context, "context");
        d = context.getResources().getDisplayMetrics().density;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        e = (configuration == null || configuration.keyboard != 1) && configuration != null && configuration.hardKeyboardHidden == 1;
        Object systemService = context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(f);
            defaultDisplay.getSize(g);
        }
        if (configuration != null) {
            if (configuration.screenWidthDp != 0) {
                int iCeil = (int) Math.ceil(r4 * d);
                if (Math.abs(g.x - iCeil) > 3.0d) {
                    g.x = iCeil;
                }
            }
            if (configuration.screenHeightDp != 0) {
                int iCeil2 = (int) Math.ceil(r4 * d);
                if (Math.abs(g.y - iCeil2) > 3.0d) {
                    g.y = iCeil2;
                }
            }
        }
        if (h == 0) {
            if (k()) {
                h = (int) (a.g() * 0.6f);
            } else {
                Point point = g;
                h = (int) (Math.min(point.x, point.y) * 0.6f);
            }
        }
        Point point2 = g;
        int i2 = point2.x;
        int i3 = point2.y;
        DisplayMetrics displayMetrics = f;
        C19406qI3.b("Screen-utils", "display size = " + i2 + Separators.SP + i3 + Separators.SP + displayMetrics.xdpi + "x" + displayMetrics.ydpi);
    }

    public static final int d(float f2, Context context) {
        AbstractC13042fc3.i(context, "context");
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static final int e(float f2) {
        if (f2 == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(AbstractC3742Cd6.c() * f2);
    }

    public static final boolean k() {
        return C5721Ko.a.d().getResources().getConfiguration().smallestScreenWidthDp >= 600;
    }

    private final int l(int i2) {
        if (AbstractC3742Cd6.c() == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(i2 / AbstractC3742Cd6.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m() {
        return ViewConfiguration.get(C5721Ko.a.d()).getScaledTouchSlop();
    }

    public final void c() {
        try {
            Object systemService = C5721Ko.a.d().getSystemService("power");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            Log.e("baleMessages", "screen state = " + ((PowerManager) systemService).isScreenOn());
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "exception at checkIsScreenOn function ";
            }
            Log.e("baleMessages", message);
        }
    }

    public final int f(Context context, int i2) {
        AbstractC13042fc3.i(context, "context");
        try {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
                return l(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
            }
            return 0;
        } catch (Exception e2) {
            C19406qI3.b("Screen-utils", "getAttributeSizeInDp:" + e2.getMessage());
            return 0;
        }
    }

    public final int g() {
        if (!j()) {
            Point point = g;
            int iMin = (int) Math.min(point.x, point.y);
            int iE = (iMin * 35) / 100;
            if (iE < e(320.0f)) {
                iE = e(320.0f);
            }
            return iMin - iE;
        }
        Point point2 = g;
        int iMin2 = (int) Math.min(point2.x, point2.y);
        Point point3 = g;
        int iMax = (((int) Math.max(point3.x, point3.y)) * 35) / 100;
        if (iMax < e(320.0f)) {
            iMax = e(320.0f);
        }
        return (int) Math.min(iMin2, r2 - iMax);
    }

    public final int h() {
        return ((Number) c.getValue()).intValue();
    }

    public final boolean i() {
        try {
            Object systemService = C5721Ko.a.d().getSystemService("power");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            return ((PowerManager) systemService).isInteractive();
        } catch (Exception e2) {
            Log.d("Screen-utils", "Error in isScreenInteractive: " + e2 + ".message");
            return false;
        }
    }

    public final boolean j() {
        int i2 = C5721Ko.a.d().getResources().getConfiguration().smallestScreenWidthDp;
        return 600 <= i2 && i2 < 720;
    }
}
