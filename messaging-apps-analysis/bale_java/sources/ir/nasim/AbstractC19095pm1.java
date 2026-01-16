package ir.nasim;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

/* renamed from: ir.nasim.pm1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC19095pm1 {
    public static Application a(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        Context baseContext = context;
        while (baseContext instanceof ContextWrapper) {
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
            if (baseContext instanceof Application) {
                return (Application) baseContext;
            }
        }
        throw new IllegalStateException("Could not find an Application in the given context: " + context);
    }
}
