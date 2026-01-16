package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class Ca8 implements Ba8 {
    public static final Ca8 a = new Ca8();
    private static final String b;

    static {
        String simpleName = Ca8.class.getSimpleName();
        AbstractC13042fc3.h(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        b = simpleName;
    }

    private Ca8() {
    }

    private final DisplayCutout e(Display display) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (AbstractC12589es.a(obj)) {
                return AbstractC13225fs.a(obj);
            }
            return null;
        } catch (ClassNotFoundException e) {
            Log.w(b, e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.w(b, e2);
            return null;
        } catch (InstantiationException e3) {
            Log.w(b, e3);
            return null;
        } catch (NoSuchFieldException e4) {
            Log.w(b, e4);
            return null;
        } catch (NoSuchMethodException e5) {
            Log.w(b, e5);
            return null;
        } catch (InvocationTargetException e6) {
            Log.w(b, e6);
            return null;
        }
    }

    private final int f(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", ConstantDeviceInfo.APP_PLATFORM);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void h(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    public Aa8 a(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        int i = Build.VERSION.SDK_INT;
        return new Aa8(i >= 30 ? C10728c6.a.a(activity) : i >= 29 ? d(activity) : i >= 28 ? c(activity) : b(activity));
    }

    public final Rect b(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!Z5.a.a(activity)) {
            AbstractC13042fc3.h(defaultDisplay, "defaultDisplay");
            Point pointG = g(defaultDisplay);
            int iF = f(activity);
            int i = rect.bottom;
            if (i + iF == pointG.y) {
                rect.bottom = i + iF;
            } else {
                int i2 = rect.right;
                if (i2 + iF == pointG.x) {
                    rect.right = i2 + iF;
                }
            }
        }
        return rect;
    }

    public final Rect c(Activity activity) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        DisplayCutout displayCutoutE;
        AbstractC13042fc3.i(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (Z5.a.a(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                if (objInvoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException e) {
            Log.w(b, e);
            h(activity, rect);
        } catch (NoSuchFieldException e2) {
            Log.w(b, e2);
            h(activity, rect);
        } catch (NoSuchMethodException e3) {
            Log.w(b, e3);
            h(activity, rect);
        } catch (InvocationTargetException e4) {
            Log.w(b, e4);
            h(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        C15975kV1 c15975kV1 = C15975kV1.a;
        AbstractC13042fc3.h(defaultDisplay, "currentDisplay");
        c15975kV1.a(defaultDisplay, point);
        Z5 z5 = Z5.a;
        if (!z5.a(activity)) {
            int iF = f(activity);
            int i = rect.bottom;
            if (i + iF == point.y) {
                rect.bottom = i + iF;
            } else {
                int i2 = rect.right;
                if (i2 + iF == point.x) {
                    rect.right = i2 + iF;
                } else if (rect.left == iF) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !z5.a(activity) && (displayCutoutE = e(defaultDisplay)) != null) {
            int i3 = rect.left;
            C18930pV1 c18930pV1 = C18930pV1.a;
            if (i3 == c18930pV1.b(displayCutoutE)) {
                rect.left = 0;
            }
            if (point.x - rect.right == c18930pV1.c(displayCutoutE)) {
                rect.right += c18930pV1.c(displayCutoutE);
            }
            if (rect.top == c18930pV1.d(displayCutoutE)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == c18930pV1.a(displayCutoutE)) {
                rect.bottom += c18930pV1.a(displayCutoutE);
            }
        }
        return rect;
    }

    public final Rect d(Activity activity) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            if (objInvoke != null) {
                return new Rect((Rect) objInvoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (IllegalAccessException e) {
            Log.w(b, e);
            return c(activity);
        } catch (NoSuchFieldException e2) {
            Log.w(b, e2);
            return c(activity);
        } catch (NoSuchMethodException e3) {
            Log.w(b, e3);
            return c(activity);
        } catch (InvocationTargetException e4) {
            Log.w(b, e4);
            return c(activity);
        }
    }

    public final Point g(Display display) {
        AbstractC13042fc3.i(display, "display");
        Point point = new Point();
        C15975kV1.a.a(display, point);
        return point;
    }
}
