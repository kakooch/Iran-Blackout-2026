package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.compose.ui.platform.AndroidComposeView;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.gs, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13816gs {
    public static final long d(AndroidComposeView androidComposeView) {
        Context context = androidComposeView.getContext();
        Activity activityE = e(context);
        if (activityE != null) {
            Rect rectA = InterfaceC3799Ck0.a.a().a(activityE);
            return C4414Fa3.c((rectA.height() & 4294967295L) | (rectA.width() << 32));
        }
        Configuration configuration = context.getResources().getConfiguration();
        return C4414Fa3.c((Math.round(configuration.screenHeightDp * r7) & 4294967295L) | (Math.round(configuration.screenWidthDp * context.getResources().getDisplayMetrics().density) << 32));
    }

    private static final Activity e(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisplayCutout f(Display display) throws Exception {
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
        } catch (Exception e) {
            if (e instanceof ClassNotFoundException ? true : e instanceof NoSuchMethodException ? true : e instanceof NoSuchFieldException ? true : e instanceof IllegalAccessException ? true : e instanceof InvocationTargetException ? true : e instanceof InstantiationException) {
                return null;
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", ConstantDeviceInfo.APP_PLATFORM);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }
}
