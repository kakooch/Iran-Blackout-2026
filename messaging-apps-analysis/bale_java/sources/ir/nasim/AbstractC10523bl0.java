package ir.nasim;

import android.content.ComponentCallbacks2;
import android.content.Context;

/* renamed from: ir.nasim.bl0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10523bl0 {
    public static Object a(Context context) {
        ComponentCallbacks2 componentCallbacks2A = AbstractC19095pm1.a(context.getApplicationContext());
        AbstractC4497Fj5.a(componentCallbacks2A instanceof LE2, "Hilt BroadcastReceiver must be attached to an @HiltAndroidApp Application. Found: %s", componentCallbacks2A.getClass());
        return ((LE2) componentCallbacks2A).N2();
    }
}
