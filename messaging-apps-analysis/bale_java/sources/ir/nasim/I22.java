package ir.nasim;

import android.content.ComponentCallbacks2;
import android.content.Context;

/* loaded from: classes3.dex */
public abstract class I22 {
    public static Object a(Context context, Class cls) {
        ComponentCallbacks2 componentCallbacks2A = AbstractC19095pm1.a(context);
        AbstractC4497Fj5.d(componentCallbacks2A instanceof ME2, "Expected application to implement GeneratedComponentManagerHolder. Check that you're passing in an application context that uses Hilt. Application class found: %s", componentCallbacks2A.getClass());
        ((ME2) componentCallbacks2A).E4();
        return D92.a(componentCallbacks2A, cls);
    }
}
