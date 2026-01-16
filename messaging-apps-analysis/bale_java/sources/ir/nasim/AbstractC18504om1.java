package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* renamed from: ir.nasim.om1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC18504om1 {
    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
